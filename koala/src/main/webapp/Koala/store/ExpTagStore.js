Ext.define('Koala.store.ExpTagStore', {
    extend: 'Ext.data.Store',
    alias: 'store.ExpTagStore',

    model: 'Koala.model.ExpTagModel',

    proxy: {
        type: 'ajax',
        url: 'expTag/list',
        reader: {
            type: 'json',
            rootProperty: 'data.items',
            totalProperty: 'data.total'
        }
    },

    remoteSort: true,
    autoLoad: true

});