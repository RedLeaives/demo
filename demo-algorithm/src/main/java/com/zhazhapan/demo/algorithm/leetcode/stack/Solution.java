package com.zhazhapan.demo.algorithm.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author pantao
 * @since 2019/1/31
 **/
public class Solution {

    private int count = 0;

    public int[][] updateMatrix(int[][] matrix) {
        int xlen = matrix.length;
        for (int i = 0; i < xlen; i++) {
            int len = matrix[i].length;
            for (int j = 0; j < len; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = helper(matrix, i, j, 0, 0, xlen - 1, len - 1);
                }
            }
        }
        return matrix;
    }

    private int helper(int[][] matrix, int row, int col, int minR, int minC, int maxR, int maxC) {
        if (row < minR || col < minC || row > maxR || col > maxC) {
            return 10000;
        }
        int space = matrix[row][col];
        if (space != 1) {
            return space;
        }
        int temp = helper(matrix, row - 1, col, minR, minC, row, maxC);
        if (temp != 0) {
            temp = Math.min(temp, helper(matrix, row + 1, col, row + 1, minC, maxR, maxC));
            if (temp != 0) {
                temp = Math.min(temp, helper(matrix, row, col - 1, minR, minC, maxR, col));
                if (temp != 0) {
                    temp = Math.min(temp, helper(matrix, row, col + 1, minR, col + 1, maxR, maxC));
                }
            }
        }
        return 1 + temp;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int swap = image[sr][sc];
        if (swap == newColor) {
            return image;
        }
        image[sr][sc] = newColor;
        int temp = sr - 1;
        if (temp >= 0 && image[temp][sc] == swap) {
            floodFill(image, temp, sc, newColor);
        }
        temp = sr + 1;
        if (temp < image.length && image[temp][sc] == swap) {
            floodFill(image, temp, sc, newColor);
        }
        temp = sc - 1;
        if (temp >= 0 && image[sr][temp] == swap) {
            floodFill(image, sr, temp, newColor);
        }
        temp = sc + 1;
        if (temp < image[sr].length && image[sr][temp] == swap) {
            floodFill(image, sr, temp, newColor);
        }
        return image;
    }

    public int findTargetSumWays(int[] nums, int S) {
        count = 0;
        calculate(nums, 0, 0, S);
        return count;
    }

    public void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S) {
                count++;
            }
        } else {
            calculate(nums, i + 1, sum + nums[i], S);
            calculate(nums, i + 1, sum - nums[i], S);
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        UndirectedGraphNode graphNode = new UndirectedGraphNode(node.label);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            graphNode.neighbors.add(cloneGraph(neighbor));
        }
        return graphNode;
    }

    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        int[] stack = new int[len];
        int top = -1;
        for (int i = 0; i < len; i++) {
            String str = tokens[i];
            int pre = top - 1;
            switch (str) {
                case "+":
                    stack[pre] = stack[pre] + stack[top--];
                    break;
                case "-":
                    stack[pre] = stack[pre] - stack[top--];
                    break;
                case "*":
                    stack[pre] = stack[pre] * stack[top--];
                    break;
                case "/":
                    stack[pre] = stack[pre] / stack[top--];
                    break;
                default:
                    stack[++top] = Integer.parseInt(str);
                    break;
            }
        }
        return stack[0];
    }

    ;

    public int[] dailyTemperatures(int[] t) {
        int[] res = new int[t.length];
        int[] stack = new int[t.length];
        int top = -1;
        for (int i = 0; i < t.length; i++) {
            while (top > -1 && t[i] > t[stack[top]]) {
                int idx = stack[top--];
                res[idx] = i - idx;
            }
            stack[++top] = i;
        }
        return res;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char c2 = stack.pop();
                if (c2 + 1 != chars[i] && c2 + 2 != chars[i]) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    class UndirectedGraphNode {

        int label;

        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }
}
