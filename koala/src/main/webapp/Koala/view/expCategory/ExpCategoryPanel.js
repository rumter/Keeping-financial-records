Ext.define('Koala.view.expCategory.ExpCategoryPanel', {
    extend: 'Ext.panel.Panel',
    alias: 'view.expCategory.ExpCategoryPanel',

    requires: [
        'Koala.store.ExpCategoryStore',
        'Koala.view.expCategory.ExpCategoryController'
    ],

    controller: 'expCategory.ExpCategoryController',

    title: 'Категории расходов',

    initComponent: function () {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'gridpanel',
                    reference: 'expCategoryGrid',
                    minHeight: 500,
                    split: true,
                    border: true,
                    store: Ext.create('store.ExpCategoryStore'),
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
                    reference: 'expCategoryEditForm',
                    border: true,
                    defaultType: 'textfield',
                    disabled: true,
                    items: [
                        {
                            reference: 'expCategoryId',
                            name: 'expCategoryId',
                            fieldLabel: 'ID',
                            padding: 5,
                            hidden: true,
                            width: '99%'
                        },
                        {
                            reference: 'expCategoryTitle',
                            name: 'expCategoryTitle',
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
