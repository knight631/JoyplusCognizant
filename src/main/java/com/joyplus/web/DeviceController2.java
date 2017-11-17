package com.joyplus.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.joyplus.model.DeviceInfo;
import com.joyplus.utils.GetRequestJsonUtils;

@RestController
public class DeviceController2 {	
	private String deviceInfoJson;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	private DeviceInfo deviceModel;
	private String mac;
	
	@RequestMapping(value="/putData", method=RequestMethod.POST)
	public String getDeviceInfo2(HttpServletRequest request) throws IOException {
		deviceInfoJson = GetRequestJsonUtils.getRequestJsonString(request);	
		System.out.println(deviceInfoJson);
		
		String useragent = request.getHeader("user-agent");
		System.out.println("useragent: " + useragent);
		
		
		String publicIp = request.getHeader("x-forwarded-for");
		if(publicIp == null || publicIp.length() == 0 || "unknown".equalsIgnoreCase(publicIp)) { 
	    	   publicIp = request.getHeader("remote-host"); 
	       } 
		
		
		 /*String publicIp = request.getHeader("x-forwarded-for"); 
	       if(publicIp == null || publicIp.length() == 0 || "unknown".equalsIgnoreCase(publicIp)) { 
	    	   publicIp = request.getHeader("Proxy-Client-IP"); 
	       } 
	       if(publicIp == null || publicIp.length() == 0 || "unknown".equalsIgnoreCase(publicIp)) { 
	    	   publicIp = request.getHeader("WL-Proxy-Client-IP"); 
	       } 
	       if(publicIp == null || publicIp.length() == 0 || "unknown".equalsIgnoreCase(publicIp)) { 
	    	   publicIp = request.getRemoteAddr(); 
	       }*/
		
		System.out.println("publicip:" + publicIp);
		
		
		String serialNumber_str = deviceInfoJson.substring(deviceInfoJson.indexOf("SerialNumber"));
		serialNumber_str = serialNumber_str.substring(serialNumber_str.indexOf("\""));
		serialNumber_str = serialNumber_str.substring(3);
		serialNumber_str = serialNumber_str.substring(0, serialNumber_str.indexOf("\""));
		deviceModel = JSON.parseObject(deviceInfoJson, DeviceInfo.class);
		mac = deviceModel.getMac();
		System.out.println("mac:" + mac);
		Criteria criteria = Criteria.where("mac").is(mac);
		Query query = new Query();
		query.addCriteria(criteria);
		Update update = new Update();
		update.set("ip", deviceModel.getIp());
		update.set("IMEI", deviceModel.getIMEI());
		update.set("width", deviceModel.getWidth());
		update.set("height", deviceModel.getHeight());
		update.set("SerialNumber", serialNumber_str);
		update.set("release", deviceModel.getRelease());
		update.set("model", deviceModel.getModel());
		update.set("useragent", useragent);
		update.set("publicIp", publicIp);
		mongoTemplate.upsert(query, update, DeviceInfo.class);	
		String rejson = "{\"msg\":\"success\"}";
		
		return rejson;
	}
	
}
