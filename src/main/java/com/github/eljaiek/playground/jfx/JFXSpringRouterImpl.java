package com.github.eljaiek.playground.jfx;

import com.github.eljaiek.playground.jfx.JFXApplication.StageReadyEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.val;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
final class JFXSpringRouterImpl implements ApplicationListener<StageReadyEvent>, Router {

   private final AppProperties appProperties;
   private final ApplicationContext applicationContext;
   private Scene scene;

    @Override
    @SneakyThrows
    public void onApplicationEvent(StageReadyEvent event) {
        val parent = loadFXML(appProperties.getLandingScene());
        val stage = event.getStage();
        stage.setTitle(appProperties.getTitle());
        scene = new Scene(parent, appProperties.getWidth(), appProperties.getHeight());
        stage.setScene(scene);
        stage.show();
    }

    private Parent loadFXML(String fxml) throws IOException {
        val fxmlLoader = new FXMLLoader(JFXSpringRouterImpl.class.getResource(fxml + ".fxml"));
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        return fxmlLoader.load();
    }

    @Override
    public void navigateByUrl(String url) {

        if (scene == null) {
            throw new IllegalArgumentException("Current scene is not ready yet");
        }

        try {
            scene.setRoot(loadFXML(url));
        } catch (IOException ex) {
            String msg = String.format("It isn't possible to set %s as Root", url);
            throw new IllegalArgumentException(msg, ex);
        }
    }
}
