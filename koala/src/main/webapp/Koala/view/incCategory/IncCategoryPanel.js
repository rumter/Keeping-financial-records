Ext.define('Koala.view.incCategory.IncCategoryPanel', {
    extend: 'Ext.panel.Panel',
    alias: 'view.incCategory.IncCategoryPanel',

    requires: [
        'Koala.store.IncCategoryStore',
        'Koala.view.incCategory.IncCategoryController'
    ],

    controller: 'incCategory.IncCategoryController',

    title: 'Категории доходов',

    initComponent: function () {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'gridpanel',
                    reference: 'incCategoryGrid',
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
                    tbar: [
                        {
                            xtype: 'button',
                            reference: 'add',
                            text: 'Добавить',
                            handler: 'onAdd'
                        },
                        {
                            xtype: 'button',
                            reference: 'edit',
                            text: 'Редактировать',
                            handler: 'onEdit',
                            disabled: true
                        },
                        {
                            xtype: 'button',
                            reference: 'del',
                            text: 'Удалить',
                            handler: 'onDel',
                            disabled: true
                        }
                    ],
                    listeners: {
                        select: 'onSelectRow'
                    }
                },
                {
                    xtype: 'form',
                    reference: 'incCategoryEditForm',
                    border: true,
                    defaultType: 'textfield',
                    disabled: true,
                    items: [
                        {
                            reference: 'incCategoryId',
                            name: 'incCategoryId',
                            fieldLabel: 'ID',
                            padding: 5,
                            //hidden: true,
                            width: '99%'
                        },
                        {
                            reference: 'incCategoryTitle',
                            name: 'incCategoryTitle',
                            allowBlank: false,
                            fieldLabel: 'Название',
                            padding: 5,
                            width: '99%'
                        }
                    ],
                    buttonAlign: 'left',
                    buttons: [
                        {
                            text: 'Сохранить',
                            reference: 'submit',
                            handler: 'onSubmit'
                        },
                        {
                            text: 'Отмена',
                            handler: 'onCancel'
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
