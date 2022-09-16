package com.arnAAVE.java_sdk.lendingPool;

import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;
import java.util.List;

public class ProtocolDataProvider {
    private AaveConnect connection;

    private String lendingPoolAddressProvider;

    private ContractGasProvider provider;

    private ILendingPoolAddressesProvider lendingPoolProvider;

    public ProtocolDataProvider(AaveConnect connection, String lendingPoolAddressProvider, String gasFee) {
        this.connection = connection;
        this.lendingPoolAddressProvider = lendingPoolAddressProvider;
        this.provider = new StaticGasProvider(new BigInteger(gasFee), new BigInteger("3000000"));
        this.lendingPoolProvider = new ILendingPoolAddressesProvider(lendingPoolAddressProvider, connection.getWeb3j(), connection.getCredentials(), provider);
    }

    List getAllATokens() throws Exception {
        byte[] bytes = {0x1};
        String protocolAddress = lendingPoolProvider.getAddress(bytes).send();
        IProtocolDataProvider dataProvider = new IProtocolDataProvider(protocolAddress, connection.getWeb3j(), connection.getCredentials(), provider);
        return dataProvider.getAllATokens().send();
    }
}
