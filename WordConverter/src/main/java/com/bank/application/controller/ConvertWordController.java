/**
 * 
 */
package com.bank.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bank.application.service.NumberConverterService;

/**
 * @author NaveenSugumar
 *
 */

@RestController
public class ConvertWordController {
	
	@Autowired
	private NumberConverterService converterService;
	private static final Logger LOGGER = LoggerFactory.getLogger(ConvertWordController.class);
	
	@GetMapping(value = "/converter/{number}", produces = "application/json")
    public String convertNumToWord(@PathVariable String number) {
		LOGGER.info("Entered number :: "+number);
		String inWords="";
		try {
		inWords=converterService.convertNumToWord(number);
		} catch(NumberFormatException nfe) {
			inWords=nfe.getMessage();
		} catch(Exception exception) {
			inWords=exception.getMessage();
		}

        return inWords;
    }


}
