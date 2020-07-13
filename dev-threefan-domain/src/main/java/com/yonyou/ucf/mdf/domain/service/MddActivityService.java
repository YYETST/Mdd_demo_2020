package com.yonyou.ucf.mdf.domain.service;

import com.yonyou.ucf.mdd.common.context.MddBaseContext;
import com.yonyou.ucf.mdd.common.dto.BaseReqDto;
import com.yonyou.ucf.mdd.core.dao.biz.IBizDataMapperDao;
import com.yonyou.ucf.mdd.core.meta.MddMetaDaoHelper;
import com.yonyou.ucf.mdd.core.utils.UIMetaHelper;
import com.yonyou.ucf.mdf.domain.dao.ActivityDao;
import lombok.extern.slf4j.Slf4j;
import org.imeta.orm.schema.QueryCondition;
import org.imeta.orm.schema.QueryConditionGroup;
import org.imeta.orm.schema.QuerySchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * mdd方式操作数据库示例
 */
@Slf4j
@Service
public class MddActivityService {

    @Autowired
    private ActivityDao activityDao;
    @Autowired
    MddMetaDaoHelper mddMetaDaoHelper;

    /**
     * 简单查询
     * @param params
     * @throws Exception
     */
    public List<Map<String,Object>> select(Map<String, Object> params) throws Exception{
        //情况一
        QueryConditionGroup queryConditionGroup = QueryConditionGroup.and(
                QueryCondition.name("name").eq(params.get("name"))
        );
        QuerySchema schema = QuerySchema.create().addSelect("code,name,type").addCondition(queryConditionGroup)
                .addOrderBy("type");
        //情况二
//        QuerySchema schema=QuerySchema.create()
//                .addSelect("code,name,type")
//                .appendQueryCondition(
//                        QueryConditionGroup.and(QueryCondition.name("name").eq(params.get("name"))),
//                        QueryConditionGroup.and(QueryCondition.name("beforeDate").elt(params.get("beforeDate"))),
//                        QueryConditionGroup.and(QueryCondition.name("afterDate").egt(params.get("afterDate")))
//                );
        //实体类名--fullname即实体的URL
        //List<Map<String,Object>> results = mddMetaDaoHelper.query("GT1190AT5.GT1190AT5.activity_doc", schema);
        //也可以使用这种方式操作
        List<Map<String,Object>> results =UIMetaHelper.mddMetaDaoHelp().query("GT1190AT5.GT1190AT5.activity_doc", schema);
        return results;
    }

}
