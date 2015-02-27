Ext.define('Koala.view.income.IncomeController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.income.IncomeController',

    _lookup: function (ref) {
        var me = this;
        return me.lookupReference(ref);
    },

    _formatDateForView: function (timestamp) {
        var date = Ext.Date.add(new Date(timestamp), Ext.Date.HOUR, 12);
        return Ext.Date.format(date, utils.DATE_FORMAT);
    },

    _formatDateForSave: function (dateTime) {
        return Ext.Date.format(new Date(dateTime), utils.DATE_TIME_FORMAT);
    },

    _getSelectedRow: function () {
        var me = this;
        var selected = me._lookup('incomeGrid').getSelectionModel().getSelection();
        if (selected != null && selected.length > 0) {
            return selected[0].data;
        }
        return null;
    },

    _clearAndCancelForm: function () {
        var me = this;
        me._lookup('incomeEditForm').reset();
        me._lookup('incomeEditForm').disable();
    },

    _load: function () {
        var me = this;
        me._lookup('incomeGrid').getStore().load();
        me._clearAndCancelForm();
    },
    _validate: function () {
        var me = this;

        var incCategoryIdField = me._lookup('incCategoryId');
        var occuredField = me._lookup('occured');
        var amountField = me._lookup('amount');

        incCategoryIdField.focus();
        occuredField.focus();
        amountField.focus();

        var incCategoryId = incCategoryIdField.getValue();
        var occured = occuredField.getValue();
        var amount = amountField.getValue();

        var fieldsNotNull = [];
        if (incCategoryId == null || incCategoryId.length == 0) {
            fieldsNotNull.push(incCategoryIdField.getFieldLabel());
        }
        if (occured == null || occured.length == 0) {
            fieldsNotNull.push(occuredField.getFieldLabel());
        }
        if (amount == null || amount.length == 0) {
            fieldsNotNull.push(amountField.getFieldLabel());
        }

        if (fieldsNotNull.length != 0) {
            var fieldsMsg = fieldsNotNull.join('", "');
            if (fieldsNotNull.length == 1) {
                fieldsMsg = 'поле "' + fieldsMsg + '"';
            } else {
                fieldsMsg = 'поля "' + fieldsMsg + '"';
            }
            Ext.Msg.show({
                title: 'Форма заполнена неверно',
                message: 'Необходимо заполнить ' + fieldsMsg,
                icon: Ext.Msg.WARNING,
                buttons: Ext.Msg.OK
            });
            return false;
        }
        return true;
    },
    _save: function () {
        var me = this;
        var income = {
            id: me._lookup('incomeId').getValue(),
            incCategoryId: me._lookup('incCategoryId').getValue(),
            occured: me._formatDateForSave(me._lookup('occured').getValue()),
            amount: me._lookup('amount').getValue(),
            description: me._lookup('description').getValue()
        };
        utils.post('income/save', {
            params: income,
            success: function (response) {
                me._load();
            }
        });
    },
    _delete: function () {
        var me = this;
        var selectedData = me._getSelectedRow();
        var id = selectedData.id;
        utils.post('income/delete', {
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
        me._lookup('incomeEditForm').reset();
        me._lookup('incomeEditForm').enable();
    },
    onEdit: function () {
        var me = this;
        var selectedData = me._getSelectedRow();
        if (selectedData != null) {
            me._lookup('incomeId').setValue(selectedData.id);
            me._lookup('incCategoryId').setValue(selectedData.incCategoryId);
            me._lookup('occured').setValue(me._formatDateForView(selectedData.occured));
            me._lookup('amount').setValue(selectedData.amount);
            //me._lookup('description').setValue(selectedData.description);
            me._lookup('incomeEditForm').enable();
        } else {
            me._clearAndCancelForm();
        }
    },
    onDel: function () {
        var me = this;
        var data = me._getSelectedRow();
        if (data != null) {
            var title = 'категория: "' + data.incCategoryTitle + '", дата: "' + me._formatDateForView(data.occured) + '", сумма: "' + data.amount + '"';
            Ext.Msg.show({
                title: 'Удалить запись?',
                message: 'Вы действительно хотите удалить запись ' + title,
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
