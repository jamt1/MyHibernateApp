Ext.application({
    name: 'Catalog',

    views: [
        'AddFormView',
        'CatalogView',
        'GridView',
    ],

    controllers : [
        'CatalogController'
    ],

    stores : [
        'CatalogStore'
    ],

    launch: function () {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: {
                xtype  : 'CatalogView'
            }
        });
    }
});