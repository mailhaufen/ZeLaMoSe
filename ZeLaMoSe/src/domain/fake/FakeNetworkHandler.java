/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.fake;

import domain.Step;
import java.util.concurrent.ExecutorService;
import network.ChatMessage;
import network.client.NetworkHandler;
import network.SessionInformation;
import domain.TetrisController.UpdateType;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author chrigi
 */
public class FakeNetworkHandler extends NetworkHandler {
    public Step lastStep;
    @Override
    public SessionInformation getAddedSession() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getRandomGeneratorSeed() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SessionInformation getRemovedSession() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void connectToServer(String ip, String serverName, String nickname) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void disconnectFromServer() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public ConcurrentHashMap<Integer, Step> stepMap = new ConcurrentHashMap<Integer, Step>();
    
    private SessionInformation localSession;
    private ConcurrentHashMap<Integer, String> sessionMap = new ConcurrentHashMap<Integer, String>();

    public FakeNetworkHandler(SessionInformation localSession) {
        this.localSession = localSession;
        sessionMap.put(localSession.getId(), localSession.getNickname());
    }

    @Override
    public SessionInformation getOwnSession() {
        return localSession;
    }
    
    public void setConnected() {
        setChanged();
        notifyObservers(UpdateType.CONNECTION_ESTABLISHED);
    }
    
    public void setGameStarted() {
        setChanged();
        notifyObservers(UpdateType.GAME_STARTED);
    }

    @Override
    public ConcurrentHashMap<Integer, String> getSessionList() {
        return sessionMap;
    }

    @Override
    public void sendChatMessage(String message) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ChatMessage getChatMessage() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Exception getThrownException() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ExecutorService getThreadPool() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addStep(Step step) {
        lastStep = step;
    }
    
    private Step remoteStep;
    public void addRemoteStep(Step step) {
        remoteStep = step;
        setChanged();
        notifyObservers(UpdateType.STEP);
    }

    @Override
    public Step getStep() {
        return remoteStep;
    }

    @Override
    public void niggasInParis() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
