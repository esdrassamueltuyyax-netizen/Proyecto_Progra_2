package model.tipos;

import model.Pokemon;

public class Fantasma extends Pokemon {

    int ataqueEspecial;
    int defensaEspecial;
    String elemento;
    String debilidad;

    public Fantasma(int ataqueEspecial, int defensaEspecial, String elemento,String descripcion, String debilidad, String nombre, int numeroPokemon, int ps, int ataque, int defensa, int velocidad, String tipo, String altura, String categoria, String peso, String habilidad, String genero, String rutaImagen) {
        super(nombre, numeroPokemon, ps, ataque, defensa, velocidad,ataqueEspecial, defensaEspecial, tipo,debilidad, descripcion, altura, categoria, peso, habilidad, genero, rutaImagen);
        this.ataqueEspecial = ataqueEspecial;
        this.defensaEspecial = defensaEspecial;
        this.elemento = elemento;
        this.debilidad = debilidad;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public int getDefensaEspecial() {
        return defensaEspecial;
    }

    public String getElemento() {
        return elemento;
    }

    public String getDebilidad() {
        return debilidad;
    }

    @Override
    public String mostrarFicha() {
        return super.mostrarFicha();
    }

    @Override
    public String verHabilidad() {
        return getNombre() + " tiene la habilidad: " + getHabilidad();
    }

}
