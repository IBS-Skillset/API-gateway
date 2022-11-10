package com.mystays.APIGateway.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class GatewayConfig {


    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder routeLocatorBuilder)
    {
        return routeLocatorBuilder.routes()
                .route(p ->p.path("/auth-server/authenticate/**")
                        .filters(f -> f.circuitBreaker(c->c.setName("authenticate").setFallbackUri("/authenticateFallback")))
                        .uri("lb://AUTHORIZATION-SERVER"))
                .route(p ->p.path("/hotel-search-service/api/**")
                        .filters(f -> f.circuitBreaker(c->c.setName("HotelSearchService").setFallbackUri("/hotelSearchServiceFallback")))
                        .uri("lb://HOTEL-SEARCH-API"))
                .route(p->p.path("/account/**")
                        .filters(f -> f.circuitBreaker(c->c.setName("AccountService").setFallbackUri("/accountServiceFallback")))
                        .uri("lb://ACCOUNT-SERVICE"))
                .route(p->p.path("/googleApi/**")
                        .filters(f -> f.circuitBreaker(c->c.setName("GoogleApi").setFallbackUri("/googleApiFallback")))
                        .uri("lb://GOOGLE-API"))
                .build();
    }
    @Bean
    public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer()
    {
        return factory->factory.configureDefault(id ->new Resilience4JConfigBuilder(id)
                .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
                .timeLimiterConfig(TimeLimiterConfig.custom()
                        .timeoutDuration(Duration.ofSeconds(50)).build()).build());
    }


}
