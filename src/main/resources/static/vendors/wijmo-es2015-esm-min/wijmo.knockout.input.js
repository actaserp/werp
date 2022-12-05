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

import{WjBinding,WjContext,MetaFactory}from"wijmo/wijmo.knockout.base";import{Control,ObservableArray,getElement,closest,CancelEventArgs,showPopup,CollectionView}from"wijmo/wijmo";import*as mKo from"knockout";import*as wjcInput from"wijmo/wijmo.input";var wjKo=mKo;export class WjDropDownBinding extends WjBinding{_getControlConstructor(){return wjcInput.DropDown}}export class wjComboBox extends WjDropDownBinding{_getControlConstructor(){return wjcInput.ComboBox}}export class wjAutoComplete extends wjComboBox{_getControlConstructor(){return wjcInput.AutoComplete}}export class wjCalendar extends WjBinding{_getControlConstructor(){return wjcInput.Calendar}}export class wjColorPicker extends WjBinding{_getControlConstructor(){return wjcInput.ColorPicker}}export class wjListBox extends WjBinding{_getControlConstructor(){return wjcInput.ListBox}}export class wjMenu extends wjComboBox{_getControlConstructor(){return wjcInput.Menu}_createWijmoContext(){return new WjMenuContext(this)}_initialize(){super._initialize();MetaFactory.findProp("value",this._metaData.props).updateControl=this._updateControlValue}_updateControlValue(t,e,n,o,r){if(null!=r){n.selectedValue=r;t._updateHeader()}return!0}}export class WjMenuContext extends WjContext{_initControl(){super._initControl();var t=this.control;t.displayMemberPath="header";t.commandPath="cmd";t.commandParameterPath="cmdParam";t.selectedValuePath="value";t.itemsSource=new ObservableArray;t.itemClicked.addHandler(()=>{this._safeUpdateSrcAttr("value",t.selectedValue);this._updateHeader()})}_childrenInitialized(){super._childrenInitialized();this.control.selectedIndex=0;this._updateHeader()}_updateHeader(){var t=this.control,e=this.valueAccessor(),n=wjKo.unwrap(e.header);if(void 0!==wjKo.unwrap(e.value)&&t.selectedItem&&t.displayMemberPath){var o=t.selectedItem[t.displayMemberPath];null!=o&&(n+=": <b>"+o+"</b>")}t.header=n}}export class wjMenuItem extends WjBinding{_getMetaDataId(){return"MenuItem"}_createWijmoContext(){return new WjMenuItemContext(this)}_initialize(){super._initialize();var t=this._metaData;t.parentProperty="itemsSource";t.isParentPropertyArray=!0}}export class WjMenuItemContext extends WjContext{_createControl(){return{header:this.element.innerHTML,cmd:null,cmdParam:null,value:null}}}export class wjMenuSeparator extends WjBinding{_getMetaDataId(){return"MenuSeparator"}_initialize(){super._initialize();var t=this._metaData;t.parentProperty="itemsSource";t.isParentPropertyArray=!0}_createControl(t){return{header:'<div class="wj-state-disabled" style="width:100%;height:1px;background-color:lightgray"></div>'}}}export class wjContextMenu extends WjBinding{_getMetaDataId(){return"ContextMenu"}_createControl(t){return null}_createWijmoContext(){return new WjContextMenuContext(this)}}export class WjContextMenuContext extends WjContext{_initControl(){super._initControl();var t=this.valueAccessor(),e=getElement(t.id);this.element.addEventListener("contextmenu",(function(t){var n=Control.getControl(e),o=n.dropDown;if(n&&o&&!closest(t.target,"[disabled]")){t.preventDefault();n.owner=this.element;n.selectedIndex=-1;if(n.onIsDroppedDownChanging(new CancelEventArgs)){showPopup(o,t);n.onIsDroppedDownChanged();o.focus()}}}))}}export class wjInputDate extends WjDropDownBinding{_getControlConstructor(){return wjcInput.InputDate}}export class wjInputDateTime extends WjBinding{_getControlConstructor(){return wjcInput.InputDateTime}}export class wjInputNumber extends WjBinding{_getControlConstructor(){return wjcInput.InputNumber}}export class wjInputMask extends WjBinding{_getControlConstructor(){return wjcInput.InputMask}}export class wjInputTime extends wjComboBox{_getControlConstructor(){return wjcInput.InputTime}}export class wjInputColor extends WjDropDownBinding{_getControlConstructor(){return wjcInput.InputColor}}export class WjCollectionViewBaseBinding extends WjBinding{_createControl(t){return null}_createWijmoContext(){return new WjCollectionViewContext(this)}_getTemplate(){return""}}export class WjCollectionViewContext extends WjContext{constructor(){super(...arguments);this._emptyCV=new CollectionView([])}init(t,e,n,o,r){t.innerHTML=this.wjBinding._getTemplate();var a=wjKo.unwrap(e().cv)||this._emptyCV;this._subscribeToCV(a);this._localVM={cv:wjKo.observable(a)};var i=r.createChildContext(this._localVM);wjKo.applyBindingsToDescendants(i,t);return{controlsDescendantBindings:!0}}update(t,e,n,o,r){var a=wjKo.unwrap(e().cv)||this._emptyCV,i=wjKo.unwrap(this._localVM.cv);if(a!==i){this._unsubscribeFromCV(i);this._subscribeToCV(a);this._localVM.cv(a)}}_subscribeToCV(t){if(t){t.collectionChanged.addHandler(this._forceBindingsUpdate,this);t.currentChanged.addHandler(this._forceBindingsUpdate,this);t.pageChanged.addHandler(this._forceBindingsUpdate,this)}}_unsubscribeFromCV(t){if(t){t.collectionChanged.removeHandler(this._forceBindingsUpdate,this);t.currentChanged.removeHandler(this._forceBindingsUpdate,this);t.pageChanged.removeHandler(this._forceBindingsUpdate,this)}}_forceBindingsUpdate(t,e){this._localVM.cv.valueHasMutated()}}export class wjCollectionViewPager extends WjCollectionViewBaseBinding{_getMetaDataId(){return"CollectionViewPager"}_getTemplate(){return'<div class="wj-control wj-content wj-pager">    <div class="wj-input-group">        <span class="wj-input-group-btn" >            <button class="wj-btn wj-btn-default" type="button"               data-bind="click: function () { cv().moveToFirstPage() },               disable: cv().pageIndex <= 0">                <span class="wj-glyph-left" style="margin-right: -4px;"></span>                <span class="wj-glyph-left"></span>            </button>        </span>        <span class="wj-input-group-btn" >           <button class="wj-btn wj-btn-default" type="button"               data-bind="click: function () { cv().moveToPreviousPage() },               disable: cv().pageIndex <= 0">                <span class="wj-glyph-left"></span>            </button>        </span>        <input type="text" class="wj-form-control" data-bind="            value: cv().pageIndex + 1 + \' / \' + cv().pageCount        " disabled />        <span class="wj-input-group-btn" >            <button class="wj-btn wj-btn-default" type="button"               data-bind="click: function () { cv().moveToNextPage() },               disable: cv().pageIndex >= cv().pageCount - 1">                <span class="wj-glyph-right"></span>            </button>        </span>        <span class="wj-input-group-btn" >            <button class="wj-btn wj-btn-default" type="button"               data-bind="click: function () { cv().moveToLastPage() },               disable: cv().pageIndex >= cv().pageCount - 1">                <span class="wj-glyph-right"></span>                <span class="wj-glyph-right" style="margin-left: -4px;"></span>            </button>        </span>    </div></div>'}}export class wjCollectionViewNavigator extends WjCollectionViewBaseBinding{_getMetaDataId(){return"CollectionViewNavigator"}_getTemplate(){return'<div class="wj-control wj-content wj-pager">    <div class="wj-input-group">        <span class="wj-input-group-btn" >            <button class="wj-btn wj-btn-default" type="button"               data-bind="click: function () { cv().moveCurrentToFirst() },               disable: cv().currentPosition <= 0">                <span class="wj-glyph-left" style="margin-right: -4px;"></span>                <span class="wj-glyph-left"></span>            </button>        </span>        <span class="wj-input-group-btn" >           <button class="wj-btn wj-btn-default" type="button"               data-bind="click: function () { cv().moveCurrentToPrevious() },               disable: cv().currentPosition <= 0">                <span class="wj-glyph-left"></span>            </button>        </span>        <input type="text" class="wj-form-control" data-bind="            value: cv().currentPosition + 1 + \' / \' + cv().itemCount        " disabled />        <span class="wj-input-group-btn" >            <button class="wj-btn wj-btn-default" type="button"               data-bind="click: function () { cv().moveCurrentToNext() },               disable: cv().currentPosition >= cv().itemCount - 1">                <span class="wj-glyph-right"></span>            </button>        </span>        <span class="wj-input-group-btn" >            <button class="wj-btn wj-btn-default" type="button"               data-bind="click: function () { cv().moveCurrentToLast() },               disable: cv().currentPosition >= cv().itemCount - 1">                <span class="wj-glyph-right"></span>                <span class="wj-glyph-right" style="margin-left: -4px;"></span>            </button>        </span>    </div></div>'}}export class wjMultiSelect extends wjComboBox{_getControlConstructor(){return wjcInput.MultiSelect}}export class wjMultiAutoComplete extends wjAutoComplete{_getControlConstructor(){return wjcInput.MultiAutoComplete}}export class wjPopup extends WjBinding{_getControlConstructor(){return wjcInput.Popup}_createWijmoContext(){return new WjPopupContext(this)}_initialize(){super._initialize();MetaFactory.findProp("owner",this._metaData.props).updateControl=function(t,e,n,o,r){n.owner=r;t._updateModal(r);return!0}}}export class WjPopupContext extends WjContext{_initControl(){super._initControl();this.control.removeOnHide=!1}_updateModal(t){var e=this.valueAccessor(),n=this.control;null==wjKo.unwrap(e.modal)&&(n.modal=!t)}}wjKo.bindingHandlers.wjComboBox=new wjComboBox;wjKo.bindingHandlers.wjAutoComplete=new wjAutoComplete;wjKo.bindingHandlers.wjCalendar=new wjCalendar;wjKo.bindingHandlers.wjColorPicker=new wjColorPicker;wjKo.bindingHandlers.wjListBox=new wjListBox;wjKo.bindingHandlers.wjMenu=new wjMenu;wjKo.bindingHandlers.wjMenuItem=new wjMenuItem;wjKo.bindingHandlers.wjMenuSeparator=new wjMenuSeparator;wjKo.bindingHandlers.wjContextMenu=new wjContextMenu;wjKo.bindingHandlers.wjInputDate=new wjInputDate;wjKo.bindingHandlers.wjInputDateTime=new wjInputDateTime;wjKo.bindingHandlers.wjInputNumber=new wjInputNumber;wjKo.bindingHandlers.wjInputMask=new wjInputMask;wjKo.bindingHandlers.wjInputTime=new wjInputTime;wjKo.bindingHandlers.wjInputColor=new wjInputColor;wjKo.bindingHandlers.wjCollectionViewNavigator=new wjCollectionViewNavigator;wjKo.bindingHandlers.wjCollectionViewPager=new wjCollectionViewPager;wjKo.bindingHandlers.wjMultiSelect=new wjMultiSelect;wjKo.bindingHandlers.wjMultiAutoComplete=new wjMultiAutoComplete;wjKo.bindingHandlers.wjPopup=new wjPopup;