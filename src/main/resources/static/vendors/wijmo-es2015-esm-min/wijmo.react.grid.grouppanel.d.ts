/*!
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
/**
 * {@module wijmo.react.grid.grouppanel}
 * Contains React components for the <b>wijmo.grid.grouppanel</b> module.
 */
/**
 *
 */
export declare var ___keepComment: any;
import { ComponentBase } from 'wijmo/wijmo.react.base';
/**
 * React component for the {@link wijmo.grid.grouppanel.GroupPanel} control.
 *
 * The component supports all properties and events of the pure JavaScript {@link wijmo.grid.grouppanel.GroupPanel} control it represents.
 *
 * The component includes an <b>initialized</b> event that is raised when the control is initialized after it is added to the page.
 * You can use this event to perform further initialization in addition to setting properties in JSX.
 * The signature of the handler function is the same as any other Wijmo event handlers.
 */
export declare class GroupPanel extends ComponentBase {
    props: {
        template?: any;
        children?: any;
        isDisabled?: any;
        tabOrder?: any;
        hideGroupedColumns?: any;
        showDragGlyphs?: any;
        maxGroups?: any;
        placeholder?: any;
        filter?: any;
        groupDescriptionCreator?: any;
        grid?: any;
        initialized?: any;
        gotFocus?: any;
        lostFocus?: any;
        refreshing?: any;
        refreshed?: any;
        invalidInput?: any;
        [key: string]: any;
    };
    constructor(props: any);
}
