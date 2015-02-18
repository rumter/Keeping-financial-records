Ext.define('Koala.model.ExpenseModel', {
    extend: 'Ext.data.Model',
    alias: 'model.ExpenseModel',

    fields: [
        {name: 'id'},
        {name: 'expCategoryId'},
        {name: 'occured'},
        {name: 'amount'},
        {name: 'description'}
    ]

});
