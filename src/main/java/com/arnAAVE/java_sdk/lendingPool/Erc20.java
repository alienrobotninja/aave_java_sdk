package com.arnAAVE.java_sdk.lendingPool;

import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

public class Erc20 {
    private final AaveConnect connection;

    private final ContractGasProvider provider;
    private final String assetAddress;

    public Erc20(AaveConnect connection, String gasFee, String assetAddress) {
        this.connection = connection;
        this.provider = new StaticGasProvider(new BigInteger(gasFee),new BigInteger("3000000"));
        this.assetAddress = assetAddress;
    }

    public TransactionReceipt approve(String amount) throws Exception {
        IERC20 erc20 = new IERC20(assetAddress,connection.getWeb3j(),connection.getCredentials(),provider);

        return erc20.approve(connection.getCredentials().getAddress(),new BigInteger(amount)).send();
    }
}
