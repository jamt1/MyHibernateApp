Ext.define('Catalog.model.CatalogModel', {
    extend: 'Ext.data.Model',
    fields: ['name', 'whom', 'whom_from', 'status'],
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
            writeAllFields: true,
            writeRecordId: false
        }

    }
});