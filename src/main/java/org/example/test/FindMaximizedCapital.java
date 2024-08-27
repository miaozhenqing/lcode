package org.example.test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMaximizedCapital {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<CostToIndex> capitalQueue = new PriorityQueue<>(capital.length, Comparator.comparing(CostToIndex::getCapital));
        for (int i = 0; i < capital.length; i++) {
            capitalQueue.add(new CostToIndex(capital[i], profits[i]));
        }
        PriorityQueue<CostToIndex> chooseQueue = new PriorityQueue<>(capital.length, Comparator.comparing(CostToIndex::getProfit).reversed());
        k = Math.min(k, capital.length);
        for (int i = 0; i < k; i++) {
            while (!capitalQueue.isEmpty() && capitalQueue.peek().capital <= w) {
                chooseQueue.add(capitalQueue.poll());
            }
            if (chooseQueue.isEmpty()) {
                break;
            }
            w += chooseQueue.poll().profit;
        }

        return w;
    }
    class CostToIndex {
        private int capital;
        private int profit;

        public CostToIndex(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }

        public int getCapital() {
            return capital;
        }

        public void setCapital(int capital) {
            this.capital = capital;
        }

        public int getProfit() {
            return profit;
        }

        public void setProfit(int profit) {
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};
        System.out.println(new FindMaximizedCapital().findMaximizedCapital(2, 0, profits, capital));//4
        System.out.println(new FindMaximizedCapital().findMaximizedCapital(3, 0, profits, capital));//6
        System.out.println(new FindMaximizedCapital().findMaximizedCapital(4, 0, profits, capital));//6
        //测试用例:1
        //			2
        //			[1,2,3]
        //			[1,1,2]
        //	期望结果:5
        profits = new int[]{1, 2, 3};
        capital = new int[]{1, 1, 2};
        System.out.println(new FindMaximizedCapital().findMaximizedCapital(1, 2, profits, capital));//5
    }

}
