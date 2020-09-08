package com.leetcode.problems.algorithm;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        SearchInsertPosition sip = new SearchInsertPosition();

        int[] nums = {1, 3, 5, 6};
        int target = 2;
        sip.searchInsert(nums, target);
    }


    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        int mid = 0;
        while(left < right) {
            mid = (right - left) / 2 + left;
            if(nums[mid] > target) {
                if(right == mid) {
                    mid--;
                }
                right = mid;
            } else if(nums[mid] < target) {
                if(left == mid) {
                    mid++;
                }
                left = mid;
            } else {
                break;
            }
        }
        return mid;
    }
}
