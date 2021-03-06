grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6

grails.tomcat.nio = true
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve

    repositories {
        inherits true // Whether to inherit repository definitions from plugins
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenCentral()

        // uncomment these to enable remote dependency resolution from public Maven repositories
        //mavenCentral()
        //mavenLocal()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.16'

        def tomcatVersion = "7.0.23"
        build("org.apache.tomcat:tomcat-catalina-ant:$tomcatVersion") {
            transitive = false
        }
        build "org.apache.tomcat.embed:tomcat-embed-core:$tomcatVersion"
        build "org.apache.tomcat.embed:tomcat-embed-jasper:$tomcatVersion"
        build "org.apache.tomcat.embed:tomcat-embed-logging-log4j:$tomcatVersion"

        // needed for JSP compilation
        runtime "org.eclipse.jdt.core.compiler:ecj:3.6.2"

    }

    plugins {
        runtime ":hibernate:$grailsVersion"
        compile ":jquery:1.7.1"
        compile ":resources:1.1.6"

        runtime ":atmosphere:0.4.2.1"

        //build ":tomcat:$grailsVersion" USE 7.0.23 instead
    }
}
