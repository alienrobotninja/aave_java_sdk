package com.arnAAVE.java_sdk.lendingPool;

import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

public class WethGateway {
    private final AaveConnect connection;

    private final String assetAddress;
    private IWETHGateway weth;

    public WethGateway(AaveConnect connection, String assetAddress, String gasFee, String gasLimit) {
        this.connection = connection;
        ContractGasProvider provider = new StaticGasProvider(new BigInteger(gasFee),new BigInteger(gasLimit));
        this.assetAddress = assetAddress;
        weth = new IWETHGateway(assetAddress,connection.getWeb3j(),connection.getCredentials(),provider);
    }

    public TransactionReceipt depositEth(String onBehalfOf, String poolAddress) throws Exception {

        return weth.depositETH(poolAddress,onBehalfOf, BigInteger.ZERO).send();
    }


    public TransactionReceipt withdrawEth(String onBehalfOf, String amount,String poolAddress) {
        BigInteger value = new BigInteger(amount);
        weth.withdrawETH(poolAddress,value, onBehalfOf);
        return null;
    }
}
