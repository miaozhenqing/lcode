package org.example._20260630;

import sun.security.krb5.internal.PAData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 回溯算法经典面试题（按难度分类，每类问题代表不同的回溯场景）
 */
public class BtAlgorithms {

    // ====================== 简单难度 ======================

    /**
     * 1. 子集问题（元素无重不可复选）
     * 难度：简单
     * 问题描述：给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     * 回溯场景：子集型回溯，每个元素选或不选
     * 示例：
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     */
    public List<List<Integer>> subsets(int[] nums) {
        return null;
    }

    /**
     * 2. 组合问题（元素无重不可复选）
     * 难度：简单
     * 问题描述：给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     * 你可以按 任何顺序 返回答案。
     * 回溯场景：组合型回溯，从n个元素中选k个，不考虑顺序
     * 示例：
     * 输入：n = 4, k = 2
     * 输出：[[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
     */
    public List<List<Integer>> combine(int n, int k) {
        return null;
    }

    // ====================== 中等难度 ======================

    /**
     * 3. 排列问题（元素无重不可复选）
     * 难度：中等
     * 问题描述：给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * 回溯场景：排列型回溯，每个元素必须选一次，考虑顺序
     * 示例：
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */
    public List<List<Integer>> permute(int[] nums) {
        return null;
    }

    /**
     * 4. 子集问题（元素可重不可复选）
     * 难度：中等
     * 问题描述：给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
     * 回溯场景：子集型回溯，需处理重复元素，跳过同一树层的重复选择
     * 示例：
     * 输入：nums = [1,2,2]
     * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        return null;
    }

    /**
     * 5. 组合总和问题（元素无重可复选）
     * 难度：中等
     * 问题描述：给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，
     * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     * 回溯场景：组合型回溯，元素可重复选择，需剪枝优化
     * 示例：
     * 输入：candidates = [2,3,6,7], target = 7
     * 输出：[[2,2,3],[7]]
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum_bt(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    public void combinationSum_bt(List<List<Integer>> res, List<Integer> path
            , int[] candidates, int target, int total, int start) {
        if (total == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        int need = target - total;
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= need) {
                path.add(candidates[i]);
                combinationSum_bt(res, path, candidates, target, total + candidates[i], i);
                path.remove(path.size() - 1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 6, 7};
        System.out.println(new BtAlgorithms().combinationSum(nums, 7));
    }

    /**
     * 6. 分割回文串
     * 难度：中等
     * 问题描述：给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
     * 回溯场景：分割型回溯，将字符串分割成满足条件的子串
     * 示例：
     * 输入：s = "aab"
     * 输出：[["a","a","b"],["aa","b"]]
     */
    public List<List<String>> partition(String s) {
        return null;
    }

    /**
     * 7. 单词搜索
     * 难度：中等
     * 问题描述：给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
     * 同一个单元格内的字母不允许被重复使用。
     * 回溯场景：网格型回溯，在二维网格中搜索路径
     * 示例：
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * 输出：true
     */
    public boolean exist(char[][] board, String word) {
        return false;
    }

    // ====================== 困难难度 ======================

    /**
     * 8. N 皇后问题
     * 难度：困难
     * 问题描述：按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
     * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
     * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     * 回溯场景：棋盘型回溯，需考虑多维度约束条件
     * 示例：
     * 输入：n = 4
     * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
     */
    public List<List<String>> solveNQueens(int n) {
        return null;
    }

    /**
     * 9. 解数独
     * 难度：困难
     * 问题描述：编写一个程序，通过填充空格来解决数独问题。
     * 数独的解法需 遵循如下规则：
     * 1. 数字 1-9 在每一行只能出现一次。
     * 2. 数字 1-9 在每一列只能出现一次。
     * 3. 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     * 数独部分空格内已填入了数字，空白格用 '.' 表示。
     * 回溯场景：棋盘型回溯，需处理部分已填充的棋盘，剪枝要求高
     * 示例：
     * 输入：board =
     * [["5","3",".",".","7",".",".",".","."]
     * ,["6",".",".","1","9","5",".",".","."]
     * ,[".","9","8",".",".",".",".","6","."]
     * ,["8",".",".",".","6",".",".",".","3"]
     * ,["4",".",".","8",".","3",".",".","1"]
     * ,["7",".",".",".","2",".",".",".","6"]
     * ,[".","6",".",".",".",".","2","8","."]
     * ,[".",".",".","4","1","9",".",".","5"]
     * ,[".",".",".",".","8",".",".","7","9"]]
     * 输出：填充完成的数独棋盘
     */
    public void solveSudoku(char[][] board) {

    }

    /**
     * 10. 正则表达式匹配
     * 难度：困难
     * 问题描述：给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     * 回溯场景：匹配型回溯，需处理复杂的模式匹配规则
     * 示例：
     * 输入：s = "aa", p = "a"
     * 输出：false
     * 输入：s = "aa", p = "a*"
     * 输出：true
     * 输入：s = "ab", p = ".*"
     * 输出：true
     */
    public boolean isMatch(String s, String p) {
        return false;
    }
}