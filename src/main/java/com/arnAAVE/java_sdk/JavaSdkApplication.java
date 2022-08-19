package com.arnAAVE.java_sdk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.arnAAVE.java_sdk.lendingPool.LendingPoolAccess.lendingPoolDeposit;

@SpringBootApplication
public class JavaSdkApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSdkApplication.class, args);
//		try {
//			lendingPoolDeposit();
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
	}

}
