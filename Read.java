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
        Operatiune[] Operatiune_temp,Operatiune_temp2;
        Ghiseu Ghiseu_temp;
        int int_temp,int_temp2,int_temp3,int_temp4;
        String String_temp;
        try {
            in = new FileReader("PostaRomana.txt");
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
            int_temp = Integer.parseInt(br.readLine()); //nrGhisee
            for(int i=0; i<int_temp; i++){
                int_temp2 = Integer.parseInt(br.readLine()); //IDGhiseu
                int_temp3 = Integer.parseInt(br.readLine()); //nrOperatiuni
                Operatiune_temp2 = new Operatiune[int_temp3];
                for(int j=0; j<int_temp3; j++){
                    int_temp4 = Integer.parseInt(br.readLine()); //IDOperatiune
                    for(int k=0;k<Operatiune_temp.length;i++) {
                        if(int_temp4==Operatiune_temp[k].Get_id()){
                            Operatiune_temp2[j]=Operatiune_temp[k];
                        }
                    }
                }
                Ghiseu_temp = new Ghiseu(Operatiune_temp2);
                Simulare.PostaRomana.Add_lista_ghisee(int_temp2,Ghiseu_temp);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
