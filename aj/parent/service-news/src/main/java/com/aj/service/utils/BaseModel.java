package com.aj.service.utils;

/**
 * this is a basic class 4 model
 *
 * @author AJ
 * @create 2018-03-02 22:20
 */

public class BaseModel {

    //开始
    private Integer start;

    //每页数量
    private Integer limit;

    //查询字
    private String searchKeyWord;

    //添加时间
    private Long addAt;

    //修改时间
    private Long updateAt;

    //ip
    private String addIp;

    //输入设备
    private String addAgent;

    //添加人
    private String addBy;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getSearchKeyWord() {
        return searchKeyWord;
    }

    public void setSearchKeyWord(String searchKeyWord) {
        this.searchKeyWord = searchKeyWord;
    }

    public Long getAddAt() {
        return addAt;
    }

    public void setAddAt(Long addAt) {
        this.addAt = addAt;
    }

    public String getAddIp() {
        return addIp;
    }

    public void setAddIp(String addIp) {
        this.addIp = addIp;
    }

    public String getAddAgent() {
        return addAgent;
    }

    public void setAddAgent(String addAgent) {
        this.addAgent = addAgent;
    }

    public String getAddBy() {
        return addBy;
    }

    public void setAddBy(String addBy) {
        this.addBy = addBy;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }
}
