import model.Pokemon;
import model.tipos.Planta;
import model.tipos.Fuego;
import view.VentanaPrincipal;

import javax.swing.SwingUtilities;
import java.util.ArrayList;
import java.util.List;


public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();

            List<Pokemon> listaPokemon = new ArrayList<>();
            listaPokemon.add(new Planta(89,50,"Planta/ veneno","Fuego / volador/hielo/psiquica","Tras nacer, crece alimentándose durante un tiempo de los nutrientes que contiene el bulbo de su lomo.",
                    "Balbasaur",1,40,42,80,50,"Planta/ veneno","0,7","Semilla","6,9","Espesura","♀️/♂️",
                    "https://img.pokemondb.net/sprites/black-white/anim/normal/bulbasaur.gif"));
            listaPokemon.add(new Fuego("Charmander",4,3,4,3,4,"Fuego","0,6","Fuego", "8,5","Mar Llamas",
                    "La llama de su cola indica su fuerza vital. Si está débil, la llama arderá más tenue.","♀️/♂️","https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/004.png",4,3,"Fuego",
                    "Agua , Roca, Tierra"));
            listaPokemon.add(new Planta(89,50,"Planta/ veneno","Fuego / volador/hielo/psiquica","Tras nacer, crece alimentándose durante un tiempo de los nutrientes que contiene el bulbo de su lomo.",
                    "Balbasaur",1,40,42,80,50,"Planta/ veneno","0,7","Semilla","6,9","Espesura","♀️/♂️",
                    "C:\\Users\\CompuFire\\Desktop\\Proyecto Progra 2\\jframe_personajes\\out\\Imagenes\\Balbasaur.png"));
            listaPokemon.add(new Planta(89,50,"Planta/ veneno","Fuego / volador/hielo/psiquica","Tras nacer, crece alimentándose durante un tiempo de los nutrientes que contiene el bulbo de su lomo.",
                    "Balbasaur",1,40,42,80,50,"Planta/ veneno","0,7","Semilla","6,9","Espesura","♀️/♂️",
                    "https://img.pokemondb.net/sprites/black-white/anim/normal/bulbasaur.gif"));
            listaPokemon.add(new Fuego("Charmander",4,3,4,3,4,"Fuego","0,6","Fuego", "8,5","Mar Llamas",
                    "La llama de su cola indica su fuerza vital. Si está débil, la llama arderá más tenue.","♀️/♂️","https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/004.png",4,3,"Fuego",
                    "Agua , Roca, Tierra"));
            listaPokemon.add(new Fuego("Charmander",4,3,4,3,4,"Fuego","0,6","Fuego", "8,5","Mar Llamas",
                    "La llama de su cola indica su fuerza vital. Si está débil, la llama arderá más tenue.","♀️/♂️","https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/004.png",4,3,"Fuego",
                    "Agua , Roca, Tierra"));

            ventana.cargarPokemon(listaPokemon);
            ventana.setVisible(true);
        });
    }
}


