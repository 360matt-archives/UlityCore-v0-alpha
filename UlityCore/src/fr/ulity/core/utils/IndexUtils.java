package fr.ulity.core.utils;

public class IndexUtils {

	public static Time time = new Time();
	public static String sha256 (String args) { return Sha256.run(args); }
	public static String allArgs (String[] arg) { return AllArgs.run(arg); }
	public static String allArgs (String[] arg, int count) { return AllArgs.run(arg, count); }

	
	
	
}
