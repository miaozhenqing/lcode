package org.example._20260630;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法经典面试题（按难度分类，每类问题代表不同的回溯场景）
 *
 *
 * void backtrack(State state, List<Choice> choices, List<State> res) {
 *     // 判断是否为解
 *     if (isSolution(state)) {
 *         // 记录解
 *         recordSolution(state, res);
 *         // 不再继续搜索
 *         return;
 *     }
 *     // 遍历所有选择
 *     for (Choice choice : choices) {
 *         // 剪枝：判断选择是否合法
 *         if (isValid(state, choice)) {
 *             // 尝试：做出选择，更新状态
 *             makeChoice(state, choice);
 *             backtrack(state, choices, res);
 *             // 回退：撤销选择，恢复到之前的状态
 *             undoChoice(state, choice);
 *         }
 *     }
 * }
 *
 * void backtrack(State state) {
 *
 *     // 当前状态是否需要记录
 *     if (shouldRecord(state)) {
 *         recordSolution(state);
 *     }
 *
 *     // 是否停止搜索
 *     if (shouldStop(state)) {
 *         return;
 *     }
 *
 *     for (Choice choice : choices) {
 *
 *         if (!isValid(state, choice)) {
 *             continue;
 *         }
 *
 *         makeChoice(state, choice);
 *
 *         backtrack(state);
 *
 *         undoChoice(state, choice);
 *     }
 * }
 *
 *
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
        List<List<Integer>> res = new ArrayList<>();
        return null;
    }

    public void subsets_bt(List<List<Integer>> res, List<Integer> path, int[] nums, int i) {
        res.add(new ArrayList<>(path));
        for (int i1 = i; i1 < nums.length; i1++) {
            path.add(nums[i1]);
            subsets_bt(res, path, nums, i1 + 1);
            path.remove(path.size() - 1);
        }

    }


    private void subsets_bt2(int[] nums,
                             int start,
                             List<Integer> path,
                             List<List<Integer>> res) {

        // =========================
        // recordSolution：记录当前解
        // =========================
        res.add(new ArrayList<>(path));

        // =========================
        // isSolution：是否到达叶子结点
        // =========================
        if (start == nums.length) {
            return;
        }

        // =========================
        // 遍历所有 Choice
        // =========================
        for (int i = start; i < nums.length; i++) {

            // 当前 Choice
            int choice = nums[i];

            // =========================
            // isValid：判断是否合法
            // 本题元素无重复，因此始终合法
            // =========================
            if (true) {

                // =========================
                // makeChoice：做选择
                // =========================
                path.add(choice);

                // 递归
                subsets_bt2(nums, i + 1, path, res);

                // =========================
                // undoChoice：撤销选择
                // =========================
                path.remove(path.size() - 1);
            }
        }
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
        List<List<Integer>> res = new ArrayList<>();
        combine_bt(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    public void combine_bt(List<List<Integer>> res, List<Integer> path, int current, int n, int k) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = current; i <= n; i++) {
            path.add(i);
            combine_bt(res, path, i + 1, n, k);
            path.remove(path.size() - 1);
        }
    }

    private void combine_bt2(List<List<Integer>> res,
                             List<Integer> path,
                             int start,
                             int n,
                             int k) {

        // =========================
        // recordSolution：记录当前解
        // =========================
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // =========================
        // isSolution：是否停止搜索
        // 已经选够 k 个元素，不再继续搜索
        // （由于上面已经 return，这里无需再写）
        // =========================

        // =========================
        // 遍历所有 Choice
        // =========================
        for (int i = start; i <= n; i++) {

            // =========================
            // isValid：是否合法
            // 本题元素无重复、不可复选，因此始终合法
            // =========================
            if (true) {

                // =========================
                // makeChoice：做选择
                // =========================
                path.add(i);

                // =========================
                // backtrack：进入下一层
                // i + 1 表示元素不可复选
                // =========================
                combine_bt2(res, path, i + 1, n, k);

                // =========================
                // undoChoice：撤销选择
                // =========================
                path.remove(path.size() - 1);
            }
        }
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
        List<List<Integer>> res = new ArrayList<>();
        permute_bt2(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void permute_bt(List<List<Integer>> res,
                            List<Integer> path,
                            int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!path.contains(nums[i])) {
                path.add(nums[i]);
                permute_bt(res, path, nums);
                path.remove(path.size() - 1);
            }
        }
    }

    private void permute_bt2(List<List<Integer>> res,
                             List<Integer> path,
                             int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                permute_bt2(res, path, nums, used);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
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
        List<List<Integer>> res = new ArrayList<>();
        subsetsWithDup_bt(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void subsetsWithDup_bt(List<List<Integer>> res,
                                   List<Integer> path, int[] nums, int start) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) { // isValid
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            subsetsWithDup_bt(res, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
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
        return null;
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
        List<List<String>> res = new ArrayList<>();
        partition_bt2(s, 0, res, new ArrayList<>());
        return res;
    }


    private void partition_bt(String s, int start, List<List<String>> result, List<String> path) {

        // 所有字符都已经分割完成
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 枚举当前这一段的结束位置
        for (int end = start; end < s.length(); end++) {

            // 当前子串不是回文，直接跳过
            if (!isPalindrome(s, start, end)) {
                continue;
            }

            // 当前回文串
            String sub = s.substring(start, end + 1);

            // 做选择
            path.add(sub);

            // 递归处理后面的字符串
            partition_bt(s, end + 1, result, path);

            // 撤销选择
            path.remove(path.size() - 1);
        }
    }

    //s="aab"
    //result=[[a,a,b],[aa,b]]
    //path=[a,a,b]
    private void partition_bt2(String s, int start, List<List<String>> result, List<String> path) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (!isPalindrome(s, start, i)) {
                continue;
            }
            path.add(s.substring(start, i + 1));
            partition_bt2(s, i + 1, result, path);
            path.remove(path.size() - 1);
        }
    }

    // 判断是否为回文串
    private boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    /**
     * 7. 单词搜索
     * 难度：中等
     * 问题描述：给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
     * 同一个单元格内的字母不允许被重复使用。
     * 回溯场景：网格型回溯，在二维网格中搜索路径
     * 示例：
     * 输入：board = [
     *  ["A","B","C","E"]
     * ,["S","F","C","S"]
     * ,["A","D","E","E"]], word = "ABCCED"
     * 输出：true
     */
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean existed = exist_bt(board, word, 0, i, j);
                if (existed) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist_bt(char[][] board, String word, int index, int i, int j) {

        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        //不能重复选
        board[i][j] = '#';

        return exist_bt(board, word, index + 1, i, j + 1) ||
                exist_bt(board, word, index + 1, i, j - 1) ||
                exist_bt(board, word, index + 1, i + 1, j) ||
                exist_bt(board, word, index + 1, i - 1, j);

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
     * 输出：[
     * [".Q..","...Q","Q...","..Q."],
     * ["..Q.","Q...","...Q",".Q.."]]
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solveNQueens_bt(res, 0, n, board);
        return res;
    }

    public void solveNQueens_bt(List<List<String>> res, int row, int n, char[][] board) {
        if (row >= n) {
            List<String> rowStr = new ArrayList<>();
            for (char[] chars : board) {
                rowStr.add(new String(chars));
            }
            res.add(rowStr);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!checkNQueen(board, row, i, n)) {
                continue;
            }
            board[row][i] = 'Q';
            solveNQueens_bt(res, row + 1, n, board);
            board[row][i] = '.';
        }
    }

    public boolean checkNQueen(char[][] board, int row, int col, int n) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        int i = row;
        int j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }
        i = row;
        j = col;
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }
        return true;
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

    public static void main(String[] args) {
        BtAlgorithms btAlgorithms = new BtAlgorithms();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(btAlgorithms.permute(nums));
        nums = new int[]{1, 2, 2};
        System.out.println(btAlgorithms.subsetsWithDup(nums));
        String str = "aab";
        System.out.println(btAlgorithms.partition(str));

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCEDAS";
        System.out.println(btAlgorithms.exist(board, word));

        System.out.println(btAlgorithms.solveNQueens(4));
    }
}