package com.zhazhapan.demo.algorithm.leetcode.tree.nary;

import com.zhazhapan.demo.algorithm.common.annotation.LeetCode;
import com.zhazhapan.demo.algorithm.common.enums.Difficulty;
import com.zhazhapan.demo.algorithm.leetcode.model.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pantao
 * @since 2018-12-09
 */
public class Postoreder {

    private List<Integer> list = new ArrayList<>();

    @LeetCode(id = 590, difficulty = Difficulty.EASY, title = "N叉树的后序遍历")
    public List<Integer> postorder(Node root) {
        post(root);
        return list;
    }

    private void post(Node root) {
        if (root != null) {
            List<Node> nodes = root.children;
            if (nodes != null && !nodes.isEmpty()) {
                for (Node node : nodes) {
                    post(node);
                }
            }
            list.add(root.val);
        }
    }
}
