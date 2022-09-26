// SPDX-License-Identifier: MIT
pragma solidity ^0.6.12;

import "./IERC20.sol";

interface IWETHGateway {
    function depositETH(
        address lendingPool,
        address onBehalfOf,
        uint16 referralCode
    ) external payable;

    function withdrawETH(
        address lendingPool,
        uint256 amount,
        address onBehalfOf
    ) external;
}

interface ILendingPool {
    function getUserAccountData(address user)
    external
    view
    returns (
        uint256 totalCollateralETH,
        uint256 totalDebtETH,
        uint256 availableBorrowsETH,
        uint256 currentLiquidationThreshold,
        uint256 ltv,
        uint256 healthFactor
    );
}

contract SampleContract {
    //IWETHGateway interface for the Goerli testnet
    IWETHGateway public iWethGateway = IWETHGateway(0x3bd3a20Ac9Ff1dda1D99C0dFCE6D65C4960B3627);
    //ILendingPool interface
    ILendingPool public iLendingPool = ILendingPool(0x4bd5643ac6f66a5237E18bfA7d47cF22f1c9F210);
    //Lending Pool address for the Aave (v2) lending pool on Goerli testnet
    address public constant lendingPoolAddress = 0x4bd5643ac6f66a5237E18bfA7d47cF22f1c9F210;
    //Contract Address for the aWeth tokens generated after depositing ETH to keep track of the amount deposited in lending pool
    address public constant aWethAddress = 0x22404B0e2a7067068AcdaDd8f9D586F834cCe2c5;

    address public owner;

    constructor() payable {
        owner = msg.sender;
    }

    function stakeEther() external payable {
        //Deposit ETH via WETHGateway
        //It will convert ETH to WETH and also send funds to the lending pool
        iWethGateway.depositETH{value: msg.value}(lendingPoolAddress, address(this), 0);
    }

    function withdrawEther(uint _amount) external {
        //Withdraw lended funds via the Weth Gateway
        //It will convert back the WETH to ETH and send it to the contract
        //Ensure you set the relevant ERC20 allowance of aWETH, before calling this function, so the WETHGateway contract can burn the associated aWETH
        IERC20(aWethAddress).approve(address(iWethGateway), type(uint256).max);
        iWethGateway.withdrawETH(lendingPoolAddress, _amount, address(this));
    }

    //To check the balance of aWeth tokens for our contract address
    function getContractAWETHBalance() external view returns(uint) {
        return IERC20(aWethAddress).balanceOf(address(this));
    }

    //Receive function is needed because withdrawETH is sending funds to the contract without call data
    receive() external payable {
    }
}
