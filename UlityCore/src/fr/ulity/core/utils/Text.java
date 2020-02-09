package fr.ulity.core.utils;

import org.bukkit.ChatColor;

public class Text {
	private final static int CENTER_PX = 154;
	 
	public static String center (String message){
		if(message == null || message.equals("")) return "";
	    message = ChatColor.translateAlternateColorCodes('&', message);
	               
	    int messagePxSize = 0;
	    boolean previousCode = false;
	    boolean isBold = false;
	               
	    for(char c : message.toCharArray()){
	        if(c == '§'){
	             previousCode = true;
	             continue;
	        }else if(previousCode == true){
	             previousCode = false;
	             if(c == 'l' || c == 'L'){
	                   isBold = true;
	                   continue;
	             }else isBold = false;
	        }else{
	              DefaultFontInfo dFI = DefaultFontInfo.getDefaultFontInfo(c);
	              messagePxSize += isBold ? dFI.getBoldLength() : dFI.getLength();
	              messagePxSize++;
	        }
	   }
	               
	   int halvedMessageSize = messagePxSize / 2;
	   int toCompensate = CENTER_PX - halvedMessageSize;
	   int spaceLength = DefaultFontInfo.SPACE.getLength() + 1;
	   int compensated = 0;
	   StringBuilder sb = new StringBuilder();
	   while(compensated < toCompensate){
	         sb.append(" ");
	         compensated += spaceLength;
	    }
	    return sb.toString() + message;
	  }

	public static String centerWithDash (String message, String color){
		if(message == null || message.equals("")) return "";
		
	    message = ChatColor.translateAlternateColorCodes('&', message);
	    color = ChatColor.translateAlternateColorCodes('&', color);
	               
	    int messagePxSize = 0;
	    boolean previousCode = false;
	    boolean isBold = false;
	               
	    for(char c : message.toCharArray()){
	        if(c == '§'){
	             previousCode = true;
	             continue;
	        }else if(previousCode == true){
	             previousCode = false;
	             if(c == 'l' || c == 'L'){
	                   isBold = true;
	                   continue;
	             }else isBold = false;
	        }else{
	              DefaultFontInfo dFI = DefaultFontInfo.getDefaultFontInfo(c);
	              messagePxSize += isBold ? dFI.getBoldLength() : dFI.getLength();
	              messagePxSize++;
	        }
	   }
	               
	   int halvedMessageSize = messagePxSize / 2;
	   int toCompensate = CENTER_PX - halvedMessageSize    /*- 1*/;
	   int spaceLength = DefaultFontInfo.SPACE.getLength() + 1;
	   int compensated = 0;
	   
	   String beforeMessage = color + "§m";
	   String afterMessage = "";
	   
	   while(compensated < toCompensate){
		   if ((compensated+spaceLength) >= toCompensate) {
			   beforeMessage = beforeMessage.concat("§r ");
			   afterMessage = "§r " + color + "§m" + afterMessage;
		   }
		   else {
			   beforeMessage = beforeMessage.concat(" ");
			   afterMessage = " " + afterMessage;
		   }
		   compensated += spaceLength;
	    }
	   
	   compensated = 0;
	   
	   return beforeMessage + message + afterMessage + "§r";

	  }

	public static String centerWithDash (String message){
		return centerWithDash(message, "§7");
	}

}
