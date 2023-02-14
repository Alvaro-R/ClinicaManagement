package tablas;

import java.sql.SQLException;

public class Producto {
	
	public Producto(String referencia, String nombre, String descripcion, float formato, String tipo_formato,
			float precio, String fabricante) throws SQLException {
		super();
		
//		this.id = id++;
		this.referencia = referencia;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.formato = formato;
		this.tipo_formato = tipo_formato;
		this.precio = precio;
		this.precio_IVA = (float) (precio+(precio*0.21));
		this.fabricante = fabricante;
		
		if (this.referencia.isEmpty() | this.nombre.isEmpty() | this.descripcion.isEmpty()
				| this.tipo_formato.isEmpty() | this.fabricante.isEmpty()) {
			throw new SQLException("CAMPO VACÍO");
		}
		
	}
	
	public Producto(String referencia, String nombre, String descripcion, float formato, String tipo_formato,
			float precio,float precio_IVA, String fabricante) throws SQLException {
		super();
		this.referencia = referencia;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.formato = formato;
		this.tipo_formato = tipo_formato;
		this.precio = precio;
		this.precio_IVA = precio_IVA;
		this.fabricante = fabricante;
		
		if (this.referencia.isEmpty() | this.nombre.isEmpty() | this.descripcion.isEmpty()
				| this.tipo_formato.isEmpty() | this.fabricante.isEmpty()) {
			throw new SQLException("CAMPO VACÍO");
		}
		
	}
	
	
	public Producto(String referencia) throws SQLException {
		super();
		this.referencia = referencia;
		
		if (this.referencia.isEmpty() | this.nombre.isEmpty() | this.descripcion.isEmpty()
				| this.tipo_formato.isEmpty() | this.fabricante.isEmpty()) {
			throw new SQLException("CAMPO VACÍO");
		}
		
	}
	
	public Producto() throws SQLException {
		super();
		if (this.precio_IVA==0) {
			this.setPrecio_IVA(precio);
		}
		
	}
	
	

	//ID
//	private int id;
//
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
	
	//REFERENCIA
	private String referencia;
	
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
	//NOMBRE
	private String nombre;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//DESCRIPCIÓN
	private String descripcion;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	//FORMATO
	private float formato;
	
	public float getFormato() {
		return formato;
	}
	public void setFormato(float formato) {
		this.formato = formato;
	}
	
	//TIPO DE FORMATO
	private String tipo_formato;
	
	public String getTipo_formato() {
		return tipo_formato;
	}
	public void setTipo_formato(String tipo_formato) {
		this.tipo_formato = tipo_formato;
	}
	
	//PRECIO
	private float precio;
	
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	//PRECIO CON IVA
	private float precio_IVA=0;
	
	public float getPrecio_IVA() {
		return precio_IVA;
	}
	public void setPrecio_IVA(float precio_IVA) {
		this.precio_IVA = (float) (this.precio+(this.precio*0.21));
	}
	
	//FABRICANTE
	private String fabricante;
	
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	public String toString() {
		return this.referencia+" "+this.nombre;
	}
	
	
	
	
	
}
