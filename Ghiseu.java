import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by ioan on 12/29/17.
 */
public class Ghiseu
{
    private PriorityQueue<Client> coada_clienti;
    Comparator<Client> comparator;
    private Operatiune[] operatiuni;

    Ghiseu(Operatiune[] valueoflisa_operatiuni)
    {
        comparator = new ClientComparator();
        coada_clienti= new PriorityQueue<Client>(comparator);
        operatiuni = new Operatiune[valueoflisa_operatiuni.length];
        for(int i=0; i<operatiuni.length; i++) {
            operatiuni[i]=valueoflisa_operatiuni[i];
        }
    }
    protected int Get_sizecoada_clienti()
    {
        return coada_clienti.size();
    }
    protected void Push_coada_clienti(Client client)
    {
        coada_clienti.add(client);
    }
    protected void Pop_coada_clienti()
    {
        coada_clienti.poll();
    }
    protected Client Head_coada_clienti()
    {
        return coada_clienti.peek();
    }
    protected void HeadDowngrade_coada_clienti()
    {
        Client head, tempclient;
        head = Head_coada_clienti();
        Pop_coada_clienti();
        tempclient = Head_coada_clienti();
        Pop_coada_clienti();
        Push_coada_clienti(tempclient);
        Push_coada_clienti(head);
        for (int i = 0; i < coada_clienti.size() - 2; i++) {
            tempclient = Head_coada_clienti();
            Pop_coada_clienti();
            Push_coada_clienti(tempclient);
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
