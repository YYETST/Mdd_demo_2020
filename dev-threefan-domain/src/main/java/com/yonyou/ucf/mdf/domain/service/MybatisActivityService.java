package com.yonyou.ucf.mdf.domain.service;

import com.yonyou.ucf.mdd.common.context.MddBaseContext;
import com.yonyou.ucf.mdd.core.dao.biz.IBizDataMapperDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * mybatis方式操作数据库示例
 * 使用mybatis只能通过一些简单的查询、更新等相关操作
 * 操作需要使用数据库真实字段及表。使用上有很大限制
 */
@Slf4j
@Service
public class MybatisActivityService {


    /**
     * 查询示例
     * @param params
     * @throws Exception
     * @return
     */
    public Object selectMybatis(Map<String, Object> params) throws Exception {
        Object obj = ((IBizDataMapperDao) MddBaseContext.getMapperDao(IBizDataMapperDao.class)).
                dynamicExecSelectSql("com.yonyou.ucf.mdf.domain.dao.mybatisActivityDao.select", null);
//        ((IBizDataMapperDao) MddBaseContext.getMapperDao(IBizDataMapperDao.class)).
//                dynamicExecDeleteSql("com.yonyou.ucf.mdf.domain.dao.mybatisActivityDao.delete",params);
        return obj;
    }

}
