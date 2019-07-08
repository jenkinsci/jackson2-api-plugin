# Jackson 2 API Plugin

This plugin exposes the [FasterXML Jackson 2](https://github.com/FasterXML/jackson) API to Jenkins plugins.

See also this [plugin's wiki page][wiki]

# Environment

The following build environment is required to build this plugin

* `java-1.8` and `maven-3.3.9`

# Build

To build the plugin locally:

    mvn clean verify

# Release

To release the plugin:

    mvn release:prepare release:perform -B

# Test local instance

To test in a local Jenkins instance

    mvn hpi:run

  [wiki]: http://wiki.jenkins-ci.org/display/JENKINS/Jackson2+API+Plugin
