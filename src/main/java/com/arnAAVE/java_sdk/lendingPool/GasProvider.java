package com.arnAAVE.java_sdk.lendingPool;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;


public class GasProvider implements ContractGasProvider {
    @Override
    public BigInteger getGasPrice(String s) {
        return null;
    }

    @Override
    public BigInteger getGasPrice() {
        return null;
    }

    @Override
    public BigInteger getGasLimit(String s) {
        return null;
    }

    @Override
    public BigInteger getGasLimit() {
        return null;
    }
}
