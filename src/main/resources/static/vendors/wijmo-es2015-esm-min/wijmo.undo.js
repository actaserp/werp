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

import{_getModule,CancelEventArgs,Control,isFunction,assert,getActiveElement,CollectionView,DateTime,isArray,isDate,isString,asNumber,asBoolean,hasClass,copy,getElement,getEventOptions,contains,Event,EventArgs,_registerModule}from"wijmo/wijmo";import{_NewRowTemplate,ColumnGroup}from"wijmo/wijmo.grid";import*as selfModule from"wijmo/wijmo.undo";export class UndoableAction{constructor(t){this._target=t}undo(){if(this._actions)for(var t=this._actions.length-1;t>=0;t--)this._actions[t].undo();this.applyState(this._oldState)}redo(){this.applyState(this._newState);this._actions&&this._actions.forEach(t=>{t.redo()})}close(){return!0}applyState(t){}shouldAddAsChildAction(t){return!1}addChildAction(t){this._actions||(this._actions=[]);this._actions.push(t)}get target(){return this._target}_focusScroll(){const t=this._target;if(t instanceof Control){t.hostElement&&t.hostElement.scrollIntoView();t.focus()}else if(t instanceof HTMLElement){t.focus();isFunction(t.select)&&t.select()}}}export class _UndoStackHTML{static addTarget(t,e){const n=_UndoStackHTML;if(e instanceof HTMLInputElement)return n._addInputElement(t,e);if(e instanceof HTMLTextAreaElement)return n._addTextAreaElement(t,e);if(e instanceof HTMLSelectElement)return n._addSelectElement(t,e);{let n=!1;for(let i=0;i<e.children.length;i++){let o=e.children[i];o instanceof HTMLElement&&t.addTarget(o)&&(n=!0)}return n}}static _addInputElement(t,e){let n=null;if("checkbox"==e.type)e.addEventListener("click",e=>{t.pushAction(new CheckboxClickAction(e))});else{if("radio"==e.type){e.addEventListener("mousedown",t=>{n=new RadioClickAction(t)},!0);let i=_UndoStackHTML._getLabel(e);i&&i.addEventListener("mousedown",t=>{n=new RadioClickAction({target:e})},!0);e.addEventListener("focus",t=>{n instanceof RadioClickAction&&n.target==t.target||(n=new RadioClickAction(t))});e.addEventListener("click",e=>{if(n instanceof RadioClickAction){t.pushAction(n);n=null}});return!0}if("range"==e.type){e.addEventListener("mousedown",t=>{let i=getActiveElement();i instanceof HTMLElement&&i!=e&&i.blur();n=new InputChangeAction(t)});e.addEventListener("mouseup",i=>{if(n instanceof InputChangeAction&&getActiveElement()!=e){n._focus=!1;t.pushAction(n);n=null}})}e.addEventListener("focus",t=>{null==n&&(n=new InputChangeAction(t))});e.addEventListener("blur",e=>{if(n instanceof InputChangeAction){t.pushAction(n);n=null}})}return!0}static _addTextAreaElement(t,e){let n=null;e.addEventListener("focus",t=>{n=new InputChangeAction(t)});e.addEventListener("blur",e=>{if(n instanceof InputChangeAction){t.pushAction(n);n=null}});return!0}static _addSelectElement(t,e){let n=null;e.addEventListener("focus",t=>{n=new InputChangeAction(t)});e.addEventListener("blur",e=>{if(n instanceof InputChangeAction){t.pushAction(n);n=null}});return!0}static _getLabel(t){let e=t.parentElement;e instanceof HTMLLabelElement||(e=document.querySelector('label[for="'+t.id+'"'));return e}}export class InputChangeAction extends UndoableAction{constructor(t){super(t.target);this._focus=!0;this._oldState=this._target.value}close(){this._newState=this._target.value;return this._newState!=this._oldState}applyState(t){let e=this._target;e.value=t;e.dispatchEvent(UndoStack._evtInput);this._focus&&this._focusScroll()}}export class CheckboxClickAction extends UndoableAction{constructor(t){super(t.target);assert("checkbox"==this._target.type,"checkbox expected");this._newState=this._target.checked;this._oldState=!this._newState}applyState(t){this._target.checked=t;this._target.focus()}}export class RadioClickAction extends UndoableAction{constructor(t){super(t.target);let e=this._target.type;assert("radio"==e,"radio button expected");this._oldState=this._getState()}close(){this._newState=this._getState();return this._newState!=this._oldState}applyState(t){if(t){t.checked=!0;t.focus()}}_getState(){let t='input[name="'+this._target.name+'"]',e=document.querySelectorAll(t);for(let t=0;t<e.length;t++)if(e[t].checked)return e[t];return null}}export class UndoStack{constructor(t,e){this._autoKbd=!0;this._stack=[];this._maxActions=1e3;this._ptr=0;this.addingTarget=new Event;this.addedTarget=new Event;this.addingAction=new Event;this.addedAction=new Event;this.undoingAction=new Event;this.undoneAction=new Event;this.redoingAction=new Event;this.redoneAction=new Event;this.stateChanged=new Event;if(!UndoStack._evtInput){let t=document.createEvent("HTMLEvents");t.initEvent("input",!0,!1);UndoStack._evtInput=t}copy(this,e);t=getElement(t||document.body);this.addTarget(t);document.addEventListener("keydown",e=>{if(this._autoKbd&&e.ctrlKey&&!e.defaultPrevented&&contains(t,e.target))switch(e.keyCode){case 90:if(this.canUndo){getActiveElement().blur();setTimeout(()=>this.undo(),100)}e.preventDefault();break;case 89:if(this.canRedo){getActiveElement().blur();setTimeout(()=>this.redo(),100)}e.preventDefault()}},getEventOptions(!0,!1))}addTarget(t){let e=!1;if(isString(t)){let e=document.querySelectorAll(t),n=!1;for(let t=0;t<e.length;t++)this.addTarget(e[t])&&(n=!0);return n}assert(t instanceof HTMLElement,"Undo target should be an HTML element");let n=new AddTargetEventArgs(t);n.cancel=hasClass(t,"wj-no-undo");if(this.onAddingTarget(n)){let i=Control.getControl(t);i&&(e=_UndoStackWijmo.addTarget(this,i));e||(e=_UndoStackHTML.addTarget(this,t));e&&this.onAddedTarget(n)}return e}get autoKeyboard(){return this._autoKbd}set autoKeyboard(t){this._autoKbd=asBoolean(t)}get isDisabled(){return this._disabled}set isDisabled(t){this._disabled=asBoolean(t)}get maxActions(){return this._maxActions}set maxActions(t){if(t!=this._maxActions){this._maxActions=asNumber(t,!1,!0);this.clear()}}get actionCount(){return this._stack.length}get canUndo(){return this._stack.length>0&&this._ptr>0&&!this._disabled}get canRedo(){return this._stack.length>0&&this._ptr<this._stack.length&&!this._disabled}undo(){if(this.canUndo){let t=this._stack[this._ptr-1],e=new UndoActionEventArgs(t);if(this.onUndoingAction(e)){this._ptr--;this._undoing=!0;t.undo();this._undoing=!1;this._pendingAction=null;this.onUndoneAction(e);this.onStateChanged()}}}redo(){if(this.canRedo){let t=this._stack[this._ptr],e=new UndoActionEventArgs(t);if(this.onRedoingAction(e)){this._ptr++;this._undoing=!0;t.redo();this._undoing=!1;this._pendingAction=null;this.onRedoneAction(e);this.onStateChanged()}}}clear(){this._ptr=0;this._stack.splice(0,this._stack.length);this.onStateChanged()}pushAction(t){this._pendingAction=t;this.pushPendingAction()}onAddingTarget(t){this.addingTarget.raise(this,t);return!t.cancel}onAddedTarget(t){this.addedTarget.raise(this,t)}onAddingAction(t){this.addingAction.raise(this,t);return!t.cancel}onAddedAction(t){this.addedAction.raise(this,t)}onUndoingAction(t){this.undoingAction.raise(this,t);return!t.cancel}onUndoneAction(t){this.undoneAction.raise(this,t)}onRedoingAction(t){this.redoingAction.raise(this,t);return!t.cancel}onRedoneAction(t){this.redoneAction.raise(this,t)}onStateChanged(){this.stateChanged.raise(this,EventArgs.empty)}pushPendingAction(){if(!this._disabled&&!this._undoing&&this._pendingAction&&this._pendingAction.close()){this._stack.splice(this._ptr,this._stack.length-this._ptr);assert(this._stack.length==this._ptr,"should be at the end of the stack");if(this._stack.length){let t=this._stack[this._ptr-1];if(t.shouldAddAsChildAction(this._pendingAction)){t.addChildAction(this._pendingAction);this._pendingAction=null;this.onStateChanged();return}}let t=new UndoActionEventArgs(this._pendingAction);if(!this.onAddingAction(t))return;this._stack.push(this._pendingAction);this._ptr++;this._pendingAction=null;let e=this._stack.length-this._maxActions;if(e>0){this._stack.splice(0,e);this._ptr-=e;assert(this._ptr>=0,"pointer should not be negative")}this.onStateChanged()}}}export class AddTargetEventArgs extends CancelEventArgs{constructor(t){super();this._target=t}get target(){return this._target}}export class UndoActionEventArgs extends CancelEventArgs{constructor(t){super();this._action=t}get action(){return this._action}}export function softInput(){return _getModule("wijmo.input")}export function softGrid(){return _getModule("wijmo.grid")}export function softGauge(){return _getModule("wijmo.gauge")}export function softNav(){return _getModule("wijmo.nav")}export class _UndoStackWijmo{static addTarget(t,e){const n=_UndoStackWijmo;return softGrid()&&e instanceof softGrid().FlexGrid?n._addFlexGrid(t,e):softGauge()&&e instanceof softGauge().Gauge?n._addGauge(t,e):softNav()&&e instanceof softNav().TreeView?n._addTreeView(t,e):!!n._isInputControl(e)&&n._addInputControl(t,e)}static _isInputControl(t){const e=softInput();return!!e&&(t instanceof e.DropDown||t instanceof e.InputMask||t instanceof e.InputNumber||t instanceof e.Calendar||t instanceof e.ColorPicker)}static _addInputControl(t,e){let n=null;e.gotFocus.addHandler(()=>{n=new InputControlChangeAction({target:e})});e.lostFocus.addHandler(()=>{if(n instanceof InputControlChangeAction){t.pushAction(n);n=null}});return!0}static _addGauge(t,e){if(!e.isReadOnly){let n=null;e.hostElement.addEventListener("focus",()=>{n||(n=new GaugeChangeAction(e))});e.lostFocus.addHandler(()=>{if(n instanceof GaugeChangeAction){t.pushAction(n);n=null}});return!0}return!1}static _addTreeView(t,e){let n=null;e.nodeEditStarted.addHandler((t,e)=>{n=new TreeViewEditAction(t,e)});e.nodeEditEnded.addHandler((e,i)=>{if(n instanceof TreeViewEditAction){t.pushAction(n);n=null}});e.isCheckedChanging.addHandler((t,e)=>{n=new TreeViewCheckAction(t,e)});e.isCheckedChanged.addHandler((e,i)=>{if(n instanceof TreeViewCheckAction){t.pushAction(n);n=null}});return!0}static _addFlexGrid(t,e){let n=null;e.beginningEdit.addHandler((t,e)=>{n=e.getRow()instanceof _NewRowTemplate?null:new GridEditAction(t,e)});e.cellEditEnded.addHandler((e,i)=>{if(n instanceof GridEditAction){t.pushAction(n);n=null}});e.pastingCell.addHandler((t,e)=>{n=e.getRow()?new GridEditAction(t,e):null});e.pastedCell.addHandler((e,i)=>{if(n instanceof GridEditAction){t.pushAction(n);n=null}});e.sortingColumn.addHandler((t,e)=>{n=new GridSortAction(t,e)});e.sortedColumn.addHandler((e,i)=>{if(n instanceof GridSortAction){t.pushAction(n);n=null}});e.resizingColumn.addHandler((t,e)=>{n instanceof GridResizeAction||(n=new GridResizeAction(t,e))});e.resizedColumn.addHandler(()=>{if(n instanceof GridResizeAction){t.pushAction(n);n=null}});e.autoSizingColumn.addHandler((t,e)=>{n=new GridResizeAction(t,e)});e.autoSizedColumn.addHandler(()=>{if(n instanceof GridResizeAction){t.pushAction(n);n=null}});e.draggingColumn.addHandler((t,e)=>{n=new GridDragAction(t,e)});e.draggedColumn.addHandler((e,i)=>{if(n instanceof GridDragAction){t.pushAction(n);n=null}});e.rowAdded.addHandler((e,n)=>{n.cancel||t.pushAction(new GridAddRowAction(e,n))});e.deletingRow.addHandler((e,n)=>{n.cancel||t.pushAction(new GridRemoveRowAction(e,n))});e.columnGroupCollapsedChanging.addHandler((t,e)=>{n=new ExpandCollapseColumnGroupAction(t,e)});e.columnGroupCollapsedChanged.addHandler((e,i)=>{if(n instanceof ExpandCollapseColumnGroupAction){t.pushAction(n);n=null}});return!0}}class InputControlChangeAction extends InputChangeAction{constructor(t){super(t);this._ctl=t.target;this._oldState=this._getControlState()}get control(){return this._ctl}close(){this._timeStamp=Date.now();this._newState=this._getControlState();return!this._sameContent(this._oldState,this._newState)}shouldAddAsChildAction(t){if(t instanceof InputControlChangeAction&&t.target==this.target&&t._timeStamp-this._timeStamp<500){this._timeStamp=Date.now();return!0}return!1}applyState(t){let e=this._ctl,n=softInput();if(n){let i=e instanceof n.Calendar||e instanceof n.InputDate;i&&e.selectionMode!=n.DateSelectionMode.Range&&(i=!1);if(e instanceof n.MultiSelect)e.checkedItems=t;else if(e instanceof n.MultiAutoComplete)e.selectedItems=t;else if(i){e.value=t[0];e.rangeEnd=t[1]}else"value"in e?e.value=t:"text"in e?e.text=t:assert(!1,"can't apply control state?");e.focus()}}_getControlState(){let t=this._ctl,e=softInput();if(e){let n=t instanceof e.Calendar||t instanceof e.InputDate;n&&t.selectionMode!=e.DateSelectionMode.Range&&(n=!1);if(t instanceof e.MultiSelect)return t.checkedItems.slice();if(t instanceof e.MultiAutoComplete)return t.selectedItems.slice();if(n)return[t.value,t.rangeEnd];if("value"in t)return t.value;if("text"in t)return t.text;assert(!1,"can't get control state?")}}_sameContent(t,e){if(isArray(t)&&isArray(e)){if(t.length!=e.length)return!1;for(let n=0;n<t.length;n++)if(t[n]!=e[n])return!1;return!0}return isDate(t)||isDate(e)?DateTime.sameDate(t,e):t==e}}class GaugeChangeAction extends UndoableAction{constructor(t){super(t);this._oldState=t.value}get control(){return this._target}close(){this._newState=this._target.value;return this._newState!=this._oldState}applyState(t){let e=this._target;e.value=t;e.focus()}}class GridEditAction extends UndoableAction{constructor(t,e){super(t);this._dataItems=[];let n=t.collectionView,i=this._rng=e.range;for(let e=i.topRow;e<=i.bottomRow;e++)this._dataItems.push(t.rows[e].dataItem);this._page=n instanceof CollectionView?n.pageIndex:-1;this._oldState=t.getCellData(e.row,e.col,!1)}get control(){return this._target}get range(){return this._rng.clone()}get row(){return this._rng.topRow}get col(){return this._rng.leftCol}get dataItem(){return this._dataItems[0]}get dataItems(){return this._dataItems}close(){let t=this._target.collectionView;if(t&&t.currentAddItem)return!1;this._timeStamp=Date.now();this._newState=this._target.getCellData(this.row,this.col,!1);return this._newState!=this._oldState}applyState(t){let e=this._target,n=e.editableCollectionView;if(n){n instanceof CollectionView&&this._page>-1&&n.moveToPage(this._page);e.deferUpdate(()=>{this._dataItems.forEach(i=>{n.editItem(i);for(let n=this._rng.leftCol;n<=this._rng.rightCol;n++){let o=e.columns[n],s=e._getBindingColumn(e.cells,this.row,o);s&&s._binding&&s._binding.setValue(i,t)}n.commitEdit()})})}e.select(e.selection.row,this.col);this._focusScroll()}shouldAddAsChildAction(t){return t instanceof GridEditAction&&t.target==this.target&&t._timeStamp-this._timeStamp<100}}class GridSortAction extends UndoableAction{constructor(t,e){super(t);let n=this._target.collectionView;n&&(this._oldState=n.sortDescriptions.slice())}get control(){return this._target}close(){let t=this._target.collectionView;if(t){this._newState=t.sortDescriptions.slice();return!0}return!1}applyState(t){let e=this._target.collectionView;e&&e.deferUpdate(()=>{let n=e.sortDescriptions;n.clear();t.forEach(t=>{n.push(t)})});this._focusScroll()}}class GridResizeAction extends UndoableAction{constructor(t,e){super(t);this._col=t.columns[e.col];this._oldState=this._col.renderWidth}get control(){return this._target}get col(){return this._col}close(){this._timeStamp=Date.now();this._newState=this._col.renderWidth;return this._newState!=this._oldState}applyState(t){this._col.width=t;this._focusScroll()}shouldAddAsChildAction(t){return t instanceof GridResizeAction&&t.target==this.target&&t._timeStamp-this._timeStamp<100}}class GridDragAction extends UndoableAction{constructor(t,e){super(t);this._col=e.getColumn(!0);this._oldState=this._getState(this._col)}get control(){return this._target}get col(){return this._col}close(){this._newState=this._getState(this._col);return!this._areStatesEqual(this._newState,this._oldState)}applyState(t){const e=this._col;e.grid.deferUpdate(()=>{const n=this._getState(e);n.coll.splice(n.idx,1);t.coll.splice(t.idx,0,e)});this._focusScroll()}_getState(t){const e=t instanceof ColumnGroup?t.parentGroup?t.parentGroup.columns:this.target.getColumnGroups():t.grid.columns;return{coll:e,idx:e.indexOf(t)}}_areStatesEqual(t,e){return t.coll===e.coll&&t.idx===e.idx}}class GridAddRowAction extends UndoableAction{constructor(t,e){super(t);let n=this._target.collectionView;if(n&&n.currentAddItem){let t=n.currentAddItem,e=n.sourceCollection.indexOf(t),i=n.currentPosition;this._oldState={item:t,index:e,position:i};this._newState={index:e,position:i}}}get control(){return this._target}close(){return null!=this._oldState}applyState(t){let e=this._target.collectionView;if(e){let n=e.sourceCollection;if(t.item){n.splice(t.index,1);if(e instanceof CollectionView&&e.trackChanges){let n=t.item;assert(e.itemsAdded.indexOf(n)>-1,"item should be in the itemsAdded list");e.itemsAdded.remove(n)}}else{let i=this._oldState.item;n.splice(t.index,0,i);if(e instanceof CollectionView&&e.trackChanges){assert(e.itemsAdded.indexOf(i)<0,"item should not be in the itemsAdded list");e.itemsAdded.push(i)}}e.refresh();e.moveCurrentToPosition(t.position);this._focusScroll()}}}class GridRemoveRowAction extends UndoableAction{constructor(t,e){super(t);this._edtIndex=-1;let n=this._target.collectionView;if(n){let i=t.rows[e.row].dataItem,o=n.sourceCollection.indexOf(i),s=n.currentPosition;n instanceof CollectionView&&n.trackChanges&&(this._edtIndex=n.itemsEdited.indexOf(i));this._oldState={item:i,index:o,position:s};this._newState={index:o,position:s}}}get control(){return this._target}get dataItem(){return this._oldState.item}close(){this._timeStamp=Date.now();return null!=this._oldState}applyState(t){let e=this._target,n=e.collectionView;if(n){let i=n.sourceCollection;if(t.item){i.splice(t.index,0,t.item);if(n instanceof CollectionView&&n.trackChanges){let e=t.item;assert(n.itemsRemoved.indexOf(e)>-1,"item should be in the itemsRemoved list");n.itemsRemoved.remove(e);this._edtIndex>-1&&n.itemsEdited.indexOf(e)<0&&n.itemsEdited.push(e)}}else{i.splice(t.index,1);if(n instanceof CollectionView&&n.trackChanges){let t=this._oldState.item;assert(n.itemsRemoved.indexOf(t)<0,"item should not be in the itemsRemoved list");n.itemsRemoved.push(t)}}n.refresh();n.moveCurrentToPosition(t.position);let o=new(softGrid().CellRange)(t.position,0,t.position,e.columns.length-1);e.select(o);this._focusScroll()}}shouldAddAsChildAction(t){return t instanceof GridRemoveRowAction&&t.target==this.target&&t._timeStamp-this._timeStamp<100}}class ExpandCollapseColumnGroupAction extends UndoableAction{constructor(t,e){super(t);this._group=e.data;this._oldState=this._group.isCollapsed}get control(){return this._target}get group(){return this._group}close(){this._newState=this._group.isCollapsed;return this._newState!=this._oldState}applyState(t){this._group.isCollapsed=t;this._focusScroll()}}class TreeViewEditAction extends UndoableAction{constructor(t,e){super(t);this._nd=e.node;this._oldState=this._getNodeText()}get control(){return this._target}get node(){return this._nd}close(){this._newState=this._getNodeText();return this._newState!=this._oldState}applyState(t){this._nd.select();this._setNodeText(t);this._target.focus()}_getNodeText(){let t=this._nd.dataItem[this._getDisplayMemberPath()];return null!=t?t.toString():""}_setNodeText(t){let e=this._nd,n=e.dataItem,i=this._getDisplayMemberPath(),o=e.element.querySelector(".wj-node-text");n[i]=t;e.treeView.isContentHtml?o.innerHTML=t:o.textContent=t}_getDisplayMemberPath(){let t=this._nd,e=t.treeView.displayMemberPath;e instanceof Array&&(e=e[t.level]);return e}}class TreeViewCheckAction extends UndoableAction{constructor(t,e){super(t);this._nd=e.node;this._oldState=this._nd.isChecked}get control(){return this._target}get node(){return this._nd}close(){this._newState=this._nd.isChecked;return this._newState!=this._oldState}applyState(t){this._nd.select();this._nd.isChecked=t;this._target.focus()}}_registerModule("wijmo.undo",selfModule);