Ext.define('Koala.view.MainPanel', {
    extend: 'Ext.panel.Panel',
    alias: 'view.MainPanel',

    layout: 'fit',

    initComponent: function () {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'panel',
                    title: 'Koala',
                    html: 'Hello world!'
                }
            ]
        });

        me.callParent(arguments);
    }

});
