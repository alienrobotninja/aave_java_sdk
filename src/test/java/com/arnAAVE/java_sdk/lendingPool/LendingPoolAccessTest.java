package com.arnAAVE.java_sdk.lendingPool;

import org.junit.jupiter.api.Test;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LendingPoolAccessTest {
    LendingPoolAccess lendingPool = new LendingPoolAccess();

    @Test
    void lendingPoolDeposit() {
        String nodeUrl = "https://goerli.infura.io/v3/4b08a7529c7a4a24af5d26ce1fe16aca";
        TransactionReceipt depositReceipt = new TransactionReceipt();

        try {
            depositReceipt = lendingPool.lendingPoolDeposit(nodeUrl);
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