

package com.godfrea.springmvc.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import com.godfrea.springmvc.service.ServiceDAO;

@RestController
public class TulaaServiceController {

	@Autowired
	ServiceDAO serviceDao ;  //ServiceDao which will do all data manipulation work


	
	//-------------------Valid Parenthesis Checker--------------------------------------------------------
	
	@RequestMapping(value = "/{parenthesis}", method = RequestMethod.GET)
	public String isValidParenthesisString(@PathVariable("parenthesis") String parenthesis) {
		
	boolean result  =	serviceDao.isValidParenthesisString(parenthesis);

	if(result){
		return "The String has balanced parenthesis";
	}
	
	else {
		return "The String has unbalanced parenthesis";
	}
		
		
	}
	
//------------------- PythagoreanTriplet Checker--------------------------------------------------------
	
		@RequestMapping(value = "/array/{aa}", method = RequestMethod.GET)
		public String hasPythagoreanTriplet(@PathVariable("aa") int[] aa) {
			
		String result  =	serviceDao.hasPythagoreanTriplet(aa);
		
	
			return result;
		
		
		
		}


}

