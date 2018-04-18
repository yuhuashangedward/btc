package com.yuhuashang.btc.entity;

import java.util.List;

public class Block {

    /**
     * 区块索引号
     */
    private int index;

    /**
     * 当前区块的hash值，区块唯一标识
     */
    private String hash;

    /**
     * 生成区块的时间戳
     */
    private long timestamp;

    /**
     * 当前区块的交易集合
     */
    private List transactions;

    /**
     * 工作量证明，计算正确hash值的次数
     */
    private int nonce;

    /**
     * 前一个区块的hash值
     */
    private String previousHash;


    public Block() {
    }

    public Block(int index, String hash, long timestamp, List transactions, int nonce, String previousHash) {
        this.index = index;
        this.hash = hash;
        this.timestamp = timestamp;
        this.transactions = transactions;
        this.nonce = nonce;
        this.previousHash = previousHash;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public List getTransactions() {
        return transactions;
    }

    public void setTransactions(List transactions) {
        this.transactions = transactions;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }
}
