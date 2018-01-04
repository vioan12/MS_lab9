import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by ioan on 1/2/18.
 */
public class Write
{
    private FileWriter out;

    Write()
    {
        try {
            out = new FileWriter("Out.txt");
        }catch (Exception e) {
            System.err.println(e);
        }
    }
    protected void console()
    {
        Ghiseu Ghiseu_temp_value;
        int Ghiseu_temp_id;
        Client Client_temp;
        Map.Entry pair;
        Iterator iterator;
        Iterator iterator2;
        try {
            iterator = Simulare.PostaRomana.Get_lista_ghisee();
            out.write("[" + Simulare.clock + "]\n");
            while (iterator.hasNext()) {
                pair = (Map.Entry) iterator.next();
                Ghiseu_temp_value = (Ghiseu) pair.getValue();
                Ghiseu_temp_id = (int) pair.getKey();
                out.write("Ghiseul " + Ghiseu_temp_id + ":\n");
                iterator2 = Ghiseu_temp_value.Get_coada_clienti();
                while (iterator2.hasNext()) {
                    Client_temp = (Client) iterator2.next();
                    out.write("     " + Client_temp.Get_nume() +"("+Client_temp.Get_timpsosire()+")"+ ":\n");
                    for (int i = 0; i < Client_temp.Get_nroperatiuni(); i++) {
                        out.write("             " + i + ":" + Client_temp.Get_operatiune_index(i).Get_operatiune().Get_id() + " ");
                        if (Client_temp.Get_operatiune_index(i).Get_sw_desfasurare() == true) {
                            out.write(Client_temp.Get_operatiune_index(i).Get_sw_desfasurare() + "(" + Client_temp.Get_operatiune_index(i).Get_id_Ghiseu() + ") ");
                        } else {
                            out.write(Client_temp.Get_operatiune_index(i).Get_sw_desfasurare() + " ");
                        }
                        if (Client_temp.Get_operatiune_index(i).Get_sw_executata() == true) {
                            out.write(Client_temp.Get_operatiune_index(i).Get_sw_executata() + "(" + Client_temp.Get_operatiune_index(i).Get_id_Ghiseu() + ")");
                        } else {
                            out.write(Client_temp.Get_operatiune_index(i).Get_sw_executata()+"");
                        }
                        out.write("\n");
                    }
                }
            }
            out.write("------------------------------------------------------------------------------------------------\n\n");
        }catch (Exception e) {
            System.err.println(e);
        }
    }
    protected void console_end()
    {
        Ghiseu Ghiseu_temp_value;
        int Ghiseu_temp_id;
        Client Client_temp;
        Map.Entry pair;
        Iterator iterator;
        iterator = Simulare.PostaRomana.Get_lista_ghisee();
        try {
            while (iterator.hasNext()) {
                out.write("\n");
                pair = (Map.Entry) iterator.next();
                Ghiseu_temp_value = (Ghiseu) pair.getValue();
                Ghiseu_temp_id = (int) pair.getKey();
                out.write("Ghiseul: " + Ghiseu_temp_id + "\n");
                out.write("     Lungimea maxima a cozi: "+Ghiseu_temp_value.Get_lungimemaxima()+"\n");
                out.write("     Timpul de utilizare: "+Ghiseu_temp_value.Get_timpuldeutilizare()+" minute\n");
                out.write("     Numar mediu de clienti: "+(((double)Ghiseu_temp_value.Get_numarulmediuclienti()/(double)Ghiseu_temp_value.Get_timpuldeutilizare())+"\n"));
            }
            out.write("------------------------------------------------------------------------------------------------\n\n");
            out.write("Numarul de Clienti: " + Simulare.Clienti_temp.length + "\n\n");
            for(int i=0; i<Simulare.Clienti_temp.length; i++){
                boolean sw = true;
                for(int j=0; j<(Simulare.Clienti_temp[i].Get_nroperatiuni())&&(sw==true); j++){
                    if(Simulare.Clienti_temp[i].Get_operatiune_index(j).Get_sw_executata()==false){
                        sw = false;
                    }
                }
                if(sw==true){
                    out.write("Clientul: " + Simulare.Clienti_temp[i].Get_nume() + "\n");
                    out.write("     Timpul de sosire: "+TimpConvert.toStr(Simulare.Clienti_temp[i].Get_timpsosire()+TimpConvert.toInt(Simulare.PostaRomana.timpdeschidere))+"\n");
                    out.write("     Timpul de plecare: "+TimpConvert.toStr(Simulare.Clienti_temp[i].Get_timpplecare()+TimpConvert.toInt(Simulare.PostaRomana.timpdeschidere))+"\n");
                    out.write("     Numarul de operatiuni: "+Simulare.Clienti_temp[i].Get_nroperatiuni()+"\n");
                    int int_temp=0, int_temp2=0;
                    for(int j=0; j<Simulare.Clienti_temp[i].Get_nroperatiuni(); j++){
                        out.write("          "+Simulare.Clienti_temp[i].Get_operatiune_index(j).Get_operatiune().Get_nume()+"\n");
                        int_temp = int_temp + (Simulare.Clienti_temp[i].Get_operatiune_index(j).Get_timpstartexec() - Simulare.Clienti_temp[i].Get_timpsosire());
                        int_temp2 = int_temp2 + int_temp + Simulare.Clienti_temp[i].Get_operatiune_index(j).Get_duratatimpexec();
                    }
                    out.write("     Timp mediu de asteptare: "+(int_temp/Simulare.Clienti_temp[i].Get_nroperatiuni())+" minute\n");
                    out.write("     Timp mediu de raspuns: "+(int_temp2/Simulare.Clienti_temp[i].Get_nroperatiuni())+" minute\n");
                    out.write("\n");
                }
            }
        }catch (Exception e) {
            System.err.println(e);
        }
    }
    protected void close()
    {
        try {
            out.close();
        }catch (Exception e) {
            System.err.println(e);
        }
    }
}
