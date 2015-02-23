Ext.define('Koala.store.IncomeStore', {
    extend: 'Ext.data.Store',
    alias: 'store.IncomeStore',

    model: 'Koala.model.IncomeModel',

    proxy: {
        type: 'ajax',
        url: 'income/list',
        reader: {
            type: 'json',
            rootProperty: 'data.items',
            totalProperty: 'data.total'
        }
    },

    remoteSort: true,
    autoLoad: true

});