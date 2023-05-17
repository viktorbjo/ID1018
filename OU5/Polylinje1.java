public class Polylinje1 {

    private Punkt[] horn;
    private String farg = "svart";
    private int bredd = 1;
    
    
	//Skapar en tom Polylinje
    public Polylinje1() { 
        
        this.horn = new Punkt[0]; 
    }
    
	//Skapar en ny Polylinje utifrån en Vektor av punkter
    public Polylinje1(Punkt[] horn) {
    
        this.horn = new Punkt[horn.length];
        for (int i = 0; i < horn.length; i++) 
            this.horn[i] = new Punkt(horn[i]);
    }
    
    //Printar Polylinjens detaljer
    public String toString1() {
        String punkter = "{";
        for (int i = 0; i < horn.length; i++) {
            punkter = punkter + ( "{" + horn[i].getNamn() + " " + horn[i].getX() + " " + horn[i].getY() + "}");
        }
        return punkter + "}";
    }
    
    //metod som avläser polylinjernas namn, färg och bredd

        //Returerar hörnen
        public Punkt[] getHorn1 () {
            return this.horn;
        }
        
        
        //Returerar färgen
        public String getFarg1 () {
            return this.farg;
        }
        
        //Returerar bredden
        public int getBredd1 () {
            return this.bredd;
        }


    //metoder som bestämmer polylinjernas färg och bredd
    public void setFarg1(String farg) { this.farg = farg; }

    public void setBredd1(int bredd) { this.bredd = bredd; }
    

    //Returerar längden av polylinjen
    public double langd1() {
        double totalLangd = 0;
        for (int i = 0; i < this.horn.length - 1; i++) {
            totalLangd += this.horn[i].avstand(this.horn[i + 1]);
        }
        return totalLangd;
    }

    
	//Lägger till ett hörn i slutet
    public void laggTill1(Punkt horn) {

        Punkt[] h = new Punkt[this.horn.length + 1];
        for(int i = 0; i < this.horn.length; i++) {
            h[i] = this.horn[i];
        }
        h[this.horn.length] = horn;
        this.horn = h;
        
    }
    
    //en metod som lägger till en punkt i polylinjen framför en angiven punkt.
    public void laggTillFramfor1 (Punkt horn, String hornNamn) {
        Punkt[] h = new Punkt[this.horn.length + 1];
        for(int i = 0, j = 0; i < h.length; i++, j++) {
            if(i < this.horn.length) {
                if(hornNamn.equalsIgnoreCase(this.horn[i].getNamn())) {
                    h[i] = horn;
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
    public void taBort1 (String hornNamn) {
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
}