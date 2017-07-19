package algorithms.implementations;

import algorithms.interfaces.BeautifulNumberValidator;
import org.junit.Test;

import static org.junit.Assert.*;

public class BeautifulNumberValidatorImplTest {
  final BeautifulNumberValidator validator = new BeautifulNumberValidatorImpl();

  @Test
  public void itShouldBeAValidBeautifulNumber() {
    assertTrue(validator.isValidBeautifulNumber("1234"));
  }

  @Test
  public void itShouldNotBeAValidBeautifulNumber() {
    assertFalse(validator.isValidBeautifulNumber("101103"));
  }

  @Test
  public void itShouldNotBeAValidBeautifulNumberSinceItStartsWithZero() {
    assertFalse(validator.isValidBeautifulNumber("010203"));
  }

  @Test
  public void itShouldNotBeAValidBeautifulNumberSinceItIsTooSmall() {
    assertFalse(validator.isValidBeautifulNumber("1"));
  }
}