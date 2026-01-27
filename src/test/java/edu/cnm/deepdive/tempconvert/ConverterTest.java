package edu.cnm.deepdive.tempconvert;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class ConverterTest {
  static final double TOLERANCE_SCALE = 0.0001;
  static final double MIN_ABSOLUTE_TOLERANCE = 0.000000001;

  @ParameterizedTest
  @CsvFileSource(resources = "convert-c2f-valid.csv", useHeadersInDisplayName = true)
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
}