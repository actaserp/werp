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

import{isIE,Point,addClass,createElement,ObservableArray,format,Rect,isFunction,copy,asArray,Size,clamp,isString,Binding,asString,Color,isNumber,Globalize,httpRequest,Event,EventArgs,asFunction,asNumber,_registerModule}from"wijmo/wijmo";import{SvgRenderEngine,ChartElement,ChartTooltip,FlexChartBase,Legend,RenderEventArgs,Position,_DataInfo,Palettes}from"wijmo/wijmo.chart";import*as selfModule from"wijmo/wijmo.chart.map";export class MapHitTestInfo{get point(){return this._pt}get item(){return this._item}get geoPoint(){return this._map?this._map.convertBack(this.point):null}get chartElement(){return this._chartElement}get map(){return this._map}}export class _DrawOptions{}export class _SvgMapRenderEngine extends SvgRenderEngine{constructor(t){super(t);this.scale=1;this.element.setAttribute("xmlns:wj-map","http://www.grapecity.com/wijmo")}drawPolygon2(t,e){let i=t?t.className:null,s=t?t.clipPath:null,r=t?t.style:null,n=this.precision;if(e&&e.length>0){let t=document.createElementNS("http://www.w3.org/2000/svg","path");this._applyColor(t,"stroke",this.stroke);let h=this.strokeWidth;if(null!==h){isIE()&&(h*=this.scale);this._setAttribute(t,"stroke-width",h.toString())}this._applyColor(t,"fill",this.fill);let o="";for(let t=0;t<e.length;t++){let i=e[t],s=i.length/2;if(s>1){o+=" M "+i[0].toFixed(n)+" "+i[1].toFixed(n);for(let t=1;t<s;t++)o+=" L "+i[2*t].toFixed(n)+" "+i[2*t+1].toFixed(n);o+=" Z"}}this._setAttribute(t,"d",o);i&&t.setAttribute("class",i);s&&this._setClipPath(t,s);this._applyStyle(t,r);this._appendChild(t);t.setAttribute("vector-effect","non-scaling-stroke");return t}return null}}export class _Range{constructor(t,e){this.min=t;this.max=e}get range(){return this.max-this.min}norm(t){return(t-this.min)/this.range}}export class _Utils{static getRange(t,e){if(t&&e){let i=t.length,s=NaN,r=NaN;for(let n=0;n<i;n++){let i=t[n];if(i){let t;t=isFunction(e)?e(i):e.getValue(i);isString(t)&&(t=parseFloat(t));if(isFinite(t)){(isNaN(s)||t<s)&&(s=t);(isNaN(r)||t>r)&&(r=t)}}}if(!isNaN(s)&&!isNaN(r))return new _Range(s,r)}return null}}export class ColorScale{constructor(t){this._clrs=[];this._clrUnknown="transparent";this.colors=Palettes.SequentialSingle.Greys;this.initialize(t)}initialize(t){copy(this,t)}convert(t,e=!0){if(!isFinite(t)||0==this._clrs.length)return this.colorUnknown;this._range&&e&&(t=this._range.norm(t));this.scale&&(t=this.scale(t));return 2==this._clrs.length?this._interpolate(this._clrs[0],this._clrs[1],t):this._clrSpline.interpolate(t).toString()}get scale(){return this._scale}set scale(t){this._scale!=t&&(this._scale=t)}get binding(){return this._binding}set binding(t){this._binding!=t&&(this._binding=t)}get colorUnknown(){return this._clrUnknown}set colorUnknown(t){this._clrUnknown!=t&&(this._clrUnknown=asString(t))}get colors(){return this._colors}set colors(t){if(this._colors!=t){this._clrs=[];let e=this._colors=t;if(e){for(let t=0;t<e.length;t++)this._clrs.push(new Color(e[t]));this._clrSpline=new _ColorSpline(this._clrs)}}}get format(){return this._fmt}set format(t){this._fmt!=t&&(this._fmt=asString(t,!0))}domain(t){isFunction(this.binding)?this._range=_Utils.getRange(t,this.binding):this._range=_Utils.getRange(t,new Binding(this.binding))}getValue(t){let e;return e=isFunction(this.binding)?this.binding(t):new Binding(this.binding).getValue(t)}_interpolate(t,e,i){let s=1-(i=clamp(i,0,1));return Color.fromRgba(t.r*s+e.r*i,t.g*s+e.g*i,t.b*s+e.b*i,t.a*s+e.a*i).toString()}_drawLegend(t,e,i){_ColorScaleLegend.draw(t,this,e,i)}_measureLegend(t,e,i,s){return _ColorScaleLegend.measure(t,this,e,i,s)}}class _ColorScaleLegend{static measure(t,e,i,s,r){let n=i?new Size(this.itemSize,r-120):new Size(s-80,this.itemSize),h=this._getValues(e),o=h.length;if(h.length){let s=new Size;for(let i=0;i<o;i++){let r=this._getLabel(e,h[i]),n=t.measureString(r);s.width=Math.max(s.width,n.width);s.height=Math.max(s.height,n.height)}s.width&&s.height&&(i?n.width+=s.width+this.marginText:n.height+=s.height+this.marginText)}return n}static draw(t,e,i,s){t.stroke="transparent";let r=this._getValues(e);if(s){let s=(i=i.inflate(0,-10)).height/100;for(let r=0;r<100;r++){t.fill=e.convert((r+.5)/100,!1);t.drawRect(i.left,i.top+r*s,this.itemSize,s+1)}if(r.length){t.stroke="black";for(let s=0;s<r.length;s++){let n=r[s],h=e._range.norm(n),o=i.top+h*i.height,l=this._getLabel(e,n),a=t.measureString(l);t.drawString(l,new Point(i.left+this.itemSize+this.marginText,o+.5*a.height));t.drawLine(i.left,o,i.left+this.itemSize,o)}}}else{let s=(i=i.inflate(-20,0)).width/100,n=0;if(r.length)for(let s=0;s<r.length;s++){let h=r[s],o=e._range.norm(h);e.scale&&(o=e.scale(o));let l=i.left+o*i.width,a=this._getLabel(e,h),c=t.measureString(a);n=Math.max(n,c.height);t.drawString(this._getLabel(e,h),new Point(l-.5*c.width,i.top+c.height))}n&&(n+=this.marginText);for(let r=0;r<100;r++){t.fill=e.convert((r+.5)/100,!1);t.drawRect(i.left+r*s,i.top+n,s+1,this.itemSize)}if(r.length){t.stroke="black";for(let s=0;s<r.length;s++){let n=r[s],h=e._range.norm(n);e.scale&&(h=e.scale(h));let o=i.left+h*i.width;t.drawLine(o,i.bottom-this.itemSize,o,i.bottom)}}}}static _getValues(t){let e=[],i=t._range;if(i){let t=this._calcDelta(i.range);for(let s=Math.round(i.min/t)*t;s<=i.max;s+=t)s<i.min||e.push(s)}return e}static _getLabel(t,e){return t.format?Globalize.formatNumber(e,t.format):e.toString()}static _calcDelta(t){var e=this._nicePrecision(t),i=t/10;let s=this._niceNumber(2*i,-e,!0);s<i&&(s=this._niceNumber(i,1-e,!1));s<i&&(s=this._niceTickNumber(i));return s}static _nicePrecision(t){if(!isNumber(t)||t<=0)return 0;var e,i=Math.log(t)/Math.LN10;e=i>=0?Math.floor(i):Math.ceil(i);var s=t/Math.pow(10,e);if(s<3){e=1-e;(s=t/Math.pow(10,e))<3&&(e+=1)}return e}static _niceTickNumber(t){if(0==t)return t;t<0&&(t=-t);var e=Math.log(t)/Math.LN10,i=Math.floor(e),s=t/Math.pow(10,i),r=10;s<=1?r=1:s<=2?r=2:s<=5&&(r=5);return r*Math.pow(10,i)}static _niceNumber(t,e,i){if(0==t)return t;t<0&&(t=-t);var s=t/Math.pow(10,e),r=10;i?s<1.5?r=1:s<3?r=2:s<4.5?r=4:s<7&&(r=5):s<=1?r=1:s<=2?r=2:s<=5&&(r=5);return r*Math.pow(10,e)}}_ColorScaleLegend.itemSize=20;_ColorScaleLegend.marginText=4;class _ColorSpline{constructor(t){this._clrs=t;let e=t.length,i=[],s=[],r=[],n=[];for(var h=0;h<e;h++){let o=t[h],l=h/(e-1);i.push(l);s.push(o.r);r.push(o.g);n.push(o.b)}this._rsp=new _Spline(i,s);this._gsp=new _Spline(i,r);this._bsp=new _Spline(i,n)}interpolate(t){t=clamp(t,0,1);let e=this._rsp.calculate(t),i=this._gsp.calculate(t),s=this._bsp.calculate(t);return Color.fromRgba(e,i,s)}}class _Spline{constructor(t,e,i){this.k=.002;this._a=[];this._b=[];this._c=[];this._d=[];this.m=[[-.5,1.5,-1.5,.5],[1,-2.5,2,-.5],[-.5,0,.5,0],[0,1,0,0]];this._x=t;this._y=e;var s=this._len=i||Math.min(t.length,e.length);if(s>3)for(var r=0;r<s-1;r++){var n=0==r?new Point(t[r],e[r]):new Point(t[r-1],e[r-1]),h=new Point(t[r],e[r]),o=new Point(t[r+1],e[r+1]),l=r==s-2?new Point(t[r+1],e[r+1]):new Point(t[r+2],e[r+2]),a=new Point,c=new Point,u=new Point,_=new Point;a.x=n.x*this.m[0][0]+h.x*this.m[0][1]+o.x*this.m[0][2]+l.x*this.m[0][3];c.x=n.x*this.m[1][0]+h.x*this.m[1][1]+o.x*this.m[1][2]+l.x*this.m[1][3];u.x=n.x*this.m[2][0]+h.x*this.m[2][1]+o.x*this.m[2][2]+l.x*this.m[2][3];_.x=n.x*this.m[3][0]+h.x*this.m[3][1]+o.x*this.m[3][2]+l.x*this.m[3][3];a.y=n.y*this.m[0][0]+h.y*this.m[0][1]+o.y*this.m[0][2]+l.y*this.m[0][3];c.y=n.y*this.m[1][0]+h.y*this.m[1][1]+o.y*this.m[1][2]+l.y*this.m[1][3];u.y=n.y*this.m[2][0]+h.y*this.m[2][1]+o.y*this.m[2][2]+l.y*this.m[2][3];_.y=n.y*this.m[3][0]+h.y*this.m[3][1]+o.y*this.m[3][2]+l.y*this.m[3][3];this._a.push(a);this._b.push(c);this._c.push(u);this._d.push(_)}}calculate(t){t*=this._len-1;var e=Math.floor(t);e<0&&(e=0);e>this._len-2&&(e=this._len-2);var i=t-e;this._a[e].x,this._b[e].x,this._c[e].x,this._d[e].x;return((this._a[e].y*i+this._b[e].y)*i+this._c[e].y)*i+this._d[e].y}}export class FlexMap extends FlexChartBase{constructor(t,e){super(t,null,!0);this._layers=new ObservableArray;this._center=new Point;this._zoom=1;this._zoomStep=.5;this._offset=new Point;this._proj=new MercatorProjection;this._touchStartH=this._touchStart.bind(this);this._touchMoveH=this._touchMove.bind(this);this._touchEndH=this._touchEnd.bind(this);this._touchCancelH=this._touchCancel.bind(this);this._mouseWheelH=this._mouseWheel.bind(this);this._handleTouch=!1;const i=this.hostElement;this.applyTemplate("wj-control wj-flexchart wj-flexmap",null,null);this._currentRenderEngine=new _SvgMapRenderEngine(i);let s=createElement("<div></div>",null,{position:"relative"});this._overlay=createElement("<div></div>",s,{position:"absolute",left:"90%",bottom:"90%"});createElement('<button class="wj-btn"><span class="wj-glyph-plus"></span></button>',this._overlay).addEventListener("click",()=>this.zoom+=this._zoomStep);createElement('<button class="wj-btn"><span class="wj-glyph-minus"></span></button>',this._overlay).addEventListener("click",()=>this.zoom-=this._zoomStep);addClass(i,"wj-flexchart-touch-disabled");i.appendChild(s);this._legend=new Legend(this);this._legend.position=Position.None;this._tooltip=new ChartTooltip;this.tooltip.content=null;const r=this;this.layers.collectionChanged.addHandler(()=>{this.layers.forEach(t=>t.map=r);this.invalidate()});this.addEventListener(i,"click",(function(t){if(r.isDisabled)return;let e=r._tooltip;e.content&&r.isTouching&&r._updateTooltip(e,t)}));this.addEventListener(i,"mousedown",t=>{if(!r.isDisabled&&0==t.button){this.focus();this._dragStart=new Point(t.pageX,t.pageY);this._hideToolTip()}});this.addEventListener(i,"mousemove",t=>{if(!r.isDisabled)if(r._dragStart){let e=this.convertBack(this._toControl(r._dragStart)),i=this.convertBack(this._toControl(t));this.center=new Point(this.center.x-i.x+e.x,this.center.y-i.y+e.y);this._dragStart=new Point(t.pageX,t.pageY)}else{let e=r._tooltip;e.content&&!r.isTouching&&r._updateTooltip(e,t)}});this.addEventListener(i,"mouseup",t=>{this._dragStart=null});this.addEventListener(i,"mouseleave",t=>{if(t.target==r.hostElement){this._dragStart=null;r._hideToolTip()}});this.addEventListener(i,"touchstart",this._touchStartH);this.addEventListener(i,"touchmove",this._touchMoveH);this.addEventListener(i,"touchcancel",this._touchCancelH);this.addEventListener(i,"touchend",this._touchEndH);this.addEventListener(i,"wheel",this._mouseWheelH);this.initialize(e);this.refresh()}get layers(){return this._layers}get center(){return this._center}set center(t){if(this._center!=t){this._center=t;this.invalidate()}}get zoom(){return this._zoom}set zoom(t){t<1&&(t=1);if(this._zoom!=t){this._zoom=t;this.invalidate()}}get tooltip(){return this._tooltip}convert(t){return this._convertMercator(t)}convertBack(t){return this._convertMercatorBack(t)}hitTest(t,e){var i=this._toControl(t,e),s=new MapHitTestInfo;if(FlexChartBase._contains(this._rectHeader,i))s._chartElement=ChartElement.Header;else if(FlexChartBase._contains(this._rectFooter,i))s._chartElement=ChartElement.Footer;else if(FlexChartBase._contains(this._rectLegend,i))s._chartElement=ChartElement.Legend;else if(FlexChartBase._contains(this._rectChart,i)){let e;if(t instanceof MouseEvent)e=document.elementFromPoint(t.x,t.y);else{let t=this._getHostOffset();e=document.elementFromPoint(t.x+i.x,t.y+i.y)}let r=e.getAttribute("wj-map:id");null!=r&&(s._item=this._getItemById(r))}return s}zoomTo(t){let e=this._proj.maxY,i=Math.max(t.top,-e),s=Math.min(t.bottom,e),r=this.convert(new Point(t.left,i)),n=this.convert(new Point(t.right,s));if(!_DataInfo.isValid(r.x,r.y,n.x,n.y))return;let h=new Point(.5*(r.x+n.x),.5*(r.y+n.y));this.center=this.convertBack(h);r=this.convert(new Point(t.left,i));n=this.convert(new Point(t.right,s));let o=this._mapRect.width/Math.abs(n.x-r.x),l=this._mapRect.height/Math.abs(n.y-r.y);this.zoom*=this.zoom+Math.log(Math.min(o,l))*Math.LOG2E}invalidate(t){t&&this.layers.forEach(t=>{t._clearCache&&t._clearCache()});super.invalidate(t)}_renderChart(t,e,i){this.onRendering(new RenderEventArgs(t));let s=e.width,r=e.height;var n=this._parseMargin(this.plotMargin);isNaN(n.left)&&(n.left=8);isNaN(n.right)&&(n.right=8);isNaN(n.top)&&(n.top=8);isNaN(n.bottom)&&(n.bottom=8);e.top+=n.top;r=e.height-(n.top+n.bottom);e.height=r>0?r:24;e.left+=n.left;s=e.width-(n.left+n.right);e.width=s>0?s:24;let h="mapRect"+(1e6*Math.random()).toFixed();t.addClipRect(e,h);let o=t.startGroup(null,h,!0);this._mapRect=e.clone();let l=this._size=.5*Math.min(e.width,e.height);this._offset.x=this._mapRect.left;this._offset.y=this._mapRect.top;e.width>2*l?this._offset.x=.5*e.width-l+this._mapRect.left:e.height>2*this._size&&(this._offset.y=.5*e.height-l+this._mapRect.top);let a=Math.pow(2,this.zoom),c=this._proj.convert(this.center);c.x=c.x*a*l-l;c.y=c.y*a*l-l;this._offset.x-=c.x;this._offset.y-=c.y;t.precision=6;for(let e=0;e<this.layers.length;e++){let i=1/(a*l);t.scale=i;let s=t.element.createSVGTransform(),r=t.element.createSVGMatrix();r.a=r.d=a*l;r.b=r.c=0;r.e=this._offset.x;r.f=this._offset.y;s.setMatrix(r);this.layers[e].render(t,s,o)}t.endGroup();let u=this._rectChart.bottom-this._mapRect.bottom;this._overlay.style.left=(this._mapRect.right-80).toString()+"px";this._overlay.style.bottom=u.toString()+"px";this.onRendered(new RenderEventArgs(t))}_getDesiredLegendSize(t,e,i,s){let r=new Size;for(let n=0;n<this.layers.length;n++){let h=this.layers[n];if(h.colorScale){h.getAllFeatures?h.colorScale.domain(h.getAllFeatures()):h.colorScale.domain(h.itemsSource);let n=h.colorScale._measureLegend(t,e,i,s);n&&n.width&&n.height&&(r=n)}}return r}_renderLegend(t,e,i,s,r,n){let h=new Rect(e.x,e.y,r,n);this.layers.forEach(e=>{e.colorScale&&e.colorScale._drawLegend(t,h,s)})}_copy(t,e){if("layers"==t){this.layers.clear();for(var i=asArray(e),s=0;s<i.length;s++)this.layers.push(i[s]);return!0}return!1}_updateTooltip(t,e){let i=t.content;if(i){let t=document.elementFromPoint(e.x,e.y),s=t?t.getAttribute("wj-map:id"):null;if(null!=s){let t=this._getItemById(s);if(t){isFunction(i)&&(i=i(t));i=format(i,t)}}else i=null}i&&i.trim().length>0?this._showToolTip(i,new Rect(e.clientX,e.clientY,5,5)):this._hideToolTip()}_getItemById(t){for(let e=0;e<this.layers.length;e++){let i=this.layers[e];if(i._getFeatureById){let e=i._getFeatureById(t);if(e)return e.properties}else if(i.getItemById){let e=i.getItemById(t);if(e)return e}}return null}_convertMercator(t){let e=Math.pow(2,this.zoom)*this._size,i=this._proj.convert(t);i.x*=e;i.y*=e;i.x+=this._offset.x;i.y+=this._offset.y;return i}_convertMercatorBack(t){let e=Math.pow(2,this.zoom)*this._size,i=this._proj,s=t.clone();s.x-=this._offset.x;s.y-=this._offset.y;s.x/=e;s.y/=e;return s=i.convertBack(s)}_touchStart(t){if(!this.isDisabled){switch(t.touches.length){case 1:this._handleTouch=!0;this._dragStart=new Point(t.touches[0].pageX,t.touches[0].pageY);break;case 2:this._dragStart=null;this._handleTouch=!0;this._touch1=new Point(t.touches[0].pageX,t.touches[0].pageY);this._touch2=new Point(t.touches[1].pageX,t.touches[1].pageY)}this._handleTouch&&this._hideToolTip()}}_touchMove(t){if(!this.isDisabled){this._handleTouch&&t.preventDefault();if(this._dragStart){let e=this.convertBack(this._toControl(this._dragStart)),i=this.convertBack(this._toControl(t.touches[0].pageX,t.touches[0].pageY));this.center=new Point(this.center.x-i.x+e.x,this.center.y-i.y+e.y);this._dragStart=new Point(t.touches[0].pageX,t.touches[0].pageY)}else if(this._touch1&&this._touch2){let e=new Point(t.touches[0].pageX,t.touches[0].pageY),i=new Point(t.touches[1].pageX,t.touches[1].pageY),s=this._dist(this._touch1,this._touch2),r=this._dist(e,i);if(Math.abs(r-s)>1){this.zoom+=Math.log2(r/s);this._touch1=e;this._touch2=i}}}}_dist(t,e){const i=t.x-e.x,s=t.y-e.y;return Math.sqrt(i*i+s*s)}_touchEnd(t){this._handleTouch=!1;this._dragStart=this._touch1=this._touch2=null}_touchCancel(t){this._handleTouch=!1;this._dragStart=this._touch1=this._touch2=null}_mouseWheel(t){if(this.isDisabled)return;t.preventDefault();this._hideToolTip();let e=-t.deltaY;e=e>0?.1:-.1;this.zoom+=e}}class MercatorProjection{constructor(){this.maxY=(2*Math.atan(Math.exp(Math.PI))-.5*Math.PI)/M.toRadians}convert(t){let e=this._convertX(t.x),i=Math.abs(t.y)>this.maxY?(t.y>0?1:-1)*this.maxY:t.y;i=this._convertY(i);return new Point(e,i)}convertBack(t){let e=this._convertBackX(t.x),i=this._convertBackY(t.y);return new Point(e,i)}_convertX(t){return(t*M.toRadians+Math.PI)/M.pi2}_convertBackX(t){return(t*M.pi2-Math.PI)/M.toRadians}_convertY(t){return(Math.PI+Math.log(Math.tan(M.pi4-.5*t*M.toRadians)))/M.pi2}_convertBackY(t){return-(2*Math.atan(Math.exp(t*M.pi2-Math.PI))-.5*Math.PI)/M.toRadians}}class M{}M.toRadians=Math.PI/180;M.pi4=.25*Math.PI;M.pi2=2*Math.PI;export class MapLayerBase{constructor(){this.itemsSourceChanged=new Event}get map(){return this._map}set map(t){this._map=t}get style(){return this._style}set style(t){if(this._style!=t){this._style=t;this.invalidate()}}get itemsSource(){return this._items}set itemsSource(t){this._setItems(t)}onItemsSourceChanged(t){this.itemsSourceChanged.raise(this,t)}get url(){return this._url}set url(t){if(this._url!=t){this._url=asString(t,!0);this._loadUrl()}}get colorScale(){return this._colorScale}set colorScale(t){if(this._colorScale!=t){this._colorScale=t;this._clearCache();this.invalidate()}}render(t,e,i){}invalidate(){this.map&&this.map.invalidate()}initialize(t){copy(this,t)}_applyStyle(t){if(this.style){t.fill=this.style.fill;t.stroke=this.style.stroke;t.strokeWidth=this.style.strokeWidth}}_clearCache(){}_loadUrl(){this.url?httpRequest(this.url,{success:t=>this.itemsSource=JSON.parse(t.responseText)}):this.itemsSource=null}_setItems(t){if(this._items!=t){this._clearCache();this._items=t;this.onItemsSourceChanged(new EventArgs);this.invalidate()}}}export class ScatterMapLayer extends MapLayerBase{constructor(t){super();this._symbolSize=5;this._symbolMinSize=5;this._symbolMaxSize=50;this._index=0;this._prefix="_";this._elMap={};this._hasBindings=!1;this.style={stroke:"grey",strokeWidth:.5,fill:"transparent"};this.initialize(t)}get symbolSize(){return this._symbolSize}set symbolSize(t){if(this._symbolSize!=t){this._symbolSize=asNumber(t);this.invalidate()}}get symbolMinSize(){return this._symbolMinSize}set symbolMinSize(t){if(this._symbolMinSize!=t){this._symbolMinSize=asNumber(t);this.invalidate()}}get symbolMaxSize(){return this._symbolMaxSize}set symbolMaxSize(t){if(this._symbolMaxSize!=t){this._symbolMaxSize=asNumber(t);this.invalidate()}}get itemsSource(){return this._items}set itemsSource(t){this._setItems(t)}get binding(){return this._binding}set binding(t){if(this._binding!=t){this._binding=asString(t,!0);this.parseBindings();this.invalidate()}}render(t,e,i){this._elMap={};this._index=0;this._prefix=this.map.layers.indexOf(this).toString()+"_";let s=t.startGroup();this.map,this.map._mapRect;this._applyStyle(t);let r=this.itemsSource,n=r?r.length:0,h=this._xBnd,o=this._yBnd,l=this._cBnd,a=this._szBnd;a&&(this._szRange=_Utils.getRange(r,a));let c=this.colorScale;c&&c.domain(r);if(h&&o||l)for(let e=0;e<n;e++){let i=r[e];if(i){let e=this.getItemPos(i);if(e){c&&(t.fill=c.convert(c.getValue(i)));this.renderItem(t,i,e.x,e.y)}}this._index++}t.endGroup();return s}renderItem(t,e,i,s){if(isNumber(i)&&isNumber(s)){let r=this.map.convert(new Point(i,s));if(isFinite(r.x)&&isFinite(r.y)){let i=this.symbolSize;if(this._szRange){let t=this._szBnd.getValue(e);t=Math.sqrt((t-this._szRange.min)/this._szRange.range);i=this.symbolMinSize+(this.symbolMaxSize-this.symbolMinSize)*t}if(isFinite(i)){let e=t.drawEllipse(r.x,r.y,.5*i,.5*i);e.setAttribute("vector-effect","non-scaling-stroke");let s=this.createId();this.setId(e,s);this._elMap[s]=e}}}}getItemById(t){let e=this.itemsSource;if(e){if(this._elMap[t]){let i=parseInt(t.split("_")[1]);if(isNumber(i)&&i<e.length)return e[i]}}return null}getGeoBBox(){let t=this.itemsSource,e=t?t.length:0;if(this._hasBindings){let i=NaN,s=NaN,r=NaN,n=NaN;for(let h=0;h<e;h++){let e=t[h];if(e){let t=this.getItemPos(e);if(t){if(isFinite(t.x)){(isNaN(i)||t.x<i)&&(i=t.x);(isNaN(s)||t.x>s)&&(s=t.x)}if(isFinite(t.y)){(isNaN(r)||t.y<r)&&(r=t.y);(isNaN(n)||t.y>n)&&(n=t.y)}}}}if(!isNaN(i)&&!isNaN(r))return new Rect(i,r,s-i,n-r)}return null}getItemPos(t){let e=this._xBnd,i=this._yBnd,s=this._cBnd;if(s){let e=s.getValue(t);if(e){let t=e.split(",");if(t&&t.length>=2){let e=parseFloat(t[0]),i=parseFloat(t[1]);if(isFinite(e)&&isFinite(i))return new Point(e,i)}}}else{let s=e.getValue(t),r=i.getValue(t);isString(s)&&(s=parseFloat(s));isString(r)&&(r=parseFloat(r));if(isFinite(s)&&isFinite(r))return new Point(s,r)}return null}setId(t,e){t&&e&&t.setAttribute("wj-map:id",e)}createId(){return this._prefix+this._index.toString()}parseBindings(){let t=this.binding;this._xBnd=this._yBnd=this._szBnd=null;this._hasBindings=!1;if(t){let e=t.split(",");if(1==e.length){this._cBnd=new Binding(e[0].trim());this._hasBindings=!0}else if(e.length>=2){this._xBnd=new Binding(e[0].trim());this._yBnd=new Binding(e[1].trim());this._hasBindings=!0;e.length>=3&&(this._szBnd=new Binding(e[2].trim()))}}}}export class _GeoJsonRender{constructor(){this._map={};this._index=0;this.prefix="_";this.hasPoints=!1;this.symbolSize=5}convert(t){this.converter&&(t=this.converter.convert(t));return t}render(t,e,i=null){this._map={};this._index=0;this.hasPoints=!1;if(e)switch(e.type){case"Point":case"MultiPoint":case"LineString":case"MultiLineString":case"Polygon":case"MultiPolygon":case"GeometryCollection":this.renderGeometry(t,e);break;case"Feature":this.renderFeature(t,e,i);break;case"FeatureCollection":if(e.features)for(let s=0;s<e.features.length;s++)this.renderFeature(t,e.features[s],i)}}renderFeature(t,e,i=null){if(e&&e.geometry){i&&i(t,e);let s=this.createId();this.renderGeometry(t,e.geometry,s);this._map[s]=e;this._index++}}renderGeometry(t,e,i=null){if(e)switch(e.type){case"Point":this.renderPoint(t,e,i);this.hasPoints=!0;break;case"MultiPoint":this.renderMultiPoint(t,e,i);this.hasPoints=!0;break;case"LineString":this.renderLineString(t,e,i);break;case"MultiLineString":this.renderMultiLineString(t,e,i);break;case"Polygon":this.renderPolygon(t,e,i);break;case"MultiPolygon":this.renderMultiPolygon(t,e,i);break;case"GeometryCollection":if(e.geometries)for(let s=0;s<e.geometries.length;s++)this.renderGeometry(t,e.geometries[s],i)}}renderPoint(t,e,i=null){if(e&&e.coordinates&&e.coordinates.length>=2){let s=new Point(e.coordinates[0],e.coordinates[1]);s=this.convert(s);let r=t.scale*this.symbolSize,n=t.drawEllipse(s.x,s.y,r,r);n.setAttribute("vector-effect","non-scaling-stroke");this.setAttribute(n,i)}}renderMultiPoint(t,e,i=null){if(e&&e.coordinates){let s=e.coordinates,r=e.coordinates.length;for(let e=0;e<r;e++){let r=new Point(s[e][0],s[e][1]);r=this.convert(r);let n=t.scale*this.symbolSize,h=t.drawEllipse(r.x,r.y,n,n);this.setAttribute(h,i)}}}renderLineString(t,e,i=null){if(e&&e.coordinates){let s=e.coordinates,r=e.coordinates.length,n=[],h=[];for(let t=0;t<r;t++){let e=new Point(s[t][0],s[t][1]);e=this.convert(e);n.push(e.x);h.push(e.y)}let o=t.drawLines(n,h);this.setAttribute(o,i)}}renderMultiLineString(t,e,i=null){if(e&&e.coordinates){let s=e.coordinates,r=s.length;for(let e=0;e<r;e++){let r=s[e],n=[],h=[];for(let t=0;t<r.length;t++){let e=new Point(r[t][0],r[t][1]);e=this.convert(e);n.push(e.x);h.push(e.y)}let o=t.drawLines(n,h);this.setAttribute(o,i)}}}renderMultiPolygon(t,e,i=null){if(e&&e.coordinates){let s=e.coordinates,r=s.length,n=t;for(let t=0;t<r;t++){let e=s[t],r=(e.length,[]);for(let t=0;t<1;t++){let i=e[t],s=[];for(let t=0;t<i.length;t++){let e=new Point(i[t][0],i[t][1]);e=this.convert(e);s.push(e.x);s.push(e.y)}r.push(s)}let h=n.drawPolygon2(null,r);this.setAttribute(h,i)}}}renderPolygon(t,e,i=null){if(e&&e.coordinates){let s=e.coordinates,r=s.length,n=t,h=[];for(let t=0;t<r;t++){let e=s[t],i=[];for(let t=0;t<e.length;t++){let s=new Point(e[t][0],e[t][1]);s=this.convert(s);i.push(s.x);i.push(s.y)}h.push(i)}let o=n.drawPolygon2(null,h);this.setAttribute(o,i)}}getFeatureById(t){return this._map[t]}getAllFeatures(t){let e=[];if(t)switch(t.type){case"Feature":e.push(t);break;case"FeatureCollection":if(t.features)for(let i=0;i<t.features.length;i++)e.push(t.features[i])}return e}getBBox(t){let e=null;if(t)switch(t.type){case"Point":case"MultiPoint":case"LineString":case"MultiLineString":case"Polygon":case"MultiPolygon":case"GeometryCollection":e=this.getGeometryBBox(t);break;case"Feature":e=this.getGeometryBBox(t.geometry);break;case"FeatureCollection":if(t.features)for(let i=0;i<t.features.length;i++){let s=this.getGeometryBBox(t.features[i].geometry,e);s&&(e=s)}}return e}getGeometryBBox(t,e){let i=null;if(t)switch(t.type){case"Point":case"MultiPoint":case"LineString":case"MultiLineString":case"Polygon":case"MultiPolygon":{let s=t.coordinates,r=this.flat(s,10);i=this.getRect(r,e)}break;case"GeometryCollection":if(t.geometries)for(let s=0;s<t.geometries.length;s++)(i=this.getGeometryBBox(t.geometries[s],e))&&(e=i.clone())}return i}getRect(t,e){let i=null;if(t){let s=NaN,r=NaN,n=NaN,h=NaN;if(e){s=e.left;r=e.right;n=e.top;h=e.bottom}let o=t.length/2;for(let e=0;e<o;e++){let i=t[2*e],o=t[2*e+1];(isNaN(s)||i<s)&&(s=i);(isNaN(r)||i>r)&&(r=i);(isNaN(n)||o<n)&&(n=o);(isNaN(h)||o>h)&&(h=o)}isNaN(s)||isNaN(n)||(i=new Rect(s,n,r-s,h-n))}return i}setAttribute(t,e){t&&e&&t.setAttribute("wj-map:id",e)}createId(){return this.prefix+this._index.toString()}flat(t,e){if(t.flat)return t.flat(e);{const e=[...t],i=[];for(;e.length;){const t=e.pop();Array.isArray(t)?e.push(...t):i.push(t)}return i.reverse()}}}export class GeoMapLayer extends MapLayerBase{constructor(t){super();this._render=new _GeoJsonRender;this._symbolSize=5;this.style={stroke:"gray",fill:"transparent",strokeWidth:.5};t&&this.initialize(t)}get itemFormatter(){return this._ifmt}set itemFormatter(t){if(this._ifmt!=t){this._ifmt=asFunction(t,!0);this._clearCache();this.invalidate()}}getAllFeatures(){return this._render.getAllFeatures(this.itemsSource)}render(t,e,i){this._render.hasPoints&&this._clearCache();let s=this._g;if(s)i.appendChild(s);else{s=t.startGroup();this._render.symbolSize=this.symbolSize;this._render.converter=this.map._proj;let e=this.colorScale;e&&e.domain(this.getAllFeatures());this._applyStyle(t);this._render.prefix=this.map.layers.indexOf(this).toString()+"_";e?this._render.render(t,this.itemsSource,(t,i)=>{t.fill=e.convert(e.getValue(i))}):this._render.render(t,this.itemsSource,this.itemFormatter);t.endGroup();this._g=s}0==s.transform.baseVal.numberOfItems?s.transform.baseVal.appendItem(e):s.transform.baseVal.replaceItem(e,0);return s}getGeoBBox(t){return t?this._render.getBBox(t):this._render.getBBox(this.itemsSource)}get symbolSize(){return this._symbolSize}set symbolSize(t){if(this._symbolSize!=t){this._symbolSize=asNumber(t);this.invalidate()}}_clearCache(){this._g=null}_getFeatureById(t){return this._render.getFeatureById(t)}}export class GeoGridLayer extends MapLayerBase{constructor(){super();this.style={stroke:"lightgrey",strokeWidth:.5,fill:"lightgrey"}}render(t,e,i){let s=t.startGroup("wj-flexmap-geogrid"),r=this.map,n=this.map._mapRect,h="wj-label";this._applyStyle(t);for(let e=-180;e<=180;e+=30){let i=r.convert(new Point(e,-85)),s=r.convert(new Point(e,85));if(this.isValid(i)&&this.isValid(s)){let r=e.toString(),o=t.measureString(r,h);t.drawString(r,new Point(i.x-.5*o.width,n.top+o.height),h);t.drawLine(i.x,i.y,s.x,s.y)}}let o=n.left;for(let e=-80;e<=80;e+=20){let i=r.convert(new Point(-180,e)),s=r.convert(new Point(180,e));if(this.isValid(i)&&this.isValid(s)){let r=o.toString(),n=t.measureString(r,h);t.drawString(e.toString(),new Point(o,i.y+.5*n.height),h);t.drawLine(i.x,i.y,s.x,s.y)}}t.endGroup();return s}isValid(t){return isFinite(t.x)&&isFinite(t.y)}}_registerModule("wijmo.chart.map",selfModule);