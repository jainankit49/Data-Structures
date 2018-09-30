package com.solutions.bitwiseOperators;

import java.util.Scanner;

public class BitwiseOperators {

    /** Problem 1:
     * Given n, find the no set bits (No of 1's in Binary Representation)	
     * @param n
     * @return
     */
	// Time Complexity is O(Number of bits)
	public static int findSetBits(int n) {
		int ans=0;
		for(;n>0;n=n>>1) {
			ans = ans + (n&1);
		}
		return ans;
	}
	
	// Time Complexity is O(Number of set bits)
	public static int findSetBitsEfficient(int n) {
		int count=0;
		while(n>0) {
			count++;
			n=n&(n-1);
		}
		return count;
	}
	
	/** Problem 2:
     * PLAYING WITH BITS
     * Prateek Bhayia likes to play with bits. One day Prateek bhayia decides 
     * to assign a task to his student Sanya. You have help Sanya to complete
     *  this task. Task is as follows - Prateek Bhayia gives Q queries each 
     *  query containing two integers a and b. Your task is to count the no 
     *  of set-bits in for all numbers between a and b (both inclusive)
     *  Input Format:
     *  Read Q - No of Queries, Followed by Q lines containing 2 integers a 
     *  and b.
     *  Constraints: Q,a,b are integers.
     *  Output Format
     *  Q lines, each containing an output for your query.
     *  Sample Input
     *  2 1 1 10 15
     *  Sample Output
     *  1 17	
     * @param n
     * @return
     */
	
