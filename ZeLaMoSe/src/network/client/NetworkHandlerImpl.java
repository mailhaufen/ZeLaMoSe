/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package network.client;

import domain.Step;
import domain.TetrisController.UpdateType;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import network.*;

/**
 *
 * @author Fabian Senn <fsenn@hsr.ch>
 */
public class NetworkHandlerImpl extends NetworkHandler {

    private Handler handler;
    private ConcurrentLinkedQueue<Step> stepQueue = new ConcurrentLinkedQueue<Step>();
    private Step lastStep;
    private SessionInformation lastAddedSession;
    private SessionInformation lastRemovedSession;
    private SessionInformation ownSession;
    private ChatMessage chatMessage;
    private ExecutorService threadPool;
    private ConcurrentHashMap<Integer, String> sessionList = new ConcurrentHashMap<Integer, String>();
    private Exception thrownException;
    private long blockQueueSeed;

    @Override
    public void niggasInParis() {
        while (!stepQueue.isEmpty()) {
            lastStep = stepQueue.poll();
            setChanged();
            notifyObservers(UpdateType.STEP);
        }
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Handler getHandler() {
        return handler;
    }

    public NetworkHandlerImpl() {
        threadPool = Executors.newFixedThreadPool(1);
    }

    @Override
    public SessionInformation getAddedSession() {
        return lastAddedSession;
    }

    @Override
    public int getRandomGeneratorSeed() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SessionInformation getRemovedSession() {
        return lastRemovedSession;
    }

    @Override
    public void connectToServer(final String ip, final String serverName, final String nickname) {
        threadPool.submit(new ConnectionRunnable(this, ip, serverName, nickname));
    }

    @Override
    public void addStep(Step step) {
        threadPool.execute(new AddStepRunnable(step, handler));
    }

    @Override
    public Step getStep() {
        return lastStep;
    }

    @Override
    public void disconnectFromServer() {
        threadPool.execute(new DisconnectionRunnable(handler));
    }

    public void notifyStepReceived(Step step) {
        stepQueue.add(step);
    }

    public void notifySessionAdded(SessionInformation addedSession) {
        lastAddedSession = addedSession;
        sessionList.put(addedSession.getId(), addedSession.getNickname());
        setChanged();
        notifyObservers(UpdateType.SESSION_ADDED);
    }

    public void notifySessionRemoved(SessionInformation removedSession) {
        lastRemovedSession = removedSession;
        sessionList.remove(new Integer(removedSession.getId()));
        setChanged();
        notifyObservers(UpdateType.SESSION_REMOVED);
    }

    public void notifyExceptionThrown(Exception ex) {
        thrownException = ex;
        setChanged();
        notifyObservers(UpdateType.EXCEPTION_THROWN);
    }

    @Override
    public SessionInformation getOwnSession() {
        return ownSession;
    }

    public void notifyConnectionEstablished(SessionInformation ownSession, List<SessionInformation> sessionList) {
        this.ownSession = ownSession;
        for (SessionInformation session : sessionList) {
            this.sessionList.put(session.getId(), session.getNickname());
        }
        setChanged();
        notifyObservers(UpdateType.CONNECTION_ESTABLISHED);
    }

    @Override
    public ConcurrentHashMap<Integer, String> getSessionList() {
        return sessionList;
    }

    @Override
    public void sendChatMessage(final String message) {
        threadPool.execute(new SendChatMessageRunnable(message, handler));
    }

    void notifyChatMessageReceived(ChatMessage message) {
        this.chatMessage = message;
        setChanged();
        notifyObservers(UpdateType.CHAT_MESSAGE_RECEIVED);
    }

    @Override
    public ChatMessage getChatMessage() {
        return chatMessage;
    }

    @Override
    public Exception getThrownException() {
        return thrownException;
    }
    
    public void notifyInit(long blockQueueSeed) {
        this.blockQueueSeed = blockQueueSeed;
        setChanged();
        notifyObservers(UpdateType.INIT_SIGNAL);
    }

    public void notifyGameStarted() {
        setChanged();
        notifyObservers(UpdateType.GAME_STARTED);
    }

    @Override
    public ExecutorService getThreadPool() {
        return threadPool;
    }

    @Override
    public void sendReadySignal() {
        handler.sendReadySignal();
    }

    @Override
    public long getBlockQueueSeed() {
        return blockQueueSeed;
    }
}
