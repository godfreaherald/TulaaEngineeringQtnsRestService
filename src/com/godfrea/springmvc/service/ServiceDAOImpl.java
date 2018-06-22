package com.godfrea.springmvc.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("serviceDao")
@Transactional
public class ServiceDAOImpl implements ServiceDAO {

	/*
	 * Receives a parenthesis string and returns a 
	 * boolean true if the string has balanced parenthesis else returns false
	 * 
	 */
	@Override
	public boolean isValidParenthesisString(String s) {
		
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		
		/* pass the expected string characters as key value in a hashmap */
			map.put('(', ')');  
			map.put('[', ']');
			map.put('{', '}');
			
			/* create a stack for storing and comparing the string characters 
			 * during string traversal
			 * */
			Stack<Character> stack = new Stack<Character>();
			
			/*traverse the string given*/
			for (int i = 0; i < s.length(); i++) {
				char curr = s.charAt(i);    /* get the current character */
		 
				if (map.keySet().contains(curr)) {  /*check if the current character is opening parenthesis and push it to the stack*/
					stack.push(curr);
					
					/*check if the current character is closing parenthesis*/
				} else if (map.values().contains(curr)) { 
					
					/*check if the stack is empty and the top object 
					 * in the stack is equal to the current element of the 
					 * string passed and the is contained it the map
					 * and  remove the element from the stack 
					 * */
					if (!stack.empty() && map.get(stack.peek()) == curr) { 
						stack.pop();   
					} else {
						return false;
					}
				}
			}
		 
			return stack.empty(); 
		
		
	}

	@Override
	/* Returns true if there is a triplet with following property
    * A[x]*A[x] = A[y]*A[y] + A[t]*[t]
    */
	public String hasPythagoreanTriplet(int aar[]) {
		int n = aar.length;// get array length
	    	
	    	int aar_bk[] =aar; //back up  and sort the array 
	    	 Arrays.sort(aar_bk);
	    	 
	    	
	        // square all array elements
	        for (int x=0; x<n; x++)
	            aar[x] = aar[x]*aar[x];
	  
	       // sort array elements 
	        Arrays.sort(aar);
	       
	  
	        // Now fix one element one by one and find the other two
	        // elements
	        for (int x = n-1; x >= 2; x--)
	        {
	           /*  start two index
	            *variables from two ends of the array and move
	            * them toward each other, to get the other two elements.
	          */  
	            int a = 0;  //index of the first element in a[0..x-1]
	            int z = x-1; // index of the last element in a[0..x-1]
	            while (a < z) // check that not yet middle of the array
	            {
	               //  other two elements found and terminate execution
	                if (aar[a] + aar[z] == aar[x]){
	              String success = "There is a Pythagorean triplet (" + (int)Math.sqrt(aar_bk[a] )+","+ (int)Math.sqrt(aar_bk[z]) + "," +(int)Math.sqrt(aar_bk[x])+")";	
	                  return success;
	                }
	                // Else either move 'a' or 'z'
	                if (aar[a] + aar[z] < aar[x])
	                   a++;
	                else
	                   z--;
	            }
	        }
	  
	      //   other two elements NOT  found,no Pythagorean triplet 
	        String failed = " There is no Pythagorean triplet.";
		
		
		return failed;
	}


}
