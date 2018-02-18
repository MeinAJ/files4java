
package com.aj.service.news.model;

import javax.validation.constraints.NotNull;

/**
 * TODO 添加类的一句话简单描述.
 * <p>
 * TODO 详细描述
 * <p>
 * TODO 示例代码
 * 
 * <pre>
 * </pre>
 * 
 * @author Administrator
 */
public class Base {

	/**
	 * 分页开始页
	 */
	private Integer start;

	/**
	 * 每次取的页数
	 */
	private Integer limit;

	/**
	 * 搜索关键词
	 */
	private String keyWords;

	/**
	 * 搜索条数
	 */
	private Integer searchNum;

	/**
	 * 语言
	 */
	private String language;

	/**
	 * 添加设备
	 */
	private String addAgent;

	/**
	 * 添加时间点
	 */
	private Long addAt;

	/**
	 * 添加人
	 */
	@NotNull(message = "addBy不能为空")
	private Long addBy;

	/**
	 * 添加ip
	 */
	private String addIp;

	/**
	 * 平台
	 */
	private String platform;

	/**
	 * 查询的排序方式
	 */
	private String sortBy;

	/**
	 * 查询的排序方式
	 */
	private String sortType;

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

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public Integer getSearchNum() {
		return searchNum;
	}

	public void setSearchNum(Integer searchNum) {
		this.searchNum = searchNum;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getAddAgent() {
		return addAgent;
	}

	public void setAddAgent(String addAgent) {
		this.addAgent = addAgent;
	}

	public Long getAddAt() {
		return addAt;
	}

	public void setAddAt(Long addAt) {
		this.addAt = addAt;
	}

	public Long getAddBy() {
		return addBy;
	}

	public void setAddBy(Long addBy) {
		this.addBy = addBy;
	}

	public String getAddIp() {
		return addIp;
	}

	public void setAddIp(String addIp) {
		this.addIp = addIp;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
}