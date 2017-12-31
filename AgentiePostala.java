import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Created by ioan on 12/29/17.
 */
public class AgentiePostala
{
    public static String timpdeschidere,timpinchidere;
    public static Operatiune[] lista_operatiuni;
    private HashMap<Integer, Ghiseu> lista_ghisee;

    AgentiePostala(String valueoftimpdeschidere, String valueoftimpinchidere)
    {
        timpdeschidere=valueoftimpdeschidere;
        timpinchidere=valueoftimpinchidere;
        lista_ghisee= new LinkedHashMap<Integer, Ghiseu>();

    }
    protected static String Get_timpdeschidere()
    {
        return timpdeschidere;
    }
    protected void Add_lista_ghisee(int id, Ghiseu ghiseu)
    {
        lista_ghisee.put(id,ghiseu);
    }
    protected Iterator Get_lista_ghisee()
    {
        Iterator itr=lista_ghisee.entrySet().iterator();
        return itr;
    }
    protected Ghiseu Get_ghisu(int index)
    {
        if(lista_ghisee.containsKey(index)==true){
            return lista_ghisee.get(index);
        } else {
            return null;
        }
    }
    protected int Get_nrghisee()
    {
        return lista_ghisee.size();
    }
    protected int Get_idGhisu(Ghiseu ghiseu)
    {
        for (HashMap.Entry<Integer, Ghiseu> e : lista_ghisee.entrySet()) {
            int key = e.getKey();
            Ghiseu value = e.getValue();
            if(ghiseu.equals(value)){
                return key;
            }
        }
        return -1;
    }
    protected boolean ClientOperatiuniInDesfasurarelaalteGhisee (Client client, Ghiseu ghiseu)
    {
        Iterator itr=lista_ghisee.entrySet().iterator();
        while (itr.hasNext()) {
            Ghiseu Ghiseu_temp = (Ghiseu) itr.next();
            if(!Ghiseu_temp.equals(ghiseu)) {
                if (Ghiseu_temp.Head_coada_clienti().equals(client)) {
                    for (int i = 0; i < Ghiseu_temp.Head_coada_clienti().Get_nroperatiuni(); i++) {
                        if (Ghiseu_temp.Head_coada_clienti().Get_operatiune_index(i).Get_sw_desfasurare() == true)
                            return true;
                    }
                }
            }
        }
        return false;
    }
}
