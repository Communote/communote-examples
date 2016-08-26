// Jumps in when the namespace communote is defined and the main layout is loaded
if (window.communote && communote.environment && communote.environment.page == 'main') {
    // Add a callback that is invoked before the Communote JavaScript component is initialized
    communote.initializer.addBeforeInitCallback(function() {
        //... this snippet creates a container with a localized message and appends it to the top
        var constructionContainer  = new Element('div', {
                id: 'construction-container',
                html: '<h1>' + communote.i18n.getMessage("plugins.communote.tutorial.construction.text") + '</h1>'
            });
        constructionContainer.inject($('cn-view-wrapper'), 'top');
    });
}