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

import{WjComponentBehavior}from"wijmo/wijmo.webcomponents.base";import*as wjcGrid from"wijmo/wijmo.grid";let _wj_ns_exists_17=!0;export class WjcFlexGrid extends wjcGrid.FlexGrid{constructor(){super(document.createElement("div"));this._wjBehaviour=WjComponentBehavior._attach(this)}static get observedAttributes(){return WjComponentBehavior.getProps(this)}connectedCallback(){this._wjBehaviour.lhConnected()}attributeChangedCallback(e,t,o){this._wjBehaviour.lhAttributeChanged(e,t,o)}disconnectedCallback(){this._wjBehaviour.lhDisconnected()}addEventListener(...e){"string"==typeof e[0]?HTMLElement.prototype.addEventListener.apply(this,e):super.addEventListener.apply(this,e)}}_wj_ns_exists_17&&WjComponentBehavior.register("wjc-flex-grid",WjcFlexGrid);export class WjcFlexGridColumn extends HTMLElement{constructor(){super();this._wjBehaviour=WjComponentBehavior._attach(this)}static get observedAttributes(){return WjComponentBehavior.getProps(this)}connectedCallback(){this._wjBehaviour.lhConnected()}attributeChangedCallback(e,t,o){this._wjBehaviour.lhAttributeChanged(e,t,o)}disconnectedCallback(){this._wjBehaviour.lhDisconnected()}_beforeInitParent(){let e=this.parentElement.control;if(e.autoGenerateColumns){e.autoGenerateColumns=!1;e.columns.clear()}}}WjcFlexGridColumn.wrappedClass=()=>wjcGrid.Column;WjcFlexGridColumn.parentProp="columns";_wj_ns_exists_17&&WjComponentBehavior.register("wjc-flex-grid-column",WjcFlexGridColumn);export class WjcFlexGridColumnGroup extends HTMLElement{constructor(){super();this._wjBehaviour=WjComponentBehavior._attach(this)}static get observedAttributes(){return WjComponentBehavior.getProps(this)}connectedCallback(){this._wjBehaviour.lhConnected()}attributeChangedCallback(e,t,o){this._wjBehaviour.lhAttributeChanged(e,t,o)}disconnectedCallback(){this._wjBehaviour.lhDisconnected()}}WjcFlexGridColumnGroup.wrappedClass=()=>wjcGrid.ColumnGroup;WjcFlexGridColumnGroup.parentProp="columnGroups";_wj_ns_exists_17&&WjComponentBehavior.register("wjc-flex-grid-column-group",WjcFlexGridColumnGroup);