package com.leetcode.problems.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] topK = new int[k];
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            Integer orDefault = numMap.getOrDefault(num, 0);
            numMap.put(num, 1+orDefault);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) ->{return x[1] - y[1];});

        numMap.entrySet().forEach(
                action -> {
                    Integer key = action.getKey();
                    Integer value = action.getValue();
                    int[] kv = new int[2];
                    kv[0] = key;
                    kv[1] = value;

                    if(pq.size()==k) {
                        if(pq.peek()[1] < value) {
                            pq.poll();
                            pq.offer(kv);
                        }
                    } else {
                        pq.offer(kv);
                    }
                }
        );

        for(int i=0; i<k; i++) {
            topK[i] = pq.poll()[0];
        }




        return topK;
    }
}
