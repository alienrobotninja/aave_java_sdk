package com.arnAAVE.java_sdk.lendingPool;

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
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.StaticStruct;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint248;
import org.web3j.abi.datatypes.generated.Uint256;
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
public class IAaveGovernanceV2 extends Contract {
    public static final String BINARY = "";

    public static final String FUNC___ABDICATE = "__abdicate";

    public static final String FUNC_AUTHORIZEEXECUTORS = "authorizeExecutors";

    public static final String FUNC_CANCEL = "cancel";

    public static final String FUNC_CREATE = "create";

    public static final String FUNC_EXECUTE = "execute";

    public static final String FUNC_GETGOVERNANCESTRATEGY = "getGovernanceStrategy";

    public static final String FUNC_GETGUARDIAN = "getGuardian";

    public static final String FUNC_GETPROPOSALBYID = "getProposalById";

    public static final String FUNC_GETPROPOSALSTATE = "getProposalState";

    public static final String FUNC_GETPROPOSALSCOUNT = "getProposalsCount";

    public static final String FUNC_GETVOTEONPROPOSAL = "getVoteOnProposal";

    public static final String FUNC_GETVOTINGDELAY = "getVotingDelay";

    public static final String FUNC_ISEXECUTORAUTHORIZED = "isExecutorAuthorized";

    public static final String FUNC_QUEUE = "queue";

    public static final String FUNC_SETGOVERNANCESTRATEGY = "setGovernanceStrategy";

    public static final String FUNC_SETVOTINGDELAY = "setVotingDelay";

    public static final String FUNC_SUBMITVOTE = "submitVote";

    public static final String FUNC_SUBMITVOTEBYSIGNATURE = "submitVoteBySignature";

    public static final String FUNC_UNAUTHORIZEEXECUTORS = "unauthorizeExecutors";

    public static final Event EXECUTORAUTHORIZED_EVENT = new Event("ExecutorAuthorized", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event EXECUTORUNAUTHORIZED_EVENT = new Event("ExecutorUnauthorized", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event GOVERNANCESTRATEGYCHANGED_EVENT = new Event("GovernanceStrategyChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event PROPOSALCANCELED_EVENT = new Event("ProposalCanceled", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event PROPOSALCREATED_EVENT = new Event("ProposalCreated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<DynamicArray<Address>>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Utf8String>>() {}, new TypeReference<DynamicArray<DynamicBytes>>() {}, new TypeReference<DynamicArray<Bool>>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Bytes32>() {}));
    ;

    public static final Event PROPOSALEXECUTED_EVENT = new Event("ProposalExecuted", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event PROPOSALQUEUED_EVENT = new Event("ProposalQueued", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event VOTEEMITTED_EVENT = new Event("VoteEmitted", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>(true) {}, new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event VOTINGDELAYCHANGED_EVENT = new Event("VotingDelayChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected IAaveGovernanceV2(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IAaveGovernanceV2(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected IAaveGovernanceV2(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected IAaveGovernanceV2(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<ExecutorAuthorizedEventResponse> getExecutorAuthorizedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(EXECUTORAUTHORIZED_EVENT, transactionReceipt);
        ArrayList<ExecutorAuthorizedEventResponse> responses = new ArrayList<ExecutorAuthorizedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ExecutorAuthorizedEventResponse typedResponse = new ExecutorAuthorizedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.executor = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ExecutorAuthorizedEventResponse> executorAuthorizedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ExecutorAuthorizedEventResponse>() {
            @Override
            public ExecutorAuthorizedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(EXECUTORAUTHORIZED_EVENT, log);
                ExecutorAuthorizedEventResponse typedResponse = new ExecutorAuthorizedEventResponse();
                typedResponse.log = log;
                typedResponse.executor = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ExecutorAuthorizedEventResponse> executorAuthorizedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EXECUTORAUTHORIZED_EVENT));
        return executorAuthorizedEventFlowable(filter);
    }

    public List<ExecutorUnauthorizedEventResponse> getExecutorUnauthorizedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(EXECUTORUNAUTHORIZED_EVENT, transactionReceipt);
        ArrayList<ExecutorUnauthorizedEventResponse> responses = new ArrayList<ExecutorUnauthorizedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ExecutorUnauthorizedEventResponse typedResponse = new ExecutorUnauthorizedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.executor = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ExecutorUnauthorizedEventResponse> executorUnauthorizedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ExecutorUnauthorizedEventResponse>() {
            @Override
            public ExecutorUnauthorizedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(EXECUTORUNAUTHORIZED_EVENT, log);
                ExecutorUnauthorizedEventResponse typedResponse = new ExecutorUnauthorizedEventResponse();
                typedResponse.log = log;
                typedResponse.executor = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ExecutorUnauthorizedEventResponse> executorUnauthorizedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EXECUTORUNAUTHORIZED_EVENT));
        return executorUnauthorizedEventFlowable(filter);
    }

    public List<GovernanceStrategyChangedEventResponse> getGovernanceStrategyChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(GOVERNANCESTRATEGYCHANGED_EVENT, transactionReceipt);
        ArrayList<GovernanceStrategyChangedEventResponse> responses = new ArrayList<GovernanceStrategyChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            GovernanceStrategyChangedEventResponse typedResponse = new GovernanceStrategyChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.newStrategy = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.initiatorChange = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<GovernanceStrategyChangedEventResponse> governanceStrategyChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, GovernanceStrategyChangedEventResponse>() {
            @Override
            public GovernanceStrategyChangedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(GOVERNANCESTRATEGYCHANGED_EVENT, log);
                GovernanceStrategyChangedEventResponse typedResponse = new GovernanceStrategyChangedEventResponse();
                typedResponse.log = log;
                typedResponse.newStrategy = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.initiatorChange = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<GovernanceStrategyChangedEventResponse> governanceStrategyChangedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(GOVERNANCESTRATEGYCHANGED_EVENT));
        return governanceStrategyChangedEventFlowable(filter);
    }

