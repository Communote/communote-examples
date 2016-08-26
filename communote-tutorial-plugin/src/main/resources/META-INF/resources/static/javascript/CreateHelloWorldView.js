// Jumps in when the namespace communote is defined and the main layout is loaded
if (window.communote && communote.environment && communote.environment.page == 'main') {
    // Add a callback that is invoked before the Communote JavaScript component is initialized
    communote.initializer.addBeforeInitCallback(function() {
        var widgets, views;
        // parentViewId defines where the new subview should be added (other parent views defined by the core are for example topicsOverview or topicSelected)
        var parentViewId = 'notesOverview';
        // Name of the new subview
        var viewName = 'helloWorld';
        var subViewName = parentViewId + '_' + viewName;

        // Register view link to horizontal navigation bar
        communote.configuration.mainPageContexts[parentViewId].push(viewName);

        // Get list of all views
        views = communote.configuration.mainPageViewManagerConfig.views;

        // Add the new view to the list of views
        views[subViewName] = {
            // When the user changes the view and 'hide' is defined the view container will be hidden.
            // Another option is 'delete' for deleting it from the DOM.
            previousViewAction: 'hide',
            // List all the widgets that should be shown in the new view
            visibleWidgets: ['EntityChooser','VerticalNavigation', 'HorizontalNavigation', 'GlobalIdShowBannerImage', 'HelloWorld']
            // You can also add parentViewId: 'insertMainView' as an option to extend the visible widgets of a main view
        }

        // Get list of all widgets
        widgets = communote.configuration.mainPageViewManagerConfig.widgets;

        // Add our HelloWorld widget to the list of all registered widgets
        widgets['HelloWorld'] = {
            // The widgetType is used to identify the Java and JavaScript widget class. Moreover,
            // a CSS class with that name is added to the container of the widget.
            widgetType: 'HelloWorldWidget',
            // The CSS selector defines where the widget should be injected
            containerSelector: '#cn-list-posts'
        };
    });
}