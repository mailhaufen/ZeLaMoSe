package view;

import domain.TetrisController;
import java.awt.CardLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;
import network.client.DiscoveryClient;
import view.MainJFrame.GameMode;

/**
 *
 * @author Fabian Senn <fsenn@hsr.ch>
 */
public class JoinGameJDialog extends javax.swing.JDialog implements Observer {

    private final GameMode gameMode;
    private final String nickname;
    private final CardLayout cardLayout;
    private DiscoveryClient serverDiscoveryClient;
    private final TetrisController tetrisController;
    private Exception thrownException;
    private ReturnValue returnValue = ReturnValue.CANCELLED;

    public enum ReturnValue {

        CONNECTED, CANCELLED, EXCEPTION_THROWN
    }

    public ReturnValue getReturnValue() {
        return returnValue;
    }

    public Exception getThrownException() {
        return thrownException;
    }

    /**
     * Creates new form JoinGameJDialog
     */
    public JoinGameJDialog(MainJFrame parent, boolean modal, GameMode gameMode, TetrisController tetrisController, String nickname) {
        super(parent, modal);
        this.gameMode = gameMode;
        this.nickname = nickname;
        this.tetrisController = tetrisController;


        initComponents();
        serverDiscoveryClient = new DiscoveryClient();
        serverDiscoveryClient.addObserver(this);
        this.cardLayout = (CardLayout) pnlConnection.getLayout();
        if (gameMode == GameMode.MULTI_PLAYER_HOST || gameMode == GameMode.SINGLE_PLAYER) {
            connectToServer("localhost");
        }
        listServer.setModel(serverDiscoveryClient.getServerListModel());
        getRootPane().setDefaultButton(btnJoin);
    }

