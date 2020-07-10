package com.yonyou.ucf.mdf.domain.dao;

import com.yonyou.ucf.mdd.ext.dao.sql.SqlHelper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nishch
 * @version 1.0
 * @date 2020/7/7
 * @des
 */
@Repository
public class ActivityDao {
    public List<Object> test() throws Exception {
        List<Object>  obj = SqlHelper.selectList("com.yonyou.ucf.mdf.domain.dao.mybatisActivityDao.selectMenuList");
        return obj;
    }
}
