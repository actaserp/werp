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

var __extends=this&&this.__extends||function(){var extendStatics=function(e,t){return(extendStatics=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)t.hasOwnProperty(n)&&(e[n]=t[n])})(e,t)};return function(e,t){extendStatics(e,t);function __(){this.constructor=e}e.prototype=null===t?Object.create(t):(__.prototype=t.prototype,new __)}}();import{ComponentBase}from"wijmo/wijmo.react.base";import*as React from"react";import*as wjcCore from"wijmo/wijmo";import*as wjcNav from"wijmo/wijmo.nav";var TreeView=function(e){__extends(TreeView,e);function TreeView(t){return e.call(this,t,wjcNav.TreeView,{objectProps:["childItemsPath","displayMemberPath","imageMemberPath","checkedMemberPath","itemsSource","selectedItem","selectedNode","checkedItems"]})||this}return TreeView}(ComponentBase);export{TreeView};var TabPanel=function(e){__extends(TabPanel,e);function TabPanel(t){return e.call(this,t,wjcNav.TabPanel,{objectProps:["selectedTab"]})||this}TabPanel.prototype._createControl=function(){var e=new wjcNav.TabPanel(this._getElement(),null,!0);e.tabs.beginUpdate();return e};TabPanel.prototype.componentDidMount=function(){e.prototype.componentDidMount.call(this);var t=this.control,n=t.selectedIndex,o=t.tabs;if(n>-1&&n<o.length){wjcCore.addClass(o[n].header,"wj-state-active");t.onSelectedIndexChanged()}o.endUpdate()};return TabPanel}(ComponentBase);export{TabPanel};var Tab=function(e){__extends(Tab,e);function Tab(t){var n=e.call(this,t,wjcNav.Tab)||this;n._parentProp="tabs";return n}Tab.prototype._createControl=function(){var e=this._getElement().children;return new wjcNav.Tab(e[0],e[1])};Tab.prototype._renderImpl=function(){return React.createElement("div",{ref:this._hostRef},this.props.children)};return Tab}(ComponentBase);export{Tab};var Accordion=function(e){__extends(Accordion,e);function Accordion(t){return e.call(this,t,wjcNav.Accordion,{objectProps:["selectedPane"]})||this}Accordion.prototype._createControl=function(){var e=new wjcNav.Accordion(this._getElement(),null,!0);e.panes.beginUpdate();return e};Accordion.prototype.componentDidMount=function(){e.prototype.componentDidMount.call(this);var t=this.control,n=t.panes;t.selectedIndex<0&&n.length&&(t.selectedIndex=0);n.endUpdate()};return Accordion}(ComponentBase);export{Accordion};var AccordionPane=function(e){__extends(AccordionPane,e);function AccordionPane(t){var n=e.call(this,t,wjcNav.AccordionPane)||this;n._parentProp="panes";return n}AccordionPane.prototype._createControl=function(){var e=this._getElement().children;return new wjcNav.AccordionPane(e[0],e[1])};AccordionPane.prototype._renderImpl=function(){return React.createElement("div",{ref:this._hostRef},this.props.children)};return AccordionPane}(ComponentBase);export{AccordionPane};