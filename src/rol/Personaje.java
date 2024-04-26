package rol;

public class Personaje {
String nombre;
Caracteristicas caract;
Profesion profesion;
Raza raza;
boolean jugador;

//constructor jugador
public Personaje(String nombre, Caracteristicas caract, Profesion profesion, Raza raza, boolean jugador) {
	super();
	this.nombre = nombre;
	this.caract = caract;
	this.profesion = profesion;
	this.raza = raza;
	this.jugador = jugador;
	
} //constructor no jugador
public Personaje(String nombre, Caracteristicas caract, Profesion profesion, Raza raza) {
	super();
	this.nombre = nombre;
	this.caract = caract;
	this.profesion = profesion;
	this.raza = raza;
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
