package com.PyroMC.PyroMCMaster;

import java.util.Arrays;
import java.util.List;


public class PMM_Util {
    
    public static List<String> chatList = Arrays.asList(new String[] { "4", "c", "6", "e", "2", "a", "b", "3", "1", "9", "d", "5", "f", "7", "8", "0" });
    public static String chatPrefix = "&";
    public static String Prefix = PyroMCMaster.plugin.getConfig().getString("prefix");
    
    
        public static String colorize(String msg) {
        String coloredMsg = "";
        for (int i = 0; i < msg.length(); i++) {
            if (msg.charAt(i) == '&') {
                coloredMsg = new StringBuilder().append(coloredMsg).append('§').toString();
            }
            else {
                coloredMsg = new StringBuilder().append(coloredMsg).append(msg.charAt(i)).toString();
            }
        }
    return coloredMsg;
  }
    
}
