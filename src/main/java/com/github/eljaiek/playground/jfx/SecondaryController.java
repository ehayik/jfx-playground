package com.github.eljaiek.playground.jfx;

import javafx.fxml.FXML;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class SecondaryController {

    private final SceneRootExchanger sceneRootExchanger;

    @FXML
    private void switchToPrimary() {
        sceneRootExchanger.exchange("/primary");
    }
}