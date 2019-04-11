/**
 * Created by ICOP on 2019-04-09.
 */
var RestUrl = require('../../actions/RestUrl');

var ADDR = RestUrl.ADDR;
var ROOT_PATH = RestUrl.ROOT_PATH;

var SecuritycheckEgslllUrl = {
    INSERT: ADDR + ROOT_PATH + "/securitycheckEgslll/insert", // 新增保存
    UPDATE: ADDR + ROOT_PATH + "/securitycheckEgslll/update", // 修改保存
    DELETE: ADDR + ROOT_PATH + "/securitycheckEgslll/delete", // 删除
    QUERY_LIST: ADDR + ROOT_PATH + "/securitycheckEgslll/queryList", // 查询列表数据
    QUERY_DETAIL: ADDR + ROOT_PATH + "/securitycheckEgslll/queryDetail", // 查询一条数据明细
    SEARCH: ADDR + ROOT_PATH + "/securitycheckEgslll/search", // 搜索
    ATTACH: ADDR + ROOT_PATH + "/securitycheckEgslll/attach", // 附件管理
    EXPORT: ADDR + ROOT_PATH + "/securitycheckEgslll/export", // 导出
    PRINT: ADDR + ROOT_PATH + "/securitycheckEgslll/print", // 打印
    CARD_ROUTE:"/securitycheckEgslll/card", // 卡片页面路由
    CARD_GO_BACK:"/securitycheckEgslll", // 卡片界面返回列表的路由
    FRONTEND_ROOT_PATH: "icop-testegslll-frontend", // 前端工程名﻿
}
module.exports = SecuritycheckEgslllUrl;