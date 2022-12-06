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

var __extends=this&&this.__extends||function(){var extendStatics=function(e,o){return(extendStatics=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,o){e.__proto__=o}||function(e,o){for(var r in o)o.hasOwnProperty(r)&&(e[r]=o[r])})(e,o)};return function(e,o){extendStatics(e,o);function __(){this.constructor=e}e.prototype=null===o?Object.create(o):(__.prototype=o.prototype,new __)}}();import{MergeManager,CellRange,FlexGrid,Row,Column,ColumnCollection,CellRangeEventArgs,AllowSorting,HeadersVisibility}from"wijmo/wijmo.grid";import{asArray,assert,isArray,isString,isNumber,isUndefined,asBoolean,getTypes,getType,tryCast,toHeaderCase,addClass,DataType,Binding,Control,CollectionView,ObservableArray,NotifyCollectionChangedEventArgs,NotifyCollectionChangedAction,asString,copy,_registerModule}from"wijmo/wijmo";import*as selfModule from"wijmo/wijmo.grid.transposed";var _MergeManager=function(e){__extends(_MergeManager,e);function _MergeManager(){return null!==e&&e.apply(this,arguments)||this}_MergeManager.prototype.getMergedRange=function(o,r,t,n){void 0===n&&(n=!0);var i=o.grid;if(o==i.rowHeaders&&i._hasColumnGroups()){if(r<0||r>=o.rows.length||t<0||t>=o.columns.length)return null;var s=i._getColumnGroup(r,t);if(s){var a=s._rng,l=o.rows;if(l.isFrozen(a.row)!=l.isFrozen(a.row2)){a=a.clone();l.isFrozen(r)?a.row2=l.frozen-1:a.row=l.frozen}return a}return null}return e.prototype.getMergedRange.call(this,o,r,t,n)};return _MergeManager}(MergeManager);export{_MergeManager};var TransposedGrid=function(e){__extends(TransposedGrid,e);function TransposedGrid(o,r){var t=e.call(this,o,null)||this;t._keyPrefix="item";t._autoGenRows=!0;addClass(t.hostElement,"wj-transposed-grid");t.allowSorting=AllowSorting.None;t.headersVisibility=HeadersVisibility.Row;t._rowInfo=new ColumnCollection(t,t.columns.defaultSize);t._grpHdl=new _RowGroupHandler(t);t.mergeManager=new _MergeManager;t.initialize(r);t._rowInfo.collectionChanged.addHandler(t._rowInfoChanged,t);t.deferUpdate((function(){var e=t.rowHeaders.columns;if(e.length){e[e.length-1].width=t.columns.defaultSize}}));return t}Object.defineProperty(TransposedGrid.prototype,"autoGenerateRows",{get:function(){return this._autoGenRows},set:function(e){this._autoGenRows=asBoolean(e)},enumerable:!0,configurable:!0});Object.defineProperty(TransposedGrid.prototype,"rowGroups",{get:function(){return this._grpHdl.getGroupDefinitions()},set:function(e){var o=this;this._rowInfo.deferUpdate((function(){o.autoGenerateRows=!1;o._rowInfo.clear();o._grpHdl.createColumnGroups(asArray(e))}))},enumerable:!0,configurable:!0});TransposedGrid.prototype.refresh=function(o){var r=this._rowInfo;if(r._dirty){r._dirty=!1;this._rowInfoChanged()}else e.prototype.refresh.call(this,o)};Object.defineProperty(TransposedGrid.prototype,"allowAddNew",{get:function(){return!1},set:function(e){},enumerable:!0,configurable:!0});Object.defineProperty(TransposedGrid.prototype,"allowDelete",{get:function(){return!1},set:function(e){},enumerable:!0,configurable:!0});Object.defineProperty(TransposedGrid.prototype,"allowSorting",{get:function(){return AllowSorting.None},set:function(e){assert(e===AllowSorting.None,"TransposedGrid does not support sorting.");this._alSorting=e},enumerable:!0,configurable:!0});Object.defineProperty(TransposedGrid.prototype,"columnGroups",{get:function(){return null},set:function(e){throw"TransposedGrid does not support columnGroups, use rowGroups instead."},enumerable:!0,configurable:!0});TransposedGrid.prototype.onRowEditEnded=function(o){var r=tryCast(this._sourceItems,"ICollectionView");if(r){var t=new NotifyCollectionChangedEventArgs(NotifyCollectionChangedAction.Change);r.collectionChanged.raise(r,t)}e.prototype.onRowEditEnded.call(this,o)};TransposedGrid.prototype._getCollectionView=function(o){var r=this,t=tryCast(this._sourceItems,"ICollectionView");t&&t.collectionChanged.removeHandler(this._sourceViewChanged);t=tryCast(o,"ICollectionView");var n=o;if(isArray(o))n=this._transposeItemsSource(o);else if(t){t.collectionChanged.addHandler(this._sourceViewChanged,this);n=this._transposeItemsSource(t.items)}this.autoGenerateColumns=!0;var i=e.prototype._getCollectionView.call(this,n),s=null;t instanceof CollectionView&&(s=t.getError);s&&i instanceof CollectionView&&(this._supportsProxies()?i.getError=function(e,o){if(null==o)return null;var r=e._keys.indexOf(o);return s(e._arr[r],e._bnd.path)}:i.getError=function(e,o){if(null==o)return null;var t=parseInt(o.substr(r._keyPrefix.length));return s(e._arr[t],e._rowInfo.binding)});this._sourceItems=o;return i};TransposedGrid.prototype._getColumnTypes=function(e){var o,r=this;if(this._sourceItems)if(isArray(this._sourceItems))o=this._sourceItems;else{var t=tryCast(this._sourceItems,"ICollectionView");t&&(o=t.items)}return o?o.map((function(e,o){return{binding:r._keyPrefix+o,dataType:DataType.Object}})):getTypes(e)};TransposedGrid.prototype._copy=function(o,r){var t=this;if(/rows|columns/.test(o)){assert(isArray(r),"Array Expected.");var n=asArray(r);n.some((function(e){return null!=e.columns}))?this.rowGroups=n:this._rowInfo.deferUpdate((function(){t.autoGenerateRows=!1;t._rowInfo.clear();r.forEach((function(e){var o=new TransposedGridRow(e);t._rowInfo.push(o)}))}));return!0}return e.prototype._copy.call(this,o,r)};TransposedGrid.prototype.onLoadedRows=function(o){for(var r=this,t=this.columns,n=0;n<t.length;n++){var i=t[n];i.align=null;i.dataType=0}var s=this.rowHeaders.columns;for(n=0;n<s.length;n++){s[n].align="left";s[n].width=0}var a=FlexGrid._getSerializableProperties(Row);this.rows.forEach((function(e){var o=e.dataItem._rowInfo;if(o){r._copyProps(o,e,a,["showDropDown","width","size"]);if(r._hasColumnGroups())for(var t=0;t<s.length;t++){var n=r._grpHdl.getColumnGroup(e.index,t);n&&r._updateRowHeaders(e.index,t,n)}else s.length&&r._updateRowHeaders(e.index,s.length-1,o)}}));for(n=0;n<s.length;n++)0===s[n].width&&(s[n].width=this.columns.defaultSize);e.prototype.onLoadedRows.call(this,o)};TransposedGrid.prototype._getBindingColumn=function(e,o,r){var t=r;if(e!=this.cells)return t;var n=e.rows[o].dataItem._rowInfo;if(isUndefined(n))return t;t=new Column;var i=FlexGrid._getSerializableProperties(Column);this._copyProps(n,t,i);t.binding=r.binding;t.header=n.header||toHeaderCase(n.binding);return t};TransposedGrid.prototype._isTransposed=function(){return!0};TransposedGrid.prototype._copyProps=function(e,o,r,t){void 0===t&&(t=[]);for(var n in e)if(r.indexOf(n)>-1&&-1===t.indexOf(n)){var i=e[n];if(!isUndefined(i))try{o[n]=i}catch(e){}}};TransposedGrid.prototype._updateRowHeaders=function(e,o,r){var t=r.header||toHeaderCase(r.binding);this.rowHeaders.setCellData(e,o,t);var n=this.rowHeaders.columns,i=r.width;if(isNumber(i)&&i>0){var s=r._rng;if(s&&s instanceof CellRange&&s.isValid){var a=s.columnSpan;assert(a>0,"Column span is negative or equal to 0");i/=a}n[o].width=Math.max(n[o].width,i)}};TransposedGrid.prototype._rowInfoChanged=function(){var e=this;this._toRowInfo&&clearTimeout(this._toRowInfo);this._toRowInfo=setTimeout((function(){var o=e.selection,r=e.itemsSource;e.itemsSource=null;e.itemsSource=r;e.selection=o}),Control._REFRESH_INTERVAL)};TransposedGrid.prototype._sourceViewChanged=function(e,o){this.activeEditor||this.invalidate()};TransposedGrid.prototype._transposeItemsSource=function(e){var o=this,r=new ObservableArray,t=getTypes(e),n=e.map((function(e,r){return o._keyPrefix+r}));(this.autoGenerateRows?this._getRowInfo(e):this._rowInfo).forEach((function(i,s){var a=new Binding(i.binding);if(null==i.dataType&&e.length){var l=a.getValue(e[0]);i.dataType=null!=l?getType(l):t[s].dataType}if(o._supportsProxies()){var u=o._createProxy(e,i,n);r.push(u)}else{var p=o._createTransposedObject(e,i,o._keyPrefix);r.push(p)}}));e instanceof ObservableArray&&e.collectionChanged.addHandler((function(e,t){if(t.action===NotifyCollectionChangedAction.Change)o.activeEditor||o.invalidate();else{var n=new NotifyCollectionChangedEventArgs(NotifyCollectionChangedAction.Reset);r.onCollectionChanged(n);o._rowInfoChanged()}}));return r};TransposedGrid.prototype._supportsProxies=function(){return null!=window.Proxy};TransposedGrid.prototype._createProxy=function(e,o,r){var t={_arr:e,_rowInfo:o,_bnd:new Binding(o.binding),_keys:r};return new Proxy(t,{ownKeys:function(e){return e._keys},getOwnPropertyDescriptor:function(){return{enumerable:!0,configurable:!0,writable:!0}},get:function(e,o){var r=e._keys.indexOf(o);return r>-1?e._bnd.getValue(e._arr[r]):e[o]},set:function(e,o,r){var t=e._keys.indexOf(o);if(t>-1){var n=e._arr,i=n[t];e._bnd.setValue(i,r);if(n instanceof ObservableArray){var s=new NotifyCollectionChangedEventArgs(NotifyCollectionChangedAction.Change,i,t);n.onCollectionChanged(s)}return!0}return!1}})};TransposedGrid.prototype._createTransposedObject=function(e,o,r){for(var t={_arr:e,_rowInfo:o},n=new Binding(o.binding),_loop_1=function(o){var i=e[o];Object.defineProperty(t,r+o,{enumerable:!0,get:function(){return n.getValue(i)},set:function(r){n.setValue(i,r);if(e instanceof ObservableArray){var t=new NotifyCollectionChangedEventArgs(NotifyCollectionChangedAction.Change,i,o);e.onCollectionChanged(t)}return!0}})},i=0;i<e.length;i++)_loop_1(i);return t};TransposedGrid.prototype._getRowInfo=function(e){var o=this,r=[];getTypes(e).forEach((function(e){var t=e.binding,n=e.dataType;if(n!=DataType.Object&&n!=DataType.Array){var i={binding:t,header:toHeaderCase(t),dataType:n},s=FlexGrid._defTypeWidth[n];if(null!=s){if(isString(s)){var a=Math.round(parseFloat(s));s=s.indexOf("*")<0?a:a*o.columns.defaultSize}isNumber(s)&&s>0&&(i.width=s)}r.push(i)}}));return r};return TransposedGrid}(FlexGrid);export{TransposedGrid};var TransposedGridRow=function(e){__extends(TransposedGridRow,e);function TransposedGridRow(){return null!==e&&e.apply(this,arguments)||this}Object.defineProperty(TransposedGridRow.prototype,"height",{get:function(){return this._height},set:function(e){this._height=e},enumerable:!0,configurable:!0});return TransposedGridRow}(Column);export{TransposedGridRow};var _RowGroupHandler=function(){function _RowGroupHandler(e){this._grid=e}Object.defineProperty(_RowGroupHandler.prototype,"columnGroups",{get:function(){return null},enumerable:!0,configurable:!0});_RowGroupHandler.prototype.createColumnGroups=function(e){this._createRowGroups(e)};_RowGroupHandler.prototype.hasColumnGroups=function(){return null!=this._colGroups&&this._colGroups.length>0};_RowGroupHandler.prototype.getGroupDefinitions=function(){return this._groupDefs};_RowGroupHandler.prototype.getColumnGroup=function(e,o){var r=this._grid;if(o<r.rowHeaders.columns.length&&e<r._rowInfo.length)for(var t=this._colGroups;t;){for(var n=t,i=0;i<t.length;i++){var s=t[i],a=s._rng;if(a.containsRow(e)){if(a.containsColumn(o)||0==s.columns.length)return s;t=s.columns;break}}if(t==n)break}return null};_RowGroupHandler.prototype.canMoveColumnGroup=function(e,o,r,t){return this._grid.columns.canMoveElement(o,t)};_RowGroupHandler.prototype.moveColumnGroup=function(e,o,r,t,n){return this._grid.columns.moveElement(o,t)};_RowGroupHandler.prototype._createRowGroups=function(e){var o=this,r=this._grid;this._groupDefs=asArray(e);r.autoGenerateRows=!1;r._rowInfo.clear();this._colGroups=[];e.forEach((function(e){o._colGroups.push(new _RowGroup(e,null))}));var t=1;this._colGroups.forEach((function(e){o._addRowGroup(e);t=Math.max(t,e._getMaxLevel())}));this._colGroups.forEach((function(e){e._expandRange(t)}));var n=r.rowHeaders.columns;n.clear();for(var i=0;i<=t;i++){var s=new Column;n.splice(i,0,s);i<t&&(s.cssClassAll="wj-colgroup")}};_RowGroupHandler.prototype._addRowGroup=function(e){var o=this,r=this._grid;e._grid=r;e._rng.row=r._rowInfo.length;0==e.columns.length?r._rowInfo.push(e):e.columns.forEach((function(e){o._addRowGroup(e)}));e._rng.row2=r._rowInfo.length-1};return _RowGroupHandler}();export{_RowGroupHandler};var _RowGroup=function(e){__extends(_RowGroup,e);function _RowGroup(o,r){var t=e.call(this)||this;t._rng=new CellRange(-1,0);t._cols=[];t._lvl=0;t._collapsed=!1;t._pGrp=r;t._lvl=0;for(var n=r;n;n=n._pGrp)t._lvl++;r&&r.columns.indexOf(t)<0&&r.columns.push(t);t._rng.col=t._rng.col2=t._lvl;t.allowDragging=!1;copy(t,o);return t}Object.defineProperty(_RowGroup.prototype,"columns",{get:function(){return this._cols},set:function(e){var o=this,r=this._cols=[];e.forEach((function(e){var t=new _RowGroup(e,o);r.indexOf(t)<0&&r.push(t)}))},enumerable:!0,configurable:!0});Object.defineProperty(_RowGroup.prototype,"rows",{get:function(){return this._cols},enumerable:!0,configurable:!0});Object.defineProperty(_RowGroup.prototype,"isEmpty",{get:function(){return 0===this._cols.length},enumerable:!0,configurable:!0});Object.defineProperty(_RowGroup.prototype,"height",{get:function(){return this._height},set:function(e){this._height=e},enumerable:!0,configurable:!0});Object.defineProperty(_RowGroup.prototype,"level",{get:function(){for(var e=this,o=0;e._pGrp;){e=e._pGrp;o++}return o},enumerable:!0,configurable:!0});Object.defineProperty(_RowGroup.prototype,"collapseTo",{get:function(){return this._collTo},set:function(e){this._collTo=asString(e)},enumerable:!0,configurable:!0});Object.defineProperty(_RowGroup.prototype,"isCollapsed",{get:function(){return this._collapsed},set:function(e){var o=this;if(e!=this._collapsed){var r=this._grid;if(r){var t=new CellRangeEventArgs(r.rowHeaders,this._rng,this);if(r.onColumnGroupCollapsedChanging(t)){this._collapsed=asBoolean(e);r.onColumnGroupCollapsedChanged(t)}}else this._collapsed=asBoolean(e)}setTimeout((function(){o._updateCollapsedState()}))},enumerable:!0,configurable:!0});_RowGroup.prototype._copy=function(e,o){if(/rows|columns/.test(e)){var r=asArray(o);this.columns=r;return!0}return!1};_RowGroup.prototype._updateCollapsedState=function(){var e=this._grid._rowInfo,o=this._rng,r=this._collapsed;this._cols.forEach((function(e){if(e instanceof _RowGroup){e._collapsed=r;e._updateCollapsedState()}}));var t=o.bottomRow;if(this.collapseTo)switch(this.collapseTo){case"$first":t=o.topRow;break;case"$last":t=o.bottomRow;break;default:var n=e.indexOf(this.collapseTo);n>-1&&(t=n)}for(var i=o.topRow;i<=o.bottomRow;i++)e[i].visible=!r||i==t};_RowGroup.prototype._getMaxLevel=function(){var e=this._lvl;this.columns.forEach((function(o){e=Math.max(e,o._getMaxLevel())}));return e};_RowGroup.prototype._expandRange=function(e){var o=e-this._getMaxLevel();if(o>0){this._rng.col2+=o;this._cols.forEach((function(e){e._shiftRange(o)}))}for(var r=this._grid._rowInfo,t=this._rng,n=t.row;n<=t.row2;n++){r[n]._rng.col2=e}};_RowGroup.prototype._shiftRange=function(e){this._rng.col+=e;this._rng.col2+=e;this._cols.forEach((function(o){o._shiftRange(e)}))};return _RowGroup}(Column);export{_RowGroup};_registerModule("wijmo.grid.transposed",selfModule);