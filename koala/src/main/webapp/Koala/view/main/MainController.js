Ext.define('Koala.view.main.MainController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.main.MainController',

    requires: [
        'Koala.view.incCategory.IncCategoryPanel',
        'Koala.view.expCategory.ExpCategoryPanel',
        'Koala.view.stream.StreamPanel'
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
    onExpCategoryClick: function () {
        var me = this;
        var formHolder = me.lookupReference('formHolder');
        formHolder.removeAll();
        formHolder.add(Ext.create('view.expCategory.ExpCategoryPanel'));
    },

    /**
     * Нажатие на пункт меню "Доходы и расходы"
     */
    onIncExpClick: function () {
        var me = this;
        var formHolder = me.lookupReference('formHolder');
        formHolder.removeAll();
        formHolder.add(Ext.create('view.stream.StreamPanel'));
    }

});
