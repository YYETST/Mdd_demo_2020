package com.yonyou.ucf.mdf.domain.rules;

import com.yonyou.ucf.mdd.common.model.rule.RuleContext;
import com.yonyou.ucf.mdd.common.model.rule.RuleExecuteResult;
import com.yonyou.ucf.mdd.common.model.uimeta.UIMetaBaseInfo;
import com.yonyou.ucf.mdd.core.meta.MddMetaDaoHelper;
import com.yonyou.ucf.mdd.rule.base.AbstractRule;
import com.yonyou.ucf.mdf.app.exceptions.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.imeta.orm.base.BizObject;
import org.imeta.orm.schema.QueryCondition;
import org.imeta.orm.schema.QueryConditionGroup;
import org.imeta.orm.schema.QuerySchema;

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Component("deleteActivityBeforeRule")
public class DeleteActivityBeforeRule extends AbstractRule {

    @Autowired
    MddMetaDaoHelper mddMetaDaoHelper;

    @Override
    public <T> RuleExecuteResult execute(RuleContext ruleContext, T... tObjs) throws Exception {
        UIMetaBaseInfo uiMetaBaseInfo = ruleContext.getUiMetaBaseInfo();
        //获取实体
        List<BizObject> bizObjectList = this.getBizObjects(uiMetaBaseInfo, ruleContext);
        Iterator var6 = bizObjectList.iterator();
        while(var6.hasNext()) {
            BizObject bizObject = (BizObject)var6.next();
            QueryConditionGroup queryConditionGroup = QueryConditionGroup.and(
                    QueryCondition.name("id").eq(bizObject.get("id"))
            );
            QuerySchema schema = QuerySchema.create().addSelect("id,name,type,enable").addCondition(queryConditionGroup)
                    .addOrderBy("code");
            //实体类名--fullname即实体的URL
            List<Map<String,Object>> results = mddMetaDaoHelper.query(uiMetaBaseInfo.getFullname(), schema);
            if (results.size()>0) {
                if("0".equals(results.get(0).get("enable").toString())){
                    throw new BusinessException(MessageFormat.format("已使用{0}不能删除!", bizObject.get("code")));
                }
            }
        }
        return new RuleExecuteResult();
    }
}
