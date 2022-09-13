package com.arnAAVE.java_sdk.lendingPool;

import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

public class Erc20 {
    private final AaveConnect connection;

    private final ContractGasProvider provider;
    private final String erc20Address;

    public Erc20(AaveConnect connection, String gasFee, String erc20Address) {
        this.connection = connection;
        this.provider = new StaticGasProvider(new BigInteger(gasFee),new BigInteger("3000000"));
        this.erc20Address =erc20Address;
    }

    public TransactionReceipt approve(String amount) throws Exception {
        IERC20 erc20 = new IERC20(erc20Address,connection.getWeb3j(),connection.getCredentials(),provider);

        return erc20.approve(connection.getCredentials().getAddress(),new BigInteger(amount)).send();
    }
}
