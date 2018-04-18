package com.yuhuashang.btc.service;

import com.yuhuashang.btc.entity.Block;
import com.yuhuashang.btc.entity.Transaction;

import java.util.List;

public class WalletService {

    /**
     * 查询余额
     * @param blockchain
     * @param address
     * @return
     */
    public static int getWalletBalance(List blockChain, String address){
        int balance = 0;
        for (Block block:blockChain){
            List transactions = block.getTransactions();
            for (Transaction transaction:
                 transactions) {
                if(address.equals(transaction.getRecipient())){
                    balance += transaction.getAmount();
                }
                if(address.equals(transaction.getSender())){
                    balance -= transaction.getAmount();
                }
            }

        }
        return balance;
    }
}
