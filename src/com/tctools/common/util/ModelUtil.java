package com.tctools.common.util;

import com.vantar.util.number.NumberUtil;
import com.vantar.util.string.StringUtil;
import java.math.BigDecimal;


public class ModelUtil {

    public static double round(double d, int decimals) {
        double v = NumberUtil.round(d, decimals);
        if (v > 0) {
            return v;
        }

        String[] floatParts = StringUtil.split(new BigDecimal(d).toPlainString(), '.');
        if (floatParts.length == 1) {
            return d;
        }
        decimals = 0;
        while (floatParts[1].charAt(decimals) == '0') {
            ++decimals;
        }
        return NumberUtil.round(d, ++decimals);
    }
}
