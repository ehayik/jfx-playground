package com.github.eljaiek.playground.jfx;

import javafx.fxml.FXML;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class PrimaryController {

    private final Router router;

    @FXML
    private void switchToSecondary() {
        router.navigateByUrl("/secondary");
    }
}
