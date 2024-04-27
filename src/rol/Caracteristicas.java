package rol;
import java.util.Arrays;
import java.util.Random;

public class Caracteristicas {
int fuerza;
int destreza;
int constitucion;
int inteligencia;
int sabiduria;
int carisma;
int vida;
int defensa;
//constructor
public Caracteristicas() {
	super();
	this.fuerza = generarCaracteristicas();
	this.destreza = generarCaracteristicas();
	this.constitucion = generarCaracteristicas();
	this.inteligencia = generarCaracteristicas();
	this.sabiduria = generarCaracteristicas();
	this.carisma = generarCaracteristicas();
	this.vida = 100;
	this.defensa = 5;
}
//metodo
public static int generarCaracteristicas()
{
	Random rand = new Random();
	int tirada1 = rand.nextInt(6) + 1;
	int tirada2 = rand.nextInt(6) + 1;
	int tirada3 = rand.nextInt(6) + 1;
	int tirada4 = rand.nextInt(6) + 1;
	// Almacenar numeros en un array
    int[] numeros = {tirada1, tirada2, tirada3, tirada4};

    // Ordenar el array de manera descendente
    Arrays.sort(numeros);
    // Revertir el array para tenerlos en orden descendente
    int[] numerosOrdenados = new int[numeros.length];
    for (int i = 0; i < numeros.length; i++) {
        numerosOrdenados[i] = numeros[numeros.length - 1 - i];
    }

    // Sumar los tres números más altos
    int suma = 0;
    for (int i = 0; i < 3; i++) {
        suma += numerosOrdenados[i];
    }
    return suma;
}
//getters and setters
public int getFuerza() {
	return fuerza;
}
public void setFuerza(int fuerza) {
	this.fuerza = fuerza;
}
public int getDestreza() {
	return destreza;
}
public void setDestreza(int destreza) {
	this.destreza = destreza;
}
public int getConstitucion() {
	return constitucion;
}
public void setConstitucion(int constitucion) {
	this.constitucion = constitucion;
}
public int getInteligencia() {
	return inteligencia;
}
public void setInteligencia(int inteligencia) {
	this.inteligencia = inteligencia;
}
public int getSabiduria() {
	return sabiduria;
}
public void setSabiduria(int sabiduria) {
	this.sabiduria = sabiduria;
}
public int getCarisma() {
	return carisma;
}
public void setCarisma(int carisma) {
	this.carisma = carisma;
}
public int getVida() {
	return vida;
}
public void setVida(int vida) {
	this.vida = vida;
}
public int getDefensa() {
	return defensa;
}
public void setDefensa(int defensa) {
	this.defensa = defensa;
}
//to string
@Override
public String toString() {
	return "Caracteristicas [fuerza=" + fuerza + ", destreza=" + destreza + ", constitucion=" + constitucion
			+ ", inteligencia=" + inteligencia + ", sabiduria=" + sabiduria + ", carisma=" + carisma + ", vida=" + vida
			+ ", defensa=" + defensa + "]";
}


}
