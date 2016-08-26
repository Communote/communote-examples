package com.communote.plugins.tutorial;

import com.communote.server.web.commons.i18n.JsMessagesExtension;
import com.communote.server.web.commons.i18n.JsMessagesRegistry;
import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Provides;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author <a href="http://github.com/communote">Communote Github Team</a>
 */
@Component
@Provides
@Instantiate
public class TutorialJsMessages implements JsMessagesExtension {

    @Override
    public Map<String, Set<String>> getJsMessageKeys() {
        HashSet<String> messageKeys = new HashSet<String>();
        // Add the message keys you need to access via your JavaScript file
        messageKeys.add("plugins.communote.tutorial.construction.text");

        HashMap<String, Set<String>> mapping = new HashMap<String, Set<String>>();
        // Define the context where you have access to the message keys
        mapping.put(JsMessagesRegistry.CATEGORY_PORTAL, messageKeys);
        return mapping;
    }

}
