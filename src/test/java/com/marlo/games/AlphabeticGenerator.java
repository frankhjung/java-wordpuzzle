package com.marlo.games;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

/** Generate alpha-numeric characters. */
public final class AlphabeticGenerator extends Generator<Character> {

  /**
   * Lowercase alphabetic characters: "a" to "z".
   *
   * <p>Compare with: <code>
   *   IntStream.rangeClosed('a', 'z')
   *      .mapToObj(c -> "" + (char) c)
   *      .collect(Collectors.joining());
   * </code>
   */
  private static final String ALPHABETIC = "abcdefghijklmnopqrstuvwxyz";;

  /** Inherit form super class. */
  public AlphabeticGenerator() {
    super(Character.class);
  }

  /** Generate an alphabetic character. */
  @Override
  public Character generate(final SourceOfRandomness randomness, final GenerationStatus status) {
    return ALPHABETIC.charAt(randomness.nextInt(ALPHABETIC.length()));
  }
}
