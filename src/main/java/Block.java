import java.lang.reflect.Array;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;

public class Block {
    private String index;
    private ZonedDateTime timestamp;
    private Data data;
    private String previousHash;
    private String hash;

    private int nonce;

    public Block(String index, ZonedDateTime timestamp, Data data) {
        previousHash = "0";
        this.index = index;
        this.timestamp = timestamp;
        this.data = data;
        this.previousHash = previousHash;
        this.nonce = 0;
        this.hash = Hash.calculateHash(index, timestamp, data, nonce);

    }

//    public String mineBlock(int difficulty){
//        String hash = null;
//        while (!this.getHash().substring(0, difficulty).equals(asList(String.valueOf(difficulty + 1)).stream().collect(joining("0")))){
//
//            this.setNonce(this.getNonce() + 1);
//            hash += Hash.calculateHash(this.getIndex(), this.getTimestamp(), this.getData(), this.getNonce());
//        }
//
//        return hash;
//    }

    public String mineBlock(int difficulty, Block block){
        String hash = block.getHash();
        String[] arrayDifficulty = new String[difficulty];
        Arrays.fill(arrayDifficulty, "0");
        while (!hash.substring(0, difficulty).equals(Arrays.stream(arrayDifficulty).collect(joining()))){

            block.setNonce(block.getNonce() + 1);
            hash = Hash.calculateHash(block.getIndex(), block.getTimestamp(), block.getData(), block.getNonce());
        }
        return hash;
    }


    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }
}
