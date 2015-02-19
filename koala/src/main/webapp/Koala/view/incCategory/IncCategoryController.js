Ext.define('Koala.view.incCategory.IncCategoryController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.incCategory.IncCategoryController',

    _lookup: function (ref) {
        var me = this;
        return me.lookupReference(ref);
    },

    _getSelectedRow: function () {
        var me = this;
        var selected = me._lookup('incCategoryGrid').getSelectionModel().getSelection();
        if (selected != null && selected.length > 0) {
            return selected[0].data;
        }
        return null;
    },

    _clearAndCancelForm: function () {
        var me = this;
        me._lookup('incCategoryEditForm').reset();
        me._lookup('incCategoryEditForm').disable();
    },

    _load: function () {
        var me = this;
        me._lookup('incCategoryGrid').getStore().load();
        me._clearAndCancelForm();
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
    },

    /**
     * Выбор записи в таблице
     *
     * @param selection
     */
    onSelectRow: function (sel, selectedData) {
        var me = this;
        me._lookup('edit').enable();
        me._lookup('del').enable();
    },

    onAdd: function () {
        var me = this;
        me._lookup('incCategoryEditForm').reset();
        me._lookup('incCategoryEditForm').enable();
    },
    onEdit: function () {
        var me = this;
        var selectedData = me._getSelectedRow();
        if (selectedData != null) {
            me._lookup('incCategoryId').setValue(selectedData.id);
            me._lookup('incCategoryTitle').setValue(selectedData.title);
            me._lookup('incCategoryEditForm').enable();
        } else {
            me._clearAndCancelForm();
        }
    },
    onDel: function () {
        var me = this;
        var selectedData = me._getSelectedRow();
        if (selectedData != null) {
            var title = selectedData.title;
            Ext.Msg.show({
                title: 'Удалить запись?',
                message: 'Вы действительно хотите удалить категорию "' + title + '"',
                buttons: Ext.Msg.YESNO,
                icon: Ext.Msg.QUESTION,
                fn: function (btn) {
                    if (btn == 'yes') {
                        me._delete();
                    }
                }
            });
        } else {
            me._clearAndCancelForm();
        }
    },

    onCancel: function () {
        var me = this;
        me._clearAndCancelForm();
    },

    onSubmit: function () {
        var me = this;
        if (me._validate()) {
            me._save();
        }
    }

});
