package tablas;

import java.sql.SQLException;

public class Fabricante {
	
	public Fabricante(String nombre, String nombre_abreviado) throws SQLException {
		super();
		this.nombre = nombre;
		this.nombre_abreviado = nombre_abreviado;
		if (this.nombre.isEmpty() | this.nombre_abreviado.isEmpty()) {
			throw new SQLException("CAMPO VACÍO");
		}
	}

	public Fabricante(String nombre) throws SQLException {
		super();
		this.nombre = nombre;
		if (this.nombre.isEmpty() | this.nombre_abreviado.isEmpty()) {
			throw new SQLException("CAMPO VACÍO");
		}
	}
	
	public Fabricante() {
		super();
	}
	
	//NOMBRE
	private String nombre;

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//NOMBRE ABREVIADO
	private String nombre_abreviado;
	
	public String getNombre_abreviado() {
		return nombre_abreviado;
	}
	public void setNombre_abreviado(String nombre_abreviado) {
		this.nombre_abreviado = nombre_abreviado;
	}

}
