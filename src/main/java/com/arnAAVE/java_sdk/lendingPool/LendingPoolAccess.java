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

    public static TransactionReceipt deposit() throws Exception {
        Credentials credentials = Credentials.create("1238370fb9507a697d2744d9c511061a0c3cc284eba1af1fa7b24854a9084219");

        ContractGasProvider provider = new StaticGasProvider(BigInteger.valueOf(30000000L),BigInteger.valueOf(30000000L));
        ILendingPoolAddressesProvider lendingPoolAddressesProvider = new ILendingPoolAddressesProvider("0x88246b72a780856c6a1f8750AbfE1EE83A1D4089",web3j,credentials,provider);
        RemoteFunctionCall<String> address = lendingPoolAddressesProvider.getLendingPool();
        String poolAddress = address.send();

        ILendingPool lendingPool = ILendingPool.load(poolAddress,web3j,credentials,provider);

        BigInteger value = BigInteger.valueOf(1000000000000000L);
//        System.out.println(value);
        RemoteFunctionCall<List> reserveList = lendingPool.getReservesList();
        List reserve = reserveList.send();
        System.out.println(reserve);

        RemoteFunctionCall<TransactionReceipt> deposit = lendingPool.deposit("0xeBCE889Cc6580DcE90ca728C549154024F4bfaE5", value, "0x9d2Ff563417A32B9865c27B48F6B1E4626606630", BigInteger.valueOf(0));

//        System.out.println(deposit.decodeFunctionResponse("0x00000000000000"));
        TransactionReceipt depositReceipt = deposit.send();


        return depositReceipt;
    }

}
