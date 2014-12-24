import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Pykmon pykmon_usuario = new Pykmon("Charmandyr", 500, 22, 8, 20, "fuego");
		Pykmon pykmon_ia = new Pykmon("Sqyrtle", 550, 16, 10, 12, "planta");
		combatePykmon(pykmon_usuario, pykmon_ia);
	}
	
	public static void estrategiaIA(Pykmon pykmon_usuario, Pykmon pykmon_ia) {
		if(pykmon_ia.getVida() < 100) {
			pykmon_ia.aumentarVida();
		}
		else if(pykmon_ia.getDefensa() < pykmon_usuario.getDefensa()) {
			pykmon_ia.aumentarDefensa();
		}
		else if(pykmon_ia.getVelocidad() < pykmon_usuario.getVelocidad()) {
			pykmon_ia.aumentarVelocidad();
		}
		else {
			pykmon_ia.atacar(pykmon_usuario);
		}
	}
	
	public static void combatePykmon(Pykmon pykmon_usuario, Pykmon pykmon_ia) {
		int turno;
		Scanner scanner = new Scanner(System.in);

		if(pykmon_usuario.getVelocidad() > pykmon_ia.getVelocidad()) {
			turno = 1;
		}
		else {
			turno = 2;
		}
		
		while(pykmon_usuario.getVida() > 0 && pykmon_ia.getVida() > 0) {
			System.out.println("Vida de Charmandyr: " + pykmon_usuario.getVida());
			System.out.println("Vida de Sqyrtle: " + pykmon_ia.getVida());
			System.out.println();
			
			if(turno == 1) {
				int eleccion;
			
				do {
					System.out.println("Acciones: ");
					System.out.println("1. Atacar");
					System.out.println("2. Aumentar vida");
					System.out.println("3. Aumentar defensa");
					System.out.println("4. Aumentar velocidad");
					System.out.println("5. Mostrar estadisticas");
					System.out.println("Introduzca la accion deseada: ");
					eleccion = scanner.nextInt();
					
					if(eleccion == 1) {
						pykmon_usuario.atacar(pykmon_ia);
					}
					else if(eleccion == 2) {
						pykmon_usuario.aumentarVida();
					}
					else if(eleccion == 3) {
						pykmon_usuario.aumentarDefensa();
					}
					else if(eleccion == 4){
						pykmon_usuario.aumentarVelocidad();
					}
					else if(eleccion == 5) {
						System.out.println();
						pykmon_usuario.mostrarEstadistica();
					}
					else {
						System.out.println("Introduce una accion correcta");
						System.out.println();
					}
				} while(eleccion > 5 || eleccion < 0);
				
				System.out.println();
				turno = 2;
			}
			else {
				System.out.println("Turno de Sqyrtle");
				System.out.println();
				estrategiaIA(pykmon_usuario, pykmon_ia);
				turno = 1;
			}
		}
	}
}
