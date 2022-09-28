package com.arnAAVE.java_sdk.Staking;

import com.arnAAVE.java_sdk.contractModels.IStakedToken;
import com.arnAAVE.java_sdk.lendingPool.AaveConnect;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

public class StakingAccess {
    private final IStakedToken iStakedToken;

    public StakingAccess(AaveConnect connection, String iStakedTokenAddress, String gasFee, String gasLimit) {
        ContractGasProvider provider = new StaticGasProvider(new BigInteger(gasFee), new BigInteger(gasLimit));
        this.iStakedToken = new IStakedToken(iStakedTokenAddress, connection.getWeb3j(), connection.getCredentials(),provider);
    }

    public String staked_token() throws Exception {
        return iStakedToken.STAKED_TOKEN().send();
    }

    public TransactionReceipt claimRewards(String to, BigInteger amount ) throws Exception {
        return  iStakedToken.claimRewards(to, amount).send();
    }

    public TransactionReceipt stake(String onBehafOf, BigInteger amount) throws Exception {
        return  iStakedToken.stake(onBehafOf,amount).send();
    }

    public TransactionReceipt redeem(String to, BigInteger amount) throws Exception {
        return  iStakedToken.redeem(to, amount).send();
    }

}
