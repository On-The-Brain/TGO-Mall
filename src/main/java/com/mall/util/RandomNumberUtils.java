package com.mall.util;

import cn.hutool.core.util.RandomUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author : Mr.Zhang
 * @version : 1.0
 * @package : com.mall.util
 * @ClassName : RandomNumberUtils
 * @projectName : TGO-Mall
 * @date : 2023/3/16 9:38
 */
public class RandomNumberUtils {

    public static List<Integer> Number(Integer min, Integer max,Integer count) {
        Set<Integer> set = new HashSet();
        while (set.size() < count) {
            int randomInt = RandomUtil.randomInt(1, 12);
            set.add(randomInt);
        }
        return (List) set.stream().collect(Collectors.toList());
    }


}
