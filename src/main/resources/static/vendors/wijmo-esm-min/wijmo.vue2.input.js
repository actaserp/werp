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

var __extends=this&&this.__extends||function(){var extendStatics=function(e,t){return(extendStatics=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var o in t)t.hasOwnProperty(o)&&(e[o]=t[o])})(e,t)};return function(e,t){extendStatics(e,t);function __(){this.constructor=e}e.prototype=null===t?Object.create(t):(__.prototype=t.prototype,new __)}}();import{VueApi,WjComponentBehavior}from"wijmo/wijmo.vue2.base";import*as wjcCore from"wijmo/wijmo";import*as wjcInput from"wijmo/wijmo.input";var WjListBoxBehavior=function(e){__extends(WjListBoxBehavior,e);function WjListBoxBehavior(){return null!==e&&e.apply(this,arguments)||this}WjListBoxBehavior.tag="wj-list-box";WjListBoxBehavior.props=["isDisabled","tabOrder","isContentHtml","maxHeight","selectedValuePath","itemFormatter","displayMemberPath","checkedMemberPath","caseSensitiveSearch","itemsSource","virtualizationThreshold","showGroups","selectedIndex","selectedItem","selectedValue","checkedItems"];WjListBoxBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput","formatItem","itemsChanged","itemChecked"];WjListBoxBehavior.changeEvents={selectedIndexChanged:["selectedIndex","selectedItem","selectedValue"],checkedItemsChanged:["checkedItems"]};WjListBoxBehavior.classCtor=function(){return wjcInput.ListBox};WjListBoxBehavior.modelProp="selectedValue";return WjListBoxBehavior}(WjComponentBehavior);export var WjListBox=WjListBoxBehavior.register();function registerV3WjListBox(e){e.component(WjListBoxBehavior.tag,WjListBox)}var WjMultiSelectListBoxBehavior=function(e){__extends(WjMultiSelectListBoxBehavior,e);function WjMultiSelectListBoxBehavior(){return null!==e&&e.apply(this,arguments)||this}WjMultiSelectListBoxBehavior.tag="wj-multi-select-list-box";WjMultiSelectListBoxBehavior.props=["isDisabled","tabOrder","itemsSource","displayMemberPath","selectedIndex","isContentHtml","showGroups","checkOnFilter","showFilterInput","filterInputPlaceholder","showSelectAllCheckbox","selectAllLabel","delay","caseSensitiveSearch","checkedMemberPath","virtualizationThreshold","checkedItems"];WjMultiSelectListBoxBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput"];WjMultiSelectListBoxBehavior.changeEvents={selectedIndexChanged:["selectedIndex"],checkedItemsChanged:["checkedItems"]};WjMultiSelectListBoxBehavior.classCtor=function(){return wjcInput.MultiSelectListBox};WjMultiSelectListBoxBehavior.modelProp="checkedItems";return WjMultiSelectListBoxBehavior}(WjComponentBehavior);export var WjMultiSelectListBox=WjMultiSelectListBoxBehavior.register();function registerV3WjMultiSelectListBox(e){e.component(WjMultiSelectListBoxBehavior.tag,WjMultiSelectListBox)}var WjComboBoxBehavior=function(e){__extends(WjComboBoxBehavior,e);function WjComboBoxBehavior(){return null!==e&&e.apply(this,arguments)||this}WjComboBoxBehavior.tag="wj-combo-box";WjComboBoxBehavior.props=["isDisabled","tabOrder","isDroppedDown","showDropDownButton","autoExpandSelection","placeholder","dropDownCssClass","isAnimated","isReadOnly","isRequired","inputType","clickAction","displayMemberPath","selectedValuePath","headerPath","isContentHtml","isEditable","handleWheel","maxDropDownHeight","maxDropDownWidth","itemFormatter","showGroups","trimText","caseSensitiveSearch","virtualizationThreshold","itemsSource","text","selectedIndex","selectedItem","selectedValue"];WjComboBoxBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput","isDroppedDownChanging","itemsSourceChanged","formatItem"];WjComboBoxBehavior.changeEvents={isDroppedDownChanged:["isDroppedDown"],textChanged:["text"],selectedIndexChanged:["selectedIndex","selectedItem","selectedValue"]};WjComboBoxBehavior.classCtor=function(){return wjcInput.ComboBox};WjComboBoxBehavior.modelProp="selectedValue";return WjComboBoxBehavior}(WjComponentBehavior);export var WjComboBox=WjComboBoxBehavior.register();function registerV3WjComboBox(e){e.component(WjComboBoxBehavior.tag,WjComboBox)}var WjAutoCompleteBehavior=function(e){__extends(WjAutoCompleteBehavior,e);function WjAutoCompleteBehavior(){return null!==e&&e.apply(this,arguments)||this}WjAutoCompleteBehavior.tag="wj-auto-complete";WjAutoCompleteBehavior.props=["isDisabled","tabOrder","isDroppedDown","showDropDownButton","autoExpandSelection","placeholder","dropDownCssClass","isAnimated","isReadOnly","isRequired","inputType","clickAction","displayMemberPath","selectedValuePath","headerPath","isContentHtml","isEditable","handleWheel","maxDropDownHeight","maxDropDownWidth","itemFormatter","showGroups","trimText","caseSensitiveSearch","virtualizationThreshold","delay","maxItems","minLength","cssMatch","itemsSourceFunction","searchMemberPath","beginsWithSearch","itemsSource","text","selectedIndex","selectedItem","selectedValue"];WjAutoCompleteBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput","isDroppedDownChanging","itemsSourceChanged","formatItem"];WjAutoCompleteBehavior.changeEvents={isDroppedDownChanged:["isDroppedDown"],textChanged:["text"],selectedIndexChanged:["selectedIndex","selectedItem","selectedValue"]};WjAutoCompleteBehavior.classCtor=function(){return wjcInput.AutoComplete};WjAutoCompleteBehavior.modelProp="selectedValue";return WjAutoCompleteBehavior}(WjComponentBehavior);export var WjAutoComplete=WjAutoCompleteBehavior.register();function registerV3WjAutoComplete(e){e.component(WjAutoCompleteBehavior.tag,WjAutoComplete)}var WjCalendarBehavior=function(e){__extends(WjCalendarBehavior,e);function WjCalendarBehavior(){return null!==e&&e.apply(this,arguments)||this}WjCalendarBehavior.tag="wj-calendar";WjCalendarBehavior.props=["isDisabled","tabOrder","monthView","showHeader","itemFormatter","itemValidator","firstDayOfWeek","max","min","formatYearMonth","formatDayHeaders","formatDays","formatYear","formatMonths","selectionMode","isReadOnly","handleWheel","repeatButtons","showYearPicker","value","displayMonth","monthCount","showMonthPicker","weeksBefore","weeksAfter","rangeEnd","rangeMin","rangeMax"];WjCalendarBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput","rangeChanged","formatItem"];WjCalendarBehavior.changeEvents={valueChanged:["value"],displayMonthChanged:["displayMonth"],rangeEndChanged:["rangeEnd"]};WjCalendarBehavior.classCtor=function(){return wjcInput.Calendar};WjCalendarBehavior.modelProp="value";return WjCalendarBehavior}(WjComponentBehavior);export var WjCalendar=WjCalendarBehavior.register();function registerV3WjCalendar(e){e.component(WjCalendarBehavior.tag,WjCalendar)}var WjColorPickerBehavior=function(e){__extends(WjColorPickerBehavior,e);function WjColorPickerBehavior(){return null!==e&&e.apply(this,arguments)||this}WjColorPickerBehavior.tag="wj-color-picker";WjColorPickerBehavior.props=["isDisabled","tabOrder","showAlphaChannel","showColorString","palette","value"];WjColorPickerBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput"];WjColorPickerBehavior.changeEvents={valueChanged:["value"]};WjColorPickerBehavior.classCtor=function(){return wjcInput.ColorPicker};WjColorPickerBehavior.modelProp="value";return WjColorPickerBehavior}(WjComponentBehavior);export var WjColorPicker=WjColorPickerBehavior.register();function registerV3WjColorPicker(e){e.component(WjColorPickerBehavior.tag,WjColorPicker)}var WjInputMaskBehavior=function(e){__extends(WjInputMaskBehavior,e);function WjInputMaskBehavior(){return null!==e&&e.apply(this,arguments)||this}WjInputMaskBehavior.tag="wj-input-mask";WjInputMaskBehavior.props=["isDisabled","tabOrder","mask","overwriteMode","isRequired","isReadOnly","promptChar","placeholder","inputType","rawValue","value"];WjInputMaskBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput"];WjInputMaskBehavior.changeEvents={valueChanged:["rawValue","value"]};WjInputMaskBehavior.classCtor=function(){return wjcInput.InputMask};WjInputMaskBehavior.modelProp="value";return WjInputMaskBehavior}(WjComponentBehavior);export var WjInputMask=WjInputMaskBehavior.register();function registerV3WjInputMask(e){e.component(WjInputMaskBehavior.tag,WjInputMask)}var WjInputColorBehavior=function(e){__extends(WjInputColorBehavior,e);function WjInputColorBehavior(){return null!==e&&e.apply(this,arguments)||this}WjInputColorBehavior.tag="wj-input-color";WjInputColorBehavior.props=["isDisabled","tabOrder","isDroppedDown","showDropDownButton","autoExpandSelection","placeholder","dropDownCssClass","isAnimated","isReadOnly","isRequired","inputType","clickAction","showAlphaChannel","showColorString","value","text"];WjInputColorBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput","isDroppedDownChanging"];WjInputColorBehavior.changeEvents={isDroppedDownChanged:["isDroppedDown"],textChanged:["text"],valueChanged:["value"]};WjInputColorBehavior.classCtor=function(){return wjcInput.InputColor};WjInputColorBehavior.modelProp="value";return WjInputColorBehavior}(WjComponentBehavior);export var WjInputColor=WjInputColorBehavior.register();function registerV3WjInputColor(e){e.component(WjInputColorBehavior.tag,WjInputColor)}var WjMultiSelectBehavior=function(e){__extends(WjMultiSelectBehavior,e);function WjMultiSelectBehavior(){return null!==e&&e.apply(this,arguments)||this}WjMultiSelectBehavior.tag="wj-multi-select";WjMultiSelectBehavior.props=["isDisabled","tabOrder","isDroppedDown","showDropDownButton","autoExpandSelection","placeholder","dropDownCssClass","isAnimated","isReadOnly","isRequired","inputType","clickAction","displayMemberPath","selectedValuePath","headerPath","isContentHtml","isEditable","handleWheel","maxDropDownHeight","maxDropDownWidth","itemFormatter","showGroups","trimText","caseSensitiveSearch","virtualizationThreshold","checkedMemberPath","maxHeaderItems","headerFormat","headerFormatter","showSelectAllCheckbox","selectAllLabel","showFilterInput","filterInputPlaceholder","checkOnFilter","delay","caseSensitiveSearch","itemsSource","checkedItems","text","selectedIndex","selectedItem","selectedValue"];WjMultiSelectBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput","isDroppedDownChanging","itemsSourceChanged","formatItem"];WjMultiSelectBehavior.changeEvents={isDroppedDownChanged:["isDroppedDown"],textChanged:["text"],selectedIndexChanged:["selectedIndex","selectedItem","selectedValue"],checkedItemsChanged:["checkedItems"]};WjMultiSelectBehavior.classCtor=function(){return wjcInput.MultiSelect};WjMultiSelectBehavior.modelProp="checkedItems";return WjMultiSelectBehavior}(WjComponentBehavior);export var WjMultiSelect=WjMultiSelectBehavior.register();function registerV3WjMultiSelect(e){e.component(WjMultiSelectBehavior.tag,WjMultiSelect)}var WjMultiAutoCompleteBehavior=function(e){__extends(WjMultiAutoCompleteBehavior,e);function WjMultiAutoCompleteBehavior(){return null!==e&&e.apply(this,arguments)||this}WjMultiAutoCompleteBehavior.tag="wj-multi-auto-complete";WjMultiAutoCompleteBehavior.props=["isDisabled","tabOrder","isDroppedDown","showDropDownButton","autoExpandSelection","placeholder","dropDownCssClass","isAnimated","isReadOnly","isRequired","inputType","clickAction","displayMemberPath","selectedValuePath","headerPath","isContentHtml","isEditable","handleWheel","maxDropDownHeight","maxDropDownWidth","itemFormatter","showGroups","trimText","caseSensitiveSearch","virtualizationThreshold","delay","maxItems","minLength","cssMatch","itemsSourceFunction","searchMemberPath","beginsWithSearch","maxSelectedItems","selectedItems","itemsSource","selectedMemberPath","text","selectedIndex","selectedItem","selectedValue"];WjMultiAutoCompleteBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput","isDroppedDownChanging","itemsSourceChanged","formatItem"];WjMultiAutoCompleteBehavior.changeEvents={isDroppedDownChanged:["isDroppedDown"],textChanged:["text"],selectedIndexChanged:["selectedIndex","selectedItem","selectedValue"],selectedItemsChanged:["selectedItems"]};WjMultiAutoCompleteBehavior.classCtor=function(){return wjcInput.MultiAutoComplete};WjMultiAutoCompleteBehavior.modelProp="selectedItems";return WjMultiAutoCompleteBehavior}(WjComponentBehavior);export var WjMultiAutoComplete=WjMultiAutoCompleteBehavior.register();function registerV3WjMultiAutoComplete(e){e.component(WjMultiAutoCompleteBehavior.tag,WjMultiAutoComplete)}var WjInputNumberBehavior=function(e){__extends(WjInputNumberBehavior,e);function WjInputNumberBehavior(){return null!==e&&e.apply(this,arguments)||this}WjInputNumberBehavior.tag="wj-input-number";WjInputNumberBehavior.props=["isDisabled","tabOrder","showSpinner","repeatButtons","max","min","step","isRequired","placeholder","inputType","format","isReadOnly","handleWheel","value","text"];WjInputNumberBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput"];WjInputNumberBehavior.changeEvents={valueChanged:["value"],textChanged:["text"]};WjInputNumberBehavior.classCtor=function(){return wjcInput.InputNumber};WjInputNumberBehavior.modelProp="value";return WjInputNumberBehavior}(WjComponentBehavior);export var WjInputNumber=WjInputNumberBehavior.register();function registerV3WjInputNumber(e){e.component(WjInputNumberBehavior.tag,WjInputNumber)}var WjInputDateBehavior=function(e){__extends(WjInputDateBehavior,e);function WjInputDateBehavior(){return null!==e&&e.apply(this,arguments)||this}WjInputDateBehavior.tag="wj-input-date";WjInputDateBehavior.props=["isDisabled","tabOrder","isDroppedDown","showDropDownButton","autoExpandSelection","placeholder","dropDownCssClass","isAnimated","isReadOnly","isRequired","inputType","clickAction","selectionMode","format","mask","max","min","inputType","repeatButtons","showYearPicker","itemValidator","itemFormatter","monthCount","handleWheel","showMonthPicker","showHeader","weeksBefore","weeksAfter","rangeMin","rangeMax","separator","alwaysShowCalendar","predefinedRanges","closeOnSelection","text","value","rangeEnd"];WjInputDateBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput","isDroppedDownChanging","rangeChanged"];WjInputDateBehavior.changeEvents={isDroppedDownChanged:["isDroppedDown"],textChanged:["text"],valueChanged:["value"],rangeEndChanged:["rangeEnd"]};WjInputDateBehavior.classCtor=function(){return wjcInput.InputDate};WjInputDateBehavior.modelProp="value";return WjInputDateBehavior}(WjComponentBehavior);export var WjInputDate=WjInputDateBehavior.register();function registerV3WjInputDate(e){e.component(WjInputDateBehavior.tag,WjInputDate)}var WjInputTimeBehavior=function(e){__extends(WjInputTimeBehavior,e);function WjInputTimeBehavior(){return null!==e&&e.apply(this,arguments)||this}WjInputTimeBehavior.tag="wj-input-time";WjInputTimeBehavior.props=["isDisabled","tabOrder","isDroppedDown","showDropDownButton","autoExpandSelection","placeholder","dropDownCssClass","isAnimated","isReadOnly","isRequired","inputType","clickAction","displayMemberPath","selectedValuePath","headerPath","isContentHtml","isEditable","handleWheel","maxDropDownHeight","maxDropDownWidth","itemFormatter","showGroups","trimText","caseSensitiveSearch","virtualizationThreshold","max","min","step","format","mask","inputType","itemsSource","text","selectedIndex","selectedItem","selectedValue","value"];WjInputTimeBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput","isDroppedDownChanging","itemsSourceChanged","formatItem"];WjInputTimeBehavior.changeEvents={isDroppedDownChanged:["isDroppedDown"],textChanged:["text"],selectedIndexChanged:["selectedIndex","selectedItem","selectedValue"],valueChanged:["value"]};WjInputTimeBehavior.classCtor=function(){return wjcInput.InputTime};WjInputTimeBehavior.modelProp="value";return WjInputTimeBehavior}(WjComponentBehavior);export var WjInputTime=WjInputTimeBehavior.register();function registerV3WjInputTime(e){e.component(WjInputTimeBehavior.tag,WjInputTime)}var WjInputDateTimeBehavior=function(e){__extends(WjInputDateTimeBehavior,e);function WjInputDateTimeBehavior(){return null!==e&&e.apply(this,arguments)||this}WjInputDateTimeBehavior.tag="wj-input-date-time";WjInputDateTimeBehavior.props=["isDisabled","tabOrder","isDroppedDown","showDropDownButton","autoExpandSelection","placeholder","dropDownCssClass","isAnimated","isReadOnly","isRequired","inputType","clickAction","selectionMode","format","mask","max","min","inputType","repeatButtons","showYearPicker","itemValidator","itemFormatter","monthCount","handleWheel","showMonthPicker","showHeader","weeksBefore","weeksAfter","rangeMin","rangeMax","separator","alwaysShowCalendar","predefinedRanges","closeOnSelection","timeMax","timeMin","timeStep","timeFormat","text","value","rangeEnd"];WjInputDateTimeBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput","isDroppedDownChanging","rangeChanged"];WjInputDateTimeBehavior.changeEvents={isDroppedDownChanged:["isDroppedDown"],textChanged:["text"],valueChanged:["value"],rangeEndChanged:["rangeEnd"]};WjInputDateTimeBehavior.classCtor=function(){return wjcInput.InputDateTime};WjInputDateTimeBehavior.modelProp="value";return WjInputDateTimeBehavior}(WjComponentBehavior);export var WjInputDateTime=WjInputDateTimeBehavior.register();function registerV3WjInputDateTime(e){e.component(WjInputDateTimeBehavior.tag,WjInputDateTime)}var WjInputDateRangeBehavior=function(e){__extends(WjInputDateRangeBehavior,e);function WjInputDateRangeBehavior(){return null!==e&&e.apply(this,arguments)||this}WjInputDateRangeBehavior.tag="wj-input-date-range";WjInputDateRangeBehavior.props=["isDisabled","tabOrder","isDroppedDown","showDropDownButton","autoExpandSelection","placeholder","dropDownCssClass","isAnimated","isReadOnly","isRequired","inputType","clickAction","selectionMode","format","mask","max","min","inputType","repeatButtons","showYearPicker","itemValidator","itemFormatter","monthCount","handleWheel","showMonthPicker","showHeader","weeksBefore","weeksAfter","rangeMin","rangeMax","separator","alwaysShowCalendar","predefinedRanges","closeOnSelection","text","value","rangeEnd"];WjInputDateRangeBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput","isDroppedDownChanging","rangeChanged"];WjInputDateRangeBehavior.changeEvents={isDroppedDownChanged:["isDroppedDown"],textChanged:["text"],valueChanged:["value"],rangeEndChanged:["rangeEnd"]};WjInputDateRangeBehavior.classCtor=function(){return wjcInput.InputDateRange};WjInputDateRangeBehavior.modelProp="value";return WjInputDateRangeBehavior}(WjComponentBehavior);export var WjInputDateRange=WjInputDateRangeBehavior.register();function registerV3WjInputDateRange(e){e.component(WjInputDateRangeBehavior.tag,WjInputDateRange)}var WjMenuBehavior=function(e){__extends(WjMenuBehavior,e);function WjMenuBehavior(){return null!==e&&e.apply(this,arguments)||this}Object.defineProperty(WjMenuBehavior.prototype,"value",{get:function(){return this._value},set:function(e){this._value=e;if(null!=e){this.control.selectedValue=e;this._updateHeader()}},enumerable:!0,configurable:!0});WjMenuBehavior.prototype._createControl=function(){var t=this,o=e.prototype._createControl.call(this);o.itemsSource=new wjcCore.ObservableArray;o.selectedIndex=0;o.listBox.formatItem.addHandler(this._fmtItem,this);o.invalidate();o.itemClicked.addHandler((function(e){t.value=t.control.selectedValue}));return o};WjMenuBehavior.prototype._updateControl=function(t,o){e.prototype._updateControl.call(this,t,o);if("header"===t){this._definedHeader=o;this._updateHeader()}"value"===t&&(this.value=o)};WjMenuBehavior.prototype._updateHeader=function(){this.control.header=this._definedHeader||"";var e=this.control.selectedItem;if(null!=this.value&&e&&this.control.displayMemberPath){var t=null;if(e instanceof WjMenuItemBehavior){var o=e.contentRoot;t=o?o.innerHTML:e[this.control.displayMemberPath]}null!=t&&(this.control.header+=": <b>"+t+"</b>")}};WjMenuBehavior.prototype._fmtItem=function(e,t){if(t.data instanceof WjMenuItemBehavior||t.data instanceof WjMenuSeparatorBehavior){t.item.textContent="";t.item.appendChild(t.data.contentRoot);t.data.added(t.item)}};WjMenuBehavior.tag="wj-menu";WjMenuBehavior.props=["isDisabled","tabOrder","isDroppedDown","showDropDownButton","autoExpandSelection","placeholder","dropDownCssClass","isAnimated","isReadOnly","isRequired","inputType","clickAction","displayMemberPath","selectedValuePath","headerPath","isContentHtml","isEditable","handleWheel","maxDropDownHeight","maxDropDownWidth","itemFormatter","showGroups","trimText","caseSensitiveSearch","virtualizationThreshold","header","commandParameterPath","commandPath","subItemsPath","openOnHover","closeOnLeave","isButton","itemsSource","text","selectedIndex","selectedItem","selectedValue","value"];WjMenuBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput","isDroppedDownChanging","itemsSourceChanged","formatItem"];WjMenuBehavior.changeEvents={isDroppedDownChanged:["isDroppedDown"],textChanged:["text"],selectedIndexChanged:["selectedIndex","selectedItem","selectedValue"],itemClicked:["value"]};WjMenuBehavior.classCtor=function(){return wjcInput.Menu};WjMenuBehavior.modelProp="selectedValue";return WjMenuBehavior}(WjComponentBehavior);export var WjMenu=WjMenuBehavior.register();function registerV3WjMenu(e){e.component(WjMenuBehavior.tag,WjMenu)}var WjMenuItemBehavior=function(e){__extends(WjMenuItemBehavior,e);function WjMenuItemBehavior(){return null!==e&&e.apply(this,arguments)||this}WjMenuItemBehavior.prototype._createControl=function(){var e=this.parent.control;1==e.itemsSource.length&&e.selectedIndex<0&&(e.selectedIndex=0);e.displayMemberPath||(e.displayMemberPath="header");e.selectedValuePath||(e.selectedValuePath="value");e.commandPath||(e.commandPath="cmd");e.commandParameterPath||(e.commandParameterPath="cmdParam");this.contentRoot=this.component.$el.firstElementChild;this.component.$el.style.display="none";return this};WjMenuItemBehavior.prototype.added=function(e){};WjMenuItemBehavior.tag="wj-menu-item";WjMenuItemBehavior.parentProp="itemsSource";WjMenuItemBehavior.siblingId="menuItemDir";WjMenuItemBehavior.props=["wjProperty","value","cmd","cmdParam"];WjMenuItemBehavior.events=["initialized"];WjMenuItemBehavior.render=function(e){if(VueApi.isV3Plus){var t=VueApi.h,o=this.$slots.default;return t("div",{},[t("div",{},o&&o())])}return e("div",[e("div",[this.$slots.default])])};return WjMenuItemBehavior}(WjComponentBehavior);export var WjMenuItem=WjMenuItemBehavior.register();function registerV3WjMenuItem(e){e.component(WjMenuItemBehavior.tag,WjMenuItem)}var WjMenuSeparatorBehavior=function(e){__extends(WjMenuSeparatorBehavior,e);function WjMenuSeparatorBehavior(){return null!==e&&e.apply(this,arguments)||this}WjMenuSeparatorBehavior.prototype._createControl=function(){this.contentRoot=this.component.$el.firstElementChild;this.component.$el.style.display="none";return this};WjMenuSeparatorBehavior.prototype.added=function(e){wjcCore.addClass(e,"wj-state-disabled")};WjMenuSeparatorBehavior.tag="wj-menu-separator";WjMenuSeparatorBehavior.parentProp="itemsSource";WjMenuSeparatorBehavior.siblingId="menuItemDir";WjMenuSeparatorBehavior.props=["wjProperty"];WjMenuSeparatorBehavior.events=["initialized"];WjMenuSeparatorBehavior.render=function(e){var t={width:"100%",height:"1px","background-color":"lightgray"};if(VueApi.isV3Plus){var o=VueApi.h;return o("div",{},[o("div",{style:t})])}return e("div",[e("div",{style:t})])};return WjMenuSeparatorBehavior}(WjComponentBehavior);export var WjMenuSeparator=WjMenuSeparatorBehavior.register();function registerV3WjMenuSeparator(e){e.component(WjMenuSeparatorBehavior.tag,WjMenuSeparator)}var WjItemTemplateDefinition={render:function(e){return VueApi.isV3Plus?VueApi.h("div"):e("div")},mounted:function(){var e=this,t=this.$parent;if(t){var o=t[WjComponentBehavior._behProp];o._mountedCB((function(){var t=o.control;e.ownerControl=t instanceof wjcInput.ListBox?t:t.listBox instanceof wjcInput.ListBox?t.listBox:void 0;e.itemComponents=[];var n=VueApi.isV3Plus?e.$slots.default:e.$scopedSlots.default,i=e.ownerControl;if(i&&n){e.formatItemHandler=function(t,o){var r=o.index;if(!e.itemComponents[r])if(VueApi.isV3Plus){var a=VueApi.h,s={parent:e.component,render:function(){return a("div",{},n&&n({itemIndex:r,item:o.data,control:i}))}},u=a(s);e.itemComponents[r]=o.item;o.item.textContent="";VueApi.render(u,o.item)}else{s=ItemTemplateComponentFactory(n,{itemIndex:r,item:o.data,control:i},e).$mount();e.itemComponents[r]=s;o.item.textContent="";o.item.appendChild(s.$el)}};i.formatItem.addHandler(e.formatItemHandler,e);i.loadingItems.addHandler((function(t){e._destroyItemComponents()}))}}))}},methods:{_destroyItemComponents:function(){(this.itemComponents||[]).forEach((function(e){VueApi.isV3Plus?VueApi.render(null,e):e.$destroy()}));this.itemComponents=[]}}};WjItemTemplateDefinition[VueApi.isV3Plus?"unmounted":"destroyed"]=function(){this.formatItemHandler&&this.ownerControl.formatItem.removeHandler(this.formatItemHandler,this);this._destroyItemComponents()};var ItemTemplateComponentFactory=function(e,t,o){var n=new ItemTemplateComponent({parent:o});n.itemTemplate=e;n.itemData=t;return n},ItemTemplateComponent=VueApi.extend({render:function(e){return e("div",{},this.itemTemplate&&this.itemTemplate(this.itemData))}}),WjItemTemplateTag="wj-item-template";export var WjItemTemplate=VueApi.isV3Plus?WjItemTemplateDefinition:VueApi.component(WjItemTemplateTag,WjItemTemplateDefinition);function registerV3WjItemTemplate(e){e.component(WjItemTemplateTag,WjItemTemplate)}var WjPopupBehavior=function(e){__extends(WjPopupBehavior,e);function WjPopupBehavior(){return null!==e&&e.apply(this,arguments)||this}WjPopupBehavior.tag="wj-popup";WjPopupBehavior.props=["isDisabled","tabOrder","owner","showTrigger","hideTrigger","fadeIn","fadeOut","isDraggable","isResizable","dialogResultEnter","dialogResultSubmit","modal","removeOnHide"];WjPopupBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput","showing","shown","hiding","hidden","resizing","sizeChanging","sizeChanged","resized","dragging","positionChanging","positionChanged","dragged"];WjPopupBehavior.classCtor=function(){return wjcInput.Popup};return WjPopupBehavior}(WjComponentBehavior);export var WjPopup=WjPopupBehavior.register();function registerV3WjPopup(e){e.component(WjPopupBehavior.tag,WjPopup)}var _CtxMenuUtils=function(){function _CtxMenuUtils(){this.key="__wjCtxMenu"}Object.defineProperty(_CtxMenuUtils.prototype,"definition",{get:function(){return VueApi.isV3Plus?{mounted:this._bind.bind(this),updated:this._update.bind(this),unmounted:this._unbind.bind(this)}:{bind:this._bind.bind(this),update:this._update.bind(this),unbind:this._unbind.bind(this)}},enumerable:!0,configurable:!0});_CtxMenuUtils.prototype._bind=function(e,t,o){var n=this,listener=function(i){if(!wjcCore.closest(i.target,"[disabled]")){var r=n._getMenuControl(t,o);if(r&&r.dropDown){i.preventDefault();i.stopPropagation();r.owner=e;r.show(i)}}};e.addEventListener("contextmenu",listener);e[this.key]={binding:t,listener:listener}};_CtxMenuUtils.prototype._unbind=function(e){var t=e[this.key]&&e[this.key].listener;t&&e.removeEventListener("contextmenu",t);e[this.key]=null};_CtxMenuUtils.prototype._update=function(e,t,o){var n=e[this.key]&&e[this.key].binding;if(!n||n.value!==t.value){this._unbind(e);this._bind(e,t,o)}};_CtxMenuUtils.prototype._getMenuControl=function(e,t){var o=null,n=null,i=e.value;if(null==i&&0===e.expression.indexOf("$refs.")){i=new wjcCore.Binding(e.expression).getValue(t.context)}wjcCore.isString(i)?n=document.getElementById(i):i instanceof HTMLElement&&(n=i);o=n?wjcCore.Control.getControl(n):i&&i.control||i;return wjcCore.tryCast(o,wjcInput.Menu)};return _CtxMenuUtils}(),wjContextMenuDefinition=(new _CtxMenuUtils).definition,WjContextMenuTag="wjContextMenu";export var WjContextMenu=VueApi.isV3Plus?wjContextMenuDefinition:VueApi.directive(WjContextMenuTag,wjContextMenuDefinition);function registerV3WjContextMenu(e){e.directive(WjContextMenuTag,WjContextMenu)}var WjCollectionViewNavigatorBehavior=function(e){__extends(WjCollectionViewNavigatorBehavior,e);function WjCollectionViewNavigatorBehavior(){return null!==e&&e.apply(this,arguments)||this}WjCollectionViewNavigatorBehavior.tag="wj-collection-view-navigator";WjCollectionViewNavigatorBehavior.props=["isDisabled","tabOrder","cv","byPage","headerFormat","repeatButtons"];WjCollectionViewNavigatorBehavior.events=["initialized","gotFocus","lostFocus","refreshing","refreshed","invalidInput"];WjCollectionViewNavigatorBehavior.classCtor=function(){return wjcInput.CollectionViewNavigator};return WjCollectionViewNavigatorBehavior}(WjComponentBehavior);export var WjCollectionViewNavigator=WjCollectionViewNavigatorBehavior.register();function registerV3WjCollectionViewNavigator(e){e.component(WjCollectionViewNavigatorBehavior.tag,WjCollectionViewNavigator)}export function registerInput(e){if(VueApi.isV3Plus){registerV3WjListBox(e);registerV3WjMultiSelectListBox(e);registerV3WjComboBox(e);registerV3WjAutoComplete(e);registerV3WjCalendar(e);registerV3WjColorPicker(e);registerV3WjInputMask(e);registerV3WjInputColor(e);registerV3WjMultiSelect(e);registerV3WjMultiAutoComplete(e);registerV3WjInputNumber(e);registerV3WjInputDate(e);registerV3WjInputTime(e);registerV3WjInputDateTime(e);registerV3WjInputDateRange(e);registerV3WjMenu(e);registerV3WjMenuItem(e);registerV3WjMenuSeparator(e);registerV3WjItemTemplate(e);registerV3WjPopup(e);registerV3WjContextMenu(e);registerV3WjCollectionViewNavigator(e)}}