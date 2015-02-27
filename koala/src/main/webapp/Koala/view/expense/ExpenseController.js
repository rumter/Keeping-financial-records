Ext.define('Koala.view.expense.ExpenseController', {
    extend: 'Koala.view.BaseController',
    alias: 'controller.expense.ExpenseController',

    _getGrid: function () {
        return this._lookup('expenseGrid');
    },
    _getEditForm: function () {
        return this._lookup('expenseEditForm');
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
        return 'дата: "' + this._formatDateForView(data.occured) + '", сумма: "' + data.amount + '"';
    },

    _fillEditFormBySelectedData: function (data) {
        var me = this;
        me._lookup('expenseId').setValue(data.id);
        me._lookup('occured').setValue(me._formatDateForView(data.occured));
        me._lookup('amount').setValue(data.amount);
        me._lookup('description').setValue(data.description);
    },

    _validate: function () {
        var me = this;

        var occuredField = me._lookup('occured');
        var amountField = me._lookup('amount');

        occuredField.focus();
        amountField.focus();

        var occured = occuredField.getValue();
        var amount = amountField.getValue();

        var fieldsNotNull = [];
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
        var expense = {
            id: me._lookup('expenseId').getValue(),
            occured: me._formatDateForSave(me._lookup('occured').getValue()),
            amount: me._lookup('amount').getValue(),
            description: me._lookup('description').getValue()
        };
        utils.post('expense/save', {
            params: expense,
            success: function (response) {
                me._load();
            }
        });
    },

    _delete: function () {
        var me = this;
        var selectedData = me._getSelectedRow();
        var id = selectedData.id;
        utils.post('expense/delete', {
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
