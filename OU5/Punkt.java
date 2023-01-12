public class Punkt {


    //INSTANS VARIABLER
    int x;
    int y;
    String a;

    //KONSTRUKTORER
    //skapa en förvald punkt
    // referar till aktuellt objekt
    Punkt(String a, int x, int y) {
        
        this.a = a;
        this.x = x;
        this.y = y;
    }

    Punkt(Punkt p) {
        
        this.x = p.x;
        this.y = p.y;
        this.a = p.a;
    }

    //METODER

    //bestäm punktens strängrepresentation
    public String toString() {
        
        String s = "";

        s = "(" + a + " " + x + ", " + y + ")";

        return s;
    }

    public boolean equals(Punkt p) {
        
        return p.x == x && p.y == y;
    }

    //bestäm punktens avstånd till origo
    public double avstand() {
        double d = 0;
        d = Math.sqrt(this.x*this.x+this.y*this.y);

        return d;
    }

    //bestäm punktens avstånd till en given punkt
    public double avstand(Punkt p) {
        
        double d = 0;
        d = Math.sqrt((p.x - this.x)*(p.x-this.x) + (p.y-this.y)*(p.y-this.y));

        return d;
    }

    
    //metod som avläser punktens namn
    public String getNamn() {

        return a;
    }

    //metod som avläsers punkts x-koordinat
    public int getX() {
        
        return x;
    }
    //metod som avläsers punkts y-koordinat
    public int getY() {

        return y;
    }

    //metod som anger punktens x-koordinat
    public void setX(int x) {
        this.x = x;
    }

    //metod som anger punktens y-koordinat
    public void setY(int y) {
        this.y = y;
    }
}