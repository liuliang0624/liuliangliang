/**
 * Created by ICOP on 2019-04-09.
 */
var React = require('react');
var assign = require('lodash/assign');
var {YYClass} = require('yylib-ui');
var {YYCreatePage} =  require('yylib-business');
var TenderUrl = require('./TenderUrl');
var {ListEventHandler} = require('yylib-cscec');

//页面初始化
var EventHandler = {

    // 新增按钮
    "addBtn": {
        onClick: function () {
            this.routeTo('tender/card');
        }
    },

    "listPage": {
        onViewWillMount: function (options) {
            ListEventHandler.init(this, TenderUrl);
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

var TenderListPage = YYClass.create({
    render: function () {
        return <YYCreatePage {...this.props} appCode="" pageCode=""
                                             uiEvent={assign({},ListEventHandler.API,EventHandler)}
                                             uiParser={ListEventHandler.uiParser}/>
    }
});
module.exports = TenderListPage;