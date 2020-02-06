package com.bank.application.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bank.application.service.NumberConverterService;
import com.bank.application.util.ServiceConstants;
import com.bank.application.util.WordConvertorForOnes;
import com.bank.application.util.WordConvertorForTens;

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
		try {
			int number = Integer.parseInt(value);
			LOGGER.info("wordConvertor:: Whole Number: "+number);
			checkMinMaxNumber(number);
			wordConvertor(((number / 100000) % 100), ServiceConstants.LAKH+ServiceConstants.EMPTY,wordConvertorString);
			wordConvertor(((number / 1000) % 100), ServiceConstants.THOUSAND +ServiceConstants.EMPTY,wordConvertorString);
			wordConvertor(((number / 100) % 10), ServiceConstants.HUNDRED+ServiceConstants.EMPTY,wordConvertorString);
			if((number > 100) && ((number % 100) > 0)) {
				wordConvertorString.append(ServiceConstants.AND+ServiceConstants.EMPTY);
			}
			wordConvertor((number % 100), ServiceConstants.EMPTY,wordConvertorString);
		} catch (Exception e) {
			throw new NumberFormatException(ServiceConstants.INVALID_NUMBER);
		}
		return wordConvertorString.toString();
	}

	private void checkMinMaxNumber(int number) {
		if (number <= 0) {
			throw new NumberFormatException(ServiceConstants.INVALID_NUMBER);
		} else if(number > 999999) {
			throw new NumberFormatException(ServiceConstants.INVALID_NUMBER);
		}
	}

	private void wordConvertor(int number, String numberCount,StringBuilder wordConvertorString) {
		LOGGER.info("wordConvertor:: Number: "+number);
		if(number > 19) {
			int tensIndex = number/10;
			int onesIndex = number%10;

			if(tensIndex != 0 || tensIndex != 1) {
				wordConvertorString.append(WordConvertorForTens.getType(String.valueOf(tensIndex)));
				wordConvertorString.append(ServiceConstants.EMPTY);
			}

			if(onesIndex != 0) {
				wordConvertorString.append(WordConvertorForOnes.getType(String.valueOf(onesIndex)));
				wordConvertorString.append(ServiceConstants.EMPTY);
			}
		} else {
			if(number > 0) {
				wordConvertorString.append(WordConvertorForOnes.getType(String.valueOf(number)));
				wordConvertorString.append(ServiceConstants.EMPTY);
			}

		}

		if(number > 0) {
			wordConvertorString.append(numberCount);
		}
	}
}
