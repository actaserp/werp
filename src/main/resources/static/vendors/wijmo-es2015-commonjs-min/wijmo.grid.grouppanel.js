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

"use strict";var __importStar=this&&this.__importStar||function(e){if(e&&e.__esModule)return e;var t={};if(null!=e)for(var i in e)Object.hasOwnProperty.call(e,i)&&(t[i]=e[i]);t.default=e;return t};Object.defineProperty(exports,"__esModule",{value:!0});const wijmo_1=require("wijmo/wijmo"),wijmo_grid_1=require("wijmo/wijmo.grid"),selfModule=__importStar(require("wijmo/wijmo.grid.grouppanel"));function softGridFilter(){return wijmo_1._getModule("wijmo.grid.filter")}exports.softGridFilter=softGridFilter;wijmo_1._addCultureInfo("GroupPanel",{dragDrop:"Drag and Drop columns here to create Groups."});class GroupPanel extends wijmo_1.Control{constructor(e,t){super(e);this._hideGroupedCols=!0;this._showDragGlyphs=!0;this._maxGroups=6;this._hiddenCols=[];this._placeholder=null;this._dragEndBnd=this._dragEnd.bind(this);let i=this.getTemplate();this.applyTemplate("wj-grouppanel wj-control",i,{_divMarkers:"div-markers",_divPH:"div-ph"});wijmo_1.setCss(this._divMarkers.parentElement,{width:"100%",height:"100%",minHeight:"1em",overflow:"hidden",cursor:"default"});let r=this.hostElement,l=this.addEventListener.bind(this);l(r,"dragstart",this._dragStart.bind(this));l(r,"dragover",this._dragOver.bind(this));l(r,"drop",this._drop.bind(this));l(r,"dragend",this._dragEndBnd);l(r,"click",this._click.bind(this));this.initialize(t)}get hideGroupedColumns(){return this._hideGroupedCols}set hideGroupedColumns(e){e!=this._hideGroupedCols&&(this._hideGroupedCols=wijmo_1.asBoolean(e))}get showDragGlyphs(){return this._showDragGlyphs}set showDragGlyphs(e){if(e!=this._showDragGlyphs){this._showDragGlyphs=wijmo_1.asBoolean(e);this.refresh()}}get maxGroups(){return this._maxGroups}set maxGroups(e){if(e!=this._maxGroups){this._maxGroups=wijmo_1.asNumber(e);let t=this._gds,i=this._maxGroups;t&&i>-1&&i<t.length&&t.splice(i,t.length-i)}}get placeholder(){return this._placeholder}set placeholder(e){if(e!=this._placeholder){this._placeholder=e;this.invalidate()}}get grid(){return this._g}set grid(e){if((e=wijmo_1.asType(e,wijmo_grid_1.FlexGrid,!0))!=this._g){let t=this._g;if(t){t.draggingColumn.removeHandler(this._draggingColumn);t.itemsSourceChanging.removeHandler(this._itemsSourceChanging);t.itemsSourceChanged.removeHandler(this._itemsSourceChanged);t.columns.collectionChanged.removeHandler(this._itemsSourceChanged);t.removeEventListener(t.hostElement,"dragend",this._dragEndBnd)}t=this._g=e;this._hiddenCols=[];if(t){t.draggingColumn.addHandler(this._draggingColumn,this);t.itemsSourceChanging.addHandler(this._itemsSourceChanging,this);t.itemsSourceChanged.addHandler(this._itemsSourceChanged,this);t.columns.collectionChanged.addHandler(this._itemsSourceChanged,this);t.addEventListener(t.hostElement,"dragend",this._dragEndBnd)}this._itemsSourceChanged(t,null)}}get collectionView(){return this._g?this._g.collectionView:null}get filter(){return this._filter}set filter(e){if((e=wijmo_1.asType(e,softGridFilter().FlexGridFilter,!0))!=this._filter){let t=this._filter;if(t){t.filterApplied.removeHandler(this.refresh,this);t.filterChanged.removeHandler(this._filterChanged,this)}if(t=this._filter=e){t.filterApplied.addHandler(this.refresh,this);t.filterChanged.addHandler(this._filterChanged,this)}this.refresh()}}get groupDescriptionCreator(){return this._gdc}set groupDescriptionCreator(e){this._gdc=e}refresh(){super.refresh();this._divMarkers.innerHTML="";this._dragMarker=this._dragCol=null;if(this._gds){let t=this._g,i=t.columnHeaders;for(let r=0;r<this._gds.length;r++){let l=this._gds[r],s=-1,o=-1;if(l instanceof wijmo_1.PropertyGroupDescription)for(let e=i.rows.length-1;e>=0&&o<0;e--)for(let r=0;r<i.columns.length&&o<0;r++){let n=t._getBindingColumn(i,e,i.columns[r]);if(n&&n.binding==l.propertyName){o=r;s=e;break}}if(o>-1&&s>-1){let r=document.createElement("div");t.cellFactory.updateCell(this._g.columnHeaders,s,o,r);r.setAttribute("class","wj-cell wj-header wj-groupmarker");wijmo_1.setCss(r,{position:"static",display:"inline-block",verticalAlign:"top",left:"",right:"",top:"",width:"",height:"",paddingLeft:"",paddingRight:""});wijmo_1.removeChild(r.querySelector(".wj-elem-filter"));wijmo_1.removeChild(r.querySelector(".wj-column-selector"));if(this.showDragGlyphs){var e=wijmo_1.createElement('<span class="wj-glyph-drag"></span>');r.insertBefore(e,r.firstChild)}let l=t._getBindingColumn(i,s,i.columns[o]),n=this._getColumnFilter(l);if(n){let e=wijmo_1.createElement('<span class="wj-filter wj-glyph-filter"></span>',r);wijmo_1.toggleClass(e,"wj-filter-on",n.isActive);wijmo_1.toggleClass(e,"wj-filter-off",!n.isActive)}wijmo_1.createElement('<span class="wj-remove">&times;</span>',r);this._divMarkers.appendChild(r)}}this._divPH.textContent=null!=this._placeholder?this._placeholder:wijmo_1.culture.GroupPanel.dragDrop;let r=this._divMarkers.children.length>0;this._divPH.style.display=r?"none":"";this._divMarkers.style.display=r?"":"none"}}hitTest(e){let t=e instanceof HTMLElement?e:e instanceof MouseEvent?e.target:null;wijmo_1.assert(null!=t,"MouseEvent or Element expected");let i=wijmo_1.closest(t,".wj-cell");if(wijmo_1.hasClass(i,"wj-cell")){let e=this._getElementIndex(i);return this._gds&&e>-1?this._gds[e]:null}return null}_filterChanged(){this._filterMarker=null}_getColumnFilter(e){let t=this._filter,i=null;t&&(i=t.filterColumns&&t.filterColumns.indexOf(e.binding)<0?null:t.getColumnFilter(e));return i}_editFilter(e){let t=this._gds,i=this._getElementIndex(e),r=t&&i>-1?t[i]:null,l=r instanceof wijmo_1.PropertyGroupDescription?r.propertyName:null,s=l?this._g.getColumn(l):null;s&&this._filter.editColumnFilter(s,null,e)}_addGroup(e,t){let i=this._getIndex(t),r=this._gds,l=this._maxGroups;for(let t=0;t<r.length;t++){let l=r[t];if(l instanceof wijmo_1.PropertyGroupDescription&&l.propertyName==e.binding){r.removeAt(t);t<i&&i--;break}}if(l>-1)for(let e=l-1;e<r.length;e++){this._removeGroup(e,r);e<i&&i--}if(l<0||r.length<l){let t=this._gdc?this._gdc(e.binding):null;t||(t=new wijmo_1.PropertyGroupDescription(e.binding));r.insert(i,t);if(e&&this.hideGroupedColumns){e.visible=!1;this._hiddenCols.push(e)}}}_moveGroup(e,t){let i=this._gds,r=this._getElementIndex(this._dragMarker),l=this._getIndex(t);l>r&&l--;l>=this._gds.length&&(l=this._gds.length);r!=l&&i.deferUpdate(()=>{let e=i[r];i.removeAt(r);i.insert(l,e)})}_removeGroup(e,t=this._gds){let i=t&&e>-1?t[e]:null,r=i instanceof wijmo_1.PropertyGroupDescription?i.propertyName:null,l=r?this._g.columns.getColumn(r):null;if(l){l.visible=!0;let e=this._hiddenCols,t=e.indexOf(l);t>-1&&e.splice(t,1)}i&&t.removeAt(e)}_getIndex(e){let t=e.clientX,i=this._divMarkers.children;for(let e=0;e<i.length;e++){let r=i[e].getBoundingClientRect();if((t-r.left)*(t-r.right)<0)return e}return i.length}_getElementIndex(e){if(e&&e.parentElement){let t=e.parentElement.children;for(let i=0;i<t.length;i++)if(t[i]==e)return i}return-1}_draggingColumn(e,t){let i=this._g,r=i._getBindingColumn(t.panel,t.row,i.columns[t.col]);this._dragCol=r.binding?r:null}_itemsSourceChanging(e,t){this._hiddenCols.forEach(e=>{e.visible=!0});this._hiddenCols=[]}_itemsSourceChanged(e,t){this._view&&this._view.collectionChanged.removeHandler(this._collectionChanged);this._view=this._g?this._g.collectionView:null;this._gds=this._view?this._view.groupDescriptions:null;this._view&&this._view.collectionChanged.addHandler(this._collectionChanged,this);this.invalidate()}_collectionChanged(e,t){t.action==wijmo_1.NotifyCollectionChangedAction.Reset&&this.invalidate()}_dragStart(e){wijmo_1._startDrag(e.dataTransfer,"move");this._dragMarker=e.target;this._dragCol=null}_dragOver(e){if(this._dragCol||this._dragMarker){e.dataTransfer.dropEffect="move";e.preventDefault();e.stopPropagation()}}_drop(e){this._dragMarker?this._moveGroup(this._dragMarker,e):this._dragCol&&this._addGroup(this._dragCol,e)}_dragEnd(e){this._dragMarker=this._dragCol=null}_click(e){let t=e.target,i=wijmo_1.closest(t,".wj-cell");if(wijmo_1.hasClass(i,"wj-cell"))if(wijmo_1.hasClass(t,"wj-filter")){if(i!=this._filterMarker){this._editFilter(i);this._filterMarker=i;return}}else if(wijmo_1.hasClass(t,"wj-remove")){let e=this._getElementIndex(i);this._removeGroup(e)}else this._updateSort(e,i);this._filterMarker=null;this.hostElement.focus()}_updateSort(e,t){let i=this._g,r=i.collectionView;if(!r||!r.canSort||i.allowSorting==wijmo_grid_1.AllowSorting.None)return;let l=this._getElementIndex(t),s=this._gds[l],o=s instanceof wijmo_1.PropertyGroupDescription?s.propertyName:null,n=o?i.getColumn(o):null;if(!n||!n.allowSorting)return;let h=n.sortMemberPath||n.binding,d=-1,a=r.sortDescriptions;for(let e=0;e<a.length;e++)if(a[e].property==h){d=e;break}let g=new wijmo_grid_1.CellRangeEventArgs(i.columnHeaders,new wijmo_grid_1.CellRange(0,n.index),e);if(i.onSortingColumn(g)){let t=e.ctrlKey||e.metaKey,r=e.shiftKey;a.deferUpdate(()=>{if(t&&r)a.clear();else if(d<0){this._g.allowSorting!=wijmo_grid_1.AllowSorting.MultiColumn&&a.clear();let e=new wijmo_1.SortDescription(h,!0);a.push(e)}else{let e=a[d].ascending;if(t||this.isTouching&&!e)a.splice(d,1);else{let t=new wijmo_1.SortDescription(h,!e);a.splice(d,1,t)}}});i.onSortedColumn(g)}}}GroupPanel.controlTemplate='<div><div wj-part="div-ph"></div><div wj-part="div-markers"></div></div>';exports.GroupPanel=GroupPanel;wijmo_1._registerModule("wijmo.grid.grouppanel",selfModule);