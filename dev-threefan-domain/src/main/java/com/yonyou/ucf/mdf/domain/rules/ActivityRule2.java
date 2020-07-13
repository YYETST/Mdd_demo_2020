package com.yonyou.ucf.mdf.domain.rules;

import com.yonyou.ucf.mdd.common.model.rule.RuleContext;
import com.yonyou.ucf.mdd.common.model.rule.RuleExecuteResult;
import com.yonyou.ucf.mdd.common.model.uimeta.UIMetaBaseInfo;
import com.yonyou.ucf.mdd.ext.core.AppContext;
import com.yonyou.ucf.mdd.rule.base.AbstractRule;
import com.yonyou.ucf.mdf.app.exceptions.BusinessException;
import org.imeta.orm.base.BizObject;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

/**
 * @author nishch
 * @version 1.0
 * @date 2020/4/14
 * @des
 */
@Component("activityRule2")
public class ActivityRule2 extends AbstractRule {



    @Override
    public <T> RuleExecuteResult execute(RuleContext ruleContext, T... tObjs) throws Exception {
        //获取上个规则设置的值
        String preRule =ruleContext.getCusMapValue("rulecontent").toString();
        System.out.println(preRule);
        return new RuleExecuteResult();
    }
}
