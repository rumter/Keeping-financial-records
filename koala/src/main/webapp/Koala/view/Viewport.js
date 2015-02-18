Ext.define('Koala.view.Viewport', {
    extend: 'Ext.container.Viewport',

    requires: [
        'Koala.view.main.MainPanel'
    ],

    layout: 'fit',
    renderTo: Ext.getBody(),

    initComponent: function () {
        var me = this;

        Ext.applyIf(me, {
            items: [
                Ext.create('view.main.MainPanel', {})
            ]
        });

        me.callParent(arguments);
    }

});
