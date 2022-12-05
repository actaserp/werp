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

var __extends=this&&this.__extends||function(){var extendStatics=function(e,t){return(extendStatics=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var i in t)t.hasOwnProperty(i)&&(e[i]=t[i])})(e,t)};return function(e,t){extendStatics(e,t);function __(){this.constructor=e}e.prototype=null===t?Object.create(t):(__.prototype=t.prototype,new __)}}();import{isString,copy,asNumber,asString,clamp,PropertyChangedEventArgs,Event,assert,setAttribute,animate,setCss,toggleClass,mouseToPage,isiOS,isNumber,isFunction,asBoolean,asType,asFunction,asEnum,asArray,Globalize,Control,Color,Point,Rect,Key,ObservableArray,addClass,format,removeChild,Size,_deprecated,_registerModule}from"wijmo/wijmo";import*as selfModule from"wijmo/wijmo.gauge";var Range=function(){function Range(e){this._min=0;this._max=100;this._thickness=1;this.propertyChanged=new Event;isString(e)?this._name=e:copy(this,e)}Object.defineProperty(Range.prototype,"min",{get:function(){return this._min},set:function(e){this._setProp("_min",asNumber(e,!0))},enumerable:!0,configurable:!0});Object.defineProperty(Range.prototype,"max",{get:function(){return this._max},set:function(e){this._setProp("_max",asNumber(e,!0))},enumerable:!0,configurable:!0});Object.defineProperty(Range.prototype,"color",{get:function(){return this._color},set:function(e){this._setProp("_color",asString(e))},enumerable:!0,configurable:!0});Object.defineProperty(Range.prototype,"thickness",{get:function(){return this._thickness},set:function(e){this._setProp("_thickness",clamp(asNumber(e),0,1))},enumerable:!0,configurable:!0});Object.defineProperty(Range.prototype,"name",{get:function(){return this._name},set:function(e){this._setProp("_name",asString(e))},enumerable:!0,configurable:!0});Range.prototype.onPropertyChanged=function(e){this.propertyChanged.raise(this,e)};Range.prototype._setProp=function(e,t){var i=this[e];if(t!=i){this[e]=t;var n=new PropertyChangedEventArgs(e.substr(1),i,t);this.onPropertyChanged(n)}};Range._ctr=0;return Range}();export{Range};export var ShowText;!function(e){e[e.None=0]="None";e[e.Value=1]="Value";e[e.MinMax=2]="MinMax";e[e.All=3]="All"}(ShowText||(ShowText={}));var Gauge=function(e){__extends(Gauge,e);function Gauge(t,i){var n=e.call(this,t,null,!0)||this;n._ranges=new ObservableArray;n._rngElements=[];n._format="n0";n._showRanges=!0;n._stackRanges=!1;n._shadow=!0;n._animated=!0;n._readOnly=!0;n._handleWheel=!0;n._step=1;n._showText=ShowText.None;n._showTicks=!1;n._showTickText=!1;n._thickness=.8;n._initialized=!1;n.valueChanged=new Event;n._getPercent=function(e){var t=this.max>this.min?(e-this.min)/(this.max-this.min):0;return Math.max(0,Math.min(1,t))};Gauge._ctr++;var a=n.hostElement;setAttribute(a,"role","slider",!0);var r=n.getTemplate();n.applyTemplate("wj-control wj-gauge",r,{_dSvg:"dsvg",_svg:"svg",_filter:"filter",_gFace:"gface",_gRanges:"granges",_gPointer:"gpointer",_gCover:"gcover",_pFace:"pface",_pPointer:"ppointer",_cValue:"cvalue",_tValue:"value",_tMin:"min",_tMax:"max",_pTicks:"pticks",_gTicks:"gticks",_gNeedle:"gneedle"});setCss(n._dSvg,{width:"100%",height:"100%"});n._filterID="wj-gauge-filter-"+Gauge._ctr.toString(36);n._filter.setAttribute("id",n._filterID);n.face=new Range;n.pointer=new Range;n._ranges.collectionChanged.addHandler((function(){n._ranges.forEach((function(e){assert(e instanceof Range,"ranges array must contain Range objects.")}));n._rangesDirty=!0;n.invalidate()}));n.addEventListener(a,"keydown",n._keydown.bind(n));n.addEventListener(a,"click",(function(e){if(0==e.button){n.focus();n._applyMouseValue(e)}}));n.addEventListener(a,"mousedown",(function(e){if(0==e.button){n.focus();n._dragging=!0;setTimeout((function(){n._applyMouseValue(e)}))}}));n.addEventListener(a,"mousemove",(function(e){n._dragging&&n.containsFocus()&&n._applyMouseValue(e,!0)}));n.addEventListener(a,"mouseup",(function(e){n._dragging=!1}));n.addEventListener(a,"mouseleave",(function(e){e.target==a&&(n._dragging=!1)}));if("ontouchstart"in window){n.addEventListener(a,"touchstart",(function(e){n.focus();!e.defaultPrevented&&n._applyMouseValue(e,!1)&&e.preventDefault()}));n.addEventListener(a,"touchmove",(function(e){!e.defaultPrevented&&n._applyMouseValue(e,!0)&&e.preventDefault()}))}n.addEventListener(a,"wheel",(function(e){if(n._handleWheel&&!n.isReadOnly&&!e.defaultPrevented&&n.containsFocus()&&null!=n.value&&n.hitTest(e)){var t=clamp(-e.deltaY,-1,1);n.value=clamp(n.value+(n.step||1)*t,n.min,n.max);e.preventDefault()}}));n.isReadOnly=!0;n.initialize(i);n.invalidate();return n}Object.defineProperty(Gauge.prototype,"value",{get:function(){return this._pointer.max},set:function(e){if(e!=this.value){this._pointer.max=asNumber(e,!0);this._updateAria()}},enumerable:!0,configurable:!0});Object.defineProperty(Gauge.prototype,"min",{get:function(){return this._face.min},set:function(e){if(e!=this.min){this._face.min=asNumber(e);this._updateAria()}},enumerable:!0,configurable:!0});Object.defineProperty(Gauge.prototype,"max",{get:function(){return this._face.max},set:function(e){if(e!=this.max){this._face.max=asNumber(e);this._updateAria()}},enumerable:!0,configurable:!0});Object.defineProperty(Gauge.prototype,"origin",{get:function(){return this._origin},set:function(e){if(e!=this._origin){this._origin=asNumber(e,!0);this.invalidate()}},enumerable:!0,configurable:!0});Object.defineProperty(Gauge.prototype,"isReadOnly",{get:function(){return this._readOnly},set:function(e){this._readOnly=asBoolean(e);setAttribute(this._svg,"cursor",this._readOnly?null:"pointer");toggleClass(this.hostElement,"wj-state-readonly",this.isReadOnly)},enumerable:!0,configurable:!0});Object.defineProperty(Gauge.prototype,"handleWheel",{get:function(){return this._handleWheel},set:function(e){this._handleWheel=asBoolean(e)},enumerable:!0,configurable:!0});Object.defineProperty(Gauge.prototype,"step",{get:function(){return this._step},set:function(e){if(e!=this._step){this._step=asNumber(e,!0);this.invalidate()}},enumerable:!0,configurable:!0});Object.defineProperty(Gauge.prototype,"format",{get:function(){return this._format},set:function(e){if(e!=this._format){this._format=asString(e);this.invalidate()}},enumerable:!0,configurable:!0});Object.defineProperty(Gauge.prototype,"getText",{get:function(){return this._getText},set:function(e){if(e!=this._getText){this._getText=asFunction(e);this.invalidate()}},enumerable:!0,configurable:!0});Object.defineProperty(Gauge.prototype,"thickness",{get:function(){return this._thickness},set:function(e){if(e!=this._thickness){this._thickness=clamp(asNumber(e,!1),0,1);this.invalidate()}},enumerable:!0,configurable:!0});Object.defineProperty(Gauge.prototype,"face",{get:function(){return this._face},set:function(e){if(e!=this._face){this._face&&this._face.propertyChanged.removeHandler(this._rangeChanged);this._face=asType(e,Range);this._face&&this._face.propertyChanged.addHandler(this._rangeChanged,this);this.invalidate()}},enumerable:!0,configurable:!0});Object.defineProperty(Gauge.prototype,"pointer",{get:function(){return this._pointer},set:function(e){if(e!=this._pointer){var t=null;if(this._pointer){t=this.value;this._pointer.propertyChanged.removeHandler(this._rangeChanged)}this._pointer=asType(e,Range);if(this._pointer){t&&(this.value=t);this._pointer.propertyChanged.addHandler(this._rangeChanged,this)}this.invalidate()}},enumerable:!0,configurable:!0});Object.defineProperty(Gauge.prototype,"showText",{get:function(){return this._showText},set:function(e){if((e=asEnum(e,ShowText))!=this._showText){this._showText=e;this.invalidate()}},enumerable:!0,configurable:!0});Object.defineProperty(Gauge.prototype,"showTicks",{get:function(){return this._showTicks},set:function(e){if(e!=this._showTicks){this._showTicks=asBoolean(e);this.invalidate()}},enumerable:!0,configurable:!0});Object.defineProperty(Gauge.prototype,"showTickText",{get:function(){return this._showTickText},set:function(e){if(e!=this._showTickText){this._showTickText=asBoolean(e);this.invalidate()}},enumerable:!0,configurable:!0});Object.defineProperty(Gauge.prototype,"tickSpacing",{get:function(){return this._tickSpacing},set:function(e){if(e!=this._tickSpacing){this._tickSpacing=asNumber(e,!0);this.invalidate()}},enumerable:!0,configurable:!0});Object.defineProperty(Gauge.prototype,"thumbSize",{get:function(){return this._thumbSize},set:function(e){if(e!=this._thumbSize){this._thumbSize=asNumber(e,!0,!0);this.invalidate()}},enumerable:!0,configurable:!0});Object.defineProperty(Gauge.prototype,"showRanges",{get:function(){return this._showRanges},set:function(e){if(e!=this._showRanges){this._showRanges=asBoolean(e);this._animColor=null;this._rangesDirty=!0;this.invalidate()}},enumerable:!0,configurable:!0});Object.defineProperty(Gauge.prototype,"stackRanges",{get:function(){return this._stackRanges},set:function(e){if(e!=this._stackRanges){this._stackRanges=asBoolean(e);this._animColor=null;this._rangesDirty=!0;this.invalidate()}},enumerable:!0,configurable:!0});Object.defineProperty(Gauge.prototype,"hasShadow",{get:function(){return this._shadow},set:function(e){if(e!=this._shadow){this._shadow=asBoolean(e);this.invalidate()}},enumerable:!0,configurable:!0});Object.defineProperty(Gauge.prototype,"isAnimated",{get:function(){return this._animated},set:function(e){this._animated=asBoolean(e)},enumerable:!0,configurable:!0});Object.defineProperty(Gauge.prototype,"ranges",{get:function(){return this._ranges},enumerable:!0,configurable:!0});Gauge.prototype.onValueChanged=function(e){this.valueChanged.raise(this,e)};Gauge.prototype.refresh=function(t){var i=this;void 0===t&&(t=!0);e.prototype.refresh.call(this,t);if(this._rangesDirty){this._rangesDirty=!1;var n=this._gRanges;this._rngElements.forEach((function(e){e.rng.propertyChanged.removeHandler(i._rangeChanged)}));for(;n.lastChild;)n.removeChild(n.lastChild);this._rngElements=[];this._showRanges&&this._ranges.forEach((function(e){e.propertyChanged.addHandler(i._rangeChanged,i);i._rngElements.push({rng:e,el:i._createElement("path",n)})}))}this._showElement(this._tValue,0!=(this.showText&ShowText.Value));this._showElement(this._tMin,0!=(this.showText&ShowText.MinMax));this._showElement(this._tMax,0!=(this.showText&ShowText.MinMax));this._showElement(this._cValue,0!=(this.showText&ShowText.Value)||this._thumbSize>0);this._updateText();var a=this._getFilterUrl();setAttribute(this._pFace,"filter",a);setAttribute(this._pPointer,"filter",a);this._updateRange(this._face);this._updateRange(this._pointer);this._updateTicks();this._ranges.forEach((function(e){i._updateRange(e)}));this._initialized=!0};Gauge.prototype.hitTest=function(e,t){isNumber(e)&&isNumber(t)?e=new Point(e,t):e instanceof Point||(e=mouseToPage(e));e=asType(e,Point);var i=Rect.fromBoundingRect(this._dSvg.getBoundingClientRect());e.x-=i.left+pageXOffset;e.y-=i.top+pageYOffset;return this._getValueFromPoint(e)};Gauge._getBBox=function(e){try{return e.getBBox()}catch(e){return{x:0,y:0,width:0,height:0}}};Gauge.prototype._getFilterUrl=function(){return this.hasShadow&&!isiOS()?"url(#"+this._filterID+")":null};Gauge.prototype._getRangeElement=function(e){if(e==this._face)return this._pFace;if(e==this._pointer)return this._pPointer;for(var t=0;t<this._rngElements.length;t++){var i=this._rngElements[t];if(i.rng==e)return i.el}return null};Gauge.prototype._rangeChanged=function(e,t){var i=this;if(e==this._pointer&&"max"==t.propertyName){this.onValueChanged();this._updateText()}if(e!=this._face){if(e==this._pointer&&"max"==t.propertyName){this._animInterval&&clearInterval(this._animInterval);if(this.isAnimated&&!this.isUpdating&&this._initialized){var n=this._getPointerColor(t.oldValue),a=this._getPointerColor(t.newValue),r=n?new Color(n):null,s=a?new Color(a):null,o=clamp(Math.abs(t.newValue-t.oldValue)/(this.max-this.min),0,1);this._animInterval=animate((function(n){i._animColor=r&&s?Color.interpolate(r,s,n).toString():null;i._updateRange(e,t.oldValue+n*(t.newValue-t.oldValue));if(n>=1){i._animColor=null;i._animInterval=null;i._updateRange(e);i._updateText()}}),o*Control._ANIM_DEF_DURATION);return}}this._updateRange(e)}else this.invalidate()};Gauge.prototype._createElement=function(e,t,i){var n=document.createElementNS(Gauge._SVGNS,e);i&&n.setAttribute("class",i);t.appendChild(n);return n};Gauge.prototype._centerText=function(e,t,i){if("none"!=e.getAttribute("display")){var n=Globalize.format(t,this.format);if(isFunction(this.getText)){var a="";e==this._tValue?a="value":e==this._tMin?a="min":e==this._tMax&&(a="max");a&&(n=this.getText(this,a,t,n))}e.textContent=n;var r=Rect.fromBoundingRect(Gauge._getBBox(e)),s=i.x-r.width/2,o=i.y+r.height/4;e.setAttribute("x",this._fix(s));e.setAttribute("y",this._fix(o))}};Gauge.prototype._copy=function(e,t){var i=this;if("ranges"==e){asArray(t).forEach((function(e){var t=new Range(e);i.ranges.push(t)}));return!0}if("pointer"==e){copy(this.pointer,t);return!0}return!1};Gauge.prototype._showElement=function(e,t){setAttribute(e,"display",t?null:"none")};Gauge.prototype._updateRange=function(e,t){void 0===t&&(t=e.max);e==this._pointer&&(e.min=null!=this.origin?this.origin:this.min<0&&this.max>0?0:this.min);var i=this._getRangeElement(e);if(i){this._updateRangeElement(i,e,t);var n=e.color;e==this._pointer&&(n=this._animColor?this._animColor:this._getPointerColor(e.max));setAttribute(i,"style",n?"fill:"+n:null)}};Gauge.prototype._getPointerColor=function(e){if(!this._showRanges){for(var t,i=0;i<this._ranges.length;i++){var n=this._ranges[i];if(e>=n.min&&e<=n.max){t=n;break}}if(t)return t.color}return this._pointer.color};Gauge.prototype._keydown=function(e){if(!this._readOnly&&this._step){var t=!0;switch(this._getKey(e.keyCode)){case Key.Left:case Key.Down:this.value=clamp(this.value-this._step,this.min,this.max);break;case Key.Right:case Key.Up:this.value=clamp(this.value+this._step,this.min,this.max);break;case Key.Home:this.value=this.min;break;case Key.End:this.value=this.max;break;default:t=!1}t&&e.preventDefault()}};Gauge.prototype._getKey=function(e){return e};Gauge.prototype._applyMouseValue=function(e,t){if(!this.isReadOnly&&this.containsFocus()){var i=this.hitTest(e);if(null!=i){var n=this._animated,a=this._step;t&&(this._animated=!1);a&&(i=Math.round(i/a)*a);this.value=clamp(i,this.min,this.max);this._animated=n;return!0}}return!1};Gauge.prototype._updateRangeElement=function(e,t,i){assert(!1,"Gauge is an abstract class.")};Gauge.prototype._updateText=function(){assert(!1,"Gauge is an abstract class.")};Gauge.prototype._updateTicks=function(){assert(!1,"Gauge is an abstract class.")};Gauge.prototype._getValueFromPoint=function(e){return null};Gauge.prototype._fix=function(e){return isNumber(e)?parseFloat(e.toFixed(4)).toString():this._fix(e.x)+" "+this._fix(e.y)};Gauge.prototype._updateAria=function(){var e=this.hostElement;if(e){setAttribute(e,"aria-valuemin",this.min);setAttribute(e,"aria-valuemax",this.max);setAttribute(e,"aria-valuenow",this.value)}};Gauge._SVGNS="http://www.w3.org/2000/svg";Gauge._ctr=0;Gauge.controlTemplate='<div wj-part="dsvg" dir="ltr"><svg wj-part="svg" width="100%" height="100%"><defs><filter wj-part="filter"><feOffset dx="3" dy="3"></feOffset><feGaussianBlur result="offset-blur" stdDeviation="5"></feGaussianBlur><feComposite operator="out" in="SourceGraphic" in2="offset-blur" result="inverse"></feComposite><feFlood flood-color="black" flood-opacity="0.2" result="color"></feFlood><feComposite operator="in" in="color" in2="inverse" result="shadow"></feComposite><feComposite operator="over" in="shadow" in2="SourceGraphic"></feComposite></filter></defs><g wj-part="gface" class="wj-face"><path wj-part="pface"/></g><g wj-part="granges" class="wj-ranges"/><g wj-part="gpointer" class="wj-pointer"><path wj-part="ppointer"/></g><g wj-part="gcover" class="wj-cover"><path wj-part="pticks" class="wj-ticks"/><g wj-part="gticks" aria-hidden="true" class="wj-tick-text"/><circle wj-part="cvalue" class="wj-pointer wj-thumb"/><g wj-part="gneedle" class="wj-needle"/><text wj-part="value" class="wj-value"/><text wj-part="min" class="wj-min" aria-hidden="true"/><text wj-part="max" class="wj-max" aria-hidden="true"/></g></svg></div>';return Gauge}(Control);export{Gauge};export var NeedleShape;!function(e){e[e.None=0]="None";e[e.Triangle=1]="Triangle";e[e.Diamond=2]="Diamond";e[e.Hexagon=3]="Hexagon";e[e.Rectangle=4]="Rectangle";e[e.Arrow=5]="Arrow";e[e.WideArrow=6]="WideArrow";e[e.Pointer=7]="Pointer";e[e.WidePointer=8]="WidePointer";e[e.Outer=9]="Outer"}(NeedleShape||(NeedleShape={}));export var NeedleLength;!function(e){e[e.Outer=0]="Outer";e[e.Middle=1]="Middle";e[e.Inner=2]="Inner"}(NeedleLength||(NeedleLength={}));var RadialGauge=function(e){__extends(RadialGauge,e);function RadialGauge(t,i){var n=e.call(this,t,null)||this;n._startAngle=0;n._sweepAngle=180;n._autoScale=!0;n._ndlShape=NeedleShape.None;n._ndlLength=NeedleLength.Middle;addClass(n.hostElement,"wj-radialgauge");n._thickness=.4;n.showText=ShowText.All;n.initialize(i);return n}Object.defineProperty(RadialGauge.prototype,"startAngle",{get:function(){return this._startAngle},set:function(e){if(e!=this._startAngle){this._startAngle=clamp(asNumber(e,!1),-360,360);this.invalidate()}},enumerable:!0,configurable:!0});Object.defineProperty(RadialGauge.prototype,"sweepAngle",{get:function(){return this._sweepAngle},set:function(e){if(e!=this._sweepAngle){this._sweepAngle=clamp(asNumber(e,!1),-360,360);this.invalidate()}},enumerable:!0,configurable:!0});Object.defineProperty(RadialGauge.prototype,"autoScale",{get:function(){return this._autoScale},set:function(e){if(e!=this._autoScale){this._autoScale=asBoolean(e);this.invalidate()}},enumerable:!0,configurable:!0});Object.defineProperty(RadialGauge.prototype,"faceBounds",{get:function(){return this._rcSvg?this._rcSvg.clone():null},enumerable:!0,configurable:!0});Object.defineProperty(RadialGauge.prototype,"clientSize",{get:function(){_deprecated("clientSize","faceBounds");var e=this._rcSvg;return e?new Size(e.width,e.height):null},enumerable:!0,configurable:!0});Object.defineProperty(RadialGauge.prototype,"needleElement",{get:function(){return this._ndlElement},set:function(e){if(e!=this._ndlElement){this._ndlShape=0;this._ndlElement=asType(e,SVGElement,!0);for(var t=this._gNeedle;t.firstChild;)removeChild(t.firstChild);if(this._ndlElement){setAttribute(t,"transform","scale(0)");t.appendChild(this._ndlElement)}this.invalidate()}},enumerable:!0,configurable:!0});Object.defineProperty(RadialGauge.prototype,"needleShape",{get:function(){return this._ndlShape},set:function(e){if(e!=this._ndlShape){var t=null;switch(e=asEnum(e,NeedleShape)){case NeedleShape.Triangle:t=RadialGauge.createNeedleElement([{x:-10,y:10},{x:100,y:0}]);break;case NeedleShape.Diamond:t=RadialGauge.createNeedleElement([{x:-20,y:0},{x:0,y:10},{x:100,y:0}]);break;case NeedleShape.Hexagon:t=RadialGauge.createNeedleElement([{x:-15,y:0},{x:-10,y:5},{x:10,y:5},{x:100,y:0}]);break;case NeedleShape.Rectangle:t=RadialGauge.createNeedleElement([{x:-20,y:3},{x:100,y:3}],10);break;case NeedleShape.Arrow:t=RadialGauge.createNeedleElement([{x:-20,y:3},{x:70,y:3},{x:70,y:15},{x:100,y:0}],10);break;case NeedleShape.WideArrow:t=RadialGauge.createNeedleElement([{x:-30,y:5},{x:-40,y:15},{x:-20,y:15},{x:-10,y:5},{x:80,y:5},{x:70,y:15},{x:100,y:0}]);break;case NeedleShape.Pointer:t=RadialGauge.createNeedleElement([{x:0,y:10},{x:100,y:0}],20,10);break;case NeedleShape.WidePointer:t=RadialGauge.createNeedleElement([{x:0,y:20},{x:100,y:0}],20,10);break;case NeedleShape.Outer:t=RadialGauge.createNeedleElement([{x:60,y:20},{x:100,y:0}])}this.needleElement=t;this._ndlShape=e;this.invalidate()}},enumerable:!0,configurable:!0});Object.defineProperty(RadialGauge.prototype,"needleLength",{get:function(){return this._ndlLength},set:function(e){if(e!=this._ndlLength){this._ndlLength=asEnum(e,NeedleLength);this.invalidate()}},enumerable:!0,configurable:!0});RadialGauge.createNeedleElement=function(e,t,i){for(var n="",a=0;a<e.length;a++){var r=e[a];if(a==e.length-1&&0==r.y)break;n+=(a>0?" L ":"M ")+r.x+" "+r.y}for(a=e.length-1;a>=0;a--){n+=" L "+(r=e[a]).x+" "+-r.y}n+=" Z";var s="http://www.w3.org/2000/svg",o=document.createElementNS(s,"g"),h=document.createElementNS(s,"path");setAttribute(h,"d",n);o.appendChild(h);if(t){var u=document.createElementNS(s,"circle");addClass(u,"wj-needle-cap");setAttribute(u,"r",t);o.appendChild(u);if(i){u=document.createElementNS(s,"circle");addClass(u,"wj-inner-needle-cap");setAttribute(u,"r",i);o.appendChild(u)}}return o};RadialGauge.prototype.refresh=function(t){void 0===t&&(t=!0);setAttribute(this._svg,"viewBox",null);this._rcSvg=Rect.fromBoundingRect(this._dSvg.getBoundingClientRect());e.prototype.refresh.call(this,t);this._ctmInv=null;this._ptSvg=null;if(this._autoScale){setAttribute(this._svg,"viewBox",null);var i=Rect.fromBoundingRect(Gauge._getBBox(this._pFace));0!=(this.showText&ShowText.Value)&&(i=Rect.union(i,Rect.fromBoundingRect(Gauge._getBBox(this._tValue))));if(0!=(this.showText&ShowText.MinMax)){i=Rect.union(i,Rect.fromBoundingRect(Gauge._getBBox(this._tMin)));i=Rect.union(i,Rect.fromBoundingRect(Gauge._getBBox(this._tMax)))}var n=[this._fix(i.left),this._fix(i.top),this._fix(i.width),this._fix(i.height)].join(" ");setAttribute(this._svg,"viewBox",n);var a=this._pFace.getCTM();this._ctmInv=a?a.inverse():null;this._ptSvg=this._svg.createSVGPoint()}};RadialGauge.prototype._updateRangeElement=function(e,t,i){if(this._rcSvg){var n=this._rcSvg,a=new Point(n.width/2,n.height/2),r=Math.min(n.width,n.height)/2,s=r*this.thickness,o=s*t.thickness,h=r-(s-o)/2,u=h-o,l=this._getStartAngle(),g=this._getSweepAngle(),c=t==this._face,p=c?0:this._getPercent(t.min),f=l+g*p,_=g*((c?1:this._getPercent(i))-p);if(this.stackRanges&&t!=this.face&&t!=this.pointer){var d=this.ranges.indexOf(t);if(d>-1){var m=this.ranges.length,y=(h-u)/m;h=(u+=(m-1-d)*y)+y}}this._updateSegment(e,a,h,u,f,_);if(t==this._pointer){var b=this._fix;if(this.thumbSize>0){var x=this._animColor?this._animColor:this._getPointerColor(t.max),v=this._getPoint(a,l+g*this._getPercent(i),(h+u)/2),w=this._cValue;setAttribute(w,"cx",b(v.x));setAttribute(w,"cy",b(v.y));setAttribute(w,"style",x?"fill:"+x:null);setAttribute(w,"r",b(this.thumbSize/2))}if(this.needleElement){var G=h;this._ndlLength==NeedleLength.Inner?G=u:this._ndlLength==NeedleLength.Middle&&(G=(u+h)/2);var R="translate({cx}, {cy}) scale({scale}) rotate({angle})".replace("{cx}",b(a.x)).replace("{cy}",b(a.y)).replace("{scale}",b(G/100)).replace("{angle}",b(f+_));this._gNeedle.setAttribute("transform",R)}}}};RadialGauge.prototype._getStartAngle=function(){var e=this.startAngle+180;this.rightToLeft&&(e=180-e);return e};RadialGauge.prototype._getSweepAngle=function(){var e=this.sweepAngle;this.rightToLeft&&(e=-e);return e};RadialGauge.prototype._updateText=function(){if(this._rcSvg){var e=this._rcSvg,t=new Point(e.width/2,e.height/2),i=Math.min(e.width,e.height)/2,n=Math.max(0,i*(1-this.thickness)),a=this._getStartAngle(),r=this._getSweepAngle();this._showElement(this._cValue,this.thumbSize>0);var s=0!=(this.showText&ShowText.MinMax)&&Math.abs(r)<=300;this._showElement(this._tMin,s);this._showElement(this._tMax,s);this._centerText(this._tValue,this.value,t);var o=10*(this._getSweepAngle()<0?-1:1);this._centerText(this._tMin,this.min,this._getPoint(t,a-o,(i+n)/2));this._centerText(this._tMax,this.max,this._getPoint(t,a+r+o,(i+n)/2))}};RadialGauge.prototype._updateTicks=function(){for(var e=this.tickSpacing&&this.tickSpacing>0?this.tickSpacing:this.step,t="",i=this._gTicks;i.firstChild;)removeChild(i.firstChild);if(this.showTicks&&e>0)for(var n=this._rcSvg,a=new Point(n.width/2,n.height/2),r=Math.min(n.width,n.height)/2,s=r*this.thickness,o=s*this._face.thickness,h=r-(s-o)/2,u=h-o,l=1.15*h,g=this._getStartAngle(),c=this._getSweepAngle(),p=this.min;p<=this.max;p+=e){var f=g+c*this._getPercent(p),_=this._fix(this._getPoint(a,f,u)),d=this._fix(this._getPoint(a,f,h));p>this.min&&p<this.max&&(t+="M "+_+" L "+d+" ");if(this.showTickText){var m=this._createElement("text",i),y=this._getPoint(a,f,l);this._centerText(m,p,y)}}this._pTicks.setAttribute("d",t)};RadialGauge.prototype._updateSegment=function(e,t,i,n,a,r){r=Math.min(Math.max(r,-359.99),359.99);var s=this._getPoint(t,a,n),o=this._getPoint(t,a,i),h=this._getPoint(t,a+r,i),u=this._getPoint(t,a+r,n),l={large:Math.abs(r)>180?1:0,cw:r>0?1:0,ccw:r>0?0:1,or:this._fix(i),ir:this._fix(n),p1:this._fix(s),p2:this._fix(o),p3:this._fix(h),p4:this._fix(u)},g=format("M {p1} L {p2} A {or} {or} 0 {large} {cw} {p3} L {p4} A {ir} {ir} 0 {large} {ccw} {p1} Z",l);e.setAttribute("d",g)};RadialGauge.prototype._getPoint=function(e,t,i){t=t*Math.PI/180;return new Point(e.x+i*Math.cos(t),e.y+i*Math.sin(t))};RadialGauge.prototype._getValueFromPoint=function(e){if(this.autoScale&&this._ctmInv){this._ptSvg.x=e.x;this._ptSvg.y=e.y;this._ptSvg=this._ptSvg.matrixTransform(this._ctmInv);e.x=this._ptSvg.x;e.y=this._ptSvg.y}if(!this._rcSvg||!this.sweepAngle)return null;var t=this._rcSvg,i=new Point(t.width/2,t.height/2),n=Math.min(t.width,t.height)/2,a=e.x-i.x,r=e.y-i.y,s=r*r+a*a;if(s<100||s>(n+10)*(n+10))return null;var o=180*(Math.PI-Math.atan2(-r,a))/Math.PI,h=this.startAngle,u=this.sweepAngle,l=h+u;this.rightToLeft&&(o=180-o);if(u>0){for(;o<h;)o+=360;for(;o>l;)o-=360}else{for(;o<l;)o+=360;for(;o>h;)o-=360}if((o-h)*(o-l)>0){var g=this._getPoint(i,o,n),c=this._getPoint(i,h,n),p=this._getPoint(i,l,n);o=this._getDist2(g,c)<this._getDist2(g,p)?h:l}var f=u?clamp(Math.abs(o-h)/Math.abs(u),0,1):0;return this.min+f*(this.max-this.min)};RadialGauge.prototype._getDist2=function(e,t){var i=e.x-t.x,n=e.y-t.y;return i*i+n*n};return RadialGauge}(Gauge);export{RadialGauge};export var GaugeDirection;!function(e){e[e.Right=0]="Right";e[e.Left=1]="Left";e[e.Up=2]="Up";e[e.Down=3]="Down"}(GaugeDirection||(GaugeDirection={}));var LinearGauge=function(e){__extends(LinearGauge,e);function LinearGauge(t,i){var n=e.call(this,t,null)||this;n._direction=GaugeDirection.Right;addClass(n.hostElement,"wj-lineargauge");n.initialize(i);return n}Object.defineProperty(LinearGauge.prototype,"direction",{get:function(){return this._direction},set:function(e){if((e=asEnum(e,GaugeDirection))!=this._direction){this._direction=e;this.invalidate()}},enumerable:!0,configurable:!0});Object.defineProperty(LinearGauge.prototype,"faceBounds",{get:function(){return this._getRangeRect(this._face)},enumerable:!0,configurable:!0});LinearGauge.prototype._updateRangeElement=function(e,t,i){var n=this._getRangeRect(t,i);this._updateSegment(e,n);var a=t==this._pointer&&0!=(this.showText&ShowText.Value),r=a||t==this._pointer&&this.thumbSize>0,s=n.left+n.width/2,o=n.top+n.height/2;switch(this._getDirection()){case GaugeDirection.Right:s=n.right;break;case GaugeDirection.Left:s=n.left;break;case GaugeDirection.Up:o=n.top;break;case GaugeDirection.Down:o=n.bottom}a&&this._centerText(this._tValue,i,new Point(s,o));if(a||r){n=Rect.fromBoundingRect(Gauge._getBBox(this._tValue));var h=this._animColor?this._animColor:this._getPointerColor(t.max),u=null!=this.thumbSize?this.thumbSize/2:.8*Math.max(n.width,n.height),l=this._cValue;setAttribute(l,"cx",this._fix(s));setAttribute(l,"cy",this._fix(o));setAttribute(l,"style",h?"fill:"+h:null);setAttribute(l,"r",this._fix(u))}};LinearGauge.prototype._updateText=function(){var e=this._getRangeRect(this._face);switch(this._getDirection()){case GaugeDirection.Right:this._setText(this._tMin,this.min,e,"left");this._setText(this._tMax,this.max,e,"right");break;case GaugeDirection.Left:this._setText(this._tMin,this.min,e,"right");this._setText(this._tMax,this.max,e,"left");break;case GaugeDirection.Up:this._setText(this._tMin,this.min,e,"bottom");this._setText(this._tMax,this.max,e,"top");break;case GaugeDirection.Down:this._setText(this._tMin,this.min,e,"top");this._setText(this._tMax,this.max,e,"bottom")}};LinearGauge.prototype._updateTicks=function(){for(var e=this.tickSpacing&&this.tickSpacing>0?this.tickSpacing:this.step,t="",i=this._gTicks;i.firstChild;)removeChild(i.firstChild);if(this.showTicks&&e>0)for(var n=this._getRangeRect(this._face),a=new Point(n.left-.75*n.width,n.top-.75*n.height),r=void 0,s=this._fix,o=this.min;o<=this.max;o+=e){var h=null;switch(this._getDirection()){case GaugeDirection.Right:a.x=n.left+n.width*this._getPercent(o);h="M "+(r=s(a.x))+" "+s(n.top)+" L "+r+" "+s(n.bottom)+" ";break;case GaugeDirection.Left:a.x=n.right-n.width*this._getPercent(o);h="M "+(r=s(a.x))+" "+s(n.top)+" L "+r+" "+s(n.bottom)+" ";break;case GaugeDirection.Up:a.y=n.bottom-n.height*this._getPercent(o);r=s(a.y);h="M "+s(n.left)+" "+r+" L "+s(n.right)+" "+r+" ";break;case GaugeDirection.Down:a.y=n.top+n.height*this._getPercent(o);r=s(a.y);h="M "+s(n.left)+" "+r+" L "+s(n.right)+" "+r+" "}o>this.min&&o<this.max&&(t+=h);if(this.showTickText){var u=this._createElement("text",i);this._centerText(u,o,a)}}this._pTicks.setAttribute("d",t)};LinearGauge.prototype._updateSegment=function(e,t){var i={p1:this._fix(new Point(t.left,t.top)),p2:this._fix(new Point(t.right,t.top)),p3:this._fix(new Point(t.right,t.bottom)),p4:this._fix(new Point(t.left,t.bottom))},n=format("M {p1} L {p2} L {p3} L {p4} Z",i);e.setAttribute("d",n)};LinearGauge.prototype._setText=function(e,t,i,n){if("none"!=e.getAttribute("display")){var a=Globalize.format(t,this.format);if(isFunction(this.getText)){var r=e==this._tValue?"value":e==this._tMin?"min":e==this._tMax?"max":null;assert(null!=r,"unknown element");a=this.getText(this,r,t,a)}e.textContent=a;var s=Rect.fromBoundingRect(Gauge._getBBox(e)),o=new Point(i.left+i.width/2-s.width/2,i.top+i.height/2+s.height/2);switch(n){case"top":o.y=i.top-4;break;case"left":o.x=i.left-4-s.width;break;case"right":o.x=i.right+4;break;case"bottom":o.y=i.bottom+4+s.height}e.setAttribute("x",this._fix(o.x));e.setAttribute("y",this._fix(o.y))}};LinearGauge.prototype._getRangeRect=function(e,t){void 0===t&&(t=e.max);var i=this.hostElement,n=new Rect(0,0,i.clientWidth,i.clientHeight),a=this._getDirection(),r=this.thumbSize?Math.ceil(this.thumbSize/2):0;if(this.showText!=ShowText.None){var s=parseInt(getComputedStyle(i).fontSize);isNaN(s)||(r=Math.max(r,3*s))}switch(a){case GaugeDirection.Right:case GaugeDirection.Left:n=n.inflate(-r,-n.height*(1-this.thickness*e.thickness)/2);break;case GaugeDirection.Up:case GaugeDirection.Down:n=n.inflate(-n.width*(1-this.thickness*e.thickness)/2,-r)}if(this.stackRanges&&e!=this.face&&e!=this.pointer){var o=this.ranges.indexOf(e);if(o>-1){var h=this.ranges.length;switch(a){case GaugeDirection.Right:case GaugeDirection.Left:n.height/=h;n.top+=o*n.height;break;case GaugeDirection.Up:case GaugeDirection.Down:n.width/=h;n.left+=o*n.width}}}var u=e==this._face,l=u?0:this._getPercent(e.min),g=u?1:this._getPercent(t);switch(a){case GaugeDirection.Right:n.left+=n.width*l;n.width*=g-l;break;case GaugeDirection.Left:n.left=n.right-n.width*g;n.width=n.width*(g-l);break;case GaugeDirection.Down:n.top+=n.height*l;n.height*=g-l;break;case GaugeDirection.Up:n.top=n.bottom-n.height*g;n.height=n.height*(g-l)}return n};LinearGauge.prototype._getValueFromPoint=function(e){var t=this._getRangeRect(this._face),i=0;switch(this._getDirection()){case GaugeDirection.Right:i=t.width>0?(e.x-t.left)/t.width:0;break;case GaugeDirection.Left:i=t.width>0?(t.right-e.x)/t.width:0;break;case GaugeDirection.Up:i=t.height>0?(t.bottom-e.y)/t.height:0;break;case GaugeDirection.Down:i=t.height>0?(e.y-t.top)/t.height:0}return this.min+i*(this.max-this.min)};LinearGauge.prototype._getDirection=function(){var e=this._direction;if(this.rightToLeft)switch(e){case GaugeDirection.Left:e=GaugeDirection.Right;break;case GaugeDirection.Right:e=GaugeDirection.Left}return e};LinearGauge.prototype._getKey=function(e){switch(this._getDirection()){case GaugeDirection.Left:switch(e){case Key.Left:e=Key.Right;break;case Key.Right:e=Key.Left}break;case GaugeDirection.Down:switch(e){case Key.Up:e=Key.Down;break;case Key.Down:e=Key.Up}}return e};return LinearGauge}(Gauge);export{LinearGauge};var BulletGraph=function(e){__extends(BulletGraph,e);function BulletGraph(t,i){var n=e.call(this,t,null)||this;addClass(n.hostElement,"wj-bulletgraph");n._pointer.thickness=.35;n._rngTarget=new Range("target");n._rngTarget.thickness=.8;n._rngTarget.color="black";n._rngGood=new Range("good");n._rngGood.color="rgba(0,0,0,.15)";n._rngBad=new Range("bad");n._rngBad.color="rgba(0,0,0,.3)";n.ranges.push(n._rngBad);n.ranges.push(n._rngGood);n.ranges.push(n._rngTarget);n.initialize(i);return n}Object.defineProperty(BulletGraph.prototype,"target",{get:function(){return this._rngTarget.max},set:function(e){this._rngTarget.max=e},enumerable:!0,configurable:!0});Object.defineProperty(BulletGraph.prototype,"good",{get:function(){return this._rngGood.max},set:function(e){this._rngGood.max=e},enumerable:!0,configurable:!0});Object.defineProperty(BulletGraph.prototype,"bad",{get:function(){return this._rngBad.max},set:function(e){this._rngBad.max=e},enumerable:!0,configurable:!0});BulletGraph.prototype._getRangeRect=function(t,i){void 0===i&&(i=t.max);var n=e.prototype._getRangeRect.call(this,t,i);if(t==this._rngTarget)switch(this._getDirection()){case GaugeDirection.Right:n.left=n.right-1;n.width=3;break;case GaugeDirection.Left:n.width=3;break;case GaugeDirection.Up:n.height=3;break;case GaugeDirection.Down:n.top=n.bottom-1;n.height=3}return n};return BulletGraph}(LinearGauge);export{BulletGraph};_registerModule("wijmo.gauge",selfModule);