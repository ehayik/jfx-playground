package com.github.eljaiek.playground.jfx;

import javafx.fxml.FXML;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class PrimaryController {

    private final String appMessage;

    private final StageRouter router;

    public PrimaryController(@Value("${app.message}") String appMessage, StageRouter router) {
        this.appMessage = appMessage;
        this.router = router;
    }

    @FXML
    private void switchToSecondary() {
        log.info(appMessage);
        router.navigateByUrl("/secondary");
    }
}
