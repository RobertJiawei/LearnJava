package Game;

import java.util.Random;

public class CodeUtil {
    public static String getCode() {
        Random r = new Random();
        StringBuilder code = new StringBuilder();
        String charPool = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 4; i++) {
            code.append(charPool.charAt(r.nextInt(52)));
        }
        code.insert(r.nextInt(5), r.nextInt(9));
        return code.toString();
    }
}
