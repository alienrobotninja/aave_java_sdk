package com.arnAAVE.java_sdk.contractModels;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.tuples.generated.Tuple3;
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
public class IReserveInterestRateStrategy extends Contract {
    public static final String BINARY = "";

    public static final String FUNC_BASEVARIABLEBORROWRATE = "baseVariableBorrowRate";

    public static final String FUNC_calculateInterestRates = "calculateInterestRates";

    public static final String FUNC_GETMAXVARIABLEBORROWRATE = "getMaxVariableBorrowRate";

    @Deprecated
    protected IReserveInterestRateStrategy(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IReserveInterestRateStrategy(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected IReserveInterestRateStrategy(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected IReserveInterestRateStrategy(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> baseVariableBorrowRate() {
        final Function function = new Function(FUNC_BASEVARIABLEBORROWRATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple3<BigInteger, BigInteger, BigInteger>> calculateInterestRates(String reserve, String aToken, BigInteger liquidityAdded, BigInteger liquidityTaken, BigInteger totalStableDebt, BigInteger totalVariableDebt, BigInteger averageStableBorrowRate, BigInteger reserveFactor) {
        final Function function = new Function(FUNC_calculateInterestRates, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, reserve), 
                new org.web3j.abi.datatypes.Address(160, aToken), 
                new org.web3j.abi.datatypes.generated.Uint256(liquidityAdded), 
                new org.web3j.abi.datatypes.generated.Uint256(liquidityTaken), 
                new org.web3j.abi.datatypes.generated.Uint256(totalStableDebt), 
                new org.web3j.abi.datatypes.generated.Uint256(totalVariableDebt), 
                new org.web3j.abi.datatypes.generated.Uint256(averageStableBorrowRate), 
                new org.web3j.abi.datatypes.generated.Uint256(reserveFactor)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple3<BigInteger, BigInteger, BigInteger>>(function,
                new Callable<Tuple3<BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple3<BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<BigInteger, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Tuple3<BigInteger, BigInteger, BigInteger>> calculateInterestRates(String reserve, BigInteger availableLiquidity, BigInteger totalStableDebt, BigInteger totalVariableDebt, BigInteger averageStableBorrowRate, BigInteger reserveFactor) {
        final Function function = new Function(FUNC_calculateInterestRates, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, reserve), 
                new org.web3j.abi.datatypes.generated.Uint256(availableLiquidity), 
                new org.web3j.abi.datatypes.generated.Uint256(totalStableDebt), 
                new org.web3j.abi.datatypes.generated.Uint256(totalVariableDebt), 
                new org.web3j.abi.datatypes.generated.Uint256(averageStableBorrowRate), 
                new org.web3j.abi.datatypes.generated.Uint256(reserveFactor)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple3<BigInteger, BigInteger, BigInteger>>(function,
                new Callable<Tuple3<BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple3<BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<BigInteger, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> getMaxVariableBorrowRate() {
        final Function function = new Function(FUNC_GETMAXVARIABLEBORROWRATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static IReserveInterestRateStrategy load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IReserveInterestRateStrategy(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static IReserveInterestRateStrategy load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IReserveInterestRateStrategy(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static IReserveInterestRateStrategy load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new IReserveInterestRateStrategy(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static IReserveInterestRateStrategy load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new IReserveInterestRateStrategy(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<IReserveInterestRateStrategy> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IReserveInterestRateStrategy.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IReserveInterestRateStrategy> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IReserveInterestRateStrategy.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<IReserveInterestRateStrategy> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IReserveInterestRateStrategy.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IReserveInterestRateStrategy> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IReserveInterestRateStrategy.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
