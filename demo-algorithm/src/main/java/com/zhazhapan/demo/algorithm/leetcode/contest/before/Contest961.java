package com.zhazhapan.demo.algorithm.leetcode.contest.before;

import com.zhazhapan.demo.algorithm.common.annotation.LeetCode;
import com.zhazhapan.demo.algorithm.common.enums.Difficulty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pantao
 * @since 2018/12/23
 **/
public class Contest961 {

    @LeetCode(id = 961, difficulty = Difficulty.EASY, title = "重复 N 次的元素")
    public int repeatedNTimes(int[] a) {
        List<Integer> list = new ArrayList<>();
        int maxLen = a.length / 2 + 1;
        for (int i = 0; i < maxLen; i++) {
            int val = a[i];
            if (list.contains(val)) {
                return val;
            } else {
                list.add(val);
            }
        }
        return a[maxLen];
    }
}
