package com.marlo.games;

import static com.marlo.games.WordPuzzleBean.LETTERS_MESSAGE;
import static com.marlo.games.WordPuzzleBean.MANDATORY_MESSAGE;
import static com.marlo.games.WordPuzzleBean.SIZE_MESSAGE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.generator.Size;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/** Test WordPuzzleBean. */
@RunWith(JUnitQuickcheck.class)
@Slf4j
public class WordPuzzleBeanTest {

  /** Test Word Puzzle bean. */
  private WordPuzzleBean bean;

  /** Default failure message. */
  public static final String VALIDATION_ERROR = "Expected no validation errors";

  /** Sets up. */
  @Before
  public void setUp() {
    bean = new WordPuzzleBean(4, "c", "adevcrsoi");
  }

  /** Test setup. */
  @Test
  public void testSetup() {
    assertTrue(bean.validate());
    assertTrue(VALIDATION_ERROR, bean.getValidations().isEmpty());
  }

  /**
   * Test good size.
   *
   * @param size the size
   */
  @Property
  public void testGoodSize(final @InRange(min = "1", max = "9") int size) {
    bean.setSize(size);
    log.debug("Size: {}", bean.getSize());
    assertTrue(bean.validate());
    assertTrue(VALIDATION_ERROR, bean.getValidations().isEmpty());
  }

  /**
   * Test bad size.
   *
   * @param size the size
   */
  @Property
  public void testBadSize(final int size) {
    Assume.assumeTrue(size < 1 || size > 9);
    bean.setSize(size);
    log.debug("Size: {}", bean.getSize());
    assertFalse(bean.validate());
    assertEquals(SIZE_MESSAGE, bean.getValidations().iterator().next().getMessage());
  }

  /**
   * Test good mandatory.
   *
   * @param mandatory the mandatory
   */
  @Property
  public void testGoodMandatory(final @InRange(min = "a", max = "z") char mandatory) {
    bean.setMandatory(String.valueOf(mandatory));
    log.debug("Mandatory: {}", bean.getMandatory());
    assertTrue(bean.validate());
    assertTrue(VALIDATION_ERROR, bean.getValidations().isEmpty());
  }

  /**
   * Test bad mandatory.
   *
   * @param mandatory the mandatory
   */
  @Property()
  public void testBadMandatory(final char mandatory) {
    Assume.assumeTrue(mandatory < 'a' || mandatory > 'z');
    bean.setMandatory(String.valueOf(mandatory));
    log.debug("Mandatory: {}", bean.getMandatory());
    assertFalse(Boolean.valueOf(bean.validate()));
    assertEquals(MANDATORY_MESSAGE, bean.getValidations().iterator().next().getMessage());
  }

  /**
   * Test good letters.
   *
   * @param letters the letters
   */
  @Property
  public void testGoodLetters(
      final @Size(min = 9, max = 9) List<@From(AlphabeticGenerator.class) Character> letters) {
    bean.setLetters(letters.stream().map(String::valueOf).collect(Collectors.joining()));
    log.debug("Letters: {}", bean.getLetters());
    assertTrue(Boolean.valueOf(bean.validate()));
    assertTrue(VALIDATION_ERROR, bean.getValidations().isEmpty());
  }

  /**
   * Test bad letters.
   *
   * @param characters the characters
   */
  @Property
  public void testBadLetters(final @Size(max = 11) List<Character> characters) {
    String letters = characters.stream().map(String::valueOf).collect(Collectors.joining());
    if (characters.size() == 9) {
      letters = letters.toUpperCase(Locale.ENGLISH);
    }
    bean.setLetters(letters);
    log.debug("Letters: {}", bean.getLetters());
    assertFalse(bean.validate());
    assertEquals(LETTERS_MESSAGE, bean.getValidations().iterator().next().getMessage());
  }

  /**
   * Test bad letters length.
   *
   * @param letters the letters
   */
  @Property
  public void testBadLettersLength(
      final @Size(max = 11) List<@From(AlphabeticGenerator.class) Character> letters) {
    Assume.assumeTrue(letters.size() != 9);
    bean.setLetters(letters.stream().map(String::valueOf).collect(Collectors.joining()));
    log.debug("Letters: {}", letters);
    assertFalse(bean.validate());
    assertEquals(LETTERS_MESSAGE, bean.getValidations().iterator().next().getMessage());
  }
}
