package com.arnAAVE.java_sdk.Staking;

import com.arnAAVE.java_sdk.contractModels.IStakedToken;
import com.arnAAVE.java_sdk.lendingPool.AaveConnect;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

public class StakingAccess {


    private IStakedToken iStakedToken;


    public StakingAccess(AaveConnect connection, String iStakedTokenAddress, String gasFee, String gasLimit) {
        ContractGasProvider provider = new StaticGasProvider(new BigInteger(gasFee), new BigInteger(gasLimit));
        this.iStakedToken = new IStakedToken(iStakedTokenAddress, connection.getWeb3j(), connection.getCredentials(),provider);
    }

    public RemoteFunctionCall<String> staked_token(){
        return iStakedToken.STAKED_TOKEN();
    }

    public RemoteFunctionCall<TransactionReceipt> claimRewards(String to, BigInteger amount ){
        return  iStakedToken.claimRewards(to, amount);
    }

    public RemoteFunctionCall<TransactionReceipt> stake(String onBehafOf, BigInteger amount) {
        return  iStakedToken.stake(onBehafOf,amount);
    }

    public RemoteFunctionCall<TransactionReceipt> redeem(String to, BigInteger amount){
        return  iStakedToken.redeem(to, amount);
    }

}
