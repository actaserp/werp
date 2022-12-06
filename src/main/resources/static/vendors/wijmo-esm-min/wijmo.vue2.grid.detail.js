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

var __extends=this&&this.__extends||function(){var extendStatics=function(e,t){return(extendStatics=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var i in t)t.hasOwnProperty(i)&&(e[i]=t[i])})(e,t)};return function(e,t){extendStatics(e,t);function __(){this.constructor=e}e.prototype=null===t?Object.create(t):(__.prototype=t.prototype,new __)}}();import{VueApi,WjComponentBehavior}from"wijmo/wijmo.vue2.base";import*as wjcGridDetail from"wijmo/wijmo.grid.detail";var WjFlexGridDetailBehavior=function(e){__extends(WjFlexGridDetailBehavior,e);function WjFlexGridDetailBehavior(){var t=null!==e&&e.apply(this,arguments)||this;t._openedComponents=[];return t}WjFlexGridDetailBehavior.render=function(e){return VueApi.isV3Plus?VueApi.h("div"):e("div")};WjFlexGridDetailBehavior.prototype._createControl=function(){var t=this,i=e.prototype._createControl.call(this);i.createDetailCell=function(e){if(VueApi.isV3Plus){var i=VueApi.h,r=t.component.$slots.default,o={row:e,item:e.dataItem,provider:t.control},n=i({parent:t.component,render:function(){return i("div",{},r&&r(o))}}),a=document.createElement("div");VueApi.render(n,a);t._openedComponents.push({$destroy:function(){VueApi.render(null,a)}});return n.el}var l=new(VueApi.extend({data:function(){return{childVN:null}},render:function(e){return e("div",[this.childVN])}}))({parent:t.component});l.childVN=t.component.$scopedSlots.default({row:e,item:e.dataItem,provider:t.control});l.$mount();t._openedComponents.push(l);return l.$el};i.disposeDetailCell=function(e){var i=e.detail,r=t._openedComponents;if(i)for(var o=0;o<r.length;o++)if(i===r[o].$el){r[o].$destroy();r.splice(o,1);break}};return i};WjFlexGridDetailBehavior.tag="wj-flex-grid-detail";WjFlexGridDetailBehavior.parentInCtor=!0;WjFlexGridDetailBehavior.props=["maxHeight","keyActionEnter","detailVisibilityMode","rowHasDetail","isAnimated"];WjFlexGridDetailBehavior.events=["initialized"];WjFlexGridDetailBehavior.classCtor=function(){return wjcGridDetail.FlexGridDetailProvider};return WjFlexGridDetailBehavior}(WjComponentBehavior);export var WjFlexGridDetail=WjFlexGridDetailBehavior.register();function registerV3WjFlexGridDetail(e){e.component(WjFlexGridDetailBehavior.tag,WjFlexGridDetail)}export function registerGridDetail(e){VueApi.isV3Plus&&registerV3WjFlexGridDetail(e)}