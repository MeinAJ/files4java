package com.company;

public class Num {

    private Integer count = 0;

    private Integer dicNum = 0;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getDicNum() {
        return dicNum;
    }

    public void setDicNum(Integer dicNum) {
        this.dicNum = dicNum;
    }

    @Override
    public String toString() {
        return "Num{" +
                "count=" + count +
                ", dicNum=" + dicNum +
                '}';
    }
}
