package com.arnAAVE.java_sdk;

import com.arnAAVE.java_sdk.lendingPool.ILendingPool;
import com.arnAAVE.java_sdk.lendingPool.LendingPoolAccess;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@SpringBootApplication
public class JavaSdkApplication {

	public static void main(String[] args) throws Exception {

		SpringApplication.run(JavaSdkApplication.class, args);


	}

}
