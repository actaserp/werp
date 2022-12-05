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

"use strict";var __importStar=this&&this.__importStar||function(e){if(e&&e.__esModule)return e;var i={};if(null!=e)for(var o in e)Object.hasOwnProperty.call(e,o)&&(i[o]=e[o]);i.default=e;return i};Object.defineProperty(exports,"__esModule",{value:!0});var tooltip,wijmo_vue2_base_1=require("wijmo/wijmo.vue2.base"),wjcCore=__importStar(require("wijmo/wijmo")),WjIncludeDefinition={render:function(e){return wijmo_vue2_base_1.VueApi.isV3Plus?wijmo_vue2_base_1.VueApi.h("div"):e("div")},props:["src"],mounted:function(){var e=this;wjcCore.httpRequest(this.src,{success:function(i){e.$el.innerHTML=i.response}})}},WjIncludeTag="wj-include";exports.WjInclude=wijmo_vue2_base_1.VueApi.isV3Plus?WjIncludeDefinition:wijmo_vue2_base_1.VueApi.component(WjIncludeTag,WjIncludeDefinition);function registerV3WjInclude(e){e.component(WjIncludeTag,exports.WjInclude)}exports.wjFormat=function(e,i){return wjcCore.Globalize.format(e,i)};exports.WjFormat=wijmo_vue2_base_1.VueApi.isV3Plus?null:wijmo_vue2_base_1.VueApi.filter("wj-format",(function(e,i){return exports.wjFormat(e,i)}));function registerV3WjFormat(e){}var tooltipDirectiveDefinition=function(e,i){tooltip||(tooltip=new wjcCore.Tooltip);if(i.oldValue!==i.value){var o=i.value;wjcCore.isObject(o)?tooltip.setTooltip(e,o.tooltip,wjcCore.asEnum(o.position,wjcCore.PopupPosition)):tooltip.setTooltip(e,o)}},WjTooltipTag="wjTooltip";exports.WjTooltip=wijmo_vue2_base_1.VueApi.isV3Plus?tooltipDirectiveDefinition:wijmo_vue2_base_1.VueApi.directive(WjTooltipTag,tooltipDirectiveDefinition);function registerV3WjTooltip(e){e.directive(WjTooltipTag,exports.WjTooltip)}function registerCore(e){if(wijmo_vue2_base_1.VueApi.isV3Plus){registerV3WjInclude(e);registerV3WjFormat(e);registerV3WjTooltip(e)}}exports.registerCore=registerCore;