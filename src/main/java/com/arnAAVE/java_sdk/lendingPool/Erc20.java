package com.arnAAVE.java_sdk.lendingPool;

import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

public class Erc20 {
    private final AaveConnect connection;

    private final IERC20 erc20;

    public Erc20(AaveConnect connection, String gasFee, String assetAddress) {
        this.connection = connection;
        ContractGasProvider provider = new StaticGasProvider(new BigInteger(gasFee),new BigInteger("3000000"));
        this.erc20 = new IERC20(assetAddress, connection.getWeb3j(), connection.getCredentials(), provider);

    }

    public TransactionReceipt approve(String amount) throws Exception {

        return erc20.approve(connection.getCredentials().getAddress(),new BigInteger(amount)).send();
    }

    public BigInteger supplyBalance() throws Exception {

        return erc20.totalSupply().send();
    }

    public BigInteger balanceOf(String address) throws Exception {

        return erc20.balanceOf(address).send();
    }
}
