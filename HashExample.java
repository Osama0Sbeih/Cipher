
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Scanner;


public class HashExample {

    public static void main(String[] args) throws Exception {
        StringHash sHash = new StringHash("md5");
        String password = "OsamaKheerAllahSbaih";
        String hashedPassword = sHash.hash(password);
        System.out.printf("Stored hash -> %s\n", hashedPassword);
        
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter username:- ");
        String username = reader.readLine();
        
        System.out.print("Enter password:- ");
        String loginPass = reader.readLine();
        String loginPassHashed = sHash.hash(loginPass);
        System.out.printf("Login hash -> %s\n", hashedPassword);
        
        if (hashedPassword.equals(loginPassHashed)) {
            System.out.println("Login success");
        } else {
            System.out.println("Login failed");
        }
    }
}
