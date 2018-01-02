import java.util.Comparator;

/**
 * Created by ioan on 1/2/18.
 */
public class ClientComparator implements Comparator<Client>
{
    @Override public int compare(Client o1, Client o2)
    {
        if (o1.Get_timpsosire() < o2.Get_timpsosire())
        {
            return -1;
        }
        if (o1.Get_timpsosire() > o2.Get_timpsosire())
        {
            return 1;
        }
        return 0;
    }
}
