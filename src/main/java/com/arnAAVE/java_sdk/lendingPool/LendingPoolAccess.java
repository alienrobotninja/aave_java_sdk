package com.arnAAVE.java_sdk.lendingPool;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;
import java.util.List;

public class LendingPoolAccess {

    private static final Web3j web3j = Web3j.build(new HttpService(
            "https://kovan.infura.io/v3/b8c7cedb8701445bb9210f4731e42c0a"));

    public TransactionReceipt deposit() throws Exception {
        Credentials credentials = Credentials.create("1238370fb9507a697d2744d9c511061a0c3cc284eba1af1fa7b24854a9084219");

        ContractGasProvider provider = new StaticGasProvider(new BigInteger("1"), new BigInteger("1"));
        ILendingPoolAddressesProvider lendingPoolAddressesProvider = new ILendingPoolAddressesProvider("0x7fc66500c84a76ad7e9c93437bfc5ac33e2ddae9",web3j,credentials,provider);
        RemoteFunctionCall<String> address = lendingPoolAddressesProvider.getLendingPool();
        String poolAddress = address.send();

        ILendingPool lendingPool = ILendingPool.load(poolAddress,web3j,credentials,provider);

        BigInteger value = new BigInteger("0.00001");
//        System.out.println(value);
        RemoteFunctionCall<List> reserveList = lendingPool.getReservesList();
        List reserve = reserveList.send();
        System.out.println(reserve);

        RemoteFunctionCall<TransactionReceipt> deposit = lendingPool.deposit("0x7fc66500c84a76ad7e9c93437bfc5ac33e2ddae9", value, "0x16B72adaB628D8762A25f707aCbfE9c170d9001dl", BigInteger.valueOf(0));

//        System.out.println(deposit.decodeFunctionResponse("0x00000000000000"));
        TransactionReceipt depositReceipt = deposit.send();


        return depositReceipt;
    }

}
