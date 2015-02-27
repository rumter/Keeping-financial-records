Ext.define('Koala.view.expense.ExpensePanel', {
    extend: 'Ext.panel.Panel',
    alias: 'view.expense.ExpensePanel',

    requires: [
        'Koala.store.ExpenseStore',
        'Koala.view.expense.ExpenseController'
    ],

    controller: 'expense.ExpenseController',

    //title: 'Расходы',

    initComponent: function () {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'gridpanel',
                    reference: 'expenseGrid',
                    id: 'expenseGrid',
                    minHeight: 400,
                    split: true,
                    border: true,
                    store: Ext.create('store.ExpenseStore'),
                    defaults: {
                        width: 200
                    },
                    columns: [
                        {
                            text: 'ID',
                            dataIndex: 'id',
                            hidden: true
                        },
                        {
                            text: 'Дата',
                            dataIndex: 'occured',
                            renderer: function (value) {
                                return me.getController()._formatDateForView(value);
                            }
                        },
                        {
                            text: 'Сумма',
                            dataIndex: 'amount'
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
                    reference: 'expenseEditForm',
                    border: true,
                    defaultType: 'textfield',
                    disabled: true,
                    defaults: {
                        padding: 5,
                        width: '99%'
                    },
                    items: [
                        {
                            reference: 'expenseId',
                            name: 'expenseId',
                            fieldLabel: 'ID',
                            hidden: true
                        },
                        {
                            reference: 'occured',
                            name: 'occured',
                            xtype: 'datefield',
                            allowBlank: false,
                            fieldLabel: 'Дата',
                            value: new Date(),
                            format: utils.DATE_FORMAT
                        },
                        {
                            reference: 'amount',
                            name: 'amount',
                            allowBlank: false,
                            fieldLabel: 'Сумма'
                        },
                        {
                            reference: 'description',
                            name: 'description',
                            xtype: 'textarea',
                            fieldLabel: 'Описание'
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
