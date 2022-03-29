package grails5

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import groovy.transform.CompileStatic
import org.springframework.context.annotation.Configuration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration

@CompileStatic
@Configuration
//@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration)
@EnableAutoConfiguration
@ComponentScan(["grails5", "com.sb"])
class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }
}