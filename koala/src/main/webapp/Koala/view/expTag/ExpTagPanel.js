Ext.define('Koala.view.expTag.ExpTagPanel', {
    extend: 'Ext.panel.Panel',
    alias: 'view.expTag.ExpTagPanel',

    requires: [
        'Koala.store.ExpTagStore',
        'Koala.view.expTag.ExpTagController'
    ],

    controller: 'expTag.ExpTagController',

    //title: 'Теги расходов',

    initComponent: function () {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'gridpanel',
                    reference: 'expTagGrid',
                    minHeight: 400,
                    split: true,
                    border: true,
                    store: Ext.create('store.ExpTagStore'),
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
                    reference: 'expTagEditForm',
                    border: true,
                    defaultType: 'textfield',
                    disabled: true,
                    items: [
                        {
                            reference: 'expTagId',
                            name: 'expTagId',
                            fieldLabel: 'ID',
                            padding: 5,
                            hidden: true,
                            width: '99%'
                        },
                        {
                            reference: 'expTagTitle',
                            name: 'expTagTitle',
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
