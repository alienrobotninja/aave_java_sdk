package com.arnAAVE.java_sdk.lendingPool;


import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.gas.StaticGasProvider;
import org.web3j.utils.Async;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class LendingPoolAccess {

    private static final Web3j web3j = Web3j.build(new HttpService(
            "https://goerli.infura.io/v3/4b08a7529c7a4a24af5d26ce1fe16aca"));

    public static void lendingPoolDeposit() throws Exception {
        confirmConnection();

        Credentials credentials = Credentials.create("25fbeee7c1487f3af3bd5b3cfb443a8d48a8c9d406c6799bebca9d5fb9513ef2");

//        System.out.println("Your Account : " + credentials.getAddress());
        ContractGasProvider provider = new StaticGasProvider(BigInteger.valueOf(20000000L),BigInteger.valueOf(30000000L));
//        ContractGasProvider provider = new DefaultGasProvider();
        ILendingPoolAddressesProvider lendingPoolAddressesProvider = new ILendingPoolAddressesProvider("0x5E52dEc931FFb32f609681B8438A51c675cc232d",web3j,credentials,provider);
        RemoteFunctionCall<String> address = lendingPoolAddressesProvider.getLendingPool();
        String poolAddress = address.send();
        System.out.println(poolAddress);
//        String poolAddress = "0x4bd5643ac6f66a5237E18bfA7d47cF22f1c9F210";

        ILendingPool lendingPool = ILendingPool.load(poolAddress,web3j,credentials,provider);


        BigInteger value = BigInteger.valueOf(1000000000000000L);
//        System.out.println(value);
        RemoteFunctionCall<List> reserveList = lendingPool.getReservesList();
        List reserve = reserveList.send();
        System.out.println(reserve);

      RemoteFunctionCall<TransactionReceipt> deposit = lendingPool.deposit("0xeB538049D10e62ca319c9fF0c9FFF18bF2Ad968e", value, "0xeB538049D10e62ca319c9fF0c9FFF18bF2Ad968e", BigInteger.valueOf(0));

//        System.out.println(deposit.decodeFunctionResponse("0x00000000000000")

        TransactionReceipt depositReceipt = deposit.send();

        System.out.println(lendingPool.getDepositEvents(depositReceipt));

        System.out.println("Transaction hash: " + depositReceipt.getTransactionHash());
        System.out.println("The transaction address: " + depositReceipt.getContractAddress());
        System.out.println("The gas used: " + depositReceipt.getGasUsed());

        List<ILendingPool.DepositEventResponse> depositEvent = lendingPool.getDepositEvents(depositReceipt);
        System.out.println(depositEvent);

//        reserveList = lendingPool.getReservesList();
//        reserve = reserveList.send();
//        System.out.println(reserve);

        loadReservedData(lendingPool);

    }

    private static void loadReservedData(ILendingPool lendingPool) throws Exception {
        ILendingPool.ReserveData assetReserve = lendingPool.getReserveData("0xb7c325266ec274feb1354021d27fa3e3379d840d").send();
        System.out.println("aTokenAddress:" + assetReserve.aTokenAddress);
        System.out.println("The id: " + assetReserve.id);
        System.out.println("Last updated at: " + assetReserve.lastUpdateTimestamp);



    }

    public static void  lendingPoolWithdraw() throws Exception {
        BigInteger value = BigInteger.valueOf(1);
        //for development reasons I'm leaving this private key here it's a testnet key
        Credentials credentials = Credentials.create("25fbeee7c1487f3af3bd5b3cfb443a8d48a8c9d406c6799bebca9d5fb9513ef2");

        ContractGasProvider provider = new StaticGasProvider(BigInteger.valueOf(40000000L),BigInteger.valueOf(30000000L));
        ILendingPoolAddressesProvider lendingPoolAddressesProvider = new ILendingPoolAddressesProvider("0x88757f2f99175387aB4C6a4b3067c77A695b0349",web3j,credentials,provider);
        RemoteFunctionCall<String> address = lendingPoolAddressesProvider.getLendingPool();
        String poolAddress = address.send();

        ILendingPool lendingPool = ILendingPool.load(poolAddress,web3j,credentials,provider);
        TransactionReceipt z = lendingPool.withdraw("0x9d2446bf688fcc0776333069D82CA9F3328518e1",value,"0xE0fBa4Fc209b4948668006B2bE61711b7f465bAe").send();
        System.out.println(z.getTransactionHash());
    }
    public static void lendingPoolBurrow(){
        BigInteger value = BigInteger.valueOf(0);
        Credentials credentials = Credentials.create("25fbeee7c1487f3af3bd5b3cfb443a8d48a8c9d406c6799bebca9d5fb9513ef2");
        System.out.println("Your Account : " + credentials.getAddress());
        ContractGasProvider provider = new DefaultGasProvider();
        ILendingPool lendingPool = new ILendingPool("0xE0fBa4Fc209b4948668006B2bE61711b7f465bAe",web3j,credentials,provider );

        System.out.println("burrowing");
        RemoteFunctionCall<TransactionReceipt> resultOne = lendingPool.borrow("0xeB538049D10e62ca319c9fF0c9FFF18bF2Ad968e",value,BigInteger.ONE,BigInteger.ZERO,"0xeB538049D10e62ca319c9fF0c9FFF18bF2Ad968e");

        System.out.println("done");

    }

    private static void confirmConnection() {
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
