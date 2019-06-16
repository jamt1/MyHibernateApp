Ext.define('Catalog.view.AddFormView', {
    extend: 'Ext.window.Window',
    alias: 'widget.addFormView',
    autoShow: true,
    layout: 'fit',
    modal: true,
    items: [
        {
            bodyPadding: 10,
            xtype: 'form',
            items: [
                {
                    xtype: 'textfield',
                    name: 'name',
                    fieldLabel: 'Описание',
                    allowBlank: false,
                    blankText: 'Это поле должно быть заполнено'
                },
                {
                    xtype: 'combobox',
                    name: 'whom',
                    store :new Ext.data.Store({
                        autoLoad: true,
                        fields: [ 'firstname' ],
                        proxy: {
                            type: 'ajax',
                            url : 'Addressbook',
                            valueField: 'firstname',
                            displayField: 'firstname',
                            editable: false,
                            selectOnFocus: false,
                            preventRender: true,
                            forceSelection: true,
                            enableKeyEvents: true,
                            reader: {
                                type: 'json',
                                root : 'res'
                            }
                        }
                    }),
                    fieldLabel: 'Кому',
                    queryMode: 'local',
                    displayField: 'firstname',
                    allowBlank: false,
                    blankText: 'Это поле должно быть заполнено',
                    editable:false
                },
                {
                    xtype: 'combobox',
                    name: 'whom_from',
                    store :new Ext.data.Store({
                        autoLoad: true,
                        fields: [ 'firstname' ],
                        proxy: {
                            type: 'ajax',
                            url : 'Addressbook',
                            valueField: 'firstname',
                            displayField: 'firstname',
                            editable: false,
                            selectOnFocus: false,
                            preventRender: true,
                            forceSelection: true,
                            enableKeyEvents: true,
                            reader: {
                                type: 'json',
                                root : 'res'
                            }
                        }
                    }),
                    fieldLabel: 'От кого',
                    queryMode: 'local',
                    displayField: 'firstname',
                    allowBlank: false,
                    blankText: 'Это поле должно быть заполнено',
                    editable:false
                },
                {
                    xtype: 'combobox',
                    name: 'status',
                    store :new Ext.data.Store({
                        autoLoad: true,
                        fields: [ 'name' ],
                        proxy: {
                            type: 'ajax',
                            url : 'orderStatus',
                            valueField: 'name',
                            displayField: 'name',
                        editable: false,
                        selectOnFocus: false,
                        preventRender: true,
                        forceSelection: true,
                        enableKeyEvents: true,
                            reader: {
                                type: 'json',
                                root : 'res'
                            }
                        }
                    }),
                    fieldLabel: 'Статус',
                    queryMode: 'local',
                    displayField: 'name',
                    allowBlank: false,
                    blankText: 'Это поле должно быть заполнено',
                    editable:false
                },
            ]
        }
    ],
    buttons: [
        {
            text: 'Сохранить',
            action: 'save',
            disabled: true
        },
        {
            text: 'Отменить',
            handler: function () {
                this.up('window').close();
            }

        }
    ]
});
