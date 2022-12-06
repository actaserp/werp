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

"use strict";var __extends=this&&this.__extends||function(){var extendStatics=function(e,o){return(extendStatics=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,o){e.__proto__=o}||function(e,o){for(var t in o)o.hasOwnProperty(t)&&(e[t]=o[t])})(e,o)};return function(e,o){extendStatics(e,o);function __(){this.constructor=e}e.prototype=null===o?Object.create(o):(__.prototype=o.prototype,new __)}}(),__decorate=this&&this.__decorate||function(e,o,t,r){var n,i=arguments.length,a=i<3?o:null===r?r=Object.getOwnPropertyDescriptor(o,t):r;if("object"==typeof Reflect&&"function"==typeof Reflect.decorate)a=Reflect.decorate(e,o,t,r);else for(var s=e.length-1;s>=0;s--)(n=e[s])&&(a=(i<3?n(a):i>3?n(o,t,a):n(o,t))||a);return i>3&&a&&Object.defineProperty(o,t,a),a},__param=this&&this.__param||function(e,o){return function(t,r){o(t,r,e)}},__importStar=this&&this.__importStar||function(e){if(e&&e.__esModule)return e;var o={};if(null!=e)for(var t in e)Object.hasOwnProperty.call(e,t)&&(o[t]=e[t]);o.default=e;return o};Object.defineProperty(exports,"__esModule",{value:!0});var core_1=require("@angular/core"),common_1=require("@angular/common"),forms_1=require("@angular/forms"),wijmo_angular2_directiveBase_1=require("wijmo/wijmo.angular2.directiveBase"),wjcGridTransposedmultirow=__importStar(require("wijmo/wijmo.grid.transposedmultirow")),wjTransposedMultiRowMeta={selector:"wj-transposed-multi-row",template:"",inputs:["wjModelProperty","isDisabled","tabOrder","newRowAtTop","allowAddNew","allowDelete","allowDragging","allowMerging","allowResizing","allowSorting","allowPinning","autoScroll","autoRowHeights","autoSizeMode","autoGenerateColumns","autoSearch","caseSensitiveSearch","quickAutoSize","bigCheckboxes","childItemsPath","groupHeaderFormat","headersVisibility","showSelectedHeaders","showMarquee","showPlaceholders","itemFormatter","isReadOnly","imeEnabled","mergeManager","selectionMode","showGroups","showSort","showDropDown","showAlternatingRows","showErrors","alternatingRowStep","itemValidator","validateEdits","treeIndent","itemsSource","autoClipboard","expandSelectionOnCopyPaste","frozenRows","frozenColumns","cloneFrozenCells","deferResizing","sortRowIndex","editColumnIndex","stickyHeaders","preserveSelectedState","preserveOutlineState","preserveWhiteSpace","keyActionTab","keyActionEnter","rowHeaderPath","virtualizationThreshold","anchorCursor","lazyRender","refreshOnEdit","copyHeaders","columnGroups","layoutDefinition"],outputs:["initialized","gotFocusNg: gotFocus","lostFocusNg: lostFocus","refreshingNg: refreshing","refreshedNg: refreshed","invalidInputNg: invalidInput","beginningEditNg: beginningEdit","cellEditEndedNg: cellEditEnded","cellEditEndingNg: cellEditEnding","prepareCellForEditNg: prepareCellForEdit","formatItemNg: formatItem","resizingColumnNg: resizingColumn","resizedColumnNg: resizedColumn","autoSizingColumnNg: autoSizingColumn","autoSizedColumnNg: autoSizedColumn","draggingColumnNg: draggingColumn","draggingColumnOverNg: draggingColumnOver","draggedColumnNg: draggedColumn","sortingColumnNg: sortingColumn","sortedColumnNg: sortedColumn","pinningColumnNg: pinningColumn","pinnedColumnNg: pinnedColumn","resizingRowNg: resizingRow","resizedRowNg: resizedRow","autoSizingRowNg: autoSizingRow","autoSizedRowNg: autoSizedRow","draggingRowNg: draggingRow","draggingRowOverNg: draggingRowOver","draggedRowNg: draggedRow","deletingRowNg: deletingRow","deletedRowNg: deletedRow","loadingRowsNg: loadingRows","loadedRowsNg: loadedRows","rowEditStartingNg: rowEditStarting","rowEditStartedNg: rowEditStarted","rowEditEndingNg: rowEditEnding","rowEditEndedNg: rowEditEnded","rowAddedNg: rowAdded","groupCollapsedChangingNg: groupCollapsedChanging","groupCollapsedChangedNg: groupCollapsedChanged","columnGroupCollapsedChangingNg: columnGroupCollapsedChanging","columnGroupCollapsedChangedNg: columnGroupCollapsedChanged","itemsSourceChangingNg: itemsSourceChanging","itemsSourceChangedNg: itemsSourceChanged","selectionChangingNg: selectionChanging","selectionChangedNg: selectionChanged","scrollPositionChangedNg: scrollPositionChanged","updatingViewNg: updatingView","updatedViewNg: updatedView","updatingLayoutNg: updatingLayout","updatedLayoutNg: updatedLayout","pastingNg: pasting","pastedNg: pasted","pastingCellNg: pastingCell","pastedCellNg: pastedCell","copyingNg: copying","copiedNg: copied"],providers:[{provide:forms_1.NG_VALUE_ACCESSOR,useFactory:wijmo_angular2_directiveBase_1.WjValueAccessorFactory,multi:!0,deps:["WjComponent"]}]};exports.wjTransposedMultiRowMeta=wjTransposedMultiRowMeta;var WjTransposedMultiRow=function(e){__extends(WjTransposedMultiRow,e);function WjTransposedMultiRow(o,t,r){var n=e.call(this,wijmo_angular2_directiveBase_1.WjDirectiveBehavior.getHostElement(o,t))||this;n.isInitialized=!1;n._wjBehaviour=wijmo_angular2_directiveBase_1.WjDirectiveBehavior.attach(n,o,t,r);n.created();return n}o=WjTransposedMultiRow;WjTransposedMultiRow.prototype.created=function(){};WjTransposedMultiRow.prototype.ngOnInit=function(){this._wjBehaviour.ngOnInit()};WjTransposedMultiRow.prototype.ngAfterViewInit=function(){this._wjBehaviour.ngAfterViewInit()};WjTransposedMultiRow.prototype.ngOnDestroy=function(){this._wjBehaviour.ngOnDestroy()};WjTransposedMultiRow.prototype.addEventListener=function(o,t,r,n){var i=this;void 0===n&&(n=!1);var a=wijmo_angular2_directiveBase_1.WjDirectiveBehavior,s=a.getZone(this);s&&a.outsideZoneEvents[t]?s.runOutsideAngular((function(){e.prototype.addEventListener.call(i,o,t,r,n)})):e.prototype.addEventListener.call(this,o,t,r,n)};var o;WjTransposedMultiRow.meta={outputs:wjTransposedMultiRowMeta.outputs};return WjTransposedMultiRow=o=__decorate([core_1.Component({selector:wjTransposedMultiRowMeta.selector,template:wjTransposedMultiRowMeta.template,inputs:wjTransposedMultiRowMeta.inputs,outputs:wjTransposedMultiRowMeta.outputs,providers:[{provide:"WjComponent",useExisting:core_1.forwardRef((function(){return o}))}].concat(wjTransposedMultiRowMeta.providers)}),__param(0,core_1.Inject(core_1.ElementRef)),__param(1,core_1.Inject(core_1.Injector)),__param(2,core_1.Inject("WjComponent")),__param(2,core_1.SkipSelf()),__param(2,core_1.Optional())],WjTransposedMultiRow)}(wjcGridTransposedmultirow.TransposedMultiRow);exports.WjTransposedMultiRow=WjTransposedMultiRow;var moduleExports=[WjTransposedMultiRow],WjGridTransposedmultirowModule=function(){function WjGridTransposedmultirowModule(){}return WjGridTransposedmultirowModule=__decorate([core_1.NgModule({imports:[common_1.CommonModule],declarations:moduleExports.slice(),exports:moduleExports.slice()})],WjGridTransposedmultirowModule)}();exports.WjGridTransposedmultirowModule=WjGridTransposedmultirowModule;