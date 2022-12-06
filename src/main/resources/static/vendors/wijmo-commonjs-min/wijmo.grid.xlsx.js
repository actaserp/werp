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

"use strict";var __extends=this&&this.__extends||function(){var extendStatics=function(e,o){return(extendStatics=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,o){e.__proto__=o}||function(e,o){for(var t in o)o.hasOwnProperty(t)&&(e[t]=o[t])})(e,o)};return function(e,o){extendStatics(e,o);function __(){this.constructor=e}e.prototype=null===o?Object.create(o):(__.prototype=o.prototype,new __)}}(),__importStar=this&&this.__importStar||function(e){if(e&&e.__esModule)return e;var o={};if(null!=e)for(var t in e)Object.hasOwnProperty.call(e,t)&&(o[t]=e[t]);o.default=e;return o};Object.defineProperty(exports,"__esModule",{value:!0});var wijmo_1=require("wijmo/wijmo"),wijmo_grid_1=require("wijmo/wijmo.grid"),mXlsx=__importStar(require("wijmo/wijmo.xlsx")),selfModule=__importStar(require("wijmo/wijmo.grid.xlsx"));function softDetail(){return wijmo_1._getModule("wijmo.grid.detail")}exports.softDetail=softDetail;function softMultiRow(){return wijmo_1._getModule("wijmo.grid.multirow")}exports.softMultiRow=softMultiRow;function softTransposed(){return wijmo_1._getModule("wijmo.grid.transposed")}exports.softTransposed=softTransposed;function softTransposedMultiRow(){return wijmo_1._getModule("wijmo.grid.transposedmultirow")}exports.softTransposedMultiRow=softTransposedMultiRow;var FlexGridXlsxConverter=function(){function FlexGridXlsxConverter(){}FlexGridXlsxConverter.save=function(e,o,t){var l=new mXlsx.Workbook;this._saveFlexGridToWorkbook(l,e,o,!1,null);t&&l.save(t);return l};FlexGridXlsxConverter.saveAsync=function(e,o,t,l,r,n,i){var s=this,a=new mXlsx.Workbook;if(!i){this._saveFlexGridToWorkbook(a,e,o,!1,null);t?a.saveAsync(t,(function(e){wijmo_1.isFunction(l)&&l(e,a)}),r,null):wijmo_1.isFunction(l)&&l(null,a);return a}var u=null!=t;this.cancelAsync((function(){var i,d=[e.collectionView&&e.collectionView.collectionChanged,e.columns&&e.columns.collectionChanged,e.rows&&e.rows.collectionChanged,e.resizedColumn,e.resizedRow],removeHandlers=function(){return d.forEach((function(e){e&&e.removeHandler(restart)}))},restart=function(){s._cs&&s._cs.cancel(!1);clearTimeout(i);i=setTimeout((function(){removeHandlers();a=null;s.saveAsync(e,o,t,l,r,n)}),100)},finish=function(){clearTimeout(i);s._cs=null;removeHandlers()};s._cs=new mXlsx._SyncPromise(null,finish);d.forEach((function(e){e&&e.addHandler(restart)}));s._saveFlexGridToWorkbook(a,e,o,!0,s._cs,(function(e){wijmo_1.isFunction(n)&&n(u?Math.round(mXlsx._map(e,0,100,0,50)):e)})).then((function(){if(t){a._externalCancellation=function(){return s._cs};a.saveAsync(t,(function(e){finish();wijmo_1.isFunction(l)&&l(e,a)}),(function(e){finish();wijmo_1.isFunction(r)&&r(e)}),(function(e){wijmo_1.isFunction(n)&&n(Math.round(mXlsx._map(e,0,100,51,100)))}))}else{finish();wijmo_1.isFunction(n)&&n(100);wijmo_1.isFunction(l)&&l(null,a)}}),(function(e){finish();throw e}))}));return null};FlexGridXlsxConverter.cancelAsync=function(e){var o=this;if(this._cs){this._cs.cancel();setTimeout((function(){o._cs=null;wijmo_1.isFunction(e)&&e()}),100)}else wijmo_1.isFunction(e)&&e()};FlexGridXlsxConverter.load=function(e,o,t){var l=this;if(o instanceof Blob)_blobToBuffer(o,(function(r){o=null;var n=new mXlsx.Workbook;n.load(r,t?t.includeStyles:void 0);r=null;e.deferUpdate((function(){l._loadToFlexGrid(e,n,t);n=null}))}));else if(o instanceof mXlsx.Workbook)e.deferUpdate((function(){l._loadToFlexGrid(e,o,t);o=null}));else{if(!(o instanceof ArrayBuffer||wijmo_1.isString(o)))throw"Invalid workbook.";var r=new mXlsx.Workbook;r.load(o,t?t.includeStyles:void 0);o=null;e.deferUpdate((function(){l._loadToFlexGrid(e,r,t);r=null}))}};FlexGridXlsxConverter.loadAsync=function(e,o,t,l,r){var n=this;if(o instanceof Blob)_blobToBuffer(o,(function(i){o=null;var s=new mXlsx.Workbook;s.loadAsync(i,(function(){i=null;e.deferUpdate((function(){n._loadToFlexGrid(e,s,t);l&&l(s);s=null}))}),r,t?t.includeStyles:void 0)}));else if(o instanceof mXlsx.Workbook)e.deferUpdate((function(){n._loadToFlexGrid(e,o,t);l&&l(o);o=null}));else{if(!(o instanceof ArrayBuffer||wijmo_1.isString(o)))throw"Invalid workbook.";var i=new mXlsx.Workbook;i.loadAsync(o,(function(){o=null;e.deferUpdate((function(){n._loadToFlexGrid(e,i,t);l&&l(i);i=null}))}),r,t?t.includeStyles:void 0)}};FlexGridXlsxConverter._saveFlexGridToWorkbook=function(e,o,t,l,r,n){var i=new mXlsx._SyncPromise(r),s=new mXlsx.WorkSheet,a=!t||null==t.includeColumnHeaders||t.includeColumnHeaders,u=!(!t||null==t.includeRowHeaders)&&t.includeRowHeaders,d=_ExportCellStyles.Cache,c=t?t.includeColumns:null,f=t?t.formatItem:null,m=[],h=t&&null!=t.convertHtmlEntities?wijmo_1.asEnum(t.convertHtmlEntities,HtmlEntityConversion):HtmlEntityConversion.Auto;if(t){null!=t.includeCellStyles&&wijmo_1._deprecated("includeCellStyles","includeStyles");d=!1===wijmo_1.asBoolean(null!=t.includeStyles?t.includeStyles:t.includeCellStyles,!0)?_ExportCellStyles.None:!1===wijmo_1.asBoolean(t.quickCellStyles,!0)?_ExportCellStyles.Regular:_ExportCellStyles.Cache}var p=d===_ExportCellStyles.Cache?new _StyleCache(500):null;null==this.hasCssText&&(this.hasCssText="cssText"in document.body.style);s.name=t?t.sheetName:"";s.visible=!t||!1!==t.sheetVisible;s.rightToLeft=o.rightToLeft;var _,x=o.wj_sheetInfo;if(x&&x.tables&&x.tables.length>0)for(var w=0;w<x.tables.length;w++)s.tables.push(x.tables[w]);if(!x&&(d!==_ExportCellStyles.None||f)){(_=document.createElement("div")).style.visibility="hidden";_.setAttribute(wijmo_grid_1.FlexGrid._WJS_MEASURE,"true");o.hostElement.appendChild(_)}var g=u?o.rowHeaders.columns.length:0,v=this._getPerRowColumnsSettings(o,u?[o.topLeftCells,o.columnHeaders]:[o.columnHeaders]),y=v.cols,C=softMultiRow()&&o instanceof softMultiRow().MultiRow?this._getPerRowColumnsSettings(o,u?[o.rowHeaders,o.cells]:[o.cells],o.rowsPerItem).cols:null,b=y.length,S=[[o.topLeftCells,o.columnHeaders],[o.rowHeaders,o.cells],[o.bottomLeftCells,o.columnFooters]];a||S.shift();var T=S.map((function(e){return e[1].rows.length})).reduce((function(e,o){return e+o}));y.length&&y[0].forEach((function(e,o){var t=v.bndCols[0][o];if(!(o>=g&&c)||c(t)){var l=new mXlsx.WorkbookColumn;l._deserialize(e);s._addWorkbookColumn(l)}}));this._saveContentToWorksheet(r,l,Date.now(),0,{panels:S,panelIdx:0,globRowIdx:0,rowsOffset:0,totalRows:T},o,s,u,(function(e){return e==wijmo_grid_1.CellType.Cell&&C?C:y}),d,_,m,p,c,h,f,(function(e){n(Math.round(e/T*100))}),(function(){var l=new mXlsx.WorkbookFrozenPane;l.rows=a?o.frozenRows+b:o.frozenRows;l.columns=u?o.frozenColumns+g:o.frozenColumns;s.frozenPane=l;e._addWorkSheet(s);if(!x&&(d!==_ExportCellStyles.None||f)){o.hostElement.removeChild(_);m.forEach((function(e){return e.forEach((function(e){e&&e.parentElement&&e.parentElement.removeChild(e)}))}))}p&&p.clear();e.activeWorksheet=t?t.activeWorksheet:null;i.resolve()}));return i};FlexGridXlsxConverter._saveContentToWorksheet=function(e,o,t,l,r,n,i,s,a,u,d,c,f,m,h,p,_,x){for(var w=this,g=u?20:200,_loop_1=function(y){if(e&&e.cancelled)return{value:void 0};if(o&&y-l>g&&Date.now()-t>100){setTimeout((function(){if(!e||!e.cancelled){_(y);w._saveContentToWorksheet(e,o,Date.now(),y,r,n,i,s,a,u,d,c,f,m,h,p,_,x)}}),0);return{value:void 0}}for(;y-r.rowsOffset>=r.panels[r.panelIdx][1].rows.length;){r.rowsOffset+=r.panels[r.panelIdx][1].rows.length;r.panelIdx++}var C=r.panels[r.panelIdx],b=C[0],S=C[1],T=y-r.rowsOffset,X=S.rows[T];if(S.cellType!==wijmo_grid_1.CellType.Cell&&X.renderSize<=0||X instanceof wijmo_grid_1._NewRowTemplate)return"continue";var j=0,F={},k=new mXlsx.WorkbookRow,R=X instanceof wijmo_grid_1.GroupRow,E=0;S.cellType===wijmo_grid_1.CellType.Cell&&(R?E=X.level:n.rows.maxGroupLevel>-1&&(E=n.rows.maxGroupLevel+1));var A=a(S.cellType);s&&(j=v._parseFlexGridRowToSheetRow(i,b,F,T,0,A,u,d,c,f,R,E,m,h,p));v._parseFlexGridRowToSheetRow(i,S,F,T,j,A,u,d,c,f,R,E,m,h,p);if(F.cells.length>0){k._deserialize(F);i._addWorkbookRow(k,r.globRowIdx)}r.globRowIdx++},v=this,y=l;y<r.totalRows;y++){var C=_loop_1(y);if("object"==typeof C)return C.value}wijmo_1.isFunction(x)&&x()};FlexGridXlsxConverter._loadToFlexGrid=function(e,o,t){if(softTransposedMultiRow()&&e instanceof softTransposedMultiRow().TransposedMultiRow)throw"Not supported.";t=t||{};var l,r=null!=e.wj_sheetInfo,n={},i=[],s=[],a={};e.itemsSource=null;e.columns.clear();e.columnHeaders.rows.clear();e.rows.clear();e.frozenColumns=0;e.frozenRows=0;var u=null==t.sheetIndex||isNaN(t.sheetIndex)?0:t.sheetIndex;if(u<0||u>=o.sheets.length)throw"The sheet index option is out of the sheet range of current workbook.";if(null!=t.sheetName)for(var d=0;d<o.sheets.length;d++)if(t.sheetName===o.sheets[d].name){l=o.sheets[d];break}if(null!=(l=l||o.sheets[u]).rows){for(var c=this._getColumnCount(l.rows),f=this._getRowCount(l.rows,c),m=l.columns,h=0;h<c;h++){e.columns.push(new wijmo_grid_1.Column);if(m[h]){isNaN(+m[h].width)||(e.columns[h].width=+m[h].width);m[h].visible||null==m[h].visible||(e.columns[h].visible=!!m[h].visible);m[h].style&&m[h].style.wordWrap&&(e.columns[h].wordWrap=m[h].style.wordWrap)}}var p,_=(null==t.includeColumnHeaders||t.includeColumnHeaders)&&l.rows.length>0,x=_?this._getColumnHeadersHeight(l):0,w=!1,g=[],v=l.frozenPane&&l.frozenPane.rows,y=l.frozenPane&&l.frozenPane.columns;v=wijmo_1.isNumber(v)&&!isNaN(v)?v:null;y=wijmo_1.isNumber(y)&&!isNaN(y)?y:null;for(var C=x;C<f;C++){var b=!1,S=null,T=l.rows[C];if(T)for(var X=C+1;X<l.rows.length;){var j=l.rows[X];if(j){(isNaN(T.groupLevel)&&!isNaN(j.groupLevel)||!isNaN(T.groupLevel)&&T.groupLevel<j.groupLevel)&&(b=!0);break}X++}if(b&&!l.summaryBelow){p&&(p.isCollapsed=w);(p=new wijmo_grid_1.GroupRow).isReadOnly=!1;w=null!=T.collapsed&&T.collapsed;p.level=isNaN(T.groupLevel)?0:T.groupLevel;a[p.level]=w;this._checkParentCollapsed(a,p.level)&&p._setFlag(wijmo_grid_1.RowColFlags.ParentCollapsed,!0);e.rows.push(p)}else{var F=new wijmo_grid_1.Row;T&&this._checkParentCollapsed(a,T.groupLevel)&&F._setFlag(wijmo_grid_1.RowColFlags.ParentCollapsed,!0);e.rows.push(F)}T&&T.height&&!isNaN(T.height)&&(e.rows[C-x].height=T.height);for(h=0;h<c;h++)if(T){var k=T.cells[h],R=k?k.formula:null;R&&"="!==R[0]&&(R="="+R);if(k&&k.textRuns&&k.textRuns.length>0){e.rows[C-x].isContentHtml=!0;e.setCellData(C-x,h,this._parseTextRunsToHTML(k.textRuns))}else e.setCellData(C-x,h,R&&r?R:this._getItemValue(k));b||this._setColumn(g,h,k);var E=C*c+h,A=k?k.style:null;if(A){S=null==S?!!A.wordWrap:S&&!!A.wordWrap;if(r){var G=mXlsx.Workbook._parseExcelFormat(k),W=void 0;if(A.hAlign)W=mXlsx.Workbook._parseHAlignToString(wijmo_1.asEnum(A.hAlign,mXlsx.HAlign));else switch(this._getItemType(k)){case wijmo_1.DataType.Number:W="right";break;case wijmo_1.DataType.Boolean:W="center";break;default:W=G&&0===G.search(/[n,c,p]/i)?"right":"left"}n[E]={fontWeight:A.font&&A.font.bold?"bold":"none",fontStyle:A.font&&A.font.italic?"italic":"none",textDecoration:A.font&&A.font.underline?"underline":"none",textAlign:W,fontFamily:A.font&&A.font.family?A.font.family:"",fontSize:A.font&&A.font.size?A.font.size+"px":"",color:A.font&&A.font.color?A.font.color:"",backgroundColor:A.fill&&A.fill.color?A.fill.color:"",whiteSpace:A.wordWrap?"pre-wrap":"normal",format:G};if(A.borders){if(A.borders.left){this._parseBorderStyle(A.borders.left.style,"Left",n[E]);n[E].borderLeftColor=A.borders.left.color}if(A.borders.right){this._parseBorderStyle(A.borders.right.style,"Right",n[E]);n[E].borderRightColor=A.borders.right.color}if(A.borders.top){this._parseBorderStyle(A.borders.top.style,"Top",n[E]);n[E].borderTopColor=A.borders.top.color}if(A.borders.bottom){this._parseBorderStyle(A.borders.bottom.style,"Bottom",n[E]);n[E].borderBottomColor=A.borders.bottom.color}}if(A.fill&&A.fill.color){var H=n[E],B=A.borders,M=A.fill.color;if(B){B.left&&B.left.color||(H.borderLeftColor=M);B.right&&B.right.color||h===y-1||(H.borderRightColor=M);B.top&&B.top.color||(H.borderTopColor=M);B.bottom&&B.bottom.color||C===v-1||(H.borderBottomColor=M)}else{H.borderLeftColor=M;h!==y-1&&(H.borderRightColor=M);H.borderTopColor=M;C!==v-1&&(H.borderBottomColor=M)}}A.font&&-1===s.indexOf(A.font.family)&&s.push(A.font.family)}}r&&k&&wijmo_1.isNumber(k.rowSpan)&&k.rowSpan>0&&wijmo_1.isNumber(k.colSpan)&&k.colSpan>0&&(k.rowSpan>1||k.colSpan>1)&&i.push(new wijmo_grid_1.CellRange(C,h,C+k.rowSpan-1,h+k.colSpan-1))}if(T){this._checkParentCollapsed(a,T.groupLevel)||T.visible||null==T.visible||(e.rows[C-x].visible=T.visible);e.rows[C-x].wordWrap=!!T.style&&!!T.style.wordWrap||!!S}}p&&(p.isCollapsed=w);null!=y&&(e.frozenColumns=y);null!=v&&(e.frozenRows=_&&v>0?v-1:v);for(h=0;h<e.columnHeaders.columns.length;h++){var N=g[h],I=e.columns[h];I.isRequired=!1;if(N){N.dataType===wijmo_1.DataType.Boolean&&(I.dataType=N.dataType);I.format=N.format;I.align=N.hAlign;I.wordWrap=I.wordWrap||!!N.wordWrap}}for(d=0;d<Math.max(x,1);d++)e.columnHeaders.rows.push(new wijmo_grid_1.Row);for(d=0;d<x;d++)for(var D=0;D<e.columnHeaders.columns.length;D++){var z=l.rows[d]?l.rows[d].cells[D]:null,L=z&&null!=z.value?z.value:"",O=e.columnHeaders.columns[D];if(L){var P=mXlsx.Workbook._parseExcelFormat(z);L=wijmo_1.Globalize.format(L,P)}O.header=O.header||L;e.columnHeaders.setCellData(d,D,L)}if(r){var V=null==t.sheetVisible||t.sheetVisible;e.wj_sheetInfo.name=l.name;e.wj_sheetInfo.visible=!0===V||!1!==l.visible;e.wj_sheetInfo.styledCells=n;e.wj_sheetInfo.mergedRanges=i;e.wj_sheetInfo.fonts=s;e.wj_sheetInfo.tables=l.tables}}};FlexGridXlsxConverter._getColumnHeadersHeight=function(e){var o;if(!e||!(o=e.rows).length)return 0;if(!o[0])return 1;for(var t=0,l=1;t<o.length&&l>0;t++,l--){var r=o[t].cells.reduce((function(e,o){return Math.max(e,o.rowSpan||0)}),1);r>l&&(l=r)}return t};FlexGridXlsxConverter._escapePlainText=function(e){return null==e?"":""===e?"'":e&&("'"===e[0]||e.length>1&&"="===e[0]&&"="===e[1])?"'"+e:e};FlexGridXlsxConverter._parseFlexGridRowToSheetRow=function(e,o,t,l,r,n,i,s,a,u,d,c,f,m,h){var p=o.grid,_=p.wj_sheetInfo,x=o.rows[l],w=0,g=_&&_.evaluateFormula;null==x.recordIndex?o.cellType===wijmo_grid_1.CellType.ColumnHeader&&o.rows.length>1&&(w=Math.min(l,n.length-1)):w=x.recordIndex;t.cells||(t.cells=[]);t.visible=x.isVisible;t.height=x.renderHeight||o.rows.defaultSize;t.groupLevel=c;d&&(t.collapsed=x.isCollapsed);x.wordWrap&&(t.style={wordWrap:x.wordWrap});for(var v,y=x.constructor===wijmo_grid_1.Row||x.constructor===wijmo_grid_1._NewRowTemplate||softTransposed()&&p instanceof softTransposed().TransposedGrid&&x instanceof wijmo_grid_1.Row||softDetail()&&x.constructor===softDetail().DetailRow||softMultiRow()&&x.constructor===softMultiRow()._MultiRow||softTransposedMultiRow()&&x instanceof softTransposedMultiRow()._MultiRow,C=softDetail()&&x.constructor===softDetail().DetailRow,b=0,S=Math.round(mXlsx._xlsx._parsePixelToCharWidth(p.treeIndent)||0),getTreeIndent=function(e){return e*S};b<o.columns.length;b++){var T=void 0,X=void 0,j=void 0,F=1,k=1,R=!1,E=p._getBindingColumn(o,l,o.columns[b]),A=0;if(_&&o===p.cells){var G=l*o.columns.length+b;_.mergedRanges&&(T=this._getMergedRange(l,b,_.mergedRanges));_.styledCells&&(X=_.styledCells[G])}else if(i!==_ExportCellStyles.None){j=this._getMeasureCell(o,b,s,a);X=(T=p.getMergedRange(o,l,b,!1))?this._getCellStyle(o,j,T.bottomRow,T.rightCol,u,!!h)||{}:this._getCellStyle(o,j,l,b,u,!!h)||{}}T||(T=p.getMergedRange(o,l,b,!1));if(T){if(l===T.topRow&&b===T.leftCol){k=T.bottomRow-T.topRow+1;F=this._getColSpan(o,T,f);R=!0}}else R=!0;if(!f||f(E)){var W=n[w]?n[w][b+r]:null,H=void 0,B=void 0,M=void 0,N=void 0,I=void 0,D=void 0,z=void 0;if(y||d){M=R?o.getCellData(l,b,!0):null;N=R?o.getCellData(l,b,!1):null;B=this._isFormula(M);H=null;I=wijmo_1.isDate(N);if(X&&X.format){D=X.format;/[hsmyt\:]/i.test(D)&&(I=!0);z=mXlsx.Workbook._parseCellFormat(X.format,I)}else if(W&&W.style&&W.style.format){D=E.format;z=W.style.format}else z=null;B&&null!=g&&wijmo_1.isFunction(g)&&(H=g(M));if(!z)if(I)z="m/d/yyyy";else if(wijmo_1.isNumber(N)&&!E.dataMap)z=wijmo_1.isInt(N)?"#,##0":"#,##0.00";else if(B){var L=M.toLowerCase();if(L.indexOf("now()")>-1){z="m/d/yyyy h:mm";I=!0}else if(L.indexOf("today()")>-1||L.indexOf("date(")>-1){z="m/d/yyyy";I=!0}else if(L.indexOf("time(")>-1){z="h:mm AM/PM";I=!0}}else z="General"}else{M=R?p.columnHeaders.getCellData(0,b,!0):null;z="General"}var O=void 0;if(wijmo_1.isString(M)&&-1!==M.indexOf("<span")){O=this._parseToTextRuns(M);M=null}var P=this._parseCellStyle(X)||{};if(o===p.cells&&d&&x.hasChildren&&b===p.columns.firstVisibleIndex){var V=void 0;if(B&&null!=H)V=H;else{M?V=M:R&&(V=x.getGroupHeader());V&&(V=V.replace(/<\/?\w+>/g,"").replace(/&#39;/g,"'"))}if(null==V&&!X)continue;!(I=wijmo_1.isDate(V))&&D&&"d"===D.toLowerCase()&&wijmo_1.isInt(V)&&(z="0");V=wijmo_1.isString(V)?mXlsx.Workbook._unescapeXML(V):V;b===p.columns.firstVisibleIndex&&p.treeIndent&&(A=getTreeIndent(c));v={value:V,isDate:I,formula:B?this._parseToExcelFormula(M,I):null,colSpan:F,rowSpan:k,style:this._extend(P,{format:z,font:p.childItemsPath?{}:{bold:!0},hAlign:e.rightToLeft?mXlsx.HAlign.Right:mXlsx.HAlign.Left,indent:A}),textRuns:O}}else{if(d||m===HtmlEntityConversion.Auto&&E.isContentHtml||m===HtmlEntityConversion.Yes){M=wijmo_1.isString(M)?mXlsx.Workbook._unescapeXML(M):M;N=wijmo_1.isString(N)?mXlsx.Workbook._unescapeXML(N):N}!I&&D&&"d"===D.toLowerCase()&&wijmo_1.isInt(N)&&(z="0");var U=void 0;U=P&&P.hAlign?P.hAlign:W&&W.style&&null!=W.style.hAlign?wijmo_1.asEnum(W.style.hAlign,mXlsx.HAlign,!0):wijmo_1.isDate(N)?mXlsx.HAlign.Left:mXlsx.HAlign.General;o===p.cells&&b===p.columns.firstVisibleIndex&&p.treeIndent&&(e.rightToLeft&&U===mXlsx.HAlign.Right||!e.rightToLeft&&U===mXlsx.HAlign.Left||U===mXlsx.HAlign.General)&&(A=getTreeIndent(c));v={value:B?H:"General"!==z||""===M&&null==N?this._escapePlainText(N):this._escapePlainText(M),isDate:I,formula:B?this._parseToExcelFormula(M,I):null,colSpan:b<p.columns.firstVisibleIndex?1:F,rowSpan:k,style:this._extend(P,{format:z,hAlign:U,vAlign:k>1?o===p.cells||!1===p.centerHeadersVertically?mXlsx.VAlign.Top:mXlsx.VAlign.Center:null,indent:A}),textRuns:O}}if(h){h(new XlsxFormatItemEventArgs(o,new wijmo_grid_1.CellRange(l,b),j,s,a,u,v))}if(C){var q=o.getCellElement(l,b);if(q){var Y=x.detail;q.appendChild(Y);wijmo_1.Control.refreshAll(Y)}}t.cells.push(v)}}return r+b};FlexGridXlsxConverter._parseCellStyle=function(e,o){void 0===o&&(o=!1);if(null==e)return null;var t=e.fontSize;t=t?+t.substring(0,t.indexOf("px")):null;isNaN(t)&&(t=null);var l=e.whiteSpace;l=!!l&&l.indexOf("pre")>-1;var r=e.textAlign;"start"===r&&(r="rtl"===e.direction?"right":"left");"end"===r&&(r="rtl"===e.direction?"left":"right");return{font:{bold:"bold"===e.fontWeight||+e.fontWeight>=700,italic:"italic"===e.fontStyle,underline:"underline"===(e.textDecorationStyle||e.textDecoration),family:this._parseToExcelFontFamily(e.fontFamily),size:t,color:e.color},fill:{color:e.backgroundColor},borders:this._parseBorder(e,o),hAlign:mXlsx.Workbook._parseStringToHAlign(r),wordWrap:l}};FlexGridXlsxConverter._parseBorder=function(e,o){var t={left:this._parseEgdeBorder(e,"Left"),right:this._parseEgdeBorder(e,"Right"),top:this._parseEgdeBorder(e,"Top"),bottom:this._parseEgdeBorder(e,"Bottom")};if(o){t.vertical=this._parseEgdeBorder(e,"Vertical");t.horizontal=this._parseEgdeBorder(e,"Horizontal")}return t};FlexGridXlsxConverter._parseEgdeBorder=function(e,o){var t,l=e["border"+o+"Style"],r=e["border"+o+"Width"];r&&(r=parseFloat(r));if(l&&"none"!==l&&"hidden"!==l&&0!==r){t={};switch(l=l.toLowerCase()){case"dotted":t.style=r>1?mXlsx.BorderStyle.MediumDashDotted:mXlsx.BorderStyle.Dotted;break;case"dashed":t.style=r>1?mXlsx.BorderStyle.MediumDashed:mXlsx.BorderStyle.Dashed;break;case"double":t.style=mXlsx.BorderStyle.Double;break;default:t.style=r>2?mXlsx.BorderStyle.Thick:r>1?mXlsx.BorderStyle.Medium:mXlsx.BorderStyle.Thin}t.color=e["border"+o+"Color"]}return t};FlexGridXlsxConverter._parseBorderStyle=function(e,o,t){var l="border"+o+"Style",r="border"+o+"Width";switch(e){case mXlsx.BorderStyle.Dotted:case mXlsx.BorderStyle.Hair:t[l]="dotted";t[r]="1px";break;case mXlsx.BorderStyle.Dashed:case mXlsx.BorderStyle.ThinDashDotDotted:case mXlsx.BorderStyle.ThinDashDotted:t[l]="dashed";t[r]="1px";break;case mXlsx.BorderStyle.MediumDashed:case mXlsx.BorderStyle.MediumDashDotDotted:case mXlsx.BorderStyle.MediumDashDotted:case mXlsx.BorderStyle.SlantedMediumDashDotted:t[l]="dashed";t[r]="2px";break;case mXlsx.BorderStyle.Double:t[l]="double";t[r]="3px";break;case mXlsx.BorderStyle.Medium:t[l]="solid";t[r]="2px";break;case mXlsx.BorderStyle.Thick:t[l]="solid";t[r]="3px";break;default:t[l]="solid";t[r]="1px"}};FlexGridXlsxConverter._parseToExcelFontFamily=function(e){var o;e&&(o=e.split(","))&&o.length>0&&(e=o[0].replace(/\"|\'/g,""));return e};FlexGridXlsxConverter._parseToExcelFormula=function(e,o){var t=e.match(/(floor|ceiling)\([+-]?\d+\.?\d*\)/gi);if(t)for(var l=0;l<t.length;l++){var r=(i=t[l]).substring(0,i.lastIndexOf(")"))+", 1)";e=e.replace(i,r)}t=null;if(t=e.match(/text\(\"?\w+\"?\s*\,\s*\"\w+\"\)/gi)){var n=/\"?\w+\"?\s*\,\s*\"(\w+)\"/i;for(l=0;l<t.length;l++){var i,s=(i=t[l]).match(n);if(s&&2===s.length){var a=s[1];if(!/^d{1,4}?$/.test(a)){var u=mXlsx.Workbook._parseCellFormat(a,o);r=i.replace(a,u);e=e.replace(i,r)}}}}return e};FlexGridXlsxConverter._parseToTextRuns=function(e){for(var o=e.split("<span "),t=[],l=0;l<o.length;l++){var r=o[l],n=void 0;if(-1!==r.indexOf("</span>")){n={text:r.substring(r.indexOf(">")+1,r.indexOf("</span>")),font:this._parseToTextRunFont(r.substring(r.indexOf('style="')+7,r.indexOf(';"')))}}else n={text:r};t.push(n)}return t};FlexGridXlsxConverter._parseToTextRunFont=function(e){var o,t=e.split(";");if(t.length>0){for(var l=void 0,r=void 0,n=void 0,i=void 0,s=void 0,a=void 0,u=0;u<t.length;u++){var d=t[u].split(":");if(2===d.length){d[1]=d[1].trim();switch(d[0]){case"font-size":i=+d[1].substring(0,d[1].indexOf("px"));isNaN(i)&&(i=null);break;case"font-weight":l="bold"===d[1]||+d[1]>=700;break;case"font-style":r="italic"===d[1];break;case"text-decoration-style":case"text-decoration":n="underline"===d[1];break;case"font-family":s=this._parseToExcelFontFamily(d[1]);break;case"color":a=d[1]}}}o={bold:l,italic:r,underline:n,family:s,size:i,color:a}}return o};FlexGridXlsxConverter._getMeasureCell=function(e,o,t,l){var r=l[e.cellType],n=r&&r[o],i=null==n;if(n){if(this.hasCssText){n.style.cssText="";n.style.visibility="hidden"}}else{r||(l[e.cellType]=r=[]);r[o]=n=t.cloneNode()}!i&&n.parentElement||(e.hostElement.children.length>0?e.hostElement.children[0].appendChild(n):e.hostElement.appendChild(n));return n};FlexGridXlsxConverter._getColumnSetting=function(e,o,t){var l=e;null!=e.colspan&&(l=this._getRenderColumn(o,t));return l?{autoWidth:!0,width:l.renderWidth||t.defaultSize,visible:l.visible&&0!==l.width&&!l._getFlag(wijmo_grid_1.RowColFlags.ParentCollapsed),style:{format:e.format?mXlsx.Workbook._parseCellFormat(e.format,e.dataType===wijmo_1.DataType.Date):"",hAlign:mXlsx.Workbook._parseStringToHAlign(this._toExcelHAlign(l.getAlignment())),wordWrap:l.wordWrap}}:null};FlexGridXlsxConverter._getPerRowColumnsSettings=function(e,o,t){var l=this,r=[],n=[];o.forEach((function(i,s){for(var a=0,u=s>0?o[0].columns.length:0,_loop_2=function(o){if(null!=t&&o>=t)return"break";if(i.rows[o].renderSize<=0)return"continue";r[a]=r[a]||[];n[a]=n[a]||[];i.columns.forEach((function(t,s){var d=e._getBindingColumn(i,o,t),c=l._getColumnSetting(d,s,i.columns);if(c){r[a][u+s]=c;n[a][u+s]=d}}));a++},d=0;d<i.rows.length;d++){if("break"===_loop_2(d))break}}));return{cols:r,bndCols:n}};FlexGridXlsxConverter._toExcelHAlign=function(e){return(e=e?e.trim().toLowerCase():e)?e.indexOf("center")>-1?"center":e.indexOf("right")>-1||e.indexOf("end")>-1?"right":e.indexOf("justify")>-1?"justify":"left":e};FlexGridXlsxConverter._getColumnCount=function(e){for(var o=0,t=0;t<e.length;t++){var l=e[t]&&e[t].cells?e[t].cells:[];if(l&&l.length>0){var r=l.length;wijmo_1.isInt(l[r-1].colSpan)&&l[r-1].colSpan>1&&(r=r+l[r-1].colSpan-1);r>o&&(o=r)}}return o};FlexGridXlsxConverter._getRowCount=function(e,o){for(var t=e.length,l=t-1,r=0;r<o;r++)e:for(;l>=0;l--){var n=e[l],i=(n&&n.cells?n.cells:[])[r];if(i&&(null!=i.value&&""!==i.value||wijmo_1.isInt(i.rowSpan)&&i.rowSpan>1)){wijmo_1.isInt(i.rowSpan)&&i.rowSpan>1&&l+i.rowSpan>t&&(t=l+i.rowSpan);break e}}return t};FlexGridXlsxConverter._numAlpha=function(e){var o=Math.floor(e/26)-1;return(o>-1?this._numAlpha(o):"")+String.fromCharCode(65+e%26)};FlexGridXlsxConverter._getItemType=function(e){return null==e||null==e.value||isNaN(e.value)?null:wijmo_1.getType(e.value)};FlexGridXlsxConverter._setColumn=function(e,o,t){var l=e[o];if(l){var r=this._getItemType(t);l.dataType!==r&&l.dataType===wijmo_1.DataType.Boolean&&r!==wijmo_1.DataType.Boolean&&(l.dataType=r);if(t&&null!=t.value&&(!wijmo_1.isString(t.value)||!wijmo_1.isNullOrWhiteSpace(t.value))){var n=mXlsx.Workbook._parseExcelFormat(t);n&&l.format!==n&&"General"!==n&&(l.format=n)}var i=void 0;if(t&&t.style){t.style.hAlign&&(i=mXlsx.Workbook._parseHAlignToString(wijmo_1.asEnum(t.style.hAlign,mXlsx.HAlign)));null==l.wordWrap?l.wordWrap=!!t.style.wordWrap:l.wordWrap=l.wordWrap&&!!t.style.wordWrap}i||r!==wijmo_1.DataType.Number||(i="right");l.hAlign=i}else e[o]={dataType:this._getItemType(t),format:mXlsx.Workbook._parseExcelFormat(t),hAlign:"",wordWrap:null}};FlexGridXlsxConverter._getItemValue=function(e){if(null==e||null==e.value)return null;var o=e.value;wijmo_1.isString(o)&&"'"===o[0]&&(o=o.substr(1));return wijmo_1.isNumber(o)&&isNaN(o)?"":o instanceof Date&&isNaN(o.getTime())?"":o};FlexGridXlsxConverter._getCellStyle=function(e,o,t,l,r,n){var i,s=e.grid;try{var a=!(r&&!s.formatItem.hasHandlers&&!s.itemFormatter&&!n);s.cellFactory.updateCell(e,t,l,o,null,a);o.className=o.className.replace("wj-state-selected","");o.className=o.className.replace("wj-state-multi-selected","")}catch(e){return null}if(r){var u=e.hostElement,d=o,c=d.style.cssText.split(/;\s+/).filter((function(e){var o=e.substring(0,e.indexOf(":"));return/^(color|background|border|font|text|whitespace)/i.test(o)})).join(";");do{c=d.className+c}while(d!==u&&(d=d.parentElement));if(!(i=r.getValue(c))){i=window.getComputedStyle(o);r.add(c,i)}}else i=window.getComputedStyle(o);return i};FlexGridXlsxConverter._parseTextRunsToHTML=function(e){for(var o="",t=0;t<e.length;t++){var l=e[t],r=l.font;o+=r?'<span style="'+(r.bold?"font-weight: bold;":"")+(r.italic?"font-style: italic;":"")+(r.underline?"text-decoration: underline;":"")+(r.family?"font-family: "+r.family+";":"")+(null!=r.size?"font-size: "+r.size+"px;":"")+(r.color?"color: "+r.color+";":"")+'">'+l.text+"</span>":l.text}return o};FlexGridXlsxConverter._extend=function(e,o){for(var t in o){var l=o[t];wijmo_1.isObject(l)&&e[t]?wijmo_1.copy(e[t],l):e[t]=l}return e};FlexGridXlsxConverter._checkParentCollapsed=function(e,o){var t=!1;Object.keys(e).forEach((function(l){!0===e[l]&&!1===t&&!isNaN(o)&&+l<o&&(t=!0)}));return t};FlexGridXlsxConverter._getColSpan=function(e,o,t){for(var l=0,r=o.leftCol;r<=o.rightCol;r++)t&&!t(e.columns[r])||l++;return l};FlexGridXlsxConverter._getRenderColumn=function(e,o){return e>=o.length?null:o[e]};FlexGridXlsxConverter._getMergedRange=function(e,o,t){for(var l=0;l<t.length;l++){var r=t[l];if(e>=r.topRow&&e<=r.bottomRow&&o>=r.leftCol&&o<=r.rightCol)return r}return null};FlexGridXlsxConverter._isFormula=function(e){return e&&"string"==typeof e&&e.length>1&&"="===e[0]&&"="!==e[1]};return FlexGridXlsxConverter}();exports.FlexGridXlsxConverter=FlexGridXlsxConverter;var _ExportCellStyles,XlsxFormatItemEventArgs=function(e){__extends(XlsxFormatItemEventArgs,e);function XlsxFormatItemEventArgs(o,t,l,r,n,i,s){var a=e.call(this,o,t)||this;a._cell=l;a._patternCell=r;a._xlsxCell=s;a._cellsCache=n;a._styleCache=i;return a}Object.defineProperty(XlsxFormatItemEventArgs.prototype,"cell",{get:function(){return this._cell},enumerable:!0,configurable:!0});Object.defineProperty(XlsxFormatItemEventArgs.prototype,"xlsxCell",{get:function(){return this._xlsxCell},set:function(e){this._xlsxCell=e},enumerable:!0,configurable:!0});XlsxFormatItemEventArgs.prototype.getFormattedCell=function(){if(!this._cell){this._cell=FlexGridXlsxConverter._getMeasureCell(this.panel,this.col,this._patternCell,this._cellsCache);FlexGridXlsxConverter._getCellStyle(this.panel,this._cell,this.row,this.col,this._styleCache,!0)}return this._cell};return XlsxFormatItemEventArgs}(wijmo_grid_1.CellRangeEventArgs);exports.XlsxFormatItemEventArgs=XlsxFormatItemEventArgs;!function(e){e[e.None=0]="None";e[e.Regular=1]="Regular";e[e.Cache=2]="Cache"}(_ExportCellStyles||(_ExportCellStyles={}));var HtmlEntityConversion,_StyleCache=function(){function _StyleCache(e){this._cache={};this._size=0;this._max=e}_StyleCache.prototype.add=function(e,o){this._size>=this._max&&this.clear();this._cache[e]=this._cloneStyle(o);this._size++};_StyleCache.prototype.clear=function(){this._cache={};this._size=0};_StyleCache.prototype.getValue=function(e){return this._cache[e]||null};_StyleCache.prototype.hasKey=function(e){return!!this._cache[e]};_StyleCache.prototype._cloneStyle=function(e){if(!e)return null;for(var o={},toCamel=function(e){return e.replace(/\-([a-z])/g,(function(e,o,t){return t>0?o.toUpperCase():o}))},t=0,l=e.length;t<l;t++){var r=e[t];o[toCamel(r)]=e.getPropertyValue(r)}return o};return _StyleCache}();exports._StyleCache=_StyleCache;function _blobToBuffer(e,o){if(e&&o)if(e.arrayBuffer)e.arrayBuffer().then((function(e){return o(e)}));else{var t=new FileReader;t.onload=function(){o(t.result);t=null};t.readAsArrayBuffer(e)}}exports._blobToBuffer=_blobToBuffer;!function(e){e[e.Auto=0]="Auto";e[e.No=1]="No";e[e.Yes=2]="Yes"}(HtmlEntityConversion=exports.HtmlEntityConversion||(exports.HtmlEntityConversion={}));wijmo_1._registerModule("wijmo.grid.xlsx",selfModule);