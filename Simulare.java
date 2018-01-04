import java.util.Iterator;
import java.util.Map;

import static java.lang.Character.MAX_VALUE;

/**
 * Created by ioan on 12/29/17.
 */
public class Simulare
{
    private static final int NR_CLIENTI_MAX = 100;
    private static final int NR_CLIENTI_MIN = 50;
    public static AgentiePostala PostaRomana;
    public static int clock;
    private Write W;

    Simulare()
    {
        Read.console();
        W = new Write();
    }
    void start()
    {
        int int_temp;
        Client Clienti_temp[];
        Generator G2,G_inexe;
        GenerareClient GC;
        Ghiseu Ghiseu_temp_value;
        int Ghiseu_temp_id;
        G2 = new StdGenerator(NR_CLIENTI_MAX-NR_CLIENTI_MIN);
        G_inexe = new StdGenerator(TimpConvert.toInt(PostaRomana.timpinchidere)-TimpConvert.toInt(PostaRomana.timpdeschidere));
        GC = new GenerareClient(G_inexe);
        int_temp=G2.next()+NR_CLIENTI_MIN;
        Clienti_temp = new Client[int_temp];
        for(int i=0;i<Clienti_temp.length; i++){
            Clienti_temp[i]= GC.generare();
        }
        clock=0;
        W.console();
        GC = new GenerareClient(G_inexe);
        while (clock<=TimpConvert.toInt(PostaRomana.timpinchidere)) {
            for (int i = 0; i < Clienti_temp.length; i++) {
                for (int j = 0; j < Clienti_temp[i].Get_nroperatiuni(); j++) {
                    int index = 0;
                    int min = MAX_VALUE;
                    Iterator iterator2 = PostaRomana.Get_lista_ghisee();
                    while (iterator2.hasNext()) {
                        Map.Entry pair2 = (Map.Entry)iterator2.next();
                        Ghiseu_temp_value = (Ghiseu)pair2.getValue();
                        Ghiseu_temp_id = (int)pair2.getKey();
                        if (Ghiseu_temp_value.contine_operatiune_id(Clienti_temp[i].Get_operatiune_index(j).Get_operatiune().Get_id()) == true) {
                            if (Ghiseu_temp_value.Get_sizecoada_clienti() < min) {
                                min = Ghiseu_temp_value.Get_sizecoada_clienti();
                                index = Ghiseu_temp_id;
                            }
                        }
                    }
                    if(PostaRomana.Get_ghisu(index)!=null) {
                        if (Clienti_temp[i].Get_timpsosire() == clock) {
                            PostaRomana.Get_ghisu(index).Push_coada_clienti(Clienti_temp[i]);
                        }
                    }
                }
            }
            Iterator iterator = PostaRomana.Get_lista_ghisee();
            while (iterator.hasNext()) {
                Map.Entry pair = (Map.Entry) iterator.next();
                Ghiseu_temp_value = (Ghiseu) pair.getValue();
                Ghiseu_temp_id = (int) pair.getKey();
                boolean sw;
                sw = true;
                if (Ghiseu_temp_value.Head_coada_clienti() != null) {
                    for (int i = 0; i < Ghiseu_temp_value.Head_coada_clienti().Get_nroperatiuni(); i++) {
                        if (Ghiseu_temp_value.contine_operatiune_id(Ghiseu_temp_value.Head_coada_clienti().Get_operatiune_index(i).Get_operatiune().Get_id()) == true) { //Ghiseul poate efectua operatiunea i a Clientului
                            if (Ghiseu_temp_value.Head_coada_clienti().Get_operatiune_index(i).Get_sw_executata() == false) { //Operatiunea i nu a fost executata
                                sw = false;
                                if (Ghiseu_temp_value.Head_coada_clienti().Get_operatiune_index(i).Get_sw_desfasurare() == false) { //Operatiunea i nu este in desfasurare
                                    if (PostaRomana.ClientOperatiuniInDesfasurarelaalteGhisee(Ghiseu_temp_value.Head_coada_clienti(), Ghiseu_temp_value) == false) { //Clientul nu are nici o operatiune in desfasurare la alte Ghisee
                                        Ghiseu_temp_value.Head_coada_clienti().Get_operatiune_index(i).Desfasurareoperatiune(Ghiseu_temp_id, clock);
                                        Generator G_timpdesfasurareoperatiune;
                                        G_timpdesfasurareoperatiune = new StdGenerator(Ghiseu_temp_value.Head_coada_clienti().Get_operatiune_index(i).Get_operatiune().Get_timpmax() - Ghiseu_temp_value.Head_coada_clienti().Get_operatiune_index(i).Get_operatiune().Get_timpmin() + 1);
                                        Ghiseu_temp_value.Head_coada_clienti().Get_operatiune_index(i).Set_duratatimpexec((G_timpdesfasurareoperatiune.next() + Ghiseu_temp_value.Head_coada_clienti().Get_operatiune_index(i).Get_operatiune().Get_timpmin()));
                                        Ghiseu_temp_value.Head_coada_clienti().Get_operatiune_index(i).Set_timpstartexec(clock);
                                    } else {
                                        Ghiseu_temp_value.HeadDowngrade_coada_clienti();
                                    }
                                } else {
                                    if (Ghiseu_temp_id == Ghiseu_temp_value.Head_coada_clienti().Get_operatiune_index(i).Get_id_Ghiseu()) { //Operatiunea este in desfasurare la Ghiseul curent
                                        if (Ghiseu_temp_value.Head_coada_clienti().Get_operatiune_index(i).Get_timpstartexec() + Ghiseu_temp_value.Head_coada_clienti().Get_operatiune_index(i).Get_duratatimpexec() <= clock) {
                                        } else {
                                            Ghiseu_temp_value.Head_coada_clienti().Get_operatiune_index(i).Executataoperatiune();
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (sw == true) { //Toate operatiunile au fost executate
                        Ghiseu_temp_value.Pop_coada_clienti();
                    }
                }
            }
            clock++;
            W.console();
        }
        W.close();
    }

}
