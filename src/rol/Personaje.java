package rol;

import javax.swing.JOptionPane;

public class Personaje {
String nombre;
Caracteristicas caract;
Profesion profesion;
Raza raza;
boolean jugador;

//constructor jugador
public Personaje(String nombre, String razaCr, String profesion, boolean jugador) {
    this.nombre = nombre;
    this.caract = new Caracteristicas();
    this.raza = encontrarRaza(razaCr);
    this.profesion = seleccionarProfesion(profesion);
	this.jugador = jugador;
	
	if (this.raza == null) {
        throw new IllegalArgumentException("La raza no coincide con ninguna raza creada.");
    }
	switch (this.raza.getCaractBonif()) {
    case "Fue":
        this.caract.setFuerza(this.caract.getFuerza() + this.raza.getBonificador());
        break;
    case "Des":
    	this.caract.setDestreza(this.caract.getDestreza() + this.raza.getBonificador());
        break;
    case "Con":
    	this.caract.setConstitucion(this.caract.getConstitucion() + this.raza.getBonificador());
        break;
    case "Sab":
    	this.caract.setSabiduria(this.caract.getSabiduria() + this.raza.getBonificador());
        break;
    case "Int":
    	this.caract.setInteligencia(this.caract.getInteligencia() + this.raza.getBonificador());
        break;
    case "Car":
    	this.caract.setCarisma(this.caract.getCarisma() + this.raza.getBonificador());
        break;
	}
	
} //constructor no jugador
public Personaje(String nombre, String razaCr, String profesion) {
    this.nombre = nombre;
    this.caract = new Caracteristicas();
    this.raza = encontrarRaza(razaCr);
    this.profesion = seleccionarProfesion(profesion);
	this.jugador = false;
	//actualizar bono
	switch (this.raza.getCaractBonif()) {
    case "Fue":
        this.caract.setFuerza(this.caract.getFuerza() + this.raza.getBonificador());
        break;
    case "Des":
    	this.caract.setDestreza(this.caract.getDestreza() + this.raza.getBonificador());
        break;
    case "Con":
    	this.caract.setConstitucion(this.caract.getConstitucion() + this.raza.getBonificador());
        break;
    case "Sab":
    	this.caract.setSabiduria(this.caract.getSabiduria() + this.raza.getBonificador());
        break;
    case "Int":
    	this.caract.setInteligencia(this.caract.getInteligencia() + this.raza.getBonificador());
        break;
    case "Car":
    	this.caract.setCarisma(this.caract.getCarisma() + this.raza.getBonificador());
        break;
	}
}
//usar metodos de profesion
public void usarAtaque() {
    // Comprobar si la profesión es un guerrero
    if (profesion instanceof Guerrero) {
        ((Guerrero) profesion).AtaqueFisico();
    }
    // Comprobar si la profesión es un mago
    else if (profesion instanceof Mago) {
        ((Mago) profesion).AtaqueFisico();
    }
}
public void usarDefensa() {
    // Comprobar si la profesión es un guerrero
    if (profesion instanceof Guerrero) {

        ((Guerrero) profesion).DefensaFisico();
    }
    // Comprobar si la profesión es un mago
    else if (profesion instanceof Mago) {
        // Realizar acciones específicas del policía
        ((Mago) profesion).DefensaFisico();
    }
}
private Raza encontrarRaza(String nombreRaza) {
    for (Raza raza : GUI.razasCreadas) {
        if (raza.getNombre().equals(nombreRaza)) {
            return raza;
        }
    }
    return null; // Si no se encuentra la raza, devuelve null
}

private Profesion seleccionarProfesion(String nombreProfesion) {
    return nombreProfesion.equals("Mago") ? new Mago() : new Guerrero();
}

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public Caracteristicas getCaract() {
	return caract;
}
public void setCaract(Caracteristicas caract) {
	this.caract = caract;
}
public Profesion getProfesion() {
	return profesion;
}
public void setProfesion(Profesion profesion) {
	this.profesion = profesion;
}
public Raza getRaza() {
	return raza;
}
public void setRaza(Raza raza) {
	this.raza = raza;
}
public boolean isJugador() {
	return jugador;
}
public void setJugador(boolean jugador) {
	this.jugador = jugador;
}
}
