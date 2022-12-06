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

"use strict";var __extends=this&&this.__extends||function(){var extendStatics=function(e,t){return(extendStatics=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var o in t)t.hasOwnProperty(o)&&(e[o]=t[o])})(e,t)};return function(e,t){extendStatics(e,t);function __(){this.constructor=e}e.prototype=null===t?Object.create(t):(__.prototype=t.prototype,new __)}}(),__importStar=this&&this.__importStar||function(e){if(e&&e.__esModule)return e;var t={};if(null!=e)for(var o in e)Object.hasOwnProperty.call(e,o)&&(t[o]=e[o]);t.default=e;return t};Object.defineProperty(exports,"__esModule",{value:!0});var wijmo_webcomponents_base_1=require("wijmo/wijmo.webcomponents.base");require("wijmo/wijmo.webcomponents.chart");var wjcOlap=__importStar(require("wijmo/wijmo.olap")),_wj_ns_exists_19=!0,WjcPivotGrid=function(e){__extends(WjcPivotGrid,e);function WjcPivotGrid(){var t=e.call(this,document.createElement("div"))||this;t._wjBehaviour=wijmo_webcomponents_base_1.WjComponentBehavior._attach(t);return t}Object.defineProperty(WjcPivotGrid,"observedAttributes",{get:function(){return wijmo_webcomponents_base_1.WjComponentBehavior.getProps(this)},enumerable:!0,configurable:!0});WjcPivotGrid.prototype.connectedCallback=function(){this._wjBehaviour.lhConnected()};WjcPivotGrid.prototype.attributeChangedCallback=function(e,t,o){this._wjBehaviour.lhAttributeChanged(e,t,o)};WjcPivotGrid.prototype.disconnectedCallback=function(){this._wjBehaviour.lhDisconnected()};WjcPivotGrid.prototype.addEventListener=function(){for(var t=[],o=0;o<arguments.length;o++)t[o]=arguments[o];"string"==typeof t[0]?HTMLElement.prototype.addEventListener.apply(this,t):e.prototype.addEventListener.apply(this,t)};return WjcPivotGrid}(wjcOlap.PivotGrid);exports.WjcPivotGrid=WjcPivotGrid;if(_wj_ns_exists_19){wijmo_webcomponents_base_1.WjComponentBehavior.register("",wjcOlap._GridContextMenu);wijmo_webcomponents_base_1.WjComponentBehavior.register("",wjcOlap.DetailDialog);wijmo_webcomponents_base_1.WjComponentBehavior.register("",wjcOlap.PivotFieldEditor);wijmo_webcomponents_base_1.WjComponentBehavior.register("",wjcOlap.PivotFilterEditor);wijmo_webcomponents_base_1.WjComponentBehavior.register("wjc-pivot-grid",WjcPivotGrid)}var WjcPivotChart=function(e){__extends(WjcPivotChart,e);function WjcPivotChart(){var t=e.call(this,document.createElement("div"))||this;t._wjBehaviour=wijmo_webcomponents_base_1.WjComponentBehavior._attach(t);return t}Object.defineProperty(WjcPivotChart,"observedAttributes",{get:function(){return wijmo_webcomponents_base_1.WjComponentBehavior.getProps(this)},enumerable:!0,configurable:!0});WjcPivotChart.prototype.connectedCallback=function(){this._wjBehaviour.lhConnected()};WjcPivotChart.prototype.attributeChangedCallback=function(e,t,o){this._wjBehaviour.lhAttributeChanged(e,t,o)};WjcPivotChart.prototype.disconnectedCallback=function(){this._wjBehaviour.lhDisconnected()};WjcPivotChart.prototype.addEventListener=function(){for(var t=[],o=0;o<arguments.length;o++)t[o]=arguments[o];"string"==typeof t[0]?HTMLElement.prototype.addEventListener.apply(this,t):e.prototype.addEventListener.apply(this,t)};return WjcPivotChart}(wjcOlap.PivotChart);exports.WjcPivotChart=WjcPivotChart;_wj_ns_exists_19&&wijmo_webcomponents_base_1.WjComponentBehavior.register("wjc-pivot-chart",WjcPivotChart);var WjcPivotPanel=function(e){__extends(WjcPivotPanel,e);function WjcPivotPanel(){var t=e.call(this,document.createElement("div"))||this;t._wjBehaviour=wijmo_webcomponents_base_1.WjComponentBehavior._attach(t);return t}Object.defineProperty(WjcPivotPanel,"observedAttributes",{get:function(){return wijmo_webcomponents_base_1.WjComponentBehavior.getProps(this)},enumerable:!0,configurable:!0});WjcPivotPanel.prototype.connectedCallback=function(){this._wjBehaviour.lhConnected()};WjcPivotPanel.prototype.attributeChangedCallback=function(e,t,o){this._wjBehaviour.lhAttributeChanged(e,t,o)};WjcPivotPanel.prototype.disconnectedCallback=function(){this._wjBehaviour.lhDisconnected()};WjcPivotPanel.prototype.addEventListener=function(){for(var t=[],o=0;o<arguments.length;o++)t[o]=arguments[o];"string"==typeof t[0]?HTMLElement.prototype.addEventListener.apply(this,t):e.prototype.addEventListener.apply(this,t)};return WjcPivotPanel}(wjcOlap.PivotPanel);exports.WjcPivotPanel=WjcPivotPanel;if(_wj_ns_exists_19){wijmo_webcomponents_base_1.WjComponentBehavior.register("",wjcOlap._ListContextMenu);wijmo_webcomponents_base_1.WjComponentBehavior.register("wjc-pivot-panel",WjcPivotPanel)}var WjcSlicer=function(e){__extends(WjcSlicer,e);function WjcSlicer(){var t=e.call(this,document.createElement("div"))||this;t._wjBehaviour=wijmo_webcomponents_base_1.WjComponentBehavior._attach(t);return t}Object.defineProperty(WjcSlicer,"observedAttributes",{get:function(){return wijmo_webcomponents_base_1.WjComponentBehavior.getProps(this)},enumerable:!0,configurable:!0});WjcSlicer.prototype.connectedCallback=function(){this._wjBehaviour.lhConnected()};WjcSlicer.prototype.attributeChangedCallback=function(e,t,o){this._wjBehaviour.lhAttributeChanged(e,t,o)};WjcSlicer.prototype.disconnectedCallback=function(){this._wjBehaviour.lhDisconnected()};WjcSlicer.prototype.addEventListener=function(){for(var t=[],o=0;o<arguments.length;o++)t[o]=arguments[o];"string"==typeof t[0]?HTMLElement.prototype.addEventListener.apply(this,t):e.prototype.addEventListener.apply(this,t)};return WjcSlicer}(wjcOlap.Slicer);exports.WjcSlicer=WjcSlicer;_wj_ns_exists_19&&wijmo_webcomponents_base_1.WjComponentBehavior.register("wjc-slicer",WjcSlicer);