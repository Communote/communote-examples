# About
This repository contains the source code accompanying the [Communote plugin development tutorial](http://communote.github.io/doc/dev_how_plugin.html) 
which demonstrates the creation of a plugin for a [Communote server](https://github.com/Communote/communote-server) installation and shows the usage 
of some of the available extension points.

# Compatibility
The plugin can be used with a Communote standalone installation.

The following table shows which Communote server versions are supported by a specific version of the plugin. A server version which 
is not listed cannot be used with the plugin.

| Plugin Version  | Supported Server Version |
| ------------- | ------------- |
| 1.0  | 3.4  |

# Building and Testing
If you don't want to work through the tutorial you can also just compile and deploy the plugin:

* Building
  * clone or download the source and setup your development environment as described in our [Developer Documentation](http://communote.github.io/doc/dev_preparation.html)
  * run ```mvn``` in the communote-tutorial-plugin directory of the checkout
* Installation
  * the JAR file of the plugin is created in communote-tutorial-plugin/target directory
  * deploy the JAR file to your Communote installation as described in the [Installation Documentation](http://communote.github.io/doc/install_extensions.html)

# License
The plugin is licensed under the [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0).
