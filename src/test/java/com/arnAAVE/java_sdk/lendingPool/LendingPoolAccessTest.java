package com.arnAAVE.java_sdk.lendingPool;

import org.junit.jupiter.api.Test;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

import static org.junit.jupiter.api.Assertions.*;

class LendingPoolAccessTest {
    LendingPoolAccess lendingPool = new LendingPoolAccess();
    @Test
    void lendingPoolDeposit() {
        Web3j web3j = Web3j.build(new HttpService(
                "https://goerli.infura.io/v3/4b08a7529c7a4a24af5d26ce1fe16aca"));
        TransactionReceipt depositReceipt = new TransactionReceipt();

        try {
            depositReceipt = lendingPool.lendingPoolDeposit(web3j);
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
    }

    @Test
    void lendingPoolBurrow() {
    }
}