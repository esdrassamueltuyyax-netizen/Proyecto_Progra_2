package model;

public abstract class Pokemon {

    String nombre;
    int numeroPokemon;
    int ps;
    int ataque;
    int defensa;
    int velocidad;
    int ataqueEspecial;
    int defensaEspecial;
    String tipo;
    String debilidades;
    String descripcion;
    String altura;
    String categoria;
    String peso;
    String habilidad;
    String genero;
    String rutaImagen;


    public Pokemon(String nombre, int numeroPokemon, int ps, int ataque, int defensa, int ataqueEspecial, int defensaEspecial,
        int velocidad, String tipo,String debilidades, String descripcion, String altura, String categoria, String peso, String habilidad,
        String genero, String rutaImagen) {
        this.nombre = nombre;
        this.numeroPokemon = numeroPokemon;
        this.ps = ps;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.ataqueEspecial = ataqueEspecial;
        this.defensaEspecial = defensaEspecial;
        this.tipo = tipo;
        this.debilidades = debilidades;
        this.descripcion = descripcion;
        this.altura = altura;
        this.categoria = categoria;
        this.peso = peso;
        this.habilidad = habilidad;
        this.genero = genero;
        this.rutaImagen = rutaImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroPokemon() {
        return numeroPokemon;
    }

    public int getPs() {
        return ps;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getAtaqueEspecial(){return  ataqueEspecial;}

    public int getDefensaEspecial(){return defensaEspecial;}

    public String getTipo() {
        return tipo;
    }

    public String getDebilidades(){return debilidades;}

    public String getDescripcion(){return descripcion;}

    public String getAltura() {
        return altura;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getPeso() {
        return peso;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public String getGenero() {
        return genero;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }
    
    public abstract String verHabilidad();

    public String mostrarFicha(){
        return String.format(
            "%s [%s] - Puntos de Salud: %d | Daño: %d",
            nombre, categoria, ps, ataque
        );
    }


}