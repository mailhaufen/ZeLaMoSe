/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.actions.InputEvent;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author chrigi
 */
public class FakeInputSampler implements InputSamplerInterface{
    public Collection<InputEvent> inputEvents = new ConcurrentLinkedQueue<InputEvent>();

    @Override
    public Collection<InputEvent> getAndRemoveAllFromQueue() {
        return inputEvents;
    }
    
    
}
