/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.Serializable;

/**
 *
 * @author Fabian Senn <fsenn@hsr.ch>
 */
public interface NetworkMessage extends Serializable {
  public Object getMessageObject();
}
