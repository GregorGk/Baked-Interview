class AppleStock {

  /**
   * For loosing scenario the returned value can be negative.
   *
   * @return the maximum of possible profits from yesterday's stocks.
   */
  public long getMaxProfit(int[] stockPricesYesterday) {
    if (stockPricesYesterday.length < 2) {
      throw new IllegalArgumentException("At least two stock prices required.");
    }
    int currentMin = stockPricesYesterday[0];
    long currentProfit = (long) stockPricesYesterday[1] - stockPricesYesterday[0];
    for (int i = 2; i < stockPricesYesterday.length; i++) {
      currentProfit = Math.max((long) stockPricesYesterday[i] - currentMin, currentProfit);
      currentMin = Math.min(stockPricesYesterday[i], currentMin);
    }
    return currentProfit;
  }
}
