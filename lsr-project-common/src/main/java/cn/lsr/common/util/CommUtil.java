package cn.lsr.common.util;

import java.text.NumberFormat;

/**
 * @Description: 公共的工具类
 * @Author: lsr
 * @Date 2022年08月06日 19:34
 */
public class CommUtil {
    /**
     * 获取百分比
     *
     * @param x    除数
     * @param y    被除数
     * @param size 保留小数点后几位
     * @return
     */
    public static float getPercentage(int x, int y, int size) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(size);
        float result = Float.parseFloat(numberFormat.format((float) x / (float) y * 100));
        return result;
    }
}
