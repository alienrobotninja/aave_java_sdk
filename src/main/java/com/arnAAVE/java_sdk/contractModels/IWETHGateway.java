package com.arnAAVE.java_sdk.contractModels;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.8.7.
 */
@SuppressWarnings("rawtypes")
public class IWETHGateway extends Contract {
    public static final String BINARY = "";

    public static final String FUNC_BORROWETH = "borrowETH";

    public static final String FUNC_DEPOSITETH = "depositETH";

    public static final String FUNC_REPAYETH = "repayETH";

    public static final String FUNC_WITHDRAWETH = "withdrawETH";

    @Deprecated
    protected IWETHGateway(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IWETHGateway(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected IWETHGateway(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected IWETHGateway(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> borrowETH(String lendingPool, BigInteger amount, BigInteger interesRateMode, BigInteger referralCode) {
        final Function function = new Function(
                FUNC_BORROWETH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, lendingPool), 
                new org.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.web3j.abi.datatypes.generated.Uint256(interesRateMode), 
                new org.web3j.abi.datatypes.generated.Uint16(referralCode)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> depositETH(String lendingPool, String onBehalfOf, BigInteger referralCode) {
        final Function function = new Function(
                FUNC_DEPOSITETH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, lendingPool), 
                new org.web3j.abi.datatypes.Address(160, onBehalfOf), 
                new org.web3j.abi.datatypes.generated.Uint16(referralCode)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> repayETH(String lendingPool, BigInteger amount, BigInteger rateMode, String onBehalfOf) {
        final Function function = new Function(
                FUNC_REPAYETH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, lendingPool), 
                new org.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.web3j.abi.datatypes.generated.Uint256(rateMode), 
                new org.web3j.abi.datatypes.Address(160, onBehalfOf)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> withdrawETH(String lendingPool, BigInteger amount, String onBehalfOf) {
        final Function function = new Function(
                FUNC_WITHDRAWETH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, lendingPool), 
                new org.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.web3j.abi.datatypes.Address(160, onBehalfOf)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static IWETHGateway load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IWETHGateway(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static IWETHGateway load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IWETHGateway(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static IWETHGateway load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new IWETHGateway(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static IWETHGateway load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new IWETHGateway(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<IWETHGateway> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IWETHGateway.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IWETHGateway> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IWETHGateway.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<IWETHGateway> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IWETHGateway.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IWETHGateway> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IWETHGateway.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
