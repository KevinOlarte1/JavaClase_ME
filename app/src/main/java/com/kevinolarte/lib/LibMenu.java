package com.kevinolarte.lib;

public class LibMenu {
    private static final String limitT ="*************************";
    private static final String extremo = "**";
    private static final String acabar = "--------------------------";
    
    public static void print(String[] args){ /// n8rar oarametrso
        if (args.length < 2) {
            System.out.println("Muy corto");
            return;
        }
        
        System.out.print("\033[H\033[2J");
        System.out.println(limitT  + "\n" + extremo + args[0] + extremo + "\n" + limitT);
        for (int i = 1; i < args.length; i++) {
            System.out.println(i + "." + args[i]);
        }
        System.err.println("\n" +acabar + "\n0.Para salir");
        
    }
}
