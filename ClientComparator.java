import java.util.Comparator;

/**
 * Created by ioan on 1/2/18.
 */
public class ClientComparator implements Comparator<Client>
{
    @Override public int compare(Client o1, Client o2)
    {
        boolean sw_o1=false,sw_o2=false;
        for(int i=0; i<(o1.Get_nroperatiuni())&&(sw_o1==false); i++){
            if(o1.Get_operatiune_index(i).Get_sw_desfasurare()==true){
                sw_o1=true;
            }
        }
        for(int i=0; i<(o2.Get_nroperatiuni())&&(sw_o2==false); i++){
            if(o2.Get_operatiune_index(i).Get_sw_desfasurare()==true){
                sw_o2=true;
            }
        }
        if(sw_o1 != sw_o2) {
            if ((sw_o1 == false) && (sw_o2 == true)) {
                return -1;
            }
            if ((sw_o1 == true) && (sw_o2 == false)) {
                return 1;
            }
        }
        if(sw_o1 == sw_o2) {
            if (o1.Get_timpsosire() < o2.Get_timpsosire()) {
                return -1;
            }
            if (o1.Get_timpsosire() > o2.Get_timpsosire()) {
                return 1;
            }
        }
        return 0;
    }
}
