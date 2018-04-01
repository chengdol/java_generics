package multiple_bonuds;

import java.io.Closeable;
import java.io.IOException;
import java.nio.CharBuffer;

// multiple bounds
public class Bounds
{
	public static void main(String[] args)
	{
		//
	}
	
	public static <S extends Readable & Closeable
				 , T extends Appendable & Closeable>
		void copy(S src, T trg, int size) throws IOException
		{
			CharBuffer buffer = CharBuffer.allocate(size);
			try
			{
				int idx = src.read(buffer);
				while (idx != -1)
				{
					buffer.flip();
					// write
					trg.append(buffer);
					buffer.clear();
					idx = src.read(buffer);
				}
			}
			finally
			{
				src.close();
				trg.close();
			}
		}
}


