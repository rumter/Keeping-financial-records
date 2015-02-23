Ext.define('Koala.model.IncomeModel', {
    extend: 'Ext.data.Model',
    alias: 'model.IncomeModel',

    fields: [
        {name: 'id'},
        {name: 'incCategoryId'},
        {name: 'incCategoryTitle'},
        {name: 'occured'},
        {name: 'amount'},
        {name: 'description'}
    ]

});
