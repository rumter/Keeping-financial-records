Ext.define('Koala.view.expCategory.ExpCategoryPanel', {
    extend: 'Ext.panel.Panel',
    alias: 'view.expCategory.ExpCategoryPanel',

    requires: [
        'Koala.view.expCategory.ExpCategoryController'
    ],

    controller: 'expCategory.ExpCategoryController',

    initComponent: function () {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'panel',
                    html: 'ExpCategoryPanel'
                }
            ]
        });

        me.callParent(arguments);
    },

    listeners: {
        afterrender: 'onAfterRender'
    }

});
