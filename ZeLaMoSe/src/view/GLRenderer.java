/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import domain.GameEngine;
import domain.actions.*;
import domain.block.Block;
import domain.actions.RotateAction.Direction;
import java.awt.Color;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.media.opengl.*;
import javax.media.opengl.fixedfunc.GLMatrixFunc;
import javax.media.opengl.glu.GLU;

/**
 *
 * @author Cyrill
 */
class GLRenderer implements GLEventListener, Observer {

    private boolean debug = true;
    private int viewportWidth, viewportHeight, blocksize;
    private final int gridWidth = 12, gridHeight = 24;
    private GameEngine engine;
    private Block currentBlock;
    private final int defaultX = 4, defaultY = 23;
    private Color[][] grid;
    private Color bgColor = Color.BLACK;
    private Color garbageLineColor = new Color(139, 0, 0);

    public GLRenderer(int width, int height, int blocksize) {
        this.viewportWidth = width;
        this.viewportHeight = height;
        this.blocksize = blocksize;
        initStackGrid();
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        GLU glu = new GLU();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glLineWidth(1.0f);
        gl.glViewport(0, 0, viewportWidth, viewportHeight);
        gl.glMatrixMode(GLMatrixFunc.GL_PROJECTION);
        gl.glLoadIdentity();

        if (debug) {
            glu.gluOrtho2D(-100, viewportWidth + 100, -100, viewportHeight + 100);
        } else {
            glu.gluOrtho2D(0, viewportWidth, 0, viewportHeight);
        }
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        if (currentBlock != null) {


            GL2 gl = drawable.getGL().getGL2();
            gl.glClear(GL.GL_COLOR_BUFFER_BIT);


            drawStackGrid(gl);
            drawCurrentBlock(gl);

            drawGridLines(gl);
        }
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    void setEngine(GameEngine fakeGameEngine) {
        engine = fakeGameEngine;
        engine.addObserver(this);

    }

    @Override
    public void update(Observable o, Object o1) {
        handleActions(engine.getSimulationState());
    }

//   - rotation (direction): rotate current block in direction by 90
// * - move (direction, speed): move block in direction (left, right, down) with speed (number of grids) 
// * - rmline (number of lines, offset): remove a number of lines, first with offset from bottom
// * - newline (line definition): add new line to bottom. line according to supplied definition
// * - A new block enters the game
    private void handleActions(Action action) {
        
        switch (action.getType()) {
            case ROTATION:
                handleRotateAction(((RotateAction) action).getDirection());
                break;
            case MOVE:
                handleMoveAction((MoveAction) action);
                break;
            case NEWBLOCK:
                HandleNewblockAction(((NewblockAction) action).getBlocktype());
                break;
            case NEWLINE:
                handleNewlineAction(((NewlineAction) action).getLine());
                break;
            case RMLINE:
                handleRmlineAction((RmlineAction) action);
                break;
        }
        if(debug){
            System.out.println("GLREnderer: actiontype recieved "+action.getType());
        }
    }

    private void drawGridLines(GL2 gl) {


        float red, green, blue;
        ////////////////////
        //drawing the grid
        red = 0.2f;
        green = 0.2f;
        blue = 0.2f;

        gl.glColor3f(red, green, blue);

        gl.glBegin(GL.GL_LINES);

        //draw the vertical lines
        for (int x = 0; x <= viewportWidth; x += blocksize) {
            gl.glVertex2d(x, 0);
            gl.glVertex2d(x, viewportHeight);
        }

        //draw the horizontal lines
        for (int y = 0; y <= viewportHeight; y += blocksize) {
            gl.glVertex2d(0, y);
            gl.glVertex2d(viewportWidth, y);
        }

        gl.glEnd();
    }

    private void drawCurrentBlock(GL2 gl) {
        Color blockColor = currentBlock.getColor();

        gl.glColor3f(blockColor.getRed(), blockColor.getGreen(), blockColor.getBlue());

        gl.glBegin(GL2.GL_QUADS);
        int x = currentBlock.getX();
        int y = currentBlock.getY();
        boolean[][] grid = currentBlock.getBlockGrid();
        for (int a = 0; a < grid.length; a++) {
            for (int b = 0; b < grid.length; b++) {
                if (grid[a][b]) {
                    gl.glVertex2i(blocksize * (x + a), blocksize * (y - b+1));
                    gl.glVertex2i(blocksize * (x + a), blocksize * (y - b));
                    gl.glVertex2i(blocksize * (x + 1 + a), blocksize * (y - b));
                    gl.glVertex2i(blocksize * (x + 1 + a), blocksize * (y - b+1));
                }
            }
        }
        gl.glEnd();
    }

    private void initStackGrid() {
        grid = new Color[gridWidth][gridHeight];
        for (int i = 0; i < gridWidth; i++) {
            for (int j = 0; j < gridHeight; j++) {
                grid[i][j] = bgColor;
            }
        }
    }

    private void drawStackGrid(GL2 gl) {

        for (int i = 0; i < gridWidth; i++) {
            for (int j = 0; j < gridHeight; j++) {

                Color colorField = grid[i][j];
                gl.glColor3f(colorField.getRed(), colorField.getGreen(), colorField.getBlue());

                gl.glBegin(GL2.GL_QUADS);

                gl.glVertex2i(blocksize * i, blocksize * (j + 1));
                gl.glVertex2i(blocksize * i, blocksize * (j));
                gl.glVertex2i(blocksize * (i + 1), blocksize * (j));
                gl.glVertex2i(blocksize * (i + 1), blocksize * (j + 1));

                gl.glEnd();
            }
        }


    }

    private void saveCurrentblockToGrid() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (currentBlock.getBlockGrid()[i][j]) {
                    grid[currentBlock.getX() +i][currentBlock.getY() - j] = currentBlock.getColor();
                }
            }
        }
    }

    private void handleRotateAction(Direction direction) {
        if (direction == Direction.LEFT) {
            currentBlock.rotateLeft();
        } else {
            currentBlock.rotateRight();
        }
    }

    private void handleMoveAction(MoveAction action) {
        switch (action.getDirection()) {
            case DOWN:
                currentBlock.setY(currentBlock.getY() - action.getSpeed());
                break;
            case LEFT:
                currentBlock.setX(currentBlock.getX() - action.getSpeed());
                break;
            case RIGHT:
                currentBlock.setX(currentBlock.getX() + action.getSpeed());
                break;
        }
    }

    private void HandleNewblockAction(Block block) {
        if ((currentBlock != null)) {


            saveCurrentblockToGrid();
        }
        currentBlock = (Block)block.clone();
        currentBlock.setX(defaultX);
        currentBlock.setY(defaultY);

    }

    private void handleNewlineAction(boolean[][] line) {

        for (int i = 0; i < gridWidth; i++) {
            for (int j = gridHeight - 1 - line[0].length; j >= 0; j--) {
                grid[i][j + line[0].length] = grid[i][j];
            }
        }

        for (int i = 0; i < line.length; i++) {
            for (int j = 0; j < line[i].length; j++) {
                if (line[i][j]) {
                    grid[i][j] = garbageLineColor;
                } else {
                    grid[i][j] = bgColor;
                }
            }
        }
    }

    private void handleRmlineAction(RmlineAction rmlineAction) {
        saveCurrentblockToGrid();
        currentBlock=null;
        printGrid();
        List<Integer> linesToRemove = rmlineAction.getLinesToRemove();

        //TODO lines must be removed from top to bottom - because
        //else the line Number in getLinesToRemove is wrong
        for (int i = 0; i < gridWidth; i++) {
            for(Integer j : linesToRemove) {
                grid[i][23-j-1] = grid[i][23-j];
            }
        }
        printGrid();

    }
    
    public void printGrid() {
        for (int i = gridHeight-1; i >= 0; i--) {
            String lineOutput = "";
            for (int j = 0; j < gridWidth; j++) {
                if (grid[j][i] != bgColor) {
                    lineOutput += "[X]";
                } else {
                    lineOutput += "[ ]";
                }
            }
            System.out.println(lineOutput);
        }
        System.out.println("");
    }
}
