package com.joyplus.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.joyplus.model.DeviceInfo;

public class DeviceDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<DeviceInfo> findDevice(String mac) {
		
		Criteria criteria = Criteria.where("mac").is(mac);
		Query query = new Query();
		query.addCriteria(criteria);
		return mongoTemplate.find(query, DeviceInfo.class);		
	}

}
