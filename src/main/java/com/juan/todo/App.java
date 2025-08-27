package com.juan.todo;

import java.util.HashMap;

public class App {

	public static void main(String[] args) {
		Tarea tareas_pendientes = new Tarea(new HashMap<String, Categoria>());
		Tarea tareas_realizadas = new Tarea(new HashMap<String, Categoria>());
		Usuario yo = new Usuario("Juan", "Olivera" , tareas_pendientes);
		
	}
	
}
