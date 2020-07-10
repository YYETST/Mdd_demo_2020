;class ObjectStore {
    // 插入
    static insert(uri,obj) {
        var objJson = JSON.stringify(obj);
        var result = _ObjectStoreSave_(uri,objJson);
        var res = JSON.parse(result);
        return res;
    }

    // 批量插入
    static insertBatch(uri,obj) {
        var objJson = JSON.stringify(obj);
        var result = _ObjectStoreSaveBatch_(uri,objJson);
        var res = JSON.parse(result);
        return res;
    }

    // 更新
    static updateById(uri,obj) {
        var objJson = JSON.stringify(obj);
        var result = _ObjectStoreUpdate_(uri,objJson);
        var res = JSON.parse(result);
        return res;
    }

    // 批量更新
    static updateBatch(uri,obj) {
        var objJson = JSON.stringify(obj);
        var result = _ObjectStoreUpdateBatch_(uri,objJson);
        var res = JSON.parse(result);
        return res;
    }

    // 删除
    static deleteById(uri,obj) {
        var objJson = JSON.stringify(obj);
        var result = _ObjectStoreDelete_(uri,objJson);
        var res = JSON.parse(result);
        return res;
    }

    // 批量删除
    static deleteBatch(uri,obj) {
        var objJson = JSON.stringify(obj);
        var result = _ObjectStoreDeleteBatch_(uri,objJson);
        var res = JSON.parse(result);
        return res;
    }

    // 条件删除
    static deleteByMap(uri,obj) {
        var objJson = JSON.stringify(obj);
        var result = _ObjectStoreDeleteByMap_(uri,objJson);
        var res = JSON.parse(result);
        return res;
    }

    // 基于ID查询
    static selectById(uri,obj) {
        var objJson = JSON.stringify(obj);
        var result = _ObjectStoreSelectById_(uri,objJson);
        var res = JSON.parse(result);
        return res;
    }

    // 基于ID批量查询
    static selectBatchIds(uri,obj) {
        var objJson = JSON.stringify(obj);
        var result = _ObjectStoreSelectBatchIds_(uri,objJson);
        var res = JSON.parse(result);
        return res;
    }

    // 基于yonQL查询
    static queryByYonQL(ql) {
        var result = yonQL(ql);
        var res = JSON.parse(result);
        return res;
    }

    // 基于Map条件查询
    static selectByMap(uri,obj) {
        var objJson = JSON.stringify(obj);
        var result = _ObjectStoreSelectByMap_(uri,objJson);
        var res = JSON.parse(result);
        return res;
    }

    // 基于wrapper条件查询
    static selectOne(uri,queryWrapper,dataAuth) {
        var queryWrapperJson = JSON.stringify(queryWrapper);
        var result = _ObjectStoreSelectOne_(uri,queryWrapperJson,dataAuth);
        var res = JSON.parse(result);
        return res;
    }

}

class Wrapper{
    constructor(queryConditions,groupByFields,queryHaving,orderByConditions) {
        // 查询条件
        this.queryConditions = queryConditions;
        // 分组
        this.groupByFields = groupByFields;
        // Having
        this.queryHaving = queryHaving;
        // 排序
        this.orderByConditions = orderByConditions;
    }

    // 等于
    eq(column,value) {
        var queryCondition = {op:"eq",column:column,value:value};
        this.queryConditions.push(queryCondition);
        return this;
    }

    // 不等于
    ne(column,value) {
        var queryCondition = {op:"ne",column:column,value:value};
        this.queryConditions.push(queryCondition);
        return this;
    }

    // 大于
    gt(column,value) {
        var queryCondition = {op:"gt",column:column,value:value};
        this.queryConditions.push(queryCondition);
        return this;
    }

    // 大于等于
    ge(column,value) {
        var queryCondition = {op:"ge",column:column,value:value};
        this.queryConditions.push(queryCondition);
        return this;
    }

    // 小于
    lt(column,value) {
        var queryCondition = {op:"lt",column:column,value:value};
        this.queryConditions.push(queryCondition);
        return this;
    }

    // 小于等于
    le(column,value) {
        var queryCondition = {op:"le",column:column,value:value};
        this.queryConditions.push(queryCondition);
        return this;
    }

    // 区间
    between(column,value1,value2) {
        var queryCondition = {op:"between",column:column,value1:value1,value2:value2};
        this.queryConditions.push(queryCondition);
        return this;
    }

    // 不在区间
    notBetween(column,value1,value2) {
        var queryCondition = {op:"notBetween",column:column,value1:value1,value2:value2};
        this.queryConditions.push(queryCondition);
        return this;
    }

    // like %值%
    like(column,value) {
        var queryCondition = {op:"like",column:column,value:value};
        this.queryConditions.push(queryCondition);
        return this;
    }

    // notLike %值%
    notLike(column,value) {
        var queryCondition = {op:"notLike",column:column,value:value};
        this.queryConditions.push(queryCondition);
        return this;
    }
}