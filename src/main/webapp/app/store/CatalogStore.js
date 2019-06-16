Ext.define('Catalog.store.CatalogStore', {
    extend: 'Ext.data.Store',
    requires : [
        'Catalog.model.CatalogModel'
    ],
    model: 'Catalog.model.CatalogModel',
    autoLoad: true,
    autoSync: true,
    proxy: {
        type: 'rest',
        api: {
            create: 'order',
            read: 'order',
            destroy: 'order',
            update: 'order'
        },
        reader: {
            type: 'json',
            root: 'data',
            successProperty: 'success'
        },
        writer: {
            type: 'json',
            writeAllFields: true
        }

    }
})