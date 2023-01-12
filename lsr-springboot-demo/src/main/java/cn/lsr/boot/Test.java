package cn.lsr.boot;

import cn.lsr.common.util.FileUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description:
 * @Author: lsr
 * @Date 2023年01月05日 17:51
 */
public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        int shard = random.nextInt(2);
        System.out.println(shard);
        String [] path = new String[3];
        path[0]="/Users/lsr/Desktop/1.txt";
        path[1]="/Users/lsr/Desktop/2.txt";
        path[2]="/Users/lsr/Desktop/3.txt";
        List<String> paths = new ArrayList<>();
        paths.add("/Users/lsr/Desktop/1.txt");
        paths.add("/Users/lsr/Desktop/2.txt");
        paths.add("/Users/lsr/Desktop/3.txt");

        FileUtils.mergeFiles(paths,"/Users/lsr/Desktop/out.txt",false);
    }




}
