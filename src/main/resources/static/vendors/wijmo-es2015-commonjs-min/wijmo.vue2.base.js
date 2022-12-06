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

"use strict";var __importStar=this&&this.__importStar||function(e){if(e&&e.__esModule)return e;var t={};if(null!=e)for(var i in e)Object.hasOwnProperty.call(e,i)&&(t[i]=e[i]);t.default=e;return t};Object.defineProperty(exports,"__esModule",{value:!0});const wijmo_1=require("wijmo/wijmo"),VueModule=__importStar(require("vue"));var Vue=VueModule.default||VueModule;exports.VueApi=Vue.version&&"3"===Vue.version[0]?{isV3Plus:!0,modelValueProp:"modelValue",extend:e=>e,h:Vue.h,render:Vue.render}:Vue;var WjVueBaseDefinition={beforeCreate:function(){let e=this.$options[WjComponentBehavior._behClassProp];e&&(this[WjComponentBehavior._behProp]=e._attach(this))},mounted:function(){this[WjComponentBehavior._behProp].lhMounted()}};WjVueBaseDefinition[exports.VueApi.isV3Plus?"unmounted":"destroyed"]=function(){this[WjComponentBehavior._behProp].lhDestroyed()};var WjVueBase=exports.VueApi.extend(WjVueBaseDefinition);class WjComponentBehavior{constructor(e){this._isMounted=!1;this._mountedCBs=[];this.component=e}static _attach(e){return new this(e)}static register(){let e={data:this.data,extends:WjVueBase,render:this.render,props:this._getProps(),model:this._getModel(),[WjComponentBehavior._behClassProp]:this};return exports.VueApi.isV3Plus?Object.assign({},e,{emits:this._getEmits()}):exports.VueApi.component(this.tag,e)}lhMounted(){if(this._isChild()){let e=this.component.$parent;if(e){this.parent=e[WjComponentBehavior._behProp];this.parent._mountedCB(()=>{this._prepareControl();this._initParent()})}}else this._prepareControl()}lhDestroyed(){this._siblingInsertedEH&&this._getElement().removeEventListener("DOMNodeInserted",this._siblingInsertedEH);let e=this.control;if(e)if(this._isChild()){let t=this._getParentProp();if(t){let i=this.parent.control[t];if(wijmo_1.isArray(i)){let t=i.indexOf(e);t>-1&&i.splice(t,1)}}}else e instanceof wijmo_1.Control&&e.dispose()}static _getProps(){let e=[];this.props&&(e=this.props);this.events&&(e=e.concat(this.events));this.changeEvents&&(e=e.concat(Object.keys(this.changeEvents)));exports.VueApi.isV3Plus&&this.modelProp&&e.push(exports.VueApi.modelValueProp);return e}static _getModel(){let e=this.modelProp;return e?{prop:e,event:"update:"+e}:null}static _getEmits(){if(!this.changeEvents)return[];let e=[];Object.keys(this.changeEvents).forEach(t=>this.changeEvents[t].forEach(t=>{e.indexOf(t)<0&&e.push(t)}));this.modelProp&&e.push(exports.VueApi.modelValueProp);return e.map(e=>`update:${e}`)}_createControl(){let e=this._isChild()?this._isParentInCtor()?this.parent.control:void 0:this._getElement();return new(this.constructor._getControlType())(e)}_initParent(){let e=this._getParentProp();if(e){let t=this.parent.control,i=t[e];if(wijmo_1.isArray(i)){let e=this._getSiblingIndex();(e<0||e>=i.length)&&(e=i.length);i.splice(e,0,this.control);this._siblingInsertedEH=this._siblingInserted.bind(this);this._getElement().addEventListener("DOMNodeInserted",this._siblingInsertedEH)}else t[e]=this.control}}_updateControl(e,t){this.control[e]=t}_prepareControl(){let e=this.control=this._createControl(),t=this._getElement(),i=this.constructor;this.component.control=e;if(!this._siblingId){null==i.siblingId&&(i.siblingId=++i._siblingDirId+"");this._siblingId=i.siblingId}t.setAttribute(i._typeSiblingIdAttr,this._siblingId);this._isMounted=!0;let o=this._mountedCBs;this._mountedCBs=[];for(let e of o)e();_initialize(this)}_isChild(){let e=this.constructor;return null!=e.parentProp||null!=e.parentInCtor}_isParentInCtor(){return!0===this.constructor.parentInCtor}_getParentProp(){return(exports.VueApi.isV3Plus?this.component.$props:this.component.$options.propsData).wjProperty||this.constructor.parentProp}_getSiblingIndex(){var e=this._getElement(),t=e.parentElement;if(!t)return-1;for(var i=t.childNodes,o=-1,n=this._siblingId,r=0;r<i.length;r++){var s=i[r];if(1==s.nodeType&&s.getAttribute(WjComponentBehavior._typeSiblingIdAttr)==n){++o;if(s===e)return o}}return-1}_siblingInserted(e){if(e.target===this._getElement()){var t=this._getSiblingIndex(),i=this.control,o=this.parent.control[this._getParentProp()],n=o.indexOf(i);if(t>=0&&n>=0&&t!==n){o.splice(n,1);t=Math.min(t,o.length);o.splice(t,0,i)}}}_getElement(){return this.component.$el}static _getControlType(){return this.classCtor()}_mountedCB(e){this._isMounted?e():this._mountedCBs.push(e)}}WjComponentBehavior.render=function(e){const t=this.$slots.default;return exports.VueApi.isV3Plus?exports.VueApi.h("div",{},[t&&t()]):e("div",[t])};WjComponentBehavior._typeSiblingIdAttr="_wjSiblingId";WjComponentBehavior._behClassProp="_wjBehCl";WjComponentBehavior._behProp="__wjBeh";WjComponentBehavior._propIdxMapProp="__propInitIdx";WjComponentBehavior._siblingDirId=0;exports.WjComponentBehavior=WjComponentBehavior;function _initialize(e){let t=e.component,i=e.control,o=e.constructor,n=o[WjComponentBehavior._propIdxMapProp];if(!n){n=o[WjComponentBehavior._propIdxMapProp]={};let e=o.props;if(e)for(let t=0;t<e.length;t++)n[e[t]]=t}var r=[],s=[],p=[],l=o.changeEvents||{};const h=exports.VueApi.isV3Plus?t.$props:t.$options.propsData,a=o.modelProp;for(var u in h)null!=n[u]?r.push(u):l[u]?p.push(u):s.push(u);exports.VueApi.isV3Plus&&a&&h.hasOwnProperty(exports.VueApi.modelValueProp)&&!h.hasOwnProperty(a)&&r.push(a);r.sort((e,t)=>n[e]-n[t]);t[WjComponentBehavior._behProp].constructor.extraProps;function _subscribeEvents(e){e.forEach(e=>{"initialized"!==e&&e.indexOf(".")<0&&wijmo_1.isFunction(t[e])&&i[e].addHandler(t[e],i)})}_subscribeEvents(s);r.forEach(e=>{if(exports.VueApi.isV3Plus){const i=exports.VueApi.modelValueProp;if(wijmo_1.isUndefined(t[e])){if(e===a&&!wijmo_1.isUndefined(t[i])){t[WjComponentBehavior._behProp]._updateControl(e,t[i]);t.$watch(i,_updateControl.bind({cmp:t,prop:a}))}}else t[WjComponentBehavior._behProp]._updateControl(e,t[e]);t.$watch(e,_updateControl.bind({cmp:t,prop:e}))}else{wijmo_1.isUndefined(t[e])||t[WjComponentBehavior._behProp]._updateControl(e,t[e]);t.$watch(e,_updateControl.bind({cmp:t,prop:e}))}});function _updateControl(e){this.cmp[WjComponentBehavior._behProp]._updateControl(this.prop,e)}!function _updateStyleProp(){var e=t.$el,o={};if("style"in i&&e.style.cssText.length){e.style.cssText.split(";").forEach(e=>{var t=e.split(":");2==t.length&&(o[t[0].trim()]=t[1].trim())});i.style=o}}();_subscribeEvents(p);if(l){let e=Object.keys(l);for(let o of e)_subscribeChangeEvents(o,l[o],i,t)}function _subscribeChangeEvents(e,t,i,o){if(t){let n=i[e];n instanceof wijmo_1.Event&&n.addHandler((e,i)=>{for(let i of t){o.$emit("update:"+i,e[i]);if(exports.VueApi.isV3Plus&&i===a&&wijmo_1.isUndefined(o[i])){const t=exports.VueApi.modelValueProp;wijmo_1.isUndefined(o[t])||o.$emit(`update:${t}`,e[i])}}},i)}}wijmo_1.isFunction(t.initialized)&&t.initialized(i);return i}exports._initialize=_initialize;