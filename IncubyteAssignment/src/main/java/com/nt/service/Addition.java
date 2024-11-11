package com.nt.service;

import org.springframework.stereotype.Service;

@Service
public class Addition {

	public void add(int num1,int num2) {
		int result=num1+num2;
		System.out.println(result);
		
	}
}
