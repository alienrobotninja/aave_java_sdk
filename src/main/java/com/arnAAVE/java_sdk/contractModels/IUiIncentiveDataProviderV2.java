package com.arnAAVE.java_sdk.contractModels;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.StaticStruct;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.tuples.generated.Tuple2;
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
public class IUiIncentiveDataProviderV2 extends Contract {
    public static final String BINARY = "";

    public static final String FUNC_GETFULLRESERVESINCENTIVEDATA = "getFullReservesIncentiveData";

    public static final String FUNC_GETRESERVESINCENTIVESDATA = "getReservesIncentivesData";

    public static final String FUNC_GETUSERRESERVESINCENTIVESDATA = "getUserReservesIncentivesData";

    @Deprecated
    protected IUiIncentiveDataProviderV2(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IUiIncentiveDataProviderV2(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected IUiIncentiveDataProviderV2(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected IUiIncentiveDataProviderV2(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Tuple2<List<AggregatedReserveIncentiveData>, List<UserReserveIncentiveData>>> getFullReservesIncentiveData(String provider, String user) {
        final Function function = new Function(FUNC_GETFULLRESERVESINCENTIVEDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, provider), 
                new org.web3j.abi.datatypes.Address(160, user)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<AggregatedReserveIncentiveData>>() {}, new TypeReference<DynamicArray<UserReserveIncentiveData>>() {}));
        return new RemoteFunctionCall<Tuple2<List<AggregatedReserveIncentiveData>, List<UserReserveIncentiveData>>>(function,
                new Callable<Tuple2<List<AggregatedReserveIncentiveData>, List<UserReserveIncentiveData>>>() {
                    @Override
                    public Tuple2<List<AggregatedReserveIncentiveData>, List<UserReserveIncentiveData>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<List<AggregatedReserveIncentiveData>, List<UserReserveIncentiveData>>(
                                convertToNative((List<AggregatedReserveIncentiveData>) results.get(0).getValue()), 
                                convertToNative((List<UserReserveIncentiveData>) results.get(1).getValue()));
                    }
                });
    }

    public RemoteFunctionCall<List> getReservesIncentivesData(String provider) {
        final Function function = new Function(FUNC_GETRESERVESINCENTIVESDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, provider)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<AggregatedReserveIncentiveData>>() {}));
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

