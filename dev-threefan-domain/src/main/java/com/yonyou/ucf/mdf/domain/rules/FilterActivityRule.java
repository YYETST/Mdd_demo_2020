package com.yonyou.ucf.mdf.domain.rules;

import com.yonyou.ucf.mdd.common.dto.BaseReqDto;
import com.yonyou.ucf.mdd.common.model.rule.RuleContext;
import com.yonyou.ucf.mdd.common.model.rule.RuleExecuteResult;
import com.yonyou.ucf.mdd.common.model.uimeta.UIMetaBaseInfo;
import com.yonyou.ucf.mdd.common.model.uimeta.filter.vo.FilterVO;
import com.yonyou.ucf.mdd.common.model.uimeta.filter.vo.SimpleFilterVO;
import com.yonyou.ucf.mdd.ext.core.AppContext;
import com.yonyou.ucf.mdd.ext.model.LoginUser;
import com.yonyou.ucf.mdd.rule.base.AbstractRule;
import org.springframework.stereotype.Component;

/**
 * @author nishch
 * @version 1.0
 * @date 2020/4/14
 * @des  查询过滤
 */
@Component("filterActivityRule")
public class FilterActivityRule extends AbstractRule {

    @Override
    public <T>RuleExecuteResult execute(RuleContext ruleContext, T... tObjs) throws Exception {
        //获取UI元数据
        UIMetaBaseInfo uiMetaBaseInfo = ruleContext.getUiMetaBaseInfo();
        //获取请求数据
        BaseReqDto dto = ruleContext.getParamObj();
        //获取当前用户
        LoginUser user = AppContext.getCurrentUser();
        if(null == user){
            throw new Exception("请登录后再操作！");
        }
        //获取查询条件
        FilterVO filterVO = dto.getTreeCondition();
        // 未停用的组织  0:启用；1：停用
        //增加查询条件--默认查询
        filterVO.setSimpleVOs(new SimpleFilterVO[]{
                new SimpleFilterVO("enable","eq",0)
        });
        dto.setCondition(filterVO);
        //设置规则间传递上下文
        setContext("return","1111");
        return new RuleExecuteResult();
    }
}
