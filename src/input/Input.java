package input;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;

public class Input {
     public static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

     public int enterInt(String msg) throws IOException {
          while (true) {
               try {
                    System.out.println(msg);
                   return Integer.parseInt(sc.readLine());
               } catch (NumberFormatException n) {
                    System.out.println("Erro, não pode estar vazio e deve ser um número inteiro.\n" + n.getMessage());
               }
          }
     }

     public String enterString(String msg) throws IOException {
          while(true) {
               System.out.println(msg);
               String i = sc.readLine();
               if(i != null) {
                    return sc.readLine();
               }
               System.out.println("Erro, não pode estar vazio");
          }
     }

     public float enterFloat(String msg) throws IOException {
          while (true) {
               try {
                    System.out.println(msg);
                   return Float.parseFloat(sc.readLine());
               } catch (NumberFormatException n) {
                    System.out.println("Erro, não pode estar vazio e deve ser um número.\n" + n.getMessage());
               }
          }
     }

     public byte enterByte(String msg) throws IOException {
          System.out.println(msg);
         return Byte.parseByte(sc.readLine());
     }

     public long enterLong(String msg) throws IOException {
          System.out.println(msg);
         return Long.parseLong(sc.readLine());
     }

     public char enterChar(String msg) throws IOException {
          System.out.println(msg);
          String enter = sc.readLine();
         return enter.charAt(0);
     }

     public double enterDouble(String msg) throws IOException {
          while (true) {
               try {
                    System.out.println(msg);
                   return Double.parseDouble(sc.readLine());
               } catch (NumberFormatException n) {
                    System.out.println("Erro, não pode estar vazio e deve ser um número.\n" + n.getMessage());
               }
          }
     }

     public boolean enterBoolean(String msg) throws IOException {
          System.out.println(msg);
         return Boolean.parseBoolean(sc.readLine());
     }

     public Date enterDate(String msg) throws IOException {
          while (true) {
               try {
                    System.out.println(msg);
                    String dt = sc.readLine();
                    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate ldt = LocalDate.parse(dt,format);
                    if(ldt.getYear() > 1920) {
                         return Date.valueOf(ldt);
                    }
                    System.out.println("Insira novamente, essa data é absurda");
               } catch (DateTimeParseException e) {
                    System.out.println("Data inválida: \n"+e.getMessage());
               }
          }
     }
}
