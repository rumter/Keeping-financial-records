Ext.define('Koala.view.incCategory.IncCategoryController', {
    extend: 'Koala.view.BaseController',
    alias: 'controller.incCategory.IncCategoryController',

    _getGrid: function () {
        return this._lookup('incCategoryGrid');
    },
    _getEditForm: function () {
        return this._lookup('incCategoryEditForm');
    },
    _getAddToolBtn: function () {
        return this._lookup('add');
    },
    _getEditToolBtn: function () {
        return this._lookup('edit');
    },
    _getDelToolBtn: function () {
        return this._lookup('del');
    },

    _getRecordTitle: function (data) {
        return 'категория: ' + data.title;
    },

    _fillEditFormBySelectedData: function (data) {
        var me = this;
        me._lookup('incCategoryId').setValue(data.id);
        me._lookup('incCategoryTitle').setValue(data.title);
    },

    _validate: function () {
        var me = this;
        me._lookup('incCategoryTitle').focus();
        var title = me._lookup('incCategoryTitle').getValue();
        if (title == null || title.length == 0) {
            var label = me._lookup('incCategoryTitle').getFieldLabel();
            Ext.Msg.show({
                title: 'Форма заполнена неверно',
                message: 'Необходимо заполнить поле "' + label + '"',
                icon: Ext.Msg.WARNING,
                buttons: Ext.Msg.OK
            });
            return false;
        }
        return true;
    },

    _save: function () {
        var me = this;
        var incCategory = {
            id: me._lookup('incCategoryId').getValue(),
            title: me._lookup('incCategoryTitle').getValue()
        };
        utils.post('incCategory/save', {
            params: incCategory,
            success: function (response) {
                me._load();
            }
        });
    },

    _delete: function () {
        var me = this;
        var selectedData = me._getSelectedRow();
        var id = selectedData.id;
        utils.post('incCategory/delete', {
            params: {
                id: id
            },
            success: function (response) {
                me._load();
            }
        });
    },

    /**
     * Действия после отрисовки компонента
     */
    onAfterRender: function () {
        var me = this;
    }

});
