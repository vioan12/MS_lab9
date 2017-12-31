import java.util.Iterator;

import static java.lang.Character.MAX_VALUE;
import static java.lang.Character.isISOControl;

/**
 * Created by ioan on 12/29/17.
 */
public class Simulare
{
    private static final int NR_CLIENTI_INAINDE_DE_DESCHIDERE = 20;
    public static AgentiePostala PostaRomana;
    public static int clock;
    Simulare()
    {
        Read.console();
    }

    void start()
    {
        int int_temp;
        Client Clienti_temp[];
        Generator G;
        GenerareClient GC;
        Ghiseu Ghiseu_temp;
        G = new StdGenerator(TimpConvert.toInt(PostaRomana.timpdeschidere));
        GC = new GenerareClient(G);
        do{
            int_temp=G.next()+1;
        }while (int_temp>NR_CLIENTI_INAINDE_DE_DESCHIDERE);
        Clienti_temp = new Client[int_temp];
        for(int i=0;i<=Clienti_temp.length; i++){
            Clienti_temp[i]= GC.generare();
        }
        clock=0;
        while (clock<=TimpConvert.toInt(PostaRomana.timpinchidere)){
            for(int i=0; i<Clienti_temp.length; i++){
                for(int j=0; j<Clienti_temp[i].Get_nroperatiuni(); j++){
                    int index=0;
                    int min=MAX_VALUE;
                    Iterator<Ghiseu> iterator = PostaRomana.Get_lista_ghisee();
                    while (iterator.hasNext()){
                        Ghiseu_temp = iterator.next();
                        if(Ghiseu_temp.contine_operatiune_id(Clienti_temp[i].Get_operatiune_index(j).Get_operatiune().Get_id())==true){
                            if(Ghiseu_temp.Get_sizecoada_clienti()<min){
                                min = Ghiseu_temp.Get_sizecoada_clienti();
                                index = PostaRomana.Get_idGhisu(Ghiseu_temp);
                            }
                        }
                    }
                    PostaRomana.Get_ghisu(index).Push_coada_clienti(Clienti_temp[i]);
                }
            }

            Iterator<Ghiseu> iterator = PostaRomana.Get_lista_ghisee();
            while (iterator.hasNext()){
                Ghiseu_temp = iterator.next();
                if(PostaRomana.ClientOperatiuneInDesfasurare(Ghiseu_temp.Head_coada_clienti())==false){ //Clientul nu are nici o operatiune in desfasurare
                    boolean sw=true;
                    for(int i=0; i<Ghiseu_temp.Head_coada_clienti().Get_nroperatiuni(); i++){
                        if(Ghiseu_temp.contine_operatiune_id(Ghiseu_temp.Head_coada_clienti().Get_operatiune_index(i).Get_operatiune().Get_id())==true){ //Giseul poate efectua operatiunea i a Clientului
                            if(Ghiseu_temp.Head_coada_clienti().Get_operatiune_index(i).Get_sw_executata()==false){ //Operatiunea i nu a fost executata
                                sw=false;
                                if(Ghiseu_temp.Head_coada_clienti().Get_operatiune_index(i).Get_sw_desfasurare()==false){ //Operatiunea i nu este in desfasurare
                                    Ghiseu_temp.Head_coada_clienti().Get_operatiune_index(i).Desfasurareoperatiune();
                                    Generator G_timpdesfasurareoperatiune;
                                    G_timpdesfasurareoperatiune = new StdGenerator(Ghiseu_temp.Head_coada_clienti().Get_operatiune_index(i).Get_operatiune().Get_timpmax() - Ghiseu_temp.Head_coada_clienti().Get_operatiune_index(i).Get_operatiune().Get_timpmin()+1);
                                    Ghiseu_temp.Head_coada_clienti().Get_operatiune_index(i).Set_timpexec(G_timpdesfasurareoperatiune.next()+Ghiseu_temp.Head_coada_clienti().Get_operatiune_index(i).Get_operatiune().Get_timpmin());
                                } else {
                                    //if(Ghiseu_temp.Head_coada_clienti().Get_operatiune_index(i).)
                                }

                            } else {

                            }
                        }
                    }
                    if(sw==true){ //Toate operatiunile au fost executate
                        Ghiseu_temp.Pop_coada_clienti();
                    }
            }
            clock++;
        }
    }

}
