package view;

import com.jogamp.opengl.util.FPSAnimator;
import domain.Config;
import domain.SimulationStateAbstract;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Fabian Senn <fsenn@hsr.ch>
 */
public class OtherGameFieldJPanel extends javax.swing.JPanel implements Observer {

    private SimulationStateAbstract gameEngine;

    /**
     * Creates new form OtherGameFieldJPanel
     */
    public OtherGameFieldJPanel(String playerName, SimulationStateAbstract gameEngine) {
        initComponents();
        this.gameEngine = gameEngine;
        this.lblPlayerName.setText("<html><b>" + playerName + "</html></b>");
        initGLJPanel(gameEngine);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code.
     * The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gLPnlEnemyArea1 = new javax.media.opengl.awt.GLJPanel();
        lblPlayerName = new javax.swing.JLabel();
        lblScoreTitle = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        lblLevelTitle = new javax.swing.JLabel();
        lblLevel = new javax.swing.JLabel();
        lblNbrOfLinesTitle = new javax.swing.JLabel();
        lblNbrOfLines = new javax.swing.JLabel();
        lblNbrOfBlocksTitle = new javax.swing.JLabel();
        lblNbrOfBlocks = new javax.swing.JLabel();

        gLPnlEnemyArea1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gLPnlEnemyArea1.setMaximumSize(new java.awt.Dimension(120, 220));
        gLPnlEnemyArea1.setMinimumSize(new java.awt.Dimension(120, 220));

        javax.swing.GroupLayout gLPnlEnemyArea1Layout = new javax.swing.GroupLayout(gLPnlEnemyArea1);
        gLPnlEnemyArea1.setLayout(gLPnlEnemyArea1Layout);
        gLPnlEnemyArea1Layout.setHorizontalGroup(
            gLPnlEnemyArea1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );
        gLPnlEnemyArea1Layout.setVerticalGroup(
            gLPnlEnemyArea1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 216, Short.MAX_VALUE)
        );

        lblPlayerName.setText("<OtherPlayerName1>");

        lblScoreTitle.setText("<html><b>Score:</b></html>");
        lblScoreTitle.setBorder(null);
        lblScoreTitle.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblScoreTitle.setMaximumSize(new java.awt.Dimension(81, 21));
        lblScoreTitle.setMinimumSize(new java.awt.Dimension(81, 21));
        lblScoreTitle.setPreferredSize(new java.awt.Dimension(81, 21));

        lblScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScore.setText("<OtherScoreValue1>");

        lblLevelTitle.setText("<html><b>Level:</b></html>");
        lblLevelTitle.setBorder(null);
        lblLevelTitle.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblLevelTitle.setMaximumSize(new java.awt.Dimension(81, 21));
        lblLevelTitle.setMinimumSize(new java.awt.Dimension(81, 21));
        lblLevelTitle.setPreferredSize(new java.awt.Dimension(81, 21));

        lblLevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLevel.setText("<OtherLevel1>");

        lblNbrOfLinesTitle.setText("<html><b>Number of Lines:</b></html>");
        lblNbrOfLinesTitle.setBorder(null);
        lblNbrOfLinesTitle.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblNbrOfLinesTitle.setMaximumSize(new java.awt.Dimension(81, 21));
        lblNbrOfLinesTitle.setMinimumSize(new java.awt.Dimension(81, 21));
        lblNbrOfLinesTitle.setPreferredSize(new java.awt.Dimension(81, 21));

        lblNbrOfLines.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNbrOfLines.setText("<OtherLines>");

        lblNbrOfBlocksTitle.setText("<html><b>Number of Blocks:</b></html>");
        lblNbrOfBlocksTitle.setBorder(null);
        lblNbrOfBlocksTitle.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblNbrOfBlocksTitle.setMaximumSize(new java.awt.Dimension(81, 21));
        lblNbrOfBlocksTitle.setMinimumSize(new java.awt.Dimension(81, 21));
        lblNbrOfBlocksTitle.setPreferredSize(new java.awt.Dimension(81, 21));

        lblNbrOfBlocks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNbrOfBlocks.setText("<OtherBlocks>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gLPnlEnemyArea1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblScoreTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblScore)
                            .addComponent(lblLevelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLevel)
                            .addComponent(lblNbrOfLinesTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNbrOfBlocksTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNbrOfLines)
                            .addComponent(lblNbrOfBlocks)))
                    .addComponent(lblPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gLPnlEnemyArea1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblScoreTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblScore)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLevelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLevel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNbrOfLinesTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNbrOfLines)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNbrOfBlocksTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNbrOfBlocks)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.media.opengl.awt.GLJPanel gLPnlEnemyArea1;
    private javax.swing.JLabel lblLevel;
    private javax.swing.JLabel lblLevelTitle;
    private javax.swing.JLabel lblNbrOfBlocks;
    private javax.swing.JLabel lblNbrOfBlocksTitle;
    private javax.swing.JLabel lblNbrOfLines;
    private javax.swing.JLabel lblNbrOfLinesTitle;
    private javax.swing.JLabel lblPlayerName;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblScoreTitle;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object o1) {
        lblScore.setText(Integer.toString(gameEngine.getScore()));
        lblLevel.setText(Integer.toString(gameEngine.getLevel()));
        lblNbrOfLines.setText(Integer.toString(gameEngine.getTotalRemovedLines()));
        lblNbrOfBlocks.setText(Integer.toString(gameEngine.getBlockCounter()));
    }

    public void initGLJPanel(SimulationStateAbstract gameEngine) {
        GameFieldRenderer rendererEnemyArea1 = new GameFieldRenderer(Config.EnemyGameFieldBlockSize, gameEngine, false);
        gLPnlEnemyArea1.addGLEventListener(rendererEnemyArea1);
        FPSAnimator animator1 = new FPSAnimator(gLPnlEnemyArea1, Config.frameRate, true);
        animator1.start();
    }
}
