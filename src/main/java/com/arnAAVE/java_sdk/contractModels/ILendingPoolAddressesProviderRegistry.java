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
public class ILendingPoolAddressesProviderRegistry extends Contract {
    public static final String BINARY = "";

    public static final String FUNC_GETADDRESSESPROVIDERIDBYADDRESS = "getAddressesProviderIdByAddress";

    public static final String FUNC_GETADDRESSESPROVIDERSLIST = "getAddressesProvidersList";

    public static final String FUNC_REGISTERADDRESSESPROVIDER = "registerAddressesProvider";

    public static final String FUNC_UNREGISTERADDRESSESPROVIDER = "unregisterAddressesProvider";

    public static final Event ADDRESSESPROVIDERREGISTERED_EVENT = new Event("AddressesProviderRegistered", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event ADDRESSESPROVIDERUNREGISTERED_EVENT = new Event("AddressesProviderUnregistered", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected ILendingPoolAddressesProviderRegistry(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ILendingPoolAddressesProviderRegistry(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ILendingPoolAddressesProviderRegistry(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ILendingPoolAddressesProviderRegistry(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<AddressesProviderRegisteredEventResponse> getAddressesProviderRegisteredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ADDRESSESPROVIDERREGISTERED_EVENT, transactionReceipt);
        ArrayList<AddressesProviderRegisteredEventResponse> responses = new ArrayList<AddressesProviderRegisteredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AddressesProviderRegisteredEventResponse typedResponse = new AddressesProviderRegisteredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.newAddress = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AddressesProviderRegisteredEventResponse> addressesProviderRegisteredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, AddressesProviderRegisteredEventResponse>() {
            @Override
            public AddressesProviderRegisteredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ADDRESSESPROVIDERREGISTERED_EVENT, log);
                AddressesProviderRegisteredEventResponse typedResponse = new AddressesProviderRegisteredEventResponse();
                typedResponse.log = log;
                typedResponse.newAddress = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AddressesProviderRegisteredEventResponse> addressesProviderRegisteredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADDRESSESPROVIDERREGISTERED_EVENT));
        return addressesProviderRegisteredEventFlowable(filter);
    }

    public List<AddressesProviderUnregisteredEventResponse> getAddressesProviderUnregisteredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ADDRESSESPROVIDERUNREGISTERED_EVENT, transactionReceipt);
        ArrayList<AddressesProviderUnregisteredEventResponse> responses = new ArrayList<AddressesProviderUnregisteredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AddressesProviderUnregisteredEventResponse typedResponse = new AddressesProviderUnregisteredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.newAddress = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AddressesProviderUnregisteredEventResponse> addressesProviderUnregisteredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, AddressesProviderUnregisteredEventResponse>() {
            @Override
            public AddressesProviderUnregisteredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ADDRESSESPROVIDERUNREGISTERED_EVENT, log);
                AddressesProviderUnregisteredEventResponse typedResponse = new AddressesProviderUnregisteredEventResponse();
                typedResponse.log = log;
                typedResponse.newAddress = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AddressesProviderUnregisteredEventResponse> addressesProviderUnregisteredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADDRESSESPROVIDERUNREGISTERED_EVENT));
        return addressesProviderUnregisteredEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> getAddressesProviderIdByAddress(String addressesProvider) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETADDRESSESPROVIDERIDBYADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addressesProvider)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<List> getAddressesProvidersList() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETADDRESSESPROVIDERSLIST, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> registerAddressesProvider(String provider, BigInteger id) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REGISTERADDRESSESPROVIDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, provider), 
                new org.web3j.abi.datatypes.generated.Uint256(id)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> unregisterAddressesProvider(String provider) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UNREGISTERADDRESSESPROVIDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, provider)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ILendingPoolAddressesProviderRegistry load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ILendingPoolAddressesProviderRegistry(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ILendingPoolAddressesProviderRegistry load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ILendingPoolAddressesProviderRegistry(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ILendingPoolAddressesProviderRegistry load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ILendingPoolAddressesProviderRegistry(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ILendingPoolAddressesProviderRegistry load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ILendingPoolAddressesProviderRegistry(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ILendingPoolAddressesProviderRegistry> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ILendingPoolAddressesProviderRegistry.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ILendingPoolAddressesProviderRegistry> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ILendingPoolAddressesProviderRegistry.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ILendingPoolAddressesProviderRegistry> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ILendingPoolAddressesProviderRegistry.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ILendingPoolAddressesProviderRegistry> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ILendingPoolAddressesProviderRegistry.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class AddressesProviderRegisteredEventResponse extends BaseEventResponse {
        public String newAddress;
    }

    public static class AddressesProviderUnregisteredEventResponse extends BaseEventResponse {
        public String newAddress;
    }
}
