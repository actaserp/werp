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

"use strict";var __importStar=this&&this.__importStar||function(r){if(r&&r.__esModule)return r;var i={};if(null!=r)for(var o in r)Object.hasOwnProperty.call(r,o)&&(i[o]=r[o]);i.default=r;return i};Object.defineProperty(exports,"__esModule",{value:!0});const wijmo_angular_base_1=require("wijmo/wijmo.angular.base"),wijmo_angular_grid_1=require("wijmo/wijmo.angular.grid"),mNg=__importStar(require("angular")),wjcGridMultirow=__importStar(require("wijmo/wijmo.grid.multirow"));var wjNg=mNg;const wijmoGridMultirowName="wj.grid.multirow";exports.ngModuleName="wj.grid.multirow";var wijmoGridMultirow=wijmo_angular_base_1._registerNgModule("wj.grid.multirow");wijmo_angular_base_1.softRefGridMultirow()&&wijmoGridMultirow.directive("wjMultiRow",["$compile","$interpolate",function(r,i){return new WjMultiRow(r,i)}]);class WjMultiRow extends wijmo_angular_grid_1.WjFlexGrid{constructor(r,i){super(r,i)}get _controlConstructor(){return wjcGridMultirow.MultiRow}}exports.WjMultiRow=WjMultiRow;