package com.arnAAVE.java_sdk.lendingPool;

import org.modelmapper.ModelMapper;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

public class ProtocolDataProvider {
    private AaveConnect connection;

    private String lendingPoolAddressProvider;

    private ContractGasProvider provider;

    private ILendingPoolAddressesProvider lendingPoolAddress;

    public ProtocolDataProvider(AaveConnect connection, String lendingPoolAddressProvider, String gasFee) {
        this.connection = connection;
        this.lendingPoolAddressProvider = lendingPoolAddressProvider;
        this.provider = new StaticGasProvider(new BigInteger(gasFee),new BigInteger("3000000"));
        this.lendingPoolAddress = new ILendingPoolAddressesProvider(lendingPoolAddressProvider,connection.getWeb3j(),connection.getCredentials(),provider);
    }


}
