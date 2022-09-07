package com.arnAAVE.java_sdk.lendingPool;


import org.modelmapper.ModelMapper;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class LendingPoolAccess {
    private Web3j web3j = null;

    private ModelMapper mapper = new ModelMapper();

    private final Credentials credentials = Credentials.create("25fbeee7c1487f3af3bd5b3cfb443a8d48a8c9d406c6799bebca9d5fb9513ef2");

    private final ContractGasProvider provider = new StaticGasProvider(new BigInteger("2000000"),new BigInteger("3000000"));

    TransactionReceipt lendingPoolDeposit(String url) throws Exception {
        Web3j web3j = Web3j.build(new HttpService(url));
        ILendingPoolAddressesProvider lendingPoolAddressesProvider = new ILendingPoolAddressesProvider("0x5E52dEc931FFb32f609681B8438A51c675cc232d",web3j,credentials,provider);
        RemoteFunctionCall<String> address = lendingPoolAddressesProvider.getLendingPool();
        String poolAddress = address.send();

        ILendingPool lendingPool = ILendingPool.load(poolAddress,web3j,credentials,provider);
        BigInteger value = new BigInteger("1000000");

        RemoteFunctionCall<TransactionReceipt> deposit = lendingPool.deposit("0xeB538049D10e62ca319c9fF0c9FFF18bF2Ad968e", value, "0xeB538049D10e62ca319c9fF0c9FFF18bF2Ad968e", BigInteger.valueOf(0));

        return deposit.send();
    }

    List<ILendingPool.DepositEventResponse> depositEvents(Web3j web3j, TransactionReceipt transactionReceipt) throws Exception {
        ContractGasProvider provider = new StaticGasProvider(new BigInteger("2000000"),new BigInteger("2000000"));
        ILendingPoolAddressesProvider lendingPoolAddressesProvider = new ILendingPoolAddressesProvider("0x5E52dEc931FFb32f609681B8438A51c675cc232d",web3j,credentials,provider);
        RemoteFunctionCall<String> address = lendingPoolAddressesProvider.getLendingPool();
        String poolAddress = address.send();
        ILendingPool lendingPool = ILendingPool.load(poolAddress,web3j,credentials,provider);
        return lendingPool.getDepositEvents(transactionReceipt);
    }

    ReserveData loadReservedData(String url) throws Exception {
        web3j = Web3j.build(new HttpService(url));
        ILendingPoolAddressesProvider lendingPoolAddressesProvider = new ILendingPoolAddressesProvider("0x5E52dEc931FFb32f609681B8438A51c675cc232d",web3j,credentials,provider);
        RemoteFunctionCall<String> address = lendingPoolAddressesProvider.getLendingPool();
        String poolAddress = address.send();

        ILendingPool lendingPool = ILendingPool.load(poolAddress,web3j,credentials,provider);

        return mapper.map(lendingPool.getReserveData("0xb7c325266ec274feb1354021d27fa3e3379d840d").send(), ReserveData.class);
    }

    TransactionReceipt lendingPoolWithdraw(String url) throws Exception {
        Web3j web3j = Web3j.build(new HttpService(url));
        BigInteger value = BigInteger.valueOf(1);
        //for development reasons I'm leaving this private key here it's a testnet key

        ILendingPoolAddressesProvider lendingPoolAddressesProvider = new ILendingPoolAddressesProvider("0x88757f2f99175387aB4C6a4b3067c77A695b0349",web3j,credentials,provider);
        RemoteFunctionCall<String> address = lendingPoolAddressesProvider.getLendingPool();
        String poolAddress = address.send();

        ILendingPool lendingPool = ILendingPool.load(poolAddress,web3j,credentials,provider);
        return lendingPool.withdraw("0xeB538049D10e62ca319c9fF0c9FFF18bF2Ad968e",value,"0xeB538049D10e62ca319c9fF0c9FFF18bF2Ad968e").send();
    }

    public static void lendingPoolBurrow(Web3j web3j){
        BigInteger value = BigInteger.valueOf(0);
        Credentials credentials = Credentials.create("25fbeee7c1487f3af3bd5b3cfb443a8d48a8c9d406c6799bebca9d5fb9513ef2");
        System.out.println("Your Account : " + credentials.getAddress());
        ContractGasProvider provider = new DefaultGasProvider();
        ILendingPool lendingPool = new ILendingPool("0xE0fBa4Fc209b4948668006B2bE61711b7f465bAe",web3j,credentials,provider );

        System.out.println("burrowing");
        RemoteFunctionCall<TransactionReceipt> resultOne = lendingPool.borrow("0xeB538049D10e62ca319c9fF0c9FFF18bF2Ad968e",value,BigInteger.ONE,BigInteger.ZERO,"0xeB538049D10e62ca319c9fF0c9FFF18bF2Ad968e");

        System.out.println("done");

    }

    private static void confirmConnection(Web3j web3j) {
        Web3ClientVersion clientVersion = null;
        try {
            clientVersion = web3j.web3ClientVersion().send();

        } catch (IOException e) {
            e.printStackTrace();
        }
        assert clientVersion != null;
        System.out.println("Client version: " + clientVersion.getWeb3ClientVersion());
    }
}
