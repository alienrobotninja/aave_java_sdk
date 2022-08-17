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
public class ICreditDelegationToken extends Contract {
    public static final String BINARY = "";

    public static final String FUNC_APPROVEDELEGATION = "approveDelegation";

    public static final String FUNC_BORROWALLOWANCE = "borrowAllowance";

    public static final Event BORROWALLOWANCEDELEGATED_EVENT = new Event("BorrowAllowanceDelegated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected ICreditDelegationToken(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ICreditDelegationToken(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ICreditDelegationToken(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ICreditDelegationToken(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<BorrowAllowanceDelegatedEventResponse> getBorrowAllowanceDelegatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(BORROWALLOWANCEDELEGATED_EVENT, transactionReceipt);
        ArrayList<BorrowAllowanceDelegatedEventResponse> responses = new ArrayList<BorrowAllowanceDelegatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            BorrowAllowanceDelegatedEventResponse typedResponse = new BorrowAllowanceDelegatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.fromUser = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.toUser = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.asset = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<BorrowAllowanceDelegatedEventResponse> borrowAllowanceDelegatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, BorrowAllowanceDelegatedEventResponse>() {
            @Override
            public BorrowAllowanceDelegatedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(BORROWALLOWANCEDELEGATED_EVENT, log);
                BorrowAllowanceDelegatedEventResponse typedResponse = new BorrowAllowanceDelegatedEventResponse();
                typedResponse.log = log;
                typedResponse.fromUser = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.toUser = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.asset = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<BorrowAllowanceDelegatedEventResponse> borrowAllowanceDelegatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(BORROWALLOWANCEDELEGATED_EVENT));
        return borrowAllowanceDelegatedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> approveDelegation(String delegatee, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_APPROVEDELEGATION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, delegatee), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> borrowAllowance(String fromUser, String toUser) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BORROWALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, fromUser), 
                new org.web3j.abi.datatypes.Address(160, toUser)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static ICreditDelegationToken load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ICreditDelegationToken(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ICreditDelegationToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ICreditDelegationToken(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ICreditDelegationToken load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ICreditDelegationToken(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ICreditDelegationToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ICreditDelegationToken(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ICreditDelegationToken> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ICreditDelegationToken.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ICreditDelegationToken> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ICreditDelegationToken.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ICreditDelegationToken> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ICreditDelegationToken.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ICreditDelegationToken> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ICreditDelegationToken.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class BorrowAllowanceDelegatedEventResponse extends BaseEventResponse {
        public String fromUser;

        public String toUser;

        public String asset;

        public BigInteger amount;
    }
}
