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
		Web3j web3j = Web3j.build(new HttpService(
				"https://kovan.infura.io/v3/b8c7cedb8701445bb9210f4731e42c0a"));

		Credentials credentials = Credentials.create("1238370fb9507a697d2744d9c511061a0c3cc284eba1af1fa7b24854a9084219");
		ILendingPool lendingPool = ILendingPool.load("0x7fc66500c84a76ad7e9c93437bfc5ac33e2ddae9", web3j, credentials, new BigInteger("1"), new BigInteger("2"));
		TransactionReceipt transactionReceipt = Transfer.sendFunds(
				web3j, credentials, "0x16B72adaB628D8762A25f707aCbfE9c170d9001d",
				BigDecimal.valueOf(0.0001), Convert.Unit.ETHER).send();
		System.out.println(transactionReceipt);

		assert false;
		List<ILendingPool.BorrowEventResponse> responses = lendingPool.getBorrowEvents(transactionReceipt);
		System.out.println("Responses = " + responses);

		LendingPoolAccess access = new LendingPoolAccess();
		TransactionReceipt receipt = access.deposit();

		System.out.println("Receipt = " + receipt);

		SpringApplication.run(JavaSdkApplication.class, args);


	}

}
