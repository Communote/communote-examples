(function(namespace) {

    var HelloWorldWidget = new Class({
        Extends: C_Widget,
        /*
        First part "plugin/" is required and marks the widget as one that is provided by a plugin.
        The maven placeholder is needed to create an unique widget group name based on the name of the OSGi bundle and
        will be replaced when building the plugin.
        */
        widgetGroup: 'plugin/${maven-symbolicname}',

        //This function prints out the input value via a notification
        showSuccessMessage: function() {
            var message = this.domNode.getElementById(this.widgetId + '_message').get('value');
            showNotification(NOTIFICATION_BOX_TYPES.success, null, message);
        }
    });

    // to register the widget constructor within the Communote namespace
    namespace.addConstructor('HelloWorldWidget', HelloWorldWidget);

})(window.runtimeNamespace);