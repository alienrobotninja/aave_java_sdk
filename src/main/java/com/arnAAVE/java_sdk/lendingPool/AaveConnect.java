package com.arnAAVE.java_sdk.lendingPool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AaveConnect {
    private String privateKey;

    private String rpcURL;

    private final Web3j web3j = Web3j.build(new HttpService(rpcURL));

    private final Credentials credentials = Credentials.create(privateKey);
}
