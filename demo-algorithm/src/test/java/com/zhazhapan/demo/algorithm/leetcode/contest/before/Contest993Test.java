package com.zhazhapan.demo.algorithm.leetcode.contest.before;

import com.zhazhapan.demo.algorithm.leetcode.contest.before.Contest993;
import com.zhazhapan.demo.algorithm.leetcode.tree.binary.TreeCodec;
import org.junit.Test;

public class Contest993Test {

    @Test
    public void isCousins() {
        Contest993 contest993 = new Contest993();
        TreeCodec codec = new TreeCodec();
        assert !contest993.isCousins(codec.deserialize("1,(2,4),3"), 4, 3);
        assert contest993.isCousins(codec.deserialize("1,(2,null,4),(3,null,5)"), 4, 5);
        assert !contest993.isCousins(codec.deserialize("1,2,3"), 2, 3);
    }
}