package cn.lsr.boot.core.spi;

import java.util.*;

/**
 * @Description: spi分组工具类
 * @Author: lsr
 * @Date 2022年08月26日 09:57
 */
public class GroupUtils {
    private GroupUtils(){}

    /**
     * filter by groups
     * @param collections
     * @param groups
     * @return
     */
    public static <T> List<T> filter(List<T> collections, String ...groups) {
        if (groups == null || groups.length == 0){
            return collections;
        }
        if (collections == null){
            return Collections.emptyList();
        }
        Set<String> groupFilters = new HashSet<>();
        Collections.addAll(groupFilters, groups);

        List<T> ret = new ArrayList<>();
        for (T obj : collections) {
            Groups groupsAnnotation = obj.getClass().getAnnotation(Groups.class);

            if (groupsAnnotation != null && groupsAnnotation.value() != null) {
                for (String annotation : groupsAnnotation.value()) {
                    if (groupFilters.contains(annotation)) {
                        ret.add(obj);
                        break;
                    }
                }
            }
        }

        return ret;
    }
}
