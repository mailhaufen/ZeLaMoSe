package view;

import com.jogamp.opengl.util.FPSAnimator;
import domain.Config;
import domain.InputSampler;
import domain.SimulationStateAbstract;
import java.awt.KeyboardFocusManager;
import java.util.Observable;
import java.util.Observer;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.swing.SwingUtilities;
import view.music.MusicFile;
import view.music.SoundEngine;

/**
 *
 * @author Patrick Zenhäusern <pzenhaeu@hsr.ch>
 */
public class OwnGameFieldJPanel extends javax.swing.JPanel implements Observer {

    private boolean useSound = false;
    private SoundEngine soundEngine = new SoundEngine();

    /**
     * Creates new form pnlGameField
     */
    public OwnGameFieldJPanel() {
        initComponents();


    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code.
     * The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        glPnlGameField = new javax.media.opengl.awt.GLJPanel(getGLCaps());
        lblNextPiece = new javax.swing.JLabel();
        lblYourScoreValue = new javax.swing.JLabel();
        tglSound = new javax.swing.JToggleButton();
        lblPlayerName = new javax.swing.JLabel();
        lblZeLaMoSe = new javax.swing.JLabel();
        lblLevelValue = new javax.swing.JLabel();
        lblLevel = new javax.swing.JLabel();
        lblNumberOfLinesValue = new javax.swing.JLabel();
        glPnlNextBlock = new javax.media.opengl.awt.GLJPanel(getGLCaps());
        lblBlockCounter1 = new javax.swing.JLabel();
        lblJokerValue = new javax.swing.JLabel();
        lblNbrOfLines1 = new javax.swing.JLabel();
        lblJoker1 = new javax.swing.JLabel();
        lblNbrOfBlocks = new javax.swing.JLabel();
        lblScore1 = new javax.swing.JLabel();

        glPnlGameField.setPreferredSize(new java.awt.Dimension(360, 660));

        javax.swing.GroupLayout glPnlGameFieldLayout = new javax.swing.GroupLayout(glPnlGameField);
        glPnlGameField.setLayout(glPnlGameFieldLayout);
        glPnlGameFieldLayout.setHorizontalGroup(
            glPnlGameFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        glPnlGameFieldLayout.setVerticalGroup(
            glPnlGameFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );

        lblNextPiece.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNextPiece.setText("<html><b>Next Piece:</b></html>");
        lblNextPiece.setBorder(null);
        lblNextPiece.setMaximumSize(new java.awt.Dimension(81, 18));
        lblNextPiece.setMinimumSize(new java.awt.Dimension(81, 18));
        lblNextPiece.setPreferredSize(new java.awt.Dimension(81, 18));

        lblYourScoreValue.setText("<YourScoreValue>");

        tglSound.setSelected(true);
        tglSound.setText("Sound on");
        tglSound.setFocusable(false);
        tglSound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglSoundActionPerformed(evt);
            }
        });

        lblPlayerName.setText("<PlayerName>");

        lblZeLaMoSe.setText("© ZeLaMoSe");

        lblLevelValue.setText("<LevelValue>");

        lblLevel.setText("<html><b>Level:</b></html>");
        lblLevel.setBorder(null);
        lblLevel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblLevel.setMaximumSize(new java.awt.Dimension(81, 21));
        lblLevel.setMinimumSize(new java.awt.Dimension(81, 21));
        lblLevel.setPreferredSize(new java.awt.Dimension(81, 21));

        lblNumberOfLinesValue.setText("<NumberOfLinesValue>");

        glPnlNextBlock.setMaximumSize(new java.awt.Dimension(160, 160));
        glPnlNextBlock.setMinimumSize(new java.awt.Dimension(160, 160));
        glPnlNextBlock.setPreferredSize(new java.awt.Dimension(160, 160));

        javax.swing.GroupLayout glPnlNextBlockLayout = new javax.swing.GroupLayout(glPnlNextBlock);
        glPnlNextBlock.setLayout(glPnlNextBlockLayout);
        glPnlNextBlockLayout.setHorizontalGroup(
            glPnlNextBlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        glPnlNextBlockLayout.setVerticalGroup(
            glPnlNextBlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        lblBlockCounter1.setText("<YourBlocksValue>");

        lblJokerValue.setText("<JokerValue>");

        lblNbrOfLines1.setText("<html><b>Number of Lines:</b></html>");
        lblNbrOfLines1.setBorder(null);
        lblNbrOfLines1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblNbrOfLines1.setMaximumSize(new java.awt.Dimension(81, 21));
        lblNbrOfLines1.setMinimumSize(new java.awt.Dimension(81, 21));
        lblNbrOfLines1.setPreferredSize(new java.awt.Dimension(81, 21));

        lblJoker1.setText("<html><b>Joker:</b></html>");
        lblJoker1.setBorder(null);
        lblJoker1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblJoker1.setMaximumSize(new java.awt.Dimension(81, 21));
        lblJoker1.setMinimumSize(new java.awt.Dimension(81, 21));
        lblJoker1.setPreferredSize(new java.awt.Dimension(81, 21));

        lblNbrOfBlocks.setText("<html><b>Number of Blocks:</b></html>");
        lblNbrOfBlocks.setBorder(null);
        lblNbrOfBlocks.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblNbrOfBlocks.setMaximumSize(new java.awt.Dimension(81, 21));
        lblNbrOfBlocks.setMinimumSize(new java.awt.Dimension(81, 21));
        lblNbrOfBlocks.setPreferredSize(new java.awt.Dimension(81, 21));

        lblScore1.setText("<html><b>Score:</b></html>");
        lblScore1.setBorder(null);
        lblScore1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblScore1.setMaximumSize(new java.awt.Dimension(81, 21));
        lblScore1.setMinimumSize(new java.awt.Dimension(81, 21));
        lblScore1.setPreferredSize(new java.awt.Dimension(81, 21));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(glPnlGameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblNextPiece, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(glPnlNextBlock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblBlockCounter1)
                                .addComponent(lblLevelValue)
                                .addComponent(lblJokerValue)
                                .addComponent(lblNumberOfLinesValue)
                                .addComponent(lblJoker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblScore1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblNbrOfBlocks, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                    .addComponent(lblNbrOfLines1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(lblYourScoreValue)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(132, 132, 132)
                            .addComponent(lblZeLaMoSe)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tglSound)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tglSound)
                .addGap(8, 8, 8)
                .addComponent(lblPlayerName)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(glPnlGameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblScore1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblYourScoreValue)
                        .addGap(18, 18, 18)
                        .addComponent(lblLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLevelValue)
                        .addGap(74, 74, 74)
                        .addComponent(lblJoker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblJokerValue)
                        .addGap(69, 69, 69)
                        .addComponent(lblNbrOfLines1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNumberOfLinesValue)
                        .addGap(18, 18, 18)
                        .addComponent(lblNbrOfBlocks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBlockCounter1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNextPiece, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(glPnlNextBlock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(lblZeLaMoSe)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tglSoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglSoundActionPerformed

        if (useSound) {
            tglSound.setText("Sound On");
            soundEngine.playBackgroundMusic(MusicFile.gameBackgroundMusic);
            gameEngine.addObserver(soundEngine);
        } else {
            tglSound.setText("Sound Off");
            soundEngine.stopBackGroundMusic(MusicFile.gameBackgroundMusic);
            gameEngine.deleteObserver(soundEngine);
        }

        useSound = !useSound;
    }//GEN-LAST:event_tglSoundActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.media.opengl.awt.GLJPanel glPnlGameField;
    private javax.media.opengl.awt.GLJPanel glPnlNextBlock;
    private javax.swing.JLabel lblBlockCounter1;
    private javax.swing.JLabel lblJoker1;
    private javax.swing.JLabel lblJokerValue;
    private javax.swing.JLabel lblLevel;
    private javax.swing.JLabel lblLevelValue;
    private javax.swing.JLabel lblNbrOfBlocks;
    private javax.swing.JLabel lblNbrOfLines1;
    private javax.swing.JLabel lblNextPiece;
    private javax.swing.JLabel lblNumberOfLinesValue;
    private javax.swing.JLabel lblPlayerName;
    private javax.swing.JLabel lblScore1;
    private javax.swing.JLabel lblYourScoreValue;
    private javax.swing.JLabel lblZeLaMoSe;
    private javax.swing.JToggleButton tglSound;
    // End of variables declaration//GEN-END:variables
    private GameFieldRenderer renderer;
    private SimulationStateAbstract gameEngine;

    public void initRenderer(SimulationStateAbstract gameEngine) {
        this.gameEngine = gameEngine;
        gameEngine.addObserver(this);
        gameEngine.addObserver(soundEngine);
        initOwnGameFieldRenderer();
        initNextBlockRenderer();
        soundEngine.playBackgroundMusic(MusicFile.gameBackgroundMusic);


    }

    public void setInputSampler(InputSampler is) {
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(is);
    }

    private GLCapabilities getGLCaps() {
        //best GL settings
        GLProfile glp = GLProfile.getDefault();
        return new GLCapabilities(glp);
    }

    @Override
    public void update(Observable o, Object arg) {
        final SimulationStateAbstract ge = (SimulationStateAbstract) o;
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                lblLevelValue.setText(Integer.toString(ge.getLevel()));
                lblYourScoreValue.setText(Integer.toString(ge.getScore()));
                lblNumberOfLinesValue.setText(Integer.toString(ge.getTotalRemovedLines()));
                lblBlockCounter1.setText(Integer.toString(ge.getBlockCounter()));
                lblJokerValue.setText(Integer.toString(ge.getNumberOfJokers()));
            }
        });


    }

    private void initOwnGameFieldRenderer() {
        renderer = new GameFieldRenderer(Config.ownGameFieldBlockSize, gameEngine, true);
        glPnlGameField.addGLEventListener(renderer);
        FPSAnimator ownGameFieldAnimator = new FPSAnimator(glPnlGameField, Config.frameRate, true);
        ownGameFieldAnimator.start();
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                lblPlayerName.setText(gameEngine.getNickName());
            }
        });
    }

    private void initNextBlockRenderer() {

        glPnlNextBlock.addGLEventListener(new NextBlockRenderer(gameEngine));
        FPSAnimator ownGameFieldAnimator = new FPSAnimator(glPnlNextBlock, Config.frameRate, true);
        ownGameFieldAnimator.start();
    }
}
