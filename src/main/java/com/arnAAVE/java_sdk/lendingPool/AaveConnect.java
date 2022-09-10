package com.arnAAVE.java_sdk.lendingPool;

import lombok.*;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;

@Data
public class AaveConnect {

    private String privateKey;

    private String rpcURL;

    private Web3j web3j;

    private Credentials credentials;

    public AaveConnect(String privateKey, String rpcURL) {
        this.privateKey = privateKey;
        this.rpcURL = rpcURL;
        this.web3j = Web3j.build(new HttpService(rpcURL));
        this.credentials = Credentials.create(privateKey);
    }

    public String getClientVersion() {
        Web3ClientVersion clientVersion = null;
        try {
            clientVersion = web3j.web3ClientVersion().send();

        } catch (IOException e) {
            e.printStackTrace();
        }
        assert clientVersion != null;

        return clientVersion.getWeb3ClientVersion();
    }
}
