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

"use strict";var __extends=this&&this.__extends||function(){var extendStatics=function(t,e){return(extendStatics=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(t,e){t.__proto__=e}||function(t,e){for(var r in e)e.hasOwnProperty(r)&&(t[r]=e[r])})(t,e)};return function(t,e){extendStatics(t,e);function __(){this.constructor=t}t.prototype=null===e?Object.create(e):(__.prototype=e.prototype,new __)}}(),__importStar=this&&this.__importStar||function(t){if(t&&t.__esModule)return t;var e={};if(null!=t)for(var r in t)Object.hasOwnProperty.call(t,r)&&(e[r]=t[r]);e.default=t;return e};Object.defineProperty(exports,"__esModule",{value:!0});var wijmo_1=require("wijmo/wijmo"),core=__importStar(require("wijmo/wijmo")),chart=__importStar(require("wijmo/wijmo.chart")),selfModule=__importStar(require("wijmo/wijmo.chart.webgl")),_EarCut=function(){function _EarCut(){}_EarCut.prototype.earcut=function(t,e,r){void 0===e&&(e=null);void 0===r&&(r=null);r=r||2;var i,n,o,s,a,h,u,f=e&&e.length,l=f?e[0]*r:t.length,p=this.linkedList(t,0,l,r,!0),c=[];if(!p||p.next===p.prev)return c;f&&(p=this.eliminateHoles(t,e,p,r));if(t.length>80*r){i=o=t[0];n=s=t[1];for(var d=r;d<l;d+=r){(a=t[d])<i&&(i=a);(h=t[d+1])<n&&(n=h);a>o&&(o=a);h>s&&(s=h)}u=0!==(u=Math.max(o-i,s-n))?1/u:0}this.earcutLinked(p,c,r,i,n,u);return c};_EarCut.prototype.linkedList=function(t,e,r,i,n){var o,s;if(n===this.signedArea(t,e,r,i)>0)for(o=e;o<r;o+=i)s=this.insertNode(o,t[o],t[o+1],s);else for(o=r-i;o>=e;o-=i)s=this.insertNode(o,t[o],t[o+1],s);if(s&&this.equals(s,s.next)){this.removeNode(s);s=s.next}return s};_EarCut.prototype.filterPoints=function(t,e){void 0===e&&(e=null);if(!t)return t;e||(e=t);var r,i=t;do{r=!1;if(i.steiner||!this.equals(i,i.next)&&0!==this.area(i.prev,i,i.next))i=i.next;else{this.removeNode(i);if((i=e=i.prev)===i.next)break;r=!0}}while(r||i!==e);return e};_EarCut.prototype.earcutLinked=function(t,e,r,i,n,o,s){void 0===s&&(s=null);if(t){!s&&o&&this.indexCurve(t,i,n,o);for(var a,h,u=t;t.prev!==t.next;){a=t.prev;h=t.next;if(o?this.isEarHashed(t,i,n,o):this.isEar(t)){e.push(a.i/r);e.push(t.i/r);e.push(h.i/r);this.removeNode(t);t=h.next;u=h.next}else if((t=h)===u){if(s)if(1===s){t=this.cureLocalIntersections(this.filterPoints(t),e,r);this.earcutLinked(t,e,r,i,n,o,2)}else 2===s&&this.splitEarcut(t,e,r,i,n,o);else this.earcutLinked(this.filterPoints(t),e,r,i,n,o,1);break}}}};_EarCut.prototype.isEar=function(t){var e=t.prev,r=t,i=t.next;if(this.area(e,r,i)>=0)return!1;for(var n=t.next.next;n!==t.prev;){if(this.pointInTriangle(e.x,e.y,r.x,r.y,i.x,i.y,n.x,n.y)&&this.area(n.prev,n,n.next)>=0)return!1;n=n.next}return!0};_EarCut.prototype.isEarHashed=function(t,e,r,i){var n=t.prev,o=t,s=t.next;if(this.area(n,o,s)>=0)return!1;for(var a=n.x<o.x?n.x<s.x?n.x:s.x:o.x<s.x?o.x:s.x,h=n.y<o.y?n.y<s.y?n.y:s.y:o.y<s.y?o.y:s.y,u=n.x>o.x?n.x>s.x?n.x:s.x:o.x>s.x?o.x:s.x,f=n.y>o.y?n.y>s.y?n.y:s.y:o.y>s.y?o.y:s.y,l=this.zOrder(a,h,e,r,i),p=this.zOrder(u,f,e,r,i),c=t.prevZ,d=t.nextZ;c&&c.z>=l&&d&&d.z<=p;){if(c!==t.prev&&c!==t.next&&this.pointInTriangle(n.x,n.y,o.x,o.y,s.x,s.y,c.x,c.y)&&this.area(c.prev,c,c.next)>=0)return!1;c=c.prevZ;if(d!==t.prev&&d!==t.next&&this.pointInTriangle(n.x,n.y,o.x,o.y,s.x,s.y,d.x,d.y)&&this.area(d.prev,d,d.next)>=0)return!1;d=d.nextZ}for(;c&&c.z>=l;){if(c!==t.prev&&c!==t.next&&this.pointInTriangle(n.x,n.y,o.x,o.y,s.x,s.y,c.x,c.y)&&this.area(c.prev,c,c.next)>=0)return!1;c=c.prevZ}for(;d&&d.z<=p;){if(d!==t.prev&&d!==t.next&&this.pointInTriangle(n.x,n.y,o.x,o.y,s.x,s.y,d.x,d.y)&&this.area(d.prev,d,d.next)>=0)return!1;d=d.nextZ}return!0};_EarCut.prototype.cureLocalIntersections=function(t,e,r){var i=t;do{var n=i.prev,o=i.next.next;if(!this.equals(n,o)&&this.intersects(n,i,i.next,o)&&this.locallyInside(n,o)&&this.locallyInside(o,n)){e.push(n.i/r);e.push(i.i/r);e.push(o.i/r);this.removeNode(i);this.removeNode(i.next);i=t=o}i=i.next}while(i!==t);return this.filterPoints(i)};_EarCut.prototype.splitEarcut=function(t,e,r,i,n,o){var s=t;do{for(var a=s.next.next;a!==s.prev;){if(s.i!==a.i&&this.isValidDiagonal(s,a)){var h=this.splitPolygon(s,a);s=this.filterPoints(s,s.next);h=this.filterPoints(h,h.next);this.earcutLinked(s,e,r,i,n,o);this.earcutLinked(h,e,r,i,n,o);return}a=a.next}s=s.next}while(s!==t)};_EarCut.prototype.eliminateHoles=function(t,e,r,i){var n,o,s,a,h,u=[];for(n=0,o=e.length;n<o;n++){s=e[n]*i;a=n<o-1?e[n+1]*i:t.length;(h=this.linkedList(t,s,a,i,!1))===h.next&&(h.steiner=!0);u.push(this.getLeftmost(h))}u.sort(this.compareX);for(n=0;n<u.length;n++){this.eliminateHole(u[n],r);r=this.filterPoints(r,r.next)}return r};_EarCut.prototype.compareX=function(t,e){return t.x-e.x};_EarCut.prototype.eliminateHole=function(t,e){if(e=this.findHoleBridge(t,e)){var r=this.splitPolygon(e,t);this.filterPoints(e,e.next);this.filterPoints(r,r.next)}};_EarCut.prototype.findHoleBridge=function(t,e){var r,i=e,n=t.x,o=t.y,s=-1/0;do{if(o<=i.y&&o>=i.next.y&&i.next.y!==i.y){var a=i.x+(o-i.y)*(i.next.x-i.x)/(i.next.y-i.y);if(a<=n&&a>s){s=a;if(a===n){if(o===i.y)return i;if(o===i.next.y)return i.next}r=i.x<i.next.x?i:i.next}}i=i.next}while(i!==e);if(!r)return null;if(n===s)return r;var h,u=r,f=r.x,l=r.y,p=1/0;i=r;do{if(n>=i.x&&i.x>=f&&n!==i.x&&this.pointInTriangle(o<l?n:s,o,f,l,o<l?s:n,o,i.x,i.y)){h=Math.abs(o-i.y)/(n-i.x);if(this.locallyInside(i,t)&&(h<p||h===p&&(i.x>r.x||i.x===r.x&&this.sectorContainsSector(r,i)))){r=i;p=h}}i=i.next}while(i!==u);return r};_EarCut.prototype.sectorContainsSector=function(t,e){return this.area(t.prev,t,e.prev)<0&&this.area(e.next,t,t.next)<0};_EarCut.prototype.indexCurve=function(t,e,r,i){var n=t;do{null===n.z&&(n.z=this.zOrder(n.x,n.y,e,r,i));n.prevZ=n.prev;n.nextZ=n.next;n=n.next}while(n!==t);n.prevZ.nextZ=null;n.prevZ=null;this.sortLinked(n)};_EarCut.prototype.sortLinked=function(t){var e,r,i,n,o,s,a,h,u=1;do{r=t;t=null;o=null;s=0;for(;r;){s++;i=r;a=0;for(e=0;e<u;e++){a++;if(!(i=i.nextZ))break}h=u;for(;a>0||h>0&&i;){if(0!==a&&(0===h||!i||r.z<=i.z)){n=r;r=r.nextZ;a--}else{n=i;i=i.nextZ;h--}o?o.nextZ=n:t=n;n.prevZ=o;o=n}r=i}o.nextZ=null;u*=2}while(s>1);return t};_EarCut.prototype.zOrder=function(t,e,r,i,n){return(t=1431655765&((t=858993459&((t=252645135&((t=16711935&((t=32767*(t-r)*n)|t<<8))|t<<4))|t<<2))|t<<1))|(e=1431655765&((e=858993459&((e=252645135&((e=16711935&((e=32767*(e-i)*n)|e<<8))|e<<4))|e<<2))|e<<1))<<1};_EarCut.prototype.getLeftmost=function(t){var e=t,r=t;do{(e.x<r.x||e.x===r.x&&e.y<r.y)&&(r=e);e=e.next}while(e!==t);return r};_EarCut.prototype.pointInTriangle=function(t,e,r,i,n,o,s,a){return(n-s)*(e-a)-(t-s)*(o-a)>=0&&(t-s)*(i-a)-(r-s)*(e-a)>=0&&(r-s)*(o-a)-(n-s)*(i-a)>=0};_EarCut.prototype.isValidDiagonal=function(t,e){return t.next.i!==e.i&&t.prev.i!==e.i&&!this.intersectsPolygon(t,e)&&(this.locallyInside(t,e)&&this.locallyInside(e,t)&&this.middleInside(t,e)&&(this.area(t.prev,t,e.prev)||this.area(t,e.prev,e))||this.equals(t,e)&&this.area(t.prev,t,t.next)>0&&this.area(e.prev,e,e.next)>0)};_EarCut.prototype.area=function(t,e,r){return(e.y-t.y)*(r.x-e.x)-(e.x-t.x)*(r.y-e.y)};_EarCut.prototype.equals=function(t,e){return t.x===e.x&&t.y===e.y};_EarCut.prototype.intersects=function(t,e,r,i){var n=this.sign(this.area(t,e,r)),o=this.sign(this.area(t,e,i)),s=this.sign(this.area(r,i,t)),a=this.sign(this.area(r,i,e));return n!==o&&s!==a||(!(0!==n||!this.onSegment(t,r,e))||(!(0!==o||!this.onSegment(t,i,e))||(!(0!==s||!this.onSegment(r,t,i))||!(0!==a||!this.onSegment(r,e,i)))))};_EarCut.prototype.onSegment=function(t,e,r){return e.x<=Math.max(t.x,r.x)&&e.x>=Math.min(t.x,r.x)&&e.y<=Math.max(t.y,r.y)&&e.y>=Math.min(t.y,r.y)};_EarCut.prototype.sign=function(t){return t>0?1:t<0?-1:0};_EarCut.prototype.intersectsPolygon=function(t,e){var r=t;do{if(r.i!==t.i&&r.next.i!==t.i&&r.i!==e.i&&r.next.i!==e.i&&this.intersects(r,r.next,t,e))return!0;r=r.next}while(r!==t);return!1};_EarCut.prototype.locallyInside=function(t,e){return this.area(t.prev,t,t.next)<0?this.area(t,e,t.next)>=0&&this.area(t,t.prev,e)>=0:this.area(t,e,t.prev)<0||this.area(t,t.next,e)<0};_EarCut.prototype.middleInside=function(t,e){var r=t,i=!1,n=(t.x+e.x)/2,o=(t.y+e.y)/2;do{r.y>o!=r.next.y>o&&r.next.y!==r.y&&n<(r.next.x-r.x)*(o-r.y)/(r.next.y-r.y)+r.x&&(i=!i);r=r.next}while(r!==t);return i};_EarCut.prototype.splitPolygon=function(t,e){var r=new Node(t.i,t.x,t.y),i=new Node(e.i,e.x,e.y),n=t.next,o=e.prev;t.next=e;e.prev=t;r.next=n;n.prev=r;i.next=r;r.prev=i;o.next=i;i.prev=o;return i};_EarCut.prototype.insertNode=function(t,e,r,i){var n=new Node(t,e,r);if(i){n.next=i.next;n.prev=i;i.next.prev=n;i.next=n}else{n.prev=n;n.next=n}return n};_EarCut.prototype.removeNode=function(t){t.next.prev=t.prev;t.prev.next=t.next;t.prevZ&&(t.prevZ.nextZ=t.nextZ);t.nextZ&&(t.nextZ.prevZ=t.prevZ)};_EarCut.prototype.deviation=function(t,e,r,i){var n=e&&e.length,o=n?e[0]*r:t.length,s=Math.abs(this.signedArea(t,0,o,r));if(n)for(var a=0,h=e.length;a<h;a++){var u=e[a]*r,f=a<h-1?e[a+1]*r:t.length;s-=Math.abs(this.signedArea(t,u,f,r))}var l=0;for(a=0;a<i.length;a+=3){var p=i[a]*r,c=i[a+1]*r,d=i[a+2]*r;l+=Math.abs((t[p]-t[d])*(t[c+1]-t[p+1])-(t[p]-t[c])*(t[d+1]-t[p+1]))}return 0===s&&0===l?0:Math.abs((l-s)/s)};_EarCut.prototype.signedArea=function(t,e,r,i){for(var n=0,o=e,s=r-i;o<r;o+=i){n+=(t[s]-t[o])*(t[o+1]+t[s+1]);s=o}return n};_EarCut.prototype.flatten=function(t){for(var e=t[0][0].length,r={vertices:[],holes:[],dimensions:e},i=0,n=0;n<t.length;n++){for(var o=0;o<t[n].length;o++)for(var s=0;s<e;s++)r.vertices.push(t[n][o][s]);if(n>0){i+=t[n-1].length;r.holes.push(i)}}return r};return _EarCut}();exports._EarCut=_EarCut;var Node=function Node(t,e,r){this.i=t;this.x=e;this.y=r;this.prev=null;this.next=null;this.z=null;this.prevZ=null;this.nextZ=null;this.steiner=!1},WebGLRenderEngine=function(t){__extends(WebGLRenderEngine,t);function WebGLRenderEngine(e){var r=t.call(this,e)||this;r.primitives=[];r.clipRects={};r.init();return r}WebGLRenderEngine.prototype.beginRender=function(){t.prototype.beginRender.call(this);this.isIE?this.element.appendChild(this.canvas):this.element.appendChild(this.foCanvas);var e=this.gl;e.viewport(0,0,e.canvas.width,e.canvas.height);e.clearColor(0,0,0,0);e.clear(e.COLOR_BUFFER_BIT|e.DEPTH_BUFFER_BIT);e.enable(e.BLEND);e.blendFuncSeparate(e.SRC_ALPHA,e.ONE_MINUS_SRC_ALPHA,e.ONE,e.ONE_MINUS_SRC_ALPHA);this.primitives.forEach((function(t){return t.beginRender()}));this.clipRects={}};WebGLRenderEngine.prototype.setViewportSize=function(e,r){t.prototype.setViewportSize.call(this,e,r);if(this.foCanvas){this.foCanvas.setAttribute("width",e.toString());this.foCanvas.setAttribute("height",r.toString())}var i=this.gl;i.canvas.width=e;i.canvas.height=r};WebGLRenderEngine.prototype.endRender=function(){this.primitives.forEach((function(t){return t.endRender()}));t.prototype.endRender.call(this);if(this.isIE){var e=document.createElementNS(WebGLRenderEngine.svgns,"image");e.setAttribute("width",this.gl.canvas.width);e.setAttribute("height",this.gl.canvas.height);e.setAttribute("href",this.canvas.toDataURL());this.element.appendChild(e);this.canvas.parentNode==this.element&&this.element.removeChild(this.canvas)}};WebGLRenderEngine.prototype.drawEllipse=function(e,r,i,n,o,s){if(this.useSvg)return t.prototype.drawEllipse.call(this,e,r,i,n,o,s);this.edraw.drawEllipse(new core.Rect(e-i,r-n,2*i,2*n),this.fill);return null};WebGLRenderEngine.prototype.drawRect=function(e,r,i,n,o,s,a){if("wj-plot-area"==this._groupCls||this.useSvg)return t.prototype.drawRect.call(this,e,r,i,n,o,s,a);this.rdraw.drawRect(new core.Rect(e,r,i,n),this.fill);return null};WebGLRenderEngine.prototype.drawLines=function(t,e,r,i,n,o){this.ldraw.drawLines(t,e,o,this.stroke,n?this.clipRects[n]:null);return null};WebGLRenderEngine.prototype.drawPolygon=function(e,r,i,n,o){if(this.useSvg)return t.prototype.drawPolygon.call(this,e,r,i,n,o);this.adraw.drawPolygon(e,r,this.fill,o?this.clipRects[o]:null);return null};WebGLRenderEngine.prototype.addClipRect=function(e,r){t.prototype.addClipRect.call(this,e,r);e&&r&&(this.clipRects[r]=e)};WebGLRenderEngine.prototype.init=function(){this.canvas=document.createElement("canvas");this.gl=this.canvas.getContext("webgl",{preserveDrawingBuffer:!0});if(this.gl){this.canvas.setAttribute("style","margin:0px;padding:0px;border:none");var t=document.createElementNS("http://www.w3.org/1999/xhtml","div");t.setAttribute("style","margin:0px;padding:0px;border:none");this.foCanvas=document.createElementNS(WebGLRenderEngine.svgns,"foreignObject");t.appendChild(this.canvas);this.foCanvas.appendChild(t)}else{this.gl=this.canvas.getContext("experimental-webgl");this.isIE=!0;this.canvas.setAttribute("style","visibility:hidden;position:absolute;top:-1000px;margin:0px;padding:0px;border:none")}this.rdraw=new _GLDrawRect(this.gl);this.edraw=new _GLDrawEllipse(this.gl);this.ldraw=new _GLDrawLines(this.gl);this.adraw=new _GLDrawAreas(this.gl);this.primitives.push(this.rdraw,this.edraw,this.ldraw,this.adraw)};WebGLRenderEngine.svgns="http://www.w3.org/2000/svg";return WebGLRenderEngine}(chart._SvgRenderEngine);exports.WebGLRenderEngine=WebGLRenderEngine;var _GLDrawBase=function(){function _GLDrawBase(t){this._vsSource="\n    attribute vec2 a_position;\n    \n    uniform vec2 u_resolution;\n    \n    void main() {\n      vec2 zeroToOne = a_position / u_resolution;\n      vec2 zeroToTwo = zeroToOne * 2.0;\n      vec2 clipSpace = zeroToTwo - 1.0;\n      gl_Position = vec4(clipSpace * vec2(1, -1), 0, 1);\n    }\n    ";this._fsSource="\n    precision mediump float;\n    uniform vec4 u_color;\n    void main() {\n      gl_FragColor = u_color;\n    }\n    ";this.gl=t}_GLDrawBase.prototype.init=function(){var t=this.gl;this.shaderProgram=this.initShaderProgram(this.vsSource,this.fsSource);this.positionAttributeLocation=t.getAttribLocation(this.shaderProgram,"a_position");this.resolutionUniformLocation=t.getUniformLocation(this.shaderProgram,"u_resolution");this.colorLocation=t.getUniformLocation(this.shaderProgram,"u_color");t.useProgram(this.shaderProgram);this.positionBuffer=t.createBuffer()};_GLDrawBase.prototype.beginRender=function(){var t=this.gl;t.useProgram(this.shaderProgram);t.uniform2f(this.resolutionUniformLocation,t.canvas.width,t.canvas.height)};_GLDrawBase.prototype.endRender=function(){this.flush()};_GLDrawBase.prototype.flush=function(){};_GLDrawBase.prototype.initShaderProgram=function(t,e){var r=this.gl,i=this.loadShader(r.VERTEX_SHADER,t),n=this.loadShader(r.FRAGMENT_SHADER,e),o=r.createProgram();r.attachShader(o,i);r.attachShader(o,n);r.linkProgram(o);if(!r.getProgramParameter(o,r.LINK_STATUS)){alert("Unable to initialize the shader program: "+r.getProgramInfoLog(o));return null}return o};_GLDrawBase.prototype.loadShader=function(t,e){var r=this.gl,i=r.createShader(t);r.shaderSource(i,e);r.compileShader(i);if(!r.getShaderParameter(i,r.COMPILE_STATUS)){alert("An error occurred compiling the shaders: "+r.getShaderInfoLog(i));r.deleteShader(i);return null}return i};Object.defineProperty(_GLDrawBase.prototype,"vsSource",{get:function(){return this._vsSource},enumerable:!0,configurable:!0});Object.defineProperty(_GLDrawBase.prototype,"fsSource",{get:function(){return this._fsSource},enumerable:!0,configurable:!0});return _GLDrawBase}(),_GLDrawRect=function(t){__extends(_GLDrawRect,t);function _GLDrawRect(e){var r=t.call(this,e)||this;r.BUFFER_SIZE=1e4;r.bufRects=[];r.bufLen=0;r.init();return r}_GLDrawRect.prototype.initBuffers=function(){if(!this.buffer){var t=this.gl;this.buffer=new Float32Array(12*this.BUFFER_SIZE);this.bufRects=new Array(this.BUFFER_SIZE);t.enableVertexAttribArray(this.positionAttributeLocation);t.bindBuffer(t.ARRAY_BUFFER,this.positionBuffer);t.vertexAttribPointer(this.positionAttributeLocation,2,t.FLOAT,!1,0,0);t.bufferData(t.ARRAY_BUFFER,4*this.buffer.length,t.DYNAMIC_DRAW)}};_GLDrawRect.prototype.drawRect=function(t,e){this.initBuffers();if(e!==this.previousFill){this.flush();this.previousFill=e}this.bufRects[this.bufLen++]=t;this.bufLen>=this.BUFFER_SIZE&&this.flush()};_GLDrawRect.prototype.flush=function(){if(0!=this.bufLen){var t=this.gl;t.useProgram(this.shaderProgram);var e=new core.Color(this.previousFill);t.uniform4f(this.colorLocation,e.r/255,e.g/255,e.b/255,e.a);t.enableVertexAttribArray(this.positionAttributeLocation);t.bindBuffer(t.ARRAY_BUFFER,this.positionBuffer);t.vertexAttribPointer(this.positionAttributeLocation,2,t.FLOAT,!1,0,0);this.setData();t.enableVertexAttribArray(this.positionAttributeLocation);t.bindBuffer(t.ARRAY_BUFFER,this.positionBuffer);t.vertexAttribPointer(this.positionAttributeLocation,2,t.FLOAT,!1,0,0);t.drawArrays(t.TRIANGLES,0,6*this.bufLen);this.bufLen=0}};_GLDrawRect.prototype.setData=function(){for(var t=this.gl,e=this.bufLen,r=this.buffer,i=0;i<e;i++){var n=this.bufRects[i],o=n.left,s=n.right,a=n.top,h=n.bottom,u=12*i;r[u]=o;r[u+1]=a;r[u+2]=s;r[u+3]=a;r[u+4]=o;r[u+5]=h;r[u+6]=o;r[u+7]=h;r[u+8]=s;r[u+9]=a;r[u+10]=s;r[u+11]=h}t.bufferSubData(t.ARRAY_BUFFER,0,r.subarray(0,12*e))};return _GLDrawRect}(_GLDrawBase),_GLDrawEllipse=function(t){__extends(_GLDrawEllipse,t);function _GLDrawEllipse(e){var r=t.call(this,e)||this;r.NTRIANGLES=12;r.BUFFER_SIZE=1e4;r.bufRects=new Array(r.BUFFER_SIZE);r.bufLen=0;r.sin1=new Float32Array(r.NTRIANGLES);r.sin2=new Float32Array(r.NTRIANGLES);r.cos1=new Float32Array(r.NTRIANGLES);r.cos2=new Float32Array(r.NTRIANGLES);r.data=new Float32Array(r.BUFFER_SIZE*r.NTRIANGLES*6);for(var i=2*Math.PI/r.NTRIANGLES,n=0;n<r.NTRIANGLES;n++){var o=i*n;r.sin1[n]=Math.sin(o);r.cos1[n]=Math.cos(o);r.sin2[n]=Math.sin(o+i);r.cos2[n]=Math.cos(o+i)}r.init();e.enableVertexAttribArray(r.positionAttributeLocation);e.bindBuffer(e.ARRAY_BUFFER,r.positionBuffer);e.vertexAttribPointer(r.positionAttributeLocation,2,e.FLOAT,!1,0,0);e.bufferData(e.ARRAY_BUFFER,4*r.data.length,e.DYNAMIC_DRAW);return r}_GLDrawEllipse.prototype.drawEllipse=function(t,e){if(e!==this.previousFill){this.flush();this.previousFill=e}this.bufRects[this.bufLen++]=t;this.bufLen>=this.BUFFER_SIZE&&this.flush()};_GLDrawEllipse.prototype.flush=function(){if(0!=this.bufLen){var t=this.gl;t.useProgram(this.shaderProgram);var e=new core.Color(this.previousFill);t.uniform4f(this.colorLocation,e.r/255,e.g/255,e.b/255,e.a);t.enableVertexAttribArray(this.positionAttributeLocation);t.bindBuffer(t.ARRAY_BUFFER,this.positionBuffer);t.vertexAttribPointer(this.positionAttributeLocation,2,t.FLOAT,!1,0,0);this.setData();t.enableVertexAttribArray(this.positionAttributeLocation);t.bindBuffer(t.ARRAY_BUFFER,this.positionBuffer);t.vertexAttribPointer(this.positionAttributeLocation,2,t.FLOAT,!1,0,0);t.drawArrays(t.TRIANGLES,0,this.bufLen*this.NTRIANGLES*3);this.bufLen=0}};_GLDrawEllipse.prototype.setData=function(){for(var t=this.gl,e=this.bufLen,r=this.data,i=0,n=0;n<e;n++)for(var o=this.bufRects[n],s=.5*o.width,a=.5*o.height,h=o.left+s,u=o.top+a,f=0;f<this.NTRIANGLES;f++){r[i=6*(n*this.NTRIANGLES+f)]=h;r[i+1]=u;r[i+2]=h+s*this.sin1[f];r[i+3]=u+a*this.cos1[f];r[i+4]=h+s*this.sin2[f];r[i+5]=u+a*this.cos2[f]}t.bufferSubData(t.ARRAY_BUFFER,0,r.subarray(0,i+6))};return _GLDrawEllipse}(_GLDrawBase),_GLDrawPoints=function(t){__extends(_GLDrawPoints,t);function _GLDrawPoints(e){var r=t.call(this,e)||this;r.BUFFER_SIZE=1e5;r.bufferLen=0;r._vsSource1="\n    attribute vec2 a_position;\n    uniform vec2 u_resolution;\n    void main() {\n      vec2 zeroToOne = a_position / u_resolution;\n      vec2 zeroToTwo = zeroToOne * 2.0;\n      vec2 clipSpace = zeroToTwo - 1.0;\n      gl_Position = vec4(clipSpace * vec2(1, -1), 0, 1);\n      gl_PointSize = 5.0;\n    }\n    ";r.init();return r}_GLDrawPoints.prototype.initBuffers=function(){if(!this.buffer){var t=this.gl;this.buffer=new Float32Array(this.BUFFER_SIZE);t.enableVertexAttribArray(this.positionAttributeLocation);t.bindBuffer(t.ARRAY_BUFFER,this.positionBuffer);t.vertexAttribPointer(this.positionAttributeLocation,2,t.FLOAT,!1,0,0);t.bufferData(t.ARRAY_BUFFER,4*this.buffer.length,t.DYNAMIC_DRAW)}};_GLDrawPoints.prototype.drawPoint=function(t,e){this.initBuffers();if(e!==this.previousFill){this.flush();this.previousFill=e}this.buffer[this.bufferLen++]=t.x;this.buffer[this.bufferLen++]=t.y;this.bufferLen>=this.BUFFER_SIZE&&this.flush()};_GLDrawPoints.prototype.flush=function(){if(0!=this.bufferLen){var t=this.gl;t.useProgram(this.shaderProgram);var e=new core.Color(this.previousFill);t.uniform4f(this.colorLocation,e.r/255,e.g/255,e.b/255,e.a>0?1:0);t.enableVertexAttribArray(this.positionAttributeLocation);t.bindBuffer(t.ARRAY_BUFFER,this.positionBuffer);t.vertexAttribPointer(this.positionAttributeLocation,2,t.FLOAT,!1,0,0);t.bufferSubData(t.ARRAY_BUFFER,0,this.buffer.subarray(0,this.bufferLen));t.drawArrays(t.POINTS,0,this.bufferLen/2);this.bufferLen=0}};Object.defineProperty(_GLDrawPoints.prototype,"vsSource",{get:function(){return this._vsSource1},enumerable:!0,configurable:!0});return _GLDrawPoints}(_GLDrawBase),_GLDrawLines=function(t){__extends(_GLDrawLines,t);function _GLDrawLines(e){var r=t.call(this,e)||this;r.BUFFER_SIZE=1e6;r.init();return r}_GLDrawLines.prototype.initBuffers=function(){if(!this.buffer){var t=this.gl;this.buffer=new Float32Array(4*this.BUFFER_SIZE);t.enableVertexAttribArray(this.positionAttributeLocation);t.bindBuffer(t.ARRAY_BUFFER,this.positionBuffer);t.vertexAttribPointer(this.positionAttributeLocation,2,t.FLOAT,!1,0,0);t.bufferData(t.ARRAY_BUFFER,4*this.buffer.length,t.DYNAMIC_DRAW)}};_GLDrawLines.prototype.drawLines=function(t,e,r,i,n){void 0===n&&(n=null);this.initBuffers();var o=r||t.length,s=this.gl;s.useProgram(this.shaderProgram);if(n){s.enable(s.SCISSOR_TEST);s.scissor(n.left,s.canvas.height-n.bottom,n.width+1,n.height+1)}var a=new core.Color(i);s.uniform4f(this.colorLocation,a.r/255,a.g/255,a.b/255,a.a>0?1:0);s.enableVertexAttribArray(this.positionAttributeLocation);s.bindBuffer(s.ARRAY_BUFFER,this.positionBuffer);s.vertexAttribPointer(this.positionAttributeLocation,2,s.FLOAT,!1,0,0);for(var h=0;h<o;h++){this.buffer[2*h]=t[h];this.buffer[2*h+1]=e[h]}s.bufferSubData(s.ARRAY_BUFFER,0,this.buffer.subarray(0,2*o));s.enableVertexAttribArray(this.positionAttributeLocation);s.bindBuffer(s.ARRAY_BUFFER,this.positionBuffer);s.vertexAttribPointer(this.positionAttributeLocation,2,s.FLOAT,!1,0,0);s.drawArrays(s.LINE_STRIP,0,o);n&&s.disable(s.SCISSOR_TEST)};return _GLDrawLines}(_GLDrawBase),_GLDrawAreas=function(t){__extends(_GLDrawAreas,t);function _GLDrawAreas(e){var r=t.call(this,e)||this;r.earcut=new _EarCut;r.BUFFER_SIZE=1e6;r.init();return r}_GLDrawAreas.prototype.initBuffers=function(){if(!this.buffer){var t=this.gl;this.buffer=new Float32Array(4*this.BUFFER_SIZE);t.enableVertexAttribArray(this.positionAttributeLocation);t.bindBuffer(t.ARRAY_BUFFER,this.positionBuffer);t.vertexAttribPointer(this.positionAttributeLocation,2,t.FLOAT,!1,0,0);t.bufferData(t.ARRAY_BUFFER,4*this.buffer.length,t.DYNAMIC_DRAW)}};_GLDrawAreas.prototype.drawPolygon=function(t,e,r,i){void 0===i&&(i=null);this.initBuffers();for(var n=t.length,o=[],s=0;s<n;s++){o.push(t[s]);o.push(e[s])}var a=this.earcut.earcut(o),h=this.gl;h.useProgram(this.shaderProgram);if(i){h.enable(h.SCISSOR_TEST);h.scissor(i.left,h.canvas.height-i.bottom,i.width,i.height)}var u=new core.Color(r);h.uniform4f(this.colorLocation,u.r/255,u.g/255,u.b/255,u.a>0?1:0);h.enableVertexAttribArray(this.positionAttributeLocation);h.bindBuffer(h.ARRAY_BUFFER,this.positionBuffer);h.vertexAttribPointer(this.positionAttributeLocation,2,h.FLOAT,!1,0,0);var f=0;for(s=0;s<a.length;s++){this.buffer[f++]=o[2*a[s]];this.buffer[f++]=o[2*a[s]+1]}h.bufferSubData(h.ARRAY_BUFFER,0,this.buffer.subarray(0,f));h.enableVertexAttribArray(this.positionAttributeLocation);h.bindBuffer(h.ARRAY_BUFFER,this.positionBuffer);h.vertexAttribPointer(this.positionAttributeLocation,2,h.FLOAT,!1,0,0);h.drawArrays(h.TRIANGLES,0,a.length);i&&h.disable(h.SCISSOR_TEST)};return _GLDrawAreas}(_GLDrawBase);wijmo_1._registerModule("wijmo.chart.webgl",selfModule);