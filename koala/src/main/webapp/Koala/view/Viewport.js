Ext.define('Koala.view.Viewport', {
    extend: 'Ext.container.Viewport',

    requires: [
        'Koala.view.MainPanel'
    ],

    layout: 'fit',
    renderTo: Ext.getBody(),

    initComponent: function () {
        var me = this;

        Ext.applyIf(me, {
            items: [
                Ext.create('view.MainPanel', {})
            ]
        });

        me.callParent(arguments);
    }

});
