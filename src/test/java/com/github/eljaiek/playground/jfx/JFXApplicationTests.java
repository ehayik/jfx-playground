package com.github.eljaiek.playground.jfx;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class JFXApplicationTests {

	@Autowired(required = false)
	JFXStageRouter router;

	@Test
	void givenApplicationContextIsLoadedThenRouterShouldNotBeNull() {
		assertThat(router).isNotNull();
	}
}
