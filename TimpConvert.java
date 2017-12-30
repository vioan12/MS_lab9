/**
 * Created by ioan on 12/29/17.
 */
public class TimpConvert
{
    static public int delaytotimpdeschidere(String timp)
    {
        return (toInt(AgentiePostala.timpdeschidere)-toInt(timp));
    }
    static public int delaytotimpdeschidere(int timp)
    {
        return (toInt(AgentiePostala.timpdeschidere)-timp);
    }
    static public int toInt(String timp)
    {
        int ora,minute;
        ora = Integer.parseInt(String.valueOf(timp.charAt(0))+String.valueOf(timp.charAt(1)));
        minute = Integer.parseInt(String.valueOf(timp.charAt(3))+String.valueOf(timp.charAt(4)));
        return (ora*60+minute);
    }
    static public String toStr(int timp)
    {
        String String_temp1,String_temp2;
        String_temp1 = String.valueOf(timp / 60);
        String_temp2 = String.valueOf(timp % 60);
        return (String_temp1+":"+String_temp2);
    }
}
