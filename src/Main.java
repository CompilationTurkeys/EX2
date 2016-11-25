   
import java.io.*;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

   
public class Main
{
	static public void main(String argv[])
	{    
		try
		{
			if (argv.length != 2){
				System.out.println("Supply input and output file paths only!\n");
				System.exit(-1);
			}
			
			PrintStream out = new PrintStream(new FileOutputStream(argv[1]));
			
			System.setOut(out);
			
			Lexer lexer = new Lexer(new FileReader(argv[0]));
    	
			
			//while (token.sym != sym.EOF)
			{
				//token = lexer.next_token();
			}
		}
			     
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}


