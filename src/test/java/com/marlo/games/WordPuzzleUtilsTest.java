package com.marlo.games;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/** Test word puzzle utility functions. */
public class WordPuzzleUtilsTest {

  /** Test letters. */
  private String letters;

  /** Sets up. */
  @Before
  public void setUp() {
    letters = "adevcrsoi";
  }

  /** Test valid word. */
  @Test
  public void testValidWord() {
    assertTrue("Word is correct", WordPuzzleUtils.isValid(letters, "voiced"));
  }

  /** Test invalid word. */
  @Test
  public void testInvalidWord() {
    assertFalse("bad character", WordPuzzleUtils.isValid(letters, "voixed"));
  }

  /** Test too many os. */
  @Test
  public void testTooManyOs() {
    assertFalse("too many 'o'`s", WordPuzzleUtils.isValid(letters, "vooiced"));
  }

  /** Test too large. */
  @Test
  public void testTooLarge() {
    assertFalse("word too large", WordPuzzleUtils.isValid(letters, letters + "moreletters"));
  }
}
