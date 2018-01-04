import java.util.Iterator;
import java.util.LinkedList;

import static java.lang.Character.MIN_VALUE;

/**
 * Created by ioan on 12/29/17.
 */
public class Ghiseu
{
    private LinkedList<Client> coada_clienti;
    private Operatiune[] operatiuni;
    private int lungimemaxima, timpuldeutilizare, numarulmediuclienti;

    Ghiseu(Operatiune[] valueoflisa_operatiuni)
    {
        coada_clienti= new LinkedList<Client>();
        operatiuni = new Operatiune[valueoflisa_operatiuni.length];
        for(int i=0; i<operatiuni.length; i++) {
            operatiuni[i]=valueoflisa_operatiuni[i];
        }
        lungimemaxima = MIN_VALUE;
        timpuldeutilizare = 0;
        numarulmediuclienti = 0;
    }
    protected int Get_sizecoada_clienti()
    {
        return coada_clienti.size();
    }
    protected Iterator Get_coada_clienti()
    {
        return coada_clienti.iterator();
    }
    protected int Get_timpuldeutilizare()
    {
        return this.timpuldeutilizare;
    }
    protected int Get_lungimemaxima()
    {
        return this.lungimemaxima;
    }
    protected int Get_numarulmediuclienti()
    {
        return this.numarulmediuclienti;
    }
    protected void Push_coada_clienti(Client client)
    {
        coada_clienti.add(client);
        if(coada_clienti.size() > lungimemaxima){
            lungimemaxima = coada_clienti.size();
        }
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
    protected void update()
    {
        if(coada_clienti.size()>0){
            timpuldeutilizare++;
            numarulmediuclienti = numarulmediuclienti + coada_clienti.size();
        }
    }
}
