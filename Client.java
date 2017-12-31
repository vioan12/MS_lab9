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
        private int timpstartexec;
        private int duratatimpexec;
        private boolean sw_executata,sw_desfasurare;
        private int id_Ghiseu;

        TimpOperatiune(Operatiune valueofoperatiune)
        {
            this.operatiune=valueofoperatiune;
            duratatimpexec=0;
            sw_executata=false;
            sw_desfasurare=false;
        }
        protected void Set_duratatimpexec(int valueofduratatimpexec)
        {
            this.duratatimpexec=valueofduratatimpexec;
        }
        protected int Get_duratatimpexec()
        {
            return this.duratatimpexec;
        }
        protected int Get_timpstartexec()
        {
            return this.timpstartexec;
        }
        protected Operatiune Get_operatiune()
        {
            return this.operatiune;
        }
        protected boolean Get_sw_executata()
        {
            return this.sw_executata;
        }
        protected int Get_id_Ghiseu()
        {
            return this.id_Ghiseu;
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
        protected void Desfasurareoperatiune(int id, int valueoftimpstartexec)
        {
            this.sw_desfasurare=true;
            this.id_Ghiseu=id;
            this.timpstartexec=valueoftimpstartexec;
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
