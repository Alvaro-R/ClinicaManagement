package bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import tablas.Fabricante;
import tablas.Producto;

public class Fabricantes {

static final String nombre_bbdd = "proyecto";
	
	public static ArrayList<String> nombreFabricantes() {

		ArrayList<String> fabricantes = new ArrayList<String>();
		
		try {
			//CONEXIÓN BBDD
			Connection conexion = BBDD.conexionBBDD(nombre_bbdd);
			
			Statement statement = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT nombre FROM Fabricantes ORDER BY nombre";
			
			ResultSet results = statement.executeQuery(sql);
			
			while (results.next()) {
				
				fabricantes.add(results.getString("nombre"));
				
			}
			
			statement.close();
			results.close();
			conexion.close();
			
		
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,e.getMessage(),
					"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
		}
		
		return fabricantes;
	}



	public static Fabricante visualizarFabricante(String nombre) throws Exception {
		
		Fabricante fabricante = null;
		
		try {
			//CONEXIÓN BBDD
			Connection conexion = BBDD.conexionBBDD(nombre_bbdd);
			
			Statement statement = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM Fabricantes WHERE nombre='"+nombre+"'";
						
			ResultSet results = statement.executeQuery(sql);
			results.next();
			
			fabricante = new Fabricante();
			
			fabricante.setNombre(results.getString(2));
			fabricante.setNombre_abreviado(results.getString(3));
			
			statement.close();
			results.close();
			conexion.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			if (e.getErrorCode() == 0) {
				throw new Exception("EL FABRICANTE NO EXISTE");
			} else {
				JOptionPane.showMessageDialog(null,e.getMessage(),
						"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"INTRODUCIR UN SÓLO REGISTRO",
					"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,e.getMessage(),
					"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
		}
		
		return fabricante;
	}
	
	
	public static Fabricante visualizarFabricanteAbreviado(String nombre_abreviado) throws Exception {
		
		Fabricante fabricante = null;
		
		try {
			//CONEXIÓN BBDD
			Connection conexion = BBDD.conexionBBDD(nombre_bbdd);
			
			Statement statement = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM Fabricantes WHERE nombre_abreviado='"+nombre_abreviado+"'";
						
			ResultSet results = statement.executeQuery(sql);
			results.next();
			
			fabricante = new Fabricante();
			
			fabricante.setNombre(results.getString(2));
			fabricante.setNombre_abreviado(results.getString(3));
	
			statement.close();
			results.close();
			conexion.close();
			
		} catch (SQLException sqlException) {
	        if (sqlException.getErrorCode() == 1062) {
	        	throw new Exception("REGISTRO DUPLICADO");
	        } else if (sqlException.getErrorCode() == 1048) {
				throw new Exception("CAMPOS VACÍOS");
	        } else if (sqlException.getErrorCode() == 0) {
				throw new Exception("EL FABRICANTE NO EXISTE");
	        } else {
				JOptionPane.showMessageDialog(null,sqlException.getMessage(),
						"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
	        }
	        
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"INTRODUCIR UN SÓLO REGISTRO",
					"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e.getMessage(),
					"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
		}
		
		return fabricante;
		
	}
	
	
	

	public static ArrayList<Producto> ProductosFabricantes(String nombre) throws Exception {
		
		ArrayList<Producto> lista_producto = null;
		
		try {
			
			//CONEXIÓN BBDD
			Connection conexion = BBDD.conexionBBDD(nombre_bbdd);
			
			Statement statement = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM Productos"
					+ " WHERE fabricante='"+nombre+"'";
			
			ResultSet results = statement.executeQuery(sql);
			
			lista_producto = new ArrayList<Producto>();
			
			while (results.next()) {
				
				Producto producto = new Producto();
				
				producto.setReferencia(results.getString(2));
				producto.setNombre(results.getString(3));
				producto.setDescripcion(results.getString(4));
				producto.setFormato(results.getFloat(5));
				producto.setTipo_formato(results.getString(6));
				producto.setPrecio(results.getFloat(7));
				producto.setPrecio_IVA(results.getFloat(8));
				producto.setFabricante(results.getString(9));
				
				lista_producto.add(producto);
				
			}
			
			statement.close();
			results.close();
			conexion.close();
			
		} catch (SQLException sqlException) {
	        if (sqlException.getErrorCode() == 1062) {
	        	throw new Exception("REGISTRO DUPLICADO");
	        } else if (sqlException.getErrorCode() == 1048) {
				throw new Exception("CAMPOS VACÍOS");
	        } else if (sqlException.getErrorCode() == 0) {
				throw new Exception("EL FABRICANTE NO EXISTE");
	        } else {
				JOptionPane.showMessageDialog(null,sqlException.getMessage(),
						"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
	        }
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e.getMessage(),
					"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
		}	
		
		return lista_producto;

	}
	
	
	public static String anteriorFabricante(String nombre) throws Exception {
		
		String anterior = null;
		
		try {
			//CONEXIÓN BBDD
			Connection conexion = BBDD.conexionBBDD(nombre_bbdd);
			
			Statement statement = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT Previous FROM (SELECT *, LAG(nombre) OVER (ORDER BY id) AS Previous FROM Fabricantes) "
					+ "AS T WHERE nombre='"+nombre+"'";
			
			ResultSet results = statement.executeQuery(sql);
			results.next();
			anterior= results.getString(1);
						
			if (anterior == null) {
				sql = "SELECT nombre FROM proyecto.Fabricantes ORDER BY id DESC LIMIT 1;";
				results = statement.executeQuery(sql);
				results.next();
				anterior= results.getString(1);
			}
			
			statement.close();
			results.close();
			conexion.close();
			
		} catch (SQLException sqlException) {
	        if (sqlException.getErrorCode() == 1062) {
	        	throw new Exception("REGISTRO DUPLICADO");
	        } else if (sqlException.getErrorCode() == 1048) {
				throw new Exception("CAMPOS VACÍOS");
	        } else if (sqlException.getErrorCode() == 0) {
				throw new Exception("EL FABRICANTE NO EXISTE");
	        } else {
				JOptionPane.showMessageDialog(null,sqlException.getMessage(),
						"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
	        }
	        
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"INTRODUCIR UN SÓLO REGISTRO",
					"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e.getMessage(),
					"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
		}
		
		return anterior;
	}
	
	
	public static String siguienteFabricante(String nombre) throws Exception {
		
		String siguiente = null;
		
		try {
			//CONEXIÓN BBDD
			Connection conexion = BBDD.conexionBBDD(nombre_bbdd);
			
			Statement statement = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT Next FROM (SELECT *, LEAD(nombre) OVER (ORDER BY id) AS Next FROM Fabricantes) "
					+ "AS T WHERE nombre='"+nombre+"'";
			
			ResultSet results = statement.executeQuery(sql);
			results.next();
			siguiente= results.getString(1);
						
			if (siguiente == null) {
				sql = "SELECT nombre FROM proyecto.Fabricantes ORDER BY id LIMIT 1;";
				results = statement.executeQuery(sql);
				results.next();
				siguiente= results.getString(1);
			}
			
			statement.close();
			results.close();
			conexion.close();
			
		} catch (SQLException sqlException) {
	        if (sqlException.getErrorCode() == 1062) {
	        	throw new Exception("REGISTRO DUPLICADO");
	        } else if (sqlException.getErrorCode() == 1048) {
				throw new Exception("CAMPOS VACÍOS");
	        } else if (sqlException.getErrorCode() == 0) {
				throw new Exception("EL FABRICANTE NO EXISTE");
	        } else {
				JOptionPane.showMessageDialog(null,sqlException.getMessage(),
						"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
	        }
	        
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"INTRODUCIR UN SÓLO REGISTRO",
					"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e.getMessage(),
					"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
		}

		return siguiente;
		
	}
	
	
	
	
	
	//MÉTODOS CREAR FABRICANTE
	
	public static void crearFabricante(String nombre, String abreviatura) throws Exception {
		
		try {
			//CONEXIÓN BASE DE DATOS
			Connection conexion = BBDD.conexionBBDD(nombre_bbdd);
			
			//QUERY PREPARADA
			PreparedStatement preparedStatement = conexion.prepareStatement("INSERT INTO Fabricantes VALUES (NULL,?,?)");
			
			//INSTANCIAMOS OBJETO PRODUCTO
			Fabricante fabricante = new Fabricante(nombre,abreviatura);
			
			System.out.println(fabricante.getNombre());
			
			//INSERTAMOS PRODUCTO EN TABLA
			preparedStatement.setString(1,fabricante.getNombre());
			preparedStatement.setString(2,fabricante.getNombre_abreviado());

			//EJECUCIÓN QUERY
			preparedStatement.executeUpdate();			
			preparedStatement.close();
			
		} catch (SQLException sqlException) {
	        if (sqlException.getErrorCode() == 1062) {
	        	throw new Exception("REGISTRO DUPLICADO");
	        } else if (sqlException.getErrorCode() == 1048) {
					throw new Exception("CAMPOS VACÍOS");
	        } else if (sqlException.getErrorCode() == 0) {
				throw new Exception("EL FABRICANTE NO EXISTE");
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
	
	
	public static void crearFabricante(Fabricante fabricante) throws Exception {
		
		try {
			//CONEXIÓN BASE DE DATOS
			Connection conexion = BBDD.conexionBBDD(nombre_bbdd);
			
			//QUERY PREPARADA
			PreparedStatement preparedStatement = conexion.prepareStatement("INSERT INTO Fabricantes VALUES (NULL,?,?)");
			
			//INSERTAMOS PRODUCTO EN TABLA
			preparedStatement.setString(1,fabricante.getNombre());
			preparedStatement.setString(2,fabricante.getNombre_abreviado());

			//EJECUCIÓN QUERY
			preparedStatement.executeUpdate();			
			preparedStatement.close();
			
		} catch (SQLException sqlException) {
	        if (sqlException.getErrorCode() == 1062) {
	        	throw new Exception("REGISTRO DUPLICADO");
	        } else if (sqlException.getErrorCode() == 1048) {
					throw new Exception("CAMPOS VACÍOS");
	        } else if (sqlException.getErrorCode() == 0) {
				throw new Exception("EL FABRICANTE NO EXISTE");
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
	
	
	
	//MÉTODOS ACTUALIZAR FABRICANTE
	
	public static void actualizarFabricante() throws Exception {
		
		int id=0;
		
		try {
			//CONEXIÓN BASE DE DATOS
			Connection conexion = BBDD.conexionBBDD(nombre_bbdd);
			
			//QUERY PREPARADA
			PreparedStatement preparedStatement = conexion.prepareStatement("UPDATE Fabricantes SET nombre=?, nombre_abreviado=? WHERE id=?");
			
			//OBTENEMOS EL ID DEL FABRICANTE
			PreparedStatement statement = conexion.prepareStatement("SELECT id FROM Fabricantes WHERE nombre=?");
			statement.setString(1,"ABCLONAL");
			ResultSet results = statement.executeQuery();
			
			results.next();
			id = results.getInt(1);
			
			//INSTANCIAMOS OBJETO FABRICANTE
			Fabricante fabricante = new Fabricante("THERMO","Probando");

			//INSERTAMOS FABRICANTE EN TABLA
			preparedStatement.setString(1,fabricante.getNombre());
			preparedStatement.setString(2,fabricante.getNombre_abreviado());
			preparedStatement.setFloat(3,id);
			
			//EJECUCIÓN QUERY
			preparedStatement.executeUpdate();			
			preparedStatement.close();
			statement.close();
			conexion.close();
			
		} catch (SQLException sqlException) {
	        if (sqlException.getErrorCode() == 1062) {
	        	throw new Exception("REGISTRO DUPLICADO");
	        } else if (sqlException.getErrorCode() == 1048) {
				throw new Exception("CAMPOS VACÍOS");
	        } else if (sqlException.getErrorCode() == 0) {
				throw new Exception("EL FABRICANTE NO EXISTE");
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
	
	
	public static void actualizarFabricante(Fabricante fabricante) throws Exception {
		
		int id=0;
		
		try {
			//CONEXIÓN BASE DE DATOS
			Connection conexion = BBDD.conexionBBDD(nombre_bbdd);
			
			//QUERY PREPARADA
			PreparedStatement preparedStatement = conexion.prepareStatement("UPDATE Fabricantes SET nombre=?, nombre_abreviado=? WHERE id=?");
			
			//OBTENEMOS EL ID DEL FABRICANTE
			PreparedStatement statement = conexion.prepareStatement("SELECT id FROM Fabricantes WHERE nombre=?");
			statement.setString(1,fabricante.getNombre());
			ResultSet results = statement.executeQuery();
			
			results.next();
			id = results.getInt(1);

			//INSERTAMOS FABRICANTE EN TABLA
			preparedStatement.setString(1,fabricante.getNombre());
			preparedStatement.setString(2,fabricante.getNombre_abreviado());
			preparedStatement.setFloat(3,id);
			
			//EJECUCIÓN QUERY
			preparedStatement.executeUpdate();			
			preparedStatement.close();
			statement.close();
			conexion.close();
			
		} catch (SQLException sqlException) {
	        if (sqlException.getErrorCode() == 1062) {
	        	throw new Exception("REGISTRO DUPLICADO");
	        } else if (sqlException.getErrorCode() == 1048) {
				throw new Exception("CAMPOS VACÍOS");
	        } else if (sqlException.getErrorCode() == 0) {
				throw new Exception("EL FABRICANTE NO EXISTE");
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
	
	
	//MÉTODOS ELIMINAR FABRICANTE
	
	public static void eliminarFabricante() throws Exception {
		
		int id =0;
		
		try {
			
			//CONEXIÓN BASE DE DATOS
			Connection conexion = BBDD.conexionBBDD(nombre_bbdd);
			
			//QUERY PREPARADA
			PreparedStatement preparedStatement = conexion.prepareStatement("DELETE FROM Fabricantes WHERE id=?");
			
			//OBTENEMOS EL ID DEL FABRICANTE
			PreparedStatement statement = conexion.prepareStatement("SELECT id FROM Fabricantes WHERE nombre=?");
			statement.setString(1,"THERMO");
			ResultSet results = statement.executeQuery();
			
			results.next();
			id = results.getInt(1);
			
			preparedStatement.setInt(1,id);
			
			//EJECUCIÓN QUERY
			preparedStatement.executeUpdate();			
			preparedStatement.close();
			conexion.close();
				
		} catch (SQLException sqlException) {
	        if (sqlException.getErrorCode() == 1062) {
	        	throw new Exception("REGISTRO DUPLICADO");
	        } else if (sqlException.getErrorCode() == 1048) {
				throw new Exception("CAMPOS VACÍOS");
	        } else if (sqlException.getErrorCode() == 0) {
				throw new Exception("EL FABRICANTE NO EXISTE");
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
	
	
	public static void eliminarFabricante(Fabricante fabricante) throws Exception {
		
		int id =0;
		
		try {
			
			//CONEXIÓN BASE DE DATOS
			Connection conexion = BBDD.conexionBBDD(nombre_bbdd);
			
			//QUERY PREPARADA
			PreparedStatement preparedStatement = conexion.prepareStatement("DELETE FROM Fabricantes WHERE id=?");
			
			//OBTENEMOS EL ID DEL FABRICANTE
			PreparedStatement statement = conexion.prepareStatement("SELECT id FROM Fabricantes WHERE nombre=?");
			statement.setString(1,fabricante.getNombre());
			ResultSet results = statement.executeQuery();
			
			results.next();
			id = results.getInt(1);
			
			preparedStatement.setInt(1,id);
			
			//EJECUCIÓN QUERY
			preparedStatement.executeUpdate();			
			preparedStatement.close();
			conexion.close();
				
		} catch (SQLException sqlException) {
	        if (sqlException.getErrorCode() == 1062) {
	        	throw new Exception("REGISTRO DUPLICADO");
	        } else if (sqlException.getErrorCode() == 1048) {
				throw new Exception("CAMPOS VACÍOS");
	        } else if (sqlException.getErrorCode() == 0) {
				throw new Exception("EL FABRICANTE NO EXISTE");
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
	
	
	
	
	
}
