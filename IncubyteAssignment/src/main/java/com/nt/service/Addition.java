package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Addition {

	public int add(String numbers) {
		int sum = 0;
		if (numbers.isEmpty()) {
			sum = 0;
		} else {

			String delimiter = ",|\n"; // default delimiters: comma and newline
			if (numbers.startsWith("//")) {
				int delimiterIndex = numbers.indexOf("\n");
				delimiter = numbers.substring(2, delimiterIndex);
				numbers = numbers.substring(delimiterIndex + 1);
				numbers = numbers.replace(delimiter, ",");
			}

			String[] numberArray = numbers.split(delimiter);
			StringBuilder negatives = new StringBuilder();

			for (String num : numberArray) {
				int number = Integer.parseInt(num);
				if (number < 0) {
					if (negatives.length() > 0) {
						negatives.append(",");
					}
					negatives.append(number);
				} else
					sum += number;
			}

			if (negatives.length() > 0) {
				throw new IllegalArgumentException("negative numbers not allowed " + negatives.toString());
			}
		}
		return sum;
	}
}
