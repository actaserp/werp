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

"use strict";var __importStar=this&&this.__importStar||function(e){if(e&&e.__esModule)return e;var t={};if(null!=e)for(var o in e)Object.hasOwnProperty.call(e,o)&&(t[o]=e[o]);t.default=e;return t};Object.defineProperty(exports,"__esModule",{value:!0});const wijmo_1=require("wijmo/wijmo"),wijmo_grid_1=require("wijmo/wijmo.grid"),selfModule=__importStar(require("wijmo/wijmo.grid.multirow"));class _MultiRowSelectionHandler extends wijmo_grid_1._SelectionHandler{_getNextColumnCell(e,t,o,l=0){const s=this._g,i=s.cells,r=s.columns,n=wijmo_grid_1.SelMove;switch(o){case n.NextEditableCell:for(let o=t+1;o<r.length;o++){let t=s._getBindingColumn(i,e,r[o]);if(t.renderSize>0&&!t.isReadOnly)return o}return t;case n.PrevEditableCell:for(let o=t-1;o>=0;o--){let t=s._getBindingColumn(i,e,r[o]);if(t.renderSize>0&&!t.isReadOnly)return o}return t}return super._getNextColumnCell(e,t,o,l)}}exports._MultiRowSelectionHandler=_MultiRowSelectionHandler;class _MultiRow extends wijmo_grid_1.Row{constructor(e,t,o){super(e);this._idxData=t;this._idxRecord=o}get recordIndex(){return this._idxRecord}}exports._MultiRow=_MultiRow;class _MultiGroupRow extends wijmo_grid_1.GroupRow{constructor(e,t){super(e);this._idxRecord=t}get recordIndex(){return this._idxRecord}get hasChildren(){return!0}getCellRange(){let e=this._getLastRowInHeader();return e!=this?e.getCellRange():super.getCellRange()}get isCollapsed(){return this._getLastRowInHeader()._getFlag(wijmo_grid_1.RowColFlags.Collapsed)}set isCollapsed(e){let t=this._getLastRowInHeader();e!=t.isCollapsed&&null!=t._list&&t._setCollapsed(wijmo_1.asBoolean(e))}_setCollapsed(e){let t=this.grid,o=t.rows,l=this.getCellRange(),s=new wijmo_grid_1.CellRangeEventArgs(t.cells,new wijmo_grid_1.CellRange(this.index,-1));if(t.onGroupCollapsedChanging(s)){t.deferUpdate(()=>{o.deferUpdate(()=>{this._setFlag(wijmo_grid_1.RowColFlags.Collapsed,e,!0);for(let t=l.topRow+1;t<=l.bottomRow&&t>-1&&t<o.length;t++){o[t]._setFlag(wijmo_grid_1.RowColFlags.ParentCollapsed,e,!0);let l=o[t];if(l instanceof _MultiGroupRow){let s=l._getLastRowInHeader();for(t+=1;t<=s.index;t++)(l=o[t])._setFlag(wijmo_grid_1.RowColFlags.ParentCollapsed,e,!0);t--}l instanceof wijmo_grid_1.GroupRow&&l.isCollapsed&&(t=l.getCellRange().bottomRow)}})});t.onGroupCollapsedChanged(s)}}_getLastRowInHeader(){let e=this.grid,t=this;if(e&&e.multiRowGroupHeaders){let o=e.rows,l=this.dataItem;for(let e=this.index+1;e<o.length&&o[e].dataItem==l;e++)t=o[e]}wijmo_1.assert(t instanceof _MultiGroupRow,"last row in header should be a _MultiRowGroup");return t}}exports._MultiGroupRow=_MultiGroupRow;class MultiRowCellCollection extends wijmo_1.ObservableArray{_setLayout(e){this._layout=e;this.forEach(t=>t._setLayout(e))}onCollectionChanged(e=wijmo_1.NotifyCollectionChangedEventArgs.reset){const t=this._layout;t&&t._onLayoutChanged();super.onCollectionChanged(e)}}exports.MultiRowCellCollection=MultiRowCellCollection;class _MultiRowLayout{constructor(e,t,o){this._initialized=!1;this._disposed=!1;this._rowsPerItem=1;this._groupsByColumn={};this._grid=e;this._changeCallback=o;this._bindingGroups=this._parseCellGroups(t);this._initialized=!0}_dispose(){if(this._disposed)return;this._disposed=!0;const e=this._bindingGroups;e.forEach(e=>{e.cells._setLayout(null)});e._setLayout(null);this._bindingGroups=null}_onLayoutChanged(){this._initialized&&!this._disposed&&this._changeCallback&&this._changeCallback()}_parseCellGroups(e){let t=this._grid,o=null,l=1;if(e){if(e instanceof MultiRowCellCollection){e.forEach(e=>{wijmo_1.assert(e instanceof MultiRowCellGroup,"groups contain items of invalid type")});o=e}else{o=new MultiRowCellCollection;for(let t=0;t<e.length;t++){let l=null;l=e[t]instanceof MultiRowCellGroup?e[t]:new MultiRowCellGroup(e[t]);o.push(l)}}o.forEach(e=>{e.openGroup()});for(let e=0,t=0;e<o.length;e++){let s=o[e];s._colstart=t;t+=s._colspanEff;l=Math.max(l,s._rowspanEff)}o.forEach(e=>{e.closeGroup(t,l)});this._rowsPerItem=l}else o=new MultiRowCellCollection;this._multiRowGroupHeaderRange=this._getMultiRowGroupHeaderRange(o);o.forEach(e=>{e.cells._setLayout(this)});o._setLayout(this);return o}_getMultiRowGroupHeaderRange(e){const t=this._rowsPerItem,o=new wijmo_grid_1.CellRange(0,0,t-1,0);for(let t=0;t<e.length;t++){const l=e[t];if(l._hasAggregates){0===t&&this._expandMultiRowGroupHeaderToAggregate(o,l);return o}o.col2=l._colstart+l._colspanEff-1}return o}_expandMultiRowGroupHeaderToAggregate(e,t){const o=this._rowsPerItem,l=t._colspanEff,s=t.cells.filter(e=>e.col>0&&0!=e.aggregate).map(e=>e.col).reduce((e,t)=>t<e?t:e,l);e.col2=Math.max(t._colstart+s-1,e.col2);for(let i=s;i<l;i++){let l=!0;for(let e=0;e<o;e++){const o=t._getCellRange(e,i);l=l&&o.col===i}if(l){e.col2=Math.max(t._colstart+i-1,e.col2);return}}}_getSingleRowGroupHeaderRange(e,t,o){const l=this._bindingGroups;if(0===l.length)return null;let s=this._getGroupByColumn(o);wijmo_1.assert(null!=s,"Failed to get the group!");let i=s._getCellRange(0,o-s._colstart);const r=new wijmo_grid_1.CellRange(t,s._colstart+i.col,t,s._colstart+i.col2);if(0!=s.getBindingColumn(e,t,o).aggregate)return r;const n=l[0]._colstart;for(let l=o-1;l>=n;l--){const o=this._getGroupByColumn(l);wijmo_1.assert(null!=o,"Failed to get the group!");if(0!=o.getBindingColumn(e,t,l).aggregate)break;i=o._getCellRange(0,l-o._colstart);r.col=o._colstart+i.col}const a=l[l.length-1],_=a._colstart+a._colspanEff;for(let l=o+1;l<_;l++){const o=this._getGroupByColumn(l);wijmo_1.assert(null!=o,"Failed to get the group!");if(0!=o.getBindingColumn(e,t,l).aggregate)break;i=o._getCellRange(0,l-o._colstart);r.col2=o._colstart+i.col2}return r}_getGroupHeaderMergedRange(e,t,o,l){if(l){const l=this._multiRowGroupHeaderRange;if(l.containsColumn(o)){const e=this._rowsPerItem,o=Math.floor(t/e)*e;return new wijmo_grid_1.CellRange(o+l.row,l.col,o+l.row2,l.col2)}const s=this._getGroupByColumn(o);wijmo_1.assert(s instanceof MultiRowCellGroup,"Failed to get the group!");return s.getMergedRange(e,t,o)}return this._getSingleRowGroupHeaderRange(e,t,o)}_getGroupByColumn(e){let t=this._groupsByColumn[e];if(!t){let o=this._bindingGroups;for(let l=0;l<o.length;l++)if(e>=(t=o[l])._colstart&&e<=t._colstart+t._colspanEff-1){this._groupsByColumn[e]=t;break}}return t}_updateCellTypes(e){this._bindingGroups.forEach(t=>{t._cols.forEach(t=>{null==t.dataType&&t._binding&&(t.dataType=wijmo_1.getType(t._binding.getValue(e)));if(!t.isReadOnly){let o=wijmo_1.isIE()?null:Object.getOwnPropertyDescriptor(e,t.binding);t.isReadOnly=o&&!o.writable&&!o.set}})})}}exports._MultiRowLayout=_MultiRowLayout;class MultiRowCell extends wijmo_grid_1.Column{constructor(e){super();this._row=this._col=0;this._rowspan=this._colspan=1;wijmo_1.copy(this,e)}get row(){return this._row}set row(e){const t=wijmo_1.asInt(e,!1,!0);if(this._row!=t){this._row=t;this._onLayoutPropertyChanged()}}get col(){return this._col}set col(e){const t=wijmo_1.asInt(e,!1,!0);if(this._col!=t){this._col=t;this._onLayoutPropertyChanged()}}get colspan(){return this._colspan}set colspan(e){const t=wijmo_1.asInt(e,!1,!0);wijmo_1.assert(t>0,"colspan must be >= 1");if(this._colspan!=t){this._colspan=t;this._onLayoutPropertyChanged()}}get rowspan(){return this._rowspan}set rowspan(e){const t=wijmo_1.asInt(e,!1,!0);wijmo_1.assert(t>0,"rowspan must be >= 1");if(this._rowspan!=t){this._rowspan=t;this._onLayoutPropertyChanged()}}_setLayout(e){this._layout=e}_onLayoutPropertyChanged(){const e=this._layout;e&&e._onLayoutChanged()}}exports.MultiRowCell=MultiRowCell;class MultiRowCellGroup extends MultiRowCell{constructor(e){super();this._isRowHeader=!1;this._colstart=0;this._cells=new MultiRowCellCollection;wijmo_1.copy(this,e)}_copy(e,t){if("cells"==e){wijmo_1.isArray(t)&&(this._cellsDef=t);return!0}return!1}get cells(){return this._cells}get isRowHeader(){return this._isRowHeader}set isRowHeader(e){const t=wijmo_1.asBoolean(e);if(this._isRowHeader!=t){this._isRowHeader=t;this._onLayoutPropertyChanged()}}openGroup(){if(!this._isParsed){this._cells=this._parseCells(this._cellsDef);this._isParsed=!0}this._calculate()}closeGroup(e,t){if(t>this._rowspanEff){this._cells.forEach(e=>{e.row==this._rowspanEff-1&&(e._rowspanEff=t-e.row)});this._rowspanEff=t}this._cells.forEach(e=>{for(;e.col+e._colspanEff<this._colspanEff&&!this._slotTaken(e.row,e.col+e._colspanEff);)e._colspanEff++});this._cells.forEach(e=>{for(;e.row+e._rowspanEff<this._rowspanEff&&!this._slotTaken(e.row+e._rowspanEff,e.col);)e._rowspanEff++});if(this._cells.length>0)for(let e=0;e<this._rowspanEff;e++)for(let t=0;t<this._colspanEff;t++)wijmo_1.assert(this._slotTaken(e,t),"Invalid layout (empty cells).");this._cols=new wijmo_grid_1.ColumnCollection(e,e.columns.defaultSize);this._rng=new Array(t*this._colspanEff);this._cells.forEach(e=>{for(let t=0;t<e._rowspanEff;t++)for(let o=0;o<e._colspanEff;o++){let l=(e.row+t)*this._colspanEff+e.col+o;this._cols.setAt(l,e);let s=new wijmo_grid_1.CellRange(0-t,0-o,0-t+e._rowspanEff-1,0-o+e._colspanEff-1);s.isSingleCell||(this._rng[l]=s)}});let o=this._colstart;this._rng[-1]=new wijmo_grid_1.CellRange(0,o,0,o+this._colspanEff-1);this._hasAggregates=!1;for(let e=0;e<this._cells.length&&!this._hasAggregates;e++)this._hasAggregates=0!=this._cells[e].aggregate}getColumnWidth(e){for(let t=0;t<this._cells.length;t++){let o=this._cells[t];if(o.col==e&&1==o._colspanEff)return o.width}return null}getMergedRange(e,t,o){if(t<0)return this._rng[-1];let l=e.rows[t],s=null!=l.recordIndex?l.recordIndex:t%this._rowspanEff,i=o-this._colstart,r=this._rng[s*this._colspanEff+i];e.cellType==wijmo_grid_1.CellType.ColumnHeader&&t++;return r?new wijmo_grid_1.CellRange(t+r.row,o+r.col,t+r.row2,o+r.col2):null}getBindingColumn(e,t,o){if(t<0)return this;let l=e.rows[t],s=l&&null!=l.recordIndex?l.recordIndex:t%this._rowspanEff,i=o-this._colstart;return this._cols[s*this._colspanEff+i]}getColumn(e){return this._cols.getColumn(e)}_getCellRange(e,t){let o=this._rng[e*this._colspanEff+t];return o?new wijmo_grid_1.CellRange(e+o.row,t+o.col,e+o.row2,t+o.col2):new wijmo_grid_1.CellRange(e,t)}_parseCells(e){let t=this._cells;if(e){if(e instanceof MultiRowCellCollection){e.forEach(e=>{wijmo_1.assert(e instanceof MultiRowCell,"cells contain items of invalid type")});t=e}else e.forEach(e=>{let o=null;o=e instanceof MultiRowCell?e:new MultiRowCell(e);t.push(o)});t.forEach(e=>{e.binding&&!e.header&&(e.header=wijmo_1.toHeaderCase(e.binding))})}return t}_clearCalculations(){this._colstart=0;this._cols=null;this._hasAggregates=!1;this._rng=null;this.row=0;this.col=0;this._colspanEff=0;this._rowspanEff=0;this._cells.forEach(e=>{e.row=0;e.col=0;e._colspanEff=0;e._rowspanEff=0})}_calculate(){this._clearCalculations();this._colspanEff=this.colspan;this._rowspanEff=this.rowspan;this._cells.forEach(e=>{this._colspanEff=Math.max(this._colspanEff,e.colspan);e._colspanEff=e.colspan;e._rowspanEff=e.rowspan});let e=0,t=0;this._cells.forEach((o,l)=>{for(;!this._cellFits(o,l,e,t);)0==(t=(t+1)%this._colspanEff)&&e++;o.row=e;o.col=t});let o=1,l=1;this._cells.forEach(e=>{o=Math.max(o,e.row+e._rowspanEff);l=Math.max(l,e.col+e._colspanEff)});this._rowspanEff=o;this._colspanEff=l}_cellFits(e,t,o,l){if(l>0&&l+e._colspanEff>this._colspanEff)return!1;for(let s=0;s<e._colspanEff;s++)if(this._slotTaken(o,l+s,t))return!1;this._colspanEff=Math.max(this._colspanEff,l+e._colspanEff-1);return!0}_slotTaken(e,t,o=this._cells.length){for(let l=0;l<o;l++){let o=this._cells[l];if(e>=o.row&&e<=o.row+o._rowspanEff-1&&t>=o.col&&t<=o.col+o._colspanEff-1)return!0}return!1}}exports.MultiRowCellGroup=MultiRowCellGroup;class MultiRow extends wijmo_grid_1.FlexGrid{constructor(e,t){super(e);this._hdrLayoutDef=null;this._centerVert=!0;this._collapsedHeaders=!1;this._multiRowGroupHeaders=!1;this._rowHdrCnt=0;this.collapsedHeadersChanging=new wijmo_1.Event;this.collapsedHeadersChanged=new wijmo_1.Event;this._layoutDef=new MultiRowCellCollection;this._layout=new _MultiRowLayout(this,this._layoutDef,()=>this._onLayoutChanged());wijmo_1.addClass(this.hostElement,"wj-multirow");let o=this.columnHeaders.hostElement.parentElement,l=wijmo_1.createElement('<div class="wj-hdr-collapse"><span></span></div>');l.style.display="none";o.appendChild(l);this._btnCollapse=l;this._updateButtonGlyph();this.addEventListener(l,"mousedown",e=>{switch(this.collapsedHeaders){case null:case!1:this._collapsedHeadersWasNull=null==this.collapsedHeaders;this.collapsedHeaders=!0;break;case!0:this.collapsedHeaders=!!this._collapsedHeadersWasNull&&null}e.preventDefault();this.focus()},!0);let s=this.hostElement;this.addEventListener(s,"mousedown",e=>{if(!this._mouseHdl._szRowCol){let t=this._layout?this._layout._bindingGroups:null,o=t&&t.length?t[0]:null;if(o&&o.isRowHeader){let t=this.hitTest(e);if(t.panel==this.columnHeaders&&t.col<this.frozenColumns){e.preventDefault();this.selectAll()}}}},!0);["dragover","dragleave","dragdrop"].forEach(e=>{this.removeEventListener(s,e)});this._addHdl=new _MultiRowAddNewHandler(this);this.formatItem.addHandler(this._formatItem,this);this.autoGenerateColumns=!1;this.allowDragging=wijmo_grid_1.AllowDragging.None;this.mergeManager=new _MergeManager;this.initialize(t)}_getProductInfo(){return"H87K,MultiRow"}get layoutDefinition(){return this._layoutDef}set layoutDefinition(e){this.finishEditing()||this.finishEditing(!0);this._layoutDef=wijmo_1.asArray(e);if(this._layout){this._layout._dispose();this._layout=null}this._layout=new _MultiRowLayout(this,e,()=>this._onLayoutChanged());this._rowHdrCnt=0;if(this._layout){let e=this._layout._bindingGroups;for(let t=0;t<e.length;t++){let o=e[t];if(!o.isRowHeader)break;this._rowHdrCnt=o._colstart+o._colspanEff;o.cells.forEach(e=>{e.isReadOnly=!0;!e.header||e.binding||e.cellTemplate||(e.cellTemplate=e.header);e.cssClass?e.cssClass.indexOf("wj-header")<0&&(e.cssClass+=" wj-header"):e.cssClass="wj-header"})}}this._rowHdrCnt&&(this.frozenColumns=this._rowHdrCnt);this._bindGrid(!0);this._rowHdrCnt&&this.selectionMode&&this.select(this.selection.row,this._rowHdrCnt)}get headerLayoutDefinition(){return this._hdrLayoutDef}set headerLayoutDefinition(e){this._hdrLayoutDef=wijmo_1.asArray(e);if(this._hdrLayout){this._hdrLayout._dispose();this._hdrLayout=null}let t=null;e&&(t=new _MultiRowLayout(this,e,()=>this._onHeaderLayoutChanged()));this._hdrLayout=t;this._bindGrid(!0)}get rowsPerItem(){return this._layout._rowsPerItem}getBindingColumn(e,t,o){return this._getBindingColumn(e,t,e.columns[o])}getColumn(e,t){if(wijmo_1.isString(e)){let o=t&&this._hdrLayout,l=(o?this._hdrLayout:this._layout)._bindingGroups,s=null;for(let t=0;t<l.length&&!s;t++)s=l[t].getColumn(e);return!s&&o?this.getColumn(e,!1):s}return super.getColumn(e)}get centerHeadersVertically(){return this._centerVert}set centerHeadersVertically(e){if(e!=this._centerVert){this._centerVert=wijmo_1.asBoolean(e);this.invalidate()}}get collapsedHeaders(){return this._collapsedHeaders}set collapsedHeaders(e){if(e!=this._collapsedHeaders){let t=new wijmo_1.CancelEventArgs;if(this.onCollapsedHeadersChanging(t)){this._collapsedHeaders=wijmo_1.asBoolean(e,!0);this._updateCollapsedHeaders();this._updateButtonGlyph();this.onCollapsedHeadersChanged(t)}}}get showHeaderCollapseButton(){return""==this._btnCollapse.style.display}set showHeaderCollapseButton(e){e!=this.showHeaderCollapseButton&&(this._btnCollapse.style.display=wijmo_1.asBoolean(e)?"":"none")}get multiRowGroupHeaders(){return this._multiRowGroupHeaders}set multiRowGroupHeaders(e){if(e!=this._multiRowGroupHeaders){this._multiRowGroupHeaders=wijmo_1.asBoolean(e);this._bindGrid(!0)}}onCollapsedHeadersChanging(e){this.collapsedHeadersChanging.raise(this,e);return!e.cancel}onCollapsedHeadersChanged(e){this.collapsedHeadersChanged.raise(this,e)}get allowPinning(){return!1}set allowPinning(e){wijmo_1.assert(!e,"MultiRow does not support pinning.")}onSelectionChanging(e){let t=e._rng;if(t&&t.isValid&&this.selectionMode){let e=this._mouseHdl._htDown,o=this.rows,l=this.columns,s=this._rowHdrCnt;if(s){t.col=Math.max(t.col,s);t.col2=Math.max(t.col2,s)}if(e&&(e.panel==this.rowHeaders||e.panel==this.cells&&e.col<s)){let e=o[t.topRow],s=o[t.bottomRow];if(e&&null!=e.recordIndex){let o=e.index-e.recordIndex,i=s instanceof _MultiGroupRow&&!this._multiRowGroupHeaders?1:this.rowsPerItem,r=s.index-s.recordIndex+i-1,n=l.length-1,a=t.row!=t.topRow?new wijmo_grid_1.CellRange(r,0,o,n):new wijmo_grid_1.CellRange(o,0,r,n);t.row=a.row;t.row2=a.row2;t.col2=n;switch(this.selectionMode){case wijmo_grid_1.SelectionMode.Cell:t.row2=a.row;t.col2=a.col;break;case wijmo_grid_1.SelectionMode.Row:t.row2=a.row}}}}return super.onSelectionChanging(e)}_createSelHdl(){return new _MultiRowSelectionHandler(this)}_getDeleteColumnIndex(){return this._rowHdrCnt}_getQuickAutoSize(){return wijmo_1.isBoolean(this.quickAutoSize)?this.quickAutoSize:this.formatItem.handlerCount<=1&&null==this.itemFormatter}_addBoundRow(e,t){let o=e[t];for(let e=0;e<this.rowsPerItem;e++)this.rows.push(new _MultiRow(o,t,e))}_addNode(e,t,o){this._addBoundRow(e,t)}_addGroupRow(e){let t=this._multiRowGroupHeaders?this.rowsPerItem:1;for(let o=0;o<t;o++)this.rows.push(new _MultiGroupRow(e,o))}_bindColumns(){let e=this.columnHeaders.rows,t=this._layout,o=this._hdrLayout,l=(o?o._rowsPerItem:this.rowsPerItem)+1;for(;e.length>l;)e.removeAt(e.length-1);for(;e.length<l;)e.push(new wijmo_grid_1.Row);this._updateCollapsedHeaders();this.columns.clear();if(t&&t._bindingGroups){let e="width,minWidth,maxWidth,binding,header,format,dataMap,name,aggregate,cellTemplate".split(",");t._bindingGroups.forEach(t=>{for(let o=0;o<t._colspanEff;o++){if(0===t.cells.length)continue;let l=new wijmo_grid_1.Column;for(let s=0;s<t.cells.length;s++){let i=t.cells[s];i.col==o&&e.forEach(e=>{null!=i[e]&&i[e]!=l[e]&&(l[e]=i[e])})}this.columns.push(l)}})}}_updateCollapsedHeaders(){let e=this.columnHeaders.rows,t=this.collapsedHeaders;e[0].visible=0!=t;for(let o=1;o<e.length;o++)e[o].visible=1!=t}_updateColumnTypes(){super._updateColumnTypes();let e=this.collectionView;if(wijmo_1.hasItems(e)){let t=e.items[0];this._layout&&this._layout._updateCellTypes(t);this._hdrLayout&&this._hdrLayout._updateCellTypes(t)}}_getBindingColumn(e,t,o){if(o&&(e==this.cells||e==this.columnHeaders)){let l=e.cellType==wijmo_grid_1.CellType.ColumnHeader;l&&t--;o=this._getGroupByColumn(o.index,l).getBindingColumn(e,t,o.index)}return o}_getBindingColumns(){let e=[];this._layout._bindingGroups.forEach(t=>{t._cols.forEach(t=>{e.indexOf(t)<0&&e.push(t)})});return e}_getRowsPerItem(){return this.rowsPerItem}_cvCollectionChanged(e,t){if(this.autoGenerateColumns&&0==this.columns.length)this._bindGrid(!0);else{let e=wijmo_1.NotifyCollectionChangedAction;switch(t.action){case e.Change:this.invalidate();break;case e.Add:if(t.index==this.collectionView.items.length-1){let e=this.rows.length;for(;e>0&&this.rows[e-1]instanceof wijmo_grid_1._NewRowTemplate;)e--;for(let o=0;o<this.rowsPerItem;o++)this.rows.insert(e+o,new _MultiRow(t.item,t.index,o));return}wijmo_1.assert(!1,"added item should be the last one.");break;default:this._bindGrid(!1)}}}_getGroupByColumn(e,t){let o=null;t&&this._hdrLayout&&!this.collapsedHeaders&&(o=this._hdrLayout._getGroupByColumn(e));o||(o=this._layout._getGroupByColumn(e));wijmo_1.assert(o instanceof MultiRowCellGroup,"Failed to get the group!");return o}_onLayoutChanged(){this.layoutDefinition=this._layoutDef}_onHeaderLayoutChanged(){this.headerLayoutDefinition=this._hdrLayoutDef}_formatItem(e,t){let o=this.rowsPerItem,l=t.panel,s=l.cellType,i=l.rows[t.range.row],r=l.rows[t.range.row2],n=t.cell,a=wijmo_grid_1.CellType;s==a.ColumnHeader&&wijmo_1.toggleClass(n,"wj-group-header",0==t.range.row);if(s==a.Cell||s==a.ColumnHeader){let e=this._getGroupByColumn(t.col,s==a.ColumnHeader);wijmo_1.toggleClass(n,"wj-group-start",e._colstart==t.range.col);wijmo_1.toggleClass(n,"wj-group-end",e._colstart+e._colspanEff-1==t.range.col2)}if(o>1&&(s==a.Cell||s==a.RowHeader)){let e=i instanceof _MultiRow||i instanceof _MultiRowNewRowTemplate,t=r instanceof _MultiRow||r instanceof _MultiRowNewRowTemplate;wijmo_1.toggleClass(n,"wj-record-start",!!e&&0==i.recordIndex);wijmo_1.toggleClass(n,"wj-record-end",!!t&&r.recordIndex==o-1)}let _=this.alternatingRowStep;if(_){let e=!1;if(i instanceof _MultiRow){e=i.dataIndex%(_+1)==0;1==_&&(e=!e)}wijmo_1.toggleClass(n,"wj-alt",e)}if(this._centerVert&&!n.getAttribute("wj-state-measuring")){let e=t.range.rowSpan>1;if(e&&t.updateContent)if(0==n.childElementCount)n.innerHTML="<div>"+n.innerHTML+"</div>";else{let e=document.createElement("div"),t=document.createRange();t.selectNodeContents(n);t.surroundContents(e)}wijmo_1.toggleClass(n,"wj-center-vert",e)}}_updateButtonGlyph(){let e=this._btnCollapse.querySelector("span");e instanceof HTMLElement&&(e.className=this.collapsedHeaders?"wj-glyph-left":"wj-glyph-down-left")}_getError(e,t,o,l){if(wijmo_1.isFunction(this.itemValidator)&&e==this.rowHeaders)for(let e=0;e<this.rowsPerItem;e++)for(o=0;o<this.columns.length;o++){let s=this.itemValidator(t+e,o,l);if(s)return s}return super._getError(e,t,o,l)}}exports.MultiRow=MultiRow;class _MergeManager extends wijmo_grid_1.MergeManager{getMergedRange(e,t,o,l=!0){let s=e.grid;if(t<0||t>=e.rows.length||o<0||o>=e.columns.length)return null;switch(e.cellType){case wijmo_grid_1.CellType.Cell:case wijmo_grid_1.CellType.RowHeader:if(e.rows[t]instanceof wijmo_grid_1.GroupRow&&!s.multiRowGroupHeaders)return this._getGroupRowMergedRange(e,t,o,l,!1)}switch(e.cellType){case wijmo_grid_1.CellType.Cell:if(e.rows[t]instanceof wijmo_grid_1.GroupRow)return this._getGroupRowMergedRange(e,t,o,l,s.multiRowGroupHeaders);case wijmo_grid_1.CellType.ColumnHeader:let i=e.cellType==wijmo_grid_1.CellType.ColumnHeader,r=s._getGroupByColumn(o,i);wijmo_1.assert(r instanceof MultiRowCellGroup,"Failed to get the group!");let n=i?r.getMergedRange(e,t-1,o):r.getMergedRange(e,t,o),a=e.columns.frozen;if(a&&n&&n.columnSpan>1&&n.col<a&&n.col2>=a){n=n.clone();o<a?n.col2=a-1:n.col=a}let _=e.rows.frozen;if(_&&n&&n.rowSpan>1&&e.cellType==wijmo_grid_1.CellType.Cell&&n.row<_&&n.row2>=_){n=n.clone();t<_?n.row2=_-1:n.row=_}wijmo_1.assert(!n||n.contains(t,o),"Merged range must contain source cell");return n;case wijmo_grid_1.CellType.RowHeader:let h=s.rowsPerItem,d=t-e.rows[t].recordIndex,u=Math.min(d+h-1,e.rows.length-1);return new wijmo_grid_1.CellRange(d,0,u,e.columns.length-1);case wijmo_grid_1.CellType.TopLeft:const w=s.collapsedHeaders,c=e.rows.length-1,g=c>0?1:0,p=0!=w?0:g,f=1!=w?c:g;return new wijmo_grid_1.CellRange(p,0,f,e.columns.length-1)}return null}_getGroupRowMergedRange(e,t,o,l=!0,s){let i=e.grid,r=e.cellType,n=e.rows[t];if(i.showGroups&&!i.childItemsPath&&n instanceof _MultiGroupRow&&n.dataItem instanceof wijmo_1.CollectionViewGroup&&r==wijmo_grid_1.CellType.Cell){return i._layout._getGroupHeaderMergedRange(e,t,o,s)}return super.getMergedRange(e,t,o,l)}}exports._MergeManager=_MergeManager;class _MultiRowAddNewHandler extends wijmo_grid_1._AddNewHandler{constructor(e){e._addHdl._detach();super(e)}updateNewRowTemplate(){let e=this._g.editableCollectionView,t=this._g,o=t.rows,l=e&&e.canAddNew&&t.allowAddNew&&!t.isReadOnly,s=-1;for(let e=0;e<o.length;e+=t.rowsPerItem)if(o[e]instanceof _MultiRowNewRowTemplate){s=e;break}if(l&&s>-1&&(this._top&&s>0||!this._top&&0==s)){s=-1;this._removeNewRowTemplate()}if(l&&s<0)for(let e=0;e<t.rowsPerItem;e++){let t=new _MultiRowNewRowTemplate(e);0==e&&(this._nrt=t);this._top?o.insert(e,t):o.push(t)}!l&&s>-1&&this._removeNewRowTemplate()}_keydown(e){super._keydown(e);e.defaultPrevented||e.keyCode!=wijmo_1.Key.Escape||this._copyNewDataItem()}_beginningEdit(e,t){super._beginningEdit(e,t);this._top&&this._copyNewDataItem()}_rowEditStarting(e,t){super._rowEditStarting(e,t);this._top&&this._copyNewDataItem()}_rowEditEnded(e,t){super._rowEditEnded(e,t);this._copyNewDataItem()}_copyNewDataItem(){if(this._top){let e=this._g,t=e.rows;for(let o=0;o<e.rowsPerItem;o++)t[o]instanceof wijmo_grid_1._NewRowTemplate&&(t[o].dataItem=this._nrt.dataItem)}}_removeNewRowTemplate(){for(let e=0,t=this._g.rows;e<t.length;e++)if(t[e]instanceof wijmo_grid_1._NewRowTemplate){t.removeAt(e);e--}}}exports._MultiRowAddNewHandler=_MultiRowAddNewHandler;class _MultiRowNewRowTemplate extends wijmo_grid_1._NewRowTemplate{constructor(e){super();this._idxRecord=e}get recordIndex(){return this._idxRecord}}exports._MultiRowNewRowTemplate=_MultiRowNewRowTemplate;wijmo_1._registerModule("wijmo.grid.multirow",selfModule);