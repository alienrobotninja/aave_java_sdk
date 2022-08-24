package com.arnAAVE.java_sdk.lendingPool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LendingPoolAccessTest {

    LendingPoolAccess lendingPoolAccess = new LendingPoolAccess();

    @Test
    void deposit() throws Exception {
        lendingPoolAccess.deposit();

    }

    @Test
    void sendEthers() throws Exception {
        lendingPoolAccess.sendEthers();
    }
}