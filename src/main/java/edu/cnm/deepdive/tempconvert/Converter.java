package edu.cnm.deepdive.tempconvert;

import jdk.jshell.spi.ExecutionControl.NotImplementedException;

public class Converter {

  static final double SCALE = 9D / 5;
  static final double OFFSET = 32;

  public double convertC2F(double celsius) {

    return celsius * SCALE + OFFSET;

//    throw new UnsupportedOperationException("Not yet implemented!");
  }
}
