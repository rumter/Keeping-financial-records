(function () {

    /**
     * Утилиты
     */
    Ext.define('Koala.Utils', {
        extend: 'Ext.emptyFn',

        /**
         * Общий формат дат/времени
         */
        DATE_TIME_FORMAT: 'd.m.Y H:i',

        /**
         * Получить HTML-код заголовка
         *
         * @param str
         * @returns {string}
         */
        getHeaderStringHTML: function (str) {
            return '<span style="color:rgb(21, 127, 204);font-size:15px;font-weight:300;font-family:helvetica,arial,verdana,sans-serif;line-height:16px;">' + str + '</span>';
        },

        /**
         * Подсветить найденный фрагмент в тексте
         * <p/>
         * Возвращает HTML
         *
         * @param text
         * @param search
         * @returns {*}
         */
        highlightSearch: function (text, search) {
            if (search == null || search == '')
                return text;

            var index = text.toUpperCase().indexOf(search.toUpperCase());
            if (index < 0)
                return text;

            text = text.substr(0, index) + "<span style='color:rgb(21,127,204)'>"
                + text.substr(index, search.length) + "</span>" + text.substr(index + search.length);

            return text;
        },


        /**
         * Получить tbar заданной panel
         *
         * @param panel
         * @returns {Ext.toolbar.Toolbar}
         */
        getTBar: function (panel) {
            var ret = null;
            panel.getDockedItems().forEach(function (dockItem) {
                if (ret == null && dockItem != null && dockItem.dock == 'top') {
                    ret = dockItem;
                }
            });
            return ret;
        },

        /**
         * Получить bbar заданной panel
         *
         * @param panel
         * @returns {Ext.toolbar.Toolbar}
         */
        getBBar: function (panel) {
            var ret = null;
            panel.getDockedItems().forEach(function (dockItem) {
                if (ret == null && dockItem != null && dockItem.dock == 'bottom') {
                    ret = dockItem;
                }
            });
            return ret;
        },

        /**
         * ajax-запрос, ответ в JSON
         * <p/>
         * Примеры запросов:
         * utils.ajax('GET', 'url/controller/method'});
         * utils.ajax('GET', 'url/controller/method', {params:{}});
         * utils.ajax('GET', 'url/controller/method', {success: function(response){}});
         * utils.ajax('GET', 'url/controller/method', {params:{}, success: function(response){}});
         */
        ajax: function (method, url, arg) {
            Ext.Ajax.request({
                url: url,
                method: method,
                params: (arg && arg.params) || {},
                success: function (result) {
                    var response = Ext.decode(result.responseText);
                    if (response.status == "success") {
                        arg && arg.success && arg.success(response);
                    }
                    else {
                        if (arg && arg.error) {
                            arg.error(response);
                        } else {
                            Ext.Msg.show({
                                title: "Ошибка",
                                msg: response.message,
                                icon: Ext.MessageBox.ERROR,
                                buttons: Ext.MessageBox.OK
                            });
                        }
                    }
                },
                failure: function (result, request) {
                    if (arg && arg.failure) {
                        arg.failure(result, request);
                    } else {
                        Ext.Msg.show({
                            title: "Ошибка",
                            msg: "При обработке запроса произошла ошибка",
                            icon: Ext.MessageBox.ERROR,
                            buttons: Ext.MessageBox.OK
                        });
                    }
                }
            });
        },

        /**
         * GET ajax запрос
         * <p/>
         * Примеры запросов:
         * utils.get('url/controller/method'});
         * utils.get('url/controller/method', {params:{}});
         * utils.get('url/controller/method', {success: function(response){}});
         * utils.get('url/controller/method', {params:{}, success: function(response){}});
         */
        get: function (url, arg) {
            this.ajax("GET", url, arg);
        },

        /**
         * POST ajax запрос
         * <p/>
         * Примеры запросов:
         * utils.post('url/controller/method'});
         * utils.post('url/controller/method', {params:{}});
         * utils.post('url/controller/method', {success: function(response){}});
         * utils.post('url/controller/method', {params:{}, success: function(response){}});
         */
        post: function (url, arg) {
            this.ajax("POST", url, arg);
        },

        /**
         * Копировать данные одного объекта в другой
         * <p/>
         * Копируются только поля, которые есть в объекте obj и в объекте data.
         * <p/>
         * Если задан notNullable = true, то копируются только поля не равные null.
         *
         * @param obj
         * @param data
         * @param notNullable
         */
        applyData: function (obj, data, notNullable) {
            notNullable = (Ext.isDefined(notNullable) && notNullable === true);
            for (key in obj) {
                if (obj.hasOwnProperty(key) && data.hasOwnProperty(key)) {
                    if (Ext.isDefined(data[key])) {
                        if (!(notNullable && data[key] === null)) {
                            obj[key] = data[key];
                        }
                    }
                }
            }
        }

    });

    var ns = window;

    ns.utils = ns.utils || Ext.create('Koala.Utils');

})();