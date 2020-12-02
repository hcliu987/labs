package com.hc.springboot.lab16.springdatamongodb.repository;

import com.hc.springboot.lab16.springdatamongodb.dataobject.UserDO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDO, Integer> {

}
