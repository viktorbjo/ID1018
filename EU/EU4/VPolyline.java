import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("Duplicates")
public class VPolyline implements Polyline {
    private Point[] vertices;
    private String colour = "black";
    private int width = 1;

    public VPolyline() {
        this.vertices = new Point[0];
    }

    public VPolyline(Point[] vertices) {
        this.vertices = new Point[vertices.length];
        for (int i = 0; i < vertices.length; i++) {
            this.vertices[i] = new Point(vertices[i]);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Point point: this){
            sb.append("(" + point.getName() + " , " + point.getX() + " , " + point.getY() + ")");
        }
        sb.append("," + this.getWidth() + " , " + this.getColour() + " | length: " + this.length());
        return sb.toString();
    }

    public Point[] getVertices() { // Unsure about this.
        Point[] gvertices = new Point[vertices.length];
        for (int i = 0; i < this.vertices.length; i++) {
            gvertices[i] = new Point(vertices[i]);
        }
        return gvertices;
    }

    public String getColour() {
        return colour;
    }

    public int getWidth() {
        return width;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double length() {
        double length = 0;
        for (int i = 0; i < vertices.length - 1; i++) {
            length += vertices[i].distance(vertices[i + 1]);
        }
        return length;
    }

    public void add(Point vertex) {
        Point[] h = new Point[this.vertices.length + 1];
        int i = 0;
        for (i = 0; i < this.vertices.length; i++) {
            h[i] = this.vertices[i];
        }
        h[i] = new Point(vertex);
        this.vertices = h;
    }

    public void insertBefore(Point vertex, String vertexName) {
        Point refvertex = new Point(vertex); // copying in order for code to use a reference to parameter instead of parameter itself
        Point[] newArray = new Point[vertices.length + 1]; // new array one slot larger
        int current = 0;
        for (int i = 0; i < this.vertices.length; i++) {
            if (this.vertices[i].getName().equals(vertexName)) {
                current = i; //Find position of where the new point should be added
                break;
            }
        }
        newArray[current] = refvertex; //set the point at position current to new vertex provided
        for (int i = 0; i < newArray.length - 1; i++) {
            newArray[i < current ? i : i + 1] = this.vertices[i]; // This skips the position current with the selector.

        }
        this.vertices = newArray; // creates new reference to the array with the vertex added.
    }

    public void remove(String vertexName) {
        Point[] newArray = new Point[vertices.length - 1];
        int current = 0;
        for (int i = 0; i < this.vertices.length; i++) {
            if (this.vertices[i].getName().equals(vertexName)) {
                current = i;
                break;
            }
        }
        for (int i = 0; i < current; i++) { // copies values of this.vertices up to but not including the removed index 'current'
            newArray[i] = this.vertices[i];
        }
        for (int i = current; i < newArray.length; i++) { // continues copying values until end of array length but values jump over removed index
            newArray[i] = this.vertices[i + 1];
        }

        this.vertices = newArray; // creates new reference to the array with the vertex removed.
    }
    public Iterator <Point> iterator(){
        return new Iterator<Point>() {
            int pos = 0;

            public boolean hasNext() {
                return vertices != null && pos < vertices.length;
            }
            public Point next() {
                if (hasNext()){
                    Point current = vertices[pos];
                    pos++;
                    return current;
                }
                throw new NoSuchElementException("Exhausted Vertices");
            }
        };
    }
}