package utils;

import java.util.Currency;
import java.util.Locale;

public class CurrencySymbolUtil {
	
	public static String getCurrency(int curr){		
		switch (curr) {
		case 1:		
			return CurrencySymbolUtil.getSymbol(Locale.US);
		case 2:			
			return "EUR";
		case 3:
			return CurrencySymbolUtil.getSymbol(Locale.UK);
		default:
			return null;
		}
		
	}
	
	private static String getSymbol(Locale locale) {		
		Currency c = Currency.getInstance(locale);		
		String symbol = c.getSymbol(locale);
		return symbol;
	}
}
