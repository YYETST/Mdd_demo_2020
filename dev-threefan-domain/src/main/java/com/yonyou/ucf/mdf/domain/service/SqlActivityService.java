package com.yonyou.ucf.mdf.domain.service;

import com.yonyou.ucf.mdd.core.utils.UIMetaHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 直接写sql方式
 */
@Slf4j
@Service
public class SqlActivityService {


    /**
     * 无参查询
     * @return
     * @throws Exception
     */
    public List<Object> selectNoParams() throws Exception {
        return UIMetaHelper.mddMetaDaoHelp().selectList("select string_0,string_1 from  t_activity_doc_xsw4twa9 limit 10",null);
    }

    /**
     * 有参查询
     * @param id
     * @return
     * @throws Exception
     */
    public List<Map<String,Object>> selectParams(String id) throws Exception{
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("string_0",id);
        return UIMetaHelper.mddMetaDaoHelp().selectList("select string_0,string_1 from  t_activity_doc_xsw4twa9 where string_0=?",params);
    }


    /**
     * 更新
     * @param params
     * @return
     * @throws Exception
     */
    public int update(Map<String,Object> params) throws Exception{
        return UIMetaHelper.mddMetaDaoHelp().executeSql("update t_activity_doc_xsw4twa9 set string_0=? where string_1=?",params);
    }


    /**
     * delete
     * @param name
     * @return
     * @throws Exception
     */
    public int delete(String name) throws Exception{
        return UIMetaHelper.mddMetaDaoHelp().executeSql("delete from t_activity_doc_xsw4twa9 where string_1=?",name);
    }

}
