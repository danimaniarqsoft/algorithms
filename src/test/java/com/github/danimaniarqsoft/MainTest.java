package com.github.danimaniarqsoft;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

@Slf4j
class MainTest {

  private Main cut;

  @BeforeAll
  static void beforeAll() {
    log.info("Before all");
  }

  @BeforeEach
  void setUp() {
    log.info("beforeEach");
    this.cut = new Main();
  }

  @Test
  void firstTest() {
    log.info("firstTest");
    String input = "duke";
    String result = cut.format(input);
    assertEquals("DUKE", result);
  }

  @Test
  void secondTest() {
    log.info("secondTest");
    String input = "duke";
    String result = cut.format(input);
    assertEquals("DUKE", result);
  }

  @AfterEach
  void afterEach() {
    log.info("afterEach");
  }

  @AfterAll
  static void afterAll() {
    log.info("After all");
  }

}