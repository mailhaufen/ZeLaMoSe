package view;

import domain.InputSampler;
import domain.SimulationStateAbstract;
import domain.TetrisController;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.List;

/**
 *
 * @author Patrick Zenhäusern <pzenhaeu@hsr.ch>
 */
public class GameFieldJFrame extends javax.swing.JFrame {

    private TetrisController tetrisController;
    private boolean fullscreenOn = false;

    public GameFieldJFrame(TetrisController tetrisController, InputSampler is, SimulationStateAbstract mainSimulation, List<SimulationStateAbstract> otherSimulations) {
        this(is, mainSimulation, otherSimulations);
        this.tetrisController = tetrisController;
    }

    public GameFieldJFrame(InputSampler is, SimulationStateAbstract mainSimulation, List<SimulationStateAbstract> otherSimulations) {
        initComponents();
        ownGameFieldJPanel2.setInputSampler(is);
        ownGameFieldJPanel2.initRenderer(mainSimulation);

        for (SimulationStateAbstract gameEngine : otherSimulations) {
            OtherGameFieldJPanel panel = new OtherGameFieldJPanel((gameEngine).getNickName(), gameEngine);
            pnlEnemyAreas.add(panel);
            gameEngine.addObserver(panel);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code.
     * The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEnemyAreas = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnFullscreen = new javax.swing.JButton();
        ownGameFieldJPanel2 = new view.OwnGameFieldJPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlEnemyAreas.setLayout(new javax.swing.BoxLayout(pnlEnemyAreas, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));
        jPanel2.add(filler1);

        btnFullscreen.setText("Fullscreen off");
        btnFullscreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFullscreenActionPerformed(evt);
            }
        });
        jPanel2.add(btnFullscreen);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);
        jPanel1.add(ownGameFieldJPanel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(706, 706, 706)
                .addComponent(pnlEnemyAreas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(354, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 370, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlEnemyAreas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1138, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1126, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
//        if (tetrisController != null) {
//            tetrisController.abortGame();
//            switch (JOptionPane.showConfirmDialog(this, "Do you want to save the Replay?", "Save Replay?", JOptionPane.YES_NO_OPTION)) {
//                case JOptionPane.YES_OPTION:
//                    JFileChooser fc = new JFileChooser();
//                    fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//                    if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
//                        File file = fc.getSelectedFile();
//                        try {
//                            tetrisController.saveReplayData(file.getAbsolutePath());
//                        } catch (IOException ex) {
//                            JOptionPane.showMessageDialog(this, ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
//                        }
//                    }
//
//                    break;
//                case JOptionPane.NO_OPTION:
//                    break;
//            }
//        }
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void btnFullscreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFullscreenActionPerformed

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = ge.getDefaultScreenDevice();
        if (device.isFullScreenSupported()) {
            if (fullscreenOn) {
                device.setFullScreenWindow(null);
                btnFullscreen.setText("Fullscreen off");
            } else {
                device.setFullScreenWindow(this);
                btnFullscreen.setText("Fullscreen on");
            }
            fullscreenOn = !fullscreenOn;
        }
    }//GEN-LAST:event_btnFullscreenActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFullscreen;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private view.OwnGameFieldJPanel ownGameFieldJPanel2;
    private javax.swing.JPanel pnlEnemyAreas;
    // End of variables declaration//GEN-END:variables

    public OwnGameFieldJPanel getMainPanel() {
        return ownGameFieldJPanel2;
    }
}
