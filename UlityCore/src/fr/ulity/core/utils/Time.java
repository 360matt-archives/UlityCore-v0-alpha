package fr.ulity.core.utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Time {
	public static int toSeconds (String period){


		final String regex = "([0-9]+)([A-z])";
		int value = 0;

		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(period);

		while (matcher.find()) {
		    int number = Integer.parseInt(matcher.group(1));
		    String multiplier = matcher.group(2);

		    value += (multiplier.equals("s")) ? number : 0;
		    value += (multiplier.equals("m")) ? number*60 : 0;
		    value += (multiplier.equals("h")) ? number*60*60 : 0;
		    value += (multiplier.equals("d") || multiplier.equals("j")) ? number*60*60*24 : 0;
		    value += (multiplier.equals("w") ) ? number*60*60*24*7 : 0;
		    value += (multiplier.equals("o")) ? number*60*60*24*31 : 0;
		    value += (multiplier.equals("y")) ? number*60*60*24*365 : 0;
		    
		}

	    return value;
	}
	
	
	public static String toLetters (long l){
		String value = "";
		long _per = l;
		
		if(l >= (60*60*24*365)) {
			_per = ((long) l/(60*60*24*365));
			l -= (60*60*24*365*_per);
			if (_per > 1)
				value += _per + " ans ";
			else
				value += "1 an ";
		}
		if(l >= (60*60*24*31)) {
			_per = ((long) l/(60*60*24*31));
			l -= (60*60*24*31*_per);
			value += _per + " mois ";
		}
		if(l >= (60*60*24*7)) {
			_per = ((long) l/(60*60*24*7));
			l -= (60*60*24*7*_per);
			if (_per > 1)
				value += _per + " semaines ";
			else
				value += "1 semaine ";
		}
		if(l >= (60*60*24)) {
			_per = ((long) l/(60*60*24));
			l -= (60*60*24*_per);
			if (_per > 1)
				value += _per + " jours ";
			else
				value += "1 jour ";
		}
		if(l >= (60*60)) {
			_per = ((long) l/(60*60));
			l -= (60*60*_per);
			if (_per > 1)
				value += _per + " heures ";
			else
				value += "1 heure ";
		}
		if(l >= 60) {
			_per = ((long) l/60);
			l -= (60*_per);
			if (_per > 1)
				value += _per + " minutes ";
			else
				value += "1 minute ";
		}
		if (value == "") {
			if (l > 0)
				value += _per + " secondes ";
			else
				value += "0 secondes ";
		}
				
	    return value.trim();
	}
	
	public static long timestamp () {
		Date date = new Date();
		return TimeUnit.MILLISECONDS.toSeconds(date.getTime());
	}
}
