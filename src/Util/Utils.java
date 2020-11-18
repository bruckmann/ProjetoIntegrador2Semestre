package Util;
import Entities.user.User;

public class Utils {


    private static Object Player;

    public static boolean isPlayer(User user) {
        return user instanceof Entities.user.Player;
    }

}
