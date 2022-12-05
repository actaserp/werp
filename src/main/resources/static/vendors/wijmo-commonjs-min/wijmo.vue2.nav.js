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

"use strict";var __extends=this&&this.__extends||function(){var extendStatics=function(e,o){return(extendStatics=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,o){e.__proto__=o}||function(e,o){for(var r in o)o.hasOwnProperty(r)&&(e[r]=o[r])})(e,o)};return function(e,o){extendStatics(e,o);function __(){this.constructor=e}e.prototype=null===o?Object.create(o):(__.prototype=o.prototype,new __)}}(),__importStar=this&&this.__importStar||function(e){if(e&&e.__esModule)return e;var o={};if(null!=e)for(var r in e)Object.hasOwnProperty.call(e,r)&&(o[r]=e[r]);o.default=e;return o};Object.defineProperty(exports,"__esModule",{value:!0});var wijmo_vue2_base_1=require("wijmo/wijmo.vue2.base"),wjcCore=__importStar(require("wijmo/wijmo")),wjcNav=__importStar(require("wijmo/wijmo.nav")),WjTreeViewBehavior=function(e){__extends(WjTreeViewBehavior,e);function WjTreeViewBehavior(){return null!==e&&e.apply(this,arguments)||this}WjTreeViewBehavior.tag="wj-tree-view";WjTreeViewBehavior.props=["isDisabled","tabOrder","childItemsPath","displayMemberPath","imageMemberPath","checkedMemberPath","isContentHtml","showCheckboxes","autoCollapse","isAnimated","isReadOnly","allowDragging","checkOnClick","expandOnClick","collapseOnClick","expandOnLoad","lazyLoadFunction","itemsSource","selectedItem","selectedNode","checkedItems"];WjTreeViewBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput","itemsSourceChanged","loadingItems","loadedItems","itemClicked","isCollapsedChanging","isCollapsedChanged","isCheckedChanging","isCheckedChanged","formatItem","dragStart","dragOver","drop","dragEnd","nodeEditStarting","nodeEditStarted","nodeEditEnding","nodeEditEnded"];WjTreeViewBehavior.changeEvents={selectedItemChanged:["selectedItem","selectedNode"],checkedItemsChanged:["checkedItems"]};WjTreeViewBehavior.classCtor=function(){return wjcNav.TreeView};return WjTreeViewBehavior}(wijmo_vue2_base_1.WjComponentBehavior);exports.WjTreeView=WjTreeViewBehavior.register();function registerV3WjTreeView(e){e.component(WjTreeViewBehavior.tag,exports.WjTreeView)}var WjTabPanelBehavior=function(e){__extends(WjTabPanelBehavior,e);function WjTabPanelBehavior(){return null!==e&&e.apply(this,arguments)||this}WjTabPanelBehavior.prototype._createControl=function(){var e=new wjcNav.TabPanel(this.component.$el,null,!0);e.beginUpdate();return e};WjTabPanelBehavior.prototype.lhMounted=function(){e.prototype.lhMounted.call(this);this.control.onSelectedIndexChanged();this.control.endUpdate()};WjTabPanelBehavior.tag="wj-tab-panel";WjTabPanelBehavior.props=["isDisabled","tabOrder","isAnimated","autoSwitch","selectedIndex","selectedTab"];WjTabPanelBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput"];WjTabPanelBehavior.changeEvents={selectedIndexChanged:["selectedIndex","selectedTab"]};WjTabPanelBehavior.classCtor=function(){return wjcNav.TabPanel};return WjTabPanelBehavior}(wijmo_vue2_base_1.WjComponentBehavior);exports.WjTabPanel=WjTabPanelBehavior.register();function registerV3WjTabPanel(e){e.component(WjTabPanelBehavior.tag,exports.WjTabPanel)}var WjTabBehavior=function(e){__extends(WjTabBehavior,e);function WjTabBehavior(){return null!==e&&e.apply(this,arguments)||this}WjTabBehavior.prototype._createControl=function(){var e=this.component.$el;wjcCore.assert(2==e.childElementCount,"TabPanel children should contain header and pane elements");return new wjcNav.Tab(e.children[0],e.children[1])};WjTabBehavior.tag="wj-tab";WjTabBehavior.parentProp="tabs";WjTabBehavior.props=["wjProperty","isDisabled","isVisible"];WjTabBehavior.events=["initialized"];WjTabBehavior.classCtor=function(){return wjcNav.Tab};return WjTabBehavior}(wijmo_vue2_base_1.WjComponentBehavior);exports.WjTab=WjTabBehavior.register();function registerV3WjTab(e){e.component(WjTabBehavior.tag,exports.WjTab)}var WjAccordionBehavior=function(e){__extends(WjAccordionBehavior,e);function WjAccordionBehavior(){return null!==e&&e.apply(this,arguments)||this}WjAccordionBehavior.prototype._createControl=function(){var e=new wjcNav.Accordion(this.component.$el,null,!0);e.beginUpdate();return e};WjAccordionBehavior.prototype.lhMounted=function(){e.prototype.lhMounted.call(this);var o=this.control;o.selectedIndex<0&&o.panes.length&&(o.selectedIndex=0);o.endUpdate()};WjAccordionBehavior.tag="wj-accordion";WjAccordionBehavior.props=["isDisabled","tabOrder","isAnimated","autoSwitch","selectedIndex","selectedPane","showIcons","allowCollapseAll","allowExpandMany"];WjAccordionBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput"];WjAccordionBehavior.changeEvents={selectedIndexChanged:["selectedIndex"]};WjAccordionBehavior.classCtor=function(){return wjcNav.Accordion};return WjAccordionBehavior}(wijmo_vue2_base_1.WjComponentBehavior);exports.WjAccordion=WjAccordionBehavior.register();function registerV3WjAccordion(e){e.component(WjAccordionBehavior.tag,exports.WjAccordion)}var WjAccordionPaneBehavior=function(e){__extends(WjAccordionPaneBehavior,e);function WjAccordionPaneBehavior(){return null!==e&&e.apply(this,arguments)||this}WjAccordionPaneBehavior.prototype._createControl=function(){var e=this.component.$el;wjcCore.assert(2==e.childElementCount,"AccordionPane children should contain header and pane elements");return new wjcNav.AccordionPane(e.children[0],e.children[1])};WjAccordionPaneBehavior.tag="wj-accordion-pane";WjAccordionPaneBehavior.parentProp="panes";WjAccordionPaneBehavior.props=["wjProperty","isDisabled","isVisible","isCollapsed"];WjAccordionPaneBehavior.events=["initialized"];WjAccordionPaneBehavior.classCtor=function(){return wjcNav.AccordionPane};return WjAccordionPaneBehavior}(wijmo_vue2_base_1.WjComponentBehavior);exports.WjAccordionPane=WjAccordionPaneBehavior.register();function registerV3WjAccordionPane(e){e.component(WjAccordionPaneBehavior.tag,exports.WjAccordionPane)}function registerNav(e){if(wijmo_vue2_base_1.VueApi.isV3Plus){registerV3WjTreeView(e);registerV3WjTabPanel(e);registerV3WjTab(e);registerV3WjAccordion(e);registerV3WjAccordionPane(e)}}exports.registerNav=registerNav;