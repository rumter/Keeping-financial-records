Ext.define('Koala.store.ExpenseStore', {
    extend: 'Ext.data.Store',
    alias: 'store.ExpenseStore',

    model: 'Koala.model.ExpenseModel',

    proxy: {
        type: 'ajax',
        url: 'expense/list',
        reader: {
            type: 'json',
            rootProperty: 'data.items',
            totalProperty: 'data.total'
        }
    },

    remoteSort: true,
    autoLoad: true

});