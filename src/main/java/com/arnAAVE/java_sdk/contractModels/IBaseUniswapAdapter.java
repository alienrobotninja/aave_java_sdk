package com.arnAAVE.java_sdk.contractModels;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple5;
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
public class IBaseUniswapAdapter extends Contract {
    public static final String BINARY = "";

    public static final String FUNC_FLASHLOAN_PREMIUM_TOTAL = "FLASHLOAN_PREMIUM_TOTAL";

    public static final String FUNC_MAX_SLIPPAGE_PERCENT = "MAX_SLIPPAGE_PERCENT";

    public static final String FUNC_ORACLE = "ORACLE";

    public static final String FUNC_UNISWAP_ROUTER = "UNISWAP_ROUTER";

    public static final String FUNC_USD_ADDRESS = "USD_ADDRESS";

    public static final String FUNC_WETH_ADDRESS = "WETH_ADDRESS";

    public static final String FUNC_GETAMOUNTSIN = "getAmountsIn";

    public static final String FUNC_GETAMOUNTSOUT = "getAmountsOut";

    public static final Event SWAPPED_EVENT = new Event("Swapped", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected IBaseUniswapAdapter(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IBaseUniswapAdapter(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected IBaseUniswapAdapter(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected IBaseUniswapAdapter(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<SwappedEventResponse> getSwappedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SWAPPED_EVENT, transactionReceipt);
        ArrayList<SwappedEventResponse> responses = new ArrayList<SwappedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SwappedEventResponse typedResponse = new SwappedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.fromAsset = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.toAsset = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.fromAmount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.receivedAmount = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<SwappedEventResponse> swappedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, SwappedEventResponse>() {
            @Override
            public SwappedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SWAPPED_EVENT, log);
                SwappedEventResponse typedResponse = new SwappedEventResponse();
                typedResponse.log = log;
                typedResponse.fromAsset = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.toAsset = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.fromAmount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.receivedAmount = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<SwappedEventResponse> swappedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SWAPPED_EVENT));
        return swappedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> FLASHLOAN_PREMIUM_TOTAL() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_FLASHLOAN_PREMIUM_TOTAL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> MAX_SLIPPAGE_PERCENT() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MAX_SLIPPAGE_PERCENT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> ORACLE() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ORACLE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> UNISWAP_ROUTER() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UNISWAP_ROUTER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> USD_ADDRESS() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_USD_ADDRESS, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> WETH_ADDRESS() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_WETH_ADDRESS, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, List<String>>> getAmountsIn(BigInteger amountOut, String reserveIn, String reserveOut) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETAMOUNTSIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amountOut), 
                new org.web3j.abi.datatypes.Address(160, reserveIn), 
                new org.web3j.abi.datatypes.Address(160, reserveOut)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteFunctionCall<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, List<String>>>(function,
                new Callable<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, List<String>>>() {
                    @Override
                    public Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, List<String>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, List<String>>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                convertToNative((List<Address>) results.get(4).getValue()));
                    }
                });
    }

    public RemoteFunctionCall<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, List<String>>> getAmountsOut(BigInteger amountIn, String reserveIn, String reserveOut) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETAMOUNTSOUT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amountIn), 
                new org.web3j.abi.datatypes.Address(160, reserveIn), 
                new org.web3j.abi.datatypes.Address(160, reserveOut)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteFunctionCall<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, List<String>>>(function,
                new Callable<Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, List<String>>>() {
                    @Override
                    public Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, List<String>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<BigInteger, BigInteger, BigInteger, BigInteger, List<String>>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                convertToNative((List<Address>) results.get(4).getValue()));
                    }
                });
    }

    @Deprecated
    public static IBaseUniswapAdapter load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IBaseUniswapAdapter(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static IBaseUniswapAdapter load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IBaseUniswapAdapter(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static IBaseUniswapAdapter load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new IBaseUniswapAdapter(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static IBaseUniswapAdapter load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new IBaseUniswapAdapter(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<IBaseUniswapAdapter> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IBaseUniswapAdapter.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IBaseUniswapAdapter> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IBaseUniswapAdapter.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<IBaseUniswapAdapter> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IBaseUniswapAdapter.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IBaseUniswapAdapter> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IBaseUniswapAdapter.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class SwappedEventResponse extends BaseEventResponse {
        public String fromAsset;

        public String toAsset;

        public BigInteger fromAmount;

        public BigInteger receivedAmount;
    }
}
