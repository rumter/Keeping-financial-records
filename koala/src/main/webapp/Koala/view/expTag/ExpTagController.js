Ext.define('Koala.view.expTag.ExpTagController', {
    extend: 'Koala.view.BaseController',
    alias: 'controller.expTag.ExpTagController',

    _getGrid: function () {
        return this._lookup('expTagGrid');
    },
    _getEditForm: function () {
        return this._lookup('expTagEditForm');
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
        return 'тег: ' + data.title;
    },

    _fillEditFormBySelectedData: function (data) {
        var me = this;
        me._lookup('expTagId').setValue(data.id);
        me._lookup('expTagTitle').setValue(data.title);
    },

    _validate: function () {
        var me = this;
        me._lookup('expTagTitle').focus();
        var title = me._lookup('expTagTitle').getValue();
        if (title == null || title.length == 0) {
            var label = me._lookup('expTagTitle').getFieldLabel();
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
        var expTag = {
            id: me._lookup('expTagId').getValue(),
            title: me._lookup('expTagTitle').getValue()
        };
        utils.post('expTag/save', {
            params: expTag,
            success: function (response) {
                me._load();
            }
        });
    },

    _delete: function () {
        var me = this;
        var selectedData = me._getSelectedRow();
        var id = selectedData.id;
        utils.post('expTag/delete', {
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
