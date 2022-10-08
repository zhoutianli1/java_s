//  https://blog.csdn.net/liuhenghui5201/article/details/8276278
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileRW {

    public static void main(String[] args) throws IOException {
        System.out.println("输入：");
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        switch (n)
        {
            case 1:
                fun1();
                break;

            case 2:

                break;
            case 3:

                break;

            default:

        }
    }

    //第一种方式：使用FileWriter和FileReader
    public static void fun1() throws IOException {
        String dir = "E:\\aaaa\\1.txt";
        File file = new File(dir);

        if(!file.exists())
        {
            file.createNewFile();
        }
        //创建文件读写对象：使用FileWriter和FileReader
        FileWriter fileWriter = new FileWriter(file);
        //当执行完此方法后，字符数据还并没有写入到目的文件中去。此时字符数据会保存在缓冲区中。
        fileWriter.write(("11111111111111111111111111,11 111 111"));
        //刷新该流中的缓冲。将缓冲区中的字符数据保存到目的文件中去。
        fileWriter.flush();
        //关闭此流。在关闭前会先刷新此流的缓冲区。在关闭后，再写入或者刷新的话，会抛IOException异常。
        fileWriter.close();

        FileReader fileReader = new FileReader(file);
        char[] ch = new char[100];
        //int read(char []cbuf);将字符读入数组。返回读取的字符数。如果已经到达尾部，则返回-1。
        fileReader.read(ch);
        for(char c:ch) {
            System.out.print(c);
        }
        System.out.println();
        fileReader.close();

    }
}
