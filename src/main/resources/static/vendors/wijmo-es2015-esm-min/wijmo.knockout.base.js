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

import{ControlMetaFactory,EventDescBase,ComplexPropDescBase,PropDescBase}from"wijmo/wijmo.meta";import*as mKo from"knockout";export class MetaFactory extends ControlMetaFactory{static CreateProp(t,e,r,i,n,a){return new PropDesc(t,e,r,i,n,a)}static CreateEvent(t,e){return new EventDesc(t,e)}static CreateComplexProp(t,e,r){return new ComplexPropDesc(t,e,r)}static findProp(t,e){return ControlMetaFactory.findProp(t,e)}static findEvent(t,e){return ControlMetaFactory.findEvent(t,e)}static findComplexProp(t,e){return ControlMetaFactory.findComplexProp(t,e)}}export class PropDesc extends PropDescBase{}export class EventDesc extends EventDescBase{}export class ComplexPropDesc extends ComplexPropDescBase{}var wjKo=mKo;export class WjBinding{constructor(){this.init=function(t,e,r,i,n){this.ensureMetaData();return this._initImpl(t,e,r,i,n)}.bind(this);this.update=function(t,e,r,i,n){this._updateImpl(t,e,r,i,n)}.bind(this);this._updateImpl=function(t,e,r,i,n){t[WjBinding._wjContextProp].update(t,e,r,i,n)}}ensureMetaData(){if(!this._metaData){this._metaData=MetaFactory.getMetaData(this._getMetaDataId());this._initialize();this._metaData.prepare()}}_initialize(){}_getControlConstructor(){return null}_getMetaDataId(){return this._getControlConstructor()}_createControl(t){return new(this._getControlConstructor())(t)}_createWijmoContext(){return new WjContext(this)}_isChild(){return this._isParentInitializer()||this._isParentReferencer()}_isParentInitializer(){return null!=this._metaData.parentProperty}_isParentReferencer(){return null!=this._metaData.parentReferenceProperty}_initImpl(t,e,r,i,n){var a=this._createWijmoContext();t[WjBinding._wjContextProp]=a;a.element=t;this._isChild()&&(a.parentWjContext=t.parentElement[WjBinding._wjContextProp]);a.valueAccessor=e;a.allBindings=r;a.viewModel=i;a.bindingContext=n;return a.init(t,e,r,i,n)}}WjBinding._wjContextProp="__wjKoContext";WjBinding._parPropAttr="wjProperty";WjBinding._controlPropAttr="control";WjBinding._initPropAttr="isInitialized";WjBinding._initEventAttr="initialized";export class WjContext{constructor(t){this._isInitialized=!1;this._isUpdatingControl=!1;this._isSourceDirty=!1;this._oldSourceValues={};this.wjBinding=t}init(t,e,r,i,n){var a=e(),o=(this.wjBinding._metaData.props,this.wjBinding._metaData.events);if(this._isChild()){var s=a[WjBinding._parPropAttr],p=this.wjBinding._metaData,l=s&&wjKo.unwrap(s)||p.parentProperty;this._parentPropDesc=MetaFactory.findComplexProp(l,this.parentWjContext.wjBinding._metaData.complexProps)||new ComplexPropDesc(l,p.isParentPropertyArray,p.ownsObject)}this._initControl();this._safeUpdateSrcAttr(WjBinding._controlPropAttr,this.control);wjKo.applyBindingsToDescendants(n,t);this._childrenInitialized();for(var c in o)this._addEventHandler(o[c]);this._updateControl(e);this._safeNotifySrcAttr(WjBinding._controlPropAttr);this._updateSource();this._isInitialized=!0;this._safeUpdateSrcAttr(WjBinding._initPropAttr,!0);var d=a[WjBinding._initEventAttr];d&&wjKo.unwrap(d)(this.bindingContext.$data,this.control,void 0);return{controlsDescendantBindings:!0}}update(t,e,r,i,n){this.valueAccessor=e;this._updateControl(e)}_createControl(){return this.wjBinding._createControl(this._parentInCtor()?this.parentWjContext.control:this.element)}_initControl(){if(this._isChild()){this.element.style.display="none";var t=this._getParentProp(),e=this.parentWjContext.control;if(this._useParentObj())this.control=e[t];else{var r=this.control=this._createControl();this._isParentInitializer()&&(this._isParentArray()?e[t].push(r):e[t]=r);this._isParentReferencer()&&!this._parentInCtor()&&(r[this._getParentReferenceProperty()]=e)}}else this.control=this._createControl()}_childrenInitialized(){}_addEventHandler(t){this.control[t.eventName].addHandler((e,r)=>{this._isInitialized&&this._updateSource();var i=this.valueAccessor()[t.eventName];i&&wjKo.unwrap(i)(this.bindingContext.$data,e,r)},this)}_updateSource(){WjContext._isUpdatingSource=!0;try{var t=this.wjBinding._metaData.props;for(var e in t){var r=t[e],i=r.propertyName;r.shouldUpdateSource&&r.isNativeControlProperty&&this._safeUpdateSrcAttr(i,this.control[i])}}finally{WjContext._isUpdatingSource=!1;for(;WjContext._pendingSourceUpdates.length>0;){WjContext._pendingSourceUpdates.shift()._updateControl()}}}_updateControl(t=this.valueAccessor){var e=t(),r=this.wjBinding._metaData.props;if(WjContext._isUpdatingSource){WjContext._pendingSourceUpdates.indexOf(this)<0&&WjContext._pendingSourceUpdates.push(this);for(var i in r)wjKo.unwrap(e[r[i].propertyName])}else try{var n=[],a=[];for(var i in r){var o=e[l=(s=r[i]).propertyName];if(void 0!==o){if((p=wjKo.unwrap(o))!==this._oldSourceValues[l]||s.changeEvent&&p!==this.control[l]){this._oldSourceValues[l]=p;n.push(p);a.push(s)}}}for(var i in n){var s=a[i],p=wjKo.unwrap(e[s.propertyName]),l=s.propertyName;if(void 0!==p||this._isInitialized){var c=this._castValueToType(p,s);s.updateControl&&s.updateControl(this,s,this.control,p,c)||!s.isNativeControlProperty||this.control[l]!=c&&(this.control[l]=c)}}}finally{}}_castValueToType(t,e){return e.castValueToType(t)}_safeUpdateSrcAttr(t,e){var r=this.valueAccessor()[t];if(wjKo.isWritableObservable(r)){e!=wjKo.unwrap(r)&&r(e)}}_safeNotifySrcAttr(t){var e=this.valueAccessor()[t];wjKo.isWritableObservable(e)&&e.valueHasMutated&&e.valueHasMutated()}_isChild(){return this.wjBinding._isChild()}_isParentInitializer(){return this.wjBinding._isParentInitializer()}_isParentReferencer(){return this.wjBinding._isParentReferencer()}_getParentProp(){return this._isParentInitializer()?this._parentPropDesc.propertyName:void 0}_getParentReferenceProperty(){return this.wjBinding._metaData.parentReferenceProperty}_useParentObj(){return!this._isParentReferencer()&&this._isParentInitializer()&&!this._parentPropDesc.isArray&&!this._parentPropDesc.ownsObject}_isParentArray(){return this._parentPropDesc.isArray}_parentInCtor(){return this._isParentReferencer()&&""==this._getParentReferenceProperty()}}WjContext._debugId=0;WjContext._isUpdatingSource=!1;WjContext._pendingSourceUpdates=[];export class WjTagsPreprocessor{static _getSpecialProps(){var t={},e=WjBinding;t[e._controlPropAttr]=!0;t[e._parPropAttr]=!0;return t}register(){this._foreignProc=wjKo.bindingProvider.instance.preprocessNode;wjKo.bindingProvider.instance.preprocessNode=this.preprocessNode.bind(this)}preprocessNode(t){var e=WjTagsPreprocessor._dataBindAttr;if(1!=t.nodeType||!this._isWjTag(t.tagName))return this._delegate(t);var r=MetaFactory.toCamelCase(t.tagName),i=wjKo.bindingHandlers[r];if(!i)return this._delegate(t);i.ensureMetaData();for(var n,a="",o=t.attributes,s=document.createElement("div"),p=0;p<o.length;p++){var l=o[p];if(l.name.toLowerCase()!=e){var c=MetaFactory.toCamelCase(l.name);if(this._isWjProp(c,i._metaData)){a&&(a+=",");a+=c+":"+l.value}else s.setAttribute(l.name,l.value)}else n=l}a=r+":{"+a+"}";n&&n.value&&n.value.trim()&&(a+=","+n.value);s.setAttribute(e,a);for(;t.firstChild;)s.appendChild(t.firstChild);t.parentNode.replaceChild(s,t);return[s]}_delegate(t){return this._foreignProc?this._foreignProc(t):void 0}_isWjTag(t){var e=WjTagsPreprocessor._wjTagPrefix;return t&&t.length>e.length&&t.substr(0,e.length).toLowerCase()===e}_isWjProp(t,e){return WjTagsPreprocessor._specialProps[t]||MetaFactory.findProp(t,e.props)||MetaFactory.findEvent(t,e.events)}}WjTagsPreprocessor._specialProps=WjTagsPreprocessor._getSpecialProps();WjTagsPreprocessor._dataBindAttr="data-bind";WjTagsPreprocessor._wjTagPrefix="wj-";window.wijmo.disableKnockoutTags||(new WjTagsPreprocessor).register();