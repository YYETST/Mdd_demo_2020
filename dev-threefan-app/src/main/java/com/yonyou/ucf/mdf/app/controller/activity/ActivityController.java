package com.yonyou.ucf.mdf.app.controller.activity;

import com.yonyou.ucf.mdd.common.context.MddBaseContext;
import com.yonyou.ucf.mdd.common.dto.BaseReqDto;
import com.yonyou.ucf.mdd.common.interfaces.context.ISimpleUser;
import com.yonyou.ucf.mdf.app.common.ResultMessage;
import com.yonyou.ucf.mdf.app.controller.BaseController;
import com.yonyou.ucf.mdf.app.controller.BillController;
import com.yonyou.ucf.mdf.domain.service.MddActivityService;
import com.yonyou.ucf.mdf.domain.service.MybatisActivityService;
import com.yonyou.ucf.mdf.domain.service.SqlActivityService;
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
public class ActivityController extends BillController {

    @Autowired
    MddActivityService mddActivityService;

    /**
     * 测试查询数据
     * @param params
     * @param request
     * @param response
     */
    @RequestMapping("/select")
    public void getBill(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response){
        try {
            //获取当前登录用户信息
            ISimpleUser user = MddBaseContext.getCurrentUser();
            Object object1 =  mddActivityService.select(params);
            this.renderJson(response, ResultMessage.data(object1));
        } catch (Exception e) {
            this.renderJson(response, ResultMessage.error(e.getMessage()));
        }
    }


    @RequestMapping("/update")
    public void update(@RequestBody BaseReqDto bill, HttpServletRequest request, HttpServletResponse response){
        try {
            //可以在这里添加自己的逻辑bill
            super.save(bill, request, response);
            this.renderJson(response, ResultMessage.success());
        } catch (Exception e) {
            this.renderJson(response, ResultMessage.error(e.getMessage()));
        }
    }






}