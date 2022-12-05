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

"use strict";var __extends=this&&this.__extends||function(){var extendStatics=function(e,t){return(extendStatics=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var i in t)t.hasOwnProperty(i)&&(e[i]=t[i])})(e,t)};return function(e,t){extendStatics(e,t);function __(){this.constructor=e}e.prototype=null===t?Object.create(t):(__.prototype=t.prototype,new __)}}(),__importStar=this&&this.__importStar||function(e){if(e&&e.__esModule)return e;var t={};if(null!=e)for(var i in e)Object.hasOwnProperty.call(e,i)&&(t[i]=e[i]);t.default=e;return t};Object.defineProperty(exports,"__esModule",{value:!0});var wijmo_1=require("wijmo/wijmo"),wijmo_grid_1=require("wijmo/wijmo.grid"),selfModule=__importStar(require("wijmo/wijmo.grid.detail")),DetailRow=function(e){__extends(DetailRow,e);function DetailRow(t){var i=e.call(this)||this;i.isReadOnly=!0;return i}Object.defineProperty(DetailRow.prototype,"detail",{get:function(){return this._detail},set:function(e){this._detail=e},enumerable:!0,configurable:!0});return DetailRow}(wijmo_grid_1.Row);exports.DetailRow=DetailRow;var KeyAction,DetailVisibilityMode,DetailMergeManager=function(e){__extends(DetailMergeManager,e);function DetailMergeManager(t){var i=e.call(this)||this;i._originalMergeManager=t.mergeManager;return i}DetailMergeManager.prototype.getMergedRange=function(e,t,i,r){void 0===r&&(r=!0);switch(e.cellType){case wijmo_grid_1.CellType.Cell:if(e.rows[t]instanceof DetailRow){e.columns.frozen>0&&e.grid&&(e.grid.cloneFrozenCells=!1);return new wijmo_grid_1.CellRange(t,0,t,e.columns.length-1)}break;case wijmo_grid_1.CellType.RowHeader:var o=_isFrozen(e,t),l=_isNew(e,t),n=e.rows[t].dataItem;!n&&t>0&&e.rows[t]instanceof DetailRow&&(n=e.rows[t-1].dataItem);for(var a=t;a>0&&e.rows[a-1].dataItem==n&&_isFrozen(e,a-1)==o&&_isNew(e,a-1)==l;)a--;for(var s=t;s<e.rows.length-1&&e.rows[s+1].dataItem==n&&_isFrozen(e,s+1)==o&&_isNew(e,s+1)==l;)s++;s<e.rows.length-1&&e.rows[s+1]instanceof DetailRow&&_isFrozen(e,s+1)==o&&_isNew(e,s+1)==l&&s++;return a!=s?new wijmo_grid_1.CellRange(a,i,s,i):null}return this._originalMergeManager.getMergedRange(e,t,i,r)};return DetailMergeManager}(wijmo_grid_1.MergeManager);exports.DetailMergeManager=DetailMergeManager;function _isFrozen(e,t){return t<e.rows.frozen}function _isNew(e,t){return e.rows[t]instanceof wijmo_grid_1._NewRowTemplate}wijmo_1._addCultureInfo("FlexGridDetailProvider",{ariaLabels:{toggleDetail:"Toggle Row Detail"}});!function(e){e[e.None=0]="None";e[e.ToggleDetail=1]="ToggleDetail"}(KeyAction=exports.KeyAction||(exports.KeyAction={}));!function(e){e[e.Code=0]="Code";e[e.Selection=1]="Selection";e[e.ExpandSingle=2]="ExpandSingle";e[e.ExpandMulti=3]="ExpandMulti"}(DetailVisibilityMode=exports.DetailVisibilityMode||(exports.DetailVisibilityMode={}));var FlexGridDetailProvider=function(){function FlexGridDetailProvider(e,t){var i=this;this._maxHeight=null;this._mode=DetailVisibilityMode.ExpandSingle;this._animated=!1;this._keyActionEnter=KeyAction.None;this._g=e;e.mergeManager=new DetailMergeManager(e);e.rowHeaders.hostElement.addEventListener("click",this._hdrClick.bind(this));e.rowHeaders.hostElement.addEventListener("mousedown",(function(t){var r=e.editableCollectionView;if(e.activeEditor||r&&r.currentEditItem){i._hdrClick(t);t.preventDefault()}}));setTimeout((function(){e.formatItem.addHandler(i._formatItem,i)}),100);e.selectionChanged.addHandler(this._selectionChanged,this);e.resizedRow.addHandler(this._resizedRow,this);e.loadingRows.addHandler((function(){return i.hideDetail()}));e.deletingRow.addHandler((function(e,t){i.hideDetail(t.row)}));e.updatedView.addHandler(this._handleFrozenCells,this);e.cloneFrozenCells=!1;e.draggingRow.addHandler((function(e,t){if(t.row<e.rows.length-1&&e.rows[t.row+1]instanceof DetailRow){t.cancel=!0;i.hideDetail(t.row)}}));e.hostElement.addEventListener("keydown",(function(e){if(e.keyCode==wijmo_1.Key.Enter&&i._keyActionEnter==KeyAction.ToggleDetail){var t=i._g.selection.row;i._toggleRowDetail(t)&&e.preventDefault()}}),!0);e._root.addEventListener("scroll",(function(){wijmo_1.Control.refreshAll(e._root)}));wijmo_1.copy(this,t)}Object.defineProperty(FlexGridDetailProvider.prototype,"grid",{get:function(){return this._g},enumerable:!0,configurable:!0});Object.defineProperty(FlexGridDetailProvider.prototype,"detailVisibilityMode",{get:function(){return this._mode},set:function(e){if((e=wijmo_1.asEnum(e,DetailVisibilityMode))!=this._mode){this._mode=e;this.hideDetail();this._g.invalidate()}},enumerable:!0,configurable:!0});Object.defineProperty(FlexGridDetailProvider.prototype,"maxHeight",{get:function(){return this._maxHeight},set:function(e){if((e=wijmo_1.asNumber(e,!0))!=this._maxHeight){this._maxHeight=e;this.hideDetail()}},enumerable:!0,configurable:!0});Object.defineProperty(FlexGridDetailProvider.prototype,"isAnimated",{get:function(){return this._animated},set:function(e){e!=this._animated&&(this._animated=wijmo_1.asBoolean(e))},enumerable:!0,configurable:!0});Object.defineProperty(FlexGridDetailProvider.prototype,"keyActionEnter",{get:function(){return this._keyActionEnter},set:function(e){this._keyActionEnter=wijmo_1.asEnum(e,KeyAction)},enumerable:!0,configurable:!0});Object.defineProperty(FlexGridDetailProvider.prototype,"createDetailCell",{get:function(){return this._createDetailCellFn},set:function(e){this._createDetailCellFn=wijmo_1.asFunction(e,!0)},enumerable:!0,configurable:!0});Object.defineProperty(FlexGridDetailProvider.prototype,"disposeDetailCell",{get:function(){return this._disposeDetailCellFn},set:function(e){this._disposeDetailCellFn=wijmo_1.asFunction(e,!0)},enumerable:!0,configurable:!0});Object.defineProperty(FlexGridDetailProvider.prototype,"rowHasDetail",{get:function(){return this._rowHasDetailFn},set:function(e){if((e=wijmo_1.asFunction(e,!0))!=this._rowHasDetailFn){this._rowHasDetailFn=e;this.hideDetail();this._g.invalidate()}},enumerable:!0,configurable:!0});FlexGridDetailProvider.prototype.getDetailRow=function(e){for(var t=this._g.rows,i=this._toIndex(e),r=t[i].dataItem;i<t.length;i++){var o=t[i];if(o instanceof DetailRow)return o;if(o.dataItem!=r)return null}return null};FlexGridDetailProvider.prototype.isDetailVisible=function(e){return null!=this.getDetailRow(e)};FlexGridDetailProvider.prototype.isDetailAvailable=function(e){e=this._toIndex(e);return this._hasDetail(e)};FlexGridDetailProvider.prototype.hideDetail=function(e){var t=this._g,i=t.rows;if(null!=e){for(var r=this._toIndex(e);!(i[r]instanceof DetailRow)&&r<i.length-1;)r++;var o=i[r];if(o instanceof DetailRow){var l=o.detail.parentElement;if(l)for(var n=l.querySelectorAll(".wj-control"),a=0;a<n.length;a++){var s=wijmo_1.Control.getControl(n[a]);s&&s.containsFocus()&&t.focus(!0)}var d=this.disposeDetailCell;!!d&&d(o)||wijmo_1.Control.disposeAll(o.detail);i.removeAt(r)}}else for(var _=0;_<i.length;_++)i[_]instanceof DetailRow&&this.hideDetail(_)};FlexGridDetailProvider.prototype.showDetail=function(e,t){void 0===t&&(t=!1);var i=this._g,r=i.rows,o=this._toIndex(e);o>0&&r[o]instanceof DetailRow&&o--;for(var l=r[o].dataItem;o<r.length-1&&r[o+1].dataItem==l;)o++;if(t){for(var n=i.selection,a=!1,s=0;s<r.length-1;s++)if(s!=o&&r[s+1]instanceof DetailRow){this.hideDetail(s);s<o&&o--;if(s<n.row){n.row--;n.row2--;a=!0}}a&&i.select(n,!1)}if(!this.isDetailVisible(o)&&this._hasDetail(o)){var d=new DetailRow(r[o]),_=this._createDetailCell(r[o]);d.detail=_;if(_){r.insert(o+1,d);var c=i.containsFocus();if(this._animated){var u=_.style;u.transform="translateY(-100%)";u.opacity="0";wijmo_1.animate((function(e){if(e<1){u.transform="translateY("+(100*-(1-e)).toFixed(0)+"%)";u.opacity=(e*e).toString()}else{u.transform=u.opacity="";wijmo_1.Control.invalidateAll(_);c&&i.scrollIntoView(o+1,-1)}}))}else c&&i.scrollIntoView(o+1,-1,!0)}}};FlexGridDetailProvider.prototype._sizeDetailRow=function(e){var t=this._g,i=e.detail;wijmo_1.Control.refreshAll(i);var r=i.offsetHeight+t._cellPadVert+1,o=this._maxHeight;wijmo_1.isNumber(o)&&o>0&&r>o&&(r=o);e.height=r;i.style.height||(i.style.height="100%");var l=i.querySelector(".wj-flexgrid");l&&!l.style.height&&(l.style.height="100%")};FlexGridDetailProvider.prototype._handleFrozenCells=function(){var e=this._g,t=e.hostElement,i=wijmo_1.Control.getControl(t.querySelector(".wj-flexgrid"));if(i instanceof wijmo_grid_1.FlexGrid&&(i.frozenRows||i.frozenColumns)){wijmo_1.setCss([e._eTL,e._eBL,e._eCHdr,e._eCFtr,e._eRHdr,e._eMarquee],{zIndex:"13"});for(var r=t.querySelectorAll(".wj-frozen"),o=0;o<r.length;o++){var l=r[o];if(wijmo_1.closest(l,".wj-flexgrid")==t){var n=parseInt(l.style.zIndex);l.style.zIndex=(n%10+10).toString()}}}};FlexGridDetailProvider.prototype._toIndex=function(e){return e instanceof wijmo_grid_1.Row?e.index:wijmo_1.asNumber(e)};FlexGridDetailProvider.prototype._hdrClick=function(e){if(!e.defaultPrevented&&0==e.button&&wijmo_1.closestClass(e.target,FlexGridDetailProvider._WJC_DETAIL)){var t=DetailVisibilityMode;switch(this._mode){case t.ExpandMulti:case t.ExpandSingle:var i=this._g,r=i.hitTest(e.target);r.panel||(r=i.hitTest(e));r.panel&&this._toggleRowDetail(r.row)&&e.preventDefault()}}};FlexGridDetailProvider.prototype._toggleRowDetail=function(e){if(e>-1){if(this.isDetailVisible(e)){this.hideDetail(e);return!0}if(this._hasDetail(e)){var t=this._g;t.select(new wijmo_grid_1.CellRange(e,0,e,t.columns.length-1));this.showDetail(e,this._mode==DetailVisibilityMode.ExpandSingle);return!0}}return!1};FlexGridDetailProvider.prototype._selectionChanged=function(e,t){var i=this;if(this._mode==DetailVisibilityMode.Selection){this._toSel&&clearTimeout(this._toSel);this._toSel=setTimeout((function(){var t=e._selHdl.selection.row;t>-1?i.showDetail(t,!0):i.hideDetail()}),300)}};FlexGridDetailProvider.prototype._formatItem=function(e,t){var i=this._g,r=t.cell,o=t.getRow(),l=DetailVisibilityMode;if(t.panel==i.cells&&o instanceof DetailRow&&null!=o.detail&&!wijmo_1.hasClass(r,"wj-detail")){wijmo_1.addClass(r,"wj-detail");r.textContent="";r.style.textAlign=r.style.zIndex="";r.className=r.className.replace(/wj\-align\-[\S]+/g,"");r.appendChild(o.detail);null==o.height?this._sizeDetailRow(o):wijmo_1.Control.refreshAll(o.detail)}if(t.panel==i.rowHeaders&&0==t.col&&this._hasDetail(t.row)){r.style.cursor="";switch(this._mode){case l.ExpandMulti:case l.ExpandSingle:var n=this.isDetailVisible(t.row),a=n?"minus":"plus",s=FlexGridDetailProvider._WJC_DETAIL;r.innerHTML='<div class="wj-btn wj-btn-glyph '+s+'" role="button" tabindex="-1"><span class="wj-glyph-'+a+'"></span></div>';var d=r.children[0],_=wijmo_1.culture.FlexGridDetailProvider.ariaLabels.toggleDetail;wijmo_1.setAriaLabel(d,_);wijmo_1.setAttribute(d,"aria-expanded",n)}}};FlexGridDetailProvider.prototype._resizedRow=function(e,t){var i=t.getRow();i instanceof DetailRow&&i.detail&&wijmo_1.Control.refreshAll(i.detail)};FlexGridDetailProvider.prototype._hasDetail=function(e){var t=this._g.rows[e];return wijmo_1.isFunction(this._rowHasDetailFn)?this._rowHasDetailFn(t):this._isRegularRow(t)};FlexGridDetailProvider.prototype._isRegularRow=function(e){return!(e instanceof wijmo_grid_1._NewRowTemplate||e instanceof DetailRow)&&!(e instanceof wijmo_grid_1.GroupRow&&!this._g.childItemsPath)};FlexGridDetailProvider.prototype._createDetailCell=function(e){return this.createDetailCell?this.createDetailCell(e):null};FlexGridDetailProvider._WJC_DETAIL="wj-elem-detail";return FlexGridDetailProvider}();exports.FlexGridDetailProvider=FlexGridDetailProvider;wijmo_1._registerModule("wijmo.grid.detail",selfModule);