/**
 * Created by ICOP on 2019-04-09.
 */
var React = require('react');
var assign = require('lodash/assign');
var {YYClass} = require('yylib-ui');
var {YYCreatePage} =  require('yylib-business');
var SecuritycheckEgslllUrl = require('./SecuritycheckEgslllUrl');
var {ListEventHandler} = require('yylib-cscec');

//页面初始化
var EventHandler = {

    // 新增按钮
    "addBtn": {
        onClick: function () {
            this.routeTo('securitycheckEgslll/card');
        }
    },

    "listPage": {
        onViewWillMount: function (options) {
            ListEventHandler.init(this, SecuritycheckEgslllUrl);
        }
        , onViewDidMount: function (options) {
			ListEventHandler.initData(this);
        }
        , onViewWillUpdate: function (options) {

        }
        , onViewDidUpdate: function (options) {

        }
    }
}

var SecuritycheckEgslllListPage = YYClass.create({
    render: function () {
        return <YYCreatePage {...this.props} appCode="" pageCode=""
                                             uiEvent={assign({},ListEventHandler.API,EventHandler)}
                                             uiParser={ListEventHandler.uiParser}/>
    }
});
module.exports = SecuritycheckEgslllListPage;