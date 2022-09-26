<h1 align="center">Aave Java SDK</h1>


### prerequisite
* add ***JDK 'azul-16'***  as the project sdk
* have maven installed
* get an infura goerli or kovan test node
* have a goerli or kovan testnet wallet (can easily be gotten from metamask)
* and load with some test eth.
* look in the test to understand how to use.
### Installation
just clone and ***mvn install*** from the terminal to add the web3j dependency then run the main in app.java

Look in the pom.xml to understand the dependency and the plugin.


###Todo
* get the solidity contracts of aave into the project
* get web3j plugin to work
* if you run the command ***mvn web3j:generate-sources*** in the terminal you'll get an error that's the plugin, it needs to be fixed for the following to work.

[
* use web3j convert the .sol contracts to .java wrapper classes
* get secret keys for aave if any and access deployed contract methods

]
###Current
* gotten the aave rpc node
* web3j dependency can connect to the aave rpc node
* The error in number three above has been resolved we left with finding a way to get the solidity contracts and create the wrapper classes.

##Known AAVE RPC nodes

``https://eth-mainnet.alchemyapi.io/v2/demo``
just get a testnet address from infura and you are good to go.
#Update
* wrapper classes have been created using the v2 .sol contracts.
* attempting to deposit on lending pool.
* we require an approve method for deposit to go through still finding away around that.
  ###lending pool contract
* deposit(``String reserve``,``BigInteger amount``,``String onBehalfOf``,``BigInteger referralCode``)


* please once again look in the test to understand how to use.

# How to use

