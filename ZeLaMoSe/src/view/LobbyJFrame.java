/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import domain.GameEngine;
import domain.InputSampler;
import domain.Step;
import domain.StepGeneratorImpl;
import domain.TetrisController;
import domain.actions.Action;
import domain.interfaces.SimulationStateInterface;
import domain.interfaces.StepProducerInterface;
import java.awt.event.KeyAdapter;
import java.util.*;
import javax.swing.SwingUtilities;
import network.SessionInformation;
import network.client.NetworkHandler;

/**
 *
 * @author Patrick Zenhäusern
 */
public class LobbyJFrame extends javax.swing.JFrame implements Observer {

    private NetworkHandler networkHandler;
    private TetrisController tetrisController;
    private SessionInformation ownSession;
    private List<SessionInformation> sessionList;
    private InputSampler inputSampler;
    private final MainJFrame menu;

    LobbyJFrame(NetworkHandler networkHandler, TetrisController tetrisController, InputSampler inputSampler, boolean host, MainJFrame menu) {
        this.tetrisController = tetrisController;
        this.networkHandler = networkHandler;
        this.sessionList = networkHandler.getSessionList();
        this.ownSession = networkHandler.getOwnSession();
        this.inputSampler = inputSampler;
        this.menu = menu;
        initComponents();
        btnStart.setVisible(host);
        networkHandler.addObserver(this);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txaChat = new javax.swing.JTextArea();
        lblServerIP = new javax.swing.JLabel();
        lblServerIPValue = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtMessage = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        lblOtherPlayerName3 = new javax.swing.JLabel();
        lblOtherPlayerName1 = new javax.swing.JLabel();
        lblOtherPlayerName2 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnStart = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblOwnPlayerName = new javax.swing.JLabel();
        lblOne = new javax.swing.JLabel();
        lblTwo = new javax.swing.JLabel();
        lblThree = new javax.swing.JLabel();
        lblFour = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        pnlClock = new javax.swing.JPanel();
        lblTimeHere = new javax.swing.JLabel();
        lblTimeHereValue = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1026, 710));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txaChat.setColumns(20);
        txaChat.setRows(5);
        jScrollPane1.setViewportView(txaChat);

        lblServerIP.setText("Server-IP:");

        lblServerIPValue.setText("<ServerIPValue>");

        jLabel1.setText("<html><h3>ZeLaMoSe-Tetris - Lobby</h3></html>");

        txtMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMessageActionPerformed(evt);
            }
        });

        btnSend.setText("Send");

        lblOtherPlayerName3.setText("<OtherPlayerName3>");

        lblOtherPlayerName1.setText("<OtherPlayerName1>");

        lblOtherPlayerName2.setText("<OtherPlayerName2>");

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnStart.setText("Start Game");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        jLabel2.setText("Players:");

        lblOwnPlayerName.setText("<OwnPlayerName>");

        lblOne.setText("1.");

        lblTwo.setText("2.");

        lblThree.setText("3.");

        lblFour.setText("4.");

        pnlClock.setBorder(javax.swing.BorderFactory.createTitledBorder("Clock"));
        pnlClock.setPreferredSize(new java.awt.Dimension(136, 136));

        javax.swing.GroupLayout pnlClockLayout = new javax.swing.GroupLayout(pnlClock);
        pnlClock.setLayout(pnlClockLayout);
        pnlClockLayout.setHorizontalGroup(
            pnlClockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );
        pnlClockLayout.setVerticalGroup(
            pnlClockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 109, Short.MAX_VALUE)
        );

        lblTimeHere.setText("Time you're here:");

        lblTimeHereValue.setText("<TimeHereValue>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMessage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 435, Short.MAX_VALUE)
                        .addComponent(lblServerIP, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblServerIPValue))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnStart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblOne)
                                .addComponent(lblTwo)
                                .addComponent(lblThree)
                                .addComponent(lblFour))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblOtherPlayerName2)
                                .addComponent(lblOtherPlayerName1)
                                .addComponent(lblOtherPlayerName3)
                                .addComponent(lblOwnPlayerName)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addComponent(jLabel2))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTimeHere)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTimeHereValue))
                    .addComponent(pnlClock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblServerIP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblServerIPValue)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblOwnPlayerName)
                            .addComponent(lblOne))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblOtherPlayerName1)
                            .addComponent(lblTwo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblOtherPlayerName2)
                            .addComponent(lblThree))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblOtherPlayerName3)
                            .addComponent(lblFour))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlClock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTimeHere)
                            .addComponent(lblTimeHereValue))
                        .addGap(42, 42, 42)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStart, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMessage)
                    .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
      formWindowClosing(null);
  }//GEN-LAST:event_btnExitActionPerformed

  private void txtMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMessageActionPerformed
      // TODO add your handling code here:
  }//GEN-LAST:event_txtMessageActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        networkHandler.deleteObserver(this);
        networkHandler.disconnectFromServer();
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                menu.setVisible(true);
            }
        });
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        tetrisController.startGame();
    }//GEN-LAST:event_btnStartActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblFour;
    private javax.swing.JLabel lblOne;
    private javax.swing.JLabel lblOtherPlayerName1;
    private javax.swing.JLabel lblOtherPlayerName2;
    private javax.swing.JLabel lblOtherPlayerName3;
    private javax.swing.JLabel lblOwnPlayerName;
    private javax.swing.JLabel lblServerIP;
    private javax.swing.JLabel lblServerIPValue;
    private javax.swing.JLabel lblThree;
    private javax.swing.JLabel lblTimeHere;
    private javax.swing.JLabel lblTimeHereValue;
    private javax.swing.JLabel lblTwo;
    private javax.swing.JPanel pnlClock;
    private javax.swing.JTextArea txaChat;
    private javax.swing.JTextField txtMessage;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object o1) {
        switch ((TetrisController.UpdateType) o1) {
            case CHAT_MESSAGE_RECEIVED:
                writeToChatArea(networkHandler.getChatMessage().toString());
                break;
            case SESSION_ADDED:
                writeToChatArea(networkHandler.getAddedSession().getNickname() + " enters");
                updatePlayerList(networkHandler.getSessionList());
                break;
            case SESSION_REMOVED:
                writeToChatArea(networkHandler.getRemovedSession().getNickname() + " has left");
                updatePlayerList(networkHandler.getSessionList());
                break;
            case GAME_STARTED:
                networkHandler.deleteObserver(this);
                final GameFieldJFrame gamefield = new GameFieldJFrame();
                OwnGameFieldJPanel panel = gamefield.getMainPanel();
                panel.setInputSampler(inputSampler);
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        gamefield.setVisible(true);
                        dispose();
                    }
                });
                break;
            case STEP:

                break;
            case EXCEPTION_THROWN:
                break;
        }
    }

    private void writeToChatArea(String message) {
        txaChat.append(message + '\n');
    }

    private void updatePlayerList(final List<SessionInformation> newSessionList) {
    }
}
