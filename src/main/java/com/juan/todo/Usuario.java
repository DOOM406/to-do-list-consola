package com.juan.todo;

public class Usuario {
	
	private String nombre;
	private String apellido;
	private Tarea lista;
	
	public Usuario(String nombre, String apellido, Tarea lista) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.lista = lista;
	}
	
	public void mostrar_mis_tareas() {
		lista.MostrarTareas();
	}
	
}
