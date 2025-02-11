package org.jgcbook.chapter03.F_multiple_bounds;
// ch03_6_1a
import java.io.Closeable;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.nio.file.Path;

public class Program_1 {
	public static <S extends Readable & Closeable, T extends Appendable & Closeable>
	    void copy(IoeThrowingSupplier<S> src, IoeThrowingSupplier<T> tgt, int size)
	                                                     throws IOException {
	    try (S s = src.get(); T t = tgt.get()) {  
	        CharBuffer buf = CharBuffer.allocate(size);
	        int i = s.read(buf);
	        while (i >= 0) {
	            buf.flip(); // prepare buffer for writing
	            t.append(buf);
	            buf.clear(); // prepare buffer for reading
	            i = s.read(buf);
	        }
	    }
	}
	public static void main(String[] args) throws IOException {
	  int size = 32;
	  Files.writeString(Path.of("file.in"), "hello world");
	  copy(() -> new FileReader("file.in"),
	       () -> new FileWriter("file.out"), size);
	  assert Files.readString(Path.of("File.out")).equals("hello world");
	}
}