    public RemoteFunctionCall<List> getUserReservesIncentivesData(String provider, String user) {
        final Function function = new Function(FUNC_GETUSERRESERVESINCENTIVESDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, provider), 
                new org.web3j.abi.datatypes.Address(160, user)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<UserReserveIncentiveData>>() {}));
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

    @Deprecated
    public static IUiIncentiveDataProviderV2 load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IUiIncentiveDataProviderV2(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static IUiIncentiveDataProviderV2 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IUiIncentiveDataProviderV2(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static IUiIncentiveDataProviderV2 load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new IUiIncentiveDataProviderV2(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static IUiIncentiveDataProviderV2 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new IUiIncentiveDataProviderV2(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<IUiIncentiveDataProviderV2> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IUiIncentiveDataProviderV2.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IUiIncentiveDataProviderV2> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IUiIncentiveDataProviderV2.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<IUiIncentiveDataProviderV2> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IUiIncentiveDataProviderV2.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IUiIncentiveDataProviderV2> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IUiIncentiveDataProviderV2.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class IncentiveData extends StaticStruct {
        public BigInteger emissionPerSecond;

        public BigInteger incentivesLastUpdateTimestamp;

        public BigInteger tokenIncentivesIndex;

        public BigInteger emissionEndTimestamp;

        public String tokenAddress;

        public String rewardTokenAddress;

        public String incentiveControllerAddress;

        public BigInteger rewardTokenDecimals;

        public BigInteger precision;

        public IncentiveData(BigInteger emissionPerSecond, BigInteger incentivesLastUpdateTimestamp, BigInteger tokenIncentivesIndex, BigInteger emissionEndTimestamp, String tokenAddress, String rewardTokenAddress, String incentiveControllerAddress, BigInteger rewardTokenDecimals, BigInteger precision) {
            super(new org.web3j.abi.datatypes.generated.Uint256(emissionPerSecond),new org.web3j.abi.datatypes.generated.Uint256(incentivesLastUpdateTimestamp),new org.web3j.abi.datatypes.generated.Uint256(tokenIncentivesIndex),new org.web3j.abi.datatypes.generated.Uint256(emissionEndTimestamp),new org.web3j.abi.datatypes.Address(tokenAddress),new org.web3j.abi.datatypes.Address(rewardTokenAddress),new org.web3j.abi.datatypes.Address(incentiveControllerAddress),new org.web3j.abi.datatypes.generated.Uint8(rewardTokenDecimals),new org.web3j.abi.datatypes.generated.Uint8(precision));
            this.emissionPerSecond = emissionPerSecond;
            this.incentivesLastUpdateTimestamp = incentivesLastUpdateTimestamp;
            this.tokenIncentivesIndex = tokenIncentivesIndex;
            this.emissionEndTimestamp = emissionEndTimestamp;
            this.tokenAddress = tokenAddress;
            this.rewardTokenAddress = rewardTokenAddress;
            this.incentiveControllerAddress = incentiveControllerAddress;
            this.rewardTokenDecimals = rewardTokenDecimals;
            this.precision = precision;
        }

        public IncentiveData(Uint256 emissionPerSecond, Uint256 incentivesLastUpdateTimestamp, Uint256 tokenIncentivesIndex, Uint256 emissionEndTimestamp, Address tokenAddress, Address rewardTokenAddress, Address incentiveControllerAddress, Uint8 rewardTokenDecimals, Uint8 precision) {
            super(emissionPerSecond,incentivesLastUpdateTimestamp,tokenIncentivesIndex,emissionEndTimestamp,tokenAddress,rewardTokenAddress,incentiveControllerAddress,rewardTokenDecimals,precision);
            this.emissionPerSecond = emissionPerSecond.getValue();
            this.incentivesLastUpdateTimestamp = incentivesLastUpdateTimestamp.getValue();
            this.tokenIncentivesIndex = tokenIncentivesIndex.getValue();
            this.emissionEndTimestamp = emissionEndTimestamp.getValue();
            this.tokenAddress = tokenAddress.getValue();
            this.rewardTokenAddress = rewardTokenAddress.getValue();
            this.incentiveControllerAddress = incentiveControllerAddress.getValue();
            this.rewardTokenDecimals = rewardTokenDecimals.getValue();
            this.precision = precision.getValue();
        }
    }

    public static class UserIncentiveData extends StaticStruct {
        public BigInteger tokenincentivesUserIndex;

        public BigInteger userUnclaimedRewards;

        public String tokenAddress;

        public String rewardTokenAddress;

        public String incentiveControllerAddress;

        public BigInteger rewardTokenDecimals;

        public UserIncentiveData(BigInteger tokenincentivesUserIndex, BigInteger userUnclaimedRewards, String tokenAddress, String rewardTokenAddress, String incentiveControllerAddress, BigInteger rewardTokenDecimals) {
            super(new org.web3j.abi.datatypes.generated.Uint256(tokenincentivesUserIndex),new org.web3j.abi.datatypes.generated.Uint256(userUnclaimedRewards),new org.web3j.abi.datatypes.Address(tokenAddress),new org.web3j.abi.datatypes.Address(rewardTokenAddress),new org.web3j.abi.datatypes.Address(incentiveControllerAddress),new org.web3j.abi.datatypes.generated.Uint8(rewardTokenDecimals));
            this.tokenincentivesUserIndex = tokenincentivesUserIndex;
            this.userUnclaimedRewards = userUnclaimedRewards;
            this.tokenAddress = tokenAddress;
            this.rewardTokenAddress = rewardTokenAddress;
            this.incentiveControllerAddress = incentiveControllerAddress;
            this.rewardTokenDecimals = rewardTokenDecimals;
        }

        public UserIncentiveData(Uint256 tokenincentivesUserIndex, Uint256 userUnclaimedRewards, Address tokenAddress, Address rewardTokenAddress, Address incentiveControllerAddress, Uint8 rewardTokenDecimals) {
            super(tokenincentivesUserIndex,userUnclaimedRewards,tokenAddress,rewardTokenAddress,incentiveControllerAddress,rewardTokenDecimals);
            this.tokenincentivesUserIndex = tokenincentivesUserIndex.getValue();
            this.userUnclaimedRewards = userUnclaimedRewards.getValue();
            this.tokenAddress = tokenAddress.getValue();
            this.rewardTokenAddress = rewardTokenAddress.getValue();
            this.incentiveControllerAddress = incentiveControllerAddress.getValue();
            this.rewardTokenDecimals = rewardTokenDecimals.getValue();
        }
    }

    public static class AggregatedReserveIncentiveData extends StaticStruct {
        public String underlyingAsset;

        public IncentiveData aIncentiveData;

        public IncentiveData vIncentiveData;

        public IncentiveData sIncentiveData;

        public AggregatedReserveIncentiveData(String underlyingAsset, IncentiveData aIncentiveData, IncentiveData vIncentiveData, IncentiveData sIncentiveData) {
            super(new org.web3j.abi.datatypes.Address(underlyingAsset),aIncentiveData,vIncentiveData,sIncentiveData);
            this.underlyingAsset = underlyingAsset;
            this.aIncentiveData = aIncentiveData;
            this.vIncentiveData = vIncentiveData;
            this.sIncentiveData = sIncentiveData;
        }

        public AggregatedReserveIncentiveData(Address underlyingAsset, IncentiveData aIncentiveData, IncentiveData vIncentiveData, IncentiveData sIncentiveData) {
            super(underlyingAsset,aIncentiveData,vIncentiveData,sIncentiveData);
            this.underlyingAsset = underlyingAsset.getValue();
            this.aIncentiveData = aIncentiveData;
            this.vIncentiveData = vIncentiveData;
            this.sIncentiveData = sIncentiveData;
        }
    }

    public static class UserReserveIncentiveData extends StaticStruct {
        public String underlyingAsset;

        public UserIncentiveData aTokenIncentivesUserData;

        public UserIncentiveData vTokenIncentivesUserData;

        public UserIncentiveData sTokenIncentivesUserData;

        public UserReserveIncentiveData(String underlyingAsset, UserIncentiveData aTokenIncentivesUserData, UserIncentiveData vTokenIncentivesUserData, UserIncentiveData sTokenIncentivesUserData) {
            super(new org.web3j.abi.datatypes.Address(underlyingAsset),aTokenIncentivesUserData,vTokenIncentivesUserData,sTokenIncentivesUserData);
            this.underlyingAsset = underlyingAsset;
            this.aTokenIncentivesUserData = aTokenIncentivesUserData;
            this.vTokenIncentivesUserData = vTokenIncentivesUserData;
            this.sTokenIncentivesUserData = sTokenIncentivesUserData;
        }

        public UserReserveIncentiveData(Address underlyingAsset, UserIncentiveData aTokenIncentivesUserData, UserIncentiveData vTokenIncentivesUserData, UserIncentiveData sTokenIncentivesUserData) {
            super(underlyingAsset,aTokenIncentivesUserData,vTokenIncentivesUserData,sTokenIncentivesUserData);
            this.underlyingAsset = underlyingAsset.getValue();
            this.aTokenIncentivesUserData = aTokenIncentivesUserData;
            this.vTokenIncentivesUserData = vTokenIncentivesUserData;
            this.sTokenIncentivesUserData = sTokenIncentivesUserData;
        }
    }
}
