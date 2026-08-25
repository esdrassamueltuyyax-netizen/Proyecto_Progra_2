package view;

import model.Pokemon;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class VentanaPrincipal extends JFrame {

    private CardLayout cardLayout;
    private JPanel PanelContenedor;
    private JPanel PanelGrid;
    private PanelDetallesPokemon panelDetalle;
    private JComboBox<String> comboFiltroTipo;
    private List<Pokemon> listaCompleta;

    public VentanaPrincipal(){
        super("Album Pokemon");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,750);
        setMinimumSize(new Dimension(950, 700));
        setLocationRelativeTo(null);


        inicializarComponentes();
    }

    private void inicializarComponentes(){
        setLayout(new BorderLayout());

        //Barra de tipos

        JPanel panelSuperior =
                new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        panelSuperior.setBackground(new Color(50, 47, 47, 71));

        JLabel lblFiltro = new JLabel("Filtar Por Tipos");
        lblFiltro.setFont(new Font("SansSerif", Font.BOLD, 13));

        String[] tipos = {
                "Todos", "Agua", "Bicho", "Dragon", "Elenctrico", "Fantasma", "Fuego",
                "Hielo", "Lucha", "Normal", "Planta", "Psiquico", "Roca", "Tierra",
                "Veneno", "Volador"
        };
        comboFiltroTipo = new JComboBox<>(tipos);
        comboFiltroTipo.addActionListener(e-> aplicarFiltro());
        panelSuperior.add(lblFiltro);
        panelSuperior.add(comboFiltroTipo);
        add(panelSuperior, BorderLayout.NORTH);

        //Principal
        cardLayout = new CardLayout();
        PanelContenedor = new JPanel(cardLayout);

        // Catalogos
        PanelGrid = new JPanel(new GridLayout(0, 4, 14,30));
        PanelGrid.setBackground(Color.WHITE);
        PanelGrid.setBorder(BorderFactory.createEmptyBorder(20,25,30,25));

        JScrollPane scrollPane = new JScrollPane(PanelGrid);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(16);

        //Detalles
        panelDetalle = new PanelDetallesPokemon(() -> cardLayout.show(PanelContenedor, "GRID"));

        PanelContenedor.add(scrollPane, "GRID");
        PanelContenedor.add(panelDetalle, "DETALLE");

        add(PanelContenedor, BorderLayout.CENTER);
    }


    // cargar los pokemosnes

    public void cargarPokemon (List<Pokemon> lista){
        this.listaCompleta = lista;
        aplicarFiltro();
    }

    private void aplicarFiltro(){
        if (listaCompleta == null) return;

        String seleccion = (String) comboFiltroTipo.getSelectedItem();
        List<Pokemon> filtrados;

        if ("Todos".equals(seleccion)){
            filtrados = listaCompleta;
        }else {
            filtrados = listaCompleta.stream()
                    .filter(p -> p.getClass().getSimpleName().equalsIgnoreCase(seleccion) ||
                            (p.getTipo() != null && p.getTipo().equalsIgnoreCase(seleccion)))
                    .collect(Collectors.toList());
        }
        renderizarGrid(filtrados);
    }

    private void renderizarGrid(List<Pokemon> pokemones){
        PanelGrid.removeAll();

        for (Pokemon p : pokemones){

            TarjetaPokemon tarjeta = new TarjetaPokemon(p, selec -> {

                 //aqui muestra los detalles del pokemon ejegido.
                panelDetalle.mostrarPokemon(selec);

                cardLayout.show(PanelContenedor, "DETALLE");
            });

            PanelGrid.add(tarjeta);
        }

        PanelGrid.revalidate();
        PanelGrid.repaint();
    }


}