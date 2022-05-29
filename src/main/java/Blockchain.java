import java.time.ZonedDateTime;
import java.util.ArrayList;

public class Blockchain {

    private ArrayList<Block> chain;
    static int difficulty;

    public Blockchain(ArrayList<Block> chain) {
        chain.add(createGenesisBlock());
        difficulty = 6;
        this.chain = chain;
    }

    public static Block createGenesisBlock(){
        return new Block(
                "0", ZonedDateTime.now(),new Data(0.0, "" , ""));
    }

    //retorna o ultimo block
    public static Block getLastBlock(ArrayList<Block> chain){
        return chain.get(chain.size() - 1);
    }

    //adiciona um block
    public static void addBlock(Block newBlock, Blockchain blockchain){
        newBlock.setPreviousHash(getLastBlock(blockchain.chain).getHash());
        newBlock.setHash(newBlock.mineBlock(difficulty, newBlock));
        blockchain.chain.add(newBlock);
    }

    public static boolean isChainValid(Blockchain blockchain){
        for (int i = 1; i < blockchain.chain.size(); i++){
            final Block currentBlock = blockchain.chain.get(i);
            final Block previousBlock = blockchain.chain.get(i-1);

            if (!currentBlock.getHash().equals(Hash.calculateHash(currentBlock.getIndex(), currentBlock.getTimestamp(), currentBlock.getData(), currentBlock.getNonce()))){
                return false;
            }

            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())){
                return false;
            }
        }
        return true;
    }
    public ArrayList<Block> getChain() {
        return chain;
    }

    public void setChain(ArrayList<Block> chain) {
        this.chain = chain;
    }
}
