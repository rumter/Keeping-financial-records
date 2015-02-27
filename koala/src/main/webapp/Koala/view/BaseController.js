Ext.define('Koala.view.BaseController', {
    extend: 'Ext.app.ViewController',

    //***************************** Утилиты *****************************

    /**
     * Поиск компонентов страницы
     *
     * @param ref
     * @returns {*}
     * @protected
     */
    _lookup: function (ref) {
        var me = this;
        return me.lookupReference(ref);
    },

    /**
     * Форматировать дату перед отображением
     *
     * @param timestamp
     * @returns {*}
     * @protected
     */
    _formatDateForView: function (timestamp) {
        var date = Ext.Date.add(new Date(timestamp), Ext.Date.HOUR, 12);
        return Ext.Date.format(date, utils.DATE_FORMAT);
    },

    /**
     * Форматировать дату перед сохранением
     *
     * @param dateTime
     * @returns {*}
     * @protected
     */
    _formatDateForSave: function (dateTime) {
        return Ext.Date.format(new Date(dateTime), utils.DATE_TIME_FORMAT);
    },

    //***************************** Компоненты страницы *****************************

    /**
     * Получить грид страницы
     *
     * @abstract
     *
     * @returns {null}
     * @protected
     */
    _getGrid: function () {
        return null;
    },

    /**
     * Получить форму редактирования
     *
     * @abstract
     *
     * @returns {null}
     * @protected
     */
    _getEditForm: function () {
        return null;
    },

    /**
     * Получить кнопку "Добавить" из toolbar
     *
     * @abstract
     *
     * @returns {null}
     * @protected
     */
    _getAddToolBtn: function () {
        return null;
    },

    /**
     * Получить кнопку "Редактировать" из toolbar
     *
     * @abstract
     *
     * @returns {null}
     * @protected
     */
    _getEditToolBtn: function () {
        return null;
    },

    /**
     * Получить кнопку "Удалить" из toolbar
     *
     * @abstract
     *
     * @returns {null}
     * @protected
     */
    _getDelToolBtn: function () {
        return null;
    },

    /**
     * Получить название записи по её данным
     *
     * @abstract
     *
     * @param data
     * @protected
     */
    _getRecordTitle: function (data) {
        return null;
    },

    //***************************** Работа с гридом *****************************

    /**
     * Получить Store грида страницы
     *
     * @returns {*}
     * @protected
     */
    _getGridStore: function () {
        var me = this;
        var grid = me._getGrid();
        if (grid != null) {
            return grid.getStore();
        }
        return null;
    },

    /**
     * Получить данные выделеной в гриде строки
     *
     * @returns {*}
     * @protected
     */
    _getSelectedRow: function () {
        var me = this;
        var grid = me._getGrid();
        if (grid != null) {
            var selected = grid.getSelectionModel().getSelection();
            if (selected != null && selected.length > 0) {
                return selected[0].data;
            }
        }
        return null;
    },

    /**
     * Получить полные данные выделеной в гриде строки
     *
     * @returns {*}
     * @protected
     */
    _getSelectedData: function () {
        var me = this;
        var selectedRow = me._getSelectedRow();
        var gridStore = me._getGridStore();
        if (selectedRow != null && selectedRow.id != null && gridStore != null) {
            var record = gridStore.getById(selectedRow.id);
            return record ? record.data : null;
        }
        return null;
    },

    /**
     * Обновить грид
     *
     * @public
     */
    _load: function () {
        var me = this;
        me._getGridStore().load();
        me._clearAndCancelForm();
    },

    //***************************** Работа с формой редактирования *****************************

    /**
     * Заполнить форму редактирования значениями выбранной записи
     *
     * @abstract
     *
     * @protected
     */
    _fillEditFormBySelectedData: function (data) {
    },

    /**
     * Очистить значения полей формы редактирования и выключить её
     *
     * @protected
     */
    _clearAndCancelForm: function () {
        var me = this;
        var form = me._getEditForm();
        form.reset();
        form.disable();
    },

    /**
     * Заполнить форму редактирования значениями записи выбранной строки
     *
     * @protected
     */
    _fillEditFormBySelected: function () {
        var me = this;
        var data = me._getSelectedData();
        if (data != null) {
            me._fillEditFormBySelectedData(data);
        } else {
            me._clearAndCancelForm();
        }
    },

    //***************************** Обработка данных *****************************

    /**
     * Проверить введенные в форму данные перед сохранением
     *
     * @protected
     */
    _validate: function () {
        return true;
    },

    /**
     * Сохранить форму редактирования
     *
     * @abstract
     *
     * @protected
     */
    _save: function () {
    },

    /**
     * Удалить выбранную запись
     *
     * @abstract
     *
     * @protected
     */
    _delete: function () {
    },

    //***************************** События *****************************

    /**
     * Выбор записи в таблице
     *
     * @param selection
     */
    onSelectRow: function () {
        var me = this;
        me._getEditToolBtn().enable();
        me._getDelToolBtn().enable();
        me._fillEditFormBySelected();
    },

    /**
     * Событие при нажатии на кнопку "Добавить" из toolbar
     */
    onAdd: function () {
        var me = this;
        me._getEditForm().reset();
        me._getEditForm().enable();
    },

    /**
     * Событие при нажатии на кнопку "Редактировать" из toolbar
     */
    onEdit: function () {
        var me = this;
        var selectedData = me._getSelectedRow();
        if (selectedData != null) {
            me._fillEditFormBySelected();
            me._getEditForm().enable();
        } else {
            me._clearAndCancelForm();
        }
    },

    /**
     * Событие при нажатии на кнопку "Удалить" из toolbar
     */
    onDel: function () {
        var me = this;
        var data = me._getSelectedData();
        if (data != null) {
            var title = me._getRecordTitle(data);
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

    /**
     * Событие при нажатии на кнопку "Отмена" из формы редактирования
     */
    onCancel: function () {
        var me = this;
        me._clearAndCancelForm();
    },

    /**
     * Событие при нажатии на кнопку "Сохранить" из формы редактирования
     */
    onSubmit: function () {
        var me = this;
        if (me._validate()) {
            me._save();
        }
    }

});