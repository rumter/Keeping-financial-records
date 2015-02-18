Ext.define('Koala.view.stream.StreamPanel', {
    extend: 'Ext.panel.Panel',
    alias: 'view.stream.StreamPanel',

    requires: [
        'Koala.view.stream.StreamController'
    ],

    initComponent: function () {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'panel',
                    html: 'StreamPanel'
                }
            ]
        });

        me.callParent(arguments);
    },

    listeners: {
        afterrender: 'onAfterRender'
    }

});