[Lending Pool V2](#lending-pool-v2)
- [deposit](#deposit)
- [borrow](#borrow)
- [repay](#repay)
- [withdraw](#withdraw)
- [swapBorrowRateMode](#swapBorrowRateMode)
- [setUsageAsCollateral](#setUsageAsCollateral)
- [liquidationCall](#liquidationCall)
- [swapCollateral](#swapCollateral)
- [repayWithCollateral](#repayWithCollateral)

## Lending Pool V2

Object that contains all the necessary methods to create Aave V2 lending pool
transactions

### deposit

Deposits the underlying asset into the reserve. For every token that is
deposited, a corresponding amount of aTokens is minted

<details>
  <summary>Sample Code</summary>

```java
/*
- @param `assetAddress` The ethereum address of the reserve asset
- @param `lendingPoolAddressProvider` lending pool address provider 
- @param `amount` The amount to be deposited, in human readable units as strings (e.g. 25000000000 ETH) 
- @param `interestRateMode`//Whether the borrow will incur a stable (InterestRate.Stable) or variable (InterestRate.Variable) interest rate
- @param `onBehalfOf` The ethereum address for which user is depositing.
*/
class LendingPoolTest {
    //check that you are on the right network 
    //NB kovan and other test nets are deprecated use Goerli
    String nodeUrl 
        = "https://goerli.infura.io/v3/<replace with your infura key>";
    String privateKey 
        = "<replace with your private key to your wallet>";
    
    private AaveConnect connection = new AaveConnect(privateKey, nodeUrl);
    
    private LendingPool lendingPool = new LendingPool(connection, lendingPoolAddressProvider, gasFee, gasLimit);

    /* rest of your code... constructor...*/

    void lendingPoolDeposit() {
        Erc20 erc20 = new Erc20(connection, amount, assetAddress);

        try {
            erc20.approve(amount);
            TransactionReceipt depositReceipt = lendingPool.deposit(amount, assetAddress, onBehalfOf);
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
}
```

</details>

<br />

### borrow

Borrow an `amount` of `reserve` asset.

User must have a collaterised position (i.e. aTokens in their wallet)


<details>
  <summary>Sample Code</summary>

```java
/*
- @param `assetAddress` The ethereum address of the reserve asset 
- @param `amount` The amount to be borrowed, in human readable units as strings (e.g. 25000000000 ETH) 
- @param `interestRateMode`//Whether the borrow will incur a stable (InterestRate.Stable) or variable (InterestRate.Variable) interest rate
- @param `lendingPoolAddressProvider` lending pool address provider 
- @param `onBehalfOf` The ethereum address for which user is borrowing. It will default to the user address 
*/

class LendingPoolTest {
    String nodeUrl
        = "https://goerli.infura.io/v3/<replace with your infura key>";
    String privateKey
        = "<replace with your private key to your wallet>";

    private AaveConnect connection = new AaveConnect(privateKey, nodeUrl);

    private LendingPool lendingPool = new LendingPool(connection, lendingPoolAddressProvider, gasFee, gasLimit);

    /* rest of your code... constructor...*/
    
    void lendingPoolWithdraw() {

        try {
            TransactionReceipt borrowReceipt =  lendingPool.borrow(amount, assetAddress, onBehalfOf);
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
}

```

</details>

<br />

### repay

Repays a borrow on the specific reserve, for the specified amount (or for the
whole amount, if (-1) is specified). the target user is defined by `onBehalfOf`.
If there is no repayment on behalf of another account, `onBehalfOf` must be
equal to `user`

If the `user` is not approved, an approval transaction will also be returned

<details>
  <summary>Sample Code</summary>

```java
/*
- @param `assetAddress` The ethereum address of the reserve asset 
- @param `amount` The amount to be borrowed, in human readable units as strings (e.g. 25000000000 ETH) 
- @param `interestRateMode`//Whether the borrow will incur a stable (InterestRate.Stable) or variable (InterestRate.Variable) interest rate
- @param `lendingPoolAddressProvider` lending pool address provider 
- @param `onBehalfOf` The ethereum address for which user is borrowing. It will default to the user address 
*/

class LendingPoolTest {
    String nodeUrl
        = "https://goerli.infura.io/v3/<replace with your infura key>";
    String privateKey
        = "<replace with your private key to your wallet>";

    private AaveConnect connection = new AaveConnect(privateKey, nodeUrl);

    private LendingPool lendingPool = new LendingPool(connection, lendingPoolAddressProvider, gasFee, gasLimit);

    /* rest of your code... constructor...*/
    
    void lendingPoolWithdraw() {

        try {
            TransactionReceipt repayReceipt =  lendingPool.repay(amount, assetAddress, onBehalfOf);
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
}

```

</details>

<br />

### withdraw

Withdraws the underlying asset of an aToken asset.

<details>
  <summary>Sample Code</summary>

```java
/*
- @param `assetAddress` The ethereum address of the reserve asset 
- @param `amount` The amount to be withdrawn, in human readable units as strings (e.g. 25000000000 ETH) 
- @param `interestRateMode`//Whether the borrow will incur a stable (InterestRate.Stable) or variable (InterestRate.Variable) interest rate
- @param `lendingPoolAddressProvider` lending pool address provider 
- @param `toAddress` The ethereum address for which user is borrowing. It will default to the user address 
*/

class LendingPoolTest {
    String nodeUrl
        = "https://goerli.infura.io/v3/<replace with your infura key>";
    String privateKey
        = "<replace with your private key to your wallet>";

    private AaveConnect connection = new AaveConnect(privateKey, nodeUrl);

    private LendingPool lendingPool = new LendingPool(connection, lendingPoolAddressProvider, gasFee, gasLimit);

    /* rest of your code... constructor...*/

    void lendingPoolWithdraw() {

        try {
            TransactionReceipt withDrawReceipt =  lendingPool.withdraw(amount, assetAddress, toAdderess);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
```

</details>

<br />

### swapBorrowRateMode

Borrowers can use this function to swap between stable and variable borrow rate
modes.

<details>
  <summary>Sample Code</summary>

```java
/*
- @param `assetAddress` The address of the reserve on which the user borrowed 
- @param `mode` //Whether the borrow will incur a stable (InterestRate.Stable) or variable (InterestRate.Variable) interest rate which is either "1" for stable or "2" for variable
*/
class LendingPoolTest {
    String nodeUrl
        = "https://goerli.infura.io/v3/<replace with your infura key>";
    String privateKey
        = "<replace with your private key to your wallet>";

    private AaveConnect connection = new AaveConnect(privateKey, nodeUrl);

    private LendingPool lendingPool = new LendingPool(connection, lendingPoolAddressProvider, gasFee, gasLimit);

    /* rest of your code... constructor...*/

    void swapBorrowRate() {
        try {
            TransactionReceipt swapBorrowRateReceipt =  lendingPool.swapBorrowRate(assetAddress, mode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

</details>

<br />