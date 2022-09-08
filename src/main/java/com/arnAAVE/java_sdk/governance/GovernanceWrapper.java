package com.arnAAVE.java_sdk.governance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;
import java.util.List;
//import com.arnAAVE.java_sdk.governance.IAaveGovernanceV2;

public class GovernanceWrapper {
    private static final Logger log = LoggerFactory.getLogger(IAaveGovernanceV2.class);
    private static final Web3j web3j = Web3j.build(new HttpService(
            "https://goerli.infura.io/v3/0730041f8bce46a2bea7e97b24c86ce3"));
    Credentials credentials =
            Credentials.create("e1ece65286e20d93efac3f6b961f4e47a5fa5fc38b8801c9e24d485c8dc234d4");
    private ContractGasProvider provider = new StaticGasProvider(new BigInteger("2000000"), new BigInteger("2000000"));
    IAaveGovernanceV2 governanceV2 =
            new IAaveGovernanceV2("0xc2ebab3bac8f2f5028f5c7317027a41ebfca31d2",web3j,credentials,provider);

    public RemoteFunctionCall<TransactionReceipt> create(String executor, List<String> targets, List<BigInteger> values, List<String> signatures, List<byte[]> calldatas, List<Boolean> withDelegatecalls, byte[] ipfsHash){

            return create(executor,targets,values,signatures,calldatas,withDelegatecalls,ipfsHash);
    }
    public RemoteFunctionCall<TransactionReceipt> cancel(BigInteger proposalId){
        return governanceV2.cancel(proposalId);
    }
    public RemoteFunctionCall<TransactionReceipt> queue(BigInteger proposalId){
    return governanceV2.queue(proposalId);
    }
    public RemoteFunctionCall<TransactionReceipt> execute(BigInteger proposalId){
        return governanceV2.execute(proposalId);
        }
    public RemoteFunctionCall<TransactionReceipt> submitVote(BigInteger proposalId, Boolean support){
        return governanceV2.submitVote(proposalId,support);
    }
//    public RemoteFunctionCall<TransactionReceipt> delegate(){}
//    public RemoteFunctionCall<TransactionReceipt> delegateByType(){}
}
