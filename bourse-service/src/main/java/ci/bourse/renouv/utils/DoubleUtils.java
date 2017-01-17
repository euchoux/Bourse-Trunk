package ci.bourse.renouv.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class DoubleUtils {

    private DoubleUtils() {}

    /**
     * Permet tronquer un double avec le nombre de chiffre après la virgule en
     * pararmètre.
     * 
     * @param value
     *            valeur à tronquer
     * @param places
     *            nombre de chiffres après la virgule
     * @return
     */
    public static double round(final double value, final int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(String.valueOf(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static boolean isDouble(final String str) {
        if (str == null || str.matches("-?\\d+(\\.\\d+)?")) {
            return true;
        }
        return false;
    }
}
