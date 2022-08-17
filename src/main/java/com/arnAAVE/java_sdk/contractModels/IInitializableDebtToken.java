package com.arnAAVE.java_sdk.contractModels;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
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
public class IInitializableDebtToken extends Contract {
    public static final String BINARY = "";

    public static final String FUNC_INITIALIZE = "initialize";

    public static final Event INITIALIZED_EVENT = new Event("Initialized", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>() {}, new TypeReference<Uint8>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<DynamicBytes>() {}));
    ;

    @Deprecated
    protected IInitializableDebtToken(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IInitializableDebtToken(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected IInitializableDebtToken(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected IInitializableDebtToken(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<InitializedEventResponse> getInitializedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(INITIALIZED_EVENT, transactionReceipt);
        ArrayList<InitializedEventResponse> responses = new ArrayList<InitializedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            InitializedEventResponse typedResponse = new InitializedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.underlyingAsset = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.pool = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.incentivesController = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.debtTokenDecimals = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.debtTokenName = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.debtTokenSymbol = (String) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.params = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<InitializedEventResponse> initializedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, InitializedEventResponse>() {
            @Override
            public InitializedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(INITIALIZED_EVENT, log);
                InitializedEventResponse typedResponse = new InitializedEventResponse();
                typedResponse.log = log;
                typedResponse.underlyingAsset = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.pool = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.incentivesController = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.debtTokenDecimals = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.debtTokenName = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.debtTokenSymbol = (String) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.params = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<InitializedEventResponse> initializedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(INITIALIZED_EVENT));
        return initializedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> initialize(String pool, String underlyingAsset, String incentivesController, BigInteger debtTokenDecimals, String debtTokenName, String debtTokenSymbol, byte[] params) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_INITIALIZE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, pool), 
                new org.web3j.abi.datatypes.Address(160, underlyingAsset), 
                new org.web3j.abi.datatypes.Address(160, incentivesController), 
                new org.web3j.abi.datatypes.generated.Uint8(debtTokenDecimals), 
                new org.web3j.abi.datatypes.Utf8String(debtTokenName), 
                new org.web3j.abi.datatypes.Utf8String(debtTokenSymbol), 
                new org.web3j.abi.datatypes.DynamicBytes(params)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static IInitializableDebtToken load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IInitializableDebtToken(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static IInitializableDebtToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IInitializableDebtToken(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static IInitializableDebtToken load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new IInitializableDebtToken(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static IInitializableDebtToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new IInitializableDebtToken(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<IInitializableDebtToken> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IInitializableDebtToken.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IInitializableDebtToken> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IInitializableDebtToken.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<IInitializableDebtToken> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IInitializableDebtToken.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IInitializableDebtToken> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IInitializableDebtToken.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class InitializedEventResponse extends BaseEventResponse {
        public String underlyingAsset;

        public String pool;

        public String incentivesController;

        public BigInteger debtTokenDecimals;

        public String debtTokenName;

        public String debtTokenSymbol;

        public byte[] params;
    }
}
