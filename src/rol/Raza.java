package rol;

public class Raza {
String nombre;
String caractBonif; //Fue,Des,Con,Sab,Int,Car
int bonificador; //1-3
//Constuctor
public Raza(String nombre, String caractBonif, int bonificador) {
	super();
	this.nombre = nombre;
	this.caractBonif = caractBonif;
	this.bonificador = bonificador;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getCaractBonif() {
	return caractBonif;
}
public void setCaractBonif(String caractBonif) {
	this.caractBonif = caractBonif;
}
public int getBonificador() {
	return bonificador;
}
public void setBonificador(int bonificador) {
	this.bonificador = bonificador;
}

}
