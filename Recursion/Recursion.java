package com.solutions.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Recursion {

	/** Problem 1:
     * Given n, find nth term of Fibonacci Series	
     * @param n
     * @return
     */
	public static int fibonacci(int n) {
		if(n==0 || n==1) {
			return 1;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	
	/** Problem 2:
     * Given an array, check if the array is sorted or not	
     * @param n
     * @return
     */
	static int i=0;
	public static boolean isSorted(int[] a, int n) {
		if(n==1) {
			return true;
		}	
		if(a[0]<=a[1] && isSorted(Arrays.copyOfRange(a,i+1, a.length), n-1)) {
			return true;
		}
		return false;
	}
	
	
	/** Problem 3:
     * POWER(O(LOGN))
     * Take as input x and n, two numbers. Write a function to calculate x raise to power n. Target complexity is O(logn). 
     * NOTE: Try both recursive and bitmasking approach.
     * Input Format:Enter the number N and its power P
     * Constraints:None
     * Output Format: Display N^P
     * Sample Input: 2 3
     * Sample Output:8	
     * @param n
     * @return
     */
	// Time Complexity: O(B)
	public static int pow(int a, int b){
	      if(b==0){
	        return 1;
	      }
	      else{
	        return (a*pow(a,b-1));
	      }
    }
	
	// Time complexity: O(logB)
	public static int fastPower(int a, int b) {
		if(b==0) {
			return 1;
		}
		
		int smallAns = fastPower(a,b/2);
		smallAns = smallAns*smallAns;
		
		if((b&1)>0) {
			return a*smallAns;
		}
		return smallAns;
	}
	
	/** Problem 4:
     * Given a number n, print an increasing and decreasing sequence of 1-n using recursion	
     * @param n
     * @return
     * PS: Anything return before the recursive function call will be executed in upward direction of call stack 
     * and anything written after the recursive function call will be executed in downward direction of call stack 
     */                                                                 
	public static void increasingSequence(int n) {
		if(n==0) {
			return;
		}
		increasingSequence(n-1);
		System.out.print(n + " ");
	}
	
	public static void decreasingSequence(int n) {
		if(n==0) {
			return;
		}
		System.out.print(n + " ");
		decreasingSequence(n-1);
	}
	
	 /** Problem 5:
	   * Multiply two numbers using recursion without using '*'
	   * @param n
	   * @return
	   */
	public static int multiply2(int num1, int num2) {
		if(num1==0 || num2==0) {
			return 0;
		}
		else if(num2<0) {
			return -num1 + multiply2(num1,num2+1);
		}
		else {
			return num1 + multiply2(num1,num2-1);
		}
	}
	
	/** Problem 6:
	   * Convert a string to integer using recursion
	   * @param n
	   * @return
	   */
	static int x=0;
	public static int stringToInteger(String s) {
	    if(s.length()==1) {
	    	x = (x*10) + Integer.parseInt(s.substring(0,1));
	    	return x;
	    }
	    else 
	    {
	    	x = (x*10) + Integer.parseInt(s.substring(0,1));
	    	return stringToInteger(s.substring(1));
	    }    
	}
	
	/** Problem 7:
	   * Tiling Problem
	   * Given a brick wall of 4 X N, and tiles of size 4 X 1 and 1 X 4, you have to find out the 
	   * total no of ways to arrange tiles on the wall.
	   * @param n
	   * @return
	   */
	public static int tilingProblem(int n) {
		if(n>=1 && n<=4) {
			return n;
		}
		return tilingProblem(n-1) + tilingProblem(n-4);
	}
	
	
	/** Problem 8:
	   * 2048 Problem
	   * Given an integer, spell that integer using recursion 
	   * Ex: 2048   -->  two zero four eight
	   * @param n
	   * @return
	   */
	static String spellings[] = {"zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	public static void print(int n) {
		if(n==0) {
			return;
		}
		print(n/10);
		System.out.print(spellings[n%10] + " ");
	}
	
	
	/** Problem 9:
	   * Linear Search
	   * Implement Linear Search recursively
	   * @param n
	   * @return
	   */
	public static int linearSearch(int[] a, int i, int n, int key) {
		if(i==n) {
			return -1;
		}
		if(a[i]==key) {
			return i;
		}
		return linearSearch(a,i+1,n,key);
	}
	
	
	/** Problem 10:
	   * Binary Search
	   * Implement Binary Search recursively
	   * @param n
	   * @return
	   */
	public static int binarySearch(int[] a, int low, int high, int key) {
		int mid = (low + (high-low))/2;
		if(a[mid]==key) {
			return mid;
		}
		if(a[mid]< key) {
			return binarySearch(a,low,mid-1,key);
		}
		else 
		{
		  return binarySearch(a,mid+1,high, key);	
		}
	}
	
	/** Problem 11:
	   * Bubble Sort
	   * Implement Bubble Sort recursively
	   * @param n
	   * @return
	   */
	public static void bubbleSort(int[] a, int n) {
		//Base Case
		if(n==1) {
			return;
		}
		
		for(int j=0;j<=n-2;j++) {
			if(a[j]>a[j+1]) {
				int temp = a[j];
				a[j] = a[j+1];
				a[j+1] = temp;
			}
		}
		
		bubbleSort(a,n-1);
	}
	
	
	public static void bubbleSort2(int[] a, int j, int n) {
		//Base Case
		if(n==1) {
			return;
		}
		if(j==n-1) {
			bubbleSort2(a,0,n-1);
		}
		
		//Rec Case
		if(a[j]>a[j+1]) {
			int temp = a[j];
			a[j] = a[j+1];
			a[j+1] = temp;
		}
		bubbleSort2(a,j+1,n);
		return;
	}
	
	
	/** Problem 12:
	   * Tower of Hanoi
	   * @param n
	   * @return
	   */
	public static void towerOfHanoi(int n, char src, char dest, char helper) {
		//Base Case
		if(n==0) {
			return;
		}
		
		//Recursive Case
		//First move N-1 disks from src to helper
		towerOfHanoi(n-1,src,helper,dest);
		System.out.println("Move " +n +" disk from " +src+" to " +dest);
		towerOfHanoi(n-1,helper,dest,src);	
	}
	
	

	/** Problem 13:
	   * Merge Sort
	   * Implement Merge Sort recursively
	   * @param n
	   * @return
	   */
    public static void mergeSort(int[] a, int s, int e) {
    	//Base Case 1 or 0 elements
    	if(s>=e) {
    		return;
    	}
    	
    	//Recursive Case
    	//1. Divide
    	int mid = (s+e)/2;
    	
    	//Recursively sort the arrays - s,mid and mid+1, end
    	mergeSort(a,s,mid);
    	mergeSort(a,mid+1,e);
    	
    	//Merge the two parts
    	merge(a,s,e);
    	
    }
    
    public static void merge(int[] a, int s, int e) {
    	int mid = (s+e)/2;
    	int i=s;
    	int j=mid+1;
    	int k=s;
    	
    	int[] temp = new int[a.length];
    	while(j<=e && i<=mid) {
    		if(a[i]<a[j]) {
    			temp[k++] = a[i++];
    		}
    		else 
    		{
    		   temp[k++] = a[j++];	
    		}
    	}
    	
    	while(i<=mid) {
    		temp[k++] = a[i++];
    	}
    	
    	while(j<=e) {
    		temp[k++] = a[j++];
    	}
    	
    	for(int q=s; q<=e;q++) {
    		a[q]=temp[q];
    	}
    }
	
    
    /** Problem 14:
	   * Quick Sort
	   * Implement Quick Sort recursively
	   * Time Complexity: Avg Case: O(nlogn), Worst Case (Sorted Array): O(n)2
	   * @param n
	   * @return
	   */
    public static void quickSort(int[] a, int s, int e) {
    	//Base Case: When 0 or 1 elements
    	if(s>=e) {
    		return;
    	}
    	
    	//Recursive Case
    	int p = partition(a, s, e);
    	quickSort(a,s,p-1);
    	quickSort(a,p+1,e);
    }
    
    public static int partition(int[] a, int s, int e) {
    	int i = s-1;
    	int j=s;
    	int pivot = a[e];
    	
    	for(;j<e;j++) {
    		if(a[j]<=pivot) {
    			i++;
    			swap(a, i, j);
    		}
    	}
    	//Bring the pivot element to its sorted position
    	swap(a, i+1, e);
    	return i+1;
    }
	
    public static void swap(int[] a, int s, int e) {
    	int temp = a[s];
    	a[s] = a[e];
    	a[e] = temp;
    }
    
    /** Problem 15:
	   * Randomized Quick Sort
	   * Shuffle all elements of array randomly and then apply quick sort
	   * Time Complexity: O(nlogn)
	   * @param n
	   * @return
	   */
    public static void shuffle(int[] a, int n) {
    	Random r = new Random();
    	
    	for(int i=n-1;i>0;i--) {
    		int j = r.nextInt(i);
    		int temp = a[i];
    		a[i] = a[j];
    		a[j] = temp;
    	}
    }
    
    public static void randomizedQuickSort(int[] a) {
    	shuffle(a,a.length);
    	quickSort(a,0,a.length-1);
    }
    
    
    /** Problem 16:
	   * RECURSION - ALL SUBSEQUENCES
	   * Print all the subsequences of a string
	   * @param n
	   * @return
	   */
    public static void printSubsequences(String input) {
    	printSubsequences(input,"");
    }
    public static void printSubsequences(String input, String output) {
    	//Base Case
    	if(input.length() == 0) {
    		System.out.println(output);
    		return;
    	}
    	
    	//Recursive Case
    	// 1) Include the current char
    	printSubsequences(input.substring(1), output+input.charAt(0));
    	
    	//2) Exclude the current char
    	printSubsequences(input.substring(1), output);
    	
    }
    
     /** Problem 17:
	   * RECURSION - ALL SUBSEQUENCES IN LEXICOGRAPHICAL ORDER
	   * Print all the subsequences of a string in lexicographical order
	   * @param n
	   * @return
	   */
    static TreeSet<String> sortedSet;
    public static void printSubSequences() {
    	Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++) {
        	sortedSet= new TreeSet<String>();
        	String ip = in.next();
        	printSubSequences(ip,"");
        	for (String treeKey : sortedSet) {
			      System.out.println(treeKey);
				}
        }
    }
   
    public static void printSubSequences(String input, String output) {
    	if(input.length()==0) {
    		sortedSet.add(output);
    		//if(sortedSet.size()==(2^(input.length()))) {
    			
    			//}
    		return;
    	}
    		
    	printSubSequences(input.substring(1),output+input.charAt(0));
    	printSubSequences(input.substring(1),output);
    }
    

    /** Problem 18:
	   * RECURSION-ASCII SUBSEQUENCES
	   * Take as input str, a string. We are concerned with all the possible ascii-subsequences of str. E.g. “ab” has following ascii-subsequences “”, “b”, “98”, “a”, “ab”, “a98”, “97”, “97b”, “9798”
	   * a. Write a recursive function which returns the count of ascii-subsequences for a given string. Print the value returned.
	   * b. Write a recursive function which prints all possible ascii-subsequences for a given string (void is the return type for function).
	   * Print all the subsequences of a string in lexicographical order
	   * @param n
	   * @return
	   */
    static TreeSet<String> sortedAsciiSet;
    public static void printAsciiSubSequences() {
    	Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++) {
        	sortedAsciiSet= new TreeSet<String>();
        	String ip = in.next();
        	printAsciiSubSequences(ip,"");
        	System.out.print(sortedAsciiSet.size() + " ");
        	for (String treeKey : sortedAsciiSet) {
			      System.out.print(treeKey + " ");
				}
        }
    }
   
    public static void printAsciiSubSequences(String input, String output) {
    	if(input.length()==0) {
    		sortedAsciiSet.add(output);
    		return;
    	}
    		
    	printAsciiSubSequences(input.substring(1),output+input.charAt(0));
    	printAsciiSubSequences(input.substring(1),output);
    	printAsciiSubSequences(input.substring(1),output+(int)input.charAt(0));
    }
    
    /** Problem 19:
	   * Phone Keypad
	   * Given an android smart phone keypad, input is a number and you have to print all possible names (strings) generated by the keypad using given number
	   * @param n
	   * @return
	   */
    static HashMap<Integer, String> numberMap = new HashMap<Integer, String>();
 
    public static void phoneKeypad(String digits) {
    	   numberMap.put(0,"");
    	   numberMap.put(1,"");
    	   numberMap.put(2,"ABC");
    	   numberMap.put(3,"DEF");
    	   numberMap.put(4,"GHI");
    	   numberMap.put(5,"JKL");
    	   numberMap.put(6,"MNO");
    	   numberMap.put(7,"PQRS");
    	   numberMap.put(8,"TUV");
    	   numberMap.put(9,"WXYZ");
    
    	  
    	   ArrayList<Character> temp = new ArrayList<Character>();
    	   printKeyPadString(digits, temp, numberMap); 
    	   
    }
    
    public static void printKeyPadString(String input, ArrayList<Character> temp, HashMap<Integer, String> map) {
    	//Base Case
    	if(input.length()==0) {
    		char[] arr = new char[temp.size()];
    		for(int i=0; i<temp.size();i++) {
    			arr[i] = temp.get(i);
    		}
    		System.out.println("");
    		printArray(arr);
    		return;
    	}
    	
    	//Recursive case
    	Integer curr = Integer.valueOf(input.substring(0, 1));
    	String letters = numberMap.get(curr);
    	for(int i=0; i<letters.length();i++) {
    		temp.add(letters.charAt(i));
    		printKeyPadString(input.substring(1),temp,map);
    		temp.remove(temp.size()-1);
    	}	
    }
    
    public static void printArray(char[] arr) {
    	for(int i=0;i<arr.length;i++) {
    		System.out.print(arr[i]);
    	}
    }
    
    /** Problem 20:
	   * Permutations
	   * Given a string s, task is to find all possible permutations of string 
	   * @param n
	   * @return
	   */
    public static void permute(char[] input, int i) {
    	//Base Case
    	if(i==input.length) {
    		printArray(input);
    		System.out.println();
    		return;
    	}
    	
    	//Recursive Case
    	for(int j=i;j<input.length;j++) {
    		swap(input,i,j);
    		permute(input,i+1);
    	
    		//Backtracking -- To restore the original array
    		swap(input,i,j);
    	}
    }
    
    /** Problem 21:
	   * N Queen Problem using recursion
	   * Place N queens in a board such that all queens are safe
	   * @param n
	   * @return
	   */
    public static boolean solveNQueen(int board[][], int i, int n) {
    	//Base Case
    	if(i==n) {
    		//You have successfully placed Queens in n rows (0 ... n-1);
    		//Print the board
    		for(i=0; i<n;i++) {
    			for(int j=0;j<n;j++) {
    				if(board[i][j]==1) {
    					System.out.print("Q");
    				}
    				else {
    					System.out.print("-");
    				}	
    			}
    		System.out.println();	
    		}
    		
    		System.out.println();	
    		return false; // Change it to return false if want to generate all possible combination of N Queen placement
    	}
    	
    	//Recursive Case
    	//Try to place the queen in the current row call on the remaining part which will be solved by recursion
    	for(int j=0;j<n;j++) {
    		// I have to check if i,j th position is safe to place the queen or not
    		if(safeToPlaceQueen(board,i,j,n)) {
    			// Place the queen - assuming i,j is the right position
    			board[i][j]=1;
    			boolean nextQueenSafelyPlaced = solveNQueen(board,i+1,n);
    			if(nextQueenSafelyPlaced) {
    				return true;
    			}
    			// Means i,j is not the right position - assumption is wrong
    			board[i][j]=0; //Backtrack
    		}
    		
    	}
    	// You have tried for all positions in current row but could not place a queen
    	return false;
    }
    
    public static boolean safeToPlaceQueen(int board[][], int i, int j,int n) {
    	//Check for the presence of queen in top rows of same column
    	for(int row=0;row<i;row++) {
    		if(board[row][j]==1) {
    			return false;
    		}
    	}
    	
    	//Check for Left Diagonal
    	int x=i;
    	int y=j;
    	while(x>=0 && y>=0) {
    		if(board[x][y]==1) {
    			return false;
    		}
    		x--;
    		y--;
    	}
    	
    	//Check for Right Diagonal
    	x=i;
    	y=j;
    	while(x>=0 && y<n) {
    		if(board[x][y]==1) {
    			return false;
    		}
    		x--;
    		y++;
    	}
    	// The position is now safe, col and diagonals
    	return true;
    }
    
    public static void swap(char[] input, int i, int j) {
    	char temp = input[i];
    	input[i] = input[j];
    	input[j] = temp;
    }
    
    
    
    /** Problem 22:
	   * N Queen Problem using bitsets (Count number of ways to place queens in NXN grid)
	   * Place N queens in a board such that all queens are safe
	   * @param n
	   * @return
	   */
    static BitSet col = new BitSet(30);
    static BitSet d1 = new BitSet(30);
    static BitSet d2 = new BitSet(30);
    static int ans =0;
    public static void solveNQueen(int r, int n, int ans) {
    	//Base Case
    	if(r==n) {
    		ans++;
    		return;
    	}
    	
    	//Recursive Case
    	for(int c=0;c<n;c++) {
    		if(!col.get(c) && !d1.get(r-c+n-1) && !d2.get(r+c)) {   // r-c for left diagonal and n-1 to shift negative index to positive ones,  r+c for right diagonal
    			col.set(c);
    			d1.set(r-c+n-1);
    			d2.set(r+c);
    			solveNQueen(r+1,n,ans);
    			//Agar hum yaha se wapas aa gaye to that means queen can be set in next row so we need to move queen to a new position in last row and thus we'll set all positions done for last row (in short Backtracking)
    			col.clear(c);
    			d1.clear(r-c+n-1);
    			d2.clear(r+c);
    		}
    	}
    }
    
    
    
    /** Problem 23:
	   * Rat in a Maze
	   * Given a MXN matrix, with some cells blocked, you have to 
	   * 1) Find path from sec to destination
	   * 2) Count the number of paths from  src to destination
	   * 3) Print all possible paths
	   * Given the rat can only move forward and down
	   * @param n
	   * @return
	   */
    public static boolean ratInMaze(char[][] maze, int soln[][], int i, int j, int m, int n) {
    	//Base Case
    	if(i==m && j==n) {
    		soln[i][j]=1;
    		
    		//Print the solution array
    		for(i=0; i<=m;i++) {
    			for(j=0; j<=n;j++) {
    				System.out.print(soln[i][j] + " ");
    			}
    			System.out.println();
    		}
    		System.out.println();
    		return true;
    	}
    	
    	//Rat should be inside grid
    	if(i>m || j>n) {
    		return false;
    	}
    	
    	//Check for blocks in path
    	if(maze[i][j]=='X') {
    		return false;
    	}
    	
    	//Assume solution exist through current cell
    	soln[i][j]=1;
    	
    	//Recursive Case
    	boolean rightSuccess = ratInMaze(maze,soln, i, j+1, m, n);
    	boolean downSuccess = ratInMaze(maze, soln,i+1,j,m,n );
    	
    	//Backtracking Case
    	// Function call k bad jo steps hote hai wo wapas jane wale steps hote hai. Base case hit hone k bad ye steps execute honge. Return karne se phle jis bhi cell se hum wapas ja rha hai, waha 0 set karke jayenge. 
    	soln[i][j]=0;
    	
    	if(rightSuccess || downSuccess) {
    		return true;
    	}
    	
    	return false;
    	
    }
    
    /** Problem 24:
	   * Sudoku Solver
	   * Given a NXN Sudoku, N is a perfect square
	   * write an algorithm which finds a possible solution
	   * @param n
	   * @return
	   */
    public static boolean solveSudoku(int[][] mat, int i, int j, int n) {
    	//Base Case
    	if(i==n) {
    		//Print Sudoku
    		for(int k=0;k<n;k++) {
    			for(int l=0;l<n;l++) {
    				System.out.print(mat[k][l] + " ");
    			}
    			System.out.println();
    		}
    		
    		return true;
    	}
    	//Case Row End
    	if(j==n) {
    		return solveSudoku(mat, i+1,0,n);
    	}
    	//Skip the pre filled cells
    	if(mat[i][j]!=0) {
    		return solveSudoku(mat, i, j+1,n);
    	}
    	
    	//Recursive Case
    	//Fill the current cell with possible options
    	for(int number=1;number<=n;number++) {
    		if(canPlace(mat,i,j,n,number)) {
    			//Assume
    			mat[i][j] = number;
    			
    			boolean couldWeSolve = solveSudoku(mat,i,j+1,n);
    			if(couldWeSolve) {
    				return true;
    			}
    		}
    	}
    	//Backtrack here
    	mat[i][j]=0;
    	return false;
    }
    
    public static boolean canPlace(int[][] mat, int i, int j, int n, int number) {
    	for(int x=0;x<n;x++) {
    		//Row and Column Check 
    		if(mat[x][j]==number || mat[i][x]==number) {
    			return false;
    		}
    	}
    	
    	int rn = (int) Math.sqrt(n);
    	int sx = (i/rn)*rn;
    	int sy = (j/rn)*rn;
    	
    	//Sub Grid check
    	for(int x=sx;x<sx+rn;x++) {
    		for(int y=sy;y<sy+rn;y++) {
    			if(mat[x][y]==number) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    
    /** Problem 25:
	   * Replace all PI
	   * Replace all occurrences of pi with 3.14
	   * Input Format:
	   * Integer N, no of lines with one string per line like  
	   * 3
	   * xpix
	   * xabpixx3.15x
	   * xpipixx
	   * Output Format:
	   * x3.14x
	   * xab3.14xx3.15x
	   * x3.143.14p3.14xx
	   * Constraints:
	   * 0 < N < 1000 0 <= len(str) < 1000
	   * Output Format
	   * Output result one per line
	   * 
	   * @param n
	   * @return
	   */
    public static void replaceAllPI() {
    	Scanner in = new Scanner(System.in);
        int n=in.nextInt();
    }
	public static void main(String args[]) {
		//System.out.println(fibonacci(5));
		//int [] a = {1,1,1,2,2,2,3,3,3,4,4,4,5};
		//System.out.println(isSorted(a,13));
		//System.out.println(fastPower(5,5));
		//decreasingSequence(5);
		//System.out.println(multiply2(-5,-5));
		//System.out.println(print(6))
		//print(20488756);
		//int[] a = {1,2,5,7,4};
		//int n = a.length;
		//int key = 5;
		//System.out.println(linearSearch(a,0,n,key));
		//bubbleSort2(a,0,5);
		//for(int i=0; i<a.length;i++) {
		//	System.out.print(a[i]);
		//}
		//char[] c = {'a','b','c'};
		//generateSubsets(c);
		//char [] a = {'4','7','4','7'};
		//System.out.println(indexLuckyNumber(a));
		//subsetSum();
		//towerOfHanoi(3,'A','C','B');
		
		//int[] a = {0,6,5,7,8,3};
		//mergeSort(a,0,5);
		//quickSort(a,0,5);
		//for(int i=0;i<a.length;i++) {
		//	System.out.print(a[i] + ",");
		//}
	    //String input = "xyz";
		//printSubsequences(input);
		//printAsciiSubSequences();
		//phoneKeypad("23");
		//char[] input = {'a','b','c'};
		//permute(input,0);
		//int [][] board = new int[4][4];
		//solveNQueen(board,0,4);
		//int n=4;
		
		//solveNQueen(0, n, ans);
		//System.out.println(ans); 
		//char  maze[][] = new char[][] {{ '0','0','0','0'},{'0','0','X','0'},{'0','0','0','X'},{'0','X','0','0'}};
		//int[][] soln= new int[10][10];
		//int m=4,n=4;
		//boolean ans = ratInMaze(maze,soln,0,0,m-1,n-1);
		//if(ans==false) {
			//System.out.println("Path does not exist");
		//}
		int mat[][] = new int[][] {
				{5,3,0,0,7,0,0,0,0},
				{6,0,0,1,9,5,0,0,0},
				{0,9,8,0,0,0,0,6,0},
				{8,0,0,0,6,0,0,0,3},
				{4,0,0,8,0,3,0,0,1},
				{7,0,0,0,2,0,0,0,6},
				{0,6,0,0,0,0,2,8,0},
				{0,0,0,4,1,9,0,0,5},
				{0,0,0,0,8,0,0,7,9}
		};
		solveSudoku(mat, 0,0,9);
		
	}
}
