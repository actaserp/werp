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

"use strict";var __importStar=this&&this.__importStar||function(e){if(e&&e.__esModule)return e;var t={};if(null!=e)for(var a in e)Object.hasOwnProperty.call(e,a)&&(t[a]=e[a]);t.default=e;return t};Object.defineProperty(exports,"__esModule",{value:!0});const wijmo_webcomponents_base_1=require("wijmo/wijmo.webcomponents.base"),wjcGauge=__importStar(require("wijmo/wijmo.gauge"));let _wj_ns_exists_9=!0;class WjcLinearGauge extends wjcGauge.LinearGauge{constructor(){super(document.createElement("div"));this._wjBehaviour=wijmo_webcomponents_base_1.WjComponentBehavior._attach(this)}static get observedAttributes(){return wijmo_webcomponents_base_1.WjComponentBehavior.getProps(this)}connectedCallback(){this._wjBehaviour.lhConnected()}attributeChangedCallback(e,t,a){this._wjBehaviour.lhAttributeChanged(e,t,a)}disconnectedCallback(){this._wjBehaviour.lhDisconnected()}addEventListener(...e){"string"==typeof e[0]?HTMLElement.prototype.addEventListener.apply(this,e):super.addEventListener.apply(this,e)}}exports.WjcLinearGauge=WjcLinearGauge;_wj_ns_exists_9&&wijmo_webcomponents_base_1.WjComponentBehavior.register("wjc-linear-gauge",WjcLinearGauge);class WjcBulletGraph extends wjcGauge.BulletGraph{constructor(){super(document.createElement("div"));this._wjBehaviour=wijmo_webcomponents_base_1.WjComponentBehavior._attach(this)}static get observedAttributes(){return wijmo_webcomponents_base_1.WjComponentBehavior.getProps(this)}connectedCallback(){this._wjBehaviour.lhConnected()}attributeChangedCallback(e,t,a){this._wjBehaviour.lhAttributeChanged(e,t,a)}disconnectedCallback(){this._wjBehaviour.lhDisconnected()}addEventListener(...e){"string"==typeof e[0]?HTMLElement.prototype.addEventListener.apply(this,e):super.addEventListener.apply(this,e)}}exports.WjcBulletGraph=WjcBulletGraph;_wj_ns_exists_9&&wijmo_webcomponents_base_1.WjComponentBehavior.register("wjc-bullet-graph",WjcBulletGraph);class WjcRadialGauge extends wjcGauge.RadialGauge{constructor(){super(document.createElement("div"));this._wjBehaviour=wijmo_webcomponents_base_1.WjComponentBehavior._attach(this)}static get observedAttributes(){return wijmo_webcomponents_base_1.WjComponentBehavior.getProps(this)}connectedCallback(){this._wjBehaviour.lhConnected()}attributeChangedCallback(e,t,a){this._wjBehaviour.lhAttributeChanged(e,t,a)}disconnectedCallback(){this._wjBehaviour.lhDisconnected()}addEventListener(...e){"string"==typeof e[0]?HTMLElement.prototype.addEventListener.apply(this,e):super.addEventListener.apply(this,e)}}exports.WjcRadialGauge=WjcRadialGauge;_wj_ns_exists_9&&wijmo_webcomponents_base_1.WjComponentBehavior.register("wjc-radial-gauge",WjcRadialGauge);class WjcRange extends HTMLElement{constructor(){super();this._wjBehaviour=wijmo_webcomponents_base_1.WjComponentBehavior._attach(this)}static get observedAttributes(){return wijmo_webcomponents_base_1.WjComponentBehavior.getProps(this)}connectedCallback(){this._wjBehaviour.lhConnected()}attributeChangedCallback(e,t,a){this._wjBehaviour.lhAttributeChanged(e,t,a)}disconnectedCallback(){this._wjBehaviour.lhDisconnected()}}WjcRange.wrappedClass=()=>wjcGauge.Range;WjcRange.parentProp="ranges";exports.WjcRange=WjcRange;_wj_ns_exists_9&&wijmo_webcomponents_base_1.WjComponentBehavior.register("wjc-range",WjcRange);