/**
 * Created by ICOP on 2019-04-09.
 */
var RestUrl = require('../../actions/RestUrl');

var ADDR = RestUrl.ADDR;
var ROOT_PATH = RestUrl.ROOT_PATH;

var TenderUrl = {
    INSERT: ADDR + ROOT_PATH + "/tender/insert", // 新增保存
    UPDATE: ADDR + ROOT_PATH + "/tender/update", // 修改保存
    DELETE: ADDR + ROOT_PATH + "/tender/delete", // 删除
    QUERY_LIST: ADDR + ROOT_PATH + "/tender/queryList", // 查询列表数据
    QUERY_DETAIL: ADDR + ROOT_PATH + "/tender/queryDetail", // 查询一条数据明细
    SEARCH: ADDR + ROOT_PATH + "/tender/search", // 搜索
    ATTACH: ADDR + ROOT_PATH + "/tender/attach", // 附件管理
    EXPORT: ADDR + ROOT_PATH + "/tender/export", // 导出
    PRINT: ADDR + ROOT_PATH + "/tender/print", // 打印
    CARD_ROUTE:"/tender/card", // 卡片页面路由
    CARD_GO_BACK:"/tender", // 卡片界面返回列表的路由
    FRONTEND_ROOT_PATH: "icop-testegslll-frontend", // 前端工程名﻿
}
module.exports = TenderUrl;