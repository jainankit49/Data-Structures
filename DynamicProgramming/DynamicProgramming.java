package com.solutions.dynamicProgramming;

public class DynamicProgramming {

	static int memo[] = new int[1000];
	/**
	 * Problem 1.1: Fibonacci Number (Memoization - Top Down Approach)
	 * @param args
	 */
	public static int findFibonaaci(int n) {
		if(n==0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		if(memo[n]!=-1) {
			return memo[n];
		}
		int ans = findFibonaaci(n-1) + findFibonaaci(n-2);
		memo[n]=ans;
		return ans;
	}
	
	
	/**
	 * Problem 1.2: Fibonacci Number (Bottom Up Approach)
	 * @param args
	 */
	public static int findFibonacciBottomUp(int n) {
		int dp[] = new int[1000];
		dp[0]=0;
		dp[1]=1;
		
		for(int i=2;i<=n;i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		return dp[n];
	}
	
	
	
	/**
	 * Problem 2.1: Reduce a number to one in minimum number of steps (Memoization - Top Down Approach)
	 * @param args
	 */
	public static int reduceNumber(int n) {
		
		if(n==1) {return 0;}
		int q1 = Integer.MAX_VALUE;
		int q2 = Integer.MAX_VALUE;
		int q3 = Integer.MAX_VALUE;
		
		if(memo[n] != -1) {
			return memo[n];
		}
		
		if(n%3 == 0) {
			q1 = 1 + reduceNumber(n/3);
		}
		if(n%2 == 0) {
			q2 = 1 + reduceNumber(n/2);
		}
		q3 = 1 + reduceNumber(n-1);
		
		int ans = Math.min(q1, Math.min(q2,q3));
		memo[n] = ans;
		return ans;
	}
	
	
	/**
	 * Problem 2.2: Reduce a number to one in minimum number of steps (DP - Bottom Up Approach)
	 * @param args
	 */
	public static int reduceNumber_DP(int n) {
		int dp[] = new int[1000];
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		
		for(int i=4; i<=n;i++) {
			int q1 = Integer.MAX_VALUE;
			int q2 = Integer.MAX_VALUE;
			int q3 = Integer.MAX_VALUE;
			
			if(n%3 == 0) {
				q1 = 1 + reduceNumber(n/3);
			}
			if(n%2 == 0) {
				q2 = 1 + reduceNumber(n/2);
			}
			q3 = 1 + reduceNumber(n-1);
			
			dp[n] = Math.min(q1, Math.min(q2,q3));
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
	   int n = 21;
	   for(int i=0;i<=n;i++) {
		   memo[i]=-1;
	   }
	   //System.out.println(findFibonaaci(n));
	   //System.out.println(findFibonacciBottomUp(n));
	   System.out.println(reduceNumber_DP(n));
	}

}
