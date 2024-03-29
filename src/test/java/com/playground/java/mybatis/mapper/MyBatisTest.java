package com.playground.java.mybatis.mapper;

import com.playground.java.mybatis.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.aggregator.AggregateWith;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {

  @Test
  public void testSelectAll() throws Exception {
    // acquire SqlSessionFactory
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    // acquire SqlSession object
    SqlSession sqlSession = sqlSessionFactory.openSession();

    // acquire mapper
    BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

    // execute sql
    List<Brand> brands = brandMapper.selectAll();
    brands.forEach(System.out::println);

    sqlSession.close();
  }

  @Test
  public void testSelectById() throws Exception {
    // acquire SqlSessionFactory
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    // acquire SqlSession object
    SqlSession sqlSession = sqlSessionFactory.openSession();

    // acquire mapper
    BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

    // execute query
    Brand brand = brandMapper.selectById(1);
    System.out.println(brand.toString());

    sqlSession.close();
  }

  @Test
  public void testSelectByCondition() throws Exception {
    // accept parameters
    int status = 0;
    String companyName = "%" + "Apple" + "%";
    String brandName = "%" + "MacBook" + "%";

    // acquire mybatis configuration file
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    // acquire SqlSession object
    SqlSession sqlSession = sqlSessionFactory.openSession();

    // acquire mapper
    BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

    // execute query
    List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
    brands.forEach(System.out::println);

    sqlSession.close();
  }

  @Test
  public void testSelectByConditionObject() throws Exception {
    // accept parameters
    int status = 1;
    String companyName = "Keycron";
    String brandName = "Keyboard";

    // process parameters
    companyName = "%" + companyName + "%";
    brandName = "%" + brandName + "%";

    // create object
    Brand brand = new Brand();
    brand.setStatus(status);
    brand.setCompanyName(companyName);
    brand.setBrandName(brandName);

    // load mybatis configuration
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    // open connection
    SqlSession sqlSession = sqlSessionFactory.openSession();

    // acquire mapper
    BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

    // execute query
    List<Brand> brands = brandMapper.selectByConditionObject(brand);
    brands.forEach(System.out::println);

    // release resources
    sqlSession.close();
  }

  @Test
  public void testSelectByConditionMap() throws Exception {
    // accept parameters
    int status = 1;
    String companyName = "Keycron";
    String brandName = "Keyboard";

    // process parameters
    companyName = "%" + companyName + "%";
    brandName = "%" + brandName + "%";

    // create map
    Map<String, String> map = new HashMap<>();
    map.put("status", String.valueOf(status));
    map.put("companyName", companyName);
    map.put("brandName", brandName);

    // acquire mybatis configuration file
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    // acquire SqlSession object
    SqlSession sqlSession = sqlSessionFactory.openSession();

    // acquire mapper
    BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

    // execute query
    List<Brand> brands = brandMapper.selectByConditionMap(map);
    brands.forEach(System.out::println);

    sqlSession.close();
  }

  @Test
  public void testSelectByDynamicCondition() throws Exception {
    // accept parameters
    int status = 1;
    String companyName = "Keycron";
    String brandName = "Keyboard";

    // process parameters
    companyName = "%" + companyName + "%";
    brandName = "%" + brandName + "%";

    // create map
    Brand brand = new Brand();
//    brand.setStatus(status);
//    brand.setCompanyName(companyName);
//    brand.setBrandName(brandName);

    // acquire mybatis configuration file
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    // acquire SqlSession object
    SqlSession sqlSession = sqlSessionFactory.openSession();

    // acquire mapper
    BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

    // execute query
    List<Brand> brands = brandMapper.selectByDynamicCondition(brand);
    brands.forEach(System.out::println);

    sqlSession.close();
  }

  @Test
  public void testSelectByConditionSingle() throws Exception {
    // accept parameters
    int status = 1;
    String companyName = "Keycron";
    String brandName = "Keyboard";

    // process parameters
    companyName = "%" + companyName + "%";
    brandName = "%" + brandName + "%";

    // create map
    Brand brand = new Brand();
//    brand.setStatus(status);
    brand.setCompanyName(companyName);
//    brand.setBrandName(brandName);

    // acquire and create SqlSessionFactory
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    // open connection
    SqlSession sqlSession = sqlSessionFactory.openSession();

    // acquire mapper
    BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

    // execute query
    List<Brand> brands = brandMapper.selectByConditionSingle(brand);
    brands.forEach(System.out::println);

    // release resource
    sqlSession.close();
  }

  @Test
  public void testAdd() throws Exception {
    // accept parameters and create new insertion entry
    String brandName = "Rogue";
    String companyName = "Nissan";
    int ordered = 2;
    String description = "SUV";
    int status = 1;
    Brand brand = new Brand();
    brand.setBrandName(brandName);
    brand.setCompanyName(companyName);
    brand.setOrdered(ordered);
    brand.setDescription(description);
    brand.setStatus(status);

    // load mybatis configuration file
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    // open session
    SqlSession sqlSession = sqlSessionFactory.openSession();
//    SqlSession sqlSession = sqlSessionFactory.openSession(true);

    // acquire mapper
    BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

    // execute query
    brandMapper.add(brand);

    // commit
    sqlSession.commit();

    // release resource
    sqlSession.close();
  }

  @Test
  public void testAddAndGetPrimaryKey() throws Exception {
    // accept parameters and create new insertion entry
    String brandName = "Rogue";
    String companyName = "Nissan";
    int ordered = 2;
    String description = "SUV";
    int status = 1;
    Brand brand = new Brand();
    brand.setBrandName(brandName);
    brand.setCompanyName(companyName);
    brand.setOrdered(ordered);
    brand.setDescription(description);
    brand.setStatus(status);

    // load mybatis configuration
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    // open SqlSession
    SqlSession sqlSession = sqlSessionFactory.openSession();

    // acquire object mapper
    BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

    // execute query
    brandMapper.addAndGetPrimaryKey(brand);
    sqlSession.commit();
    System.out.println(brand);

    // release resource
    sqlSession.close();
  }

  @Test
  public void testUpdate() throws Exception {
    // accept parameters and create new insertion entry
    int id = 6;
    String brandName = "Rogue222";
    String companyName = "Nissan";
    int ordered = 2;
    String description = "SUV - Updated";
    int status = 1;
    Brand brand = new Brand();
    brand.setId(id);
    brand.setBrandName(brandName);
    brand.setCompanyName(companyName);
    brand.setOrdered(ordered);
    brand.setDescription(description);
    brand.setStatus(status);

    // load mybatis configuration
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    // open SqlSession
    SqlSession sqlSession = sqlSessionFactory.openSession();

    // acquire object mapper
    BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

    // execute query
    brandMapper.update(brand);
    sqlSession.commit();
    System.out.println(brand);

    // release resource
    sqlSession.close();
  }

  @Test
  public void testUpdateWithDynamicSql() throws Exception {
    // accept parameters and create new insertion entry
    int id = 6;
    String brandName = "Rogue22233";
    String companyName = "Nissan2323";
    int ordered = 2;
    String description = "SUV - Updated";
    int status = 1;
    Brand brand = new Brand();
    brand.setId(id);
    brand.setBrandName(brandName);
//    brand.setCompanyName(companyName);
//    brand.setOrdered(ordered);
//    brand.setDescription(description);
//    brand.setStatus(status);

    // load mybatis configuration
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    // open SqlSession
    SqlSession sqlSession = sqlSessionFactory.openSession();

    // acquire object mapper
    BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

    // execute query
    brandMapper.updateDynamicSql(brand);
    sqlSession.commit();
    System.out.println(brand);

    // release resource
    sqlSession.close();
  }

  @Test
  public void testDeleteById() throws Exception {
    // accept parameter
    int id = 6;

    // load mybatis configuration file
    String configFile = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(configFile);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    // open session
    SqlSession sqlSession = sqlSessionFactory.openSession(true);

    // acquire mapper
    BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

    // execute query
    brandMapper.deleteById(id);

    // release resource
    sqlSession.close();
  }

  @Test
  public void testDeleteByIdArray() throws Exception {
    // accept parameter
    int[] ids = {4, 5};

    // load mybatis configuration file
    String configFile = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(configFile);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    // open session
    SqlSession sqlSession = sqlSessionFactory.openSession(true);

    // acquire mapper
    BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

    // execute query
    brandMapper.deleteByIdArray(ids);

    // release resource
    sqlSession.close();
  }
}