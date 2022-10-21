class StockSpanner {

    int index;
    List<Integer> prices;
    List<Integer> days;

    public StockSpanner() {
        index = 0;
        prices = new ArrayList<Integer>();
        days = new ArrayList<Integer>();
    }

    public int next(int price) {
        int p = index-1;
        while (p>=0 && price>=prices.get(p)) {
            p = p - days.get(p);
        }
        prices.add(price);
        days.add(index - p);
        index ++;
        return days.get(index-1);
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */