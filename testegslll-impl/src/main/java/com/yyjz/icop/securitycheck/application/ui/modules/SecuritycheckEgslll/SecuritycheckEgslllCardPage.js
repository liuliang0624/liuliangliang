/**
 * Created by ICOP on 2019-04-09.
 */
var React = require('react');
var {YYClass} = require('yylib-ui');
var assign = require('lodash/assign');
var {YYCreatePage} =  require('yylib-business');
var {CardEventHandler} = require('yylib-cscec');
var SecuritycheckEgslllUrl = require('./SecuritycheckEgslllUrl');

//页面初始化
var EventHandler = {

    "cardPage": {
        onViewWillMount: function (options) {
            CardEventHandler.pageLoading(this);
        }
        , onViewDidMount: function (options) {
            CardEventHandler.init(this, SecuritycheckEgslllUrl);
        }
        , onViewWillUpdate: function (options) {

        }
        , onViewDidUpdate: function (options) {

        }
    }
};

var SecuritycheckEgslllCardPage = YYClass.create({
    render: function () {
        return <YYCreatePage {...this.props} appCode="" pageCode=""
                                             uiEvent={assign({},CardEventHandler.API,EventHandler)} 
                                             uiParser={}/>
    }
});

module.exports = SecuritycheckEgslllCardPage;