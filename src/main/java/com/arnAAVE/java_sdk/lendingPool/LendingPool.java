package com.arnAAVE.java_sdk.lendingPool;


import lombok.Data;
import org.modelmapper.ModelMapper;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.awt.geom.Point2D;
import java.math.BigInteger;
import java.util.List;

@Data
public class LendingPool {
    private final ILendingPool lendingPool;
    private AaveConnect connection;

    private String lendingPoolAddressProvider;

    private final ModelMapper mapper = new ModelMapper();

    private ContractGasProvider provider;

    public LendingPool(AaveConnect connection, String lendingPoolAddressProvider, String gasFee, String gasLimit) throws Exception {
        this.connection = connection;
        this.lendingPoolAddressProvider = lendingPoolAddressProvider;
        this.provider = new StaticGasProvider(new BigInteger(gasFee),new BigInteger(gasLimit));
        ILendingPoolAddressesProvider lendingPoolAddress = new ILendingPoolAddressesProvider(lendingPoolAddressProvider,connection.getWeb3j(),connection.getCredentials(),provider);
        String poolAddress = lendingPoolAddress.getLendingPool().send();
        this.lendingPool = ILendingPool.load(poolAddress,connection.getWeb3j(),connection.getCredentials(),provider);
    }

    TransactionReceipt deposit(String amount, String assetAddress, String onBehalfOf) throws Exception {

        BigInteger value = new BigInteger(amount);

        return lendingPool.deposit(assetAddress, value, onBehalfOf, BigInteger.valueOf(0)).send();
    }

    List<ILendingPool.DepositEventResponse> depositEvents(Web3j web3j, TransactionReceipt transactionReceipt) throws Exception {

        return lendingPool.getDepositEvents(transactionReceipt);
    }

    ReserveData loadReservedData(String assetAddress) throws Exception {

        return mapper.map(lendingPool.getReserveData(assetAddress).send(), ReserveData.class);
    }

    TransactionReceipt withdraw(String amount, String assetAddress, String toAddress) throws Exception {
       BigInteger value = new BigInteger(amount);

        return lendingPool.withdraw(assetAddress,value,toAddress).send();
    }

    TransactionReceipt borrow(String amount, String assetAddress, String onBehalfOf) throws Exception {
        BigInteger value = new BigInteger(amount);

        return lendingPool.borrow(assetAddress,value, BigInteger.ONE,BigInteger.ZERO, onBehalfOf).send();
    }

    TransactionReceipt repay(String amount, String assetAddress, String onBehalfOf) throws Exception {
       BigInteger value = new BigInteger(amount);

       return lendingPool.repay(assetAddress,value,BigInteger.ONE,onBehalfOf).send();
    }

    TransactionReceipt swapBorrowRate(String assetAddress, String mode) throws Exception {
        BigInteger value = new BigInteger(mode);

        return lendingPool.swapBorrowRateMode(assetAddress,value).send();
    }

}
