Ext.define('Koala.view.incCategory.IncCategoryPanel', {
    extend: 'Ext.panel.Panel',
    alias: 'view.incCategory.IncCategoryPanel',

    requires: [
        'Koala.view.incCategory.IncCategoryController'
    ],

    initComponent: function () {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'panel',
                    html: 'IncCategoryPanel'
                }
            ]
        });

        me.callParent(arguments);
    },

    listeners: {
        afterrender: 'onAfterRender'
    }

});
