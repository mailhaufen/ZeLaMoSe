/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import network.client.HandlerInterface;

/**
 *
 * @author Fabian Senn <fsenn@hsr.ch>
 */
public class SendChatMessageRunnable implements Runnable {
   private final String message;
   private final HandlerInterface handler;

   public SendChatMessageRunnable(String Message, HandlerInterface handler) {
      this.message = Message;
      this.handler = handler;
   }
   
   @Override
   public void run() {
      handler.sendChatMessage(message);
   }
   
}
