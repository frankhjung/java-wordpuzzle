package com.marlo.games;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

/** Bean to validate Word Puzzle command line arguments. */
@Getter
@Setter
public class WordPuzzleBean {

  /** Minimum word size. */
  @Min(value = 1, message = "Size: Expected integer in range 1..9")
  @Max(value = 9, message = "Size: Expected integer in range 1..9")
  private int size;

  /** Mandatory character. Every word must contain this character. */
  @Pattern(regexp = "^[a-z]{1}$", message = "Mandatory: Expected 1 alphabetic letter")
  private String mandatory;

  /** Words must contain only these letters. */
  @Pattern(regexp = "^[a-z]{9}$", message = "Letters: Expected 9 alphabetic letters")
  private String letters;

  /** Bean validations if any. */
  private Set<ConstraintViolation<WordPuzzleBean>> validations;

  /** Construct bean from command line arguments. */
  public WordPuzzleBean(final int size, final String mandatory, final String letters) {
    this.size = size;
    this.mandatory = mandatory;
    this.letters = letters;
  }

  /** Validate the values of this bean. */
  public boolean validate() {
    final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    validations = validator.validate(this);
    return validations.isEmpty();
  }
}
