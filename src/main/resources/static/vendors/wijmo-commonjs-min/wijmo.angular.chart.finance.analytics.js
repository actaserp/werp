﻿/*!
    *
    * Wijmo Library 5.20221.842
    * http://wijmo.com/
    *
    * Copyright(c) GrapeCity, Inc.  All rights reserved.
    *
    * Licensed under the GrapeCity Commercial License.
    * sales@wijmo.com
    * wijmo.com/products/wijmo-5/license/
    *
    */

"use strict";var __extends=this&&this.__extends||function(){var extendStatics=function(t,e){return(extendStatics=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(t,e){t.__proto__=e}||function(t,e){for(var r in e)e.hasOwnProperty(r)&&(t[r]=e[r])})(t,e)};return function(t,e){extendStatics(t,e);function __(){this.constructor=t}t.prototype=null===e?Object.create(e):(__.prototype=e.prototype,new __)}}(),__importStar=this&&this.__importStar||function(t){if(t&&t.__esModule)return t;var e={};if(null!=t)for(var r in t)Object.hasOwnProperty.call(t,r)&&(e[r]=t[r]);e.default=t;return e};Object.defineProperty(exports,"__esModule",{value:!0});var wijmo_angular_base_1=require("wijmo/wijmo.angular.base"),wijmo_angular_chart_1=require("wijmo/wijmo.angular.chart"),mNg=__importStar(require("angular")),wjcChartFinAn=__importStar(require("wijmo/wijmo.chart.finance.analytics")),wjNg=mNg,wijmoChartFinAnName="wj.chart.finance.analytics";exports.ngModuleName=wijmoChartFinAnName;var wijmoChartFinAn=wijmo_angular_base_1._registerNgModule(wijmoChartFinAnName);if(wijmo_angular_base_1.softRefChartFinanceAnalytics()){wijmoChartFinAn.directive("wjFlexChartFibonacci",[function(){return new WjFlexChartFibonacci}]);wijmoChartFinAn.directive("wjFlexChartFibonacciArcs",[function(){return new WjFlexChartFibonacciArcs}]);wijmoChartFinAn.directive("wjFlexChartFibonacciFans",[function(){return new WjFlexChartFibonacciFans}]);wijmoChartFinAn.directive("wjFlexChartFibonacciTimeZones",[function(){return new WjFlexChartFibonacciTimeZones}]);wijmoChartFinAn.directive("wjFlexChartAtr",[function(){return new WjFlexChartAtr}]);wijmoChartFinAn.directive("wjFlexChartCci",[function(){return new WjFlexChartCci}]);wijmoChartFinAn.directive("wjFlexChartRsi",[function(){return new WjFlexChartRsi}]);wijmoChartFinAn.directive("wjFlexChartWilliamsR",[function(){return new WjFlexChartWilliamsR}]);wijmoChartFinAn.directive("wjFlexChartMacd",[function(){return new WjFlexChartMacd}]);wijmoChartFinAn.directive("wjFlexChartMacdHistogram",[function(){return new WjFlexChartMacdHistogram}]);wijmoChartFinAn.directive("wjFlexChartStochastic",[function(){return new WjFlexChartStochastic}]);wijmoChartFinAn.directive("wjFlexChartBollingerBands",[function(){return new WjFlexChartBollingerBands}]);wijmoChartFinAn.directive("wjFlexChartEnvelopes",[function(){return new WjFlexChartEnvelopes}])}var WjBaseOverlayIndicator=function(t){__extends(WjBaseOverlayIndicator,t);function WjBaseOverlayIndicator(){var e=t.call(this)||this;e.require="^wjFinancialChart";e.template='<div class="wjBaseOverlayIndicator" ng-transclude />';return e}Object.defineProperty(WjBaseOverlayIndicator.prototype,"_controlConstructor",{get:function(){return wjcChartFinAn.OverlayIndicatorBase},enumerable:!0,configurable:!0});return WjBaseOverlayIndicator}(wijmo_angular_chart_1.WjSeriesBase);exports.WjBaseOverlayIndicator=WjBaseOverlayIndicator;var WjBaseSingleOverlayIndicator=function(t){__extends(WjBaseSingleOverlayIndicator,t);function WjBaseSingleOverlayIndicator(){var e=t.call(this)||this;e.template='<div class="wjBaseSingleOverlayIndicator" ng-transclude />';return e}Object.defineProperty(WjBaseSingleOverlayIndicator.prototype,"_controlConstructor",{get:function(){return wjcChartFinAn.SingleOverlayIndicatorBase},enumerable:!0,configurable:!0});return WjBaseSingleOverlayIndicator}(WjBaseOverlayIndicator);exports.WjBaseSingleOverlayIndicator=WjBaseSingleOverlayIndicator;var WjFlexChartFibonacci=function(t){__extends(WjFlexChartFibonacci,t);function WjFlexChartFibonacci(){var e=t.call(this)||this;e.require=["?^wjFinancialChart"];e.template='<div class="wjFlexChartFibonacci" ng-transclude />';return e}Object.defineProperty(WjFlexChartFibonacci.prototype,"_controlConstructor",{get:function(){return wjcChartFinAn.Fibonacci},enumerable:!0,configurable:!0});WjFlexChartFibonacci.prototype._initControl=function(e){return t.prototype._initControl.call(this,void 0)};return WjFlexChartFibonacci}(wijmo_angular_chart_1.WjSeriesBase);exports.WjFlexChartFibonacci=WjFlexChartFibonacci;var WjFlexChartFibonacciArcs=function(t){__extends(WjFlexChartFibonacciArcs,t);function WjFlexChartFibonacciArcs(){var e=t.call(this)||this;e.require=["?^wjFinancialChart"];e.template='<div class="wjFlexChartFibonacciArcs" ng-transclude />';return e}Object.defineProperty(WjFlexChartFibonacciArcs.prototype,"_controlConstructor",{get:function(){return wjcChartFinAn.FibonacciArcs},enumerable:!0,configurable:!0});WjFlexChartFibonacciArcs.prototype._initControl=function(e){return t.prototype._initControl.call(this,void 0)};return WjFlexChartFibonacciArcs}(wijmo_angular_chart_1.WjSeriesBase);exports.WjFlexChartFibonacciArcs=WjFlexChartFibonacciArcs;var WjFlexChartFibonacciFans=function(t){__extends(WjFlexChartFibonacciFans,t);function WjFlexChartFibonacciFans(){var e=t.call(this)||this;e.require=["?^wjFinancialChart"];e.template='<div class="wjFlexChartFibonacciFans" ng-transclude />';return e}Object.defineProperty(WjFlexChartFibonacciFans.prototype,"_controlConstructor",{get:function(){return wjcChartFinAn.FibonacciFans},enumerable:!0,configurable:!0});WjFlexChartFibonacciFans.prototype._initControl=function(e){return t.prototype._initControl.call(this,void 0)};return WjFlexChartFibonacciFans}(wijmo_angular_chart_1.WjSeriesBase);exports.WjFlexChartFibonacciFans=WjFlexChartFibonacciFans;var WjFlexChartFibonacciTimeZones=function(t){__extends(WjFlexChartFibonacciTimeZones,t);function WjFlexChartFibonacciTimeZones(){var e=t.call(this)||this;e.require=["?^wjFinancialChart"];e.template='<div class="wjFlexChartFibonacciTimeZones" ng-transclude />';return e}Object.defineProperty(WjFlexChartFibonacciTimeZones.prototype,"_controlConstructor",{get:function(){return wjcChartFinAn.FibonacciTimeZones},enumerable:!0,configurable:!0});WjFlexChartFibonacciTimeZones.prototype._initControl=function(e){return t.prototype._initControl.call(this,void 0)};return WjFlexChartFibonacciTimeZones}(wijmo_angular_chart_1.WjSeriesBase);exports.WjFlexChartFibonacciTimeZones=WjFlexChartFibonacciTimeZones;var WjFlexChartAtr=function(t){__extends(WjFlexChartAtr,t);function WjFlexChartAtr(){var e=t.call(this)||this;e.template='<div class="wjFlexChartAtr" ng-transclude />';return e}Object.defineProperty(WjFlexChartAtr.prototype,"_controlConstructor",{get:function(){return wjcChartFinAn.ATR},enumerable:!0,configurable:!0});return WjFlexChartAtr}(WjBaseSingleOverlayIndicator);exports.WjFlexChartAtr=WjFlexChartAtr;var WjFlexChartCci=function(t){__extends(WjFlexChartCci,t);function WjFlexChartCci(){var e=t.call(this)||this;e.template='<div class="wjFlexChartCci" ng-transclude />';return e}Object.defineProperty(WjFlexChartCci.prototype,"_controlConstructor",{get:function(){return wjcChartFinAn.CCI},enumerable:!0,configurable:!0});return WjFlexChartCci}(WjBaseSingleOverlayIndicator);exports.WjFlexChartCci=WjFlexChartCci;var WjFlexChartRsi=function(t){__extends(WjFlexChartRsi,t);function WjFlexChartRsi(){var e=t.call(this)||this;e.template='<div class="wjFlexChartRsi" ng-transclude />';return e}Object.defineProperty(WjFlexChartRsi.prototype,"_controlConstructor",{get:function(){return wjcChartFinAn.RSI},enumerable:!0,configurable:!0});return WjFlexChartRsi}(WjBaseSingleOverlayIndicator);exports.WjFlexChartRsi=WjFlexChartRsi;var WjFlexChartWilliamsR=function(t){__extends(WjFlexChartWilliamsR,t);function WjFlexChartWilliamsR(){var e=t.call(this)||this;e.template='<div class="wjFlexChartWilliamsR" ng-transclude />';return e}Object.defineProperty(WjFlexChartWilliamsR.prototype,"_controlConstructor",{get:function(){return wjcChartFinAn.WilliamsR},enumerable:!0,configurable:!0});return WjFlexChartWilliamsR}(WjBaseSingleOverlayIndicator);exports.WjFlexChartWilliamsR=WjFlexChartWilliamsR;var WjFlexChartMacdBase=function(t){__extends(WjFlexChartMacdBase,t);function WjFlexChartMacdBase(){var e=t.call(this)||this;e.template='<div class="wjFlexChartBaseMacd" ng-transclude />';return e}Object.defineProperty(WjFlexChartMacdBase.prototype,"_controlConstructor",{get:function(){return wjcChartFinAn.MacdBase},enumerable:!0,configurable:!0});return WjFlexChartMacdBase}(WjBaseOverlayIndicator);exports.WjFlexChartMacdBase=WjFlexChartMacdBase;var WjFlexChartMacd=function(t){__extends(WjFlexChartMacd,t);function WjFlexChartMacd(){var e=t.call(this)||this;e.template='<div class="wjFlexChartMacd" ng-transclude />';return e}Object.defineProperty(WjFlexChartMacd.prototype,"_controlConstructor",{get:function(){return wjcChartFinAn.Macd},enumerable:!0,configurable:!0});return WjFlexChartMacd}(WjFlexChartMacdBase);exports.WjFlexChartMacd=WjFlexChartMacd;var WjFlexChartMacdHistogram=function(t){__extends(WjFlexChartMacdHistogram,t);function WjFlexChartMacdHistogram(){var e=t.call(this)||this;e.template='<div class="wjFlexChartMacdHistogram" ng-transclude />';return e}Object.defineProperty(WjFlexChartMacdHistogram.prototype,"_controlConstructor",{get:function(){return wjcChartFinAn.MacdHistogram},enumerable:!0,configurable:!0});return WjFlexChartMacdHistogram}(WjFlexChartMacdBase);exports.WjFlexChartMacdHistogram=WjFlexChartMacdHistogram;var WjFlexChartStochastic=function(t){__extends(WjFlexChartStochastic,t);function WjFlexChartStochastic(){var e=t.call(this)||this;e.template='<div class="wjFlexChartStochastic" ng-transclude />';return e}Object.defineProperty(WjFlexChartStochastic.prototype,"_controlConstructor",{get:function(){return wjcChartFinAn.Stochastic},enumerable:!0,configurable:!0});return WjFlexChartStochastic}(WjBaseOverlayIndicator);exports.WjFlexChartStochastic=WjFlexChartStochastic;var WjFlexChartBollingerBands=function(t){__extends(WjFlexChartBollingerBands,t);function WjFlexChartBollingerBands(){var e=t.call(this)||this;e.template='<div class="wjFlexChartBollingerBands" ng-transclude />';return e}Object.defineProperty(WjFlexChartBollingerBands.prototype,"_controlConstructor",{get:function(){return wjcChartFinAn.BollingerBands},enumerable:!0,configurable:!0});return WjFlexChartBollingerBands}(WjBaseOverlayIndicator);exports.WjFlexChartBollingerBands=WjFlexChartBollingerBands;var WjFlexChartEnvelopes=function(t){__extends(WjFlexChartEnvelopes,t);function WjFlexChartEnvelopes(){var e=t.call(this)||this;e.template='<div class="wjFlexChartEnvelopes" ng-transclude />';return e}Object.defineProperty(WjFlexChartEnvelopes.prototype,"_controlConstructor",{get:function(){return wjcChartFinAn.Envelopes},enumerable:!0,configurable:!0});return WjFlexChartEnvelopes}(WjBaseOverlayIndicator);exports.WjFlexChartEnvelopes=WjFlexChartEnvelopes;