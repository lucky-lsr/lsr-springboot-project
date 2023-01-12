package cn.lsr.common.util;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.List;

/**
 * @Description: 文件操作工具类
 * @Author: lsr
 * @Date 2023年01月11日 17:40
 */
public class FileUtils {

    /**
     * 文件合并
     * @param paths 文件具体路径集合
     * @param resultPath 输出文件地址
     * @param isDelete 合并完之后是否删除子文件
     * @return
     */
    public static boolean mergeFiles(List<String> paths, String resultPath, boolean isDelete) {
        if (paths.isEmpty()){
            return false;
        }
        if (StringUtils.isEmpty(resultPath)){
            return false;
        }
        if (paths.size()==1){
            return new File(paths.get(0)).renameTo(new File(resultPath));
        }
        File[] files = new File[paths.size()];
        for (int i = 0; i < paths.size(); i++) {
            files[i] = new File(paths.get(i));
            if (StringUtils.isEmpty(paths.get(i)) || !files[i].exists() || !files[i].isFile()){
                return false;
            }
        }

        File resultFile = new File(resultPath);

        try {
            FileChannel resultFileChannel = new FileOutputStream(resultFile, true).getChannel();
            for (String path : paths) {
                FileChannel blk = new FileInputStream(path).getChannel();
                resultFileChannel.transferFrom(blk, resultFileChannel.size(), blk.size());
                blk.close();
            }
            resultFileChannel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        if (isDelete){
            for (int i = 0; i < files.length; i ++) {
                files[i].delete();
            }
        }
        return true;
    }
}
