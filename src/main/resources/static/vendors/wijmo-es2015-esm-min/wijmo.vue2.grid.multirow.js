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

import{VueApi,WjComponentBehavior}from"wijmo/wijmo.vue2.base";import*as wjcGridMultirow from"wijmo/wijmo.grid.multirow";import*as wjGrid from"wijmo/wijmo.vue2.grid";class WjMultiRowBehavior extends WjComponentBehavior{_createControl(){let e=super._createControl();new wjGrid.DirectiveCellFactory(e);return e}}WjMultiRowBehavior.tag="wj-multi-row";WjMultiRowBehavior.props=["isDisabled","tabOrder","newRowAtTop","allowAddNew","allowDelete","allowDragging","allowMerging","allowResizing","allowSorting","allowPinning","autoScroll","autoRowHeights","autoSizeMode","autoGenerateColumns","autoSearch","caseSensitiveSearch","quickAutoSize","bigCheckboxes","childItemsPath","groupHeaderFormat","headersVisibility","showSelectedHeaders","showMarquee","showPlaceholders","itemFormatter","isReadOnly","imeEnabled","mergeManager","selectionMode","showGroups","showSort","showDropDown","showAlternatingRows","showErrors","alternatingRowStep","itemValidator","validateEdits","treeIndent","itemsSource","autoClipboard","expandSelectionOnCopyPaste","frozenRows","frozenColumns","cloneFrozenCells","deferResizing","sortRowIndex","editColumnIndex","stickyHeaders","preserveSelectedState","preserveOutlineState","preserveWhiteSpace","keyActionTab","keyActionEnter","rowHeaderPath","virtualizationThreshold","anchorCursor","lazyRender","refreshOnEdit","copyHeaders","columnGroups","layoutDefinition","headerLayoutDefinition","centerHeadersVertically","collapsedHeaders","showHeaderCollapseButton","multiRowGroupHeaders"];WjMultiRowBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput","beginningEdit","cellEditEnded","cellEditEnding","prepareCellForEdit","formatItem","resizingColumn","resizedColumn","autoSizingColumn","autoSizedColumn","draggingColumn","draggingColumnOver","draggedColumn","sortingColumn","sortedColumn","pinningColumn","pinnedColumn","resizingRow","resizedRow","autoSizingRow","autoSizedRow","draggingRow","draggingRowOver","draggedRow","deletingRow","deletedRow","loadingRows","loadedRows","rowEditStarting","rowEditStarted","rowEditEnding","rowEditEnded","rowAdded","groupCollapsedChanging","groupCollapsedChanged","columnGroupCollapsedChanging","columnGroupCollapsedChanged","itemsSourceChanging","itemsSourceChanged","selectionChanging","selectionChanged","scrollPositionChanged","updatingView","updatedView","updatingLayout","updatedLayout","pasting","pasted","pastingCell","pastedCell","copying","copied","collapsedHeadersChanging"];WjMultiRowBehavior.changeEvents={collapsedHeadersChanged:["collapsedHeaders"]};WjMultiRowBehavior.classCtor=function(){return wjcGridMultirow.MultiRow};export var WjMultiRow=WjMultiRowBehavior.register();function registerV3WjMultiRow(e){e.component(WjMultiRowBehavior.tag,WjMultiRow)}class WjMultiRowCellBehavior extends WjComponentBehavior{}WjMultiRowCellBehavior.tag="wj-multi-row-cell";WjMultiRowCellBehavior.parentProp="cells";WjMultiRowCellBehavior.props=["wjProperty","name","dataMap","dataType","binding","sortMemberPath","format","cellTemplate","header","width","maxLength","minWidth","maxWidth","align","allowDragging","allowSorting","allowResizing","allowMerging","aggregate","isReadOnly","cssClass","cssClassAll","isContentHtml","isSelected","visible","wordWrap","multiLine","mask","inputType","isRequired","showDropDown","dataMapEditor","dropDownCssClass","quickAutoSize","editor","colspan","rowspan"];WjMultiRowCellBehavior.events=["initialized"];WjMultiRowCellBehavior.changeEvents={"grid.selectionChanged":["isSelected"]};WjMultiRowCellBehavior.classCtor=function(){return wjcGridMultirow.MultiRowCell};export var WjMultiRowCell=WjMultiRowCellBehavior.register();function registerV3WjMultiRowCell(e){e.component(WjMultiRowCellBehavior.tag,WjMultiRowCell)}class WjMultiRowCellGroupBehavior extends WjComponentBehavior{}WjMultiRowCellGroupBehavior.tag="wj-multi-row-cell-group";WjMultiRowCellGroupBehavior.parentProp="layoutDefinition";WjMultiRowCellGroupBehavior.props=["wjProperty","name","dataMap","dataType","binding","sortMemberPath","format","cellTemplate","header","width","maxLength","minWidth","maxWidth","align","allowDragging","allowSorting","allowResizing","allowMerging","aggregate","isReadOnly","cssClass","cssClassAll","isContentHtml","isSelected","visible","wordWrap","multiLine","mask","inputType","isRequired","showDropDown","dataMapEditor","dropDownCssClass","quickAutoSize","editor","colspan","rowspan"];WjMultiRowCellGroupBehavior.events=["initialized"];WjMultiRowCellGroupBehavior.changeEvents={"grid.selectionChanged":["isSelected"]};WjMultiRowCellGroupBehavior.classCtor=function(){return wjcGridMultirow.MultiRowCellGroup};export var WjMultiRowCellGroup=WjMultiRowCellGroupBehavior.register();function registerV3WjMultiRowCellGroup(e){e.component(WjMultiRowCellGroupBehavior.tag,WjMultiRowCellGroup)}const WjMultiRowCellTemplateTag="wj-multi-row-cell-template";export var WjMultiRowCellTemplate=VueApi.isV3Plus?wjGrid.WjFlexGridCellTemplateDefinition:VueApi.component(WjMultiRowCellTemplateTag,wjGrid.WjFlexGridCellTemplateDefinition);function registerV3WjMultiRowCellTemplate(e){e.component(WjMultiRowCellTemplateTag,WjMultiRowCellTemplate)}export function registerGridMultirow(e){if(VueApi.isV3Plus){registerV3WjMultiRow(e);registerV3WjMultiRowCell(e);registerV3WjMultiRowCellGroup(e);registerV3WjMultiRowCellTemplate(e)}}