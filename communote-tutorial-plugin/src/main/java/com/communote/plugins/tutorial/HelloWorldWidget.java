package com.communote.plugins.tutorial;

import com.communote.server.widgets.EmptyWidget;

/**
 * @author <a href="http://github.com/communote">Communote Github Team</a>
 */
public class HelloWorldWidget extends EmptyWidget {

    @Override
    public String getTile(String outputType) {
        // key of the vm.tiles-mappings.properties entry whose value holds
        // the path of the velocity file which should be rendered
        return "com.communote.tutorial.HelloWorld.widget";
    }
}
