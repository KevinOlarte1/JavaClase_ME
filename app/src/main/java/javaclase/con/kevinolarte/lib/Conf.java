package javaclase.con.kevinolarte.lib;

//import net.datafaker.Faker;
//import com.github.javafaker.Faker;

public class Conf {
    //Faker para crear parametros falsos.
    //public static Faker fakerEs = new Faker(new java.util.Locale("es"));
    //Faker fakerEs = new Faker(new java.util.Locale("es"));
    public static void sleep(int s){
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
