package qq;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/*
 * 1.�鿴�ļ��Ƿ����
 * 	1>:�鿴��ȡ���ļ��Ƿ����
 * 	2>:�鿴��Ҫд����ļ����Ƿ����,����������򴴽�
 * 2.���ļ�����������
 * 3.��������,ȡ��ÿ���ļ�
 * 	1>:�ж��ļ����Ƿ�����ļ���
 * 	2>:�������,�����õݹ�ص��˷���
 * 4.��д�ļ�
 * 5.����һ��������
 * 6.�����ļ�
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
				System.out.println("�ļ���: "+f);
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
