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
import org.web3j.abi.datatypes.Bool;
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
public class ILendingPoolCollateralManager extends Contract {
    public static final String BINARY = "";

    public static final String FUNC_LIQUIDATIONCALL = "liquidationCall";

    public static final Event LIQUIDATIONCALL_EVENT = new Event("LiquidationCall", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Bool>() {}));
    ;

    public static final Event RESERVEUSEDASCOLLATERALDISABLED_EVENT = new Event("ReserveUsedAsCollateralDisabled", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event RESERVEUSEDASCOLLATERALENABLED_EVENT = new Event("ReserveUsedAsCollateralEnabled", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected ILendingPoolCollateralManager(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ILendingPoolCollateralManager(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ILendingPoolCollateralManager(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ILendingPoolCollateralManager(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<LiquidationCallEventResponse> getLiquidationCallEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LIQUIDATIONCALL_EVENT, transactionReceipt);
        ArrayList<LiquidationCallEventResponse> responses = new ArrayList<LiquidationCallEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LiquidationCallEventResponse typedResponse = new LiquidationCallEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.collateral = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.principal = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.user = (String) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.debtToCover = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.liquidatedCollateralAmount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.liquidator = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.receiveAToken = (Boolean) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<LiquidationCallEventResponse> liquidationCallEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, LiquidationCallEventResponse>() {
            @Override
            public LiquidationCallEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LIQUIDATIONCALL_EVENT, log);
                LiquidationCallEventResponse typedResponse = new LiquidationCallEventResponse();
                typedResponse.log = log;
                typedResponse.collateral = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.principal = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.user = (String) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.debtToCover = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.liquidatedCollateralAmount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.liquidator = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.receiveAToken = (Boolean) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<LiquidationCallEventResponse> liquidationCallEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LIQUIDATIONCALL_EVENT));
        return liquidationCallEventFlowable(filter);
    }

    public List<ReserveUsedAsCollateralDisabledEventResponse> getReserveUsedAsCollateralDisabledEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RESERVEUSEDASCOLLATERALDISABLED_EVENT, transactionReceipt);
        ArrayList<ReserveUsedAsCollateralDisabledEventResponse> responses = new ArrayList<ReserveUsedAsCollateralDisabledEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ReserveUsedAsCollateralDisabledEventResponse typedResponse = new ReserveUsedAsCollateralDisabledEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.reserve = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.user = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ReserveUsedAsCollateralDisabledEventResponse> reserveUsedAsCollateralDisabledEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ReserveUsedAsCollateralDisabledEventResponse>() {
            @Override
            public ReserveUsedAsCollateralDisabledEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RESERVEUSEDASCOLLATERALDISABLED_EVENT, log);
                ReserveUsedAsCollateralDisabledEventResponse typedResponse = new ReserveUsedAsCollateralDisabledEventResponse();
                typedResponse.log = log;
                typedResponse.reserve = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.user = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ReserveUsedAsCollateralDisabledEventResponse> reserveUsedAsCollateralDisabledEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RESERVEUSEDASCOLLATERALDISABLED_EVENT));
        return reserveUsedAsCollateralDisabledEventFlowable(filter);
    }

    public List<ReserveUsedAsCollateralEnabledEventResponse> getReserveUsedAsCollateralEnabledEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RESERVEUSEDASCOLLATERALENABLED_EVENT, transactionReceipt);
        ArrayList<ReserveUsedAsCollateralEnabledEventResponse> responses = new ArrayList<ReserveUsedAsCollateralEnabledEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ReserveUsedAsCollateralEnabledEventResponse typedResponse = new ReserveUsedAsCollateralEnabledEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.reserve = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.user = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ReserveUsedAsCollateralEnabledEventResponse> reserveUsedAsCollateralEnabledEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ReserveUsedAsCollateralEnabledEventResponse>() {
            @Override
            public ReserveUsedAsCollateralEnabledEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RESERVEUSEDASCOLLATERALENABLED_EVENT, log);
                ReserveUsedAsCollateralEnabledEventResponse typedResponse = new ReserveUsedAsCollateralEnabledEventResponse();
                typedResponse.log = log;
                typedResponse.reserve = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.user = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ReserveUsedAsCollateralEnabledEventResponse> reserveUsedAsCollateralEnabledEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RESERVEUSEDASCOLLATERALENABLED_EVENT));
        return reserveUsedAsCollateralEnabledEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> liquidationCall(String collateral, String principal, String user, BigInteger debtToCover, Boolean receiveAToken) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_LIQUIDATIONCALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, collateral), 
                new org.web3j.abi.datatypes.Address(160, principal), 
                new org.web3j.abi.datatypes.Address(160, user), 
                new org.web3j.abi.datatypes.generated.Uint256(debtToCover), 
                new org.web3j.abi.datatypes.Bool(receiveAToken)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ILendingPoolCollateralManager load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ILendingPoolCollateralManager(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ILendingPoolCollateralManager load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ILendingPoolCollateralManager(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ILendingPoolCollateralManager load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ILendingPoolCollateralManager(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ILendingPoolCollateralManager load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ILendingPoolCollateralManager(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ILendingPoolCollateralManager> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ILendingPoolCollateralManager.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ILendingPoolCollateralManager> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ILendingPoolCollateralManager.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ILendingPoolCollateralManager> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ILendingPoolCollateralManager.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ILendingPoolCollateralManager> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ILendingPoolCollateralManager.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class LiquidationCallEventResponse extends BaseEventResponse {
        public String collateral;

        public String principal;

        public String user;

        public BigInteger debtToCover;

        public BigInteger liquidatedCollateralAmount;

        public String liquidator;

        public Boolean receiveAToken;
    }

    public static class ReserveUsedAsCollateralDisabledEventResponse extends BaseEventResponse {
        public String reserve;

        public String user;
    }

    public static class ReserveUsedAsCollateralEnabledEventResponse extends BaseEventResponse {
        public String reserve;

        public String user;
    }
}
