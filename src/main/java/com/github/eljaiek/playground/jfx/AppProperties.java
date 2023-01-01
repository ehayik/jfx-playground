package com.github.eljaiek.playground.jfx;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("app")
public record AppProperties(String title, String indexView, int width, int height) {

}