    private void connectToServer(final String serverIP) {
        cardLayout.next(pnlConnection);
        lblIPAddress1.setText(serverIP);
        tetrisController.addObserver(this);
        tetrisController.connectToServer(serverIP, TetrisController.SERVER_PORT, nickname);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code.
     * The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlConnection = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblEnterIP = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblIPAddress = new javax.swing.JLabel();
        txtIPAddress = new javax.swing.JTextField();
        lblState = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnJoin = new javax.swing.JButton();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        btnCancel = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listServer = new javax.swing.JList();
        btnRefresh = new javax.swing.JButton();
        lblRefreshing = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lblTryToJoin = new javax.swing.JLabel();
        lblIPAddress1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lblWait = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel4 = new javax.swing.JPanel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnCancel1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlConnection.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlConnection.setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        lblEnterIP.setText("Please enter the IP-Address of the Server...");
        lblEnterIP.setName("");
        jPanel1.add(lblEnterIP, java.awt.BorderLayout.NORTH);

        jPanel5.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.Y_AXIS));

        lblIPAddress.setText("IP-Address:");
        jPanel5.add(lblIPAddress);

        txtIPAddress.setAlignmentX(0.0F);
        txtIPAddress.setMaximumSize(new java.awt.Dimension(200, 31));
        jPanel5.add(txtIPAddress);

        lblState.setMaximumSize(new java.awt.Dimension(291, 21));
        lblState.setMinimumSize(new java.awt.Dimension(291, 21));
        lblState.setPreferredSize(new java.awt.Dimension(291, 21));
        jPanel5.add(lblState);

        jPanel1.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));
        jPanel6.add(filler1);

        btnJoin.setText("Join");
        btnJoin.setMaximumSize(new java.awt.Dimension(55, 31));
        btnJoin.setMinimumSize(new java.awt.Dimension(55, 31));
        btnJoin.setPreferredSize(new java.awt.Dimension(55, 31));
        btnJoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJoinActionPerformed(evt);
            }
        });
        jPanel6.add(btnJoin);
        jPanel6.add(filler6);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel6.add(btnCancel);

        jPanel1.add(jPanel6, java.awt.BorderLayout.SOUTH);

        jPanel9.setPreferredSize(new java.awt.Dimension(180, 90));

        listServer.setPreferredSize(new java.awt.Dimension(120, 50));
        listServer.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listServerValueChanged(evt);
            }
        });
        listServer.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                listServerPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(listServer);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        lblRefreshing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/image/refresh.gif")));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(btnRefresh)
                        .addGap(18, 18, 18)
                        .addComponent(lblRefreshing)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh)
                    .addComponent(lblRefreshing))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel9, java.awt.BorderLayout.WEST);

        pnlConnection.add(jPanel1, "card2");

        jPanel2.setPreferredSize(new java.awt.Dimension(279, 173));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        lblTryToJoin.setText("Trying to join game:");
        jPanel7.add(lblTryToJoin);

        lblIPAddress1.setText("<Sample IP Address>");
        jPanel7.add(lblIPAddress1);

        jPanel2.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jPanel8.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.Y_AXIS));

        lblWait.setText("Please wait...");
        jPanel8.add(lblWait);

        jProgressBar1.setAlignmentX(0.0F);
        jProgressBar1.setIndeterminate(true);
        jPanel8.add(jProgressBar1);

        jPanel2.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));
        jPanel4.add(filler3);

        btnCancel1.setText("Cancel");
        btnCancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancel1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnCancel1);

        jPanel2.add(jPanel4, java.awt.BorderLayout.SOUTH);

        pnlConnection.add(jPanel2, "card3");

        getContentPane().add(pnlConnection, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnJoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJoinActionPerformed
        connectToServer(txtIPAddress.getText());
    }//GEN-LAST:event_btnJoinActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        returnValue = ReturnValue.CANCELLED;
        tetrisController.deleteObserver(this);
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnCancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancel1ActionPerformed
        if (gameMode == GameMode.MULTI_PLAYER_JOIN) {
            cardLayout.next(pnlConnection);
            lblState.setText("");
        } else {
            btnCancelActionPerformed(evt);
        }
    }//GEN-LAST:event_btnCancel1ActionPerformed

    private void listServerValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listServerValueChanged
        if (!evt.getValueIsAdjusting() && listServer.getSelectedValue() != null) {
            txtIPAddress.setText(listServer.getSelectedValue().toString());
        }

    }//GEN-LAST:event_listServerValueChanged

    private void listServerPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_listServerPropertyChange
    }//GEN-LAST:event_listServerPropertyChange

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        listServer.setModel(serverDiscoveryClient.getServerListModel());
    }//GEN-LAST:event_btnRefreshActionPerformed

    @Override
    public void update(Observable o, Object o1) {
        if (o1 instanceof TetrisController.UpdateType) {
            switch ((TetrisController.UpdateType) o1) {

                case CONNECTION_ESTABLISHED:
                    returnValue = ReturnValue.CONNECTED;
                    tetrisController.deleteObserver(this);
                    dispose();
                    break;
                case EXCEPTION_THROWN:
                    if (gameMode == GameMode.MULTI_PLAYER_JOIN) {
                        SwingUtilities.invokeLater(new Runnable() {

                            @Override
                            public void run() {
                                cardLayout.next(pnlConnection);
                                lblState.setText("<html><font color=red>Connection Establishment failed</font></html>");
                            }
                        });
                    } else {
                        returnValue = ReturnValue.EXCEPTION_THROWN;
                        thrownException = tetrisController.getThrownException();
                        tetrisController.deleteObserver(this);
                        dispose();
                    }
                    break;
            }
        } else {
            switch ((DiscoveryClient.DiscoveryState) o1) {
                case STARTED:
                    btnRefresh.setEnabled(false);
                    lblRefreshing.setVisible(true);
                    break;
                case FINISHED:
                    btnRefresh.setEnabled(true);
                    lblRefreshing.setVisible(false);
                    break;
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCancel1;
    private javax.swing.JButton btnJoin;
    private javax.swing.JButton btnRefresh;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEnterIP;
    private javax.swing.JLabel lblIPAddress;
    private javax.swing.JLabel lblIPAddress1;
    private javax.swing.JLabel lblRefreshing;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblTryToJoin;
    private javax.swing.JLabel lblWait;
    private javax.swing.JList listServer;
    private javax.swing.JPanel pnlConnection;
    private javax.swing.JTextField txtIPAddress;
    // End of variables declaration//GEN-END:variables
}
