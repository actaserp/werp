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

"use strict";var __importStar=this&&this.__importStar||function(e){if(e&&e.__esModule)return e;var i={};if(null!=e)for(var o in e)Object.hasOwnProperty.call(e,o)&&(i[o]=e[o]);i.default=e;return i};Object.defineProperty(exports,"__esModule",{value:!0});const wijmo_vue2_base_1=require("wijmo/wijmo.vue2.base"),wjcOlap=__importStar(require("wijmo/wijmo.olap"));class WjPivotGridBehavior extends wijmo_vue2_base_1.WjComponentBehavior{}WjPivotGridBehavior.tag="wj-pivot-grid";WjPivotGridBehavior.props=["isDisabled","tabOrder","newRowAtTop","allowAddNew","allowDelete","allowDragging","allowMerging","allowResizing","allowSorting","allowPinning","autoScroll","autoRowHeights","autoSizeMode","autoGenerateColumns","autoSearch","caseSensitiveSearch","quickAutoSize","bigCheckboxes","childItemsPath","groupHeaderFormat","headersVisibility","showSelectedHeaders","showMarquee","showPlaceholders","itemFormatter","isReadOnly","imeEnabled","mergeManager","selectionMode","showGroups","showSort","showDropDown","showAlternatingRows","showErrors","alternatingRowStep","itemValidator","validateEdits","treeIndent","itemsSource","autoClipboard","expandSelectionOnCopyPaste","frozenRows","frozenColumns","cloneFrozenCells","deferResizing","sortRowIndex","editColumnIndex","stickyHeaders","preserveSelectedState","preserveOutlineState","preserveWhiteSpace","keyActionTab","keyActionEnter","rowHeaderPath","virtualizationThreshold","anchorCursor","lazyRender","refreshOnEdit","copyHeaders","columnGroups","showDetailOnDoubleClick","customContextMenu","collapsibleSubtotals","centerHeadersVertically","showColumnFieldHeaders","showRowFieldHeaders","showValueFieldHeaders","outlineMode"];WjPivotGridBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput","beginningEdit","cellEditEnded","cellEditEnding","prepareCellForEdit","formatItem","resizingColumn","resizedColumn","autoSizingColumn","autoSizedColumn","draggingColumn","draggingColumnOver","draggedColumn","sortingColumn","sortedColumn","pinningColumn","pinnedColumn","resizingRow","resizedRow","autoSizingRow","autoSizedRow","draggingRow","draggingRowOver","draggedRow","deletingRow","deletedRow","loadingRows","loadedRows","rowEditStarting","rowEditStarted","rowEditEnding","rowEditEnded","rowAdded","groupCollapsedChanging","groupCollapsedChanged","columnGroupCollapsedChanging","columnGroupCollapsedChanged","itemsSourceChanging","itemsSourceChanged","selectionChanging","selectionChanged","scrollPositionChanged","updatingView","updatedView","updatingLayout","updatedLayout","pasting","pasted","pastingCell","pastedCell","copying","copied"];WjPivotGridBehavior.classCtor=function(){return wjcOlap.PivotGrid};exports.WjPivotGrid=WjPivotGridBehavior.register();function registerV3WjPivotGrid(e){e.component(WjPivotGridBehavior.tag,exports.WjPivotGrid)}class WjPivotChartBehavior extends wijmo_vue2_base_1.WjComponentBehavior{}WjPivotChartBehavior.tag="wj-pivot-chart";WjPivotChartBehavior.props=["isDisabled","tabOrder","chartType","showHierarchicalAxes","showTotals","showTitle","showLegend","legendPosition","stacking","maxSeries","maxPoints","itemsSource","header","footer","headerStyle","footerStyle"];WjPivotChartBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput"];WjPivotChartBehavior.classCtor=function(){return wjcOlap.PivotChart};exports.WjPivotChart=WjPivotChartBehavior.register();function registerV3WjPivotChart(e){e.component(WjPivotChartBehavior.tag,exports.WjPivotChart)}class WjPivotPanelBehavior extends wijmo_vue2_base_1.WjComponentBehavior{}WjPivotPanelBehavior.tag="wj-pivot-panel";WjPivotPanelBehavior.props=["isDisabled","tabOrder","autoGenerateFields","viewDefinition","engine","itemsSource","showFieldIcons","restrictDragging","deferredUpdate"];WjPivotPanelBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput","itemsSourceChanged","viewDefinitionChanged","updatingView","updatedView"];WjPivotPanelBehavior.classCtor=function(){return wjcOlap.PivotPanel};exports.WjPivotPanel=WjPivotPanelBehavior.register();function registerV3WjPivotPanel(e){e.component(WjPivotPanelBehavior.tag,exports.WjPivotPanel)}class WjSlicerBehavior extends wijmo_vue2_base_1.WjComponentBehavior{}WjSlicerBehavior.tag="wj-slicer";WjSlicerBehavior.props=["isDisabled","tabOrder","field","showHeader","header","showCheckboxes","multiSelect"];WjSlicerBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput"];WjSlicerBehavior.classCtor=function(){return wjcOlap.Slicer};exports.WjSlicer=WjSlicerBehavior.register();function registerV3WjSlicer(e){e.component(WjSlicerBehavior.tag,exports.WjSlicer)}function registerOlap(e){if(wijmo_vue2_base_1.VueApi.isV3Plus){registerV3WjPivotGrid(e);registerV3WjPivotChart(e);registerV3WjPivotPanel(e);registerV3WjSlicer(e)}}exports.registerOlap=registerOlap;