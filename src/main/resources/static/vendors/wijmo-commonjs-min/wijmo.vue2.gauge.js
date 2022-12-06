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

"use strict";var __extends=this&&this.__extends||function(){var extendStatics=function(e,a){return(extendStatics=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,a){e.__proto__=a}||function(e,a){for(var r in a)a.hasOwnProperty(r)&&(e[r]=a[r])})(e,a)};return function(e,a){extendStatics(e,a);function __(){this.constructor=e}e.prototype=null===a?Object.create(a):(__.prototype=a.prototype,new __)}}(),__importStar=this&&this.__importStar||function(e){if(e&&e.__esModule)return e;var a={};if(null!=e)for(var r in e)Object.hasOwnProperty.call(e,r)&&(a[r]=e[r]);a.default=e;return a};Object.defineProperty(exports,"__esModule",{value:!0});var wijmo_vue2_base_1=require("wijmo/wijmo.vue2.base"),wjcGauge=__importStar(require("wijmo/wijmo.gauge")),WjLinearGaugeBehavior=function(e){__extends(WjLinearGaugeBehavior,e);function WjLinearGaugeBehavior(){return null!==e&&e.apply(this,arguments)||this}WjLinearGaugeBehavior.tag="wj-linear-gauge";WjLinearGaugeBehavior.props=["isDisabled","tabOrder","value","min","max","origin","isReadOnly","handleWheel","step","format","thickness","hasShadow","isAnimated","showText","showTicks","showTickText","showRanges","stackRanges","thumbSize","tickSpacing","getText","direction"];WjLinearGaugeBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput"];WjLinearGaugeBehavior.changeEvents={valueChanged:["value"]};WjLinearGaugeBehavior.classCtor=function(){return wjcGauge.LinearGauge};WjLinearGaugeBehavior.modelProp="value";return WjLinearGaugeBehavior}(wijmo_vue2_base_1.WjComponentBehavior);exports.WjLinearGauge=WjLinearGaugeBehavior.register();function registerV3WjLinearGauge(e){e.component(WjLinearGaugeBehavior.tag,exports.WjLinearGauge)}var WjBulletGraphBehavior=function(e){__extends(WjBulletGraphBehavior,e);function WjBulletGraphBehavior(){return null!==e&&e.apply(this,arguments)||this}WjBulletGraphBehavior.tag="wj-bullet-graph";WjBulletGraphBehavior.props=["isDisabled","tabOrder","value","min","max","origin","isReadOnly","handleWheel","step","format","thickness","hasShadow","isAnimated","showText","showTicks","showTickText","showRanges","stackRanges","thumbSize","tickSpacing","getText","direction","target","good","bad"];WjBulletGraphBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput"];WjBulletGraphBehavior.changeEvents={valueChanged:["value"]};WjBulletGraphBehavior.classCtor=function(){return wjcGauge.BulletGraph};WjBulletGraphBehavior.modelProp="value";return WjBulletGraphBehavior}(wijmo_vue2_base_1.WjComponentBehavior);exports.WjBulletGraph=WjBulletGraphBehavior.register();function registerV3WjBulletGraph(e){e.component(WjBulletGraphBehavior.tag,exports.WjBulletGraph)}var WjRadialGaugeBehavior=function(e){__extends(WjRadialGaugeBehavior,e);function WjRadialGaugeBehavior(){return null!==e&&e.apply(this,arguments)||this}WjRadialGaugeBehavior.tag="wj-radial-gauge";WjRadialGaugeBehavior.props=["isDisabled","tabOrder","value","min","max","origin","isReadOnly","handleWheel","step","format","thickness","hasShadow","isAnimated","showText","showTicks","showTickText","showRanges","stackRanges","thumbSize","tickSpacing","getText","autoScale","startAngle","sweepAngle","needleShape","needleLength","needleElement"];WjRadialGaugeBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput"];WjRadialGaugeBehavior.changeEvents={valueChanged:["value"]};WjRadialGaugeBehavior.classCtor=function(){return wjcGauge.RadialGauge};WjRadialGaugeBehavior.modelProp="value";return WjRadialGaugeBehavior}(wijmo_vue2_base_1.WjComponentBehavior);exports.WjRadialGauge=WjRadialGaugeBehavior.register();function registerV3WjRadialGauge(e){e.component(WjRadialGaugeBehavior.tag,exports.WjRadialGauge)}var WjRangeBehavior=function(e){__extends(WjRangeBehavior,e);function WjRangeBehavior(){return null!==e&&e.apply(this,arguments)||this}WjRangeBehavior.tag="wj-range";WjRangeBehavior.parentProp="ranges";WjRangeBehavior.props=["wjProperty","color","min","max","name","thickness"];WjRangeBehavior.events=["initialized"];WjRangeBehavior.classCtor=function(){return wjcGauge.Range};return WjRangeBehavior}(wijmo_vue2_base_1.WjComponentBehavior);exports.WjRange=WjRangeBehavior.register();function registerV3WjRange(e){e.component(WjRangeBehavior.tag,exports.WjRange)}function registerGauge(e){if(wijmo_vue2_base_1.VueApi.isV3Plus){registerV3WjLinearGauge(e);registerV3WjBulletGraph(e);registerV3WjRadialGauge(e);registerV3WjRange(e)}}exports.registerGauge=registerGauge;