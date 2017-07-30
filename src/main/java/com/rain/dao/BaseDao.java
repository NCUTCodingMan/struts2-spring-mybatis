package com.rain.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("baseDao")
public class BaseDao<T> {
    public static Logger logger = LoggerFactory.getLogger(BaseDao.class);
    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;
    
    public boolean save(String mapper, T t) {
        try {
            this.sqlSessionTemplate.insert(mapper, t);
        } catch (Exception e) {
            logger.debug(mapper + "新增操作出现异常");
            logger.debug(e.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean edit(String mapper, T t) {
        try {
            this.sqlSessionTemplate.update(mapper, t);
        } catch (Exception e) {
            logger.debug(mapper + "更新操作出现异常");
            logger.debug(e.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean delete(String mapper, T t) {
        try {
            this.sqlSessionTemplate.delete(mapper, t);
        } catch (Exception e) {
            logger.debug(mapper + "删除操作出现异常");
            logger.debug(e.getMessage());
            return false;
        }
        return true;
    }
    
    @SuppressWarnings("unchecked")
    public T queryForObject(String mapper, T t) {
        return (T)this.sqlSessionTemplate.selectOne(mapper, t);
    }
    
    public List<T> queryForList(String mapper, Map<String, Object> params) {
        return this.sqlSessionTemplate.selectList(mapper, params);
    }
}
