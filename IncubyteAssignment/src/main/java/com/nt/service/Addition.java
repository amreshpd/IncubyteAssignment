package com.nt.service;

import org.springframework.stereotype.Service;

@Service
public class Addition {

	public int add(String numbers) {
		int sum=0;
		if(numbers.isEmpty()) {
			sum=0;
		}else {
			sum=Integer.parseInt(numbers);
		}
		return sum;
	}
}
