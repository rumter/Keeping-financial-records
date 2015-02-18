Ext.define('Koala.view.incCategory.IncCategoryPanel', {
    extend: 'Ext.panel.Panel',
    alias: 'view.incCategory.IncCategoryPanel',

    requires: [
        'Koala.store.IncCategoryStore',
        'Koala.view.incCategory.IncCategoryController'
    ],

    initComponent: function () {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'gridpanel',
                    referense: 'incCategoryGrid',
                    minHeight: 200,
                    split: true,
                    store: Ext.create('store.IncCategoryStore'),
                    columns: [
                        {
                            text: 'ID',
                            dataIndex: 'id',
                            hidden: true
                        },
                        {
                            text: 'Название',
                            width: 300,
                            dataIndex: 'title'
                        }
                    ],
                    listeners: {
                        select: 'onSelectRow'
                    }
                }
            ]
        });

        me.callParent(arguments);
    },

    listeners: {
        afterrender: 'onAfterRender'
    }

});
