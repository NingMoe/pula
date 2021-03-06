/**
 * 
 */
package pula.sys.vo;

import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.math.NumberUtils;


/**
 * 
 * <pre>
 *  <xml>
 *   <appid><![CDATA[wx2421b1c4370ec43b]]></appid>
 *   <attach><![CDATA[支付测试]]></attach>
 *   <bank_type><![CDATA[CFT]]></bank_type>
 *   <fee_type><![CDATA[CNY]]></fee_type>
 *   <is_subscribe><![CDATA[Y]]></is_subscribe>
 *   <mch_id><![CDATA[10000100]]></mch_id>
 *   <nonce_str><![CDATA[5d2b6c2a8db53831f7eda20af46e531c]]></nonce_str>
 *   <openid><![CDATA[oUpF8uMEb4qRXf22hE3X68TekukE]]></openid>
 *   <out_trade_no><![CDATA[1409811653]]></out_trade_no>
 *   <result_code><![CDATA[SUCCESS]]></result_code>
 *   <return_code><![CDATA[SUCCESS]]></return_code>
 *   <sign><![CDATA[B552ED6B279343CB493C5DD0D78AB241]]></sign>
 *   <sub_mch_id><![CDATA[10000100]]></sub_mch_id>
 *   <time_end><![CDATA[20140903131540]]></time_end>
 *   <total_fee>1</total_fee>
 *   <trade_type><![CDATA[JSAPI]]></trade_type>
 *   <transaction_id><![CDATA[1004400740201409030005092168]]></transaction_id>
 *  </xml>
 * </pre>
 * 
 * Wechat notify request entity
 * 
 * @author Administrator
 */
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class WechatNotifyEntity {
	@XmlElement
	private String return_code = "";
	@XmlElement
	private String return_msg;
	@XmlElement
	private String appid;
	@XmlElement
	private String mch_id;
	@XmlElement
	private String device_info;
	@XmlElement
	private String nonce_str;
	@XmlElement
	private String sign;
	@XmlElement
	private String result_code;
	@XmlElement
	private String err_code;
	@XmlElement
	private String err_code_des;
	@XmlElement
	private String openid;
	@XmlElement
	private String is_subscribe;
	@XmlElement
	private String trade_type;
	@XmlElement
	private String bank_type;
	@XmlElement
	private int total_fee;
	@XmlElement
	private String fee_type;
	@XmlElement
	private int cash_fee;
	@XmlElement
	private String cash_fee_type;
	@XmlElement
	private int coupon_fee;
	@XmlElement
	private int coupon_count;
	/*
	 * 代金券或立减优惠ID coupon_id_$n @XmlElement否 String(20) 10000
	 * 代金券或立减优惠ID,$n为下标，从0开始编号 单个代金券或立减优惠支付金额 coupon_fee_$n 否 Int 100
	 * 单个代金券或立减优惠支付金额,$n为下标，从0开始编号
	 */
	@XmlElement
	private String transaction_id;
	@XmlElement
	private String out_trade_no;
	@XmlElement
	private String attach;
	@XmlElement
	private String time_end;
	@XmlElement
	private String sub_mch_id;
	
	public WechatNotifyEntity()
	{
	}

	public WechatNotifyEntity(@SuppressWarnings("rawtypes") Map allParameters) {
		if (allParameters.get("return_code") != null) {
			return_code = allParameters.get("return_code").toString();
		}
		if (allParameters.get("return_msg") != null) {
			return_msg = allParameters.get("return_msg").toString();
		}

		if (allParameters.get("appid") != null) {
			appid = allParameters.get("appid").toString();
		}

		if (allParameters.get("mch_id") != null) {
			mch_id = allParameters.get("mch_id").toString();
		}
		if (allParameters.get("device_info") != null) {
			device_info = allParameters.get("device_info").toString();
		}
		if (allParameters.get("nonce_str") != null) {
			nonce_str = allParameters.get("nonce_str").toString();
		}
		if (allParameters.get("sign") != null) {
			sign = allParameters.get("sign").toString();
		}
		if (allParameters.get("result_code") != null) {
			result_code = allParameters.get("result_code").toString();
		}
		if (allParameters.get("err_code") != null) {
			err_code = allParameters.get("err_code").toString();
		}
		if (allParameters.get("err_code_des") != null) {
			err_code_des = allParameters.get("err_code_des").toString();
		}
		if (allParameters.get("openid") != null) {
			openid = allParameters.get("openid").toString();
		}
		if (allParameters.get("is_subscribe") != null) {
			is_subscribe = allParameters.get("is_subscribe").toString();
		}
		if (allParameters.get("trade_type") != null) {
			trade_type = allParameters.get("trade_type").toString();
		}
		if (allParameters.get("bank_type") != null) {
			bank_type = allParameters.get("bank_type").toString();
		}
		if (allParameters.get("total_fee") != null) {
			total_fee = NumberUtils.toInt(allParameters.get("total_fee")
					.toString());
		}
		if (allParameters.get("fee_type") != null) {
			fee_type = allParameters.get("fee_type").toString();
		}
		if (allParameters.get("cash_fee") != null) {
			cash_fee = NumberUtils.toInt(allParameters.get("cash_fee")
					.toString());
		}
		if (allParameters.get("cash_fee_type") != null) {
			cash_fee_type = allParameters.get("cash_fee_type").toString();
		}
		if (allParameters.get("coupon_fee") != null) {
			coupon_fee = NumberUtils.toInt(allParameters.get("coupon_fee")
					.toString());
		}
		if (allParameters.get("coupon_count") != null) {
			coupon_fee = NumberUtils.toInt(allParameters.get("coupon_count")
					.toString());
		}

		if (allParameters.get("transaction_id") != null) {
			transaction_id = allParameters.get("transaction_id").toString();
		}
		if (allParameters.get("out_trade_no") != null) {
			out_trade_no = allParameters.get("out_trade_no").toString();
		}
		if (allParameters.get("attach") != null) {
			attach = allParameters.get("attach").toString();
		}
		if (allParameters.get("time_end") != null) {
			time_end = allParameters.get("time_end").toString();
		}
		if (allParameters.get("sub_mch_id") != null) {
			sub_mch_id = allParameters.get("sub_mch_id").toString();
		}
	}

	public String getReturn_code() {
		return return_code == null ? "" : return_code;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_msg() {
		return return_msg == null ? "" : return_msg;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

	public String getAppid() {
		return appid == null ? "" : appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id == null ? "" : mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getDevice_info() {
		return device_info == null ? "" : device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getNonce_str() {
		return nonce_str == null ? "" :nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign == null ? "" : sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getResult_code() {
		return result_code == null ? "" : result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public String getErr_code() {
		return err_code == null ? "": err_code;
	}

	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	public String getErr_code_des() {
		return err_code_des == null ? "" :err_code_des;
	}

	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}

	public String getOpenid() {
		return openid == null ? "" : openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getIs_subscribe() {
		return is_subscribe == null ? "" : is_subscribe;
	}

	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}

	public String getTrade_type() {
		return trade_type == null ? "" : trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getBank_type() {
		return bank_type == null ? "" : bank_type;
	}

	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}

	public int getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}

	public String getFee_type() {
		return fee_type == null ? "" : fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public int getCash_fee() {
		return cash_fee;
	}

	public void setCash_fee(int cash_fee) {
		this.cash_fee = cash_fee;
	}

	public String getCash_fee_type() {
		return cash_fee_type == null ? "" : cash_fee_type;
	}

	public void setCash_fee_type(String cash_fee_type) {
		this.cash_fee_type = cash_fee_type;
	}

	public int getCoupon_fee() {
		return coupon_fee;
	}

	public void setCoupon_fee(int coupon_fee) {
		this.coupon_fee = coupon_fee;
	}

	public int getCoupon_count() {
		return coupon_count;
	}

	public void setCoupon_count(int coupon_count) {
		this.coupon_count = coupon_count;
	}

	public String getTransaction_id() {
		return transaction_id == null ? "" : transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getOut_trade_no() {
		return out_trade_no == null ? "" :out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getAttach() {
		return attach ==null ? "" : attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getTime_end() {
		return time_end == null ? "" : time_end;
	}

	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}
	
	public String getSub_mch_id() {
		return sub_mch_id == null ? "" :sub_mch_id;
	}

	public void setSub_mch_id(String sub_mch_id) {
		this.sub_mch_id = sub_mch_id;
	}

	@SuppressWarnings("unchecked")
	public void toParameterMap(@SuppressWarnings("rawtypes") Map paramMap) {
		paramMap.put("return_code", return_code);
		paramMap.put("appid", this.appid);
		paramMap.put("attach", this.attach);
		paramMap.put("bank_type", this.bank_type);
		paramMap.put("cash_fee", this.cash_fee);
		paramMap.put("cash_fee_type", this.cash_fee_type);
		paramMap.put("coupon_count", this.coupon_count);
		paramMap.put("coupon_fee", this.coupon_fee);
		paramMap.put("device_info", this.device_info);
		paramMap.put("err_code", this.err_code);
		paramMap.put("err_code_des", this.err_code_des);
		paramMap.put("fee_type", this.fee_type);
		paramMap.put("is_subscribe", this.is_subscribe);
		paramMap.put("mch_id", this.mch_id);
		paramMap.put("nonce_str", this.nonce_str);
		paramMap.put("openid", this.openid);
		paramMap.put("out_trade_no", this.out_trade_no);
		paramMap.put("result_code", this.result_code);
		paramMap.put("return_code", this.return_code);
		paramMap.put("return_msg", this.return_msg);
		paramMap.put("sign", this.sign);
		paramMap.put("time_end", this.time_end);
		paramMap.put("total_fee", this.total_fee);
		paramMap.put("trade_type", this.trade_type);
		paramMap.put("transaction_id", this.transaction_id);
		paramMap.put("sub_mch_id", this.sub_mch_id);
	}

}
