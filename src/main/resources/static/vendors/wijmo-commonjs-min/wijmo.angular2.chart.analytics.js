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

"use strict";var __extends=this&&this.__extends||function(){var extendStatics=function(e,t){return(extendStatics=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var r in t)t.hasOwnProperty(r)&&(e[r]=t[r])})(e,t)};return function(e,t){extendStatics(e,t);function __(){this.constructor=e}e.prototype=null===t?Object.create(t):(__.prototype=t.prototype,new __)}}(),__decorate=this&&this.__decorate||function(e,t,r,i){var a,n=arguments.length,o=n<3?t:null===i?i=Object.getOwnPropertyDescriptor(t,r):i;if("object"==typeof Reflect&&"function"==typeof Reflect.decorate)o=Reflect.decorate(e,t,r,i);else for(var s=e.length-1;s>=0;s--)(a=e[s])&&(o=(n<3?a(o):n>3?a(t,r,o):a(t,r))||o);return n>3&&o&&Object.defineProperty(t,r,o),o},__param=this&&this.__param||function(e,t){return function(r,i){t(r,i,e)}},__importStar=this&&this.__importStar||function(e){if(e&&e.__esModule)return e;var t={};if(null!=e)for(var r in e)Object.hasOwnProperty.call(e,r)&&(t[r]=e[r]);t.default=e;return t};Object.defineProperty(exports,"__esModule",{value:!0});var core_1=require("@angular/core"),common_1=require("@angular/common"),wijmo_angular2_directiveBase_1=require("wijmo/wijmo.angular2.directiveBase"),wjcChartAnalytics=__importStar(require("wijmo/wijmo.chart.analytics")),wjFlexChartTrendLineMeta={selector:"wj-flex-chart-trend-line",template:"",inputs:["asyncBindings","wjProperty","axisX","axisY","binding","bindingX","cssClass","name","style","altStyle","symbolMarker","symbolSize","symbolStyle","visibility","itemsSource","interpolateNulls","tooltipContent","itemFormatter","sampleCount","order","fitType"],outputs:["initialized","renderingNg: rendering","renderedNg: rendered","visibilityChangePC: visibilityChange"],providers:[]};exports.wjFlexChartTrendLineMeta=wjFlexChartTrendLineMeta;var WjFlexChartTrendLine=function(e){__extends(WjFlexChartTrendLine,e);function WjFlexChartTrendLine(t,r,i){var a=e.call(this)||this;a.isInitialized=!1;a.wjProperty="series";a._wjBehaviour=wijmo_angular2_directiveBase_1.WjDirectiveBehavior.attach(a,t,r,i);a.created();return a}t=WjFlexChartTrendLine;WjFlexChartTrendLine.prototype.created=function(){};WjFlexChartTrendLine.prototype.ngOnInit=function(){this._wjBehaviour.ngOnInit()};WjFlexChartTrendLine.prototype.ngAfterViewInit=function(){this._wjBehaviour.ngAfterViewInit()};WjFlexChartTrendLine.prototype.ngOnDestroy=function(){this._wjBehaviour.ngOnDestroy()};var t;WjFlexChartTrendLine.meta={outputs:wjFlexChartTrendLineMeta.outputs,changeEvents:{"chart.seriesVisibilityChanged":["visibility"]},siblingId:"series"};return WjFlexChartTrendLine=t=__decorate([core_1.Component({selector:wjFlexChartTrendLineMeta.selector,template:wjFlexChartTrendLineMeta.template,inputs:wjFlexChartTrendLineMeta.inputs,outputs:wjFlexChartTrendLineMeta.outputs,providers:[{provide:"WjComponent",useExisting:core_1.forwardRef((function(){return t}))}].concat(wjFlexChartTrendLineMeta.providers)}),__param(0,core_1.Inject(core_1.ElementRef)),__param(1,core_1.Inject(core_1.Injector)),__param(2,core_1.Inject("WjComponent")),__param(2,core_1.SkipSelf()),__param(2,core_1.Optional())],WjFlexChartTrendLine)}(wjcChartAnalytics.TrendLine);exports.WjFlexChartTrendLine=WjFlexChartTrendLine;var wjFlexChartMovingAverageMeta={selector:"wj-flex-chart-moving-average",template:"",inputs:["asyncBindings","wjProperty","axisX","axisY","binding","bindingX","cssClass","name","style","altStyle","symbolMarker","symbolSize","symbolStyle","visibility","itemsSource","interpolateNulls","tooltipContent","itemFormatter","sampleCount","period","type"],outputs:["initialized","renderingNg: rendering","renderedNg: rendered","visibilityChangePC: visibilityChange"],providers:[]};exports.wjFlexChartMovingAverageMeta=wjFlexChartMovingAverageMeta;var WjFlexChartMovingAverage=function(e){__extends(WjFlexChartMovingAverage,e);function WjFlexChartMovingAverage(t,r,i){var a=e.call(this)||this;a.isInitialized=!1;a.wjProperty="series";a._wjBehaviour=wijmo_angular2_directiveBase_1.WjDirectiveBehavior.attach(a,t,r,i);a.created();return a}t=WjFlexChartMovingAverage;WjFlexChartMovingAverage.prototype.created=function(){};WjFlexChartMovingAverage.prototype.ngOnInit=function(){this._wjBehaviour.ngOnInit()};WjFlexChartMovingAverage.prototype.ngAfterViewInit=function(){this._wjBehaviour.ngAfterViewInit()};WjFlexChartMovingAverage.prototype.ngOnDestroy=function(){this._wjBehaviour.ngOnDestroy()};var t;WjFlexChartMovingAverage.meta={outputs:wjFlexChartMovingAverageMeta.outputs,changeEvents:{"chart.seriesVisibilityChanged":["visibility"]},siblingId:"series"};return WjFlexChartMovingAverage=t=__decorate([core_1.Component({selector:wjFlexChartMovingAverageMeta.selector,template:wjFlexChartMovingAverageMeta.template,inputs:wjFlexChartMovingAverageMeta.inputs,outputs:wjFlexChartMovingAverageMeta.outputs,providers:[{provide:"WjComponent",useExisting:core_1.forwardRef((function(){return t}))}].concat(wjFlexChartMovingAverageMeta.providers)}),__param(0,core_1.Inject(core_1.ElementRef)),__param(1,core_1.Inject(core_1.Injector)),__param(2,core_1.Inject("WjComponent")),__param(2,core_1.SkipSelf()),__param(2,core_1.Optional())],WjFlexChartMovingAverage)}(wjcChartAnalytics.MovingAverage);exports.WjFlexChartMovingAverage=WjFlexChartMovingAverage;var wjFlexChartYFunctionSeriesMeta={selector:"wj-flex-chart-y-function-series",template:"",inputs:["asyncBindings","wjProperty","axisX","axisY","binding","bindingX","cssClass","name","style","altStyle","symbolMarker","symbolSize","symbolStyle","visibility","itemsSource","interpolateNulls","tooltipContent","itemFormatter","sampleCount","min","max","func"],outputs:["initialized","renderingNg: rendering","renderedNg: rendered","visibilityChangePC: visibilityChange"],providers:[]};exports.wjFlexChartYFunctionSeriesMeta=wjFlexChartYFunctionSeriesMeta;var WjFlexChartYFunctionSeries=function(e){__extends(WjFlexChartYFunctionSeries,e);function WjFlexChartYFunctionSeries(t,r,i){var a=e.call(this)||this;a.isInitialized=!1;a.wjProperty="series";a._wjBehaviour=wijmo_angular2_directiveBase_1.WjDirectiveBehavior.attach(a,t,r,i);a.created();return a}t=WjFlexChartYFunctionSeries;WjFlexChartYFunctionSeries.prototype.created=function(){};WjFlexChartYFunctionSeries.prototype.ngOnInit=function(){this._wjBehaviour.ngOnInit()};WjFlexChartYFunctionSeries.prototype.ngAfterViewInit=function(){this._wjBehaviour.ngAfterViewInit()};WjFlexChartYFunctionSeries.prototype.ngOnDestroy=function(){this._wjBehaviour.ngOnDestroy()};var t;WjFlexChartYFunctionSeries.meta={outputs:wjFlexChartYFunctionSeriesMeta.outputs,changeEvents:{"chart.seriesVisibilityChanged":["visibility"]},siblingId:"series"};return WjFlexChartYFunctionSeries=t=__decorate([core_1.Component({selector:wjFlexChartYFunctionSeriesMeta.selector,template:wjFlexChartYFunctionSeriesMeta.template,inputs:wjFlexChartYFunctionSeriesMeta.inputs,outputs:wjFlexChartYFunctionSeriesMeta.outputs,providers:[{provide:"WjComponent",useExisting:core_1.forwardRef((function(){return t}))}].concat(wjFlexChartYFunctionSeriesMeta.providers)}),__param(0,core_1.Inject(core_1.ElementRef)),__param(1,core_1.Inject(core_1.Injector)),__param(2,core_1.Inject("WjComponent")),__param(2,core_1.SkipSelf()),__param(2,core_1.Optional())],WjFlexChartYFunctionSeries)}(wjcChartAnalytics.YFunctionSeries);exports.WjFlexChartYFunctionSeries=WjFlexChartYFunctionSeries;var wjFlexChartParametricFunctionSeriesMeta={selector:"wj-flex-chart-parametric-function-series",template:"",inputs:["asyncBindings","wjProperty","axisX","axisY","binding","bindingX","cssClass","name","style","altStyle","symbolMarker","symbolSize","symbolStyle","visibility","itemsSource","interpolateNulls","tooltipContent","itemFormatter","sampleCount","min","max","func","xFunc","yFunc"],outputs:["initialized","renderingNg: rendering","renderedNg: rendered","visibilityChangePC: visibilityChange"],providers:[]};exports.wjFlexChartParametricFunctionSeriesMeta=wjFlexChartParametricFunctionSeriesMeta;var WjFlexChartParametricFunctionSeries=function(e){__extends(WjFlexChartParametricFunctionSeries,e);function WjFlexChartParametricFunctionSeries(t,r,i){var a=e.call(this)||this;a.isInitialized=!1;a.wjProperty="series";a._wjBehaviour=wijmo_angular2_directiveBase_1.WjDirectiveBehavior.attach(a,t,r,i);a.created();return a}t=WjFlexChartParametricFunctionSeries;WjFlexChartParametricFunctionSeries.prototype.created=function(){};WjFlexChartParametricFunctionSeries.prototype.ngOnInit=function(){this._wjBehaviour.ngOnInit()};WjFlexChartParametricFunctionSeries.prototype.ngAfterViewInit=function(){this._wjBehaviour.ngAfterViewInit()};WjFlexChartParametricFunctionSeries.prototype.ngOnDestroy=function(){this._wjBehaviour.ngOnDestroy()};var t;WjFlexChartParametricFunctionSeries.meta={outputs:wjFlexChartParametricFunctionSeriesMeta.outputs,changeEvents:{"chart.seriesVisibilityChanged":["visibility"]},siblingId:"series"};return WjFlexChartParametricFunctionSeries=t=__decorate([core_1.Component({selector:wjFlexChartParametricFunctionSeriesMeta.selector,template:wjFlexChartParametricFunctionSeriesMeta.template,inputs:wjFlexChartParametricFunctionSeriesMeta.inputs,outputs:wjFlexChartParametricFunctionSeriesMeta.outputs,providers:[{provide:"WjComponent",useExisting:core_1.forwardRef((function(){return t}))}].concat(wjFlexChartParametricFunctionSeriesMeta.providers)}),__param(0,core_1.Inject(core_1.ElementRef)),__param(1,core_1.Inject(core_1.Injector)),__param(2,core_1.Inject("WjComponent")),__param(2,core_1.SkipSelf()),__param(2,core_1.Optional())],WjFlexChartParametricFunctionSeries)}(wjcChartAnalytics.ParametricFunctionSeries);exports.WjFlexChartParametricFunctionSeries=WjFlexChartParametricFunctionSeries;var wjFlexChartWaterfallMeta={selector:"wj-flex-chart-waterfall",template:"",inputs:["asyncBindings","wjProperty","axisX","axisY","binding","bindingX","cssClass","name","style","altStyle","symbolMarker","symbolSize","symbolStyle","visibility","itemsSource","interpolateNulls","tooltipContent","itemFormatter","relativeData","start","startLabel","showTotal","totalLabel","showIntermediateTotal","intermediateTotalPositions","intermediateTotalLabels","connectorLines","styles"],outputs:["initialized","renderingNg: rendering","renderedNg: rendered","visibilityChangePC: visibilityChange"],providers:[]};exports.wjFlexChartWaterfallMeta=wjFlexChartWaterfallMeta;var WjFlexChartWaterfall=function(e){__extends(WjFlexChartWaterfall,e);function WjFlexChartWaterfall(t,r,i){var a=e.call(this)||this;a.isInitialized=!1;a.wjProperty="series";a._wjBehaviour=wijmo_angular2_directiveBase_1.WjDirectiveBehavior.attach(a,t,r,i);a.created();return a}t=WjFlexChartWaterfall;WjFlexChartWaterfall.prototype.created=function(){};WjFlexChartWaterfall.prototype.ngOnInit=function(){this._wjBehaviour.ngOnInit()};WjFlexChartWaterfall.prototype.ngAfterViewInit=function(){this._wjBehaviour.ngAfterViewInit()};WjFlexChartWaterfall.prototype.ngOnDestroy=function(){this._wjBehaviour.ngOnDestroy()};var t;WjFlexChartWaterfall.meta={outputs:wjFlexChartWaterfallMeta.outputs,changeEvents:{"chart.seriesVisibilityChanged":["visibility"]},siblingId:"series"};return WjFlexChartWaterfall=t=__decorate([core_1.Component({selector:wjFlexChartWaterfallMeta.selector,template:wjFlexChartWaterfallMeta.template,inputs:wjFlexChartWaterfallMeta.inputs,outputs:wjFlexChartWaterfallMeta.outputs,providers:[{provide:"WjComponent",useExisting:core_1.forwardRef((function(){return t}))}].concat(wjFlexChartWaterfallMeta.providers)}),__param(0,core_1.Inject(core_1.ElementRef)),__param(1,core_1.Inject(core_1.Injector)),__param(2,core_1.Inject("WjComponent")),__param(2,core_1.SkipSelf()),__param(2,core_1.Optional())],WjFlexChartWaterfall)}(wjcChartAnalytics.Waterfall);exports.WjFlexChartWaterfall=WjFlexChartWaterfall;var wjFlexChartBoxWhiskerMeta={selector:"wj-flex-chart-box-whisker",template:"",inputs:["asyncBindings","wjProperty","axisX","axisY","binding","bindingX","cssClass","name","style","altStyle","symbolMarker","symbolSize","symbolStyle","visibility","itemsSource","interpolateNulls","tooltipContent","itemFormatter","quartileCalculation","groupWidth","gapWidth","showMeanLine","meanLineStyle","showMeanMarker","meanMarkerStyle","showInnerPoints","showOutliers"],outputs:["initialized","renderingNg: rendering","renderedNg: rendered","visibilityChangePC: visibilityChange"],providers:[]};exports.wjFlexChartBoxWhiskerMeta=wjFlexChartBoxWhiskerMeta;var WjFlexChartBoxWhisker=function(e){__extends(WjFlexChartBoxWhisker,e);function WjFlexChartBoxWhisker(t,r,i){var a=e.call(this)||this;a.isInitialized=!1;a.wjProperty="series";a._wjBehaviour=wijmo_angular2_directiveBase_1.WjDirectiveBehavior.attach(a,t,r,i);a.created();return a}t=WjFlexChartBoxWhisker;WjFlexChartBoxWhisker.prototype.created=function(){};WjFlexChartBoxWhisker.prototype.ngOnInit=function(){this._wjBehaviour.ngOnInit()};WjFlexChartBoxWhisker.prototype.ngAfterViewInit=function(){this._wjBehaviour.ngAfterViewInit()};WjFlexChartBoxWhisker.prototype.ngOnDestroy=function(){this._wjBehaviour.ngOnDestroy()};var t;WjFlexChartBoxWhisker.meta={outputs:wjFlexChartBoxWhiskerMeta.outputs,changeEvents:{"chart.seriesVisibilityChanged":["visibility"]},siblingId:"series"};return WjFlexChartBoxWhisker=t=__decorate([core_1.Component({selector:wjFlexChartBoxWhiskerMeta.selector,template:wjFlexChartBoxWhiskerMeta.template,inputs:wjFlexChartBoxWhiskerMeta.inputs,outputs:wjFlexChartBoxWhiskerMeta.outputs,providers:[{provide:"WjComponent",useExisting:core_1.forwardRef((function(){return t}))}].concat(wjFlexChartBoxWhiskerMeta.providers)}),__param(0,core_1.Inject(core_1.ElementRef)),__param(1,core_1.Inject(core_1.Injector)),__param(2,core_1.Inject("WjComponent")),__param(2,core_1.SkipSelf()),__param(2,core_1.Optional())],WjFlexChartBoxWhisker)}(wjcChartAnalytics.BoxWhisker);exports.WjFlexChartBoxWhisker=WjFlexChartBoxWhisker;var wjFlexChartErrorBarMeta={selector:"wj-flex-chart-error-bar",template:"",inputs:["asyncBindings","wjProperty","axisX","axisY","binding","bindingX","cssClass","name","style","altStyle","symbolMarker","symbolSize","symbolStyle","visibility","itemsSource","interpolateNulls","tooltipContent","itemFormatter","chartType","errorBarStyle","value","errorAmount","endStyle","direction"],outputs:["initialized","renderingNg: rendering","renderedNg: rendered","visibilityChangePC: visibilityChange"],providers:[]};exports.wjFlexChartErrorBarMeta=wjFlexChartErrorBarMeta;var WjFlexChartErrorBar=function(e){__extends(WjFlexChartErrorBar,e);function WjFlexChartErrorBar(t,r,i){var a=e.call(this)||this;a.isInitialized=!1;a.wjProperty="series";a._wjBehaviour=wijmo_angular2_directiveBase_1.WjDirectiveBehavior.attach(a,t,r,i);a.created();return a}t=WjFlexChartErrorBar;WjFlexChartErrorBar.prototype.created=function(){};WjFlexChartErrorBar.prototype.ngOnInit=function(){this._wjBehaviour.ngOnInit()};WjFlexChartErrorBar.prototype.ngAfterViewInit=function(){this._wjBehaviour.ngAfterViewInit()};WjFlexChartErrorBar.prototype.ngOnDestroy=function(){this._wjBehaviour.ngOnDestroy()};var t;WjFlexChartErrorBar.meta={outputs:wjFlexChartErrorBarMeta.outputs,changeEvents:{"chart.seriesVisibilityChanged":["visibility"]},siblingId:"series"};return WjFlexChartErrorBar=t=__decorate([core_1.Component({selector:wjFlexChartErrorBarMeta.selector,template:wjFlexChartErrorBarMeta.template,inputs:wjFlexChartErrorBarMeta.inputs,outputs:wjFlexChartErrorBarMeta.outputs,providers:[{provide:"WjComponent",useExisting:core_1.forwardRef((function(){return t}))}].concat(wjFlexChartErrorBarMeta.providers)}),__param(0,core_1.Inject(core_1.ElementRef)),__param(1,core_1.Inject(core_1.Injector)),__param(2,core_1.Inject("WjComponent")),__param(2,core_1.SkipSelf()),__param(2,core_1.Optional())],WjFlexChartErrorBar)}(wjcChartAnalytics.ErrorBar);exports.WjFlexChartErrorBar=WjFlexChartErrorBar;var wjFlexChartBreakEvenMeta={selector:"wj-flex-chart-break-even",template:"",inputs:["asyncBindings","wjProperty","axisX","axisY","binding","bindingX","cssClass","name","style","altStyle","symbolMarker","symbolSize","symbolStyle","visibility","itemsSource","interpolateNulls","tooltipContent","itemFormatter","fixedCost","variableCost","salesPrice","styles"],outputs:["initialized","renderingNg: rendering","renderedNg: rendered","visibilityChangePC: visibilityChange"],providers:[]};exports.wjFlexChartBreakEvenMeta=wjFlexChartBreakEvenMeta;var WjFlexChartBreakEven=function(e){__extends(WjFlexChartBreakEven,e);function WjFlexChartBreakEven(t,r,i){var a=e.call(this)||this;a.isInitialized=!1;a.wjProperty="series";a._wjBehaviour=wijmo_angular2_directiveBase_1.WjDirectiveBehavior.attach(a,t,r,i);a.created();return a}t=WjFlexChartBreakEven;WjFlexChartBreakEven.prototype.created=function(){};WjFlexChartBreakEven.prototype.ngOnInit=function(){this._wjBehaviour.ngOnInit()};WjFlexChartBreakEven.prototype.ngAfterViewInit=function(){this._wjBehaviour.ngAfterViewInit()};WjFlexChartBreakEven.prototype.ngOnDestroy=function(){this._wjBehaviour.ngOnDestroy()};var t;WjFlexChartBreakEven.meta={outputs:wjFlexChartBreakEvenMeta.outputs,changeEvents:{"chart.seriesVisibilityChanged":["visibility"]},siblingId:"series"};return WjFlexChartBreakEven=t=__decorate([core_1.Component({selector:wjFlexChartBreakEvenMeta.selector,template:wjFlexChartBreakEvenMeta.template,inputs:wjFlexChartBreakEvenMeta.inputs,outputs:wjFlexChartBreakEvenMeta.outputs,providers:[{provide:"WjComponent",useExisting:core_1.forwardRef((function(){return t}))}].concat(wjFlexChartBreakEvenMeta.providers)}),__param(0,core_1.Inject(core_1.ElementRef)),__param(1,core_1.Inject(core_1.Injector)),__param(2,core_1.Inject("WjComponent")),__param(2,core_1.SkipSelf()),__param(2,core_1.Optional())],WjFlexChartBreakEven)}(wjcChartAnalytics.BreakEven);exports.WjFlexChartBreakEven=WjFlexChartBreakEven;var moduleExports=[WjFlexChartTrendLine,WjFlexChartMovingAverage,WjFlexChartYFunctionSeries,WjFlexChartParametricFunctionSeries,WjFlexChartWaterfall,WjFlexChartBoxWhisker,WjFlexChartErrorBar,WjFlexChartBreakEven],WjChartAnalyticsModule=function(){function WjChartAnalyticsModule(){}return WjChartAnalyticsModule=__decorate([core_1.NgModule({imports:[common_1.CommonModule],declarations:moduleExports.slice(),exports:moduleExports.slice()})],WjChartAnalyticsModule)}();exports.WjChartAnalyticsModule=WjChartAnalyticsModule;