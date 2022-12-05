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

var __extends=this&&this.__extends||function(){var extendStatics=function(e,o){return(extendStatics=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,o){e.__proto__=o}||function(e,o){for(var t in o)o.hasOwnProperty(t)&&(e[t]=o[t])})(e,o)};return function(e,o){extendStatics(e,o);function __(){this.constructor=e}e.prototype=null===o?Object.create(o):(__.prototype=o.prototype,new __)}}(),__decorate=this&&this.__decorate||function(e,o,t,n){var r,i=arguments.length,a=i<3?o:null===n?n=Object.getOwnPropertyDescriptor(o,t):n;if("object"==typeof Reflect&&"function"==typeof Reflect.decorate)a=Reflect.decorate(e,o,t,n);else for(var d=e.length-1;d>=0;d--)(r=e[d])&&(a=(i<3?r(a):i>3?r(o,t,a):r(o,t))||a);return i>3&&a&&Object.defineProperty(o,t,a),a},__param=this&&this.__param||function(e,o){return function(t,n){o(t,n,e)}};import{Component,NgModule,ElementRef,Injector,Optional,forwardRef,Inject,SkipSelf}from"@angular/core";import{CommonModule}from"@angular/common";import{NG_VALUE_ACCESSOR}from"@angular/forms";import{WjDirectiveBehavior,WjValueAccessorFactory}from"wijmo/wijmo.angular2.directiveBase";import*as wjcGridTransposedmultirow from"wijmo/wijmo.grid.transposedmultirow";var wjTransposedMultiRowMeta={selector:"wj-transposed-multi-row",template:"",inputs:["wjModelProperty","isDisabled","tabOrder","newRowAtTop","allowAddNew","allowDelete","allowDragging","allowMerging","allowResizing","allowSorting","allowPinning","autoScroll","autoRowHeights","autoSizeMode","autoGenerateColumns","autoSearch","caseSensitiveSearch","quickAutoSize","bigCheckboxes","childItemsPath","groupHeaderFormat","headersVisibility","showSelectedHeaders","showMarquee","showPlaceholders","itemFormatter","isReadOnly","imeEnabled","mergeManager","selectionMode","showGroups","showSort","showDropDown","showAlternatingRows","showErrors","alternatingRowStep","itemValidator","validateEdits","treeIndent","itemsSource","autoClipboard","expandSelectionOnCopyPaste","frozenRows","frozenColumns","cloneFrozenCells","deferResizing","sortRowIndex","editColumnIndex","stickyHeaders","preserveSelectedState","preserveOutlineState","preserveWhiteSpace","keyActionTab","keyActionEnter","rowHeaderPath","virtualizationThreshold","anchorCursor","lazyRender","refreshOnEdit","copyHeaders","columnGroups","layoutDefinition"],outputs:["initialized","gotFocusNg: gotFocus","lostFocusNg: lostFocus","refreshingNg: refreshing","refreshedNg: refreshed","invalidInputNg: invalidInput","beginningEditNg: beginningEdit","cellEditEndedNg: cellEditEnded","cellEditEndingNg: cellEditEnding","prepareCellForEditNg: prepareCellForEdit","formatItemNg: formatItem","resizingColumnNg: resizingColumn","resizedColumnNg: resizedColumn","autoSizingColumnNg: autoSizingColumn","autoSizedColumnNg: autoSizedColumn","draggingColumnNg: draggingColumn","draggingColumnOverNg: draggingColumnOver","draggedColumnNg: draggedColumn","sortingColumnNg: sortingColumn","sortedColumnNg: sortedColumn","pinningColumnNg: pinningColumn","pinnedColumnNg: pinnedColumn","resizingRowNg: resizingRow","resizedRowNg: resizedRow","autoSizingRowNg: autoSizingRow","autoSizedRowNg: autoSizedRow","draggingRowNg: draggingRow","draggingRowOverNg: draggingRowOver","draggedRowNg: draggedRow","deletingRowNg: deletingRow","deletedRowNg: deletedRow","loadingRowsNg: loadingRows","loadedRowsNg: loadedRows","rowEditStartingNg: rowEditStarting","rowEditStartedNg: rowEditStarted","rowEditEndingNg: rowEditEnding","rowEditEndedNg: rowEditEnded","rowAddedNg: rowAdded","groupCollapsedChangingNg: groupCollapsedChanging","groupCollapsedChangedNg: groupCollapsedChanged","columnGroupCollapsedChangingNg: columnGroupCollapsedChanging","columnGroupCollapsedChangedNg: columnGroupCollapsedChanged","itemsSourceChangingNg: itemsSourceChanging","itemsSourceChangedNg: itemsSourceChanged","selectionChangingNg: selectionChanging","selectionChangedNg: selectionChanged","scrollPositionChangedNg: scrollPositionChanged","updatingViewNg: updatingView","updatedViewNg: updatedView","updatingLayoutNg: updatingLayout","updatedLayoutNg: updatedLayout","pastingNg: pasting","pastedNg: pasted","pastingCellNg: pastingCell","pastedCellNg: pastedCell","copyingNg: copying","copiedNg: copied"],providers:[{provide:NG_VALUE_ACCESSOR,useFactory:WjValueAccessorFactory,multi:!0,deps:["WjComponent"]}]};export{wjTransposedMultiRowMeta};var WjTransposedMultiRow=function(e){__extends(WjTransposedMultiRow,e);function WjTransposedMultiRow(o,t,n){var r=e.call(this,WjDirectiveBehavior.getHostElement(o,t))||this;r.isInitialized=!1;r._wjBehaviour=WjDirectiveBehavior.attach(r,o,t,n);r.created();return r}o=WjTransposedMultiRow;WjTransposedMultiRow.prototype.created=function(){};WjTransposedMultiRow.prototype.ngOnInit=function(){this._wjBehaviour.ngOnInit()};WjTransposedMultiRow.prototype.ngAfterViewInit=function(){this._wjBehaviour.ngAfterViewInit()};WjTransposedMultiRow.prototype.ngOnDestroy=function(){this._wjBehaviour.ngOnDestroy()};WjTransposedMultiRow.prototype.addEventListener=function(o,t,n,r){var i=this;void 0===r&&(r=!1);var a=WjDirectiveBehavior,d=a.getZone(this);d&&a.outsideZoneEvents[t]?d.runOutsideAngular((function(){e.prototype.addEventListener.call(i,o,t,n,r)})):e.prototype.addEventListener.call(this,o,t,n,r)};var o;WjTransposedMultiRow.meta={outputs:wjTransposedMultiRowMeta.outputs};return WjTransposedMultiRow=o=__decorate([Component({selector:wjTransposedMultiRowMeta.selector,template:wjTransposedMultiRowMeta.template,inputs:wjTransposedMultiRowMeta.inputs,outputs:wjTransposedMultiRowMeta.outputs,providers:[{provide:"WjComponent",useExisting:forwardRef((function(){return o}))}].concat(wjTransposedMultiRowMeta.providers)}),__param(0,Inject(ElementRef)),__param(1,Inject(Injector)),__param(2,Inject("WjComponent")),__param(2,SkipSelf()),__param(2,Optional())],WjTransposedMultiRow)}(wjcGridTransposedmultirow.TransposedMultiRow);export{WjTransposedMultiRow};var moduleExports=[WjTransposedMultiRow],WjGridTransposedmultirowModule=function(){function WjGridTransposedmultirowModule(){}return WjGridTransposedmultirowModule=__decorate([NgModule({imports:[CommonModule],declarations:moduleExports.slice(),exports:moduleExports.slice()})],WjGridTransposedmultirowModule)}();export{WjGridTransposedmultirowModule};