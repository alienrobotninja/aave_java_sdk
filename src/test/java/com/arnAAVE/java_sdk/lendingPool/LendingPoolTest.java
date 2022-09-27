package com.arnAAVE.java_sdk.lendingPool;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigInteger;
import java.util.ArrayList;

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

        try {
            lendingPool = new LendingPool(connection, "0x5E52dEc931FFb32f609681B8438A51c675cc232d","20000000","30000000");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testConnection() {
        log.info("client version -> {}", connection.getClientVersion());
//        System.out.println("Client version " + connection.getClientVersion());
        assertTrue(connection.getClientVersion().contains("Geth"));
    }
    @Test
    void protocolDataProvider(){
        ProtocolDataProvider dataProvider = new ProtocolDataProvider(connection,"0x5E52dEc931FFb32f609681B8438A51c675cc232d","2000000");

        try {
            System.out.println(dataProvider.getAllATokens());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testApprove(){
        Erc20 erc20 = new Erc20(connection,"2000000","0xCCa7d1416518D095E729904aAeA087dBA749A4dC");
        TransactionReceipt erc20Receipt = new TransactionReceipt();
        try {
            erc20Receipt = erc20.approve("10000000");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Transaction hash: " + erc20Receipt.getTransactionHash());
        System.out.println("The transaction address: " + erc20Receipt.getContractAddress());
        System.out.println("The gas used: " + erc20Receipt.getGasUsed());
    }
    @Test
    void testTotalPoolSupply(){
        Erc20 erc20 = new Erc20(connection,"2000000","0xCCa7d1416518D095E729904aAeA087dBA749A4dC");

        try {
            log.info("total balance -{}", erc20.supplyBalance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testAddressPoolBalance(){
        Erc20 erc20 = new Erc20(connection,"2000000","0xCCa7d1416518D095E729904aAeA087dBA749A4dC");

        try {
            log.info("Your balance -{}", erc20.balanceOf("0xeB538049D10e62ca319c9fF0c9FFF18bF2Ad968e"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testWethGateway() {
        WethGateway weth = new WethGateway(connection,"0x3bd3a20Ac9Ff1dda1D99C0dFCE6D65C4960B3627","2000000","3000000");
//        WethGateway weth = new WethGateway(connection,"0x6cf3eeAAe068CB8087Ea9e857170f2Ba251F83bF","2000000","3000000");
        TransactionReceipt wethReceipt = null;
        try {
            wethReceipt = weth.depositEth("0xeB538049D10e62ca319c9fF0c9FFF18bF2Ad968e","0x4bd5643ac6f66a5237E18bfA7d47cF22f1c9F210");
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("Weth Receipt -{}",wethReceipt);
    }

    @Test
    void testWethGatewayWithDraw() {
        WethGateway weth = new WethGateway(connection,"0x3bd3a20Ac9Ff1dda1D99C0dFCE6D65C4960B3627","2000000","3000000");
//        WethGateway weth = new WethGateway(connection,"0x6cf3eeAAe068CB8087Ea9e857170f2Ba251F83bF","2000000","3000000");
        TransactionReceipt wethReceipt = null;
        try {
            wethReceipt = weth.withdrawEth("0xeB538049D10e62ca319c9fF0c9FFF18bF2Ad968e","1000000","0x4bd5643ac6f66a5237E18bfA7d47cF22f1c9F210");
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("Weth Receipt -{}",wethReceipt);
    }

    @Test
    void lendingPoolDeposit() {
        Erc20 erc20 = new Erc20(connection,"2000000","0xCCa7d1416518D095E729904aAeA087dBA749A4dC");

        TransactionReceipt depositReceipt = new TransactionReceipt();

        try {
            erc20.approve("100000000000");
            depositReceipt = lendingPool.deposit("100000000000","0xCCa7d1416518D095E729904aAeA087dBA749A4dC","0xeB538049D10e62ca319c9fF0c9FFF18bF2Ad968e");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            log.info("the list is - {} ",lendingPool.depositEvents(connection.getWeb3j(), depositReceipt));
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("Deposit hash: " + depositReceipt.getTransactionHash());
        log.info("Deposit address: " + depositReceipt.getContractAddress());
        log.info("Deposit gas used: " + depositReceipt.getGasUsed());
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
    void testSwapBorrowRate(){
        TransactionReceipt rateReceipt = new TransactionReceipt();

        try {
            rateReceipt = lendingPool.swapBorrowRate("0xCCa7d1416518D095E729904aAeA087dBA749A4dC", "1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(rateReceipt.getTransactionHash());
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