package com.arnAAVE.java_sdk.lendingPool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.StaticStruct;
import org.web3j.abi.datatypes.generated.Uint128;
import org.web3j.abi.datatypes.generated.Uint40;
import org.web3j.abi.datatypes.generated.Uint8;

import java.math.BigInteger;

@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
public class ReserveData extends StaticStruct {
    public ILendingPool.ReserveConfigurationMap configuration;

    public BigInteger liquidityIndex;

    public BigInteger variableBorrowIndex;

    public BigInteger currentLiquidityRate;

    public BigInteger currentVariableBorrowRate;

    public BigInteger currentStableBorrowRate;

    public BigInteger lastUpdateTimestamp;

    public String aTokenAddress;

    public String stableDebtTokenAddress;

    public String variableDebtTokenAddress;

    public String interestRateStrategyAddress;

    public BigInteger id;

    public ReserveData(ILendingPool.ReserveConfigurationMap configuration, BigInteger liquidityIndex, BigInteger variableBorrowIndex, BigInteger currentLiquidityRate, BigInteger currentVariableBorrowRate, BigInteger currentStableBorrowRate, BigInteger lastUpdateTimestamp, String aTokenAddress, String stableDebtTokenAddress, String variableDebtTokenAddress, String interestRateStrategyAddress, BigInteger id) {
        super(configuration,new org.web3j.abi.datatypes.generated.Uint128(liquidityIndex),new org.web3j.abi.datatypes.generated.Uint128(variableBorrowIndex),new org.web3j.abi.datatypes.generated.Uint128(currentLiquidityRate),new org.web3j.abi.datatypes.generated.Uint128(currentVariableBorrowRate),new org.web3j.abi.datatypes.generated.Uint128(currentStableBorrowRate),new org.web3j.abi.datatypes.generated.Uint40(lastUpdateTimestamp),new org.web3j.abi.datatypes.Address(aTokenAddress),new org.web3j.abi.datatypes.Address(stableDebtTokenAddress),new org.web3j.abi.datatypes.Address(variableDebtTokenAddress),new org.web3j.abi.datatypes.Address(interestRateStrategyAddress),new org.web3j.abi.datatypes.generated.Uint8(id));
        this.configuration = configuration;
        this.liquidityIndex = liquidityIndex;
        this.variableBorrowIndex = variableBorrowIndex;
        this.currentLiquidityRate = currentLiquidityRate;
        this.currentVariableBorrowRate = currentVariableBorrowRate;
        this.currentStableBorrowRate = currentStableBorrowRate;
        this.lastUpdateTimestamp = lastUpdateTimestamp;
        this.aTokenAddress = aTokenAddress;
        this.stableDebtTokenAddress = stableDebtTokenAddress;
        this.variableDebtTokenAddress = variableDebtTokenAddress;
        this.interestRateStrategyAddress = interestRateStrategyAddress;
        this.id = id;
    }

    public ReserveData(ILendingPool.ReserveConfigurationMap configuration, Uint128 liquidityIndex, Uint128 variableBorrowIndex, Uint128 currentLiquidityRate, Uint128 currentVariableBorrowRate, Uint128 currentStableBorrowRate, Uint40 lastUpdateTimestamp, Address aTokenAddress, Address stableDebtTokenAddress, Address variableDebtTokenAddress, Address interestRateStrategyAddress, Uint8 id) {
        super(configuration,liquidityIndex,variableBorrowIndex,currentLiquidityRate,currentVariableBorrowRate,currentStableBorrowRate,lastUpdateTimestamp,aTokenAddress,stableDebtTokenAddress,variableDebtTokenAddress,interestRateStrategyAddress,id);
        this.configuration = configuration;
        this.liquidityIndex = liquidityIndex.getValue();
        this.variableBorrowIndex = variableBorrowIndex.getValue();
        this.currentLiquidityRate = currentLiquidityRate.getValue();
        this.currentVariableBorrowRate = currentVariableBorrowRate.getValue();
        this.currentStableBorrowRate = currentStableBorrowRate.getValue();
        this.lastUpdateTimestamp = lastUpdateTimestamp.getValue();
        this.aTokenAddress = aTokenAddress.getValue();
        this.stableDebtTokenAddress = stableDebtTokenAddress.getValue();
        this.variableDebtTokenAddress = variableDebtTokenAddress.getValue();
        this.interestRateStrategyAddress = interestRateStrategyAddress.getValue();
        this.id = id.getValue();
    }
}
