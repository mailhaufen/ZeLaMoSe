/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.interfaces.SimulationStateInterface;
import domain.interfaces.StepProducerInterface;
import java.util.Observable;
import java.util.Observer;
import java.util.TimerTask;
import java.util.Timer;
import network.client.NetworkHandler;
import network.SessionInformation;

/**
 *
 * Wrap signals in Runnable, for synchronization to GUI thread.
 * notifyObservers will be called from the simulation thread (timer)
 * 
 * 
 * @author chrigi
 */
public class TetrisController extends Observable implements Observer {
    private Timer timer;
      public enum UpdateType {

      STEP, SESSION_ADDED, SESSION_REMOVED, CONNECTION_ESTABLISHED, EXCEPTION_THROWN
   ,  CHAT_MESSAGE_RECEIVED, GAME_STARTED};

    private SimulationController simulationController;
    private NetworkHandler networkHandler;
    private StepGenerator stepGenerator;
    
    private int currentStep = 0;
    private final int stepDuration = 50; //in millisecond
    private int localSessionID = -1;
    
    public TetrisController(SimulationController sController, NetworkHandler nH, StepGenerator sG) {
        simulationController = sController;
        networkHandler = nH;
        networkHandler.addObserver(this);
        stepGenerator = sG;
        stepGenerator.addObserver(this);
    }
    
//    public Map<Integer, String> getAvailableSessions() {
//        
//    }
    
    public SimulationStateInterface getSession(int sessionId) {
        return simulationController.getSimulation(sessionId);
    }
    
    public void startServer() {
        //TODO create server and connectToServer
    }
    
    public void connectToServer(String ip, int port) {
        //TODO connect networkhandler to server
        networkHandler.connectToServer(ip, "servername", "nickname");
    }
    
    public void startGame() {
        //networkHandler.startGame();
    }

    @Override
    public void update(Observable o, Object o1) {
        System.out.println("update");
        if (o1 == UpdateType.STEP) {
            System.out.println("adding step: ");
            StepProducerInterface producer = (StepProducerInterface)o;
            Step step = producer.getStep();
            simulationController.addStep(step);
            assert(localSessionID >= 0);
            if (step.getSessionID() == localSessionID) {
                networkHandler.addStep(step);
            }
        }
        if (o1 == UpdateType.GAME_STARTED) {
            System.out.println("starting game");
            simulationController.initSimulation();
            run();
        }
        
        if (o1 == UpdateType.SESSION_ADDED) {
            System.out.println("session added");
        }
        
        if (o1 == UpdateType.SESSION_REMOVED) {
            System.out.println("session removed");
        }
        if (o1 == UpdateType.CONNECTION_ESTABLISHED) {
            System.out.println("connection established");
            SessionInformation sessionInformation = networkHandler.getOwnSession();
            localSessionID = sessionInformation.getId();
            stepGenerator.setSessionID(sessionInformation.getId());
            simulationController.addSession(localSessionID, "localSessionName", new GameEngine(localSessionID));
        }
        
        
        
    }
      
    
    /*
     * Called every 50ms
     * 
     * public for testing
     */
    public void runStep() {
        System.out.println("running step: "+currentStep+" time: "+System.nanoTime());
        stepGenerator.niggasInParis();
        simulationController.simulateStep(currentStep);
        currentStep++;
        
    }
    
    //Start the step timer
    private void run() { 
        TimerTask timerTask = new TimerTask() {
                                  @Override
                                  public void run() {
                                      runStep();
                                  }
                              };
        timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, stepDuration);
    }
    
    
    
}
