/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import domain.*;
import java.awt.Color;
import java.awt.Component;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.*;
import network.ChatMessage;
import view.music.MusicFile;
import view.music.SoundEngine;

/**
 *
 * @author Patrick Zenhäusern <pzenhaeu@hsr.ch>
 */
public class LobbyJFrame extends javax.swing.JFrame implements Observer {

    private TetrisController tetrisController;
    private PlayerListModel playerListModel;
    private final ChatController chatController;
    private SoundEngine soundEngine;
    final static SimpleAttributeSet BLUE = new SimpleAttributeSet();
    final static SimpleAttributeSet DEFAULT = new SimpleAttributeSet();
    final static SimpleAttributeSet INSERT = new SimpleAttributeSet();

    static {
        StyleConstants.setForeground(BLUE, Color.blue);
        StyleConstants.setFontFamily(BLUE, "Helvetica");
        StyleConstants.setFontSize(BLUE, 12);
        StyleConstants.setBold(BLUE, true);

        StyleConstants.setForeground(DEFAULT, Color.black);
        StyleConstants.setFontFamily(DEFAULT, "Helvetica");
        StyleConstants.setFontSize(DEFAULT, 12);

        StyleConstants.setForeground(INSERT, Color.red);
        StyleConstants.setFontFamily(INSERT, "Helvetica");
        StyleConstants.setItalic(INSERT, true);
        StyleConstants.setBold(INSERT, true);
        StyleConstants.setFontSize(INSERT, 12);
    }

    LobbyJFrame(TetrisController tetrisController, final ChatController chatController, MainJFrame.GameMode gameMode) {
        this.tetrisController = tetrisController;
        this.chatController = chatController;
        this.playerListModel = new PlayerListModel(chatController.getSessionList());

        initComponents();
        lblServerIPValue.setText(tetrisController.getServerIP());
        tetrisController.addObserver(this);
        chatController.addObserver(this);
        chatController.addObserver(playerListModel);
        switch (gameMode) {
            case SINGLE_PLAYER:
                tetrisController.startGame(0);
                break;
            case MULTI_PLAYER_JOIN:
                btnStart.setEnabled(false);
                lblNumberOfJokers.setVisible(false);
                sprNumberOfJokersValue.setVisible(false);
            case MULTI_PLAYER_HOST:
                soundEngine = new SoundEngine();
                soundEngine.playBackgroundMusic(MusicFile.lobbyBackgroundMusic);
                break;
        }
    }

