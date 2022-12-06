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

"use strict";var WjTransposedGrid_1,WjTransposedGridRow_1,__decorate=this&&this.__decorate||function(e,o,r,t){var i,n=arguments.length,a=n<3?o:null===t?t=Object.getOwnPropertyDescriptor(o,r):t;if("object"==typeof Reflect&&"function"==typeof Reflect.decorate)a=Reflect.decorate(e,o,r,t);else for(var s=e.length-1;s>=0;s--)(i=e[s])&&(a=(n<3?i(a):n>3?i(o,r,a):i(o,r))||a);return n>3&&a&&Object.defineProperty(o,r,a),a},__param=this&&this.__param||function(e,o){return function(r,t){o(r,t,e)}},__importStar=this&&this.__importStar||function(e){if(e&&e.__esModule)return e;var o={};if(null!=e)for(var r in e)Object.hasOwnProperty.call(e,r)&&(o[r]=e[r]);o.default=e;return o};Object.defineProperty(exports,"__esModule",{value:!0});const core_1=require("@angular/core"),common_1=require("@angular/common"),forms_1=require("@angular/forms"),wijmo_angular2_directiveBase_1=require("wijmo/wijmo.angular2.directiveBase"),wjcGridTransposed=__importStar(require("wijmo/wijmo.grid.transposed"));var wjTransposedGridMeta={selector:"wj-transposed-grid",template:"<div><ng-content></ng-content></div>",inputs:["wjModelProperty","autoGenerateRows","isDisabled","tabOrder","newRowAtTop","allowAddNew","allowDelete","allowDragging","allowMerging","allowResizing","allowSorting","allowPinning","autoScroll","autoRowHeights","autoSizeMode","autoGenerateColumns","autoSearch","caseSensitiveSearch","quickAutoSize","bigCheckboxes","childItemsPath","groupHeaderFormat","headersVisibility","showSelectedHeaders","showMarquee","showPlaceholders","itemFormatter","isReadOnly","imeEnabled","mergeManager","selectionMode","showGroups","showSort","showDropDown","showAlternatingRows","showErrors","alternatingRowStep","itemValidator","validateEdits","treeIndent","itemsSource","autoClipboard","expandSelectionOnCopyPaste","frozenRows","frozenColumns","cloneFrozenCells","deferResizing","sortRowIndex","editColumnIndex","stickyHeaders","preserveSelectedState","preserveOutlineState","preserveWhiteSpace","keyActionTab","keyActionEnter","rowHeaderPath","virtualizationThreshold","anchorCursor","lazyRender","refreshOnEdit","copyHeaders","columnGroups","rowGroups"],outputs:["initialized","gotFocusNg: gotFocus","lostFocusNg: lostFocus","refreshingNg: refreshing","refreshedNg: refreshed","invalidInputNg: invalidInput","beginningEditNg: beginningEdit","cellEditEndedNg: cellEditEnded","cellEditEndingNg: cellEditEnding","prepareCellForEditNg: prepareCellForEdit","formatItemNg: formatItem","resizingColumnNg: resizingColumn","resizedColumnNg: resizedColumn","autoSizingColumnNg: autoSizingColumn","autoSizedColumnNg: autoSizedColumn","draggingColumnNg: draggingColumn","draggingColumnOverNg: draggingColumnOver","draggedColumnNg: draggedColumn","sortingColumnNg: sortingColumn","sortedColumnNg: sortedColumn","pinningColumnNg: pinningColumn","pinnedColumnNg: pinnedColumn","resizingRowNg: resizingRow","resizedRowNg: resizedRow","autoSizingRowNg: autoSizingRow","autoSizedRowNg: autoSizedRow","draggingRowNg: draggingRow","draggingRowOverNg: draggingRowOver","draggedRowNg: draggedRow","deletingRowNg: deletingRow","deletedRowNg: deletedRow","loadingRowsNg: loadingRows","loadedRowsNg: loadedRows","rowEditStartingNg: rowEditStarting","rowEditStartedNg: rowEditStarted","rowEditEndingNg: rowEditEnding","rowEditEndedNg: rowEditEnded","rowAddedNg: rowAdded","groupCollapsedChangingNg: groupCollapsedChanging","groupCollapsedChangedNg: groupCollapsedChanged","columnGroupCollapsedChangingNg: columnGroupCollapsedChanging","columnGroupCollapsedChangedNg: columnGroupCollapsedChanged","itemsSourceChangingNg: itemsSourceChanging","itemsSourceChangedNg: itemsSourceChanged","selectionChangingNg: selectionChanging","selectionChangedNg: selectionChanged","scrollPositionChangedNg: scrollPositionChanged","updatingViewNg: updatingView","updatedViewNg: updatedView","updatingLayoutNg: updatingLayout","updatedLayoutNg: updatedLayout","pastingNg: pasting","pastedNg: pasted","pastingCellNg: pastingCell","pastedCellNg: pastedCell","copyingNg: copying","copiedNg: copied"],providers:[{provide:forms_1.NG_VALUE_ACCESSOR,useFactory:wijmo_angular2_directiveBase_1.WjValueAccessorFactory,multi:!0,deps:["WjComponent"]}]};exports.wjTransposedGridMeta=wjTransposedGridMeta;let WjTransposedGrid=WjTransposedGrid_1=class WjTransposedGrid extends wjcGridTransposed.TransposedGrid{constructor(e,o,r){super(wijmo_angular2_directiveBase_1.WjDirectiveBehavior.getHostElement(e,o));this.isInitialized=!1;this._wjBehaviour=wijmo_angular2_directiveBase_1.WjDirectiveBehavior.attach(this,e,o,r);this.created()}created(){}ngOnInit(){this._wjBehaviour.ngOnInit()}ngAfterViewInit(){this._wjBehaviour.ngAfterViewInit()}ngOnDestroy(){this._wjBehaviour.ngOnDestroy()}addEventListener(e,o,r,t=!1){let i=wijmo_angular2_directiveBase_1.WjDirectiveBehavior,n=i.getZone(this);n&&i.outsideZoneEvents[o]?n.runOutsideAngular(()=>{super.addEventListener(e,o,r,t)}):super.addEventListener(e,o,r,t)}};WjTransposedGrid.meta={outputs:wjTransposedGridMeta.outputs};WjTransposedGrid=WjTransposedGrid_1=__decorate([core_1.Component({selector:wjTransposedGridMeta.selector,template:wjTransposedGridMeta.template,inputs:wjTransposedGridMeta.inputs,outputs:wjTransposedGridMeta.outputs,providers:[{provide:"WjComponent",useExisting:core_1.forwardRef(()=>WjTransposedGrid_1)},...wjTransposedGridMeta.providers]}),__param(0,core_1.Inject(core_1.ElementRef)),__param(1,core_1.Inject(core_1.Injector)),__param(2,core_1.Inject("WjComponent")),__param(2,core_1.SkipSelf()),__param(2,core_1.Optional())],WjTransposedGrid);exports.WjTransposedGrid=WjTransposedGrid;var wjTransposedGridRowMeta={selector:"wj-transposed-grid-row",template:"",inputs:["asyncBindings","wjProperty","name","dataMap","dataType","binding","sortMemberPath","format","cellTemplate","header","width","maxLength","minWidth","maxWidth","align","allowDragging","allowSorting","allowResizing","allowMerging","aggregate","isReadOnly","cssClass","cssClassAll","isContentHtml","isSelected","visible","wordWrap","multiLine","mask","inputType","isRequired","showDropDown","dataMapEditor","dropDownCssClass","quickAutoSize","editor"],outputs:["initialized","isSelectedChangePC: isSelectedChange"],providers:[]};exports.wjTransposedGridRowMeta=wjTransposedGridRowMeta;let WjTransposedGridRow=WjTransposedGridRow_1=class WjTransposedGridRow extends wjcGridTransposed.TransposedGridRow{constructor(e,o,r){super();this.isInitialized=!1;this.wjProperty="_rowInfo";let t=(this._wjBehaviour=wijmo_angular2_directiveBase_1.WjDirectiveBehavior.attach(this,e,o,r)).parentBehavior.directive;if(t.autoGenerateRows){t.autoGenerateRows=!1;t._rowInfo.clear()}this.created()}created(){}ngOnInit(){this._wjBehaviour.ngOnInit()}ngAfterViewInit(){this._wjBehaviour.ngAfterViewInit()}ngOnDestroy(){this._wjBehaviour.ngOnDestroy()}};WjTransposedGridRow.meta={outputs:wjTransposedGridRowMeta.outputs,changeEvents:{"grid.selectionChanged":["isSelected"]}};WjTransposedGridRow=WjTransposedGridRow_1=__decorate([core_1.Component({selector:wjTransposedGridRowMeta.selector,template:wjTransposedGridRowMeta.template,inputs:wjTransposedGridRowMeta.inputs,outputs:wjTransposedGridRowMeta.outputs,providers:[{provide:"WjComponent",useExisting:core_1.forwardRef(()=>WjTransposedGridRow_1)},...wjTransposedGridRowMeta.providers]}),__param(0,core_1.Inject(core_1.ElementRef)),__param(1,core_1.Inject(core_1.Injector)),__param(2,core_1.Inject("WjComponent")),__param(2,core_1.SkipSelf()),__param(2,core_1.Optional())],WjTransposedGridRow);exports.WjTransposedGridRow=WjTransposedGridRow;let moduleExports=[WjTransposedGrid,WjTransposedGridRow],WjGridTransposedModule=class WjGridTransposedModule{};WjGridTransposedModule=__decorate([core_1.NgModule({imports:[common_1.CommonModule],declarations:[...moduleExports],exports:[...moduleExports]})],WjGridTransposedModule);exports.WjGridTransposedModule=WjGridTransposedModule;