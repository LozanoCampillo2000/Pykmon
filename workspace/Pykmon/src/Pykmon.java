
public class Pykmon {
	private String nombre;
	private int vida;
	private int ataque;
	private int defensa;
	private int velocidad;
	private String tipo;
	
	public Pykmon(String nombre, int vida, int ataque, int defensa, int velocidad, String tipo) {
		this.nombre = nombre;
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.velocidad = velocidad;
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public int getVelocidad() {
		return velocidad;
	}

	public String getNombre() {
		return nombre;
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
	
	private int ataqueTipo(Pykmon pykmon) {
		if(tipo == "fuego") {
			if(pykmon.getTipo() == "agua") {
				ataque = -10;
			}
			if(pykmon.getTipo() == "planta") {
				ataque = 10;
			}
		}
		
		if(tipo == "agua") {
			if(pykmon.getTipo() == "planta") {
				ataque = -10;
			}
			if(pykmon.getTipo() == "fuego") {
				ataque = 10;
			}
		}
		
		else {
			if(pykmon.getTipo() == "fuego") {
				ataque = -10;
			}
			if(pykmon.getTipo() == "agua") {
				ataque = 10;
			}
		}
		
		return ataque;
	}
	
	public void atacar(Pykmon pykmon) {
		ataque = ataque + ataqueTipo(pykmon);
		int vida_pykmon = pykmon.getVida() - (ataque - pykmon.getDefensa());
		pykmon.setVida(vida_pykmon);
	}
	
	public int aumentarVida() {
		vida = vida + 20;
		return vida;
		
	}
	
	public int aumentarVelocidad() {
		velocidad = velocidad + 10;
		return velocidad;
	}
	
	public int aumentarDefensa() {
		defensa = defensa + 10;
		return defensa;
	}
	
	public void mostrarEstadistica() {
		System.out.println("Vida: " + vida);
		System.out.println("Ataque: " + ataque);
		System.out.println("Defensa: " + defensa);
		System.out.println("Velocidad: " + velocidad);
	}
}
