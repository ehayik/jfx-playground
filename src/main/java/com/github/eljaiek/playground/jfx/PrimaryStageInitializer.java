package com.github.eljaiek.playground.jfx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.val;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import static com.github.eljaiek.playground.jfx.JavaFxApplication.*;

@Component
@RequiredArgsConstructor
final class PrimaryStageInitializer implements ApplicationListener<StageReadyEvent>, StageRouter {

   private final AppProperties appProperties;
   private final ApplicationContext applicationContext;
   private Scene scene;

    @Override
    @SneakyThrows
    public void onApplicationEvent(StageReadyEvent event) {
        val parent = loadFXML(appProperties.indexView());
        scene = new Scene(parent, appProperties.width(), appProperties.height());

        val stage = event.getStage();
        stage.setTitle(appProperties.title());
        stage.setScene(scene);
        stage.show();
    }

    private Parent loadFXML(String fxml) throws IOException {
        var resource = PrimaryStageInitializer.class.getResource(fxml + ".fxml");

        if (resource == null) {
            throw new IOException("Failed to find FXML resource " + fxml);
        }

        val fxmlLoader = new FXMLLoader(resource);
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        return fxmlLoader.load();
    }

    @Override
    public void navigateByUrl(String url) {
        Assert.notNull(scene, "Current scene is not ready yet");

        try {
            scene.setRoot(loadFXML(url));
        } catch (IOException ex) {
            throw new IllegalArgumentException("It isn't possible to set %s as Root".formatted(url), ex);
        }
    }
}
