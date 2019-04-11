/**
 * Created by ICOP on 2019-04-09.
 */
var React = require('react');
var {YYClass} = require('yylib-ui');
var assign = require('lodash/assign');
var {YYCreatePage} =  require('yylib-business');
var {CardEventHandler} = require('yylib-cscec');
var TenderUrl = require('./TenderUrl');

//页面初始化
var EventHandler = {

    "cardPage": {
        onViewWillMount: function (options) {
            CardEventHandler.pageLoading(this);
        }
        , onViewDidMount: function (options) {
            CardEventHandler.init(this, TenderUrl);
        }
        , onViewWillUpdate: function (options) {

        }
        , onViewDidUpdate: function (options) {

        }
    }
};

var TenderCardPage = YYClass.create({
    render: function () {
        return <YYCreatePage {...this.props} appCode="" pageCode=""
                                             uiEvent={assign({},CardEventHandler.API,EventHandler)} 
                                             uiParser={}/>
    }
});

module.exports = TenderCardPage;