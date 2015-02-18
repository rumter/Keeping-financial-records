Ext.define('Koala.view.main.FormMenuController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.main.FormMenuController',

    /**
     * Нажатие на пункт меню "Категория доходов"
     */
    onIncCategoryClick: function () {
        var me = this;
        var view = me.getView();
        view.fireEvent("onIncCategoryClick");
    },

    /**
     * Нажатие на пункт меню "Категории расходов"
     */
    onExpCategoryClick: function () {
        var me = this;
        var view = me.getView();
        view.fireEvent("onExpCategoryClick");
    },

    /**
     * Нажатие на пункт меню "Доходы и расходы"
     */
    onIncExpClick: function () {
        var me = this;
        var view = me.getView();
        view.fireEvent("onIncExpClick");
    }

});
