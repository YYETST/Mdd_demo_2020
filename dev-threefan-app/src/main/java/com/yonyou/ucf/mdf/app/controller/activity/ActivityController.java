package com.yonyou.ucf.mdf.app.controller.activity;

import com.yonyou.ucf.mdd.common.context.MddBaseContext;
import com.yonyou.ucf.mdd.common.dto.BaseReqDto;
import com.yonyou.ucf.mdd.common.enums.OperationTypeEnum;
import com.yonyou.ucf.mdd.common.interfaces.context.ISimpleUser;
import com.yonyou.ucf.mdd.common.model.rule.RuleContext;
import com.yonyou.ucf.mdd.common.model.rule.RuleExecuteResult;
import com.yonyou.ucf.mdd.rule.api.RuleEngine;
import com.yonyou.ucf.mdf.app.common.ResultMessage;
import com.yonyou.ucf.mdf.app.controller.BaseController;
import com.yonyou.ucf.mdf.app.exceptions.BusinessException;
import com.yonyou.ucf.mdf.app.util.RuleEngineUtils;
import com.yonyou.ucf.mdf.domain.service.ActivityService;
import com.yonyou.ucf.mdf.domain.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author nishch
 * @version 1.0
 * @date 2020/7/7
 * @des  活动管理控制器
 */
@Slf4j
@RestController
@RequestMapping("/activity")
public class ActivityController extends BaseController {
    @Autowired
    ActivityService activityService;

    /**
     * 测试查询数据
     * @param params
     * @param request
     * @param response
     */
    @RequestMapping("/select")
    public void getBill(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response){
        try {
            ISimpleUser user = MddBaseContext.getCurrentUser();
            activityService.select(params);
            this.renderJson(response, ResultMessage.success());
        } catch (Exception e) {
            this.renderJson(response, ResultMessage.error(e.getMessage()));
        }
    }

    /**
     * 测试规则链
     * @param baseReqDto
     * @return
     * @throws Exception
     */
    @RequestMapping("/rule")
    public RuleExecuteResult check(@RequestBody BaseReqDto baseReqDto) throws Exception {
        try {
            RuleContext ruleContext = RuleEngineUtils.prepareRuleContext(baseReqDto, "activity");
            RuleExecuteResult result = RuleEngine.getInstance().execute(ruleContext);
            if (result.getMsgCode() != 1) {
                throw new BusinessException(result.getMessage());
            } else {
                return result;
            }
        } catch (Exception var4) {
            throw new BusinessException(var4.getMessage());
        }
    }
}