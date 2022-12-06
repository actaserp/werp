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

"use strict";var __extends=this&&this.__extends||function(){var extendStatics=function(e,r){return(extendStatics=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,r){e.__proto__=r}||function(e,r){for(var t in r)r.hasOwnProperty(t)&&(e[t]=r[t])})(e,r)};return function(e,r){extendStatics(e,r);function __(){this.constructor=e}e.prototype=null===r?Object.create(r):(__.prototype=r.prototype,new __)}}(),__importStar=this&&this.__importStar||function(e){if(e&&e.__esModule)return e;var r={};if(null!=e)for(var t in e)Object.hasOwnProperty.call(e,t)&&(r[t]=e[t]);r.default=e;return r};Object.defineProperty(exports,"__esModule",{value:!0});var wijmo_knockout_base_1=require("wijmo/wijmo.knockout.base"),wijmo_knockout_chart_1=require("wijmo/wijmo.knockout.chart"),mKo=__importStar(require("knockout")),wjcChartAnal=__importStar(require("wijmo/wijmo.chart.analytics")),wjKo=mKo,WjTrendLineBase=function(e){__extends(WjTrendLineBase,e);function WjTrendLineBase(){return null!==e&&e.apply(this,arguments)||this}WjTrendLineBase.prototype._getControlConstructor=function(){return wjcChartAnal.TrendLineBase};return WjTrendLineBase}(wijmo_knockout_chart_1.WjSeriesBase);exports.WjTrendLineBase=WjTrendLineBase;var wjFlexChartTrendLine=function(e){__extends(wjFlexChartTrendLine,e);function wjFlexChartTrendLine(){return null!==e&&e.apply(this,arguments)||this}wjFlexChartTrendLine.prototype._getControlConstructor=function(){return wjcChartAnal.TrendLine};return wjFlexChartTrendLine}(WjTrendLineBase);exports.wjFlexChartTrendLine=wjFlexChartTrendLine;var wjFlexChartMovingAverage=function(e){__extends(wjFlexChartMovingAverage,e);function wjFlexChartMovingAverage(){return null!==e&&e.apply(this,arguments)||this}wjFlexChartMovingAverage.prototype._getControlConstructor=function(){return wjcChartAnal.MovingAverage};return wjFlexChartMovingAverage}(WjTrendLineBase);exports.wjFlexChartMovingAverage=wjFlexChartMovingAverage;var wjFlexChartYFunctionSeries=function(e){__extends(wjFlexChartYFunctionSeries,e);function wjFlexChartYFunctionSeries(){return null!==e&&e.apply(this,arguments)||this}wjFlexChartYFunctionSeries.prototype._getControlConstructor=function(){return wjcChartAnal.YFunctionSeries};return wjFlexChartYFunctionSeries}(WjTrendLineBase);exports.wjFlexChartYFunctionSeries=wjFlexChartYFunctionSeries;var wjFlexChartParametricFunctionSeries=function(e){__extends(wjFlexChartParametricFunctionSeries,e);function wjFlexChartParametricFunctionSeries(){return null!==e&&e.apply(this,arguments)||this}wjFlexChartParametricFunctionSeries.prototype._getControlConstructor=function(){return wjcChartAnal.ParametricFunctionSeries};wjFlexChartParametricFunctionSeries.prototype._initialize=function(){e.prototype._initialize.call(this);wijmo_knockout_base_1.MetaFactory.findProp("func",this._metaData.props).updateControl=function(e,r,t,n,a){null!=a&&(t.xFunc=a);return!0}};return wjFlexChartParametricFunctionSeries}(WjTrendLineBase);exports.wjFlexChartParametricFunctionSeries=wjFlexChartParametricFunctionSeries;var wjFlexChartWaterfall=function(e){__extends(wjFlexChartWaterfall,e);function wjFlexChartWaterfall(){return null!==e&&e.apply(this,arguments)||this}wjFlexChartWaterfall.prototype._getControlConstructor=function(){return wjcChartAnal.Waterfall};return wjFlexChartWaterfall}(wijmo_knockout_chart_1.WjSeriesBase);exports.wjFlexChartWaterfall=wjFlexChartWaterfall;wjKo.bindingHandlers.wjFlexChartTrendLine=new wjFlexChartTrendLine;wjKo.bindingHandlers.wjFlexChartMovingAverage=new wjFlexChartMovingAverage;wjKo.bindingHandlers.wjFlexChartYFunctionSeries=new wjFlexChartYFunctionSeries;wjKo.bindingHandlers.wjFlexChartParametricFunctionSeries=new wjFlexChartParametricFunctionSeries;wjKo.bindingHandlers.wjFlexChartWaterfall=new wjFlexChartWaterfall;