package com.dihaw.utils;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;


public class ValidationSupportUtils {
	
	public final static Date DATE_FILTERS_MIN_LIMIT = DateUtils.setYears(DateUtils.truncate(new Date(), Calendar.YEAR), 1900);
	public final static Date DATE_FILTERS_MAX_LIMIT = DateUtils.setYears(DateUtils.truncate(new Date(), Calendar.YEAR), 10000);
	public final static BigDecimal IMPORTS_MAX_LIMIT = new BigDecimal("99999999999.99");
	public final static String SPECIAL_CHARS_REGEX_CLASS = "[^ \"%&\\/\\',.0-9A-Za-z\\-_\\$\\(\\)\\*\\+\\?\\@\\[\\\\\\]]";
	
	public static boolean containsSpecialChars(String target) {
		return StringUtils.isNotBlank(target) && target.matches(".*" + SPECIAL_CHARS_REGEX_CLASS + ".*");
	}
	
	public static void rejectIfEmptyOrWhitespace(Errors errors, String field, String errorCode) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, field, errorCode);
	}
	
	public static void rejectIfContainsSpecialChars(Errors errors, String field, String errorCode) {
		
		Object value = errors.getFieldValue(field);
		if (value != null && containsSpecialChars(value.toString())) {
			errors.rejectValue(field, errorCode);
		}
	}


}
