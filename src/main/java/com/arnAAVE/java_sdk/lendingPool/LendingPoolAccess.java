package com.arnAAVE.java_sdk.lendingPool;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class LendingPoolAccess {

    private static final Web3j web3j = Web3j.build(new HttpService(
            "https://goerli.infura.io/v3/b8c7cedb8701445bb9210f4731e42c0a"));
    private static final Credentials credentials = Credentials.create("1238370fb9507a697d2744d9c511061a0c3cc284eba1af1fa7b24854a9084219");

    public TransactionReceipt deposit() throws Exception {
        ContractGasProvider provider = new StaticGasProvider(new BigInteger("2000000"), new BigInteger("2000000"));
        ILendingPoolAddressesProvider lendingPoolAddressesProvider = new ILendingPoolAddressesProvider("0x5E52dEc931FFb32f609681B8438A51c675cc232d",web3j,credentials,provider);
        RemoteFunctionCall<String> address = lendingPoolAddressesProvider.getLendingPool();
        String poolAddress = address.send();

        ILendingPool lendingPool = ILendingPool.load(poolAddress,web3j,credentials,provider);

        BigInteger value = new BigInteger("1000000");

        RemoteFunctionCall<List> reserveList = lendingPool.getReservesList();
        List reserve = reserveList.send();
        System.out.println(reserve);

        RemoteFunctionCall<TransactionReceipt> deposit = lendingPool.deposit("0x16B72adaB628D8762A25f707aCbfE9c170d9001d", value, "0x16B72adaB628D8762A25f707aCbfE9c170d9001d", BigInteger.valueOf(0));

        return deposit.send();
    }
    public void sendEthers() throws Exception {
        ILendingPool lendingPool = ILendingPool.load("0x16B72adaB628D8762A25f707aCbfE9c170d9001d", web3j, credentials, new BigInteger("1"), new BigInteger("2"));
        TransactionReceipt transactionReceipt = Transfer.sendFunds(
                web3j, credentials, "0x16B72adaB628D8762A25f707aCbfE9c170d9001d",
                BigDecimal.valueOf(0.0001), Convert.Unit.ETHER).send();
        System.out.println(transactionReceipt);
        assert false;
        List<ILendingPool.BorrowEventResponse> responses = lendingPool.getBorrowEvents(transactionReceipt);
        System.out.println("Responses = " + responses);
    }

}
