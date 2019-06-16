Ext.define('Catalog.controller.CatalogController', {
    extend: 'Ext.app.Controller',

    refs: [
        {selector: 'GridView',
            ref: 'GridView'},
        {selector: 'GridView button[action="add"]',
            ref: 'GridAdd'},
        {selector: 'GridView button[action="delete"]',
            ref: 'GridDelete'},
        {selector: 'addFormView',
            ref: 'addFormView'},
        {selector: 'CatalogView',
            ref: 'CatalogView'},
        {selector: 'addFormView textfield[name=name] ',
            ref: 'addFormName'},
        {selector: 'addFormView textfield[name=whom]',
            ref: 'addFormWhom'},
        {selector: 'addFormView textfield[name=whom_from]',
            ref: 'addFormWhom_from'},
        {selector: 'addFormView textfield[name=status]',
            ref: 'addFormStatus'},
        {selector: 'addFormView button[action=save]',
            ref: 'addFormSave'}
    ],

    init: function () {
        this.control({
            'GridView  button[action=add]': {
                click: this.onAdd
            },
            'GridView  button[action=delete]': {
                click: this.onDel
            },
            'GridView': {
                cellclick: this.onLineGrid
            },
            'addFormView  button[action=save]': {
                click: this.onSave
            },
            'addFormView  textfield[name=name]': {
                change: this.onValidation
            },
            'addFormView  textfield[name=whom]': {
                change: this.onValidation
            },
            'addFormView  textfield[name=whom_from]': {
                change: this.onValidation
            },
            'addFormView  textfield[name=status]': {
                change: this.onValidation
            }
        });
    },

    onSave: function (button) {
        var me = this;
        var Model = Ext.create('Catalog.model.CatalogModel');
        Model.set(this.getAddFormView().down('form').getValues());
        Model.save({
            success: function (operation, response) {
                var objAjax = operation.data;
                Ext.getStore('CatalogStore').add(objAjax);
                me.getAddFormView().close();
            },
            failure: function (dummy, result) {
                Ext.MessageBox.show({
                    title: 'Дубликат!',
                    msg: 'Такая заявка уже существуют',
                    buttons: Ext.Msg.OK,
                    icon: Ext.Msg.ERROR
                });
            }

        });
    },

    onAdd: function () {
        Ext.widget('addFormView');
    },

    onDel: function () {
        var sm = this.getGridView().getSelectionModel();
        var rs = sm.getSelection();
        this.getGridView().store.remove(rs[0]);
        this.getGridView().store.commitChanges();
        this.getGridDelete().disable();
    },
    onLineGrid: function () {
        this.getGridDelete().enable();
    },

    onValidation: function () {
        if (this.getAddFormName().validate() && this.getAddFormWhom().validate()&& this.getAddFormWhom_from().validate()&& this.getAddFormStatus().validate()) {
            this.getAddFormSave().enable();
        } else {
            this.getAddFormSave().disable();
        }
    }

});