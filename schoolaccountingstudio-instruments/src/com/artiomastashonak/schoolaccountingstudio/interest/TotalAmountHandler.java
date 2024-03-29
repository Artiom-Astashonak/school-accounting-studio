// Copyright 2023-2024 Artiom Astashonak. Use of this code is governed by the Apache License 2.0 that can be found in the LICENSE file.
package com.artiomastashonak.schoolaccountingstudio.interest;

/**
 * The {@code TotalAmountHandler} object handles the total amount gotten from the user
 * providing storage of necessary variables and calculation methods.
 *
 * @author Artiom Astashonak
 */
public class TotalAmountHandler {
  private final int DAYS_CALCULATION_MODE = 0;
  private final int MONTHS_CALCULATION_MODE = 1;
  private final int YEARS_CALCULATION_MODE = 2;
  private final double CALCULATION_ERROR = Double.NaN;

  private double capital = 0;
  private long time = 0;
  private double quote = 0;
  private double totalAmount = 0;
  private boolean isLeapYear = false;

  /**
   * Constructs a new {@code TotalAmountHandler} object with standard properties set up.
   */
  public TotalAmountHandler() { }

  /**
   * Calculates and returns an unknown value of all class variables. If there is nothing
   * to find the {@code CALCULATION_ERROR} is returned.
   *
   * @param mode the calculation mode
   * @return the unknown value or the {@code CALCULATION_ERROR} if there is no value
   * to be found
   */
  public double calculate(int mode) {
    if (capital == 0) return calculateCapital(mode);
    if (time == 0) return calculateTime(mode);
    if (quote == 0) return calculateQuote(mode);
    if (totalAmount == 0) return calculateTotalAmount(mode);
    return CALCULATION_ERROR;
  }

  /**
   * Computes the value of the total amount.
   *
   * @param mode the calculation mode
   * @return the total amount value or the {@code CALCULATION_ERROR} if there is no
   * value to be found
   */
  private double calculateTotalAmount(int mode) {
    if (mode == DAYS_CALCULATION_MODE) {
      if (isLeapYear) return Math.round(((capital * (36600 + time * quote)) / 36600) * 100.0) / 100.0;
      return Math.round(((capital * (36500 + time * quote)) / 36500) * 100.0) / 100.0;
    }
    if (mode == MONTHS_CALCULATION_MODE) return Math.round(((capital * (1200 + time * quote)) / 1200) * 100.0) / 100.0;
    if (mode == YEARS_CALCULATION_MODE) return Math.round(((capital * (100 + time * quote)) / 100) * 100.0) / 100.0;
    return CALCULATION_ERROR;
  }

  /**
   * Computes the value of the capital.
   *
   * @param mode the calculation mode
   * @return the capital value or the {@code CALCULATION_ERROR} if there is no
   * value to be found
   */
  private double calculateCapital(int mode) {
    if (mode == DAYS_CALCULATION_MODE) {
      if (isLeapYear) return Math.round(((36600 * totalAmount) / (36600 + time * quote)) * 100.0) / 100.0;
      return Math.round(((36500 * totalAmount) / (36500 + time * quote)) * 100.0) / 100.0;
    }
    if (mode == MONTHS_CALCULATION_MODE) return Math.round(((1200 * totalAmount) / (1200 + time * quote)) * 100.0) / 100.0;
    if (mode == YEARS_CALCULATION_MODE) return Math.round(((100 * totalAmount) / (100 + time * quote)) * 100.0) / 100.0;
    return CALCULATION_ERROR;
  }

  /**
   * Computes the value of the time.
   *
   * @param mode the calculation mode
   * @return the time value or the {@code CALCULATION_ERROR} if there is no
   * value to be found
   */
  private double calculateTime(int mode) {
    if (mode == DAYS_CALCULATION_MODE) {
      if (isLeapYear) return Math.round(((((36600 * totalAmount) / capital) - 36600) / quote) * 100.0) / 100.0;
      return Math.round(((((36500 * totalAmount) / capital) - 36500) / quote) * 100.0) / 100.0;
    }
    if (mode == MONTHS_CALCULATION_MODE) return Math.round(((((1200 * totalAmount) / capital) - 1200) / quote) * 100.0) / 100.0;
    if (mode == YEARS_CALCULATION_MODE) return Math.round(((((100 * totalAmount) / capital) - 100) / quote) * 100.0) / 100.0;
    return CALCULATION_ERROR;
  }

  /**
   * Computes the value of the quote.
   *
   * @param mode the calculation mode
   * @return the quote value or the {@code CALCULATION_ERROR} if there is no
   * value to be found
   */
  private double calculateQuote(int mode) {
    if (mode == DAYS_CALCULATION_MODE) {
      if (isLeapYear) return Math.round(((((36600 * totalAmount) / capital) - 36600) / time) * 100.0) / 100.0;
      return Math.round(((((36500 * totalAmount) / capital) - 36500) / time) * 100.0) / 100.0;
    }
    if (mode == MONTHS_CALCULATION_MODE) return Math.round(((((1200 * totalAmount) / capital) - 1200) / time) * 100.0) / 100.0;
    if (mode == YEARS_CALCULATION_MODE) return Math.round(((((100 * totalAmount) / capital) - 100) / time) * 100.0) / 100.0;
    return CALCULATION_ERROR;
  }

  /**
   * Resets the object to its initial state.
   */
  public void reset() {
    this.capital = 0;
    this.time = 0;
    this.quote = 0;
    this.totalAmount = 0;
    this.isLeapYear = false;
  }

  public double getCapital() {
    return capital;
  }

  public void setCapital(double capital) {
    this.capital = capital;
  }

  public long getTime() {
      return time;
  }

  public void setTime(long time) {
    this.time = time;
  }

  public double getQuote() {
    return quote;
  }

  public void setQuote(double quote) {
    this.quote = quote;
  }

  public double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public boolean isLeapYear() {
    return isLeapYear;
  }

  public void setLeapYear(boolean leapYear) {
    isLeapYear = leapYear;
  }
}