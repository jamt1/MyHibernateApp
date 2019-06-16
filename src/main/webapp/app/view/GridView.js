Ext.define('Catalog.view.GridView', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.GridView',
    width: 400,
    height: 300,
    frame: true,
    store: 'CatalogStore',
    iconCls: 'icon-user',
    viewConfig:{
        markDirty:false
    },
    columns: [
        {
            text: 'Номер заявки',
            flex: 1,
            sortable: true,
            dataIndex: 'id',
            editor: {
                xtype:'textfield',
                allowBlank: false,
                blankText: 'Это поле должно быть заполнено'
            }
        },
        {
            text: 'Описание',
            flex: 1,
            sortable: true,
            dataIndex: 'name',
            editor: {
                xtype:'textfield',
                allowBlank: false,
                blankText: 'Это поле должно быть заполнено'
            }
        },
        {
            flex: 1,
            text: 'Кому',
            sortable: true,
            dataIndex: 'whom',
            editor: {
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
                queryMode: 'local',
                displayField: 'firstname',
                allowBlank: false,
                blankText: 'Это поле должно быть заполнено',
                editable:false
            },
        },
        {
            flex: 1,
            text: 'От кого',
            sortable: true,
            dataIndex: 'whom_from',
            editor: {
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
                queryMode: 'local',
                displayField: 'firstname',
                allowBlank: false,
                blankText: 'Это поле должно быть заполнено',
                editable:false
            },
        },
        {
            flex: 1,
            text: 'Статус',
            sortable: true,
            dataIndex: 'status',
            editor: {
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
                queryMode: 'local',
                displayField: 'name',
                allowBlank: false,
                blankText: 'Это поле должно быть заполнено',
                editable:false
            }
        },
    ],
    plugins: [
        Ext.create('Ext.grid.plugin.RowEditing', {
            clicksToEdit: 2,
            saveBtnText: 'Сохранить',
            cancelBtnText: 'Отменить'
        })
    ],
    selType: 'rowmodel',
    dockedItems: [
        {
            xtype: 'toolbar',
            items: [
                {
                    text: 'Добавить',
                    action: 'add',
                    iconCls: 'icon-add'
                },
                '-',
                {
                    action: 'delete',
                    text: 'Удалить',
                    iconCls: 'icon-delete',
                    disabled: true
                }
            ]
        }
    ]
});

