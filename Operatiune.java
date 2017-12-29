/**
 * Created by ioan on 12/29/17.
 */
public class Operatiune
{
    private String nume;
    private int id,timpmin,timpmax;

    Operatiune(int valueofid, String valueofnume, int valueoftimpmin, int valueoftimpmax)
    {
        this.id=valueofid;
        this.nume=valueofnume;
        this.timpmin=valueoftimpmin;
        this.timpmax=valueoftimpmax;
    }
    protected int Get_id()
    {
        return this.id;
    }
    protected String Get_nume()
    {
        return this.nume;
    }
    protected int Get_timpmin()
    {
        return this.timpmin;
    }
    protected int Get_timpmax()
    {
        return this.timpmax;
    }
}
