Ext.define('Koala.view.main.MainController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.main.MainController',

    requires: [
        'Koala.view.incCategory.IncCategoryPanel',
        'Koala.view.expTag.ExpTagPanel',
        'Koala.view.income.IncomePanel'
    ],

    /**
     * Действия после отрисовки компонента
     */
    onAfterRender: function () {
        this.onIncCategoryClick();
    },

    /**
     * Нажатие на пункт меню "Категория доходов"
     */
    onIncCategoryClick: function () {
        var me = this;
        var formHolder = me.lookupReference('formHolder');
        formHolder.removeAll();
        formHolder.add(Ext.create('view.incCategory.IncCategoryPanel'));
    },

    /**
     * Нажатие на пункт меню "Категории расходов"
     */
    onExpTagClick: function () {
        var me = this;
        var formHolder = me.lookupReference('formHolder');
        formHolder.removeAll();
        formHolder.add(Ext.create('view.expTag.ExpTagPanel'));
    },

    /**
     * Нажатие на пункт меню "Доходы и расходы"
     */
    onIncomeClick: function () {
        var me = this;
        var formHolder = me.lookupReference('formHolder');
        formHolder.removeAll();
        formHolder.add(Ext.create('view.income.IncomePanel'));
    }

});
