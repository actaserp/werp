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

var __extends=this&&this.__extends||function(){var extendStatics=function(e,t){return(extendStatics=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var o in t)t.hasOwnProperty(o)&&(e[o]=t[o])})(e,t)};return function(e,t){extendStatics(e,t);function __(){this.constructor=e}e.prototype=null===t?Object.create(t):(__.prototype=t.prototype,new __)}}(),__rest=this&&this.__rest||function(e,t){var o={};for(var r in e)Object.prototype.hasOwnProperty.call(e,r)&&t.indexOf(r)<0&&(o[r]=e[r]);if(null!=e&&"function"==typeof Object.getOwnPropertySymbols){var i=0;for(r=Object.getOwnPropertySymbols(e);i<r.length;i++)t.indexOf(r[i])<0&&(o[r[i]]=e[r[i]])}return o};import{VueApi,WjComponentBehavior}from"wijmo/wijmo.vue2.base";import*as wjcCore from"wijmo/wijmo";import*as wjcGrid from"wijmo/wijmo.grid";import*as wjcInteropGrid from"wijmo/wijmo.interop.grid";export var CellTemplateType=wjcInteropGrid.GridCellTemplateType;var WjFlexGridBehavior=function(e){__extends(WjFlexGridBehavior,e);function WjFlexGridBehavior(){return null!==e&&e.apply(this,arguments)||this}WjFlexGridBehavior.prototype._createControl=function(){var t=e.prototype._createControl.call(this);new DirectiveCellFactory(t);return t};WjFlexGridBehavior.tag="wj-flex-grid";WjFlexGridBehavior.props=["isDisabled","tabOrder","newRowAtTop","allowAddNew","allowDelete","allowDragging","allowMerging","allowResizing","allowSorting","allowPinning","autoScroll","autoRowHeights","autoSizeMode","autoGenerateColumns","autoSearch","caseSensitiveSearch","quickAutoSize","bigCheckboxes","childItemsPath","groupHeaderFormat","headersVisibility","showSelectedHeaders","showMarquee","showPlaceholders","itemFormatter","isReadOnly","imeEnabled","mergeManager","selectionMode","showGroups","showSort","showDropDown","showAlternatingRows","showErrors","alternatingRowStep","itemValidator","validateEdits","treeIndent","itemsSource","autoClipboard","expandSelectionOnCopyPaste","frozenRows","frozenColumns","cloneFrozenCells","deferResizing","sortRowIndex","editColumnIndex","stickyHeaders","preserveSelectedState","preserveOutlineState","preserveWhiteSpace","keyActionTab","keyActionEnter","rowHeaderPath","virtualizationThreshold","anchorCursor","lazyRender","refreshOnEdit","copyHeaders","columnGroups"];WjFlexGridBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput","beginningEdit","cellEditEnded","cellEditEnding","prepareCellForEdit","formatItem","resizingColumn","resizedColumn","autoSizingColumn","autoSizedColumn","draggingColumn","draggingColumnOver","draggedColumn","sortingColumn","sortedColumn","pinningColumn","pinnedColumn","resizingRow","resizedRow","autoSizingRow","autoSizedRow","draggingRow","draggingRowOver","draggedRow","deletingRow","deletedRow","loadingRows","loadedRows","rowEditStarting","rowEditStarted","rowEditEnding","rowEditEnded","rowAdded","groupCollapsedChanging","groupCollapsedChanged","columnGroupCollapsedChanging","columnGroupCollapsedChanged","itemsSourceChanging","itemsSourceChanged","selectionChanging","selectionChanged","scrollPositionChanged","updatingView","updatedView","updatingLayout","updatedLayout","pasting","pasted","pastingCell","pastedCell","copying","copied"];WjFlexGridBehavior.classCtor=function(){return wjcGrid.FlexGrid};return WjFlexGridBehavior}(WjComponentBehavior);export var WjFlexGrid=WjFlexGridBehavior.register();function registerV3WjFlexGrid(e){e.component(WjFlexGridBehavior.tag,WjFlexGrid)}var WjFlexGridColumnBehavior=function(e){__extends(WjFlexGridColumnBehavior,e);function WjFlexGridColumnBehavior(){return null!==e&&e.apply(this,arguments)||this}WjFlexGridColumnBehavior.prototype._initParent=function(){var t=this.parent.control;if(t.autoGenerateColumns){t.autoGenerateColumns=!1;t.columns.clear()}e.prototype._initParent.call(this)};WjFlexGridColumnBehavior.tag="wj-flex-grid-column";WjFlexGridColumnBehavior.parentProp="columns";WjFlexGridColumnBehavior.props=["wjProperty","name","dataMap","dataType","binding","sortMemberPath","format","cellTemplate","header","width","maxLength","minWidth","maxWidth","align","allowDragging","allowSorting","allowResizing","allowMerging","aggregate","isReadOnly","cssClass","cssClassAll","isContentHtml","isSelected","visible","wordWrap","multiLine","mask","inputType","isRequired","showDropDown","dataMapEditor","dropDownCssClass","quickAutoSize","editor"];WjFlexGridColumnBehavior.events=["initialized"];WjFlexGridColumnBehavior.changeEvents={"grid.selectionChanged":["isSelected"]};WjFlexGridColumnBehavior.classCtor=function(){return wjcGrid.Column};return WjFlexGridColumnBehavior}(WjComponentBehavior);export var WjFlexGridColumn=WjFlexGridColumnBehavior.register();function registerV3WjFlexGridColumn(e){e.component(WjFlexGridColumnBehavior.tag,WjFlexGridColumn)}var WjFlexGridColumnGroupBehavior=function(e){__extends(WjFlexGridColumnGroupBehavior,e);function WjFlexGridColumnGroupBehavior(){return null!==e&&e.apply(this,arguments)||this}WjFlexGridColumnGroupBehavior.tag="wj-flex-grid-column-group";WjFlexGridColumnGroupBehavior.parentProp="columnGroups";WjFlexGridColumnGroupBehavior.props=["wjProperty","name","dataMap","dataType","binding","sortMemberPath","format","cellTemplate","header","width","maxLength","minWidth","maxWidth","align","allowDragging","allowSorting","allowResizing","allowMerging","aggregate","isReadOnly","cssClass","cssClassAll","isContentHtml","isSelected","visible","wordWrap","multiLine","mask","inputType","isRequired","showDropDown","dataMapEditor","dropDownCssClass","quickAutoSize","editor","collapseTo","isCollapsed"];WjFlexGridColumnGroupBehavior.events=["initialized"];WjFlexGridColumnGroupBehavior.changeEvents={"grid.selectionChanged":["isSelected"]};WjFlexGridColumnGroupBehavior.classCtor=function(){return wjcGrid.ColumnGroup};return WjFlexGridColumnGroupBehavior}(WjComponentBehavior);export var WjFlexGridColumnGroup=WjFlexGridColumnGroupBehavior.register();function registerV3WjFlexGridColumnGroup(e){e.component(WjFlexGridColumnGroupBehavior.tag,WjFlexGridColumnGroup)}var DirectiveCellFactory=function(e){__extends(DirectiveCellFactory,e);function DirectiveCellFactory(){return null!==e&&e.apply(this,arguments)||this}DirectiveCellFactory.prototype.shouldInstantiate=function(e){var t=e.templateCache;return null==t||t.column!==e.column||!t.cellCmp||t.templateContextProperty!==e.templateContextProperty||e.cell.firstChild!=t.rootElement};DirectiveCellFactory.prototype.renderTemplate=function(e,t){var o=e.row,r={},i=e.templateContext;e.cellBindingsData=this.setBindingsData(r,o,e.column,o.dataItem,e.cellValue,i.valuePaths);if(t){var l=e.cell,n=i._instantiateTemplate(l,r.cell),a=e.templateCache={column:e.column,rootElement:n.$el,templateContextProperty:e.templateContextProperty,cellCmp:n};l[e.templateContextProperty]=a}else{var p=e.templateCache.cellCmp;p.context=r.cell;p.$forceUpdate()}};DirectiveCellFactory.prototype.disposeTemplate=function(t,o,r){var i=o&&o.cellCmp;if(i){i.$destroy();o.cellCmp=null;e.prototype.disposeTemplate.call(this,t,o,r)}};DirectiveCellFactory.prototype.clearCell=function(e){e.textContent=""};DirectiveCellFactory.prototype.applyImmediately=function(e){};DirectiveCellFactory.prototype.flushPendingEvents=function(e){};DirectiveCellFactory.prototype.getEditorFocusFlag=function(){return!0};DirectiveCellFactory.prototype.setEditorFocusFlag=function(e){};return DirectiveCellFactory}(wjcInteropGrid.DirectiveCellFactoryBase);export{DirectiveCellFactory};export var WjFlexGridCellTemplateDefinition={props:{cellOverflow:{default:void 0},cellType:{default:void 0},autoSizeRows:{default:!0},forceFullEdit:{default:!0}},render:function(e){return VueApi.isV3Plus?VueApi.h("div"):e("div")},mounted:function(){var e=this,t=this.$parent;if(t){var o=t[WjComponentBehavior._behProp];o._mountedCB((function(){var r=e.ownerControl=o.control;if(r instanceof wjcGrid.FlexGrid)e.grid=r;else if(r instanceof wjcGrid.Column){e.column=r;var i=t,l=void 0;do{var n=(i=i.$parent)&&i[WjComponentBehavior._behProp];l=n&&n.control}while(!(l instanceof wjcGrid.FlexGrid));e.grid=l}e._attachToControl()}))}},methods:{_attachToControl:function(){var e=this.cellTypeEnum=wjcCore.asEnum(this.cellType,CellTemplateType),t=this.ownerControl;t[DirectiveCellFactory.getTemplContextProp(e)]=this;t instanceof wjcGrid.Column&&(e===CellTemplateType.Cell||e===CellTemplateType.ColumnHeader||e===CellTemplateType.ColumnFooter)&&t._setFlag(wjcGrid.RowColFlags.HasTemplate,!0);this.grid.invalidate()},_detachFromControl:function(){if(null!=this.cellTypeEnum){this.ownerControl[DirectiveCellFactory.getTemplContextProp(this.cellTypeEnum)]=null;this.grid.invalidate()}},_instantiateTemplate:function(e,t){var o=VueApi.isV3Plus?new V3CellTemplateCmp({parent:this}):new CellTemplateCmp({parent:this});o.context=t;o.slotFn=VueApi.isV3Plus?this.$slots.default:this.$scopedSlots.default;o.$mount();e&&e.appendChild(o.$el);return o}}};WjFlexGridCellTemplateDefinition[VueApi.isV3Plus?"unmounted":"destroyed"]=function(){this._detachFromControl()};var WjFlexGridCellTemplateTag="wj-flex-grid-cell-template";export var WjFlexGridCellTemplate=VueApi.isV3Plus?WjFlexGridCellTemplateDefinition:VueApi.component(WjFlexGridCellTemplateTag,WjFlexGridCellTemplateDefinition);function registerV3WjFlexGridCellTemplate(e){e.component(WjFlexGridCellTemplateTag,WjFlexGridCellTemplate)}var CellTemplateCmp=VueApi.extend({render:function(e){var t=this.slotFn;return e("div",t&&[t(this.context)])}}),V3CellTemplateCmp=function(){function V3CellTemplateCmp(e){this.props=e;this._host=document.createElement("div")}V3CellTemplateCmp.prototype.$mount=function(){var e=this,t=VueApi.h,o=this.props,r=o.parent,i=__rest(o,["parent"]);VueApi.render(t({parent:r,render:function(){return t("div",i,e.slotFn&&e.slotFn(e.context))}}),this.$el)};Object.defineProperty(V3CellTemplateCmp.prototype,"$el",{get:function(){return this._host},enumerable:!0,configurable:!0});V3CellTemplateCmp.prototype.$destroy=function(){VueApi.render(null,this.$el);this._host=null};V3CellTemplateCmp.prototype.$forceUpdate=function(){this._host&&this.$mount()};return V3CellTemplateCmp}();export function registerGrid(e){if(VueApi.isV3Plus){registerV3WjFlexGrid(e);registerV3WjFlexGridColumn(e);registerV3WjFlexGridColumnGroup(e);registerV3WjFlexGridCellTemplate(e)}}