import java.util.HashMap;

/**
 * Created by ioan on 12/30/17.
 */
public class GenerareClient
{
    private Generator G_timpsosire,G_nume,G_prenume,G_operatiuni;
    private HashMap<Integer, String> prenume,nume;

    GenerareClient(Generator valueofG_timpsosire)
    {
        this.G_timpsosire=valueofG_timpsosire;
        G_operatiuni = new StdGenerator(AgentiePostala.lista_operatiuni.length);
        G_prenume = new StdGenerator(30);
        G_nume = new StdGenerator(40);
        prenume = new HashMap<Integer, String>();
        nume = new HashMap<Integer, String>();
        prenume.put(0,"Alexandru");
        prenume.put(1,"Levi");
        prenume.put(2,"David");
        prenume.put(3,"Luca");
        prenume.put(4,"Evan");
        prenume.put(5,"Felix");
        prenume.put(6,"Liam");
        prenume.put(7,"Eli");
        prenume.put(8,"Aiden");
        prenume.put(9,"Aryana");
        prenume.put(10,"Sofia");
        prenume.put(11,"Lidia");
        prenume.put(12,"Anya");
        prenume.put(13,"Adira");
        prenume.put(14,"Ava");
        prenume.put(15,"Evelin");
        prenume.put(16,"Olivia");
        prenume.put(17,"Maira");
        prenume.put(18,"Ela");
        prenume.put(19,"Ema");
        prenume.put(20,"Razvan");
        prenume.put(21,"Sorin");
        prenume.put(22,"Ioan");
        prenume.put(23,"Grigore");
        prenume.put(24,"Madalin");
        prenume.put(25,"Ileana");
        prenume.put(26,"Dimitrie");
        prenume.put(27,"Constantin");
        prenume.put(28,"Dragos");
        prenume.put(29,"Ciprian");
        nume.put(0,"Nita");
        nume.put(1,"Pop");
        nume.put(2,"Popa");
        nume.put(3,"Popescu");
        nume.put(4,"Ionescu");
        nume.put(5,"Nemes");
        nume.put(6,"Stan");
        nume.put(7,"Dumitrescu");
        nume.put(8,"Dima");
        nume.put(9,"Gheorghiu");
        nume.put(10,"Ionita");
        nume.put(11,"Marin");
        nume.put(12,"Tudor");
        nume.put(13,"Dobre");
        nume.put(14,"Barbu");
        nume.put(15,"Nistor");
        nume.put(16,"Florea");
        nume.put(17,"Ene");
        nume.put(18,"Dinu");
        nume.put(19,"Georgescu");
        nume.put(20,"Stoica");
        nume.put(21,"Diaconu");
        nume.put(22,"Diaconescu");
        nume.put(23,"Mazilescu");
        nume.put(24,"Ababei");
        nume.put(25,"Aanei");
        nume.put(26,"Nistor");
        nume.put(27,"Mocanu");
        nume.put(28,"Oprea");
        nume.put(29,"Voinea");
        nume.put(30,"Dochioiu");
        nume.put(31,"Albu");
        nume.put(32,"Tabacu");
        nume.put(33,"Manole");
        nume.put(34,"Cristea");
        nume.put(35,"Toma");
        nume.put(36,"Stanescu");
        nume.put(37,"Preda");
        nume.put(38,"Puscasu");
        nume.put(39,"Tomescu");
    }
    public Client generare()
    {
        int int_temp1,int_temp2,int_temp3,int_temp4;
        Operatiune[] Operatiuni_temp;
        Client Client_temp;
        int_temp1 = G_nume.next(); //Nume
        int_temp2 = G_prenume.next(); //Prenume
        int_temp4 = G_timpsosire.next(); //Timpul de sosoire [int]
        int_temp3 = G_operatiuni.next()+1; //nrOperatiuni
        Operatiuni_temp =  new Operatiune[int_temp3]; //Operatiunile
        for(int i=0; i<Operatiuni_temp.length; i++){
            int_temp3 = G_operatiuni.next(); //Indicele Operatiunii generate
            Operatiuni_temp[i] = AgentiePostala.lista_operatiuni[int_temp3]; //Operatiunea i
        }
        Client_temp = new Client((nume.get(int_temp1)+" "+prenume.get(int_temp2)),int_temp4,Operatiuni_temp);
        return Client_temp;
    }
}
