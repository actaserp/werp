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

"use strict";var WjLinearGauge_1,WjBulletGraph_1,WjRadialGauge_1,WjRange_1,__decorate=this&&this.__decorate||function(e,t,a,r){var i,n=arguments.length,o=n<3?t:null===r?r=Object.getOwnPropertyDescriptor(t,a):r;if("object"==typeof Reflect&&"function"==typeof Reflect.decorate)o=Reflect.decorate(e,t,a,r);else for(var s=e.length-1;s>=0;s--)(i=e[s])&&(o=(n<3?i(o):n>3?i(t,a,o):i(t,a))||o);return n>3&&o&&Object.defineProperty(t,a,o),o},__param=this&&this.__param||function(e,t){return function(a,r){t(a,r,e)}},__importStar=this&&this.__importStar||function(e){if(e&&e.__esModule)return e;var t={};if(null!=e)for(var a in e)Object.hasOwnProperty.call(e,a)&&(t[a]=e[a]);t.default=e;return t};Object.defineProperty(exports,"__esModule",{value:!0});const core_1=require("@angular/core"),common_1=require("@angular/common"),forms_1=require("@angular/forms"),wijmo_angular2_directiveBase_1=require("wijmo/wijmo.angular2.directiveBase"),wjcGauge=__importStar(require("wijmo/wijmo.gauge"));var wjLinearGaugeMeta={selector:"wj-linear-gauge",template:"<div><ng-content></ng-content></div>",inputs:["asyncBindings","wjModelProperty","isDisabled","tabOrder","value","min","max","origin","isReadOnly","handleWheel","step","format","thickness","hasShadow","isAnimated","showText","showTicks","showTickText","showRanges","stackRanges","thumbSize","tickSpacing","getText","direction"],outputs:["initialized","gotFocusNg: gotFocus","lostFocusNg: lostFocus","refreshingNg: refreshing","refreshedNg: refreshed","invalidInputNg: invalidInput","valueChangedNg: valueChanged","valueChangePC: valueChange"],providers:[{provide:forms_1.NG_VALUE_ACCESSOR,useFactory:wijmo_angular2_directiveBase_1.WjValueAccessorFactory,multi:!0,deps:["WjComponent"]}]};exports.wjLinearGaugeMeta=wjLinearGaugeMeta;let WjLinearGauge=WjLinearGauge_1=class WjLinearGauge extends wjcGauge.LinearGauge{constructor(e,t,a){super(wijmo_angular2_directiveBase_1.WjDirectiveBehavior.getHostElement(e,t));this.isInitialized=!1;this.wjModelProperty="value";this._wjBehaviour=wijmo_angular2_directiveBase_1.WjDirectiveBehavior.attach(this,e,t,a);this.created()}created(){}ngOnInit(){this._wjBehaviour.ngOnInit()}ngAfterViewInit(){this._wjBehaviour.ngAfterViewInit()}ngOnDestroy(){this._wjBehaviour.ngOnDestroy()}addEventListener(e,t,a,r=!1){let i=wijmo_angular2_directiveBase_1.WjDirectiveBehavior,n=i.getZone(this);n&&i.outsideZoneEvents[t]?n.runOutsideAngular(()=>{super.addEventListener(e,t,a,r)}):super.addEventListener(e,t,a,r)}};WjLinearGauge.meta={outputs:wjLinearGaugeMeta.outputs,changeEvents:{valueChanged:["value"]}};WjLinearGauge=WjLinearGauge_1=__decorate([core_1.Component({selector:wjLinearGaugeMeta.selector,template:wjLinearGaugeMeta.template,inputs:wjLinearGaugeMeta.inputs,outputs:wjLinearGaugeMeta.outputs,providers:[{provide:"WjComponent",useExisting:core_1.forwardRef(()=>WjLinearGauge_1)},...wjLinearGaugeMeta.providers]}),__param(0,core_1.Inject(core_1.ElementRef)),__param(1,core_1.Inject(core_1.Injector)),__param(2,core_1.Inject("WjComponent")),__param(2,core_1.SkipSelf()),__param(2,core_1.Optional())],WjLinearGauge);exports.WjLinearGauge=WjLinearGauge;var wjBulletGraphMeta={selector:"wj-bullet-graph",template:"<div><ng-content></ng-content></div>",inputs:["asyncBindings","wjModelProperty","isDisabled","tabOrder","value","min","max","origin","isReadOnly","handleWheel","step","format","thickness","hasShadow","isAnimated","showText","showTicks","showTickText","showRanges","stackRanges","thumbSize","tickSpacing","getText","direction","target","good","bad"],outputs:["initialized","gotFocusNg: gotFocus","lostFocusNg: lostFocus","refreshingNg: refreshing","refreshedNg: refreshed","invalidInputNg: invalidInput","valueChangedNg: valueChanged","valueChangePC: valueChange"],providers:[{provide:forms_1.NG_VALUE_ACCESSOR,useFactory:wijmo_angular2_directiveBase_1.WjValueAccessorFactory,multi:!0,deps:["WjComponent"]}]};exports.wjBulletGraphMeta=wjBulletGraphMeta;let WjBulletGraph=WjBulletGraph_1=class WjBulletGraph extends wjcGauge.BulletGraph{constructor(e,t,a){super(wijmo_angular2_directiveBase_1.WjDirectiveBehavior.getHostElement(e,t));this.isInitialized=!1;this.wjModelProperty="value";this._wjBehaviour=wijmo_angular2_directiveBase_1.WjDirectiveBehavior.attach(this,e,t,a);this.created()}created(){}ngOnInit(){this._wjBehaviour.ngOnInit()}ngAfterViewInit(){this._wjBehaviour.ngAfterViewInit()}ngOnDestroy(){this._wjBehaviour.ngOnDestroy()}addEventListener(e,t,a,r=!1){let i=wijmo_angular2_directiveBase_1.WjDirectiveBehavior,n=i.getZone(this);n&&i.outsideZoneEvents[t]?n.runOutsideAngular(()=>{super.addEventListener(e,t,a,r)}):super.addEventListener(e,t,a,r)}};WjBulletGraph.meta={outputs:wjBulletGraphMeta.outputs,changeEvents:{valueChanged:["value"]}};WjBulletGraph=WjBulletGraph_1=__decorate([core_1.Component({selector:wjBulletGraphMeta.selector,template:wjBulletGraphMeta.template,inputs:wjBulletGraphMeta.inputs,outputs:wjBulletGraphMeta.outputs,providers:[{provide:"WjComponent",useExisting:core_1.forwardRef(()=>WjBulletGraph_1)},...wjBulletGraphMeta.providers]}),__param(0,core_1.Inject(core_1.ElementRef)),__param(1,core_1.Inject(core_1.Injector)),__param(2,core_1.Inject("WjComponent")),__param(2,core_1.SkipSelf()),__param(2,core_1.Optional())],WjBulletGraph);exports.WjBulletGraph=WjBulletGraph;var wjRadialGaugeMeta={selector:"wj-radial-gauge",template:"<div><ng-content></ng-content></div>",inputs:["asyncBindings","wjModelProperty","isDisabled","tabOrder","value","min","max","origin","isReadOnly","handleWheel","step","format","thickness","hasShadow","isAnimated","showText","showTicks","showTickText","showRanges","stackRanges","thumbSize","tickSpacing","getText","autoScale","startAngle","sweepAngle","needleShape","needleLength","needleElement"],outputs:["initialized","gotFocusNg: gotFocus","lostFocusNg: lostFocus","refreshingNg: refreshing","refreshedNg: refreshed","invalidInputNg: invalidInput","valueChangedNg: valueChanged","valueChangePC: valueChange"],providers:[{provide:forms_1.NG_VALUE_ACCESSOR,useFactory:wijmo_angular2_directiveBase_1.WjValueAccessorFactory,multi:!0,deps:["WjComponent"]}]};exports.wjRadialGaugeMeta=wjRadialGaugeMeta;let WjRadialGauge=WjRadialGauge_1=class WjRadialGauge extends wjcGauge.RadialGauge{constructor(e,t,a){super(wijmo_angular2_directiveBase_1.WjDirectiveBehavior.getHostElement(e,t));this.isInitialized=!1;this.wjModelProperty="value";this._wjBehaviour=wijmo_angular2_directiveBase_1.WjDirectiveBehavior.attach(this,e,t,a);this.created()}created(){}ngOnInit(){this._wjBehaviour.ngOnInit()}ngAfterViewInit(){this._wjBehaviour.ngAfterViewInit()}ngOnDestroy(){this._wjBehaviour.ngOnDestroy()}addEventListener(e,t,a,r=!1){let i=wijmo_angular2_directiveBase_1.WjDirectiveBehavior,n=i.getZone(this);n&&i.outsideZoneEvents[t]?n.runOutsideAngular(()=>{super.addEventListener(e,t,a,r)}):super.addEventListener(e,t,a,r)}};WjRadialGauge.meta={outputs:wjRadialGaugeMeta.outputs,changeEvents:{valueChanged:["value"]}};WjRadialGauge=WjRadialGauge_1=__decorate([core_1.Component({selector:wjRadialGaugeMeta.selector,template:wjRadialGaugeMeta.template,inputs:wjRadialGaugeMeta.inputs,outputs:wjRadialGaugeMeta.outputs,providers:[{provide:"WjComponent",useExisting:core_1.forwardRef(()=>WjRadialGauge_1)},...wjRadialGaugeMeta.providers]}),__param(0,core_1.Inject(core_1.ElementRef)),__param(1,core_1.Inject(core_1.Injector)),__param(2,core_1.Inject("WjComponent")),__param(2,core_1.SkipSelf()),__param(2,core_1.Optional())],WjRadialGauge);exports.WjRadialGauge=WjRadialGauge;var wjRangeMeta={selector:"wj-range",template:"",inputs:["wjProperty","color","min","max","name","thickness"],outputs:["initialized"],providers:[]};exports.wjRangeMeta=wjRangeMeta;let WjRange=WjRange_1=class WjRange extends wjcGauge.Range{constructor(e,t,a){super();this.isInitialized=!1;this.wjProperty="ranges";this._wjBehaviour=wijmo_angular2_directiveBase_1.WjDirectiveBehavior.attach(this,e,t,a);this.created()}created(){}ngOnInit(){this._wjBehaviour.ngOnInit()}ngAfterViewInit(){this._wjBehaviour.ngAfterViewInit()}ngOnDestroy(){this._wjBehaviour.ngOnDestroy()}};WjRange.meta={outputs:wjRangeMeta.outputs};WjRange=WjRange_1=__decorate([core_1.Component({selector:wjRangeMeta.selector,template:wjRangeMeta.template,inputs:wjRangeMeta.inputs,outputs:wjRangeMeta.outputs,providers:[{provide:"WjComponent",useExisting:core_1.forwardRef(()=>WjRange_1)},...wjRangeMeta.providers]}),__param(0,core_1.Inject(core_1.ElementRef)),__param(1,core_1.Inject(core_1.Injector)),__param(2,core_1.Inject("WjComponent")),__param(2,core_1.SkipSelf()),__param(2,core_1.Optional())],WjRange);exports.WjRange=WjRange;let moduleExports=[WjLinearGauge,WjBulletGraph,WjRadialGauge,WjRange],WjGaugeModule=class WjGaugeModule{};WjGaugeModule=__decorate([core_1.NgModule({imports:[common_1.CommonModule],declarations:[...moduleExports],exports:[...moduleExports]})],WjGaugeModule);exports.WjGaugeModule=WjGaugeModule;