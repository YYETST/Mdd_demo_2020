package com.yonyou.ucf.mdf.domain.service;

import com.yonyou.ucf.mdd.common.context.MddBaseContext;
import com.yonyou.ucf.mdd.common.model.rule.RuleExecuteResult;
import com.yonyou.ucf.mdd.core.dao.biz.IBizDataMapperDao;
import com.yonyou.ucf.mdd.core.meta.MddMetaDaoHelper;
import com.yonyou.ucf.mdd.ext.core.AppContext;
import com.yonyou.ucf.mdd.ext.model.LoginUser;
import com.yonyou.ucf.mdf.domain.dao.ActivityDao;
import org.imeta.biz.base.BizContext;
import org.imeta.orm.base.BizObject;
import org.imeta.orm.base.JsonFormatter;
import org.imeta.orm.schema.QueryCondition;
import org.imeta.orm.schema.QueryConditionGroup;
import org.imeta.orm.schema.QuerySchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ActivityService {

    @Autowired
    private ActivityDao activityDao;
    @Autowired
    MddMetaDaoHelper mddMetaDaoHelper;

    /**
     * 使用mybatis只能通过一些简单的查询、更新等相关操作
     * @param params
     * @throws Exception
     */
    public void selectMybatis(Map<String, Object> params) throws Exception {
        ((IBizDataMapperDao)MddBaseContext.getMapperDao(IBizDataMapperDao.class)).
                dynamicExecSelectSql("com.yonyou.ucf.mdf.domain.dao.mybatisActivityDao.select", null);
    }

    public List<Map<String,Object>> select(Map<String, Object> params) throws Exception{
        QueryConditionGroup queryConditionGroup = QueryConditionGroup.and(
                QueryCondition.name("new1").eq("11")
        );
        QuerySchema schema = QuerySchema.create().addSelect("new1,new2,new3").addCondition(queryConditionGroup);
        //实体类名
        List<Map<String,Object>> results = mddMetaDaoHelper.query("GT827AT2.GT827AT2.activity", schema);
        return results;
    }



}
