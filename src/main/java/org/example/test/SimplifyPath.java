package org.example.test;


import java.util.Stack;


public class SimplifyPath {

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] split = path.split("/");
        for (String s : split) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!s.equals(".") && !s.equals("")) {
                stack.push(s);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder builder = new StringBuilder();
        for (String s : stack) {
            builder.append("/");
            builder.append(s);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String path = "/home/";
        System.out.println(simplifyPath(path));//"/home"
        String path2 = "/../";
        System.out.println(simplifyPath(path2));//"/"
        String path3 = "/home//foo/";
        System.out.println(simplifyPath(path3));//"/home/foo"
        String path4 = "/a/./b/../../c/";
        System.out.println(simplifyPath(path4));//"/c"
    }
}
