/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.fake;
import domain.SimulationController;
import domain.GameEngineAbstract;
import domain.actions.Action;
import domain.actions.GarbageLineAction;

/**
 *
 * @author Christian Mollekopf <cmolleko@hsr.ch>
 */
public class FakeGameEngine extends GameEngineAbstract {
  private Action lastAction  = null;
  private int sessionId;
  public FakeGameEngine(int sessionId) {
      this.sessionId = sessionId;
  }

  @Override
  public int getSessionID() {
    return this.sessionId;
  }

    @Override
    public void startGame() {
      
    }  
  
  @Override
  public void handleAction(Action action) {
//      System.out.println("simulate action");
      lastAction = action;
      setChanged();
      notifyObservers();
  }
  
  public Action getLastAction() {
      return lastAction;
  }

  @Override
  public Action getSimulationState() {
    //do nothing
      return lastAction;
  }

    @Override
    public int getLevel() {
        //do nothing
        return 0;
    }

    @Override
    public String toString() {
        return new String("MockGameEndine " + sessionId);
    }


    @Override
    public void setNickName(String nickName) {
       
    }

    @Override
    public GarbageLineAction getlastGarbageLineAction() {
       return null;
    }

  
    
}