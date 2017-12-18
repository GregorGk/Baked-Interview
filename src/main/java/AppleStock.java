class AppleStock {

  /**
   * Returns the maximum of possible profits from yesterday's stocks.
   * Can be negative.
   */
  public int getMaxProfit(int[] stockPricesYesterday) {
    if (stockPricesYesterday.length < 2) {
      throw new IllegalArgumentException("At least two stock prices required.");
    }
    int currentMin = stockPricesYesterday[0];
    int currentProfit = stockPricesYesterday[1] - stockPricesYesterday[0];
    for (int i = 2; i < stockPricesYesterday.length; i++) {
      currentProfit = Math.max(stockPricesYesterday[i] - currentMin, currentProfit);
      currentMin = Math.min(stockPricesYesterday[i], currentMin);
    }
    return currentProfit;
  }
}
