package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;

public class Stream {
	
	public static void copy(InputStream in, OutputStream out) throws IOException {
		int c;
		while((c = in.read()) != -1) {
			out.write(c);
		}
	}
	
	public static void copy(Reader in, Writer out) throws IOException {
		int c;
		while((c = in.read()) != -1) {
			out.write(c);
		}
	}
	
	public static void main(String[] args) {
		try {
			// Tạo đối tượng kết nối với nguồn
			FileReader in1 = new FileReader("file0.txt");
			// Tạo đối tượng kết nối với file nhận
			FileWriter out1 = new FileWriter("file1.txt");
			// Thực hiện sao chép
			Stream.copy(in1, out1);
			// Đóng nguồn
			in1.close();
			// Đóng nhận
			out1.close();
			
			String msg = "Hello World";
			StringReader in2 = new StringReader(msg);
			FileWriter out2 = new FileWriter("file2.txt");
			Stream.copy(in2, out2);
			in2.close();
			out2.close();
			
//			BufferedReader bf = new BufferedReader(in1);
//			FileWriter out3 = new FileWriter("file3.txt");
//			String line;
//			while((line = bf.readLine()) != "") {
//				out3.write(line);
//			}
//			out3.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
