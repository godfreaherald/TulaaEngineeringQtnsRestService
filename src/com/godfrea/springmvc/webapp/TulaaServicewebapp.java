package com.godfrea.springmvc.webapp;



import org.springframework.web.client.RestTemplate;


/*
 * Uses Spring RestTemplate to access the Spring Rest Services
 */
public class TulaaServicewebapp {

	public static final String REST_SERVICE_URI = "http://localhost:8080/TulaaEngineeringQtnsRestService";
	

	        /* Testing ValidParenthesis API---------- */
	private static String isValidParenthesis(String s){
		
		System.out.println("Testing ValidParenthesis API----------");
		RestTemplate restTemplate = new RestTemplate();
        String results = restTemplate.getForObject(REST_SERVICE_URI+"/"+s,String.class);
        System.out.println(results);
        return results;
	}
	
	       /*Testing PythagoreanTriplet API----------*/
	private static String hasPythagoreanTriplet(int aar[]){
		
		System.out.println("Testing PythagoreanTriplet API----------");
		RestTemplate restTemplate = new RestTemplate();
        String results = restTemplate.getForObject(REST_SERVICE_URI+"/array/"+aar,String.class);
        System.out.println(results);
        return results;
	}
	
}