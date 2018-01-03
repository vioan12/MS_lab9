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
        Queue_LinkedList<Client> iterator2;
        try {
            iterator = Simulare.PostaRomana.Get_lista_ghisee();
            out.write("[" + Simulare.clock + "]\n");
            while (iterator.hasNext()) {
                pair = (Map.Entry) iterator.next();
                Ghiseu_temp_value = (Ghiseu) pair.getValue();
                Ghiseu_temp_id = (int) pair.getKey();
                out.write("Ghiseul " + Ghiseu_temp_id + ":\n");
                iterator2 = Ghiseu_temp_value.Get_coada_clienti();
                while (iterator2.Next()!=null) {
                    Client_temp = (Client) iterator2.Value();
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
                    iterator2 = iterator2.Next();
                }
            }
            out.write("------------------------------------------------------------------------------------------------\n\n");
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
