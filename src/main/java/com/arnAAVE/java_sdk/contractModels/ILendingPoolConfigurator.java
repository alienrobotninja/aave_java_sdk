package com.arnAAVE.java_sdk.contractModels;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
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
public class ILendingPoolConfigurator extends Contract {
    public static final String BINARY = "";

    public static final Event ATOKENUPGRADED_EVENT = new Event("ATokenUpgraded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event BORROWINGDISABLEDONRESERVE_EVENT = new Event("BorrowingDisabledOnReserve", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event BORROWINGENABLEDONRESERVE_EVENT = new Event("BorrowingEnabledOnReserve", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Bool>() {}));
    ;

    public static final Event COLLATERALCONFIGURATIONCHANGED_EVENT = new Event("CollateralConfigurationChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event RESERVEACTIVATED_EVENT = new Event("ReserveActivated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event RESERVEDEACTIVATED_EVENT = new Event("ReserveDeactivated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event RESERVEDECIMALSCHANGED_EVENT = new Event("ReserveDecimalsChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event RESERVEFACTORCHANGED_EVENT = new Event("ReserveFactorChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event RESERVEFROZEN_EVENT = new Event("ReserveFrozen", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event RESERVEINITIALIZED_EVENT = new Event("ReserveInitialized", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event RESERVEINTERESTRATESTRATEGYCHANGED_EVENT = new Event("ReserveInterestRateStrategyChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>() {}));
    ;

    public static final Event RESERVEUNFROZEN_EVENT = new Event("ReserveUnfrozen", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event STABLEDEBTTOKENUPGRADED_EVENT = new Event("StableDebtTokenUpgraded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event STABLERATEDISABLEDONRESERVE_EVENT = new Event("StableRateDisabledOnReserve", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event STABLERATEENABLEDONRESERVE_EVENT = new Event("StableRateEnabledOnReserve", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event VARIABLEDEBTTOKENUPGRADED_EVENT = new Event("VariableDebtTokenUpgraded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected ILendingPoolConfigurator(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ILendingPoolConfigurator(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ILendingPoolConfigurator(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ILendingPoolConfigurator(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<ATokenUpgradedEventResponse> getATokenUpgradedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ATOKENUPGRADED_EVENT, transactionReceipt);
        ArrayList<ATokenUpgradedEventResponse> responses = new ArrayList<ATokenUpgradedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ATokenUpgradedEventResponse typedResponse = new ATokenUpgradedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.proxy = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.implementation = (String) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ATokenUpgradedEventResponse> aTokenUpgradedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ATokenUpgradedEventResponse>() {
            @Override
            public ATokenUpgradedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ATOKENUPGRADED_EVENT, log);
                ATokenUpgradedEventResponse typedResponse = new ATokenUpgradedEventResponse();
                typedResponse.log = log;
                typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.proxy = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.implementation = (String) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ATokenUpgradedEventResponse> aTokenUpgradedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ATOKENUPGRADED_EVENT));
        return aTokenUpgradedEventFlowable(filter);
    }

    public List<BorrowingDisabledOnReserveEventResponse> getBorrowingDisabledOnReserveEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(BORROWINGDISABLEDONRESERVE_EVENT, transactionReceipt);
        ArrayList<BorrowingDisabledOnReserveEventResponse> responses = new ArrayList<BorrowingDisabledOnReserveEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            BorrowingDisabledOnReserveEventResponse typedResponse = new BorrowingDisabledOnReserveEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<BorrowingDisabledOnReserveEventResponse> borrowingDisabledOnReserveEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, BorrowingDisabledOnReserveEventResponse>() {
            @Override
            public BorrowingDisabledOnReserveEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(BORROWINGDISABLEDONRESERVE_EVENT, log);
                BorrowingDisabledOnReserveEventResponse typedResponse = new BorrowingDisabledOnReserveEventResponse();
                typedResponse.log = log;
                typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<BorrowingDisabledOnReserveEventResponse> borrowingDisabledOnReserveEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(BORROWINGDISABLEDONRESERVE_EVENT));
        return borrowingDisabledOnReserveEventFlowable(filter);
    }

    public List<BorrowingEnabledOnReserveEventResponse> getBorrowingEnabledOnReserveEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(BORROWINGENABLEDONRESERVE_EVENT, transactionReceipt);
        ArrayList<BorrowingEnabledOnReserveEventResponse> responses = new ArrayList<BorrowingEnabledOnReserveEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            BorrowingEnabledOnReserveEventResponse typedResponse = new BorrowingEnabledOnReserveEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.stableRateEnabled = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<BorrowingEnabledOnReserveEventResponse> borrowingEnabledOnReserveEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, BorrowingEnabledOnReserveEventResponse>() {
            @Override
            public BorrowingEnabledOnReserveEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(BORROWINGENABLEDONRESERVE_EVENT, log);
                BorrowingEnabledOnReserveEventResponse typedResponse = new BorrowingEnabledOnReserveEventResponse();
                typedResponse.log = log;
                typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.stableRateEnabled = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<BorrowingEnabledOnReserveEventResponse> borrowingEnabledOnReserveEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(BORROWINGENABLEDONRESERVE_EVENT));
        return borrowingEnabledOnReserveEventFlowable(filter);
    }

    public List<CollateralConfigurationChangedEventResponse> getCollateralConfigurationChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(COLLATERALCONFIGURATIONCHANGED_EVENT, transactionReceipt);
        ArrayList<CollateralConfigurationChangedEventResponse> responses = new ArrayList<CollateralConfigurationChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CollateralConfigurationChangedEventResponse typedResponse = new CollateralConfigurationChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.ltv = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.liquidationThreshold = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.liquidationBonus = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<CollateralConfigurationChangedEventResponse> collateralConfigurationChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, CollateralConfigurationChangedEventResponse>() {
            @Override
            public CollateralConfigurationChangedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(COLLATERALCONFIGURATIONCHANGED_EVENT, log);
                CollateralConfigurationChangedEventResponse typedResponse = new CollateralConfigurationChangedEventResponse();
                typedResponse.log = log;
                typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.ltv = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.liquidationThreshold = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.liquidationBonus = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<CollateralConfigurationChangedEventResponse> collateralConfigurationChangedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(COLLATERALCONFIGURATIONCHANGED_EVENT));
        return collateralConfigurationChangedEventFlowable(filter);
    }

    public List<ReserveActivatedEventResponse> getReserveActivatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RESERVEACTIVATED_EVENT, transactionReceipt);
        ArrayList<ReserveActivatedEventResponse> responses = new ArrayList<ReserveActivatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ReserveActivatedEventResponse typedResponse = new ReserveActivatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ReserveActivatedEventResponse> reserveActivatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ReserveActivatedEventResponse>() {
            @Override
            public ReserveActivatedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RESERVEACTIVATED_EVENT, log);
                ReserveActivatedEventResponse typedResponse = new ReserveActivatedEventResponse();
                typedResponse.log = log;
                typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ReserveActivatedEventResponse> reserveActivatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RESERVEACTIVATED_EVENT));
        return reserveActivatedEventFlowable(filter);
    }

    public List<ReserveDeactivatedEventResponse> getReserveDeactivatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RESERVEDEACTIVATED_EVENT, transactionReceipt);
        ArrayList<ReserveDeactivatedEventResponse> responses = new ArrayList<ReserveDeactivatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ReserveDeactivatedEventResponse typedResponse = new ReserveDeactivatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ReserveDeactivatedEventResponse> reserveDeactivatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ReserveDeactivatedEventResponse>() {
            @Override
            public ReserveDeactivatedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RESERVEDEACTIVATED_EVENT, log);
                ReserveDeactivatedEventResponse typedResponse = new ReserveDeactivatedEventResponse();
                typedResponse.log = log;
                typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ReserveDeactivatedEventResponse> reserveDeactivatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RESERVEDEACTIVATED_EVENT));
        return reserveDeactivatedEventFlowable(filter);
    }

    public List<ReserveDecimalsChangedEventResponse> getReserveDecimalsChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RESERVEDECIMALSCHANGED_EVENT, transactionReceipt);
        ArrayList<ReserveDecimalsChangedEventResponse> responses = new ArrayList<ReserveDecimalsChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ReserveDecimalsChangedEventResponse typedResponse = new ReserveDecimalsChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.decimals = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ReserveDecimalsChangedEventResponse> reserveDecimalsChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ReserveDecimalsChangedEventResponse>() {
            @Override
            public ReserveDecimalsChangedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RESERVEDECIMALSCHANGED_EVENT, log);
                ReserveDecimalsChangedEventResponse typedResponse = new ReserveDecimalsChangedEventResponse();
                typedResponse.log = log;
                typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.decimals = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ReserveDecimalsChangedEventResponse> reserveDecimalsChangedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RESERVEDECIMALSCHANGED_EVENT));
        return reserveDecimalsChangedEventFlowable(filter);
    }

    public List<ReserveFactorChangedEventResponse> getReserveFactorChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RESERVEFACTORCHANGED_EVENT, transactionReceipt);
        ArrayList<ReserveFactorChangedEventResponse> responses = new ArrayList<ReserveFactorChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ReserveFactorChangedEventResponse typedResponse = new ReserveFactorChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.factor = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ReserveFactorChangedEventResponse> reserveFactorChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ReserveFactorChangedEventResponse>() {
            @Override
            public ReserveFactorChangedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RESERVEFACTORCHANGED_EVENT, log);
                ReserveFactorChangedEventResponse typedResponse = new ReserveFactorChangedEventResponse();
                typedResponse.log = log;
                typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.factor = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ReserveFactorChangedEventResponse> reserveFactorChangedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RESERVEFACTORCHANGED_EVENT));
        return reserveFactorChangedEventFlowable(filter);
    }

    public List<ReserveFrozenEventResponse> getReserveFrozenEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RESERVEFROZEN_EVENT, transactionReceipt);
        ArrayList<ReserveFrozenEventResponse> responses = new ArrayList<ReserveFrozenEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ReserveFrozenEventResponse typedResponse = new ReserveFrozenEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ReserveFrozenEventResponse> reserveFrozenEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ReserveFrozenEventResponse>() {
            @Override
            public ReserveFrozenEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RESERVEFROZEN_EVENT, log);
                ReserveFrozenEventResponse typedResponse = new ReserveFrozenEventResponse();
                typedResponse.log = log;
                typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ReserveFrozenEventResponse> reserveFrozenEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RESERVEFROZEN_EVENT));
        return reserveFrozenEventFlowable(filter);
    }

    public List<ReserveInitializedEventResponse> getReserveInitializedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RESERVEINITIALIZED_EVENT, transactionReceipt);
        ArrayList<ReserveInitializedEventResponse> responses = new ArrayList<ReserveInitializedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ReserveInitializedEventResponse typedResponse = new ReserveInitializedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.aToken = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.stableDebtToken = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.variableDebtToken = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.interestRateStrategyAddress = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ReserveInitializedEventResponse> reserveInitializedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ReserveInitializedEventResponse>() {
            @Override
            public ReserveInitializedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RESERVEINITIALIZED_EVENT, log);
                ReserveInitializedEventResponse typedResponse = new ReserveInitializedEventResponse();
                typedResponse.log = log;
                typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.aToken = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.stableDebtToken = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.variableDebtToken = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.interestRateStrategyAddress = (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ReserveInitializedEventResponse> reserveInitializedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RESERVEINITIALIZED_EVENT));
        return reserveInitializedEventFlowable(filter);
    }

    public List<ReserveInterestRateStrategyChangedEventResponse> getReserveInterestRateStrategyChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RESERVEINTERESTRATESTRATEGYCHANGED_EVENT, transactionReceipt);
        ArrayList<ReserveInterestRateStrategyChangedEventResponse> responses = new ArrayList<ReserveInterestRateStrategyChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ReserveInterestRateStrategyChangedEventResponse typedResponse = new ReserveInterestRateStrategyChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.strategy = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ReserveInterestRateStrategyChangedEventResponse> reserveInterestRateStrategyChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ReserveInterestRateStrategyChangedEventResponse>() {
            @Override
            public ReserveInterestRateStrategyChangedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RESERVEINTERESTRATESTRATEGYCHANGED_EVENT, log);
                ReserveInterestRateStrategyChangedEventResponse typedResponse = new ReserveInterestRateStrategyChangedEventResponse();
                typedResponse.log = log;
                typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.strategy = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ReserveInterestRateStrategyChangedEventResponse> reserveInterestRateStrategyChangedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RESERVEINTERESTRATESTRATEGYCHANGED_EVENT));
        return reserveInterestRateStrategyChangedEventFlowable(filter);
    }

    public List<ReserveUnfrozenEventResponse> getReserveUnfrozenEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RESERVEUNFROZEN_EVENT, transactionReceipt);
        ArrayList<ReserveUnfrozenEventResponse> responses = new ArrayList<ReserveUnfrozenEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ReserveUnfrozenEventResponse typedResponse = new ReserveUnfrozenEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ReserveUnfrozenEventResponse> reserveUnfrozenEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ReserveUnfrozenEventResponse>() {
            @Override
            public ReserveUnfrozenEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RESERVEUNFROZEN_EVENT, log);
                ReserveUnfrozenEventResponse typedResponse = new ReserveUnfrozenEventResponse();
                typedResponse.log = log;
                typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ReserveUnfrozenEventResponse> reserveUnfrozenEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RESERVEUNFROZEN_EVENT));
        return reserveUnfrozenEventFlowable(filter);
    }

    public List<StableDebtTokenUpgradedEventResponse> getStableDebtTokenUpgradedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(STABLEDEBTTOKENUPGRADED_EVENT, transactionReceipt);
        ArrayList<StableDebtTokenUpgradedEventResponse> responses = new ArrayList<StableDebtTokenUpgradedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            StableDebtTokenUpgradedEventResponse typedResponse = new StableDebtTokenUpgradedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.proxy = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.implementation = (String) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<StableDebtTokenUpgradedEventResponse> stableDebtTokenUpgradedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, StableDebtTokenUpgradedEventResponse>() {
            @Override
            public StableDebtTokenUpgradedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(STABLEDEBTTOKENUPGRADED_EVENT, log);
                StableDebtTokenUpgradedEventResponse typedResponse = new StableDebtTokenUpgradedEventResponse();
                typedResponse.log = log;
                typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.proxy = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.implementation = (String) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<StableDebtTokenUpgradedEventResponse> stableDebtTokenUpgradedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(STABLEDEBTTOKENUPGRADED_EVENT));
        return stableDebtTokenUpgradedEventFlowable(filter);
    }

    public List<StableRateDisabledOnReserveEventResponse> getStableRateDisabledOnReserveEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(STABLERATEDISABLEDONRESERVE_EVENT, transactionReceipt);
        ArrayList<StableRateDisabledOnReserveEventResponse> responses = new ArrayList<StableRateDisabledOnReserveEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            StableRateDisabledOnReserveEventResponse typedResponse = new StableRateDisabledOnReserveEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<StableRateDisabledOnReserveEventResponse> stableRateDisabledOnReserveEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, StableRateDisabledOnReserveEventResponse>() {
            @Override
            public StableRateDisabledOnReserveEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(STABLERATEDISABLEDONRESERVE_EVENT, log);
                StableRateDisabledOnReserveEventResponse typedResponse = new StableRateDisabledOnReserveEventResponse();
                typedResponse.log = log;
                typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<StableRateDisabledOnReserveEventResponse> stableRateDisabledOnReserveEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(STABLERATEDISABLEDONRESERVE_EVENT));
        return stableRateDisabledOnReserveEventFlowable(filter);
    }

    public List<StableRateEnabledOnReserveEventResponse> getStableRateEnabledOnReserveEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(STABLERATEENABLEDONRESERVE_EVENT, transactionReceipt);
        ArrayList<StableRateEnabledOnReserveEventResponse> responses = new ArrayList<StableRateEnabledOnReserveEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            StableRateEnabledOnReserveEventResponse typedResponse = new StableRateEnabledOnReserveEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<StableRateEnabledOnReserveEventResponse> stableRateEnabledOnReserveEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, StableRateEnabledOnReserveEventResponse>() {
            @Override
            public StableRateEnabledOnReserveEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(STABLERATEENABLEDONRESERVE_EVENT, log);
                StableRateEnabledOnReserveEventResponse typedResponse = new StableRateEnabledOnReserveEventResponse();
                typedResponse.log = log;
                typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<StableRateEnabledOnReserveEventResponse> stableRateEnabledOnReserveEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(STABLERATEENABLEDONRESERVE_EVENT));
        return stableRateEnabledOnReserveEventFlowable(filter);
    }

    public List<VariableDebtTokenUpgradedEventResponse> getVariableDebtTokenUpgradedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(VARIABLEDEBTTOKENUPGRADED_EVENT, transactionReceipt);
        ArrayList<VariableDebtTokenUpgradedEventResponse> responses = new ArrayList<VariableDebtTokenUpgradedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            VariableDebtTokenUpgradedEventResponse typedResponse = new VariableDebtTokenUpgradedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.proxy = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.implementation = (String) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<VariableDebtTokenUpgradedEventResponse> variableDebtTokenUpgradedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, VariableDebtTokenUpgradedEventResponse>() {
            @Override
            public VariableDebtTokenUpgradedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(VARIABLEDEBTTOKENUPGRADED_EVENT, log);
                VariableDebtTokenUpgradedEventResponse typedResponse = new VariableDebtTokenUpgradedEventResponse();
                typedResponse.log = log;
                typedResponse.asset = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.proxy = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.implementation = (String) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<VariableDebtTokenUpgradedEventResponse> variableDebtTokenUpgradedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(VARIABLEDEBTTOKENUPGRADED_EVENT));
        return variableDebtTokenUpgradedEventFlowable(filter);
    }

    @Deprecated
    public static ILendingPoolConfigurator load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ILendingPoolConfigurator(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ILendingPoolConfigurator load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ILendingPoolConfigurator(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ILendingPoolConfigurator load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ILendingPoolConfigurator(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ILendingPoolConfigurator load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ILendingPoolConfigurator(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ILendingPoolConfigurator> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ILendingPoolConfigurator.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ILendingPoolConfigurator> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ILendingPoolConfigurator.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ILendingPoolConfigurator> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ILendingPoolConfigurator.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ILendingPoolConfigurator> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ILendingPoolConfigurator.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class ATokenUpgradedEventResponse extends BaseEventResponse {
        public String asset;

        public String proxy;

        public String implementation;
    }

    public static class BorrowingDisabledOnReserveEventResponse extends BaseEventResponse {
        public String asset;
    }

    public static class BorrowingEnabledOnReserveEventResponse extends BaseEventResponse {
        public String asset;

        public Boolean stableRateEnabled;
    }

    public static class CollateralConfigurationChangedEventResponse extends BaseEventResponse {
        public String asset;

        public BigInteger ltv;

        public BigInteger liquidationThreshold;

        public BigInteger liquidationBonus;
    }

    public static class ReserveActivatedEventResponse extends BaseEventResponse {
        public String asset;
    }

    public static class ReserveDeactivatedEventResponse extends BaseEventResponse {
        public String asset;
    }

    public static class ReserveDecimalsChangedEventResponse extends BaseEventResponse {
        public String asset;

        public BigInteger decimals;
    }

    public static class ReserveFactorChangedEventResponse extends BaseEventResponse {
        public String asset;

        public BigInteger factor;
    }

    public static class ReserveFrozenEventResponse extends BaseEventResponse {
        public String asset;
    }

    public static class ReserveInitializedEventResponse extends BaseEventResponse {
        public String asset;

        public String aToken;

        public String stableDebtToken;

        public String variableDebtToken;

        public String interestRateStrategyAddress;
    }

    public static class ReserveInterestRateStrategyChangedEventResponse extends BaseEventResponse {
        public String asset;

        public String strategy;
    }

    public static class ReserveUnfrozenEventResponse extends BaseEventResponse {
        public String asset;
    }

    public static class StableDebtTokenUpgradedEventResponse extends BaseEventResponse {
        public String asset;

        public String proxy;

        public String implementation;
    }

    public static class StableRateDisabledOnReserveEventResponse extends BaseEventResponse {
        public String asset;
    }

    public static class StableRateEnabledOnReserveEventResponse extends BaseEventResponse {
        public String asset;
    }

    public static class VariableDebtTokenUpgradedEventResponse extends BaseEventResponse {
        public String asset;

        public String proxy;

        public String implementation;
    }
}
