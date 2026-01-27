package edu.cnm.deepdive.tempconvert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

class ConverterTest {
  static final double TOLERANCE_SCALE = 0.0001;
  static final double MIN_ABSOLUTE_TOLERANCE = 0.000000001;

  @ParameterizedTest
  @CsvFileSource(resources = "convert-valid.csv", useHeadersInDisplayName = true)
  void convertC2F_valid(double celsius, double expected) {
    Converter converter = new Converter();

    double tolerance = Math.max(
        Math.abs(expected * TOLERANCE_SCALE),
        MIN_ABSOLUTE_TOLERANCE
    );

    assertEquals(
        expected,
        converter.convertC2F(celsius),
        tolerance
    );
  }

  @ParameterizedTest
  @ValueSource(doubles = {Converter.CELSIUS_ABSOLUTE_ZERO - 0.01, -Double.MAX_VALUE})
  void convertC2F_invalid(double celsius) {
    try {
      new Converter().convertC2F(celsius);
      fail("Illegal argument exception expected, but no exception thrown.");
    } catch (IllegalArgumentException e) {
      // Do nothing! This exception is expected.
    } catch (Exception e) {
      fail("Illegal argument exception expected, but %s thrown.".formatted(e.getClass().getSimpleName()));
    }
  }

  @ParameterizedTest
  @ValueSource(doubles = {-459.67, -Double.MAX_VALUE})
  void convertF2C_invalid(double fahrenheit) {
    try {
      new Converter().convertF2C(fahrenheit);
      fail("Illegal argument exception expected, but no exception thrown.");
    } catch (IllegalArgumentException e) {
      // Do nothing! This exception is expected.
    } catch (Exception e) {
      fail("Illegal argument exception expected, but %s thrown.".formatted(e.getClass().getSimpleName()));
    }
  }

}