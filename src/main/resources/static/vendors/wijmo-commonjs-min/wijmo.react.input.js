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

"use strict";var __extends=this&&this.__extends||function(){var extendStatics=function(t,e){return(extendStatics=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(t,e){t.__proto__=e}||function(t,e){for(var n in e)e.hasOwnProperty(n)&&(t[n]=e[n])})(t,e)};return function(t,e){extendStatics(t,e);function __(){this.constructor=t}t.prototype=null===e?Object.create(e):(__.prototype=e.prototype,new __)}}(),__assign=this&&this.__assign||function(){return(__assign=Object.assign||function(t){for(var e,n=1,o=arguments.length;n<o;n++){e=arguments[n];for(var r in e)Object.prototype.hasOwnProperty.call(e,r)&&(t[r]=e[r])}return t}).apply(this,arguments)},__importStar=this&&this.__importStar||function(t){if(t&&t.__esModule)return t;var e={};if(null!=t)for(var n in t)Object.hasOwnProperty.call(t,n)&&(e[n]=t[n]);e.default=t;return e};Object.defineProperty(exports,"__esModule",{value:!0});var wijmo_react_base_1=require("wijmo/wijmo.react.base"),React=__importStar(require("react")),ReactDOM=__importStar(require("react-dom")),wjcCore=__importStar(require("wijmo/wijmo")),wjcInput=__importStar(require("wijmo/wijmo.input")),ListBox=function(t){__extends(ListBox,t);function ListBox(e){return t.call(this,e,wjcInput.ListBox,{objectProps:["itemsSource","selectedItem","selectedValue","checkedItems","wjItemTemplate"]})||this}ListBox.prototype.componentDidMount=function(){var e=t.prototype.componentDidMount.call(this);new ItemTemplate(this);return e};return ListBox}(wijmo_react_base_1.ComponentBase);exports.ListBox=ListBox;var MultiSelectListBox=function(t){__extends(MultiSelectListBox,t);function MultiSelectListBox(e){return t.call(this,e,wjcInput.MultiSelectListBox,{objectProps:["itemsSource","checkedItems"]})||this}return MultiSelectListBox}(wijmo_react_base_1.ComponentBase);exports.MultiSelectListBox=MultiSelectListBox;var ComboBox=function(t){__extends(ComboBox,t);function ComboBox(e){return t.call(this,e,wjcInput.ComboBox,{objectProps:["itemsSource","selectedItem","selectedValue","wjItemTemplate"]})||this}ComboBox.prototype.componentDidMount=function(){var e=t.prototype.componentDidMount.call(this);new ItemTemplate(this);return e};return ComboBox}(wijmo_react_base_1.ComponentBase);exports.ComboBox=ComboBox;var AutoComplete=function(t){__extends(AutoComplete,t);function AutoComplete(e){return t.call(this,e,wjcInput.AutoComplete,{objectProps:["itemsSource","selectedItem","selectedValue"]})||this}return AutoComplete}(wijmo_react_base_1.ComponentBase);exports.AutoComplete=AutoComplete;var Calendar=function(t){__extends(Calendar,t);function Calendar(e){return t.call(this,e,wjcInput.Calendar)||this}return Calendar}(wijmo_react_base_1.ComponentBase);exports.Calendar=Calendar;var ColorPicker=function(t){__extends(ColorPicker,t);function ColorPicker(e){return t.call(this,e,wjcInput.ColorPicker,{objectProps:["palette"]})||this}return ColorPicker}(wijmo_react_base_1.ComponentBase);exports.ColorPicker=ColorPicker;var InputMask=function(t){__extends(InputMask,t);function InputMask(e){return t.call(this,e,wjcInput.InputMask)||this}return InputMask}(wijmo_react_base_1.ComponentBase);exports.InputMask=InputMask;var InputColor=function(t){__extends(InputColor,t);function InputColor(e){return t.call(this,e,wjcInput.InputColor)||this}return InputColor}(wijmo_react_base_1.ComponentBase);exports.InputColor=InputColor;var MultiSelect=function(t){__extends(MultiSelect,t);function MultiSelect(e){return t.call(this,e,wjcInput.MultiSelect,{objectProps:["itemsSource","selectedItem","selectedValue","checkedItems","wjItemTemplate"]})||this}MultiSelect.prototype.componentDidMount=function(){var e=t.prototype.componentDidMount.call(this);new ItemTemplate(this);return e};return MultiSelect}(wijmo_react_base_1.ComponentBase);exports.MultiSelect=MultiSelect;var MultiAutoComplete=function(t){__extends(MultiAutoComplete,t);function MultiAutoComplete(e){return t.call(this,e,wjcInput.MultiAutoComplete,{objectProps:["itemsSource","selectedItem","selectedValue","selectedItems"]})||this}return MultiAutoComplete}(wijmo_react_base_1.ComponentBase);exports.MultiAutoComplete=MultiAutoComplete;var InputNumber=function(t){__extends(InputNumber,t);function InputNumber(e){return t.call(this,e,wjcInput.InputNumber)||this}return InputNumber}(wijmo_react_base_1.ComponentBase);exports.InputNumber=InputNumber;var InputDate=function(t){__extends(InputDate,t);function InputDate(e){return t.call(this,e,wjcInput.InputDate,{objectProps:["predefinedRanges"]})||this}return InputDate}(wijmo_react_base_1.ComponentBase);exports.InputDate=InputDate;var InputTime=function(t){__extends(InputTime,t);function InputTime(e){return t.call(this,e,wjcInput.InputTime,{objectProps:["itemsSource","selectedItem","selectedValue"]})||this}return InputTime}(wijmo_react_base_1.ComponentBase);exports.InputTime=InputTime;var InputDateTime=function(t){__extends(InputDateTime,t);function InputDateTime(e){return t.call(this,e,wjcInput.InputDateTime,{objectProps:["predefinedRanges"]})||this}return InputDateTime}(wijmo_react_base_1.ComponentBase);exports.InputDateTime=InputDateTime;var InputDateRange=function(t){__extends(InputDateRange,t);function InputDateRange(e){return t.call(this,e,wjcInput.InputDateRange,{objectProps:["predefinedRanges"]})||this}return InputDateRange}(wijmo_react_base_1.ComponentBase);exports.InputDateRange=InputDateRange;var Menu=function(t){__extends(Menu,t);function Menu(e){var n=t.call(this,e,wjcInput.Menu,{objectProps:["itemsSource","selectedItem","selectedValue","wjItemTemplate"]})||this;n._contextMenuData={};n.contextMenuProp="contextMenuOf";return n}Object.defineProperty(Menu.prototype,"value",{get:function(){return this._value},set:function(t){this._value=t;if(null!=t){this.control.selectedValue=t;this._updateHeader()}},enumerable:!0,configurable:!0});Menu.prototype.componentDidMount=function(){var e=t.prototype.componentDidMount.call(this);this._definedHeader=this.props.header;this.value=this.props.value;new ItemTemplate(this);this._contextMenuBindListeners();return e};Menu.prototype.componentDidUpdate=function(e){t.prototype.componentDidUpdate.call(this,e);this._definedHeader=this.props.header;this.value=this.props.value;var n=this._contextMenuGetElementsIfChanged();if(n){this._contextMenuUnbindListeners();this._contextMenuBindListeners(n)}};Menu.prototype.componentWillUnmount=function(){this._contextMenuUnbindListeners();t.prototype.componentWillUnmount.call(this)};Menu.prototype._createControl=function(){var e=this,n=t.prototype._createControl.call(this);n.itemsSource=new wjcCore.ObservableArray;n.selectedIndex=0;n.listBox.formatItem.addHandler(this._fmtItem,this);n.invalidate();n.itemClicked.addHandler((function(t){e.value=e.control.selectedValue}));return n};Menu.prototype._updateHeader=function(){this.control.header=this._definedHeader||"";var t=this.control.selectedItem;if(null!=this.value&&t&&this.control.displayMemberPath){var e=null;if(t instanceof MenuItem){var n=t.contentRoot;e=n?n.innerHTML:t[this.control.displayMemberPath]}null!=e&&(this.control.header+=": <b>"+e+"</b>")}};Menu.prototype._fmtItem=function(t,e){if(e.data instanceof MenuItem||e.data instanceof MenuSeparator){e.item.textContent="";e.item.appendChild(e.data.contentRoot);e.data.added(e.item)}};Menu.prototype._contextMenuGetElementsIfChanged=function(){var t=this._contextMenuData.elements||[],e=this._contextMenuGetElements(this.props[this.contextMenuProp]);if(t.length!==e.length)return e;for(var n in t)if(t[n]!==e[n])return e;return null};Menu.prototype._contextMenuGetElements=function(t){var e=this,n=[];(wjcCore.isArray(t)?t:[t]).forEach((function(t){if(t){var o=null;if("string"==typeof t)o=document.getElementById(t);else if("object"==typeof t){var r=t.current;if(r)if(r instanceof HTMLElement)o=r;else if(r instanceof wijmo_react_base_1.ComponentBase)o=r.control.hostElement;else{wijmo_react_base_1.ComponentBase.isInStrictMode(r)&&console.warn("In React StrictMode reference in Menu "+e.contextMenuProp+" prop should point to HTMLElement (not custom component)");o=ReactDOM.findDOMNode(r)}}o&&n.push(o)}}));return n};Menu.prototype._contextMenuBindListeners=function(t){var e=this;void 0===t&&(t=null);this.props.hasOwnProperty(this.contextMenuProp)&&(this.control.hostElement.style.display="none");var n=t||this._contextMenuGetElements(this.props[this.contextMenuProp]),o=[];n.forEach((function(t){var n=null;if(t){n=function(n){if(!wjcCore.closest(n.target,"[disabled]")){var o=e.control;if(o&&o.dropDown){n.preventDefault();n.stopPropagation();o.owner=t;o.show(n)}}};t.addEventListener("contextmenu",n)}o.push(n)}));this._contextMenuData={elements:n,listeners:o}};Menu.prototype._contextMenuUnbindListeners=function(){var t=this._contextMenuData;for(var e in t.elements||[]){var n=t.elements[e];if(n){n.removeEventListener("contextmenu",t.listeners[e]);var o=this.control;if(o.owner===n&&o.isDroppedDown){o.owner=void 0;o.hide()}}}this._contextMenuData={}};return Menu}(wijmo_react_base_1.ComponentBase);exports.Menu=Menu;var MenuItem=function(t){__extends(MenuItem,t);function MenuItem(e){var n=t.call(this,e,null,{objectProps:["value","cmd","cmdParam"]})||this;n._parentProp="itemsSource";n._siblingId="menuItemDir";n.value=null;n.cmd=null;n.cmdParam=null;return n}MenuItem.prototype._createControl=function(){var t=this.parent.control;1==t.itemsSource.length&&t.selectedIndex<0&&(t.selectedIndex=0);t.displayMemberPath||(t.displayMemberPath="header");t.selectedValuePath||(t.selectedValuePath="value");t.commandPath||(t.commandPath="cmd");t.commandParameterPath||(t.commandParameterPath="cmdParam");return this};MenuItem.prototype._renderImpl=function(){var t=this;return React.createElement("div",{style:{display:"none"},ref:this._hostRef},React.createElement("div",{ref:function(e){return t.contentRoot=e}},this.props.children))};MenuItem.prototype.added=function(t){};return MenuItem}(wijmo_react_base_1.ComponentBase);exports.MenuItem=MenuItem;var MenuSeparator=function(t){__extends(MenuSeparator,t);function MenuSeparator(e){var n=t.call(this,e,null)||this;n._parentProp="itemsSource";n._siblingId="menuItemDir";return n}MenuSeparator.prototype._createControl=function(){return this};MenuSeparator.prototype._renderImpl=function(){var t=this;return React.createElement("div",{style:{display:"none"},ref:this._hostRef},React.createElement("div",{ref:function(e){return t.contentRoot=e},style:{width:"100%",height:"1px",backgroundColor:"lightgray"}},this.props.children))};MenuSeparator.prototype.added=function(t){wjcCore.addClass(t,"wj-state-disabled")};return MenuSeparator}(wijmo_react_base_1.ComponentBase);exports.MenuSeparator=MenuSeparator;var ItemTemplate=function(){function ItemTemplate(t){this._templateItems=[];this.component=t;this.ownerControl=t.control;this.wjItemTemplate=this.component.props.wjItemTemplate;this.listBox=this._getListBox(this.ownerControl);this._attachToComponent();this._attachToControl()}ItemTemplate.prototype._attachToComponent=function(){this.component._afterDidUpdate.addHandler(this._updateTemplateItems,this);this.component._beforeWillUnmount.addHandler(this._beforeWillUnmount,this)};ItemTemplate.prototype._beforeWillUnmount=function(){this.component._afterDidUpdate.removeHandler(this._updateTemplateItems,this);this.component._beforeWillUnmount.removeHandler(this._beforeWillUnmount,this);this._destroyTemplateItems()};ItemTemplate.prototype._updateTemplateItems=function(){var t=this;if(null==this.component.props.wjItemTemplate&&wjcCore.isFunction(this.wjItemTemplate)){this.wjItemTemplate=null;this._templateItems.forEach((function(e){ReactDOM.unmountComponentAtNode(e.itemEl);setTimeout((function(){var n=wjcCore.isString(e.item)?e.item:e.item[t.listBox.displayMemberPath];e.itemEl.textContent=n}))}))}else if(wjcCore.isFunction(this.component.props.wjItemTemplate)){this.wjItemTemplate=this.component.props.wjItemTemplate;this._templateItems.forEach((function(e){ReactDOM.render(t._createItemElTpl(e),e.itemEl)}))}};ItemTemplate.prototype._attachToControl=function(){this.listBox.formatItem.addHandler(this._fmtItem,this);this.listBox.loadingItems.addHandler(this._destroyTemplateItems,this);this.ownerControl.invalidate()};ItemTemplate.prototype._fmtItem=function(t,e){var n=e.item,o={control:t,item:e.data,itemIndex:e.index};this._templateItems.push(__assign({},o,{itemEl:n}));if(wjcCore.isFunction(this.wjItemTemplate)){n.textContent="";ReactDOM.render(this._createItemElTpl(o),n)}};ItemTemplate.prototype._getListBox=function(t){return t instanceof wjcInput.ListBox?t:t.listBox};ItemTemplate.prototype._destroyTemplateItems=function(){wjcCore.isFunction(this.wjItemTemplate)&&this._templateItems.forEach((function(t){ReactDOM.unmountComponentAtNode(t.itemEl)}));this._templateItems=[]};ItemTemplate.prototype._createItemElTpl=function(t){return React.createElement("div",{},this.wjItemTemplate({control:t.control,item:t.item,itemIndex:t.itemIndex}))};return ItemTemplate}(),Popup=function(t){__extends(Popup,t);function Popup(e){var n=t.call(this,e,wjcInput.Popup)||this;n._v17=wijmo_react_base_1.ComponentBase._reactMajorVersion>=17;return n}Popup.prototype.componentDidMount=function(){t.prototype.componentDidMount.call(this);var e=this._hostRefValue;this._sEl=e.nextSibling;this._pEl=e.parentElement;this._v17&&this.forceUpdate()};Popup.prototype.componentWillUnmount=function(){var e=this._hostRefValue,n=this._pEl;if(n!=e.parentElement){var o=this._sEl;o?n.insertBefore(e,o):n.appendChild(e)}t.prototype.componentWillUnmount.call(this)};Popup.prototype._renderImpl=function(){var t=this.props.children;this._v17&&(t=this._hostRefValue?ReactDOM.createPortal(t,this._hostRefValue):void 0);return React.createElement("div",{ref:this._hostRef},t)};return Popup}(wijmo_react_base_1.ComponentBase);exports.Popup=Popup;var CollectionViewNavigator=function(t){__extends(CollectionViewNavigator,t);function CollectionViewNavigator(e){return t.call(this,e,wjcInput.CollectionViewNavigator,{objectProps:["cv"]})||this}return CollectionViewNavigator}(wijmo_react_base_1.ComponentBase);exports.CollectionViewNavigator=CollectionViewNavigator;