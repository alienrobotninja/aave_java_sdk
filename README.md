# aaveJavaSdk


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