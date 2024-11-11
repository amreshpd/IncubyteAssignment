package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nt.exception.NegativeNumberException;

@Service
@RestControllerAdvice
public class Addition {

	@ExceptionHandler(value = NegativeNumberException.class)
	public int add(String numbers) throws Exception {
		int sum = 0;
		if (numbers.isEmpty()) {
			sum = 0;
		} else {

			
			if (numbers.startsWith("//")) {
				int delimiterIndex = numbers.indexOf("\n");
			String	delimiter = numbers.substring(2, delimiterIndex);
				numbers = numbers.substring(delimiterIndex + 1);
				numbers = numbers.replace(delimiter, ",");
			}

			String[] numberArray = numbers.split("[,\n]");
			List<Integer> negatives = new ArrayList<>();

			for (String num : numberArray) {
				int number = Integer.parseInt(num.trim());
				if (number < 0) {					
					negatives.add(number);
				} else
					sum += number;
			}

			if (!negatives.isEmpty()) {
				throw new NegativeNumberException("negative numbers not allowed "+negatives);
			}
		}
		return sum;
	}
}
