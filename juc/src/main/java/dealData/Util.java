package dealData;


import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Util {
    public static AtomicInteger count = new AtomicInteger(1);
    private static Integer default_file_num = 10;
    //大文件切分
    public static File[] div(File file) throws IOException {
        getFileTotalLines(file);


        return null;
    }

    public static void main(String[] args) {
        int a = 1302;
        int b = 8;
        System.out.println(a/b);
        for(int i = 0; i < b; i++) {
            System.out.println(a % b);
        }
    }
    private static File[] generateFiles(){
        Integer size = count.get()/default_file_num;
        for(int i = 0; i < default_file_num; i++) {
            
        }
        return null;
    }
    private static void getFileTotalLines(File file) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
               while(br.readLine() != null){
                   count.incrementAndGet();
               }
        }
    }
}
