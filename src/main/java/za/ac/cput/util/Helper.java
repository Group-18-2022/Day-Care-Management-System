package za.ac.cput.util;

import java.util.UUID;

public class Helper {
    public static String generateID() {
        return UUID.randomUUID().toString();
    }

    public static boolean isNullOrEmpty(Object o) {
        return (o == null || o.equals(""));
    }
}
