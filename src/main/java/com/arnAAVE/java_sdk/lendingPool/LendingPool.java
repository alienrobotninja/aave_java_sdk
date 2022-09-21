package com.arnAAVE.java_sdk.lendingPool;


import lombok.Data;
import org.modelmapper.ModelMapper;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;
import java.util.List;

@Data
public class LendingPool {
    private AaveConnect connection;

    private String lendingPoolAddressProvider;

    private final ModelMapper mapper = new ModelMapper();

    private ContractGasProvider provider;

    private ILendingPoolAddressesProvider lendingPoolAddress;

    public LendingPool(AaveConnect connection, String lendingPoolAddressProvider, String gasFee, String gasLimit) {
        this.connection = connection;
        this.lendingPoolAddressProvider = lendingPoolAddressProvider;
        this.provider = new StaticGasProvider(new BigInteger(gasFee),new BigInteger(gasLimit));
        this.lendingPoolAddress = new ILendingPoolAddressesProvider(lendingPoolAddressProvider,connection.getWeb3j(),connection.getCredentials(),provider);
    }

    TransactionReceipt deposit(String amount, String assetAddress, String onBehalfOf) throws Exception {
        String poolAddress = lendingPoolAddress.getLendingPool().send();
        ILendingPool lendingPool = ILendingPool.load(poolAddress,connection.getWeb3j(),connection.getCredentials(),provider);
        BigInteger value = new BigInteger(amount);

        return lendingPool.deposit(assetAddress, value, onBehalfOf, BigInteger.valueOf(0)).send();
    }

    List<ILendingPool.DepositEventResponse> depositEvents(Web3j web3j, TransactionReceipt transactionReceipt) throws Exception {
        ContractGasProvider provider = new StaticGasProvider(new BigInteger("2000000"),new BigInteger("2000000"));
        ILendingPoolAddressesProvider lendingPoolAddressesProvider = new ILendingPoolAddressesProvider("0x5E52dEc931FFb32f609681B8438A51c675cc232d",connection.getWeb3j(),connection.getCredentials(),provider);
        RemoteFunctionCall<String> address = lendingPoolAddressesProvider.getLendingPool();
        String poolAddress = address.send();
        ILendingPool lendingPool = ILendingPool.load(poolAddress,connection.getWeb3j(),connection.getCredentials(),provider);
        return lendingPool.getDepositEvents(transactionReceipt);
    }

    ReserveData loadReservedData(String assetAddress) throws Exception {
        String poolAddress = lendingPoolAddress.getLendingPool().send();

        ILendingPool lendingPool = ILendingPool.load(poolAddress,connection.getWeb3j(),connection.getCredentials(),provider);

        return mapper.map(lendingPool.getReserveData(assetAddress).send(), ReserveData.class);
    }

    TransactionReceipt withdraw(String amount, String assetAddress, String toAddress) throws Exception {
        String poolAddress = lendingPoolAddress.getLendingPool().send();
        BigInteger value = new BigInteger(amount);

        ILendingPool lendingPool = ILendingPool.load(poolAddress,connection.getWeb3j(),connection.getCredentials(),provider);
        return lendingPool.withdraw(assetAddress,value,toAddress).send();
    }

    TransactionReceipt borrow(String amount, String assetAddress, String onBehalfOf) throws Exception {
        String poolAddress = lendingPoolAddress.getLendingPool().send();
        BigInteger value = new BigInteger(amount);

        ILendingPool lendingPool = ILendingPool.load(poolAddress,connection.getWeb3j(),connection.getCredentials(),provider);
        return lendingPool.borrow(assetAddress,value, BigInteger.ONE,BigInteger.ZERO, onBehalfOf).send();
    }

    TransactionReceipt repay(String amount, String assetAddress, String onBehalfOf) throws Exception {
        String poolAddress = lendingPoolAddress.getLendingPool().send();
        BigInteger value = new BigInteger(amount);

        ILendingPool lendingPool = ILendingPool.load(poolAddress,connection.getWeb3j(),connection.getCredentials(),provider);
       
        return lendingPool.repay(assetAddress,value,BigInteger.ONE,onBehalfOf).send();
    }

    TransactionReceipt swapBorrowRate(String amount, String assetAddress, String onBehalfOf) throws Exception {
        String poolAddress = lendingPoolAddress.getLendingPool().send();
        BigInteger value = new BigInteger(amount);

        ILendingPool lendingPool = ILendingPool.load(poolAddress,connection.getWeb3j(),connection.getCredentials(),provider);
        return lendingPool.swapBorrowRateMode(assetAddress,BigInteger.ONE).send();
    }

}
