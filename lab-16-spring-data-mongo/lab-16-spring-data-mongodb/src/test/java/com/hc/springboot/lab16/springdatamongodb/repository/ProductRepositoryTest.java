package com.hc.springboot.lab16.springdatamongodb.repository;

import com.hc.springboot.lab16.springdatamongodb.Application;
import com.hc.springboot.lab16.springdatamongodb.dataobject.ProductDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ProductRepositoryTest {

  @Autowired
  private ProductRepository productRepository;

  @Test
  public void testInsert() {
    ProductDO product = new ProductDO();
    product.setName("鱼头");
    productRepository.insert(product);
    System.out.println(product.getId());
  }
}
