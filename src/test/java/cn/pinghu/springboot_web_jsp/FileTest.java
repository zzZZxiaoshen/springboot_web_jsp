package cn.pinghu.springboot_web_jsp;

import org.junit.Test;

import java.io.File;

public class FileTest {

    /**
    *  企业微信api接入_1  批量改成 1_企业微信api接入
    */
    @Test
    public void FileTest01() {
        File file = new File("C:\\Users\\lx\\Desktop\\企业微信");
        File[] files = file.listFiles();
        for (File filechil : files) {
            System.out.println("file1 = " + filechil.toString());
        //System.out.println(filechil.getAbsoluteFile());
            String numberString  = filechil.getAbsolutePath()
                    .substring(filechil.getAbsolutePath().lastIndexOf("\\"));
            System.out.println(numberString );
            String fileNamePrefix = numberString .substring(numberString .indexOf("_") + 1, numberString .lastIndexOf("."));
            System.out.println("fileNamePrefix = " + fileNamePrefix);
            String fileNameString = numberString.substring(1, numberString.indexOf("_"));
            System.out.println("fileNameString = " + fileNameString);
            String suffix = ".txt";
            String concat = file.getAbsolutePath()
                    .concat("\\")
                    .concat(fileNamePrefix)
                    .concat("_")
                    .concat(fileNameString)
                    .concat(suffix);

            System.out.println("concat = " + concat);
            File newFileName = new File(concat);
            filechil.renameTo(newFileName);
        }
    }

    /**
    * 递归输出文件目录
     *   这只是使用递归的算法去解决指定文件的路径的输出
     *   还能使用递归的方法封装数据参数返回给前台
    */
    @Test
    public void test011() {
        // 封装目录
        File srcFolder = new File("C:\\Users\\lx\\Desktop\\企业微信");

        // 递归功能实现
        getAllJavaFilePaths(srcFolder);
    }
    private static void getAllJavaFilePaths(File srcFolder) {
        // 获取该目录下所有的文件或者文件夹的File数组
        File[] fileArray = srcFolder.listFiles();

        // 遍历该File数组，得到每一个File对象
        for (File file : fileArray) {
            // 判断该File对象是否是文件夹
            if (file.isDirectory()) {
                getAllJavaFilePaths(file);
            } else {                      // 规律与出口没有位置限制
                // 继续判断是否以.java结尾
                if (file.getName().endsWith(".java")) {
                    // 就输出该文件的绝对路径
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}

