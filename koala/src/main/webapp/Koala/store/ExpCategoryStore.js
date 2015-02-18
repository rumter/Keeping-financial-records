Ext.define('Koala.store.ExpCategoryStore', {
    extend: 'Ext.data.Store',
    alias: 'store.ExpCategoryStore',

    model: 'Koala.model.ExpCategoryModel',

    proxy: {
        type: 'ajax',
        url: 'expCategory/list',
        reader: {
            type: 'json',
            rootProperty: 'data.items',
            totalProperty: 'data.total'
        }
    },

    remoteSort: true,
    autoLoad: true

});