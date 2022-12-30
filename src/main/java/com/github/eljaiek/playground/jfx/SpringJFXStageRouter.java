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
import java.util.concurrent.atomic.AtomicReference;

@Component
@RequiredArgsConstructor
final class SpringJFXStageRouter implements ApplicationListener<StageReadyEvent>, JFXStageRouter {

   private final AppProperties appProperties;
   private final ApplicationContext applicationContext;
   private final AtomicReference<Scene> sceneRef = new AtomicReference<>();

    @Override
    @SneakyThrows
    public void onApplicationEvent(StageReadyEvent event) {
        val parent = loadFXML(appProperties.getIndexView());
        Scene scene = new Scene(parent, appProperties.getWidth(), appProperties.getHeight());
        sceneRef.set(scene);

        val stage = event.getStage();
        stage.setTitle(appProperties.getTitle());
        stage.setScene(scene);
        stage.show();
    }

    private Parent loadFXML(String fxml) throws IOException {
        val fxmlLoader = new FXMLLoader(SpringJFXStageRouter.class.getResource(fxml + ".fxml"));
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        return fxmlLoader.load();
    }

    @Override
    public void navigateByUrl(String url) {

        if (sceneRef.get() == null) {
            throw new IllegalArgumentException("Current scene is not ready yet");
        }

        try {
            sceneRef.get().setRoot(loadFXML(url));
        } catch (IOException ex) {
            String msg = String.format("It isn't possible to set %s as Root", url);
            throw new IllegalArgumentException(msg, ex);
        }
    }
}
