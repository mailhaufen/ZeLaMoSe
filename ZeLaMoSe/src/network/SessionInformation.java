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
public class SessionInformation implements Serializable {
  private final int id;
  private final String nickname;
   
  public SessionInformation(int id, String nickname) {
    this.id = id;
    this.nickname = nickname;
  }

  /**
   * @return the nickname
   */
  public String getNickname() {
    return nickname;
  }

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

   @Override
   public String toString() {
      return "SessionInformation{" + "id=" + id + ", nickname=" + nickname + '}';
   }
}
