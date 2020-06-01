package leetcodeSolutions;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Definition for a point.
 * 
 */
class Point {
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
}

class TreeNode{
	TreeNode left;
	TreeNode right;
	int val;
	
	TreeNode(int val){
		this.val = val;
	}
	
}

class Entry{
	private final Object value;
	private final Long expiration;
	private final Long timeStamp;
	
	public Entry(Object val, Long expiration) {
		this.value = val;
		this.expiration = expiration;
		this.timeStamp = System.currentTimeMillis();
	}
	
	public boolean isExpired() {
		return (timeStamp + expiration) < System.currentTimeMillis();
	}
	
	public Object getValue() {
		return this.value;
	}
}

public class LeetCodeSolutions {

	/**
	 * Problem 1: Max Points in a line
	 * https://medium.com/@harycane/max-points-on-a-line-1e38f51d591f 
	 * @param points
	 * @return
	 */

	public int maxPoints(Point[] points) {
		//declare HashMap and result variable
		int result = 0;
		Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();

		for(int i=0;i<points.length;i++){
			map.clear();

			int overlap = 0;
			int max = 0;

			for(int j=i+1; j<points.length;j++){
				//Compute the slope numerator and denominator     
				int x = points[j].x - points[i].x;
				int y = points[j].y - points[i].y;

				if(x==0 && y==0) {
					overlap++;
					continue;
				}

				int gcd = generateGCD(x,y);

				if(gcd!=0) {
					x /= gcd;
					y /= gcd;
				}

				if(map.containsKey(x)) {
					if(map.get(x).containsKey(y)) {
						map.get(x).put(y,map.get(x).get(y) + 1);
					}
					else {
						map.get(x).put(y, 1);
					}
				}
				else {
					Map<Integer,Integer> m = new HashMap<>();
					m.put(y, 1);
					map.put(x, m);
				}

				max = Math.max(max, map.get(x).get(y));

			}
			result = Math.max(result, max+overlap+1);
		}
		return result;
	}

	public int generateGCD(int a, int b) {
		if(b==0) {
			return a;
		}
		return generateGCD(b,a%b);
	}


	/**
	 * Problem 2: Letter Combinations of a Phone Number  https://leetcode.com/problems/letter-combinations-of-a-phone-number/
	 * https://www.youtube.com/watch?v=a-sMgZ7HGW0
	 * @return
	 */

	private static final String[] MAPPING = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public List<String> letterCombinations(String digits) {
		char[] partialMnemonics = new char[digits.length()];
		List<String> mnemonics = new ArrayList<>();
		if(digits.length() ==0){
			return mnemonics;
		}
		partialMnemonicsHelper(digits, 0, partialMnemonics, mnemonics);
		return mnemonics;
	}

	private void partialMnemonicsHelper(String phoneNumber, int digit, char[] partialMnemonics, List<String> mnemonics) {

		if(digit == phoneNumber.length()){
			mnemonics.add(new String(partialMnemonics));
		}
		else
		{
			for(int i=0; i< MAPPING[phoneNumber.charAt(digit) - '0'].length(); i++){
				char c = MAPPING[phoneNumber.charAt(digit) - '0'].charAt(i);
				partialMnemonics[digit]=c;
				partialMnemonicsHelper(phoneNumber, digit+1, partialMnemonics, mnemonics);
			}
		}    
	}


	/**
	 * Problem 3: Serialize and Deserialize a binary tree  https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
	 * https://medium.com/@dimko1/serialize-and-deserialize-binary-tree-e9811ead85ed
	 * @return
	 */	    
	public String serialize(TreeNode root) {
		if(root == null) {
			return "#";
		}
		return "" + root.val + " " + serialize(root.left) + serialize(root.right);
	}
	
	public TreeNode deserialize(String data) {
		return build(new Scanner(data));
	}
	
	public TreeNode build(Scanner sc) {
		if(!sc.hasNext()) {
			return null;
		}
		
		String tk = sc.next();
		if(tk.equals("#")) {
			return null;
		}
		
		TreeNode root = new TreeNode(Integer.parseInt(tk));
		root.left = build(sc);
		root.right = build(sc);
		return root;
	}
	
	/**
	 * Problem 4: Implement a hashmap where entries expires after some time
	 * https://www.careercup.com/question?id=5689672300756992
	 * @return
	 */	
	private static ConcurrentHashMap<String, Entry> cache = new ConcurrentHashMap<>(); 
	
	public void put(String key, Object value, Long expiration) {
		cache.put(key, new Entry(value, expiration));
	}
	
	public Object get(String key) {
		Entry entry = cache.get(key);
		
		if(entry!=null) {
			if(!entry.isExpired()) {
				return entry.getValue();
			}
			else 
			{
				cache.remove(key);
				return null;
			}
		}
		return null;
	}
	
	
	/**
	 * Problem 5: Maximum Histogram Area
	 * 
	 * Given an array representing height of bar in bar graph, find max histogram
	 * area in the bar graph. Max histogram will be max rectangular area in the
	 * graph.
	 * 
	 * Maintain a stack
	 * 
	 * If stack is empty or value at index of stack is less than or equal to value at current 
	 * index, push this into stack.
	 * Otherwise keep removing values from stack till value at index at top of stack is 
	 * less than value at current index.
	 * While removing value from stack calculate area
	 * if stack is empty 
	 * it means that till this point value just removed has to be smallest element
	 * so area = input[top] * i
	 * if stack is not empty then this value at index top is less than or equal to 
	 * everything from stack top + 1 till i. So area will
	 * area = input[top] * (i - stack.peek() - 1);
	 * Finally maxArea is area if area is greater than maxArea.
	 * 
	 * Video link https://youtu.be/ZmnqCZp9bBs
	 * 
	 * Time complexity is O(n)
	 * Space complexity is O(n)
	 * @return
	 */	
	
	 public int maxHistogramArea(int[] input) {
		 Deque<Integer> stack = new LinkedList<Integer>();
		 int area = 0;
		 int maxArea = 0;
		 int i;
		 
		 for(i=0;i<input.length;) {
			 if(stack.isEmpty() || input[stack.peekFirst()] <= input[i]) {
				 stack.offerFirst(i++);
			 }
			 else 
			 {
				int top = stack.pollFirst(); 
				if(stack.isEmpty()) {
					area = input[top]*i;
				}
				else 
				{
					area = input[top]*(i-stack.peekFirst()-1);
				}
				if(area > maxArea) {
					maxArea = area;
				}
			 }
		 }
		 
		 while(!stack.isEmpty()) {
			 int top = stack.pollFirst();
			 
			 if(stack.isEmpty()) {
				 area = input[top]*i;
			 }
			 else 
			 {
				 area = input[top]*(i-stack.peekFirst()-1);
			 }
			 if(area>maxArea) {
				 maxArea = area;
			 }
		 }
		 return maxArea;
	 }
	


}
