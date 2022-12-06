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

"use strict";var __importStar=this&&this.__importStar||function(e){if(e&&e.__esModule)return e;var t={};if(null!=e)for(var r in e)Object.hasOwnProperty.call(e,r)&&(t[r]=e[r]);t.default=e;return t};Object.defineProperty(exports,"__esModule",{value:!0});const wijmo_react_base_1=require("wijmo/wijmo.react.base"),React=__importStar(require("react")),wjcCore=__importStar(require("wijmo/wijmo")),wjcNav=__importStar(require("wijmo/wijmo.nav"));class TreeView extends wijmo_react_base_1.ComponentBase{constructor(e){super(e,wjcNav.TreeView,{objectProps:["childItemsPath","displayMemberPath","imageMemberPath","checkedMemberPath","itemsSource","selectedItem","selectedNode","checkedItems"]})}}exports.TreeView=TreeView;class TabPanel extends wijmo_react_base_1.ComponentBase{constructor(e){super(e,wjcNav.TabPanel,{objectProps:["selectedTab"]})}_createControl(){const e=new wjcNav.TabPanel(this._getElement(),null,!0);e.tabs.beginUpdate();return e}componentDidMount(){super.componentDidMount();let e=this.control,t=e.selectedIndex,r=e.tabs;if(t>-1&&t<r.length){wjcCore.addClass(r[t].header,"wj-state-active");e.onSelectedIndexChanged()}r.endUpdate()}}exports.TabPanel=TabPanel;class Tab extends wijmo_react_base_1.ComponentBase{constructor(e){super(e,wjcNav.Tab);this._parentProp="tabs"}_createControl(){const e=this._getElement().children;return new wjcNav.Tab(e[0],e[1])}_renderImpl(){return React.createElement("div",{ref:this._hostRef},this.props.children)}}exports.Tab=Tab;class Accordion extends wijmo_react_base_1.ComponentBase{constructor(e){super(e,wjcNav.Accordion,{objectProps:["selectedPane"]})}_createControl(){const e=new wjcNav.Accordion(this._getElement(),null,!0);e.panes.beginUpdate();return e}componentDidMount(){super.componentDidMount();const e=this.control,t=e.panes;e.selectedIndex<0&&t.length&&(e.selectedIndex=0);t.endUpdate()}}exports.Accordion=Accordion;class AccordionPane extends wijmo_react_base_1.ComponentBase{constructor(e){super(e,wjcNav.AccordionPane);this._parentProp="panes"}_createControl(){const e=this._getElement().children;return new wjcNav.AccordionPane(e[0],e[1])}_renderImpl(){return React.createElement("div",{ref:this._hostRef},this.props.children)}}exports.AccordionPane=AccordionPane;