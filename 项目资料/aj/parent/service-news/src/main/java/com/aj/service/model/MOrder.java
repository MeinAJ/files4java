package com.aj.service.model;

import javax.validation.constraints.NotNull;
import java.util.HashMap;

/**
 * 订单
 * 
 * @author shj-22
 *
 */
public class MOrder extends MBasePager {

	/**
	 * id
	 */
	@NotNull(message = "id不能为空")
	private Long id;

	/**
	 * 此处为了兼容yougo
	 */
	private Long orderId;

	/**
	 * 状态
	 */
	private String status;

	/**
	 * 支付方式
	 */
	@NotNull(message = "payType不能为空")
	private Object payType;

	/**
	 * 送货码
	 */
	private Integer confirmCode;

	/**
	 * 应付
	 */
	private Double dueCharge;

	/**
	 * 实付
	 */
	private Double realCharge;

	/**
	 * 费率
	 */
	private Double rate;
	
	/**
	 * yougo用户id
	 */
	private Long userId;

	/**
	 * 小费
	 */
	private Double tip;


	/**
	 * 发货信息id
	 */
	private Long sendAddressId;

	/**
	 * 发货信息版本
	 */
	private Integer sendAddressVer;


	/**
	 * 收货信息id
	 */
	private Long receiveAddressId;

	/**
	 * 收货信息版本
	 */
	private Integer receiveAddressVer;

	/**
	 * 取货时间
	 */
	private String appointmentAt;

	/**
	 * '取货时间戳
	 */
	private Long AppointmentStamp;

	/**
	 * 平台
	 */
	private String platform;

	/**
	 * 区域
	 */
	@NotNull(message = "areaId不能为空")
	private Long areaId;

	/**
	 * 实际送达时间
	 */
	private Long actualAt;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 是否删除
	 */
	private Integer isDelete;

	/**
	 * 币种
	 */
	private String currency;

	/**
	 * 物品类型
	 */
	@NotNull(message = "productTypeId不能为空")
	private Long productTypeId;


	/**
	 * 起步价
	 */
	private Double startFare;

	/**
	 * 起步距离，单位km
	 */
	private Double startDistance;

	/**
	 * 超出配送距离时，每公里的价格
	 */
	private Double beyondPrice;

	/**
	 * 距离,单位km
	 */
	private Double distance;


	/**
	 * 订单取消时间(只限状态为取消时)
	 */
	private Long cancelAt;

	/**
	 * 配送员信息
	 */
	private HashMap goer;

	/**
	 * 是否要查询S_WAITPAY状态的订单
	 * @return
	 */
	private String noWaitPay;

    /**
     * 用于搜索(开始时间)
     * @return
     */
    private Long beginTime;

    /**
     * 用于搜索(结束时间)
     * @return
     */
    private Long endTime;

	/**
	 *  下单用户信息
	 * @return
	 */
	private MNews user;

	public MNews getUser() {
		return user;
	}

	public void setUser(MNews user) {
		this.user = user;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getPayType() {
		return payType;
	}

	public void setPayType(Object payType) {
		this.payType = payType;
	}

	public Integer getConfirmCode() {
		return confirmCode;
	}

	public void setConfirmCode(Integer confirmCode) {
		this.confirmCode = confirmCode;
	}

	public Double getDueCharge() {
		return dueCharge;
	}

	public void setDueCharge(Double dueCharge) {
		this.dueCharge = dueCharge;
	}

	public Double getRealCharge() {
		return realCharge;
	}

	public void setRealCharge(Double realCharge) {
		this.realCharge = realCharge;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Double getTip() {
		return tip;
	}

	public void setTip(Double tip) {
		this.tip = tip;
	}

	public Integer getSendAddressVer() {
		return sendAddressVer;
	}

	public void setSendAddressVer(Integer sendAddressVer) {
		this.sendAddressVer = sendAddressVer;
	}

	public Integer getReceiveAddressVer() {
		return receiveAddressVer;
	}

	public void setReceiveAddressVer(Integer receiveAddressVer) {
		this.receiveAddressVer = receiveAddressVer;
	}

	public String getAppointmentAt() {
		return appointmentAt;
	}

	public void setAppointmentAt(String appointmentAt) {
		this.appointmentAt = appointmentAt;
	}

	public Long getAppointmentStamp() {
		return AppointmentStamp;
	}

	public void setAppointmentStamp(Long appointmentStamp) {
		AppointmentStamp = appointmentStamp;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Long getActualAt() {
		return actualAt;
	}

	public void setActualAt(Long actualAt) {
		this.actualAt = actualAt;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Long getSendAddressId() {
		return sendAddressId;
	}

	public void setSendAddressId(Long sendAddressId) {
		this.sendAddressId = sendAddressId;
	}

	public Long getReceiveAddressId() {
		return receiveAddressId;
	}

	public void setReceiveAddressId(Long receiveAddressId) {
		this.receiveAddressId = receiveAddressId;
	}

	public Long getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(Long productTypeId) {
		this.productTypeId = productTypeId;
	}

	public Double getStartFare() {
		return startFare;
	}

	public void setStartFare(Double startFare) {
		this.startFare = startFare;
	}

	public Double getStartDistance() {
		return startDistance;
	}

	public void setStartDistance(Double startDistance) {
		this.startDistance = startDistance;
	}

	public Double getBeyondPrice() {
		return beyondPrice;
	}

	public void setBeyondPrice(Double beyondPrice) {
		this.beyondPrice = beyondPrice;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Long getCancelAt() {
		return cancelAt;
	}

	public void setCancelAt(Long cancelAt) {
		this.cancelAt = cancelAt;
	}

	public HashMap getGoer() {
		return goer;
	}

	public void setGoer(HashMap goer) {
		this.goer = goer;
	}

	public String getNoWaitPay() {
		return noWaitPay;
	}

	public void setNoWaitPay(String noWaitPay) {
		this.noWaitPay = noWaitPay;
	}

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

	public Long getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Long beginTime) {
		this.beginTime = beginTime;
	}
}
