package 栈;

import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * @author michaelyang
 *
 */
public class _20_有效括号 {
	
	private static HashMap<Character, Character> map = new HashMap<>();
	
	static {
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
	}
	
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				stack.push(c);
			}else {
				if (stack.isEmpty()) return false;
				if (c != map.get(stack.pop())) return false;
			}
		}
		return stack.isEmpty();
    }
}
