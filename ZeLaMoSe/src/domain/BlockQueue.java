/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.block.BlockAbstract;
import domain.block.BlockType;
import domain.block.GarbageBlock;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Cyrill Lam <clam@hsr.ch>
 */
public class BlockQueue implements BlockQueueInterface {

    private Random randomGenerator;
    private List<BlockType> blocksProbability;
    private int blockCounter;
    /**
     * initalise blockqueue with given seed to make sure it's always the same order
     *
     * @param seed
     *
     */
    private long seed;
    public BlockQueue(long seed) {
        randomGenerator = new Random(seed);
        blockCounter = 0;
        this.seed = seed;
        fillBlockList();
    }

    @Override
    public BlockAbstract getNextBlock() {
        BlockAbstract returnValue;
        returnValue = blocksProbability.get(randomGenerator.nextInt(blocksProbability.size())).createBlock(++blockCounter,seed);
        return returnValue;
    }

    private void fillBlockList() {
        blocksProbability = new ArrayList<BlockType>();
        for(BlockType blockType : BlockType.values()){
            for(int i = 0; i < blockType.getProbability(); i++){
                blocksProbability.add(blockType);
            }
        }
    }
    
    
}
