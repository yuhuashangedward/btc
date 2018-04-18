package com.yuhuashang.btc.service;

import com.yuhuashang.btc.entity.Block;
import com.yuhuashang.btc.entity.Transaction;

import java.util.List;

public class GetBlock {


    /**
     * 挖矿
     * @param blockchain 整个区块链
     * @param txs 需记账记录，包含
     * @param address 矿工钱包地址
     * @return
     */
    private static void mineBlock(List blockchain, List txs, String address){
        // 加入系统奖励的交易
        Transaction sysTx = new Transaction(CryptoUtil.UUID(), "", address, 10);
        txs.add(sysTx);
        // 获取当前区块链里的最后一个区块
        Block latestBlock = (Block) blockchain.get(blockchain.size() - 1);
        // 随机数
        int nonce = 1;
        String hash = "";
        while(true){
            hash = CryptoUtil.SHA256(latestBlock.getHash() + JSON.toJSONString(txs) + nonce);
            if(hash.startsWith("0000")){
                System.out.println("=====计算结果正确，计算次数为：" + nonce + ",hash:" + hash);
                break;
            }
            nonce++;
            System.out.println("计算错误，hash:" + hash);
        }
        // 解出难题，可以构造新区块并加入进区块链里
        Block newBlock = new Block(latestBlock.getIndex() + 1, System.currentTimeMillis(), txs, nonce, latestBlock.getHash(), hash);
        blockchain.add(newBlock);
        System.out.println("挖矿后的区块链：" + JSON.toJSONString(blockchain));
    }
}
