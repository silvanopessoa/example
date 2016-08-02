package com.tianbao54.compress.test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;

import org.junit.Test;
import org.xerial.snappy.Snappy;

public class CompressTest {

	@Test
	public void testSnappyCompress () throws IOException {
		
		FileInputStream fis = new FileInputStream(new File("C:\\summary.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String fileContext = br.readLine();
		byte[] beforeCompress = fileContext.getBytes();
		byte[] bytes = Snappy.compress(fileContext.getBytes());
		System.out.println(beforeCompress.length + "   " + bytes.length);
	}
	
	@Test
	public void testGzipCompress () throws IOException {
		
		FileInputStream fis = new FileInputStream(new File("C:\\summary.txt"));
		byte[] bytes = new byte[fis.available()];
		fis.read(bytes);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(out);
		gzip.write(bytes);
		gzip.close();
		
		byte[] snappy = Snappy.compress(bytes);
		System.out.println(bytes.length + "   " + snappy.length);
		
		byte[] afterCompress = out.toString("ISO-8859-1").getBytes();
		System.out.println(bytes.length + "    " + afterCompress.length);
	}
}
