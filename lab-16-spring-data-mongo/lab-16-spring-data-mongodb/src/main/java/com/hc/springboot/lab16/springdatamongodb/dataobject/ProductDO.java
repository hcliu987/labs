package com.hc.springboot.lab16.springdatamongodb.dataobject;

import com.hc.springboot.lab16.springdatamongodb.mongo.IncIdEntity;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product")
public class ProductDO  extends IncIdEntity<Integer> {

    private  String  name;
    public  String getName(){
        return  name;
    }
    public  ProductDO setName(String name){
        this.name=name;
        return  this;
    }
}
