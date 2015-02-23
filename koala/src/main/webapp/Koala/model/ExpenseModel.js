Ext.define('Koala.model.ExpenseModel', {
    extend: 'Ext.data.Model',
    alias: 'model.ExpenseModel',

    fields: [
        {name: 'id'},
        {name: 'occured'},
        {name: 'amount'},
        {name: 'description'}
    ]

});
