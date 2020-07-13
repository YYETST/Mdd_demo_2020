package com.yonyou.ucf.mdf.domain.rules;

import com.yonyou.ucf.mdd.bpm.service.ProcessService;
import com.yonyou.ucf.mdd.common.interfaces.rule.IRule;
import com.yonyou.ucf.mdd.common.model.rule.RuleContext;
import com.yonyou.ucf.mdd.common.model.rule.RuleExecuteResult;
import com.yonyou.ucf.mdd.common.model.uimeta.UIMetaBaseInfo;
import com.yonyou.ucf.mdd.core.meta.MddMetaDaoHelper;
import com.yonyou.ucf.mdd.ext.base.user.UserOrg;
import com.yonyou.ucf.mdd.ext.core.AppContext;
import com.yonyou.ucf.mdd.ext.model.BillContext;
import com.yonyou.ucf.mdd.ext.model.LoginUser;
import com.yonyou.ucf.mdd.rule.base.AbstractRule;
import com.yonyou.ucf.mdd.uimeta.util.UIMetaUtils;
import com.yonyou.ucf.mdd.utils.ServiceUtils;
import com.yonyou.ucf.mdf.app.exceptions.BusinessException;
import org.imeta.biz.base.BizContext;
import org.imeta.core.model.Entity;
import org.imeta.orm.base.BizObject;
import org.imeta.orm.base.JsonFormatter;
import org.imeta.orm.schema.QueryCondition;
import org.imeta.orm.schema.QueryConditionGroup;
import org.imeta.orm.schema.QuerySchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author nishch
 * @version 1.0
 * @date 2020/4/14
 * @des
 */
@Component("activityRule")
public class ActivityRule extends AbstractRule {



    @Override
    public <T> RuleExecuteResult execute(RuleContext ruleContext, T... tObjs) throws Exception {
        //获取UI元数据
        UIMetaBaseInfo uiMetaBaseInfo = ruleContext.getUiMetaBaseInfo();
        //取业务数据
        List<BizObject> bizObjectList = this.getBizObjects(uiMetaBaseInfo, ruleContext);
        Iterator var6 = bizObjectList.iterator();
        while(var6.hasNext()) {
            BizObject bizObject = (BizObject)var6.next();
//            bizObject.set("creator", ruleContext.getUserId());
//            bizObject.set("creationtime", new Date());
            if(bizObject.get("name").equals("111")){
                throw  new BusinessException("new1不能为111");
            }
        }
        ruleContext.setCusMapValue("rulecontent","111123");
        return new RuleExecuteResult();
    }
}
