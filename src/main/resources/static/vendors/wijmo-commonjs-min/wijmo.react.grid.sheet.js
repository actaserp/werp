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

"use strict";var __extends=this&&this.__extends||function(){var extendStatics=function(e,t){return(extendStatics=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var r in t)t.hasOwnProperty(r)&&(e[r]=t[r])})(e,t)};return function(e,t){extendStatics(e,t);function __(){this.constructor=e}e.prototype=null===t?Object.create(t):(__.prototype=t.prototype,new __)}}(),__importStar=this&&this.__importStar||function(e){if(e&&e.__esModule)return e;var t={};if(null!=e)for(var r in e)Object.hasOwnProperty.call(e,r)&&(t[r]=e[r]);t.default=e;return t};Object.defineProperty(exports,"__esModule",{value:!0});var wijmo_react_base_1=require("wijmo/wijmo.react.base"),wjcGridSheet=__importStar(require("wijmo/wijmo.grid.sheet")),FlexSheet=function(e){__extends(FlexSheet,e);function FlexSheet(t){return e.call(this,t,wjcGridSheet.FlexSheet,{objectProps:["childItemsPath","mergeManager","itemsSource","virtualizationThreshold","columnGroups"]})||this}return FlexSheet}(wijmo_react_base_1.ComponentBase);exports.FlexSheet=FlexSheet;var Sheet=function(e){__extends(Sheet,e);function Sheet(t){var r=e.call(this,t,wjcGridSheet.Sheet,{objectProps:["itemsSource"]})||this;r._parentProp="sheets";r._parentInCtor=!0;return r}return Sheet}(wijmo_react_base_1.ComponentBase);exports.Sheet=Sheet;