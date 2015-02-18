Ext.define('Koala.view.incCategory.IncCategoryController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.incCategory.IncCategoryController',

    /**
     * Действия после отрисовки компонента
     */
    onAfterRender: function () {
    },

    /**
     * Выбор записи в таблице
     *
     * @param selection
     */
    onSelectRow: function (sel, selectedData) {
        console.log(selectedData);
    }

});
