package com.juan.todo;

import java.awt.Component.BaselineResizeBehavior;
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
		sc.nextLine();
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
	
	public static void cargarDatos(Scanner sc, Tarea tareas) {
		String tt=null;
		System.out.print("Ingrese su tarea: ");
		//sc.nextLine();
		tt = sc.nextLine().trim();
		if(tt.isEmpty()) {
			System.out.println("Accion cancelada");
			return;
		}else {
			Categoria cat = null;
			do {
				cat=menuCategoria(sc);
			} while (cat==null);
			tareas.CargarTareas(tt, cat);
			
		}
	}
	
	public static void main(String[] args) {
		Tarea tareas_pendientes = new Tarea(new HashMap<String, Categoria>());
		Tarea tareas_realizadas = new Tarea(new HashMap<String, Categoria>());
		Scanner sc = new Scanner(System.in);
		Usuario yo = new Usuario("Juan", "Olivera" , tareas_pendientes);
		String tt;
		//sc.nextLine();
		while (true) {
			System.out.println("---------Menu---------");
			System.out.println("1 - Agregar tarea.");
			System.out.println("2 - Actualizar tarea.");
			System.out.println("3 - Eliminar tarea.");
			System.out.println("4 - Marcar tarea como completada.");
			System.out.println("5 - Ver tareas por categoria");
			System.out.println("6 - Ver tareas pendientes");
			System.out.println("7 - Ver tareas realizadas");
			System.out.println("8 - Salir");
			System.out.print("Op: ");
			int op=sc.nextInt();
			if(op==8) break;
			switch (op) {
			case 1:
				sc.nextLine();
				cargarDatos(sc, tareas_pendientes);
				System.out.println("Tarea cargada!.");
				break;
			case 2:
				tareas_pendientes.MostrarTareas();
				System.out.print("Ingrese su tarea a reemplazar: ");
				sc.nextLine();
				tt = sc.nextLine().trim();
				if(tt.isEmpty()) {
					System.out.println("Accion cancelada");
					break;
				}else {
					tareas_pendientes.eliminarTarea(tt);
					System.out.println("Agregue la nueva tarea.");
					
					cargarDatos(sc, tareas_pendientes);
					System.out.println("Tarea actualizada!.");
				}
				break;
			case 3:
				tareas_pendientes.MostrarTareas();
				System.out.print("Ingrese su tarea a eliminar: ");
				sc.nextLine();
				tt = sc.nextLine().trim();
				if(tt.isEmpty()) {
					System.out.println("Accion cancelada");
					break;
				}else {
					tareas_pendientes.eliminarTarea(tt);
					System.out.println("Tarea eliminada con exito");
				}
				break;
			case 4:
				tareas_pendientes.MostrarTareas();
				System.out.print("Ingrese su tarea completada: ");
				sc.nextLine();
				tt = sc.nextLine().trim();
				if(tt.isEmpty()) {
					System.out.println("Accion cancelada");
					break;
				}else {
					String tmp = tareas_pendientes.getTarea(tt);
					do {
						tmp=tareas_pendientes.getTarea(tt);
					} while (tmp==null);
					tareas_pendientes.eliminarTarea(tt);
					tareas_realizadas.CargarTareas(tt, Categoria.REALIZADA);
					System.out.println("Tarea realizada con exito");
				}
				break;
			case 5:
				Categoria m =null;
				System.out.println("Ingrese la categoria que quieres mostras.");
				do {
					m=menuCategoria(sc);
				} while (m==null);
				tareas_pendientes.mostrarPorCategorias(m);
				break;
			case 6:
				yo.mostrar_mis_tareas();
				break;
			case 7:
				tareas_realizadas.mostrarTareasRealizadas();
				break;
			default:
				System.out.println("No se reconoce el valor. Intente nuevamente");
				break;
			}
			
		}
		
	}
	
}