    public static void playingWithBits() {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=1;i<=t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int ans = 0;
            for(int j=a;j<=b;j++)
            {
                ans+=findSetBits(j);
                
            }
            System.out.print(ans+" ");
            System.out.println();
        }
        in.close();
    }
    
    
    /** Problem 3:
     * XOR Swapping	
     * @param n
     * @return
     */
    public static void swapNumbers(int a, int b) {
    	a=a^b;
    	b=b^a;
    	a=a^b;
    }
    
    /** Problem 4:
     * Extract Ith bit of a number	
     * @param n
     * @return
     */
    public static int getIthBit(int n, int i) {
    	return (n&(1<<i))!=0?1:0;
    }
    
    /** Problem 5:
     * Set Ith bit of a number to 1	
     * @param n
     * @return
     */
    public static void setIthBit(int n, int i) {
    	int mask = 1<<i;
    	n = (n|mask);
    }
    
    /** Problem 6:
     * Clear Ith bit of a number to 0	
     * @param n
     * @return
     */
    public static void clearBit(int n, int i) {
    	int mask = ~(1<<i);
    	n = n&mask;
    }
    
    /** Problem 7:
     * Generate all subsets using bitmasking
     * Ex: Input: abc Output: a,b,c,ab,bc,ac,abc	
     * @param n
     * @return
     */
    public static void generateSubsets(char[] a) {
    	//Generate a range of numbers from 0 to 2^n-1
    	int n = a.length;
    	int range = (1<<n)-1;
    	
    	for(int i=0;i<=range;i++) {
    		filterChars(a,i);
    	}
    }
    
    public static void filterChars(char[] a, int no) {
    	int i=0;
    	while(no>0) {
    		System.out.print((no&1)>0?String.valueOf(a[i]):"");
    		i++;
    		no = no>>1;
    	}
    	System.out.println();
    }
    
    
    /** Problem 8:
     * UNIQUE NUMBER - II
     * Find two unique numbers in an array	
     * @param n
     * @return
     */
    public static void findTwoUniqueNumbers(int[] a) {
    	int res=0;
    	for(int i=0;i<a.length;i++) {
    		res=res^a[i];
    	}
    	//find the rightmost set bit in res
    	int i=0;
    	int temp=res;
    	while(temp>0) {
    		if((temp&1)>0) {
    			break;
    		}
    		i++;
    		temp=temp>>1;
    	}
    	
    	int mask = 1<<i;
    	
    	int firstNo=0;
    	
    	for(int j=0;j<a.length;j++) {
    		if((a[j]&mask)!=0) {
    			firstNo = firstNo^a[j];
    		}
    	}
    	
    	int secondNo = res^firstNo;
    	System.out.println("First Number:" +firstNo + ", "  + "Second Number: " +secondNo);
    }
    
    /** Problem 9:
     * UNIQUE NUMBER - I
     * We are given an array containing n numbers. All the numbers are present 
     * twice except for one number which is only present once. 
     * Find the unique number without taking any extra spaces and in 
     * linear time. ( Hint - Use Bitwise )
     * Input Format:
     * First line contains the number n. 
     * Second line contains n space separated number.	
     * @param n
     * @return
     */
    public static void findUniqueNumber() {
        Scanner in = new Scanner(System.in);
         int t=in.nextInt();
         int a[] = new int[t];
         for(int i=0;i<t;i++){
             a[i] = in.nextInt();
         }
         int ans=0;
         for(int i=0; i<a.length; i++){
           ans = ans^a[i];
         }
         System.out.print(ans);
         in.close();
     }
    
    /** Problem 10:
     * UNIQUE NUMBER - III	
     * In an array, all numbers are repeated three times, except one
     * number which is repeated only once. Find that number.
     * @param n
     * @return
     */
    public static int findUniqueNumberThree(int[] a) {
    	int cnt[] = new int[64];
    	for(int i=0;i<a.length;i++) {
    		int j=0;
    		int no = a[i];
    		while(no>0) {
    			cnt[j] += (no&1);
    			j++;
    			no = no >>1;
    		}
    	}
    	
    	int q=1;
    	int ans=0;
    	for(int p=0;p<cnt.length;p++) {
    		cnt[p] %=3;
    		ans += cnt[p]*q;
    		q=q<<1;
    	}
    	return ans;
    }
    
    /** Problem 11:
     * INCREDIBLE HULK
     * The Planet Earth is under a threat from the aliens of the outer space 
     * and the Marvel Avengers team is busy fighting against them. 
     * Meanwhile, The Incredible Hulk has to defeat an enemy who is N steps
     *  above the level where he is standing (assume it as the 0th level). 
     *  Hulk, because of his incredible jumping ability can take jumps in 
     *  power of 2. In order to defeat the enemy as quickly as possible he 
     *  has to reach the Nth step in minimum moves possible. Help Hulk to 
     *  find the same and contribute in saving the Mother Earth.
     *  Input Format:
     *  The first line contains the number of test cases T. 
     *  T test cases follow: The first line of each test case contains 
     *  a number N.
     *  Constraints:1 <= T <= 10 1 <= N <= 10^5
     *  Output Format
     *  Output T lines, containing the minimum number of moves required 
     *  by Hulk to reach the Nth step
     *  Sample Input
     *  3 3 4 5
     *  Sample Output
     *  2 1 2
     * @param n
     * @return
     */
    
    public static void incredibleHulk() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0;i<t;i++){
          int ans = countSetBits(in.nextInt());
          System.out.print(ans + " ");
        }
        in.close();
    }
    
    public static int countSetBits(int n){
      int ans=0;
      while(n>0){
        ans += n&1;
        n = n>>1;
      }
      return ans;
    }
    
    
    /** Problem 12:
     * TAVAS AND SADDAS
     * Once again Tavas started eating coffee mix without water! Keione told him that it smells awful, but he didn't stop doing that. 
     * That's why Keione told his smart friend, SaDDas to punish him! SaDDas took Tavas' headphones and told him: 
     * "If you solve the following problem, I'll return it to you."The problem is:
     * You are given a lucky number n. Lucky numbers are the positive integers whose decimal representations contain only the 
     * lucky digits 4 and 7. For example, numbers 47, 744, 4 are lucky and 5, 17, 467 are not.
     * If we sort all lucky numbers in increasing order, what's the 1-based index of n?
     * Tavas is not as smart as SaDDas, so he asked you to do him a favor and solve this problem so he can have his 
     * headphones back.
     * The first and only line of input contains a lucky number n (1 ≤ n ≤ 109).
     * Print the index of n among all lucky numbers.
     * Sample Input:4
     * Sample Output:1	
     * @param n
     * @return
     */
     public static int indexLuckyNumber(char[] n) {
    	 int len = n.length;
    	 int ans=0;
    	 ans = (1<<len) -2;
    	 
    	 for(int i=len-1,pos=0;i>=0;i--,pos++) {
    		 if(n[i]=='7') {
    			 ans += (1<<pos);
    		 }
    	 }
    	 return ans+1;
     }
    
     
     /** Problem 13:
      * XOR PROFIT PROBLEM
      * We are given two coins of value x and y. We have to find the maximum of value of a XOR b where x <= a <= b <= y.
      * Input Format:
      * We are given two integers x and y
      * Constraints: l <= r <= 1000
      * Output Format
      * Print the maximum value of a XOR b
      * Sample Input: 5 6
      * Sample Output: 3	
      * @param n
      * @return
      */
     
     public static void XORProfit() {
         Scanner in = new Scanner(System.in);
         int a = in.nextInt();
         int b = in.nextInt();
         int max=0;
         int ans=0;
         for(int i=a;i<b;i++){
           for(int j=a+1;j<=b;j++){
             ans = i^j;
             if(ans>max){
               max=ans;
             }
           }
         }
         System.out.println(max);
         in.close();
     }
     
    /** Problem 14:
     * SUBSET SUM EASY
     * Mike is a very passionate about sets. Lately, he is busy solving one of the problems on sets. 
     * He has to find whether if the sum of any of the non-empty subsets of the set A is zero.
     * Input Format:
     * The first line contains an integer T, which is the total number of test cases. T test cases follow.
     * Each test case consists of two lines.
     * The first line consists of a single integer N, which is the number of elements
     * present in the set A. The second line contains the integer in the set.
     * Constraints: 1 ≤ T ≤10 1 ≤ N ≤ 4 -10^5 ≤ A[i] ≤ 10^5
     * Output Format
     * If the sum of any of the subset is zero, then print “Yes” (without quotes) else print “No”(without quotes).
     * Sample Input: 1 4 1 2 3 -3
     * Sample Output: Yes
     * @param n
     * @return
     */
     public static void subsetSum() {
    	  Scanner in = new Scanner(System.in);
     	 int t = in.nextInt();
     	 int flag=0;
     	 for(int i=0;i<t;i++) {
     		 int arraySize = in.nextInt();
     		 int[] inputArray = new int[arraySize];
     		 for(int j=0;j<arraySize;j++) {
     			 inputArray[j]=in.nextInt();
     		 }
     		 
     		 int range = (1<<arraySize)-1;
     		 for(int p=0;p<=range;p++) {
     			int result = filterNumbers(inputArray,p);
     			if(p!=0 && result==0) {
        			 System.out.println("Yes");
        			 flag=1;
        			 break;
        		 	}
     		 }
     		 if(flag==0) {
     			 System.out.println("No");
     		 }
     	 }
     	 in.close();
     }
     
     public static int filterNumbers(int [] inputArray, int n) {
    	 int q=0;
    	 int ans=0;
    	 while(n>0) {
    		 if((n & 1) == 1) {
    			 ans += inputArray[q];
    			 n = n >> 1;
    		   q++;
    		 }
    	 }
    	 return ans;
     }
}



    
