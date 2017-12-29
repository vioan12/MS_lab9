import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by ioan on 12/29/17.
 */
public class Ghiseu
{
    private PriorityQueue<Client> coada_clienti;
    private Operatiune[] operatiuni;

    Ghiseu(Operatiune[] valueoflisa_operatiuni)
    {
        coada_clienti= new PriorityQueue<Client>();
        operatiuni = new Operatiune[valueoflisa_operatiuni.length];
        for(int i=0; i<operatiuni.length; i++) {
            operatiuni[i]=valueoflisa_operatiuni[i];
        }
    }
    protected void Push_coada_clienti(Client valueofclient)
    {
        coada_clienti.add(valueofclient);
    }
    protected void Pop_coada_clienti()
    {
        coada_clienti.poll();
    }
    protected Client Head_coada_clienti()
    {
        return coada_clienti.peek();
    }
}
