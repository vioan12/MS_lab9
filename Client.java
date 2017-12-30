/**
 * Created by ioan on 12/29/17.
 */
public class Client
{
    private String nume;
    private TimpOperatiune[] operatiuni;
    private int timpsosire;
    private int timpplecare;
    protected class TimpOperatiune
    {
        private Operatiune operatiune;
        private int timpexec;
        private boolean sw_executata,sw_desfasurare;

        TimpOperatiune(Operatiune valueofoperatiune)
        {
            this.operatiune=valueofoperatiune;
            timpexec=0;
            sw_executata=false;
            sw_desfasurare=false;
        }
        protected void Set_timpexec(int valueoftimpexec)
        {
            this.timpexec=valueoftimpexec;
        }
        protected int Get_timpexec()
        {
            return this.timpexec;
        }
        protected Operatiune Get_operatiune()
        {
            return this.operatiune;
        }
        protected boolean Get_sw_executata()
        {
            return this.sw_executata;
        }
        protected void Executataoperatiune()
        {
            this.sw_executata=true;
            this.sw_desfasurare=false;
        }
        protected boolean Get_sw_desfasurare()
        {
            return this.sw_desfasurare;
        }
        protected void Desfasurareoperatiune()
        {
            this.sw_desfasurare=true;
        }

    }

    Client(String valueofnume, int valueoftimpsosire, Operatiune[] valueoflista_operatiuni)
    {
        this.nume=valueofnume;
        this.timpsosire=valueoftimpsosire;
        this.operatiuni=new TimpOperatiune[valueoflista_operatiuni.length];
        for(int i=0; i<operatiuni.length; i++){
            operatiuni[i]=new TimpOperatiune(valueoflista_operatiuni[i]);
        }
        this.timpplecare=valueoftimpsosire;
    }
    protected int Get_timpsosire()
    {
        return this.timpsosire;
    }
    protected int Get_timpplecare()
    {
        return this.timpplecare;
    }
    protected TimpOperatiune Get_operatiune_index(int index)
    {
        return operatiuni[index];
    }
    protected int Get_nroperatiuni()
    {
        return operatiuni.length;
    }
    protected void Set_timpplecare(int valueoftimpplecare)
    {
        this.timpplecare=valueoftimpplecare;
    }
}
