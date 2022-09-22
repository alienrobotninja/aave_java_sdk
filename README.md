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

```ts
import { LendingPool } from '@aave/contract-helpers';

const lendingPool = new LendingPool(provider, {
  LENDING_POOL: lendingPoolAddress,
  WETH_GATEWAY: wethGatewayAddress,
});

/*
- @param `user` The ethereum address that will make the deposit 
- @param `reserve` The ethereum address of the reserve 
- @param `amount` The amount to be deposited 
- @param @optional `onBehalfOf` The ethereum address for which user is depositing. It will default to the user address
*/
const txs: EthereumTransactionTypeExtended[] = await lendingPool.deposit({
  user,
  reserve,
  amount,
  onBehalfOf,
});
```

Submit transaction(s) as shown [here](#submitting-transactions)

</details>

<br />

### borrow

Borrow an `amount` of `reserve` asset.

User must have a collaterised position (i.e. aTokens in their wallet)


<details>
  <summary>Sample Code</summary>

```ts
import { LendingPool, InterestRate } from '@aave/contract-helpers';

const lendingPool = new LendingPool(provider, {
  LENDING_POOL: lendingPoolAddress,
  WETH_GATEWAY: wethGatewayAddress,
});

/*
- @param `user` The ethereum address that will receive the borrowed amount 
- @param `reserve` The ethereum address of the reserve asset 
- @param `amount` The amount to be borrowed, in human readable units (e.g. 2.5 ETH) 
- @param `interestRateMode`//Whether the borrow will incur a stable (InterestRate.Stable) or variable (InterestRate.Variable) interest rate
- @param @optional `debtTokenAddress` The ethereum address of the debt token of the asset you want to borrow. Only needed if the reserve is ETH mock address 
- @param @optional `onBehalfOf` The ethereum address for which user is borrowing. It will default to the user address 
*/
const txs: EthereumTransactionTypeExtended[] = await lendingPool.borrow({
  user,
  reserve,
  amount,
  interestRateMode,
  debtTokenAddress,
  onBehalfOf,
  referralCode,
});
```

Submit transaction as shown [here](#submitting-transactions)

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

```ts
import { LendingPool, InterestRate } from '@aave/contract-helpers';

const lendingPool = new LendingPool(provider, {
  LENDING_POOL: lendingPoolAddress,
  WETH_GATEWAY: wethGatewayAddress,
});

/*
- @param `user` The ethereum address that repays 
- @param `reserve` The ethereum address of the reserve on which the user borrowed 
- @param `amount` The amount to repay, or (-1) if the user wants to repay everything 
- @param `interestRateMode` // Whether stable (InterestRate.Stable) or variable (InterestRate.Variable) debt will be repaid
- @param @optional `onBehalfOf` The ethereum address for which user is repaying. It will default to the user address
*/
const txs: EthereumTransactionTypeExtended[] = lendingPool.repay({
  user,
  reserve,
  amount,
  interestRateMode,
  onBehalfOf,
});
```

Submit transaction(s) as shown [here](#submitting-transactions)

</details>

<br />

### withdraw

Withdraws the underlying asset of an aToken asset.

<details>
  <summary>Sample Code</summary>

```ts
import { LendingPool } from '@aave/contract-helpers';

const lendingPool = new LendingPool(provider, {
  LENDING_POOL: lendingPoolAddress,
  WETH_GATEWAY: wethGatewayAddress,
});

/*
- @param `user` The ethereum address that will receive the aTokens 
- @param `reserve` The ethereum address of the reserve asset 
- @param `amount` The amount of aToken being redeemed 
- @param @optional `aTokenAddress` The ethereum address of the aToken. Only needed if the reserve is ETH mock address 
- @param @optional `onBehalfOf` The amount of aToken being redeemed. It will default to the user address
*/
const txs: EthereumTransactionTypeExtended[] = lendingPool.withdraw({
  user,
  reserve,
  amount,
  aTokenAddress,
  onBehalfOf,
});
```

Submit transaction as shown [here](#submitting-transactions)

</details>

<br />

### swapBorrowRateMode

Borrowers can use this function to swap between stable and variable borrow rate
modes.

<details>
  <summary>Sample Code</summary>

```ts
import { LendingPool, InterestRate } from '@aave/contract-helpers';

const lendingPool = new LendingPool(provider, {
  LENDING_POOL: lendingPoolAddress,
});

/*
- @param `user` The ethereum address that wants to swap rate modes 
- @param `reserve` The address of the reserve on which the user borrowed 
- @param `interestRateMode` //Whether the borrow will incur a stable (InterestRate.Stable) or variable (InterestRate.Variable) interest rate
*/
const txs: EthereumTransactionTypeExtended[] = lendingPool.swapBorrowRateMode({
  user,
  reserve,
  interestRateMode,
});
```

Submit transaction as shown [here](#submitting-transactions)

</details>

<br />