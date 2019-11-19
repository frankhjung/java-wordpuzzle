package com.marlo.games;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/** Test word puzzle utility functions. */
public class WordPuzzleUtilsTest {

  private String letters;

  @Before
  public void setUp() {
    letters = "adevcrsoi";
  }

  @Test
  public void isValidWord() {
    assertTrue("Word is correct", WordPuzzleUtils.isValid(letters, "voice"));
  }

  @Test
  public void isInValidWord() {
    assertFalse("Word contains bad character", WordPuzzleUtils.isValid(letters, "voixe"));
  }
}
