/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.actions;

import domain.block.BlockAbstract;

/**
 *
 * @author chrigi
 */
public class GarbageLineAction extends Action{
    BlockAbstract[][] lines;

    public GarbageLineAction(long timestamp, BlockAbstract[][] line) {
        super(ActionType.NEWLINE, timestamp);
        this.lines = line;
    }

    
    public BlockAbstract[][] getLines() {
        return lines;
    }
    
}
