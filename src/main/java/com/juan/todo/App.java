package com.juan.todo;

import java.lang.annotation.ElementType;
import java.util.HashMap;
import java.util.Scanner;

public class App {

	public static Categoria menuCategoria(Scanner sc) {
		System.out.println("1 - Pendiente");
		System.out.println("2 - Realizar cuando pueda");
		System.out.println("3 - Realizar lo antes posible");
		System.out.println("4 - Urgente");
		System.out.println("Op: ");
		int op = sc.nextInt();
		switch (op) {
		case 1: return Categoria.PENDIENTE;
		case 2: return Categoria.REALIZAR_CUANDO_PUEDA;
		case 3: return Categoria.REALIZAR_LO_ANTES_POSIBLE;
		case 4: return Categoria.REALIZAR_URGENTE;
		default:
			System.out.println("VALOR NO VALIDO");
			return null;
		}
	}
	
	public static void main(String[] args) {
		Tarea tareas_pendientes = new Tarea(new HashMap<String, Categoria>());
		Tarea tareas_realizadas = new Tarea(new HashMap<String, Categoria>());
		Scanner sc = new Scanner(System.in);
		Usuario yo = new Usuario("Juan", "Olivera" , tareas_pendientes);
		
		while (true) {
			System.out.println("---------Menu---------");
			System.out.println("1 - Agregar tarea.");
			System.out.println("2 - Actualizar tarea.");
			System.out.println("3 - Eliminar tarea.");
			System.out.println("4 - Marcar tarea como completada.");
			System.out.println("5 - Ver tareas por categoria");
			System.out.println("6 - Salir");
			System.out.print("Op: ");
			int op=sc.nextInt();
			
			switch (op) {
			case 1:
				System.out.print("Ingrese su tarea: ");
				String tt = sc.nextLine().trim();
				if(tt.isEmpty()) {
					System.out.println("Accion cancelada");
					break;
				}else {
					Categoria cat = null;
					do {
						cat=menuCategoria(sc);
					} while (cat!=null);
					tareas_pendientes.CargarTareas(tt, cat);
				}
				break;

			default:
				break;
			}
			
		}
		
	}
	
}