    private GameFieldJFrame createGameField() {
        List<SimulationStateAbstract> otherSimulations = new ArrayList<SimulationStateAbstract>();
        for (Integer sessionID : tetrisController.getSessionMap().keySet()) {
            if (sessionID != tetrisController.getLocalSessionID()) {
                otherSimulations.add(tetrisController.getSession(sessionID));
            }
        }
        SimulationStateAbstract localSimulation = tetrisController.getSession(tetrisController.getLocalSessionID());
        final GameFieldJFrame gameField = new GameFieldJFrame(tetrisController.getInputSampler(), localSimulation, otherSimulations);
        return gameField;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code.
     * The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblServerIP = new javax.swing.JLabel();
        lblServerIPValue = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtMessage = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnStart = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        pnlClock = new javax.swing.JPanel();
        lblNumberOfJokers = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstPlayers = new javax.swing.JList();
        sprNumberOfJokersValue = new javax.swing.JSpinner();
        jScrollPane3 = new javax.swing.JScrollPane();
        txpChat = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblServerIP.setText("Server-IP:");

        lblServerIPValue.setText("<ServerIPValue>");

        jLabel1.setText("<html><h3>ZeLaMoSe-Tetris - Lobby</h3></html>");

        txtMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMessageActionPerformed(evt);
            }
        });

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

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

        lblNumberOfJokers.setText("Number of Jokers:");

        lstPlayers.setModel(playerListModel);
        lstPlayers.setCellRenderer(new DefaultListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(JList jlist, Object o, int i, boolean bln, boolean bln1) {
                Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) o;
                setText(entry.getValue());
                if (entry.getKey() == chatController.getOwnSession().getId()) {
                    setBackground(new Color(230, 245, 245));
                } else {
                    setBackground(Color.white);
                    setEnabled(false);
                }
                return this;
            }
        });
        jScrollPane2.setViewportView(lstPlayers);

        txpChat.setEditable(false);
        txpChat.setFocusable(false);
        jScrollPane3.setViewportView(txpChat);

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
                        .addGap(203, 203, 203)
                        .addComponent(lblServerIP, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(lblServerIPValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnStart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNumberOfJokers)
                        .addGap(32, 32, 32)
                        .addComponent(sprNumberOfJokersValue, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(pnlClock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblServerIP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblServerIPValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlClock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNumberOfJokers)
                            .addComponent(sprNumberOfJokersValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnStart, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMessage)
                    .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        JFormattedTextField txt = ((JSpinner.NumberEditor) sprNumberOfJokersValue.getEditor()).getTextField();
        ((NumberFormatter) txt.getFormatter()).setAllowsInvalid(false);
        ((NumberFormatter) txt.getFormatter()).setMinimum(0);

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
      System.exit(0);
  }//GEN-LAST:event_btnExitActionPerformed

  private void txtMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMessageActionPerformed
      btnSendActionPerformed(evt);
  }//GEN-LAST:event_txtMessageActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        tetrisController.startGame((Integer) sprNumberOfJokersValue.getValue());
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        if (!txtMessage.getText().isEmpty()) {
            chatController.sendChatMessage(txtMessage.getText());
            txtMessage.setText("");
        }

    }//GEN-LAST:event_btnSendActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblNumberOfJokers;
    private javax.swing.JLabel lblServerIP;
    private javax.swing.JLabel lblServerIPValue;
    private javax.swing.JList lstPlayers;
    private javax.swing.JPanel pnlClock;
    private javax.swing.JSpinner sprNumberOfJokersValue;
    private javax.swing.JTextPane txpChat;
    private javax.swing.JTextField txtMessage;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object o1) {
        TetrisController.UpdateType type = (TetrisController.UpdateType) o1;

        switch (type) {
            case INIT_SIGNAL:
                chatController.deleteObserver(this);
                chatController.deleteObserver(playerListModel);
                chatController.tearDown();
                tetrisController.deleteObserver(this);
                final GameFieldJFrame gameField = createGameField();

                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        gameField.setVisible(true);
                        if (soundEngine != null) {
                            soundEngine.stopBackGroundMusic(MusicFile.lobbyBackgroundMusic);
                        }
                        dispose();
                    }
                });
                break;
            case EXCEPTION_THROWN:
                break;
            case CHAT_MESSAGE_RECEIVED:
                writeChatMessage(chatController.getChatMessage());
                break;
            case SESSION_ADDED:
                writeServerMessage(chatController.getAddedSession().getNickname() + " enters");
                break;
            case SESSION_REMOVED:
                writeServerMessage(chatController.getRemovedSession().getNickname() + " has left");
                break;
        }
    }

    private void writeChatMessage(ChatMessage chatMessage) {
        appendText(chatMessage.getSender().getNickname() + ": ", BLUE);
        appendText(chatMessage.getMessage() + '\n', DEFAULT);
        scrollToNewLine();        
    }

    private void writeServerMessage(String message) {
        appendText(message + '\n', DEFAULT);
        scrollToNewLine();
    }

    private void appendText(final String text, final AttributeSet set) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    txpChat.getDocument().insertString(txpChat.getDocument().getLength(), text, set);
                } catch (BadLocationException ex) {
                    Logger.getLogger(LobbyJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    private void scrollToNewLine() {
        txpChat.setCaretPosition(txpChat.getText().length());
    }
}
