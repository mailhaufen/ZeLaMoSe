package view;

import domain.InputSampler;
import domain.SimulationStateAbstract;
import java.util.List;

/**
 *
 * @author Patrick Zenhäusern <pzenhaeu@hsr.ch>
 */
public class GameFieldJFrame extends javax.swing.JFrame {

    /**
     * Creates new form frmGame
     */
    public GameFieldJFrame() {
        initComponents();
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

        ownGameFieldJPanel2 = new view.OwnGameFieldJPanel();
        pnlEnemyAreas = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlEnemyAreas.setLayout(new javax.swing.BoxLayout(pnlEnemyAreas, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ownGameFieldJPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlEnemyAreas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(354, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ownGameFieldJPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 46, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlEnemyAreas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.media.opengl.awt.GLJPanel gLPnlEnemyArea1;
    private javax.media.opengl.awt.GLJPanel gLPnlEnemyArea2;
    private javax.media.opengl.awt.GLJPanel gLPnlEnemyArea3;
    private view.OwnGameFieldJPanel ownGameFieldJPanel2;
    private javax.swing.JPanel pnlEnemyAreas;
    // End of variables declaration//GEN-END:variables

    public OwnGameFieldJPanel getMainPanel() {
        return ownGameFieldJPanel2;
    }
}
