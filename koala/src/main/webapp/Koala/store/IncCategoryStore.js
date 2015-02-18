Ext.define('Koala.store.IncCategoryStore', {
    extend: 'Ext.data.Store',
    alias: 'store.IncCategoryStore',

    model: 'Koala.model.IncCategoryModel',

    proxy: {
        type: 'ajax',
        url: 'incCategory/list',
        reader: {
            type: 'json',
            rootProperty: 'data.items',
            totalProperty: 'data.total'
        }
    },

    remoteSort: true,
    autoLoad: true

});