    public List<ProposalCanceledEventResponse> getProposalCanceledEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PROPOSALCANCELED_EVENT, transactionReceipt);
        ArrayList<ProposalCanceledEventResponse> responses = new ArrayList<ProposalCanceledEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ProposalCanceledEventResponse typedResponse = new ProposalCanceledEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ProposalCanceledEventResponse> proposalCanceledEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ProposalCanceledEventResponse>() {
            @Override
            public ProposalCanceledEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PROPOSALCANCELED_EVENT, log);
                ProposalCanceledEventResponse typedResponse = new ProposalCanceledEventResponse();
                typedResponse.log = log;
                typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ProposalCanceledEventResponse> proposalCanceledEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PROPOSALCANCELED_EVENT));
        return proposalCanceledEventFlowable(filter);
    }

    public List<ProposalCreatedEventResponse> getProposalCreatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PROPOSALCREATED_EVENT, transactionReceipt);
        ArrayList<ProposalCreatedEventResponse> responses = new ArrayList<ProposalCreatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ProposalCreatedEventResponse typedResponse = new ProposalCreatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.creator = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.executor = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.targets = (List<String>) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.values = (List<BigInteger>) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.signatures = (List<String>) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.calldatas = (List<byte[]>) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.withDelegatecalls = (List<Boolean>) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.startBlock = (BigInteger) eventValues.getNonIndexedValues().get(6).getValue();
            typedResponse.endBlock = (BigInteger) eventValues.getNonIndexedValues().get(7).getValue();
            typedResponse.strategy = (String) eventValues.getNonIndexedValues().get(8).getValue();
            typedResponse.ipfsHash = (byte[]) eventValues.getNonIndexedValues().get(9).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ProposalCreatedEventResponse> proposalCreatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ProposalCreatedEventResponse>() {
            @Override
            public ProposalCreatedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PROPOSALCREATED_EVENT, log);
                ProposalCreatedEventResponse typedResponse = new ProposalCreatedEventResponse();
                typedResponse.log = log;
                typedResponse.creator = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.executor = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.targets = (List<String>) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.values = (List<BigInteger>) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.signatures = (List<String>) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.calldatas = (List<byte[]>) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.withDelegatecalls = (List<Boolean>) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.startBlock = (BigInteger) eventValues.getNonIndexedValues().get(6).getValue();
                typedResponse.endBlock = (BigInteger) eventValues.getNonIndexedValues().get(7).getValue();
                typedResponse.strategy = (String) eventValues.getNonIndexedValues().get(8).getValue();
                typedResponse.ipfsHash = (byte[]) eventValues.getNonIndexedValues().get(9).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ProposalCreatedEventResponse> proposalCreatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PROPOSALCREATED_EVENT));
        return proposalCreatedEventFlowable(filter);
    }

    public List<ProposalExecutedEventResponse> getProposalExecutedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PROPOSALEXECUTED_EVENT, transactionReceipt);
        ArrayList<ProposalExecutedEventResponse> responses = new ArrayList<ProposalExecutedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ProposalExecutedEventResponse typedResponse = new ProposalExecutedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.initiatorExecution = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ProposalExecutedEventResponse> proposalExecutedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ProposalExecutedEventResponse>() {
            @Override
            public ProposalExecutedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PROPOSALEXECUTED_EVENT, log);
                ProposalExecutedEventResponse typedResponse = new ProposalExecutedEventResponse();
                typedResponse.log = log;
                typedResponse.initiatorExecution = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ProposalExecutedEventResponse> proposalExecutedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PROPOSALEXECUTED_EVENT));
        return proposalExecutedEventFlowable(filter);
    }

    public List<ProposalQueuedEventResponse> getProposalQueuedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PROPOSALQUEUED_EVENT, transactionReceipt);
        ArrayList<ProposalQueuedEventResponse> responses = new ArrayList<ProposalQueuedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ProposalQueuedEventResponse typedResponse = new ProposalQueuedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.initiatorQueueing = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.executionTime = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ProposalQueuedEventResponse> proposalQueuedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ProposalQueuedEventResponse>() {
            @Override
            public ProposalQueuedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PROPOSALQUEUED_EVENT, log);
                ProposalQueuedEventResponse typedResponse = new ProposalQueuedEventResponse();
                typedResponse.log = log;
                typedResponse.initiatorQueueing = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.executionTime = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ProposalQueuedEventResponse> proposalQueuedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PROPOSALQUEUED_EVENT));
        return proposalQueuedEventFlowable(filter);
    }

    public List<VoteEmittedEventResponse> getVoteEmittedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(VOTEEMITTED_EVENT, transactionReceipt);
        ArrayList<VoteEmittedEventResponse> responses = new ArrayList<VoteEmittedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            VoteEmittedEventResponse typedResponse = new VoteEmittedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.voter = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.support = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.votingPower = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<VoteEmittedEventResponse> voteEmittedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, VoteEmittedEventResponse>() {
            @Override
            public VoteEmittedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(VOTEEMITTED_EVENT, log);
                VoteEmittedEventResponse typedResponse = new VoteEmittedEventResponse();
                typedResponse.log = log;
                typedResponse.voter = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.support = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.votingPower = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<VoteEmittedEventResponse> voteEmittedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(VOTEEMITTED_EVENT));
        return voteEmittedEventFlowable(filter);
    }

    public List<VotingDelayChangedEventResponse> getVotingDelayChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(VOTINGDELAYCHANGED_EVENT, transactionReceipt);
        ArrayList<VotingDelayChangedEventResponse> responses = new ArrayList<VotingDelayChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            VotingDelayChangedEventResponse typedResponse = new VotingDelayChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.initiatorChange = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newVotingDelay = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<VotingDelayChangedEventResponse> votingDelayChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, VotingDelayChangedEventResponse>() {
            @Override
            public VotingDelayChangedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(VOTINGDELAYCHANGED_EVENT, log);
                VotingDelayChangedEventResponse typedResponse = new VotingDelayChangedEventResponse();
                typedResponse.log = log;
                typedResponse.initiatorChange = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newVotingDelay = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<VotingDelayChangedEventResponse> votingDelayChangedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(VOTINGDELAYCHANGED_EVENT));
        return votingDelayChangedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> __abdicate() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC___ABDICATE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> authorizeExecutors(List<String> executors) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_AUTHORIZEEXECUTORS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(executors, org.web3j.abi.datatypes.Address.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> cancel(BigInteger proposalId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CANCEL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(proposalId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> create(String executor, List<String> targets, List<BigInteger> values, List<String> signatures, List<byte[]> calldatas, List<Boolean> withDelegatecalls, byte[] ipfsHash) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CREATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, executor), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(targets, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(values, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Utf8String>(
                        org.web3j.abi.datatypes.Utf8String.class,
                        org.web3j.abi.Utils.typeMap(signatures, org.web3j.abi.datatypes.Utf8String.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.DynamicBytes>(
                        org.web3j.abi.datatypes.DynamicBytes.class,
                        org.web3j.abi.Utils.typeMap(calldatas, org.web3j.abi.datatypes.DynamicBytes.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Bool>(
                        org.web3j.abi.datatypes.Bool.class,
                        org.web3j.abi.Utils.typeMap(withDelegatecalls, org.web3j.abi.datatypes.Bool.class)), 
                new org.web3j.abi.datatypes.generated.Bytes32(ipfsHash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> execute(BigInteger proposalId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_EXECUTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(proposalId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getGovernanceStrategy() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETGOVERNANCESTRATEGY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> getGuardian() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETGUARDIAN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<ProposalWithoutVotes> getProposalById(BigInteger proposalId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETPROPOSALBYID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(proposalId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<ProposalWithoutVotes>() {}));
        return executeRemoteCallSingleValueReturn(function, ProposalWithoutVotes.class);
    }

    public RemoteFunctionCall<BigInteger> getProposalState(BigInteger proposalId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETPROPOSALSTATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(proposalId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getProposalsCount() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETPROPOSALSCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Vote> getVoteOnProposal(BigInteger proposalId, String voter) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETVOTEONPROPOSAL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(proposalId), 
                new org.web3j.abi.datatypes.Address(160, voter)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Vote>() {}));
        return executeRemoteCallSingleValueReturn(function, Vote.class);
    }

    public RemoteFunctionCall<BigInteger> getVotingDelay() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETVOTINGDELAY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> isExecutorAuthorized(String executor) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISEXECUTORAUTHORIZED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, executor)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> queue(BigInteger proposalId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_QUEUE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(proposalId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setGovernanceStrategy(String governanceStrategy) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETGOVERNANCESTRATEGY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, governanceStrategy)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setVotingDelay(BigInteger votingDelay) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETVOTINGDELAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(votingDelay)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> submitVote(BigInteger proposalId, Boolean support) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SUBMITVOTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(proposalId), 
                new org.web3j.abi.datatypes.Bool(support)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> submitVoteBySignature(BigInteger proposalId, Boolean support, BigInteger v, byte[] r, byte[] s) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SUBMITVOTEBYSIGNATURE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(proposalId), 
                new org.web3j.abi.datatypes.Bool(support), 
                new org.web3j.abi.datatypes.generated.Uint8(v), 
                new org.web3j.abi.datatypes.generated.Bytes32(r), 
                new org.web3j.abi.datatypes.generated.Bytes32(s)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> unauthorizeExecutors(List<String> executors) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UNAUTHORIZEEXECUTORS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(executors, org.web3j.abi.datatypes.Address.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static IAaveGovernanceV2 load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IAaveGovernanceV2(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static IAaveGovernanceV2 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IAaveGovernanceV2(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static IAaveGovernanceV2 load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new IAaveGovernanceV2(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static IAaveGovernanceV2 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new IAaveGovernanceV2(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<IAaveGovernanceV2> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IAaveGovernanceV2.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IAaveGovernanceV2> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IAaveGovernanceV2.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<IAaveGovernanceV2> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IAaveGovernanceV2.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IAaveGovernanceV2> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IAaveGovernanceV2.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class ProposalWithoutVotes extends DynamicStruct {
        public BigInteger id;

        public String creator;

        public String executor;

        public List<String> targets;

        public List<BigInteger> values;

        public List<String> signatures;

        public List<byte[]> calldatas;

        public List<Boolean> withDelegatecalls;

        public BigInteger startBlock;

        public BigInteger endBlock;

        public BigInteger executionTime;

        public BigInteger forVotes;

        public BigInteger againstVotes;

        public Boolean executed;

        public Boolean canceled;

        public String strategy;

        public byte[] ipfsHash;

        public ProposalWithoutVotes(BigInteger id, String creator, String executor, List<String> targets, List<BigInteger> values, List<String> signatures, List<byte[]> calldatas, List<Boolean> withDelegatecalls, BigInteger startBlock, BigInteger endBlock, BigInteger executionTime, BigInteger forVotes, BigInteger againstVotes, Boolean executed, Boolean canceled, String strategy, byte[] ipfsHash) {
            super(new org.web3j.abi.datatypes.generated.Uint256(id),new org.web3j.abi.datatypes.Address(creator),new org.web3j.abi.datatypes.Address(executor),new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>((Address) targets),new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>((Uint256) values),new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Utf8String>((Utf8String) signatures),new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.DynamicBytes>((DynamicBytes) calldatas),new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Bool>((Bool) withDelegatecalls),new org.web3j.abi.datatypes.generated.Uint256(startBlock),new org.web3j.abi.datatypes.generated.Uint256(endBlock),new org.web3j.abi.datatypes.generated.Uint256(executionTime),new org.web3j.abi.datatypes.generated.Uint256(forVotes),new org.web3j.abi.datatypes.generated.Uint256(againstVotes),new org.web3j.abi.datatypes.Bool(executed),new org.web3j.abi.datatypes.Bool(canceled),new org.web3j.abi.datatypes.Address(strategy),new org.web3j.abi.datatypes.generated.Bytes32(ipfsHash));
            this.id = id;
            this.creator = creator;
            this.executor = executor;
            this.targets = targets;
            this.values = values;
            this.signatures = signatures;
            this.calldatas = calldatas;
            this.withDelegatecalls = withDelegatecalls;
            this.startBlock = startBlock;
            this.endBlock = endBlock;
            this.executionTime = executionTime;
            this.forVotes = forVotes;
            this.againstVotes = againstVotes;
            this.executed = executed;
            this.canceled = canceled;
            this.strategy = strategy;
            this.ipfsHash = ipfsHash;
        }

        public ProposalWithoutVotes(Uint256 id, Address creator, Address executor, DynamicArray<Address> targets, DynamicArray<Uint256> values, DynamicArray<Utf8String> signatures, DynamicArray<DynamicBytes> calldatas, DynamicArray<Bool> withDelegatecalls, Uint256 startBlock, Uint256 endBlock, Uint256 executionTime, Uint256 forVotes, Uint256 againstVotes, Bool executed, Bool canceled, Address strategy, Bytes32 ipfsHash) {
            super(id,creator,executor,targets,values,signatures,calldatas,withDelegatecalls,startBlock,endBlock,executionTime,forVotes,againstVotes,executed,canceled,strategy,ipfsHash);
            this.id = id.getValue();
            this.creator = creator.getValue();
            this.executor = executor.getValue();
            this.targets = targets.getValue();
            this.values = values.getValue();
            this.signatures = signatures.getValue();
            this.calldatas = calldatas.getValue();
            this.withDelegatecalls = withDelegatecalls.getValue();
            this.startBlock = startBlock.getValue();
            this.endBlock = endBlock.getValue();
            this.executionTime = executionTime.getValue();
            this.forVotes = forVotes.getValue();
            this.againstVotes = againstVotes.getValue();
            this.executed = executed.getValue();
            this.canceled = canceled.getValue();
            this.strategy = strategy.getValue();
            this.ipfsHash = ipfsHash.getValue();
        }
    }

    public static class Vote extends StaticStruct {
        public Boolean support;

        public BigInteger votingPower;

        public Vote(Boolean support, BigInteger votingPower) {
            super(new org.web3j.abi.datatypes.Bool(support),new org.web3j.abi.datatypes.generated.Uint248(votingPower));
            this.support = support;
            this.votingPower = votingPower;
        }

        public Vote(Bool support, Uint248 votingPower) {
            super(support,votingPower);
            this.support = support.getValue();
            this.votingPower = votingPower.getValue();
        }
    }

    public static class ExecutorAuthorizedEventResponse extends BaseEventResponse {
        public String executor;
    }

    public static class ExecutorUnauthorizedEventResponse extends BaseEventResponse {
        public String executor;
    }

    public static class GovernanceStrategyChangedEventResponse extends BaseEventResponse {
        public String newStrategy;

        public String initiatorChange;
    }

    public static class ProposalCanceledEventResponse extends BaseEventResponse {
        public BigInteger id;
    }

    public static class ProposalCreatedEventResponse extends BaseEventResponse {
        public String creator;

        public String executor;

        public BigInteger id;

        public List<String> targets;

        public List<BigInteger> values;

        public List<String> signatures;

        public List<byte[]> calldatas;

        public List<Boolean> withDelegatecalls;

        public BigInteger startBlock;

        public BigInteger endBlock;

        public String strategy;

        public byte[] ipfsHash;
    }

    public static class ProposalExecutedEventResponse extends BaseEventResponse {
        public String initiatorExecution;

        public BigInteger id;
    }

    public static class ProposalQueuedEventResponse extends BaseEventResponse {
        public String initiatorQueueing;

        public BigInteger id;

        public BigInteger executionTime;
    }

    public static class VoteEmittedEventResponse extends BaseEventResponse {
        public String voter;

        public BigInteger id;

        public Boolean support;

        public BigInteger votingPower;
    }

    public static class VotingDelayChangedEventResponse extends BaseEventResponse {
        public String initiatorChange;

        public BigInteger newVotingDelay;
    }
}
