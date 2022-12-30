package com.github.eljaiek.playground.jfx;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Value
@ConstructorBinding
@ConfigurationProperties("app")
public class AppProperties {
    String title;
    String indexView;
    int width;
    int height;
}
