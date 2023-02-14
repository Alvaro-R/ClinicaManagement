package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import tablas.Fabricante;
import tablas.Producto;

public class BBDD {
	
	static final String URL = "jdbc:mysql://localhost:3306/";
	static final String usuario = "root";
	static final String contraseña = "1234abcd";
	static final String nombre_bbdd = "proyecto";
	
	//MÉTODO CONEXIÓN SERVIDOR
	public static Connection conexionBBDD() throws SQLException {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(URL,usuario,contraseña);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e.getMessage(),
				"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
		}
		return conexion;
	}
	
	//MÉTODO CONEXIÓN BBDD
	public static Connection conexionBBDD(String database) throws Exception {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(URL+database,usuario,contraseña);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			if (e.getErrorCode() == 1049) {
	        	throw new Exception("BBDD NO EXISTE");
			} else {
				JOptionPane.showMessageDialog(null,e.getMessage(),
						"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e.getMessage(),
				"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
		}
		return conexion;
	}
	
	//MÉTODO CREACIÓN BBDD
	public static void crearBBDD() throws Exception {
		
		try {
			//CONEXIÓN SERVIDOR
			Connection conexion = conexionBBDD();
			
			//CREACIÓN BBDD
			Statement statement = conexion.createStatement();
	        statement.executeUpdate("CREATE DATABASE "+nombre_bbdd);
	        
	        statement.close();
	        conexion.close();
	        
		} catch (SQLException sqlException) {
	        if (sqlException.getErrorCode() == 1007) {
	        	throw new Exception("BBDD YA EXISTE");
	        } else {
				JOptionPane.showMessageDialog(null,sqlException.getMessage(),
						"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
	        }
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e.getMessage(),
					"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
		}

		
	}
	
	public static void eliminarBBDD() throws Exception {
		
		try {
			//CONEXIÓN SERVIDOR
			Connection conexion = conexionBBDD();
			
			//CREACIÓN BBDD
			Statement statement = conexion.createStatement();
	        statement.executeUpdate("DROP DATABASE "+nombre_bbdd);
	        
	        statement.close();
	        conexion.close();
	        
		} catch (SQLException sqlException) {
	        if (sqlException.getErrorCode() == 1008) {
	            throw new Exception("BBDD NO EXISTE");
	        } else {
				JOptionPane.showMessageDialog(null,sqlException.getMessage(),
						"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
	        } 
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e.getMessage(),
					"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	
	
	//CREAR TABLA PRODUCTOS
	public static void crearTablaProductos() {
		
		try {
			//CONEXIÓN BBDD
			Connection conexion = conexionBBDD(nombre_bbdd);

			Statement statement = conexion.createStatement();
			//ELIMINAR TABLA SI YA EXISTE
			statement.executeUpdate("DROP TABLE IF EXISTS Productos");
			//CREAR TABLA
			statement.executeUpdate("CREATE TABLE Productos("
					+ "id INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,"
					+ "referencia VARCHAR(10) UNIQUE NOT NULL,"
					+ "nombre VARCHAR(30) NOT NULL,"
					+ "descripcion VARCHAR(100) NOT NULL,"
					+ "formato FLOAT NOT NULL,"
					+ "tipo_formato VARCHAR(10) NOT NULL,"
					+ "precio FLOAT NOT NULL,"
					+ "precio_IVA FLOAT NOT NULL,"
					+ "fabricante VARCHAR(30) NOT NULL,"
					+ "CONSTRAINT FK_ProFab FOREIGN KEY (fabricante) REFERENCES Fabricantes(nombre) ON DELETE CASCADE ON UPDATE CASCADE"
					+ ")"
					);

			statement.close();
			conexion.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e.getMessage(),
					"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,e.getMessage(),
					"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
		}	
	}
	
	
	public static void crearTablaFabricantes() {
	
		try {
			//CONEXIÓN BBDD
			Connection conexion = conexionBBDD(nombre_bbdd);	

			Statement statement = conexion.createStatement();
			
			statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
			//ELIMINAR TABLA SI YA EXISTE
			statement.executeUpdate("DROP TABLE IF EXISTS Fabricantes");
			statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
			
			//CREAR TABLA
			statement.executeUpdate("CREATE TABLE Fabricantes("
					+ "id INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,"
					+ "nombre VARCHAR(30) UNIQUE NOT NULL,"
					+ "nombre_abreviado VARCHAR(10) UNIQUE NOT NULL"
					+ ")"
					);

			statement.close();
			conexion.close();			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e.getMessage(),
					"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,e.getMessage(),
					"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
		}		
	}
	
	
	public static void crearTablaClientes() {
		
		try {
			//CONEXIÓN BBDD
			Connection conexion = conexionBBDD(nombre_bbdd);

			Statement statement = conexion.createStatement();
			//ELIMINAR TABLA SI YA EXISTE
			statement.executeUpdate("DROP TABLE IF EXISTS Clientes");
			//CREAR TABLA
			statement.executeUpdate("CREATE TABLE Clientes("
					+ "id INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,"
					+ "nombre VARCHAR(30) UNIQUE NOT NULL,"
					+ "nombre_abreviado VARCHAR(10) UNIQUE NOT NULL"
					+ ")"
					);

			statement.close();
			conexion.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e.getMessage(),
					"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,e.getMessage(),
					"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
		}	
		
	}
	
	public static void llenarProductos() {	
		
		try {
			//PRODUCTOS FABRICANTE GENETEX
			Producto producto1 = new Producto("GTX12545","Anticuerpo1","Anti-Mouse IgG",100,"ul",150,"GENETEX");
			Producto producto2 = new Producto("GTX52875","Anticuerpo2","Anti-Rat IgG",100,"ul",150,"GENETEX");
			Producto producto3 = new Producto("GTX87452","Anticuerpo3","Anti-Donkey IgG",100,"ul",150,"GENETEX");
			Producto producto4 = new Producto("GTX87746","Proteina1","Recombinant Protein alpha",100,"mg",400,"GENETEX");
			Producto producto5 = new Producto("GTX85523","Proteina2","Recombinant Protein beta",100,"mg",400,"GENETEX");
			
			//PRODUCTOS FABRICANTE THERMO
			Producto producto6 = new Producto("12-4558-82","Anticuerpo1","Anti-CD4 AlexaFluor",100,"ul",200,"THERMO");
			Producto producto7 = new Producto("12-8462-82","Anticuerpo2","Anti-CD8 AlexaFluor",100,"ul",220,"THERMO");
			Producto producto8 = new Producto("12-1620-82","Anticuerpo3","Anti-CD16 AlexaFluor",100,"ul",210,"THERMO");
			Producto producto9 = new Producto("145893","Frasco Cultivo1","Frasco grande para cultivo celular",10,"unidades",300,"THERMO");
			Producto producto10 = new Producto("124475","Frasco Cultivo2","Frasco pequeño para cultivo celular",50,"unidades",250,"THERMO");
			
			//PRODUCTOS FABRICANTE ABCLONAL
			Producto producto11 = new Producto("RK04145","Protein1","SARS-CoV-2 Spike S1 Protein",150,"ug",300,"ABCLONAL");
			Producto producto12 = new Producto("RK04515","Protein2","SARS-CoV-2 Nucleocapsid Protein",150,"ug",350,"ABCLONAL");
			Producto producto13 = new Producto("RK08563","Protein3","SARS-CoV-2 Spike RBD Protein",150,"ug",400,"ABCLONAL");
			Producto producto14 = new Producto("RK08689","Protein4","SARS-CoV-2 Spike ECD Protein",150,"ug",300,"ABCLONAL");
			Producto producto15 = new Producto("RK03625","Protein5","SARS-CoV-2 M Protein",150,"ug",280,"ABCLONAL");
			
			Productos.crearProducto(producto1);
			Productos.crearProducto(producto2);
			Productos.crearProducto(producto3);
			Productos.crearProducto(producto4);
			Productos.crearProducto(producto5);
			Productos.crearProducto(producto6);
			Productos.crearProducto(producto7);
			Productos.crearProducto(producto8);
			Productos.crearProducto(producto9);
			Productos.crearProducto(producto10);
			Productos.crearProducto(producto11);
			Productos.crearProducto(producto12);
			Productos.crearProducto(producto13);
			Productos.crearProducto(producto14);
			Productos.crearProducto(producto15);
			
			JOptionPane.showMessageDialog(null,"PRODUCTOS CREADOS CORRECTAMENTE",
					"WARNING_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e.getMessage(),
					"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	
	public static void llenarFabricantes() {
		
		try {
			//GENETEX
			Fabricante fabricante1 = new Fabricante("GENETEX","GTX");
			
			//THERMO
			Fabricante fabricante2 = new Fabricante("THERMO", "TH");
			
			//ABCLONAL
			Fabricante fabricante3 = new Fabricante("ABCLONAL","AB");
			
			Fabricantes.crearFabricante(fabricante1);
			Fabricantes.crearFabricante(fabricante2);
			Fabricantes.crearFabricante(fabricante3);
			
			JOptionPane.showMessageDialog(null,"FABRICANTES CREADOS CORRECTAMENTE",
					"WARNING_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e.getMessage(),
					"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
