package com.communote.plugins.tutorial;

import java.util.Map;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Invalidate;
import org.apache.felix.ipojo.annotations.Validate;
import org.osgi.framework.BundleContext;

import com.communote.server.web.WebServiceLocator;
import com.communote.server.web.fe.widgets.extension.WidgetFactoryRegistry;
import com.communote.server.widgets.Widget;
import com.communote.server.widgets.WidgetCreationException;
import com.communote.server.widgets.WidgetFactory;

/**
 * @author <a href="http://github.com/communote">Communote Github Team</a>
 */
@Component
@Instantiate
public class TutorialWidgetFactory implements WidgetFactory {

    private final String symbolicName;

    /**
     * Constructs the widget factory
     *
     * @param bundleContext
     *            the context of the bundle
     */
    public TutorialWidgetFactory(BundleContext bundleContext) {
        // Saving the context of the plugin to stop and start the factory
        this.symbolicName = bundleContext.getBundle().getSymbolicName();
    }

    /**
     * Create a new widget instance that should handle the current widget request.
     *
     * @param widgetGroupName
     *            the group of the widget
     * @param widgetName
     *            the name of the widget
     * @param requestParameters
     *            the request parameters of the current request
     * @return the new widget instance
     * @throws WidgetCreationException
     *             in case the widget cannot be created
     */
    @Override
    public Widget createWidget(String widgetGroupName, String widgetName,
            Map<String, String[]> requestParameters) throws WidgetCreationException {
        // Return the new widget instance
        return new HelloWorldWidget();
    }

    /**
     * Plugin start callback to register the factory.
     */
    @Validate
    public void start() {
        WebServiceLocator.instance().getService(WidgetFactoryRegistry.class)
                .addWidgetFactory(this.symbolicName, this);
    }

    /**
     * Plugin stop callback to remove the factory.
     */
    @Invalidate
    public void stop() {
        WebServiceLocator.instance().getService(WidgetFactoryRegistry.class)
                .removeWidgetFactory(this.symbolicName);
    }

}