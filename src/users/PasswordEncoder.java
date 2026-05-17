package users;
import java.util.Base64;

public class PasswordEncoder {

    public static String encode(String plainPassword){
        return Base64.getEncoder().encodeToString(plainPassword.getBytes());
    }
    public static String decode(String encodedPassword){
        return new String(Base64.getDecoder().decode(encodedPassword));
    }
    public static boolean matches(String plainPassword, String encodedPassword){
        return encode(plainPassword).equals(decode(encodedPassword));
    }
}
