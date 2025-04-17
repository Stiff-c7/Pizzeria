package mundo;

import estructuras.Heap;
import java.util.Comparator;

public class Pizzeria {
    private Heap<Pedido> pedidosRecibidos;
    private Heap<Pedido> colaDespachos;

    public static final String RECIBIR_PEDIDO = "RECIBIR";
    public static final String ATENDER_PEDIDO = "ATENDER";
    public static final String DESPACHAR_PEDIDO = "DESPACHAR";

    public Pizzeria() {
        // Max-Heap para ordenar los pedidos por precio (de mayor a menor)
        pedidosRecibidos = new Heap<>(Comparator.comparing(Pedido::getPrecio)); // indica que es Max-Heap
        // Min-Heap para ordenar los pedidos por cercanía (de menor a mayor)
        colaDespachos = new Heap<>(Comparator.comparing(Pedido::getCercania).reversed()); // indica que es Min-Heap
    }

    // Método para agregar un nuevo pedido
    public void agregarPedido(String autorPedido, double precio, int cercania) {
        Pedido nuevoPedido = new Pedido(autorPedido, precio, cercania);
        pedidosRecibidos.insert(nuevoPedido); // Inserta el pedido en el heap de pedidos recibidos
    }

    // Método para atender un pedido, moviéndolo a la cola de despachos
    public Pedido atenderPedido() {
        Pedido pedido = pedidosRecibidos.remove(); // Elimina el pedido de la cola de recibidos
        if (pedido != null) {
            colaDespachos.insert(pedido); // Inserta el pedido en la cola de despachos
        }
        return pedido;
    }

    // Método para despachar un pedido
    public Pedido despacharPedido() {
        return colaDespachos.remove(); // Elimina y devuelve el pedido de la cola de despachos
    }

    // Devuelve una lista de pedidos recibidos
    public java.util.List<Pedido> pedidosRecibidosList() {
        return pedidosRecibidos.getList(); // Devuelve la lista de pedidos en el heap
    }

    // Devuelve una lista de pedidos en espera para despachar
    public java.util.List<Pedido> colaDespachosList() {
        return colaDespachos.getList(); // Devuelve la lista de pedidos en el heap
    }
}
