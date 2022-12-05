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

"use strict";var __extends=this&&this.__extends||function(){var extendStatics=function(e,t){return(extendStatics=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var l in t)t.hasOwnProperty(l)&&(e[l]=t[l])})(e,t)};return function(e,t){extendStatics(e,t);function __(){this.constructor=e}e.prototype=null===t?Object.create(t):(__.prototype=t.prototype,new __)}}(),__importStar=this&&this.__importStar||function(e){if(e&&e.__esModule)return e;var t={};if(null!=e)for(var l in e)Object.hasOwnProperty.call(e,l)&&(t[l]=e[l]);t.default=e;return t};Object.defineProperty(exports,"__esModule",{value:!0});var wijmo_1=require("wijmo/wijmo"),wjcCore=__importStar(require("wijmo/wijmo")),wjcGrid=__importStar(require("wijmo/wijmo.grid")),selfModule=__importStar(require("wijmo/wijmo.interop.grid"));function softInput(){return wijmo_1._getModule("wijmo.input")}exports.softInput=softInput;function softGridDetail(){return wijmo_1._getModule("wijmo.grid.detail")}exports.softGridDetail=softGridDetail;var __gridCFRef=wjcGrid&&wjcGrid.CellFactory;if(!__gridCFRef){window.wijmo.grid={};window.wijmo.grid.CellFactory=function(){}}var GridCellTemplateType,DirectiveCellFactoryBase=function(e){__extends(DirectiveCellFactoryBase,e);function DirectiveCellFactoryBase(t){var l=e.call(this)||this;l._lastApplyTimeStamp=0;l._noApplyLag=!1;l._startingEditing=!1;l._cellStampCounter=0;l._composing=!1;l.grid=t;if(!DirectiveCellFactoryBase._templateTypes){DirectiveCellFactoryBase._templateTypes=[];for(var i in GridCellTemplateType)isNaN(i)&&DirectiveCellFactoryBase._templateTypes.push(i)}var r=l;l._baseCf=t.cellFactory;t.cellFactory=l;l._evtInput=document.createEvent("HTMLEvents");l._evtInput.initEvent("input",!0,!1);l._evtBlur=document.createEvent("HTMLEvents");l._evtBlur.initEvent("blur",!1,!1);t.prepareCellForEdit.addHandler((function(e,t){r._noApplyLag=!0}));t.cellEditEnded.addHandler((function(e,l){var i=l.range,o=i.col;(o<0||o<t.columns.length&&!t._getBindingColumn(t.cells,i.row,t.columns[o])[DirectiveCellFactoryBase.getTemplContextProp(GridCellTemplateType.CellEdit)])&&(r._editChar=null);setTimeout((function(){r._noApplyLag=!1}),300)}));t.beginningEdit.addHandler((function(e,t){r._startingEditing=!0}));t.hostElement.addEventListener("keydown",(function(e){r._startingEditing=!1}),!0);t.hostElement.addEventListener("keypress",(function(e){var l=e.charCode>32?String.fromCharCode(e.charCode):null;if(l&&wjcCore.closest(e.target,".wj-flexgrid")===t.hostElement)if(!t.activeEditor||r._startingEditing){r._editChar=l;setTimeout((function(){t.activeEditor||(r._editChar=null)}),0)}else r._editChar&&(r._editChar+=l)}),!0);t.hostElement.addEventListener("compositionstart",(function(e){r._composing=!0}),!0);t.hostElement.addEventListener("compositionend",(function(e){r._composing=!1}),!0);return l}DirectiveCellFactoryBase.prototype.updateCell=function(e,t,l,i,r){var o=this;this._cellStampCounter=(this._cellStampCounter+1)%1e7;var n=i[DirectiveCellFactoryBase._cellStampProp]=this._cellStampCounter;i.style.overflow&&(i.style.overflow="");var a=t,s=l;if(r&&!r.isSingleCell){t=r.row;l=r.col}var c,d=this,p=e.grid,u=p.editRange,C=e.rows[t],m=C.dataItem,f=!1,v=!1,_=!1,y=!1;switch(e.cellType){case wjcGrid.CellType.Cell:if(u&&u.row===t&&u.col===l){c=GridCellTemplateType.CellEdit;v=_=!0}else if(C instanceof wjcGrid.GroupRow){var w=!((y=m instanceof wjcCore.CollectionViewGroup)||C.hasChildren);if(l==e.columns.firstVisibleIndex)c=w?GridCellTemplateType.Cell:GridCellTemplateType.GroupHeader;else{c=w?GridCellTemplateType.Cell:GridCellTemplateType.Group;v=!0}}else C instanceof wjcGrid._NewRowTemplate?c=GridCellTemplateType.NewCellTemplate:softGridDetail()&&softGridDetail().DetailRow&&C instanceof softGridDetail().DetailRow||(c=GridCellTemplateType.Cell);break;case wjcGrid.CellType.ColumnHeader:c=GridCellTemplateType.ColumnHeader;break;case wjcGrid.CellType.RowHeader:c=p.collectionView&&p.collectionView.currentEditItem===m?GridCellTemplateType.RowHeaderEdit:GridCellTemplateType.RowHeader;f=!0;break;case wjcGrid.CellType.TopLeft:c=GridCellTemplateType.TopLeft;f=!0;break;case wjcGrid.CellType.ColumnFooter:c=GridCellTemplateType.ColumnFooter;v=!0;break;case wjcGrid.CellType.BottomLeft:c=GridCellTemplateType.BottomLeft;f=!0}var g=!1;if(null!=c){var h=null;y&&c==GridCellTemplateType.GroupHeader?h=p.getColumn(m.groupDescription.propertyName):l>=0&&l<e.columns.length&&(h=e.cellType===wjcGrid.CellType.ColumnHeader&&p._hasColumnGroups()?p._getColumnGroup(t,l):p._getBindingColumn(e,t,e.columns[l]));if(h){var E=DirectiveCellFactoryBase.getTemplContextProp,T=E(c),F=(f?p:h)[T];if(!F)if(c===GridCellTemplateType.RowHeaderEdit){T=E(c=GridCellTemplateType.RowHeader);F=p[T]}else if((c===GridCellTemplateType.Group||c===GridCellTemplateType.GroupHeader)&&!y){T=E(c=GridCellTemplateType.Cell);F=h[T]}if(F){var j;v&&(j=e.getCellData(t,l,!1));g=!0;var G=i.getAttribute(wjcGrid.FlexGrid._WJS_MEASURE),D=G&&"true"===G.toLowerCase();if(_){this.clearCell(i);this._baseCf.updateCell(e,a,s,i,r,!0)}var B,I=_&&p.imeEnabled,H=I&&this._composing,S=i[T],x={cell:i,column:h,row:C,panel:e,rng:r,isEdit:_,isImeInput:I,isTrueImeInput:H,templateContext:F,templateCache:S,templateContextProperty:T,cellStamp:n,cellValue:j};if(this.shouldInstantiate(x)){if(_){var b=i.firstElementChild;if(b){I||i.focus();b.style.display="none"}}else this.clearCell(i);this._doDisposeCell(i);this.renderTemplate(x,!0);x.templateCache=S=i[T];B=x.cellBindingsData}else{this.renderTemplate(x,!1);B=x.cellBindingsData}F.cellOverflow&&(i.style.overflow=F.cellOverflow);D?this.applyImmediately(x):F.autoSizeRows&&!I?this.checkHeight(x):_&&setTimeout((function(){I?o._initImeEditInput(S,F):o._initEditInput(S,F,null)}),0);if(_){d._cellEditorVars=B.localVars;var editEndingEH=function(e,t){p.cellEditEnding.removeHandler(editEndingEH);if(!t.stayInEditMode){var l=wjcCore.getActiveElement();l&&l.dispatchEvent(d._evtBlur);wjcCore.contains(i,wjcCore.getActiveElement())&&i.focus()}d._triggerEditorEvents(i);if(!t.cancel&&!t.stayInEditMode)for(var r=B.localVars,o=0,n=Object.getOwnPropertyNames(B.bindings);o<n.length;o++){var a=n[o];B.bindings[a].setValue(r,B.localVars.values[a])}var s=i.querySelectorAll(".wj-dropdown");[].forEach.call(s,(function(e){var t=wjcCore.Control.getControl(e);t&&softInput()&&t instanceof softInput().DropDown&&(t.isDroppedDown=!1)}))},editEndedEH_1=function(e,t){p.cellEditEnded.removeHandler(editEndedEH_1);d._cellEditorVars=null};p.cellEditEnding.addHandler(editEndingEH);p.cellEditEnded.addHandler(editEndedEH_1)}else this._baseCf.updateCell(e,a,s,i,r,!1)}}}if(!g){this._doDisposeCell(i);this._baseCf.updateCell(e,a,s,i,r)}};DirectiveCellFactoryBase.prototype.getEditorValue=function(t){if(this._cellEditorVars){var l=t.editRange;l&&l.isValid&&this._triggerEditorEvents(t.cells.getCellElement(l.row,l.col));return this._cellEditorVars.value}return e.prototype.getEditorValue.call(this,t)};DirectiveCellFactoryBase.prototype.disposeCell=function(e){this._doDisposeCell(e)};DirectiveCellFactoryBase.prototype.disposeTemplate=function(e,t,l){if(t){t.rootElement=null;t.column=null;e[t.templateContextProperty]=null;t.templateContextProperty=null}};DirectiveCellFactoryBase.prototype.setBindingsData=function(e,t,l,i,r,o){e.row=t;e.col=l;e.item=i;var n={},a=e.cell||{},s={},c={localVars:a,bindings:s};a.row=t;a.col=l;a.item=i;a.value=r;a.values=n;if(o)for(var d=0,p=Object.getOwnPropertyNames(o);d<p.length;d++){var u=p[d],C=new wjcCore.Binding(o[u]);s[u]=C;n[u]=C.getValue(a)}e.cell!==a&&(e.cell=a);return c};DirectiveCellFactoryBase.prototype.checkHeight=function(e){var t=this;setTimeout((function(){var l=e.cell;if(e.cellStamp===l[DirectiveCellFactoryBase._cellStampProp]){var i=l.scrollHeight,r=e.panel.rows,o=e.row.index,n=e.rng,a=n&&n.rowSpan||1,s=e.isEdit;null!=r.maxSize&&(i=Math.min(i,r.maxSize));if(o<r.length&&r[o].renderHeight*a<i-1){var c=r.defaultSize=i/a;if(s){var d=t._isFullEdit(),p=t.grid;p.autoRowHeights&&(e.row.height=c);p.refresh();p.startEditing(d);return}}else s&&(e.isImeInput?t._initImeEditInput(e.templateCache,e.templateContext):t._initEditInput(e.templateCache,e.templateContext,null))}}),0)};DirectiveCellFactoryBase.prototype.doDisposeCell=function(e){for(var t=DirectiveCellFactoryBase._templateTypes,l=0;l<t.length;l++){var i=DirectiveCellFactoryBase.getTemplContextProp(GridCellTemplateType[t[l]]),r=e[i];if(r){var o=(r.column||this.grid)[i];this.disposeTemplate(e,r,o)}}};DirectiveCellFactoryBase.getTemplContextProp=function(e){return"$__cellTempl"+GridCellTemplateType[e]};DirectiveCellFactoryBase.prototype._doDisposeCell=function(e){this.doDisposeCell(e)};DirectiveCellFactoryBase.prototype._initEditInput=function(e,t,l){var i=this,r=!1!==this.getEditorFocusFlag();this.setEditorFocusFlag(null);this._setFullEdit(t);if(r){var o=this._findInitialInput(e);if(o){var inpFocusEh=function(){o.removeEventListener("focus",inpFocusEh);setTimeout((function(){setTimeout((function(){var e=null!=l?l:i._editChar;if(e){o.value=e;i._editChar=null;DirectiveCellFactoryBase._setSelectionRange(o,e.length,e.length);o.dispatchEvent(i._evtInput)}}),0)}),DirectiveCellFactoryBase._FOCUS_INTERVAL)};o.addEventListener("focus",inpFocusEh);o.focus()}}};DirectiveCellFactoryBase.prototype._initImeEditInput=function(e,t){var l=this,i=wjcCore.getActiveElement();if(i&&(i instanceof HTMLInputElement||i instanceof HTMLTextAreaElement)&&wjcCore.hasClass(i,"wj-grid-ime")){var r=this._findInitialInput(e),o=r&&r.style.color,n=this._composing,compEndEh_1=function(){i.removeEventListener("compositionend",compEndEh_1);wjcCore.setCss(i,wjcGrid._ImeHandler._cssHidden);l.setEditorFocusFlag(!0);r&&(r.style.color=o);l._initEditInput(e,t,n?i.value:null)};if(n){i.addEventListener("compositionend",compEndEh_1);if(r){var a=r.getBoundingClientRect(),s=i.getBoundingClientRect(),c=window.getComputedStyle(i),d=parseFloat(c.left),p=parseFloat(c.top);wjcCore.setCss(i,{left:d+a.left-s.left+"px",top:p+a.top-s.top+"px",width:a.width+"px",height:a.height+"px"});r.style.color="transparent"}}else setTimeout((function(){return compEndEh_1()}),DirectiveCellFactoryBase._FOCUS_INTERVAL)}};DirectiveCellFactoryBase.prototype._findInitialInput=function(e){var t=e&&e.rootElement&&e.rootElement.querySelectorAll("input,textarea");if(t)for(var l=0;l<t.length;l++){var i=t[l],r=window.getComputedStyle(i);if("none"!==r.display&&"visible"===r.visibility)return i}return null};DirectiveCellFactoryBase._setSelectionRange=function(e,t,l){void 0===l&&(l=t);if(wjcCore.contains(document.body,e)&&!e.disabled&&"none"!=e.style.display)try{e.setSelectionRange(wjcCore.asNumber(t),wjcCore.asNumber(l),wjcCore.isIE()?null:"backward");e.focus()}catch(e){}};DirectiveCellFactoryBase.prototype._triggerEditorEvents=function(e){if(e)for(var t=e.querySelectorAll(".wj-control"),l=0;l<t.length;l++){var i=t[l],r=wjcCore.Control.getControl(i);r&&this.flushPendingEvents(r)}};DirectiveCellFactoryBase.prototype._isFullEdit=function(){var e=this.grid;return!e.activeEditor||e._edtHdl._fullEdit};DirectiveCellFactoryBase.prototype._setFullEdit=function(e){var t=this.grid;e.forceFullEdit&&t.activeEditor&&(t._edtHdl._fullEdit=!0)};DirectiveCellFactoryBase._cellStampProp="__wjCellStamp";DirectiveCellFactoryBase._FOCUS_INTERVAL=wjcCore.Control._FOCUS_INTERVAL+20;return DirectiveCellFactoryBase}(wjcGrid.CellFactory);exports.DirectiveCellFactoryBase=DirectiveCellFactoryBase;__gridCFRef||(window.wijmo.grid=null);!function(e){e[e.Cell=0]="Cell";e[e.CellEdit=1]="CellEdit";e[e.ColumnHeader=2]="ColumnHeader";e[e.RowHeader=3]="RowHeader";e[e.RowHeaderEdit=4]="RowHeaderEdit";e[e.TopLeft=5]="TopLeft";e[e.GroupHeader=6]="GroupHeader";e[e.Group=7]="Group";e[e.NewCellTemplate=8]="NewCellTemplate";e[e.ColumnFooter=9]="ColumnFooter";e[e.BottomLeft=10]="BottomLeft"}(GridCellTemplateType=exports.GridCellTemplateType||(exports.GridCellTemplateType={}));wijmo_1._registerModule("wijmo.interop.grid",selfModule);