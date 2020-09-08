package com.leetcode.problems.algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Set<Integer> roomSet = new HashSet<>();
        LinkedList<Integer> keys = new LinkedList<>();
        keys.add(0);
        while(keys.size() > 0) {
            Integer pop = keys.pop();
            List<Integer> integers = rooms.get(pop);
            roomSet.add(pop);
            for (Integer integer : integers) {
                if(!roomSet.contains(integer)) {
                    keys.add(integer);
                }
            }
        }
        return roomSet.size() == rooms.size();
    }
}
