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

import{_addCultureInfo,Key,Control,culture,copy,asEnum,asNumber,asBoolean,asFunction,isFunction,isNumber,animate,setCss,closest,closestClass,addClass,hasClass,setAriaLabel,setAttribute,_registerModule}from"wijmo/wijmo";import{Row,FlexGrid,MergeManager,CellRange,CellType,_NewRowTemplate,GroupRow}from"wijmo/wijmo.grid";import*as selfModule from"wijmo/wijmo.grid.detail";export class DetailRow extends Row{constructor(e){super();this.isReadOnly=!0}get detail(){return this._detail}set detail(e){this._detail=e}}export class DetailMergeManager extends MergeManager{constructor(e){super();this._originalMergeManager=e.mergeManager}getMergedRange(e,t,i,l=!0){switch(e.cellType){case CellType.Cell:if(e.rows[t]instanceof DetailRow){e.columns.frozen>0&&e.grid&&(e.grid.cloneFrozenCells=!1);return new CellRange(t,0,t,e.columns.length-1)}break;case CellType.RowHeader:let l=_isFrozen(e,t),s=_isNew(e,t),a=e.rows[t].dataItem;!a&&t>0&&e.rows[t]instanceof DetailRow&&(a=e.rows[t-1].dataItem);let o=t;for(;o>0&&e.rows[o-1].dataItem==a&&_isFrozen(e,o-1)==l&&_isNew(e,o-1)==s;)o--;let n=t;for(;n<e.rows.length-1&&e.rows[n+1].dataItem==a&&_isFrozen(e,n+1)==l&&_isNew(e,n+1)==s;)n++;n<e.rows.length-1&&e.rows[n+1]instanceof DetailRow&&_isFrozen(e,n+1)==l&&_isNew(e,n+1)==s&&n++;return o!=n?new CellRange(o,i,n,i):null}return this._originalMergeManager.getMergedRange(e,t,i,l)}}function _isFrozen(e,t){return t<e.rows.frozen}function _isNew(e,t){return e.rows[t]instanceof _NewRowTemplate}_addCultureInfo("FlexGridDetailProvider",{ariaLabels:{toggleDetail:"Toggle Row Detail"}});export var KeyAction;!function(e){e[e.None=0]="None";e[e.ToggleDetail=1]="ToggleDetail"}(KeyAction||(KeyAction={}));export var DetailVisibilityMode;!function(e){e[e.Code=0]="Code";e[e.Selection=1]="Selection";e[e.ExpandSingle=2]="ExpandSingle";e[e.ExpandMulti=3]="ExpandMulti"}(DetailVisibilityMode||(DetailVisibilityMode={}));export class FlexGridDetailProvider{constructor(e,t){this._maxHeight=null;this._mode=DetailVisibilityMode.ExpandSingle;this._animated=!1;this._keyActionEnter=KeyAction.None;this._g=e;e.mergeManager=new DetailMergeManager(e);e.rowHeaders.hostElement.addEventListener("click",this._hdrClick.bind(this));e.rowHeaders.hostElement.addEventListener("mousedown",t=>{let i=e.editableCollectionView;if(e.activeEditor||i&&i.currentEditItem){this._hdrClick(t);t.preventDefault()}});setTimeout(()=>{e.formatItem.addHandler(this._formatItem,this)},100);e.selectionChanged.addHandler(this._selectionChanged,this);e.resizedRow.addHandler(this._resizedRow,this);e.loadingRows.addHandler(()=>this.hideDetail());e.deletingRow.addHandler((e,t)=>{this.hideDetail(t.row)});e.updatedView.addHandler(this._handleFrozenCells,this);e.cloneFrozenCells=!1;e.draggingRow.addHandler((e,t)=>{if(t.row<e.rows.length-1&&e.rows[t.row+1]instanceof DetailRow){t.cancel=!0;this.hideDetail(t.row)}});e.hostElement.addEventListener("keydown",e=>{if(e.keyCode==Key.Enter&&this._keyActionEnter==KeyAction.ToggleDetail){let t=this._g.selection.row;this._toggleRowDetail(t)&&e.preventDefault()}},!0);e._root.addEventListener("scroll",()=>{Control.refreshAll(e._root)});copy(this,t)}get grid(){return this._g}get detailVisibilityMode(){return this._mode}set detailVisibilityMode(e){if((e=asEnum(e,DetailVisibilityMode))!=this._mode){this._mode=e;this.hideDetail();this._g.invalidate()}}get maxHeight(){return this._maxHeight}set maxHeight(e){if((e=asNumber(e,!0))!=this._maxHeight){this._maxHeight=e;this.hideDetail()}}get isAnimated(){return this._animated}set isAnimated(e){e!=this._animated&&(this._animated=asBoolean(e))}get keyActionEnter(){return this._keyActionEnter}set keyActionEnter(e){this._keyActionEnter=asEnum(e,KeyAction)}get createDetailCell(){return this._createDetailCellFn}set createDetailCell(e){this._createDetailCellFn=asFunction(e,!0)}get disposeDetailCell(){return this._disposeDetailCellFn}set disposeDetailCell(e){this._disposeDetailCellFn=asFunction(e,!0)}get rowHasDetail(){return this._rowHasDetailFn}set rowHasDetail(e){if((e=asFunction(e,!0))!=this._rowHasDetailFn){this._rowHasDetailFn=e;this.hideDetail();this._g.invalidate()}}getDetailRow(e){let t=this._g.rows,i=this._toIndex(e),l=t[i].dataItem;for(;i<t.length;i++){let e=t[i];if(e instanceof DetailRow)return e;if(e.dataItem!=l)return null}return null}isDetailVisible(e){return null!=this.getDetailRow(e)}isDetailAvailable(e){e=this._toIndex(e);return this._hasDetail(e)}hideDetail(e){let t=this._g,i=t.rows;if(null==e){for(let e=0;e<i.length;e++)i[e]instanceof DetailRow&&this.hideDetail(e);return}let l=this._toIndex(e);for(;!(i[l]instanceof DetailRow)&&l<i.length-1;)l++;let s=i[l];if(s instanceof DetailRow){let e=s.detail.parentElement;if(e){let i=e.querySelectorAll(".wj-control");for(let e=0;e<i.length;e++){let l=Control.getControl(i[e]);l&&l.containsFocus()&&t.focus(!0)}}let a=this.disposeDetailCell;!!a&&a(s)||Control.disposeAll(s.detail);i.removeAt(l)}}showDetail(e,t=!1){let i=this._g,l=i.rows,s=this._toIndex(e);s>0&&l[s]instanceof DetailRow&&s--;let a=l[s].dataItem;for(;s<l.length-1&&l[s+1].dataItem==a;)s++;if(t){let e=i.selection,t=!1;for(let i=0;i<l.length-1;i++)if(i!=s&&l[i+1]instanceof DetailRow){this.hideDetail(i);i<s&&s--;if(i<e.row){e.row--;e.row2--;t=!0}}t&&i.select(e,!1)}if(!this.isDetailVisible(s)&&this._hasDetail(s)){let e=new DetailRow(l[s]),t=this._createDetailCell(l[s]);e.detail=t;if(t){l.insert(s+1,e);let a=i.containsFocus();if(this._animated){let e=t.style;e.transform="translateY(-100%)";e.opacity="0";animate(l=>{if(l<1){e.transform="translateY("+(100*-(1-l)).toFixed(0)+"%)";e.opacity=(l*l).toString()}else{e.transform=e.opacity="";Control.invalidateAll(t);a&&i.scrollIntoView(s+1,-1)}})}else a&&i.scrollIntoView(s+1,-1,!0)}}}_sizeDetailRow(e){let t=this._g,i=e.detail;Control.refreshAll(i);let l=i.offsetHeight+t._cellPadVert+1,s=this._maxHeight;isNumber(s)&&s>0&&l>s&&(l=s);e.height=l;i.style.height||(i.style.height="100%");let a=i.querySelector(".wj-flexgrid");a&&!a.style.height&&(a.style.height="100%")}_handleFrozenCells(){let e=this._g,t=e.hostElement,i=Control.getControl(t.querySelector(".wj-flexgrid"));if(i instanceof FlexGrid&&(i.frozenRows||i.frozenColumns)){setCss([e._eTL,e._eBL,e._eCHdr,e._eCFtr,e._eRHdr,e._eMarquee],{zIndex:"13"});let i=t.querySelectorAll(".wj-frozen");for(let e=0;e<i.length;e++){let l=i[e];if(closest(l,".wj-flexgrid")==t){let e=parseInt(l.style.zIndex);l.style.zIndex=(e%10+10).toString()}}}}_toIndex(e){return e instanceof Row?e.index:asNumber(e)}_hdrClick(e){if(!e.defaultPrevented&&0==e.button&&closestClass(e.target,FlexGridDetailProvider._WJC_DETAIL)){let t=DetailVisibilityMode;switch(this._mode){case t.ExpandMulti:case t.ExpandSingle:let i=this._g,l=i.hitTest(e.target);l.panel||(l=i.hitTest(e));l.panel&&this._toggleRowDetail(l.row)&&e.preventDefault()}}}_toggleRowDetail(e){if(e>-1){if(this.isDetailVisible(e)){this.hideDetail(e);return!0}if(this._hasDetail(e)){let t=this._g;t.select(new CellRange(e,0,e,t.columns.length-1));this.showDetail(e,this._mode==DetailVisibilityMode.ExpandSingle);return!0}}return!1}_selectionChanged(e,t){if(this._mode==DetailVisibilityMode.Selection){this._toSel&&clearTimeout(this._toSel);this._toSel=setTimeout(()=>{let t=e._selHdl.selection.row;t>-1?this.showDetail(t,!0):this.hideDetail()},300)}}_formatItem(e,t){let i=this._g,l=t.cell,s=t.getRow(),a=DetailVisibilityMode;if(t.panel==i.cells&&s instanceof DetailRow&&null!=s.detail&&!hasClass(l,"wj-detail")){addClass(l,"wj-detail");l.textContent="";l.style.textAlign=l.style.zIndex="";l.className=l.className.replace(/wj\-align\-[\S]+/g,"");l.appendChild(s.detail);null==s.height?this._sizeDetailRow(s):Control.refreshAll(s.detail)}if(t.panel==i.rowHeaders&&0==t.col&&this._hasDetail(t.row)){l.style.cursor="";switch(this._mode){case a.ExpandMulti:case a.ExpandSingle:let e=this.isDetailVisible(t.row),i=e?"minus":"plus",s=FlexGridDetailProvider._WJC_DETAIL;l.innerHTML='<div class="wj-btn wj-btn-glyph '+s+'" role="button" tabindex="-1"><span class="wj-glyph-'+i+'"></span></div>';let o=l.children[0],n=culture.FlexGridDetailProvider.ariaLabels.toggleDetail;setAriaLabel(o,n);setAttribute(o,"aria-expanded",e)}}}_resizedRow(e,t){let i=t.getRow();i instanceof DetailRow&&i.detail&&Control.refreshAll(i.detail)}_hasDetail(e){let t=this._g.rows[e];return isFunction(this._rowHasDetailFn)?this._rowHasDetailFn(t):this._isRegularRow(t)}_isRegularRow(e){return!(e instanceof _NewRowTemplate||e instanceof DetailRow)&&!(e instanceof GroupRow&&!this._g.childItemsPath)}_createDetailCell(e){return this.createDetailCell?this.createDetailCell(e):null}}FlexGridDetailProvider._WJC_DETAIL="wj-elem-detail";_registerModule("wijmo.grid.detail",selfModule);