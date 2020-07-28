package com.example.jpa.hibernate.demojpa.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.jpa.hibernate.demojpa.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest
class JPQLTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
EntityManager em;

	@Test
	void contextLoads() {
		logger.info("test is running....");
		List result=em.createQuery("select c from Course c").getResultList();
		logger.info(result.toString());
	}
	
	@Test

	void jpql_typed() {
		logger.info("test is running....");
		TypedQuery<Course> query = em.createQuery("select c from Course c",Course.class);
	}

	

  @Test
  @Transactional
  void native_query()
  {
	  Query query=em.createNativeQuery("Update Course set last_updated_date=sysdate()");
	  int i=query.executeUpdate();
	  
	  logger.info("numberOFRow:{}",i);
  }
}
