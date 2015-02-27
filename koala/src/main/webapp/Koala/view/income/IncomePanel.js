Ext.define('Koala.view.income.IncomePanel', {
    extend: 'Ext.panel.Panel',
    alias: 'view.income.IncomePanel',

    requires: [
        'Koala.store.IncomeStore',
        'Koala.store.IncCategoryStore',
        'Koala.view.income.IncomeController'
    ],

    controller: 'income.IncomeController',

    //title: 'Доходы',

    initComponent: function () {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'gridpanel',
                    reference: 'incomeGrid',
                    id: 'incomeGrid',
                    minHeight: 400,
                    split: true,
                    border: true,
                    store: Ext.create('store.IncomeStore'),
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
                            text: 'ID категории',
                            dataIndex: 'incCategoryId',
                            hidden: true
                        },
                        {
                            text: 'Категория',
                            dataIndex: 'incCategoryTitle'
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
                    reference: 'incomeEditForm',
                    border: true,
                    defaultType: 'textfield',
                    disabled: true,
                    defaults: {
                        padding: 5,
                        width: '99%'
                    },
                    items: [
                        {
                            reference: 'incomeId',
                            name: 'incomeId',
                            fieldLabel: 'ID',
                            hidden: true
                        },
                        {
                            reference: 'incCategoryId',
                            name: 'incCategoryId',
                            xtype: 'combobox',
                            allowBlank: false,
                            fieldLabel: 'Категория',
                            store: Ext.create('store.IncCategoryStore'),
                            queryModel: 'local',
                            displayField: 'title',
                            valueField: 'id'
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
