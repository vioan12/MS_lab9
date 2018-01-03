import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by ioan on 12/29/17.
 */
public class Ghiseu
{
    private Queue_LinkedList coada_clienti;
    private Operatiune[] operatiuni;

    Ghiseu(Operatiune[] valueoflisa_operatiuni)
    {
        coada_clienti= new Queue_LinkedList<Client>();
        operatiuni = new Operatiune[valueoflisa_operatiuni.length];
        for(int i=0; i<operatiuni.length; i++) {
            operatiuni[i]=valueoflisa_operatiuni[i];
        }
    }
    protected int Get_sizecoada_clienti()
    {
        return coada_clienti.Size();
    }
    protected Queue_LinkedList<Client> Get_coada_clienti()
    {
        return coada_clienti;
    }
    protected void Push_coada_clienti(Client client)
    {
        coada_clienti.Add(client);
    }
    protected void Pop_coada_clienti()
    {
        coada_clienti.Remove();
    }
    protected Client Head_coada_clienti()
    {
        return (Client)coada_clienti.Value();
    }
    protected void HeadDowngrade_coada_clienti()
    {
        if(coada_clienti.Size()>1) {
            coada_clienti.HeadDowngrade();
        }
    }
    protected boolean contine_operatiune_id(int id)
    {
        boolean sw=false;
        for(int i=0; (i<operatiuni.length)&&(sw==false); i++){
            if(operatiuni[i].Get_id()==id){
                sw=true;
            }
        }
        return sw;
    }
}
