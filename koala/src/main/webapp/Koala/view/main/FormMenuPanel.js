Ext.define('Koala.view.main.FormMenuPanel', {
    extend: 'Ext.menu.Menu',
    alias: 'view.main.FormMenuPanel',
    plain: true,
    floating: false,

    requires: [
        'Koala.view.main.FormMenuController'
    ],

    controller: 'main.FormMenuController',

    defaults: {
        padding: 5
    },

    items: [
        {
            text: 'Категории доходов',
            reference: 'incCategoryBtn',
            handler: 'onIncCategoryClick'
        },
        {
            text: 'Теги расходов',
            handler: 'onExpTagClick'
        },
        {
            text: 'Доходы',
            handler: 'onIncomeClick'
        },
        {
            text: 'Расходы',
            handler: 'onExpenseClick'
        }
    ]

});