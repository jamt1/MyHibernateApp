Ext.define('Catalog.view.CatalogView', {
    extend: 'Ext.panel.Panel',
    width: 500,
    height: 360,
    padding: 10,
    alias: 'widget.CatalogView',
    layout: 'border',
    items: [
        {
            xtype: 'GridView',
            region: 'center'
        },
        {
            xtype: 'panel',
            html: '<div style="font: normal 18px cursive"><center><font size = "10">Справочник</font></center></div>',
            region: 'north',
            height: 80
        },

    ],
    renderTo: Ext.getBody()
});