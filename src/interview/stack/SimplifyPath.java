package interview.stack;

import java.util.*;
public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] routes = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String route : routes) {
            if (route.isEmpty() || route.equals(".")) {
                continue;
            }
            if (route.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else {
                stack.offerLast(route);
            }
        }
        if(stack.isEmpty())
        {
            return "/";
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty())
        {
            result.append("/").append(stack.pollFirst());
        }
        return result.toString();

    }
}
