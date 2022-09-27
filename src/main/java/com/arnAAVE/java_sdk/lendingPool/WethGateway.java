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

//    public TransactionReceipt depositEth(String onBehalfOf, String poolAddress) throws Exception {
//        public RemoteFunctionCall<TransactionReceipt> newGreeting(String _greeting, BigInteger weiValue) {
//            final Function function = new Function(
//                    FUNC_NEWGREETING,
//                    Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_greeting)),
//                    Collections.<TypeReference<?>>emptyList());
//            return executeRemoteCallTransaction(function, weiValue);
//        }
//        Function function = new Function<>(
//                "functionName",  // function we're calling
//                Arrays.asList(new Type(value), ...),  // Parameters to pass as Solidity Types
//        Arrays.asList(new TypeReference<Type>() {}, ...));
//
//        String encodedFunction = FunctionEncoder.encode(function)
//        Transaction transaction = Transaction.createFunctionCallTransaction(
//                <from>, <gasPrice>, <gasLimit>, contractAddress, <funds>, encodedFunction);
//
//        org.web3j.protocol.core.methods.response.EthSendTransaction transactionResponse =
//                web3j.ethSendTransaction(transaction).sendAsync().get();

//        String transactionHash = transactionResponse.getTransactionHash();
//
//// wait for response using EthGetTransactionReceipt...
//        return weth.depositETH(poolAddress,onBehalfOf, BigInteger.ZERO).send();
//    }



    public TransactionReceipt withdrawEth(String onBehalfOf, String amount,String poolAddress) throws Exception {
        BigInteger value = new BigInteger(amount);

    return weth.withdrawETH(poolAddress,value, onBehalfOf).send();
    }
}
