/**
 * Created by ioan on 12/29/17.
 */
public class TimpConvert
{
    static int toInt(String timp)
    {
        int orabaza,ora;
        int minutebaza,minute;
        orabaza = Integer.parseInt(String.valueOf(AgentiePostala.Get_timpdeschidere().charAt(0))+String.valueOf(AgentiePostala.Get_timpdeschidere().charAt(1)));
        ora = Integer.parseInt(String.valueOf(timp.charAt(0))+String.valueOf(timp.charAt(1)));
        minutebaza = Integer.parseInt(String.valueOf(AgentiePostala.Get_timpdeschidere().charAt(3))+String.valueOf(AgentiePostala.Get_timpdeschidere().charAt(4)));
        minute = Integer.parseInt(String.valueOf(timp.charAt(3))+String.valueOf(timp.charAt(4)));
        return ((ora-orabaza)*60+(minute-minutebaza));
    }
}
