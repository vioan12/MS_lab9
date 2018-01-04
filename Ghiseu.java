import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by ioan on 12/29/17.
 */
public class Ghiseu
{
    private LinkedList<Client> coada_clienti;
    private Operatiune[] operatiuni;

    Ghiseu(Operatiune[] valueoflisa_operatiuni)
    {
        coada_clienti= new LinkedList<Client>();
        operatiuni = new Operatiune[valueoflisa_operatiuni.length];
        for(int i=0; i<operatiuni.length; i++) {
            operatiuni[i]=valueoflisa_operatiuni[i];
        }
    }
    protected int Get_sizecoada_clienti()
    {
        return coada_clienti.size();
    }
    protected Iterator Get_coada_clienti()
    {
        return coada_clienti.iterator();
    }
    protected void Push_coada_clienti(Client client)
    {
        coada_clienti.add(client);
    }
    protected void Pop_coada_clienti()
    {
        coada_clienti.remove();
    }
    protected Client Head_coada_clienti()
    {
        if(Get_sizecoada_clienti()>0) {
            return coada_clienti.element();
        } else {
            return null;
        }
    }
    protected void HeadDowngrade_coada_clienti()
    {
        if(coada_clienti.size()>1) {
            Client Client_temp;
            Client_temp = (Client) coada_clienti.element();
            coada_clienti.remove();
            coada_clienti.add(1, Client_temp);
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
