import java.io.*; //Printwriter

public class PolylinjeTest {

    public static void main (String[] args) {
        PrintWriter out = new PrintWriter (System.out, true);
        
        Punkt p1 = new Punkt("A", 3, 4);
        Punkt p2 = new Punkt("B", 5, 2);
        Punkt p3 = new Punkt("C", 7, 1);
        Punkt p4 = new Punkt("D", 10, 12);
        Punkt[] px = {p1, p2, p3, p4};
        
        //Skapa ny polylinje
        Polylinje pl1 = new Polylinje(px);
        
        
        //Testa inspektorer
        out.println("Polylinje(toString): " + pl1.toString());
        String f = pl1.getFarg();
        int b = pl1.getBredd();
        Punkt h[] = pl1.getHorn();
        out.println("Färg: " + f + "    Bredd: " + b + "\nHörn: ");
        for (int i = 0; i < h.length; i++) {
            out.println(h[i]);
        }
        
        //Testa en kombinator
        double l = pl1.langd();
        out.println("Längd: " + l);

        //Testa komparator
        boolean test = p4.equals(p2);
        System.out.println("är punkt 3 och  2 lika? " + test);
        
        
        //Testa mutatorer
        out.println("Gamla Färgen: " + f);
        pl1.setFarg("blå");
        f = pl1.getFarg();
        out.println("Nya Färgen: " + f);
        
        out.println("Gamla Bredden: " + b);
        pl1.setBredd(5);
        b = pl1.getBredd();
        out.println("Nya Bredden: " + b);
            
        Punkt p5 = new Punkt("E", 23, 2);
        pl1.laggTill(p5);
        out.println("Polylinje(nytt hörn efter): " + pl1.toString());
        
        Punkt p0 = new Punkt("-A", 3, 1);
        pl1.laggTillFramfor(p0, "A");
        out.println("Polylinje(nytt hörn framför): " + pl1.toString());
        
        pl1.taBort("B");
        out.println("Polylinje(ta bort hörn): " + pl1.toString());

        //testa Iteratorn
        Polylinje.PolylinjeIterator pit = pl1.new PolylinjeIterator();
        while(pit.finnsHorn())
		{
			System.out.println(pit.horn().toString());
			pit.gaFram();
		}


    }

    

}