package com.arnAAVE.java_sdk.lendingPool;

import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

public class WethGateway {
    private final AaveConnect connection;

    private final ContractGasProvider provider;
    private final String assetAddress;

    public WethGateway(AaveConnect connection, String assetAddress, String gasFee, String gasLimit) {
        this.connection = connection;
        this.provider = new StaticGasProvider(new BigInteger(gasFee),new BigInteger(gasLimit));
        this.assetAddress = assetAddress;
    }

    TransactionReceipt depositEth(String onBehalfOf, String poolAddress) throws Exception {
        IWETHGateway weth = new IWETHGateway(assetAddress,connection.getWeb3j(),connection.getCredentials(),provider);
        return weth.depositETH(poolAddress,onBehalfOf, BigInteger.ZERO).send();
    }


}
