package fr.ulity.core.utils;

import javax.annotation.Nullable;

public class indexUtils {

	public static time time = new time();
	public static String sha256 (String args) { return sha256.run(args); }
	public static String allArgs (String[] arg) { return allArgs.run(arg); }
	public static String allArgs (String[] arg, @Nullable int count) { return allArgs.run(arg, count); }

	
	
	
}
