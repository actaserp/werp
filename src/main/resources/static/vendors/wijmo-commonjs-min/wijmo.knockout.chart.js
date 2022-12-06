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

"use strict";var __extends=this&&this.__extends||function(){var extendStatics=function(t,e){return(extendStatics=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(t,e){t.__proto__=e}||function(t,e){for(var r in e)e.hasOwnProperty(r)&&(t[r]=e[r])})(t,e)};return function(t,e){extendStatics(t,e);function __(){this.constructor=t}t.prototype=null===e?Object.create(e):(__.prototype=e.prototype,new __)}}(),__importStar=this&&this.__importStar||function(t){if(t&&t.__esModule)return t;var e={};if(null!=t)for(var r in t)Object.hasOwnProperty.call(t,r)&&(e[r]=t[r]);e.default=t;return e};Object.defineProperty(exports,"__esModule",{value:!0});var wijmo_knockout_base_1=require("wijmo/wijmo.knockout.base"),mKo=__importStar(require("knockout")),wjcChart=__importStar(require("wijmo/wijmo.chart")),wjKo=mKo,WjFlexChartBaseBinding=function(t){__extends(WjFlexChartBaseBinding,t);function WjFlexChartBaseBinding(){return null!==t&&t.apply(this,arguments)||this}WjFlexChartBaseBinding.prototype._getControlConstructor=function(){return wjcChart.FlexChartBase};WjFlexChartBaseBinding.prototype._initialize=function(){t.prototype._initialize.call(this);wijmo_knockout_base_1.MetaFactory.findProp("tooltipContent",this._metaData.props).updateControl=function(t,e,r,n,o){null!=o&&(r.tooltip.content=o);return!0}};return WjFlexChartBaseBinding}(wijmo_knockout_base_1.WjBinding);exports.WjFlexChartBaseBinding=WjFlexChartBaseBinding;var wjFlexChart=function(t){__extends(wjFlexChart,t);function wjFlexChart(){return null!==t&&t.apply(this,arguments)||this}wjFlexChart.prototype._getControlConstructor=function(){return wjcChart.FlexChart};wjFlexChart.prototype._initialize=function(){t.prototype._initialize.call(this);wijmo_knockout_base_1.MetaFactory.findProp("labelContent",this._metaData.props).updateControl=function(t,e,r,n,o){null!=o&&(r.dataLabel.content=o);return!0}};return wjFlexChart}(WjFlexChartBaseBinding);exports.wjFlexChart=wjFlexChart;var wjFlexPie=function(t){__extends(wjFlexPie,t);function wjFlexPie(){return null!==t&&t.apply(this,arguments)||this}wjFlexPie.prototype._getControlConstructor=function(){return wjcChart.FlexPie};wjFlexPie.prototype._initialize=function(){t.prototype._initialize.call(this);wijmo_knockout_base_1.MetaFactory.findProp("labelContent",this._metaData.props).updateControl=function(t,e,r,n,o){null!=o&&(r.dataLabel.content=o);return!0}};return wjFlexPie}(WjFlexChartBaseBinding);exports.wjFlexPie=wjFlexPie;var wjFlexChartAxis=function(t){__extends(wjFlexChartAxis,t);function wjFlexChartAxis(){return null!==t&&t.apply(this,arguments)||this}wjFlexChartAxis.prototype._getControlConstructor=function(){return wjcChart.Axis};return wjFlexChartAxis}(wijmo_knockout_base_1.WjBinding);exports.wjFlexChartAxis=wjFlexChartAxis;var wjFlexChartLegend=function(t){__extends(wjFlexChartLegend,t);function wjFlexChartLegend(){return null!==t&&t.apply(this,arguments)||this}wjFlexChartLegend.prototype._getControlConstructor=function(){return wjcChart.Legend};return wjFlexChartLegend}(wijmo_knockout_base_1.WjBinding);exports.wjFlexChartLegend=wjFlexChartLegend;var WjSeriesBase=function(t){__extends(WjSeriesBase,t);function WjSeriesBase(){return null!==t&&t.apply(this,arguments)||this}WjSeriesBase.prototype._getControlConstructor=function(){return wjcChart.SeriesBase};WjSeriesBase.prototype._createControl=function(e){return t.prototype._createControl.call(this,null)};return WjSeriesBase}(wijmo_knockout_base_1.WjBinding);exports.WjSeriesBase=WjSeriesBase;var wjFlexChartSeries=function(t){__extends(wjFlexChartSeries,t);function wjFlexChartSeries(){return null!==t&&t.apply(this,arguments)||this}wjFlexChartSeries.prototype._getControlConstructor=function(){return wjcChart.Series};wjFlexChartSeries.prototype._createWijmoContext=function(){return new WjFlexChartSeriesContext(this)};return wjFlexChartSeries}(WjSeriesBase);exports.wjFlexChartSeries=wjFlexChartSeries;var WjFlexChartSeriesContext=function(t){__extends(WjFlexChartSeriesContext,t);function WjFlexChartSeriesContext(){return null!==t&&t.apply(this,arguments)||this}WjFlexChartSeriesContext.prototype._initControl=function(){var e=this;t.prototype._initControl.call(this);var r=this.parentWjContext.control;r instanceof wjcChart.FlexChart&&r.seriesVisibilityChanged.addHandler((function(t,r){e._updateSource()}))};return WjFlexChartSeriesContext}(wijmo_knockout_base_1.WjContext);exports.WjFlexChartSeriesContext=WjFlexChartSeriesContext;var wjFlexChartLineMarker=function(t){__extends(wjFlexChartLineMarker,t);function wjFlexChartLineMarker(){return null!==t&&t.apply(this,arguments)||this}wjFlexChartLineMarker.prototype._getControlConstructor=function(){return wjcChart.LineMarker};return wjFlexChartLineMarker}(wijmo_knockout_base_1.WjBinding);exports.wjFlexChartLineMarker=wjFlexChartLineMarker;var wjFlexChartPlotArea=function(t){__extends(wjFlexChartPlotArea,t);function wjFlexChartPlotArea(){return null!==t&&t.apply(this,arguments)||this}wjFlexChartPlotArea.prototype._getControlConstructor=function(){return wjcChart.PlotArea};return wjFlexChartPlotArea}(wijmo_knockout_base_1.WjBinding);exports.wjFlexChartPlotArea=wjFlexChartPlotArea;var wjFlexChartDataPoint=function(t){__extends(wjFlexChartDataPoint,t);function wjFlexChartDataPoint(){return null!==t&&t.apply(this,arguments)||this}wjFlexChartDataPoint.prototype._getControlConstructor=function(){return wjcChart.DataPoint};return wjFlexChartDataPoint}(wijmo_knockout_base_1.WjBinding);exports.wjFlexChartDataPoint=wjFlexChartDataPoint;wjKo.bindingHandlers.wjFlexChart=new wjFlexChart;wjKo.bindingHandlers.wjFlexPie=new wjFlexPie;wjKo.bindingHandlers.wjFlexChartAxis=new wjFlexChartAxis;wjKo.bindingHandlers.wjFlexChartLegend=new wjFlexChartLegend;wjKo.bindingHandlers.wjFlexChartSeries=new wjFlexChartSeries;wjKo.bindingHandlers.wjFlexChartLineMarker=new wjFlexChartLineMarker;wjKo.bindingHandlers.wjFlexChartPlotArea=new wjFlexChartPlotArea;wjKo.bindingHandlers.wjFlexChartDataPoint=new wjFlexChartDataPoint;