package com.github.eljaiek.playground.jfx;

import javafx.fxml.FXML;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class PrimaryController {

    private final JFXStageRouter router;

    @FXML
    private void switchToSecondary() {
        router.navigateByUrl("/secondary");
    }
}
