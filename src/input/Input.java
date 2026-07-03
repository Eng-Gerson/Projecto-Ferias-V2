package input;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Input {
     public static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
     public int enterInt(String msg)throws IOException{
          System.out.println(msg);
          int i = Integer.parseInt(sc.readLine());
          return i;
     }

     public String enterString(String msg)throws IOException{
          System.out.println(msg);
          String i = sc.readLine();
          return i;
     }

     public float enterFloat(String msg)throws IOException{
          System.out.println(msg);
          float i = Float.parseFloat(sc.readLine());
          return i;
     }

     public byte enterByte(String msg)throws IOException{
          System.out.println(msg);
          byte i = Byte.parseByte(sc.readLine());
          return i;
     }

     public long enterLong(String msg)throws IOException{
          System.out.println(msg);
          long i = Long.parseLong(sc.readLine());
          return i;
     }

     public char enterChar(String msg)throws IOException{
          System.out.println(msg);
          String enter = sc.readLine();
          char i = enter.charAt(0);
          return i;
     }
	 
	 public double enterDouble(String msg)throws IOException{
		System.out.println(msg);
		double i = Double.parseDouble(sc.readLine());
		return i;
	 }
      public boolean enterBoolean(String msg)throws IOException{
          System.out.println(msg);
          boolean i = Boolean.parseBoolean(sc.readLine());
          return i;
      }
}
