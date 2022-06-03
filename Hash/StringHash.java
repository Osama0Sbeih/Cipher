import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringHash {
    
    private MessageDigest digest;
    
    public StringHash(String algorithm) throws NoSuchAlgorithmException {
        this.digest = MessageDigest.getInstance(algorithm);
    }
    
    public String hash(String text) {
        String hexadecimal = "";
        
        byte[] hash = digest.digest(text.getBytes());
        for (int i = 0; i < hash.length; i++) {
            hexadecimal += String.format("%02X", hash[i]);
            
        }
        
        return hexadecimal;
    }
}
