package com.hc.springboot.lab16.springdatamongodb.dao;

import com.hc.springboot.lab16.springdatamongodb.dataobject.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void insert(UserDO entity) {
        mongoTemplate.insert(entity);
    }

    public void updateById(UserDO entity) {
        // 生成 Update 条件
        final Update update = new Update();
        ReflectionUtils.doWithFields(entity.getClass(), new ReflectionUtils.FieldCallback() {
            @Override
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                if ("id".equals(field.getName()) || field.getAnnotation(Transient.class) != null ||
                        Modifier.isStatic(field.getModifiers())) {
                    return;
                }

                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                if (field.get(entity) == null) {
                    return;
                }
                update.set(field.getName(), field.get(entity));

            }
        });
        if (update.getUpdateObject().isEmpty()) {
            return;
        }
        mongoTemplate.updateFirst(new Query(Criteria.where("_id").is(entity.getId())), update, UserDO.class);
    }

    public void deleteById(Integer id) {
        mongoTemplate.remove(new Query(Criteria.where("_id").is(id)), UserDO.class);
    }

    public UserDO findById(Integer id) {
        return mongoTemplate.findOne(new Query(Criteria.where("_id").is(id)), UserDO.class);
    }

    public UserDO findByUsername(String username) {
        return mongoTemplate.findOne(new Query(Criteria.where("username").is(username)), UserDO.class);
    }

    public List<UserDO> findAllById(List<Integer> ids) {
         return mongoTemplate.find(new Query(Criteria.where("_id").in(ids)), UserDO.class);
    }
}
