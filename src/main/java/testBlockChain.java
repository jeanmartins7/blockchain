import netscape.javascript.JSObject;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class testBlockChain {

    public static void main(String[] args) {

        var jeanCoin = new Blockchain(new ArrayList<>());
        var transection1 = new Block("1", ZonedDateTime.now(), new Data(1.1,
                UUID.randomUUID().toString(), UUID.randomUUID().toString()));
        var transection2 = new Block("2", ZonedDateTime.now(), new Data(1.1,
                UUID.randomUUID().toString(), UUID.randomUUID().toString()));

        System.out.println("mining block 1...");
        Blockchain.addBlock(transection1, jeanCoin);
        System.out.println(jeanCoin.getChain().get(1).getHash());
        System.out.println("mining block 2...");
        Blockchain.addBlock(transection2, jeanCoin);
        System.out.println(jeanCoin.getChain().get(2).getHash());



        System.out.println("blockChain is valid? " + Boolean.toString(Blockchain.isChainValid(jeanCoin)));
        Data datachange = new Data(100.00, UUID.randomUUID().toString(), UUID.randomUUID().toString());
        jeanCoin.getChain().get(1).setData(datachange);
        System.out.println("blockChain is valid? " + Boolean.toString(Blockchain.isChainValid(jeanCoin)));


    }


}
