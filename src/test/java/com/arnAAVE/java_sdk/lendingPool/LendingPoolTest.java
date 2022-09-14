package com.arnAAVE.java_sdk.lendingPool;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class LendingPoolTest {
    private AaveConnect connection;

    private LendingPool lendingPool;

    @BeforeEach
    void connection(){
        String nodeUrl = "https://goerli.infura.io/v3/4b08a7529c7a4a24af5d26ce1fe16aca";
        String privateKey = "25fbeee7c1487f3af3bd5b3cfb443a8d48a8c9d406c6799bebca9d5fb9513ef2";

        connection = new AaveConnect(privateKey,nodeUrl);

        lendingPool = new LendingPool(connection, "0x5E52dEc931FFb32f609681B8438A51c675cc232d");
    }

    @Test
    void testConnection() {
        log.info("client version -> {}", connection.getClientVersion());
//        System.out.println("Client version " + connection.getClientVersion());
        assertTrue(connection.getClientVersion().contains("Geth"));
    }


    @Test
    void lendingPoolDeposit() {
        TransactionReceipt depositReceipt = new TransactionReceipt();

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
       TransactionReceipt withDrawReceipt = new TransactionReceipt();

        try {
            withDrawReceipt = lendingPool.withdraw("100000","0xb597cd8d3217ea6477232f9217fa70837ff667af","0xb597cd8d3217ea6477232f9217fa70837ff667af");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Transaction hash: " + withDrawReceipt.getTransactionHash());
        System.out.println("The transaction address: " + withDrawReceipt.getContractAddress());
        System.out.println("The gas used: " + withDrawReceipt.getGasUsed());
    }


    @Test
    void lendingPoolBorrow() {
        TransactionReceipt borrowReceipt = new TransactionReceipt();

        try {
            borrowReceipt = lendingPool.borrow("10000", "0xb597cd8d3217ea6477232f9217fa70837ff667af", "0xeB538049D10e62ca319c9fF0c9FFF18bF2Ad968e");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(borrowReceipt.getTransactionHash());
//        assertTrue();
    }

    @Test
    void testLendingPoolRepay(){
        TransactionReceipt repayReceipt = new TransactionReceipt();

        try {
            repayReceipt = lendingPool.repay("10000", "0xb597cd8d3217ea6477232f9217fa70837ff667af", "0xb597cd8d3217ea6477232f9217fa70837ff667af");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(repayReceipt.getTransactionHash());
    }

    @Test
    void loadReservedData() {

        try {
            ReserveData assetReserve = lendingPool.loadReservedData("0x075a36ba8846c6b6f53644fdd3bf17e5151789dc");
            System.out.println("aTokenAddress:" + assetReserve.aTokenAddress);
            System.out.println("The id: " + assetReserve.id);
            System.out.println("Last updated at: " + assetReserve.lastUpdateTimestamp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void setUsageAsCollateral(){

    }

    @Test
    void liquidationCall(){

    }

    @Test
    void flashloans(){

    }
}