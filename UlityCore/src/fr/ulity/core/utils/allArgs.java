package fr.ulity.core.utils;

public class allArgs {
	public static String run (String[] args, Integer count) {
    	String allArgs = "";

    	for(int i = 0; i < args.length; i++){
    		if (count == 0) {
        	    String arg = args[i] + " ";
        	    allArgs = allArgs + arg;
    		}
    		else 
    			count--;

    	}
    	
    	return allArgs.trim();
	}
	
	public static String run (String[] args) {
		return run(args, 0);
	}
}
