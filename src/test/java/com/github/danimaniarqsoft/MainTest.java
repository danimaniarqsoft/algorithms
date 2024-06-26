package com.github.danimaniarqsoft;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class MainTest {

  private Main cut;

  @BeforeEach
  void setUp() {
    log.info("Hola mundo");
    this.cut = new Main();
  }

  @Test
  void firstTest() {
    String input = "duke";

    String result = cut.format(input);

    assertEquals("DUKE", result);
  }
  @Test
  void secondTest() {
    String input = "duke";

    String result = cut.format(input);

    assertEquals("DUKE", result);
  }
}
