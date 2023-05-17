public class Polylinje {

    private Punkt[] horn;
    private String farg = "svart";
    private int bredd = 1;
    
    public Polylinje() { 
        
        this.horn = new Punkt[0]; 
    }
    
    public Polylinje(Punkt[] horn) {
    
        this.horn = new Punkt[horn.length];
        for (int i = 0; i < horn.length; i++) 
            this.horn[i] = new Punkt(horn[i]);
    }
    
    //bestäm polylinjens strängrepresentation
    public String toString() {
        String punkter = "{";
        for (int i = 0; i < horn.length; i++) {
            punkter = punkter + ( "{" + horn[i].getNamn() + " " + horn[i].getX() + " " + horn[i].getY() + "}");
        }
        return punkter + "}";
    }
    
    
    //Returerar hörnen
	public Punkt[] getHorn () {
		Punkt[] h = new Punkt[horn.length];
		for(int i = 0; i < horn.length; i++) {
		   h[i] = new Punkt (horn[i]);
		}
		return h;
	}
    
    //Returerar färgen
	public String getFarg () {
		String farg = this.farg;
		return farg;
	}

    //Returerar bredden
	public int getBredd () {
		int bredd = this.bredd;
		return bredd;
	}

    //Sätter färgen
	public void setFarg (String farg) {
		this.farg = farg;
	}
	
	//Sätter bredden
	public void setBredd (int bredd) {
	this.bredd = bredd;
	}

    //Metod som returnerar längd
    public double langd() {
        double totalLangd = 0;
        for (int i = 0; i < this.horn.length - 1; i++) {
            totalLangd += this.horn[i].avstand(this.horn[i + 1]);
        }
        return totalLangd;
    }
    
    //Metod som lägger till ett hörn
    public void laggTill(Punkt horn) {

        Punkt[] h = new Punkt[this.horn.length + 1];
        for(int i = 0; i < this.horn.length; i++) {
            h[i] = this.horn[i];
        }
        h[this.horn.length] = new Punkt(horn);
        this.horn = h;    
    }
    
    //en metod som lägger till en punkt i polylinjen framför en angiven punkt.
    public void laggTillFramfor (Punkt horn, String hornNamn) {
        Punkt[] h = new Punkt[this.horn.length + 1];
        for(int i = 0, j = 0; i < h.length; i++, j++) {
            if(i < this.horn.length) {
                if(hornNamn.equalsIgnoreCase(this.horn[i].getNamn())) {
                    h[i] = new Punkt(horn);
                    j--;
                }
                else {
                    h[i] = this.horn[j];
                }
            }
            else {
                h[i] = this.horn[j];
            }
        }
        this.horn = h;
    }
    
    //metod som tar bort en angiven punkt ifrån polylinjen
    public void taBort (String hornNamn) {
        Punkt[] h = new Punkt[this.horn.length - 1];
        for (int i = 0, j = 0; i <= h.length; i++, j++) {
            if(hornNamn.equalsIgnoreCase(this.horn[i].getNamn())) {
                j--;
            }
            else {
                h[j] = this.horn[i];
            }
        }
        this.horn = h;
    }

    public class PolylinjeIterator {

        private int aktuell = -1;
        
        public PolylinjeIterator () {
            if (Polylinje.this.horn.length > 0)
            aktuell = 0;
        }
        
        public boolean finnsHorn () {
            return aktuell != -1;
        }
        
        public Punkt horn () throws java.util.NoSuchElementException {
        if (!this.finnsHorn ())
            throw new java.util.NoSuchElementException ("slut av iterationen"); 
            
        Punkt horn = Polylinje.this.horn[aktuell];
        return horn;
        }
        
        public void gaFram () {
            if (aktuell >= 0 && aktuell < Polylinje.this.horn.length - 1)
                aktuell++;
            else
                aktuell = -1;
        }    
    }
}