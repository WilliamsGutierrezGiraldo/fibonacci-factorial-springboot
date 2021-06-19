package com.test.wagg.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.test.wagg.service.OperationsService;

@Service
public class OperationsServiceImpl implements OperationsService {

	@Override
	public Long calculateFibonacci(int n) {
		return new BigDecimal(fibonacci(n)).longValue();
	}

	@Override
	public Long calculateFactorial(int n) {
		return new BigDecimal(factorial(n)).longValue();
	}

	@Override
	public Long recieveValues(int number, String operation) {
		if (operation.equals("fibonacci")) {
			return calculateFibonacci(number);
		}
		if (operation.equals("factorial")) {
			return calculateFactorial(number);
		}
		
		return BigDecimal.ZERO.longValue();
	}
	
	private int factorial (int numero) {
		if (numero==0) {
		    return 1;
		} else {
		    return numero * factorial(numero-1);
		}

	}
	
	private int fibonacci(int n) {
	    if (n>1){
	       return fibonacci(n-1) + fibonacci(n-2);
	    }
	    else if (n==1) {
	        return 1;
	    }
	    else if (n==0){  
	        return 0;
	    }
	    else {
	        return -1; 
	    }
	}

}
