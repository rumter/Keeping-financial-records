Ext.define('Koala.view.main.MainPanel', {
    extend: 'Ext.panel.Panel',
    alias: 'view.main.MainPanel',

    requires: [
        'Koala.view.main.FormMenuPanel',
        'Koala.view.main.MainController'
    ],

    controller: 'main.MainController',

    layout: 'border',

    defaults: {},

    title: 'Koala',

    initComponent: function () {
        var me = this;

        Ext.applyIf(me, {
            items: [
                Ext.create('view.main.FormMenuPanel', {
                    region: 'west',
                    listeners: {
                        onIncCategoryClick: 'onIncCategoryClick',
                        onExpTagClick: 'onExpTagClick',
                        onIncomeClick: 'onIncomeClick',
                        onExpenseClick: 'onExpenseClick'
                    }
                }),
                {
                    region: 'center',
                    xtype: 'panel',
                    reference: 'formHolder',
                    bodyPadding: 5,
                    items: [
                        {
                            xtype: 'panel',
                            html: 'Welcome!'
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    },

    listeners: {
        afterrender: 'onAfterRender'
    }

});