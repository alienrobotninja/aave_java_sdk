package com.arnAAVE.java_sdk.Staking;

import com.arnAAVE.java_sdk.contractModels.IStakedToken;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

public class StakingAccess {

    private static final Web3j web3j = Web3j.build(new HttpService(
            "https://goerli.infura.io/v3/b8c7cedb8701445bb9210f4731e42c0a"));
    private static final Credentials credentials = Credentials.create("1238370fb9507a697d2744d9c511061a0c3cc284eba1af1fa7b24854a9084219");

    private ContractGasProvider provider = new StaticGasProvider(new BigInteger("2000000"), new BigInteger("2000000"));

    private IStakedToken iStakedToken = new IStakedToken("", web3j, credentials, provider);


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
