package view;

import model.Pokemon;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.net.URL;


public class PanelDetallesPokemon extends JPanel {

  private JLabel lblTitulo;
  private JLabel lblImagen;
  private JTextArea txtDescripcion;

  private JPanel panelTipos;
  private JPanel panelDebilidades;
  private JPanel panelStats;
  private JPanel panelAtributos;

    public PanelDetallesPokemon( Runnable alVolver){
        setLayout(new BorderLayout(15,15));
        setBackground(new Color(240,242,245));
        setBorder(new EmptyBorder(15, 20,20,20));

        //musetra el encabezado
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setOpaque(false);

        JButton btnVolver = new JButton("<- Volver Al Album");
        btnVolver.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnVolver.setBackground(new Color(40,45,50));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFocusPainted(false);
        btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnVolver.addActionListener(e -> alVolver.run());

        panelSuperior.add(btnVolver,BorderLayout.WEST);


        lblTitulo = new JLabel("Selecciona un pokemon ", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD,28));
        lblTitulo.setForeground(new Color(30,30,30));

        panelSuperior.add(lblTitulo, BorderLayout.CENTER);
        add(panelSuperior,BorderLayout.NORTH);


        //Tarjeta Principal
        JPanel tarjetaPrincipal = new JPanel(new GridBagLayout());
        tarjetaPrincipal.setBackground(Color.WHITE);
        tarjetaPrincipal.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 205,210)),
                new EmptyBorder(20,20,20,20)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(0,10,0,10);


        //lado izquiero
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
        panelIzquierdo.setOpaque(false);

        //imagen
        JPanel cajaImagen= new JPanel(new GridBagLayout());
        cajaImagen.setBackground(new Color(245,245,245));
        cajaImagen.setBorder(BorderFactory.createLineBorder(new Color(230,230,230)));
        cajaImagen.setPreferredSize(new Dimension(250,220));


        lblImagen = new JLabel("Imagen no encontrada",SwingConstants.CENTER);
        lblImagen.setFont(new Font("SansSerif",Font.BOLD, 13));
        cajaImagen.add(lblImagen);

        panelIzquierdo.add(cajaImagen);
        panelIzquierdo.add(Box.createVerticalStrut(15));


        // Mostrar las estadisticas
        JLabel lblStatsTitulo = new JLabel("Estadisticas");
        lblStatsTitulo.setFont(new Font("SansSerif",Font.BOLD, 16));
        lblStatsTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        panelIzquierdo.add(lblStatsTitulo);
        panelIzquierdo.add(Box.createVerticalStrut(8));

        panelStats = new JPanel(new GridLayout(6,2,5,5));
        panelStats.setBackground(new Color(245,245,245));
        panelStats.setBorder(new EmptyBorder(10,10,10,10));
        panelIzquierdo.add(panelStats);


        //parte derecho del panel en donde estan los tipos, la descripccion y las debilidades
        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));
        panelDerecho.setOpaque(false);


        //descripcion
        JLabel lblDescripcion= new JLabel("Descripcion");
        lblDescripcion.setFont(new Font("SansSerif", Font.BOLD,16));
        panelDerecho.add(lblDescripcion);
        panelDerecho.add(Box.createVerticalStrut(8));

        txtDescripcion = new JTextArea("Sin Descripcion");
        txtDescripcion.setFont(new Font("SansSerif", Font.PLAIN, 13));
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        txtDescripcion.setEditable(false);
        txtDescripcion.setOpaque(false);

        panelDerecho.add(txtDescripcion);
        panelDerecho.add(Box.createVerticalStrut(15));

        // informacion
        JLabel lblInformacion = new JLabel("Informacion");
        lblInformacion.setFont(new Font("SansSerif", Font.BOLD, 16));
        panelDerecho.add(lblInformacion);
        panelDerecho.add(Box.createVerticalStrut(8));

        panelAtributos= new JPanel(new GridLayout(3, 2, 20,12));
        panelAtributos.setBackground(new Color(52,166,211));
        panelAtributos.setBorder(new EmptyBorder( 15,18,15,18));
        panelDerecho.add(panelAtributos);
        panelDerecho.add(Box.createVerticalStrut(15));


        //Muestra los Tipos

        JLabel lblTipo = new JLabel("Tipo");
        lblTipo.setFont(new Font("SansSerif", Font.BOLD, 16));
        panelDerecho.add(lblTipo);
        panelDerecho.add(Box.createVerticalStrut(5));

        panelTipos = new JPanel (new FlowLayout(FlowLayout.LEFT,8,3));
        panelTipos.setOpaque(false);
        panelDerecho.add(panelTipos);
        panelDerecho.add(Box.createVerticalStrut(12));


        //Debilidades

        JLabel lblDebilidad = new JLabel("Debilidades");
        lblDebilidad.setFont(new Font("SansSerif", Font.BOLD,16));
        panelDerecho.add(lblDebilidad);
        panelDerecho.add(Box.createVerticalStrut(8));

        panelDebilidades = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 3));
        panelDebilidades.setOpaque(false);
        panelDerecho.add(panelDebilidades);

        // Coloca las dos columnas
        gbc.gridx = 0;
        gbc.weightx= 0.45;
        tarjetaPrincipal.add(panelIzquierdo, gbc);

        gbc.gridx= 1;
        gbc.weightx= 0.55;
        tarjetaPrincipal.add(panelDerecho, gbc);

        add(tarjetaPrincipal, BorderLayout.CENTER);

    }
    public void mostrarPokemon(Pokemon p){

          // para mostrar el nombre del pokemon
        lblTitulo.setText(String.format("%s Nº %04d", p.getNombre(),p.getNumeroPokemon(),p.getRutaImagen()));

        // para mostrar la imagen
        lblImagen.setIcon(null);
        lblImagen.setText("Imagen no encontrada");

        SwingUtilities.invokeLater(() ->{
            Image img = cargarImagenUniversal(p.getRutaImagen());
            if (img != null){
                lblImagen.setIcon(new ImageIcon(img.getScaledInstance(200,200, Image.SCALE_SMOOTH)));
                lblImagen.setText("");
             }else {
                lblImagen.setText("Imagen no encontrada");
            }
        });

        // Muestra las descripcion de cada pokemon
        String Descripcion = p.getDescripcion();
        if(Descripcion == null || Descripcion.isEmpty()){

            Descripcion = "Sin Descripcion.";
        }
        txtDescripcion.setText(Descripcion);

        //Mustre la Informacion

        panelAtributos.removeAll();
        agregarAtributo(panelAtributos, "Altura", p.getAltura() + "M");
        agregarAtributo(panelAtributos, "Categoria", p.getCategoria());
        agregarAtributo(panelAtributos, "Peso", p.getPeso() + "Kg");
        agregarAtributo(panelAtributos, "Habilidad", p.getHabilidad());
        agregarAtributo(panelAtributos, "Genero", p.getGenero() );

        // Muestra que tipo de pokemon es
        panelTipos.removeAll();
        if (p.getTipo() != null && !p.getTipo().isEmpty()){
            for (String tipo : p.getTipo().split("/")){
                panelTipos.add(createBadge(tipo.trim()));
            }
        }

        //Muestra Cuales Son sus Debilidades
        panelDebilidades.removeAll();
        if (p.getDebilidades() != null && !p.getDebilidades().isEmpty()){
            for (String debilidad : p.getDebilidades().split(",")){
                for (String d : debilidad.trim().split("/")){
                    panelDebilidades.add(createBadge(d.trim()));
                }
            }
        }

        //Muestra las estadisticasd del pokemon
        panelStats.removeAll();
        agregarStatBarra(panelStats, "PS", p.getPs(), new Color(120,200,80));
        agregarStatBarra(panelStats, "Ataque", p.getAtaque(), new Color(240,200,50));
        agregarStatBarra(panelStats, "Defensa", p.getDefensa(), new Color(240,130,48));
        agregarStatBarra(panelStats, "Ataque Especial", p.getAtaqueEspecial(), new Color(80,180,230));
        agregarStatBarra(panelStats, "Defensa Especial", p.getDefensaEspecial(), new Color(80,120,230));
        agregarStatBarra(panelStats, "Velocidad", p.getVelocidad(), new Color(180,100,230));


        //Para Actualizar la pantalla

        revalidate();
        repaint();

    }
    // Cargamos las imagenes de pada pokemon por URL
    private Image cargarImagenUniversal(String ruta) {
        if (ruta == null || ruta.trim().isEmpty()) {
            return null;
        }
        String rutaLimpia = ruta.trim();

        // Carga desde Internet (URLs HTTP/HTTPS)
        if (rutaLimpia.startsWith("http://") || rutaLimpia.startsWith("https://")) {
            try {
                return javax.imageio.ImageIO.read(new java.net.URL(rutaLimpia));
            } catch (Exception ignored) {}
        }

        //  Carga usando ClassLoader (sin la barra '/')
        String rutaSinDiagonal = rutaLimpia.startsWith("/") ? rutaLimpia.substring(1) : rutaLimpia;
        URL resourceUrl1 = getClass().getClassLoader().getResource(rutaSinDiagonal);
        if (resourceUrl1 != null) {
            return new ImageIcon(resourceUrl1).getImage();
        }

        // Carga usando Class Resource (con la barra '/')
        String rutaConDiagonal = rutaLimpia.startsWith("/") ? rutaLimpia : "/" + rutaLimpia;
        URL resourceUrl2 = PanelDetallesPokemon.class.getResource(rutaConDiagonal);
        if (resourceUrl2 != null) {
            return new ImageIcon(resourceUrl2).getImage();
        }

        //  Carga desde el disco local / sistema de archivos
        java.io.File archivoLocal = new java.io.File(rutaLimpia);
        if (archivoLocal.exists()) {
            return new ImageIcon(archivoLocal.getAbsolutePath()).getImage();
        }

        // Si todos fallan no aparecen las imagenes
        return null;
    }

    // mustra la barra de estadistica de cada pokemon
    private void agregarStatBarra(JPanel container, String nombre, int valor, Color colorBarra){
        JLabel lbl = new JLabel(nombre);
        lbl.setFont(new Font("SansSerif", Font.PLAIN, 10));

        JProgressBar barra = new JProgressBar(0,150);
        barra.setValue(valor);
        barra.setForeground(colorBarra);
        barra.setString(String.valueOf(valor));
        barra.setStringPainted(true);
        barra.setBorderPainted(false);

        container.add(lbl);
        container.add(barra);
    }


    //mustra los atributos
    private void agregarAtributo (JPanel container, String titulo, String valor){
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.setOpaque(false);

        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(new Font("SansSerif", Font.PLAIN, 11));
        lblTitulo.setForeground(new Color(220, 240, 255));

        JLabel lblValor = new JLabel(valor);
        lblValor.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblValor.setForeground(Color.BLACK);

        panel.add(lblTitulo);
        panel.add(lblValor);
        container.add(panel);
    }

    //opcion que muestra los tipos (BADGE)
    private JLabel createBadge(String texto){
        JLabel badge = new JLabel(texto.toUpperCase(), SwingConstants.CENTER);
        badge.setFont(new Font("SansSerif", Font.BOLD, 11));
        badge.setForeground(Color.WHITE);
        badge.setOpaque(true);
        badge.setBorder(new EmptyBorder(5,12,5,12));

        switch (texto.toLowerCase()){
            case "planta": badge.setBackground(new Color(120,200,80)); break;
            case "agua": badge.setBackground(new Color(104,144,240));break;
            case "bicho": badge.setBackground(new Color(168,184,32));break;
            case "dragon": badge.setBackground(new Color(255, 42, 42));break;
            case "electrico": badge.setBackground(new Color(194, 241, 244));break;
            case "fantasma": badge.setBackground(new Color(255, 255, 255));break;
            case "fuego": badge.setBackground(new Color(240, 128, 48));break;
            case "hielo": badge.setBackground(new Color(106, 232, 239));break;
            case "lucha": badge.setBackground(new Color(138, 42, 37));break;
            case "normal": badge.setBackground(new Color(168, 168, 120));break;
            case "psiquico": badge.setBackground(new Color(131, 81, 175));break;
            case "roca": badge.setBackground(new Color(74, 47, 7));break;
            case "tierra": badge.setBackground(new Color(46, 21, 20));break;
            case "veneno": badge.setBackground(new Color(160, 64, 160));break;
            case "volador": badge.setBackground(new Color(168, 144, 240));break;
        }
        return badge;
    }
 }
