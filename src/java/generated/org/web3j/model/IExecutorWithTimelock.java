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
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
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
public class IExecutorWithTimelock extends Contract {
    public static final String BINARY = "";

    public static final String FUNC_GRACE_PERIOD = "GRACE_PERIOD";

    public static final String FUNC_MAXIMUM_DELAY = "MAXIMUM_DELAY";

    public static final String FUNC_MINIMUM_DELAY = "MINIMUM_DELAY";

    public static final String FUNC_CANCELTRANSACTION = "cancelTransaction";

    public static final String FUNC_EXECUTETRANSACTION = "executeTransaction";

    public static final String FUNC_GETADMIN = "getAdmin";

    public static final String FUNC_GETDELAY = "getDelay";

    public static final String FUNC_GETPENDINGADMIN = "getPendingAdmin";

    public static final String FUNC_ISACTIONQUEUED = "isActionQueued";

    public static final String FUNC_ISPROPOSALOVERGRACEPERIOD = "isProposalOverGracePeriod";

    public static final String FUNC_QUEUETRANSACTION = "queueTransaction";

    public static final Event CANCELLEDACTION_EVENT = new Event("CancelledAction", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}));
    ;

    public static final Event EXECUTEDACTION_EVENT = new Event("ExecutedAction", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}, new TypeReference<DynamicBytes>() {}));
    ;

    public static final Event NEWADMIN_EVENT = new Event("NewAdmin", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event NEWDELAY_EVENT = new Event("NewDelay", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event NEWPENDINGADMIN_EVENT = new Event("NewPendingAdmin", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event QUEUEDACTION_EVENT = new Event("QueuedAction", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}));
    ;

    @Deprecated
    protected IExecutorWithTimelock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IExecutorWithTimelock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected IExecutorWithTimelock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected IExecutorWithTimelock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<CancelledActionEventResponse> getCancelledActionEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CANCELLEDACTION_EVENT, transactionReceipt);
        ArrayList<CancelledActionEventResponse> responses = new ArrayList<CancelledActionEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CancelledActionEventResponse typedResponse = new CancelledActionEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.target = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.actionHash = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.signature = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.executionTime = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.withDelegatecall = (Boolean) eventValues.getNonIndexedValues().get(5).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<CancelledActionEventResponse> cancelledActionEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, CancelledActionEventResponse>() {
            @Override
            public CancelledActionEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CANCELLEDACTION_EVENT, log);
                CancelledActionEventResponse typedResponse = new CancelledActionEventResponse();
                typedResponse.log = log;
                typedResponse.target = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.actionHash = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.signature = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.executionTime = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.withDelegatecall = (Boolean) eventValues.getNonIndexedValues().get(5).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<CancelledActionEventResponse> cancelledActionEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CANCELLEDACTION_EVENT));
        return cancelledActionEventFlowable(filter);
    }

    public List<ExecutedActionEventResponse> getExecutedActionEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(EXECUTEDACTION_EVENT, transactionReceipt);
        ArrayList<ExecutedActionEventResponse> responses = new ArrayList<ExecutedActionEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ExecutedActionEventResponse typedResponse = new ExecutedActionEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.target = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.actionHash = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.signature = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.executionTime = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.withDelegatecall = (Boolean) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.resultData = (byte[]) eventValues.getNonIndexedValues().get(6).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ExecutedActionEventResponse> executedActionEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ExecutedActionEventResponse>() {
            @Override
            public ExecutedActionEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(EXECUTEDACTION_EVENT, log);
                ExecutedActionEventResponse typedResponse = new ExecutedActionEventResponse();
                typedResponse.log = log;
                typedResponse.target = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.actionHash = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.signature = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.executionTime = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.withDelegatecall = (Boolean) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.resultData = (byte[]) eventValues.getNonIndexedValues().get(6).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ExecutedActionEventResponse> executedActionEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EXECUTEDACTION_EVENT));
        return executedActionEventFlowable(filter);
    }

    public List<NewAdminEventResponse> getNewAdminEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(NEWADMIN_EVENT, transactionReceipt);
        ArrayList<NewAdminEventResponse> responses = new ArrayList<NewAdminEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NewAdminEventResponse typedResponse = new NewAdminEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.newAdmin = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NewAdminEventResponse> newAdminEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, NewAdminEventResponse>() {
            @Override
            public NewAdminEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NEWADMIN_EVENT, log);
                NewAdminEventResponse typedResponse = new NewAdminEventResponse();
                typedResponse.log = log;
                typedResponse.newAdmin = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<NewAdminEventResponse> newAdminEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NEWADMIN_EVENT));
        return newAdminEventFlowable(filter);
    }

    public List<NewDelayEventResponse> getNewDelayEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(NEWDELAY_EVENT, transactionReceipt);
        ArrayList<NewDelayEventResponse> responses = new ArrayList<NewDelayEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NewDelayEventResponse typedResponse = new NewDelayEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.delay = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NewDelayEventResponse> newDelayEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, NewDelayEventResponse>() {
            @Override
            public NewDelayEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NEWDELAY_EVENT, log);
                NewDelayEventResponse typedResponse = new NewDelayEventResponse();
                typedResponse.log = log;
                typedResponse.delay = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<NewDelayEventResponse> newDelayEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NEWDELAY_EVENT));
        return newDelayEventFlowable(filter);
    }

    public List<NewPendingAdminEventResponse> getNewPendingAdminEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(NEWPENDINGADMIN_EVENT, transactionReceipt);
        ArrayList<NewPendingAdminEventResponse> responses = new ArrayList<NewPendingAdminEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NewPendingAdminEventResponse typedResponse = new NewPendingAdminEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.newPendingAdmin = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NewPendingAdminEventResponse> newPendingAdminEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, NewPendingAdminEventResponse>() {
            @Override
            public NewPendingAdminEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NEWPENDINGADMIN_EVENT, log);
                NewPendingAdminEventResponse typedResponse = new NewPendingAdminEventResponse();
                typedResponse.log = log;
                typedResponse.newPendingAdmin = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<NewPendingAdminEventResponse> newPendingAdminEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NEWPENDINGADMIN_EVENT));
        return newPendingAdminEventFlowable(filter);
    }

    public List<QueuedActionEventResponse> getQueuedActionEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(QUEUEDACTION_EVENT, transactionReceipt);
        ArrayList<QueuedActionEventResponse> responses = new ArrayList<QueuedActionEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            QueuedActionEventResponse typedResponse = new QueuedActionEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.target = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.actionHash = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.signature = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.executionTime = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.withDelegatecall = (Boolean) eventValues.getNonIndexedValues().get(5).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<QueuedActionEventResponse> queuedActionEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, QueuedActionEventResponse>() {
            @Override
            public QueuedActionEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(QUEUEDACTION_EVENT, log);
                QueuedActionEventResponse typedResponse = new QueuedActionEventResponse();
                typedResponse.log = log;
                typedResponse.target = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.actionHash = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.signature = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.executionTime = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.withDelegatecall = (Boolean) eventValues.getNonIndexedValues().get(5).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<QueuedActionEventResponse> queuedActionEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(QUEUEDACTION_EVENT));
        return queuedActionEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> GRACE_PERIOD() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GRACE_PERIOD, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> MAXIMUM_DELAY() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MAXIMUM_DELAY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> MINIMUM_DELAY() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MINIMUM_DELAY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> cancelTransaction(String target, BigInteger value, String signature, byte[] data, BigInteger executionTime, Boolean withDelegatecall) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CANCELTRANSACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, target), 
                new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.Utf8String(signature), 
                new org.web3j.abi.datatypes.DynamicBytes(data), 
                new org.web3j.abi.datatypes.generated.Uint256(executionTime), 
                new org.web3j.abi.datatypes.Bool(withDelegatecall)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> executeTransaction(String target, BigInteger value, String signature, byte[] data, BigInteger executionTime, Boolean withDelegatecall) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_EXECUTETRANSACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, target), 
                new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.Utf8String(signature), 
                new org.web3j.abi.datatypes.DynamicBytes(data), 
                new org.web3j.abi.datatypes.generated.Uint256(executionTime), 
                new org.web3j.abi.datatypes.Bool(withDelegatecall)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getAdmin() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETADMIN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getDelay() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETDELAY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> getPendingAdmin() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETPENDINGADMIN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> isActionQueued(byte[] actionHash) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISACTIONQUEUED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(actionHash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> isProposalOverGracePeriod(String governance, BigInteger proposalId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISPROPOSALOVERGRACEPERIOD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, governance), 
                new org.web3j.abi.datatypes.generated.Uint256(proposalId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> queueTransaction(String target, BigInteger value, String signature, byte[] data, BigInteger executionTime, Boolean withDelegatecall) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_QUEUETRANSACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, target), 
                new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.Utf8String(signature), 
                new org.web3j.abi.datatypes.DynamicBytes(data), 
                new org.web3j.abi.datatypes.generated.Uint256(executionTime), 
                new org.web3j.abi.datatypes.Bool(withDelegatecall)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static IExecutorWithTimelock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IExecutorWithTimelock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static IExecutorWithTimelock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IExecutorWithTimelock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static IExecutorWithTimelock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new IExecutorWithTimelock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static IExecutorWithTimelock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new IExecutorWithTimelock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<IExecutorWithTimelock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IExecutorWithTimelock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IExecutorWithTimelock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IExecutorWithTimelock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<IExecutorWithTimelock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IExecutorWithTimelock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IExecutorWithTimelock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IExecutorWithTimelock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class CancelledActionEventResponse extends BaseEventResponse {
        public String target;

        public byte[] actionHash;

        public BigInteger value;

        public String signature;

        public byte[] data;

        public BigInteger executionTime;

        public Boolean withDelegatecall;
    }

    public static class ExecutedActionEventResponse extends BaseEventResponse {
        public String target;

        public byte[] actionHash;

        public BigInteger value;

        public String signature;

        public byte[] data;

        public BigInteger executionTime;

        public Boolean withDelegatecall;

        public byte[] resultData;
    }

    public static class NewAdminEventResponse extends BaseEventResponse {
        public String newAdmin;
    }

    public static class NewDelayEventResponse extends BaseEventResponse {
        public BigInteger delay;
    }

    public static class NewPendingAdminEventResponse extends BaseEventResponse {
        public String newPendingAdmin;
    }

    public static class QueuedActionEventResponse extends BaseEventResponse {
        public String target;

        public byte[] actionHash;

        public BigInteger value;

        public String signature;

        public byte[] data;

        public BigInteger executionTime;

        public Boolean withDelegatecall;
    }
}
