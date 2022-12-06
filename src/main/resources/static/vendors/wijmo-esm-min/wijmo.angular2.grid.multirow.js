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

var __extends=this&&this.__extends||function(){var extendStatics=function(e,t){return(extendStatics=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var o in t)t.hasOwnProperty(o)&&(e[o]=t[o])})(e,t)};return function(e,t){extendStatics(e,t);function __(){this.constructor=e}e.prototype=null===t?Object.create(t):(__.prototype=t.prototype,new __)}}(),__decorate=this&&this.__decorate||function(e,t,o,i){var l,n=arguments.length,r=n<3?t:null===i?i=Object.getOwnPropertyDescriptor(t,o):i;if("object"==typeof Reflect&&"function"==typeof Reflect.decorate)r=Reflect.decorate(e,t,o,i);else for(var a=e.length-1;a>=0;a--)(l=e[a])&&(r=(n<3?l(r):n>3?l(t,o,r):l(t,o))||r);return n>3&&r&&Object.defineProperty(t,o,r),r},__param=this&&this.__param||function(e,t){return function(o,i){t(o,i,e)}};import{Component,NgModule,ElementRef,Injector,Directive,ViewContainerRef,TemplateRef,Optional,forwardRef,Inject,ChangeDetectorRef,SkipSelf}from"@angular/core";import{CommonModule}from"@angular/common";import{NG_VALUE_ACCESSOR}from"@angular/forms";import{WjDirectiveBehavior,WjValueAccessorFactory}from"wijmo/wijmo.angular2.directiveBase";import*as wjcGridMultirow from"wijmo/wijmo.grid.multirow";import*as wjGrid from"wijmo/wijmo.angular2.grid";var wjMultiRowMeta={selector:"wj-multi-row",template:"<div><ng-content></ng-content></div>",inputs:["asyncBindings","wjModelProperty","isDisabled","tabOrder","newRowAtTop","allowAddNew","allowDelete","allowDragging","allowMerging","allowResizing","allowSorting","allowPinning","autoScroll","autoRowHeights","autoSizeMode","autoGenerateColumns","autoSearch","caseSensitiveSearch","quickAutoSize","bigCheckboxes","childItemsPath","groupHeaderFormat","headersVisibility","showSelectedHeaders","showMarquee","showPlaceholders","itemFormatter","isReadOnly","imeEnabled","mergeManager","selectionMode","showGroups","showSort","showDropDown","showAlternatingRows","showErrors","alternatingRowStep","itemValidator","validateEdits","treeIndent","itemsSource","autoClipboard","expandSelectionOnCopyPaste","frozenRows","frozenColumns","cloneFrozenCells","deferResizing","sortRowIndex","editColumnIndex","stickyHeaders","preserveSelectedState","preserveOutlineState","preserveWhiteSpace","keyActionTab","keyActionEnter","rowHeaderPath","virtualizationThreshold","anchorCursor","lazyRender","refreshOnEdit","copyHeaders","columnGroups","layoutDefinition","headerLayoutDefinition","centerHeadersVertically","collapsedHeaders","showHeaderCollapseButton","multiRowGroupHeaders"],outputs:["initialized","gotFocusNg: gotFocus","lostFocusNg: lostFocus","refreshingNg: refreshing","refreshedNg: refreshed","invalidInputNg: invalidInput","beginningEditNg: beginningEdit","cellEditEndedNg: cellEditEnded","cellEditEndingNg: cellEditEnding","prepareCellForEditNg: prepareCellForEdit","formatItemNg: formatItem","resizingColumnNg: resizingColumn","resizedColumnNg: resizedColumn","autoSizingColumnNg: autoSizingColumn","autoSizedColumnNg: autoSizedColumn","draggingColumnNg: draggingColumn","draggingColumnOverNg: draggingColumnOver","draggedColumnNg: draggedColumn","sortingColumnNg: sortingColumn","sortedColumnNg: sortedColumn","pinningColumnNg: pinningColumn","pinnedColumnNg: pinnedColumn","resizingRowNg: resizingRow","resizedRowNg: resizedRow","autoSizingRowNg: autoSizingRow","autoSizedRowNg: autoSizedRow","draggingRowNg: draggingRow","draggingRowOverNg: draggingRowOver","draggedRowNg: draggedRow","deletingRowNg: deletingRow","deletedRowNg: deletedRow","loadingRowsNg: loadingRows","loadedRowsNg: loadedRows","rowEditStartingNg: rowEditStarting","rowEditStartedNg: rowEditStarted","rowEditEndingNg: rowEditEnding","rowEditEndedNg: rowEditEnded","rowAddedNg: rowAdded","groupCollapsedChangingNg: groupCollapsedChanging","groupCollapsedChangedNg: groupCollapsedChanged","columnGroupCollapsedChangingNg: columnGroupCollapsedChanging","columnGroupCollapsedChangedNg: columnGroupCollapsedChanged","itemsSourceChangingNg: itemsSourceChanging","itemsSourceChangedNg: itemsSourceChanged","selectionChangingNg: selectionChanging","selectionChangedNg: selectionChanged","scrollPositionChangedNg: scrollPositionChanged","updatingViewNg: updatingView","updatedViewNg: updatedView","updatingLayoutNg: updatingLayout","updatedLayoutNg: updatedLayout","pastingNg: pasting","pastedNg: pasted","pastingCellNg: pastingCell","pastedCellNg: pastedCell","copyingNg: copying","copiedNg: copied","collapsedHeadersChangingNg: collapsedHeadersChanging","collapsedHeadersChangedNg: collapsedHeadersChanged","collapsedHeadersChangePC: collapsedHeadersChange"],providers:[{provide:NG_VALUE_ACCESSOR,useFactory:WjValueAccessorFactory,multi:!0,deps:["WjComponent"]}]};export{wjMultiRowMeta};var WjMultiRow=function(e){__extends(WjMultiRow,e);function WjMultiRow(t,o,i,l){var n=e.call(this,WjDirectiveBehavior.getHostElement(t,o))||this;n.cdRef=l;n.isInitialized=!1;n._wjBehaviour=WjDirectiveBehavior.attach(n,t,o,i);new wjGrid.DirectiveCellFactory(n,l);n.created();return n}t=WjMultiRow;WjMultiRow.prototype.created=function(){};WjMultiRow.prototype.ngOnInit=function(){this._wjBehaviour.ngOnInit()};WjMultiRow.prototype.ngAfterViewInit=function(){this._wjBehaviour.ngAfterViewInit()};WjMultiRow.prototype.ngOnDestroy=function(){this._wjBehaviour.ngOnDestroy()};WjMultiRow.prototype.addEventListener=function(t,o,i,l){var n=this;void 0===l&&(l=!1);var r=WjDirectiveBehavior,a=r.getZone(this);a&&r.outsideZoneEvents[o]?a.runOutsideAngular((function(){e.prototype.addEventListener.call(n,t,o,i,l)})):e.prototype.addEventListener.call(this,t,o,i,l)};WjMultiRow.prototype.startEditing=function(t,o,i,l,n){void 0===t&&(t=!0);this._edtFocus=null;var r=e.prototype.startEditing.call(this,t,o,i,l,n);r&&(this._edtFocus=l||null==l);return r};WjMultiRow.prototype.onCellEditEnding=function(t){this._edtFocus=null;return e.prototype.onCellEditEnding.call(this,t)};var t;WjMultiRow.meta={outputs:wjMultiRowMeta.outputs,changeEvents:{collapsedHeadersChanged:["collapsedHeaders"]}};return WjMultiRow=t=__decorate([Component({selector:wjMultiRowMeta.selector,template:wjMultiRowMeta.template,inputs:wjMultiRowMeta.inputs,outputs:wjMultiRowMeta.outputs,providers:[{provide:"WjComponent",useExisting:forwardRef((function(){return t}))}].concat(wjMultiRowMeta.providers)}),__param(0,Inject(ElementRef)),__param(1,Inject(Injector)),__param(2,Inject("WjComponent")),__param(2,SkipSelf()),__param(2,Optional()),__param(3,Inject(ChangeDetectorRef))],WjMultiRow)}(wjcGridMultirow.MultiRow);export{WjMultiRow};var wjMultiRowCellMeta={selector:"wj-multi-row-cell",template:"<div><ng-content></ng-content></div>",inputs:["wjProperty","name","dataMap","dataType","binding","sortMemberPath","format","cellTemplate","header","width","maxLength","minWidth","maxWidth","align","allowDragging","allowSorting","allowResizing","allowMerging","aggregate","isReadOnly","cssClass","cssClassAll","isContentHtml","visible","wordWrap","multiLine","mask","inputType","isRequired","showDropDown","dataMapEditor","dropDownCssClass","quickAutoSize","editor","colspan","rowspan"],outputs:["initialized"],providers:[]};export{wjMultiRowCellMeta};var WjMultiRowCell=function(e){__extends(WjMultiRowCell,e);function WjMultiRowCell(t,o,i,l){var n=e.call(this)||this;n.cdRef=l;n.isInitialized=!1;n.wjProperty="cells";n._wjBehaviour=WjDirectiveBehavior.attach(n,t,o,i);n.created();return n}t=WjMultiRowCell;WjMultiRowCell.prototype.created=function(){};WjMultiRowCell.prototype.ngOnInit=function(){this._wjBehaviour.ngOnInit()};WjMultiRowCell.prototype.ngAfterViewInit=function(){this._wjBehaviour.ngAfterViewInit()};WjMultiRowCell.prototype.ngOnDestroy=function(){this._wjBehaviour.ngOnDestroy()};var t;WjMultiRowCell.meta={outputs:wjMultiRowCellMeta.outputs};return WjMultiRowCell=t=__decorate([Component({selector:wjMultiRowCellMeta.selector,template:wjMultiRowCellMeta.template,inputs:wjMultiRowCellMeta.inputs,outputs:wjMultiRowCellMeta.outputs,providers:[{provide:"WjComponent",useExisting:forwardRef((function(){return t}))}].concat(wjMultiRowCellMeta.providers)}),__param(0,Inject(ElementRef)),__param(1,Inject(Injector)),__param(2,Inject("WjComponent")),__param(2,SkipSelf()),__param(2,Optional()),__param(3,Inject(ChangeDetectorRef))],WjMultiRowCell)}(wjcGridMultirow.MultiRowCell);export{WjMultiRowCell};var wjMultiRowCellGroupMeta={selector:"wj-multi-row-cell-group",template:"<div><ng-content></ng-content></div>",inputs:["wjProperty","name","dataMap","dataType","binding","sortMemberPath","format","cellTemplate","header","width","maxLength","minWidth","maxWidth","align","allowDragging","allowSorting","allowResizing","allowMerging","aggregate","isReadOnly","cssClass","cssClassAll","isContentHtml","visible","wordWrap","multiLine","mask","inputType","isRequired","showDropDown","dataMapEditor","dropDownCssClass","quickAutoSize","editor","colspan","rowspan"],outputs:["initialized"],providers:[]};export{wjMultiRowCellGroupMeta};var WjMultiRowCellGroup=function(e){__extends(WjMultiRowCellGroup,e);function WjMultiRowCellGroup(t,o,i,l){var n=e.call(this)||this;n.cdRef=l;n.isInitialized=!1;n.wjProperty="layoutDefinition";n._wjBehaviour=WjDirectiveBehavior.attach(n,t,o,i);n.created();return n}t=WjMultiRowCellGroup;WjMultiRowCellGroup.prototype.created=function(){};WjMultiRowCellGroup.prototype.ngOnInit=function(){this._wjBehaviour.ngOnInit()};WjMultiRowCellGroup.prototype.ngAfterViewInit=function(){this._wjBehaviour.ngAfterViewInit()};WjMultiRowCellGroup.prototype.ngOnDestroy=function(){this._wjBehaviour.ngOnDestroy()};var t;WjMultiRowCellGroup.meta={outputs:wjMultiRowCellGroupMeta.outputs};return WjMultiRowCellGroup=t=__decorate([Component({selector:wjMultiRowCellGroupMeta.selector,template:wjMultiRowCellGroupMeta.template,inputs:wjMultiRowCellGroupMeta.inputs,outputs:wjMultiRowCellGroupMeta.outputs,providers:[{provide:"WjComponent",useExisting:forwardRef((function(){return t}))}].concat(wjMultiRowCellGroupMeta.providers)}),__param(0,Inject(ElementRef)),__param(1,Inject(Injector)),__param(2,Inject("WjComponent")),__param(2,SkipSelf()),__param(2,Optional()),__param(3,Inject(ChangeDetectorRef))],WjMultiRowCellGroup)}(wjcGridMultirow.MultiRowCellGroup);export{WjMultiRowCellGroup};var WjMultiRowCellTemplate=function(e){__extends(WjMultiRowCellTemplate,e);function WjMultiRowCellTemplate(t,o,i,l,n,r){return e.call(this,t,o,i,l,n,r)||this}t=WjMultiRowCellTemplate;var t;return WjMultiRowCellTemplate=t=__decorate([Directive({selector:"[wjMultiRowCellTemplate]",inputs:["wjMultiRowCellTemplate","cellTypeStr: cellType","cellOverflow","valuePaths","autoSizeRows","forceFullEdit"],exportAs:"wjMultiRowCellTemplate",providers:[{provide:"WjComponent",useExisting:forwardRef((function(){return t}))}]}),__param(0,Inject(ViewContainerRef)),__param(1,Inject(TemplateRef)),__param(1,Optional()),__param(2,Inject(ElementRef)),__param(3,Inject("WjComponent")),__param(3,SkipSelf()),__param(3,Optional()),__param(4,Inject(Injector)),__param(5,Inject(ChangeDetectorRef))],WjMultiRowCellTemplate)}(wjGrid.WjFlexGridCellTemplate);export{WjMultiRowCellTemplate};var moduleExports=[WjMultiRow,WjMultiRowCell,WjMultiRowCellGroup,WjMultiRowCellTemplate],WjGridMultirowModule=function(){function WjGridMultirowModule(){}return WjGridMultirowModule=__decorate([NgModule({imports:[CommonModule],declarations:moduleExports.slice(),exports:moduleExports.slice()})],WjGridMultirowModule)}();export{WjGridMultirowModule};