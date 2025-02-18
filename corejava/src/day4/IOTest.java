package day4;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import org.junit.jupiter.api.Test;

class IOTest {
	
	
	@Test
	public void testBufferedReader() {
		try(BufferedReader br= new BufferedReader(new FileReader(new File("data.txt")))){
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
		}catch(Exception e) {
			
		}
	}
	@Test
	public void testReaders() {
		try(Reader reader=new FileReader (new File("data.txt"))){
			try(Writer writer = new FileWriter(new File("dataOut.txt"))){
				char [] buff= new char[4];
				int i=-1;
				while((i= reader.read(buff))!=-1) {
					writer.write(buff,0,i);
				}
				writer.flush();
			}
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testChainingStreams() {
		try(InputStream is= new BufferedInputStream(new FileInputStream(new File("data.txt")))) {//buffered Input Stream is used to read chunks of data.
			try(OutputStream os= new FileOutputStream(new File("dataCopy.txt"))){
				byte [] buff= new byte[4];
			    int i=0;
			    while((i= is.read(buff))!=-1) {
			    	System.out.println(new String(buff,0,i));
			    	os.write(buff,0,i);
			    }
			    os.flush();
				}
		}catch(Exception e) {
			
		}
	}

	@Test
	public void testThirdReadTryWithResources() {
		try(InputStream is= new FileInputStream(new File("data.txt"))){
			try(OutputStream os= new FileOutputStream(new File("dataCopy.txt"))){
			byte [] buff= new byte[4];
		    int i=0;
		    while((i= is.read(buff))!=-1) {
		    	System.out.println(new String(buff,0,i));
		    	os.write(buff,0,i);
		    }
		    os.flush();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSecondReadTryWithResources() {
		try(InputStream is= new FileInputStream(new File("data.txt"))){
			byte [] buff= new byte[4];
		    int bytesRead = is.read(buff);
		    assertEquals(4,bytesRead);
		    System.out.println(new String(buff));
		    assertEquals(4,is.read(buff));
		    System.out.println(new String(buff));
		    assertEquals(4,is.read(buff));
		    System.out.println(new String(buff));
		    assertEquals(4,is.read(buff));
		    System.out.println(new String(buff));
		    assertEquals(2,is.read(buff));
		    System.out.println(new String(buff));
		    assertEquals(-1,is.read(buff));
		    System.out.println(new String(buff));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testReadTryWithResources() {//has lesser complexity so can be used as an alternative
		try(InputStream is= new FileInputStream(new File("data.txt"))){
			assertEquals('H',((byte)is.read()));
			assertEquals('e',((byte)is.read()));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	void testRead() {
		InputStream is= null;
		try {
			is = new FileInputStream(new File("data.txt"));
			assertEquals('H',((byte)is.read()));
			assertEquals('e',((byte)is.read()));
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				is.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
