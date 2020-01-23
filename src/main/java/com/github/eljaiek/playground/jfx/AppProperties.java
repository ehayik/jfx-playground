package com.github.eljaiek.playground.jfx;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Value
@ConstructorBinding
@ConfigurationProperties("app")
public class AppProperties {

    private final String title;
    private final String landingScene;
    private final int width;
    private final int height;
}
