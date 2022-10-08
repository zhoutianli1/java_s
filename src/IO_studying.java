import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IO_studying
{
    public static void main(String[] args) throws IOException {
        IO_studying fileRW = new IO_studying();
        fileRW.thirdWay();
        fileRW.firstWay();
        fileRW.secondWay();

    }
    //第一种方式：使用FileWriter和FileReader
    public void firstWay() throws IOException {
        String dir = "E:\\aaa\\a.txt";
        File file = new File(dir);
        //如果文件不存在，创建文件
        if (!file.exists())
            file.createNewFile();
        //创建FileWriter对象
        FileWriter writer = new FileWriter(file);
        //向文件中写入内容
        writer.write("the first way to write and read");
        writer.flush();
        writer.close();

        //创建FileReader对象，读取文件中的内容
        FileReader reader = new FileReader(file);
        char[] ch = new char[100];
        reader.read(ch);
        for(char c:ch) {
            System.out.print(c);
        }
        System.out.println();
        reader.close();
    }

    //第二种方式:使用BuffredReader和BufferedWriter
    public void secondWay() throws IOException {
        String dir = "E:\\soft\\aaa\\b.txt";
        File file = new File(dir);
        //如果文件不存在，创建文件
        if (!file.exists())
            file.createNewFile();
        //创建BufferedWriter对象并向文件写入内容
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        //向文件中写入内容
        bw.write("the second way to write and read");
        bw.flush();
        bw.close();
        //创建BufferedReader读取文件内容
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line=br.readLine())!=null) {
            System.out.println(line);
        }
        br.close();
    }

    //第三种方式：使用FileInputStream和FileOutputStream
    public void thirdWay() throws IOException {
        String dir = "E:\\soft\\aaa\\c.txt";
        File file = new File(dir);
        //如果文件不存在，创建文件
        if (!file.exists())
            file.createNewFile();
        //创建FileOutputStream对象，写入内容
        FileOutputStream fos = new FileOutputStream(file);
        //向文件中写入内容
        fos.write("the third way to write and read".getBytes());
        fos.close();
        //创建FileInputStream对象，读取文件内容
        FileInputStream fis = new FileInputStream(file);
        byte[] bys = new byte[100];
        while (fis.read(bys, 0, bys.length)!=-1) {
            //将字节数组转换为字符串
            System.out.println(new String(bys));
        }
        fis.close();
    }

  




}
