package com.github.eljaiek.playground.jfx;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class JavaFxApplication extends Application {

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        applicationContext = new SpringApplicationBuilder()
                .sources(MainApplication.class)
                .initializers(newApplicationContextInitializer(this))
                .run(getParameters().getRaw().toArray(new String[0]));
    }

    private static ApplicationContextInitializer<GenericApplicationContext> newApplicationContextInitializer(Application application) {
        return ac -> {
          ac.registerBean(Application.class, () -> application);
          ac.registerBean(Parameters.class, application::getParameters);
          ac.registerBean(HostServices.class, application::getHostServices);
        };
    }

    @Override
    public void start(Stage primaryStage) {
        applicationContext.publishEvent(new StageReadyEvent(primaryStage));
    }

    @Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
    }

    static class StageReadyEvent extends ApplicationEvent {

        public StageReadyEvent(Stage stage) {
            super(stage);
        }

        public Stage getStage() {
            return (Stage) getSource();
        }
    }
}
