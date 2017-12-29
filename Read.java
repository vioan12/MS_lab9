import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by ioan on 12/29/17.
 */
public class Read
{
    void console()
    {
        FileReader in;
        BufferedReader br;
        Operatiune[] Operatiune_temp;
        int int_temp,int_temp2,int_temp3;
        String String_temp;
        try {
            in = new FileReader("Input.txt");
            br = new BufferedReader(in);
            Simulare.PostaRomana= new AgentiePostala(br.readLine());
            int_temp = Integer.parseInt(br.readLine());
            Operatiune_temp = new Operatiune[int_temp];
            for(int i=0; i<Operatiune_temp.length; i++){
                String_temp = br.readLine();
                int_temp = Integer.parseInt(br.readLine());
                int_temp2 = Integer.parseInt(br.readLine());
                int_temp3 = Integer.parseInt(br.readLine());
                Operatiune_temp[i]=new Operatiune(int_temp, String_temp, int_temp2, int_temp3);
            }
            int_temp = Integer.parseInt(br.readLine());

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}

