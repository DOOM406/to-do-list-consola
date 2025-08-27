package com.juan.todo;

import java.util.ArrayList;
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
		for(String i : tareas.keySet()) {
			System.out.println("Tarea: "+i+"- Categoria: "+tareas.get(i).getPrioridad());
		}
			
	}
	
	public boolean ComprobarTareas() {
		return tareas.isEmpty();
	}
	
}
