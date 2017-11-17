package com.joyplus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.joyplus.model.DeviceInfo;

//@Repository
public interface DeviceRepository extends MongoRepository<DeviceInfo, String>{

}
