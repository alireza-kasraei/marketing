package net.devk.greetingsservice;

import org.springframework.context.annotation.Configuration;
//@formatter:off
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@Configuration
@EnableResourceServer
@EnableOAuth2Client
class OAuthResourceConfiguration {
}
