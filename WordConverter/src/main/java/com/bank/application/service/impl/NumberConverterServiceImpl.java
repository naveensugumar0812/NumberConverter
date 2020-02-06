package com.bank.application.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bank.application.service.NumberConverterService;
import com.bank.application.util.ServiceConstants;

/**
 * @author NaveenSugumar
 *
 */

@Repository
public class NumberConverterServiceImpl implements NumberConverterService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NumberConverterServiceImpl.class);

	@Override
	public String convertNumToWord(String value) throws NumberFormatException  {
		StringBuilder wordConvertorString = new StringBuilder();
		int number = Integer.parseInt(value);
		if(number <= 0 || number > 999999) {
			throw new NumberFormatException(ServiceConstants.INVALID_NUMBER);
		}

		return wordConvertorString.toString();
	}
}
