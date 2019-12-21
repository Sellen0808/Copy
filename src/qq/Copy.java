package qq;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/*
 * 1.查看文件是否存在
 * 	1>:查看读取的文件是否存在
 * 	2>:查看需要写入的文件夹是否存在,如果不存在则创建
 * 2.将文件放入数组中
 * 3.遍历数组,取出每个文件
 * 	1>:判断文件中是否存在文件夹
 * 	2>:如果存在,则利用递归回调此方法
 * 4.读写文件
 * 5.设置一个缓冲区
 * 6.复制文件
 * 
 * 
 */
public class Copy {
	public static void main(String[] args) throws Exception {
		copyDirectory("G:\\aa","G:\\bb");
	}
	
	private static void copyDirectory(String src, String dest) throws Exception {
File file=new File(src);
		
		File[] listFiles = file.listFiles();
		
		File file2=new File(dest);
		if(!file2.exists()) {
			file2.mkdir();
		}
		
		for (File f : listFiles) {
			if(f.isDirectory()) {
				System.out.println("文件夹: "+f);
				copyDirectory(f.getAbsolutePath(), dest+"\\"+f.getName());
			}else {
			copyFile(f,new File(dest,f.getName()));
			}
			System.out.println("over");
		}
		
	}
	private static void copyFile(File src ,File dest) throws Exception {
		InputStream in=new FileInputStream(src);
		OutputStream out=new  FileOutputStream(dest);
		
		 byte [] bb=new byte[1024*8];
		 
		 int len;
		 while((len=in.read(bb))>0) {
			 
			 out.write(bb,0,len);
		 }
		}
}
