package view;

import model.Pokemon;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.function.Consumer;


public class TarjetaPokemon extends JPanel {

    public TarjetaPokemon(Pokemon pokemon, Consumer<Pokemon> alSeleccionar){
        setLayout(new BorderLayout(5, 5));
        setPreferredSize(new Dimension(200, 290));

        setBackground(new Color(245, 245, 245));
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(225, 225, 225), 1, true),
                new EmptyBorder(10, 10,10,10)
        ));

        setCursor((new Cursor(Cursor.HAND_CURSOR)));

        // crear imagen en el centro
        JLabel lblImgen = new JLabel("",SwingConstants.CENTER);
        lblImgen.setPreferredSize(new Dimension(180,180));

        Image img = cargarImagenUniversal(pokemon.getRutaImagen());
        if (img != null){
            Image imgEscalada = img.getScaledInstance(170,170, Image.SCALE_SMOOTH);
            lblImgen.setIcon(new ImageIcon(imgEscalada));
        }else {
            lblImgen.setText("Imagen no encontrada");
        }
        add(lblImgen, BorderLayout.CENTER);

        //Creamos los datos que va a tener cada pokemon
        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));
        panelInfo.setOpaque(false);


        JLabel lblNumero = new JLabel(String.format("Nº %04d",pokemon.getNumeroPokemon()));
        lblNumero.setFont(new Font("SansSerif", Font.BOLD, 11));
        lblNumero.setForeground(new Color(5, 5, 5));
        lblNumero.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblNombre = new JLabel(pokemon.getNombre());
        lblNombre.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblNombre.setForeground(Color.BLACK);
        lblNombre.setAlignmentX(Component.LEFT_ALIGNMENT);

        panelInfo.add(lblNumero);
        panelInfo.add(Box.createVerticalStrut(5));

        panelInfo.add(lblNombre);
        panelInfo.add(Box.createVerticalStrut(5));

        JPanel panelTipos = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 0));
        panelTipos.setOpaque(false);
        panelTipos.setAlignmentX(Component.LEFT_ALIGNMENT);

        //Creamos etiqueta para e tipo

        if (pokemon.getTipo() != null){
            String[] tipos = pokemon.getTipo().split("/");
            for (String t : tipos){
                panelTipos.add(crearBadgeTipos(t.trim()));
            }
        }
        panelInfo.add(panelTipos);
        add(panelInfo, BorderLayout.SOUTH);

        //hacer que funcione el clik
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                alSeleccionar.accept(pokemon);
            }
        });

    }
    private Image cargarImagenUniversal(String ruta) {
        if (ruta == null || ruta.trim().isEmpty()) {
            return null;
        }

        String rutaLimpia = ruta.trim();

        // Carga si es URL de Internet (HTTP / HTTPS)
        if (rutaLimpia.startsWith("http://") || rutaLimpia.startsWith("https://")) {
            try {
                return javax.imageio.ImageIO.read(new java.net.URL(rutaLimpia));
            } catch (Exception ignored) {}
        }

        //Carga por ClassLoader (Sin '/')
        String sinDiagonal = rutaLimpia.startsWith("/") ? rutaLimpia.substring(1) : rutaLimpia;
        URL res1 = getClass().getClassLoader().getResource(sinDiagonal);
        if (res1 != null) {
            return new ImageIcon(res1).getImage();
        }

        //Carga por Class Resource (Con '/')
        String conDiagonal = rutaLimpia.startsWith("/") ? rutaLimpia : "/" + rutaLimpia;
        URL res2 = getClass().getResource(conDiagonal);
        if (res2 != null) {
            return new ImageIcon(res2).getImage();
        }

        //Carga desde Disco Local (Ejemplo: C:/imagenes/foto.png)
        java.io.File archivoLocal = new java.io.File(rutaLimpia);
        if (archivoLocal.exists()) {
            return new ImageIcon(archivoLocal.getAbsolutePath()).getImage();
        }

        return null;
    }


    private JLabel crearBadgeTipos(String tipo){
        JLabel badge = new JLabel(tipo.toUpperCase());
        badge.setFont(new Font("SansSerif", Font.BOLD, 9));
        badge.setForeground(Color.WHITE);
        badge.setOpaque(true);
        badge.setBorder(new EmptyBorder(3, 8, 3, 8));

        //determinamos colores para cada tipo de Pokemon
        switch (tipo.toLowerCase()){
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