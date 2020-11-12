package Util;
import Entities.User;

public class Utils {


    private static Object Player;

    public static boolean isPlayer(User user) {
        return user.getRole().toLowerCase().equals("player");
    }

}
