package mundo;

public class Pedido implements Comparable<Pedido> {
    private String autorPedido;
    private double precio;
    private int cercania;

    public Pedido(String autorPedido, double precio, int cercania) {
        this.autorPedido = autorPedido;
        this.precio = precio;
        this.cercania = cercania;
    }

    public String getAutorPedido() {
        return autorPedido;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCercania() {
        return cercania;
    }

    @Override
    public int compareTo(Pedido otro) { //ordenar por precio
        // Por defecto puedes comparar por precio.
        // Puedes cambiar esto según el heap (precio o cercanía)
        // Aquí devolvemos 0 porque el Heap ya se encarga con compare() dependiendo del booleano
        //return 0; // Esto es válido si Heap tiene lógica personalizada
        return Double.compare(this.precio, otro.precio);
    }
    public int compareToCercania(Pedido otro) { //ordenar por cercania
        return Double.compare(this.cercania, otro.cercania);
    }


    @Override
    public String toString() {
        return "Pedido{" +
                "autor='" + autorPedido + '\'' +
                ", precio=" + precio +
                ", cercania=" + cercania +
                '}';
    }
}
