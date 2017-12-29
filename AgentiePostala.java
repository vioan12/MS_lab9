import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by ioan on 12/29/17.
 */
public class AgentiePostala
{
    private static String timpdeschidere;
    private HashMap<Integer, Ghiseu> lista_ghisee;

    AgentiePostala(String valueoftimpdeschidere)
    {
        timpdeschidere=valueoftimpdeschidere;
        lista_ghisee= new HashMap<Integer, Ghiseu>();
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
}
