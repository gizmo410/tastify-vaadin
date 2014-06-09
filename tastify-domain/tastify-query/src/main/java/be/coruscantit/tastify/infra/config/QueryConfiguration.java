package be.coruscantit.tastify.infra.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @since 11/05/14
 */
@Configuration
@ComponentScan(basePackages = "be.coruscantit.tastify.query")
public class QueryConfiguration {

    // TODO Put Parse.com configuration in here

}
