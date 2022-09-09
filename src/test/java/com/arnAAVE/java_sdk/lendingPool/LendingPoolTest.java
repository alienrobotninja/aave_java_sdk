package com.arnAAVE.java_sdk.lendingPool;

import org.junit.jupiter.api.Test;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LendingPoolTest {


    @Test
    void lendingPoolDeposit() {
        String nodeUrl = "https://goerli.infura.io/v3/4b08a7529c7a4a24af5d26ce1fe16aca";
        String privateKey = "25fbeee7c1487f3af3bd5b3cfb443a8d48a8c9d406c6799bebca9d5fb9513ef2";

        TransactionReceipt depositReceipt = new TransactionReceipt();
        AaveConnect connection = new AaveConnect(privateKey,nodeUrl);

        LendingPool lendingPool = new LendingPool(connection,);
        try {
            depositReceipt = lendingPool.deposit("10000000","0xCCa7d1416518D095E729904aAeA087dBA749A4dC","0xeB538049D10e62ca319c9fF0c9FFF18bF2Ad968e");
        } catch (Exception e) {
            e.printStackTrace();
        }

//        try {
//            System.out.println(lendingPool.depositEvents(web3j, depositReceipt));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        System.out.println("Transaction hash: " + depositReceipt.getTransactionHash());
        System.out.println("The transaction address: " + depositReceipt.getContractAddress());
        System.out.println("The gas used: " + depositReceipt.getGasUsed());

//        List<ILendingPool.DepositEventResponse> depositEvent = lendingPool.getDepositEvents(depositReceipt);
//        System.out.println(depositEvent);
    }

    @Test
    void lendingPoolWithdraw() {
        String nodeUrl = "https://goerli.infura.io/v3/4b08a7529c7a4a24af5d26ce1fe16aca";
        TransactionReceipt withDrawReceipt = new TransactionReceipt();

        try {
            withDrawReceipt = lendingPool.lendingPoolWithdraw(nodeUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Transaction hash: " + withDrawReceipt.getTransactionHash());
        System.out.println("The transaction address: " + withDrawReceipt.getContractAddress());
        System.out.println("The gas used: " + withDrawReceipt.getGasUsed());
    }


    @Test
    void lendingPoolBurrow() {
        String nodeUrl = "https://goerli.infura.io/v3/4b08a7529c7a4a24af5d26ce1fe16aca";

        try {
            lendingPool.lendingPoolBurrow(nodeUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        assertTrue();
    }

    @Test
    void loadReservedData() {
        String nodeUrl = "https://goerli.infura.io/v3/4b08a7529c7a4a24af5d26ce1fe16aca";

        try {
            ReserveData assetReserve = lendingPool.loadReservedData(nodeUrl);
            System.out.println("aTokenAddress:" + assetReserve.aTokenAddress);
            System.out.println("The id: " + assetReserve.id);
            System.out.println("Last updated at: " + assetReserve.lastUpdateTimestamp);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}