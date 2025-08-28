package com.juan.todo;

import java.util.HashMap;

public class Tarea {
	
	
	private HashMap<String, Categoria> tareas;
	
	
	public Tarea(HashMap<String, Categoria> tareas) {
		
		this.tareas = tareas;
		
	}
	
	public void CargarTareas(String t, Categoria cat) {
		tareas.put(t, cat);
	}
	
	public void MostrarTareas() {
		if(tareas.isEmpty()) {System.out.println("No hay tareas pendientes"); return;}
		for(String i : tareas.keySet()) {
			System.out.println("Tarea: "+i+"- Categoria: "+tareas.get(i).name());
		}
			
	}
	public void mostrarTareasRealizadas() {
		if(tareas.isEmpty()) {System.out.println("No hay tareas realizadas"); return;}
		for(String i : tareas.keySet()) {
			System.out.println("Tarea: "+i+"- Categoria: "+tareas.get(i).name());
		}
	}
	public boolean ComprobarTareas() {
		return tareas.isEmpty();
	}
	
	public void eliminarTarea(String t) {
		tareas.remove(t);
	}
	
	public String getTarea(String buscada) {
		for(String i : tareas.keySet()) {
			if(i.equals(buscada)) {
				return i;
			}
		}
		return null;
	}
	
	public Categoria getCategoira(Categoria buscada) {
		for(String i : tareas.keySet()) {
			if(tareas.get(i)==buscada) {
				return tareas.get(i);
			}
		}
		return null;
	}
	
	public void mostrarPorCategorias(Categoria buscada) {
		if(tareas.isEmpty()) {System.out.println("No hay tareas pendientes"); return;}
		boolean b = false;
		for(String i : tareas.keySet()) {
			if(tareas.get(i)==buscada) {
				System.out.println("Tarea: "+i+"- Categoria: "+tareas.get(i).name());
				b=true;
			}
		}
		if(b==false) System.out.println("No hay tareas de la categoria: "+buscada.name());
		
	}
}
