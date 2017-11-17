package com.joyplus.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "device_list")
public class DeviceInfo {

	@Id
	private String objectId;
	private String mac;
	private String ip;
	private String IMEI;
	private String height;
	private String width;
	private String release;
	private String model;
	private String SerNum;
	private String publicIp;
	private String useragent;
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getIMEI() {
		return IMEI;
	}
	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getRelease() {
		return release;
	}
	public void setRelease(String release) {
		this.release = release;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
		
	public String getSerNum() {
		return SerNum;
	}
	public void setSerNum(String serNum) {
		SerNum = serNum;
	}
	public String getPublicIp() {
		return publicIp;
	}
	public void setPublicIp(String publicIp) {
		this.publicIp = publicIp;
	}
	public String getUseragent() {
		return useragent;
	}
	public void setUseragent(String useragent) {
		this.useragent = useragent;
	}
	
	
	
}
