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
            text: 'Категории расходов',
            handler: 'onExpCategoryClick'
        },
        {
            text: 'Доходы и расходы',
            handler: 'onIncExpClick'
        }
    ]

});