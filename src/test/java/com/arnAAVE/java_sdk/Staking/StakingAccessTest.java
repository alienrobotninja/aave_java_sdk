package com.arnAAVE.java_sdk.Staking;

import com.arnAAVE.java_sdk.lendingPool.AaveConnect;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class StakingAccessTest {

    AaveConnect connection = new AaveConnect("1238370fb9507a697d2744d9c511061a0c3cc284eba1af1fa7b24854a9084219", "https://goerli.infura.io/v3/b8c7cedb8701445bb9210f4731e42c0a");
    StakingAccess stakingAccess;

    @BeforeEach
    void setUp() {
    }

    @Test
    void claimRewards() {
        RemoteFunctionCall<TransactionReceipt> receipt = stakingAccess.claimRewards("0x16b72adab628d8762a25f707acbfe9c170d9001d", new BigInteger("2000000"));
        log.info("receipt: " + receipt);
    }

    @Test
    void stake() {
        RemoteFunctionCall<TransactionReceipt> receipt = stakingAccess.stake("0x16b215977114756b17f8c1a7b989d6061a1cae8e", new BigInteger("2000000"));
        log.info("receipt: " + receipt);
    }

    @Test
    void redeem() {
        RemoteFunctionCall<TransactionReceipt> receipt = stakingAccess.redeem("0x16b215977114756b17f8c1a7b989d6061a1cae8e", new BigInteger("2000000"));
        log.info("receipt: " + receipt);
    }
}