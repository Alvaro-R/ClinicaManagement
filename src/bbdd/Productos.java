package bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import tablas.Producto;

public class Productos {

	static final String nombre_bbdd = "proyecto";
	
	
	//MÉTODOS MOSTRAR PRODUCTOS
	
	public static ArrayList<Producto> listaProductos() throws Exception {
		
		ArrayList<Producto> lista_producto = null;
		
		try {
			//CONEXIÓN BBDD
			Connection conexion = BBDD.conexionBBDD(nombre_bbdd);
			
			Statement statement = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM productos";
			
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
				throw new Exception("EL PRODUCTO NO EXISTE");
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
		
		return lista_producto;
		
	}
	
	
	
	public static Producto visualizarProducto(String referencia) throws Exception {
		
		Producto producto = null;
		
		try {
			//CONEXIÓN BBDD
			Connection conexion = BBDD.conexionBBDD(nombre_bbdd);
			
			//
			Statement statement = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM Productos WHERE referencia='"+referencia+"'";
			
			ResultSet results = statement.executeQuery(sql);
			results.next();
			
			producto = new Producto();
			
			producto.setReferencia(results.getString(2));
			producto.setNombre(results.getString(3));
			producto.setDescripcion(results.getString(4));
			producto.setFormato(results.getFloat(5));
			producto.setTipo_formato(results.getString(6));
			producto.setPrecio(results.getFloat(7));
			producto.setPrecio_IVA(results.getFloat(8));
			producto.setFabricante(results.getString(9));
			
			statement.close();
			results.close();
			conexion.close();
			
		} catch (SQLException sqlException) {
	        if (sqlException.getErrorCode() == 1062) {
	        	throw new Exception("REGISTRO DUPLICADO");
	        } else if (sqlException.getErrorCode() == 1048) {
				throw new Exception("CAMPOS VACÍOS");
	        } else if (sqlException.getErrorCode() == 0) {
				throw new Exception("EL PRODUCTO NO EXISTE");
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
		
		return producto;
		
	}
	
	public static String anteriorProducto(String referencia) throws Exception {
		
		String anterior=null;
		
		try {
			//CONEXIÓN BBDD
			Connection conexion = BBDD.conexionBBDD(nombre_bbdd);
			
			Statement statement = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT Previous FROM (SELECT *, LAG(referencia) OVER (ORDER BY id) AS Previous FROM Productos) "
					+ "AS T WHERE referencia='"+referencia+"'";
			
			ResultSet results = statement.executeQuery(sql);
			results.next();
			anterior= results.getString(1);
						
			if (anterior == null) {
				sql = "SELECT referencia FROM proyecto.Productos ORDER BY id DESC LIMIT 1;";
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
				throw new Exception("EL PRODUCTO NO EXISTE");
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
	
	
	public static String siguienteProducto(String referencia) throws Exception {
		
		String siguiente = null;
		
		try {
			//CONEXIÓN BBDD
			Connection conexion = BBDD.conexionBBDD(nombre_bbdd);
			
			Statement statement = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT Next FROM (SELECT *, LEAD(referencia) OVER (ORDER BY id) AS Next FROM Productos) "
					+ "AS T WHERE referencia='"+referencia+"'";
			
			ResultSet results = statement.executeQuery(sql);
			results.next();
			siguiente= results.getString(1);
						
			if (siguiente == null) {
				sql = "SELECT referencia FROM proyecto.Productos ORDER BY id LIMIT 1;";
				results = statement.executeQuery(sql);
				results.next();
				siguiente= results.getString(1);
			}
			
			statement.close();
			results.close();
			conexion.close();
			
			return siguiente;
			
		} catch (SQLException sqlException) {
	        if (sqlException.getErrorCode() == 1062) {
	        	throw new Exception("REGISTRO DUPLICADO");
	        } else if (sqlException.getErrorCode() == 1048) {
				throw new Exception("CAMPOS VACÍOS");
	        } else if (sqlException.getErrorCode() == 0) {
				throw new Exception("EL PRODUCTO NO EXISTE");
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
	
	
	//MÉTODOS CREAR PRODUCTO
	
	
	public static void crearProducto(String referencia) throws Exception {
		
		try {
			//CONEXIÓN BASE DE DATOS
			Connection conexion = BBDD.conexionBBDD(nombre_bbdd);
			
			//QUERY PREPARADA
			PreparedStatement preparedStatement = conexion.prepareStatement("INSERT INTO Productos VALUES (NULL,?,?,?,?,?,?,?,?)");
			
			//INSTANCIAMOS OBJETO PRODUCTO
			
			Producto producto = new Producto(referencia,"Tubos de 50","Son tubos de plástico",(float) 100,"unidades",(float) 50.50,"ABCLONAL");
			
			System.out.println(producto.getReferencia());
			
			//INSERTAMOS PRODUCTO EN TABLA
			preparedStatement.setString(1,producto.getReferencia());
			preparedStatement.setString(2,producto.getNombre());
			preparedStatement.setString(3,producto.getDescripcion());
			preparedStatement.setFloat(4,producto.getFormato());
			preparedStatement.setString(5,producto.getTipo_formato());
			preparedStatement.setFloat(6,producto.getPrecio());
			preparedStatement.setFloat(7,producto.getPrecio_IVA());
			preparedStatement.setString(8,producto.getFabricante());

			//EJECUCIÓN QUERY
			preparedStatement.executeUpdate();			
			preparedStatement.close();

		} catch (SQLException sqlException) {
	        if (sqlException.getErrorCode() == 1062) {
	        	throw new Exception("REGISTRO DUPLICADO");
	        } else if (sqlException.getErrorCode() == 1048) {
				throw new Exception("CAMPOS VACÍOS");
	        } else if (sqlException.getErrorCode() == 0) {
				throw new Exception("EL PRODUCTO NO EXISTE");
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
	
	
	public static void crearProducto(Producto producto) throws Exception {
		
		try {
			//CONEXIÓN BASE DE DATOS
			Connection conexion = BBDD.conexionBBDD(nombre_bbdd);
			
			//QUERY PREPARADA
			PreparedStatement preparedStatement = conexion.prepareStatement("INSERT INTO Productos VALUES (NULL,?,?,?,?,?,?,?,?)");
			
			//INSERTAMOS PRODUCTO EN TABLA
			preparedStatement.setString(1,producto.getReferencia());
			preparedStatement.setString(2,producto.getNombre());
			preparedStatement.setString(3,producto.getDescripcion());
			preparedStatement.setFloat(4,producto.getFormato());
			preparedStatement.setString(5,producto.getTipo_formato());
			preparedStatement.setFloat(6,producto.getPrecio());
			preparedStatement.setFloat(7,producto.getPrecio_IVA());
			preparedStatement.setString(8,producto.getFabricante());

			//EJECUCIÓN QUERY
			preparedStatement.executeUpdate();			
			preparedStatement.close();

		} catch (SQLException sqlException) {
	        if (sqlException.getErrorCode() == 1062) {
	        	throw new Exception("REGISTRO DUPLICADO");
	        } else if (sqlException.getErrorCode() == 1048) {
				throw new Exception("CAMPOS VACÍOS");
	        } else if (sqlException.getErrorCode() == 0) {
				throw new Exception("EL PRODUCTO NO EXISTE");
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
	
	
	
	
	//MÉTODOS ACTUALIZAR PRODUCTO
	
	
	public static void actualizarProducto() throws Exception {
		
		try {
			//CONEXIÓN BASE DE DATOS
			Connection conexion = BBDD.conexionBBDD(nombre_bbdd);
			
			//QUERY PREPARADA
			PreparedStatement preparedStatement = conexion.prepareStatement("UPDATE Productos SET nombre=?,descripcion=?,formato=?,tipo_formato=?,precio=?,fabricante=? WHERE referencia=?");
			
			//INSTANCIAMOS OBJETO PRODUCTO
			Producto producto = new Producto("PLC50050","Probando","Prueba",(float) 20,"unidades",(float) 50.50,"ABCLONAL");
			
			System.out.println(producto.getReferencia());
			
			//INSERTAMOS PRODUCTO EN TABLA
			preparedStatement.setString(1,producto.getNombre());
			preparedStatement.setString(2,producto.getDescripcion());
			preparedStatement.setFloat(3,producto.getFormato());
			preparedStatement.setString(4,producto.getTipo_formato());
			preparedStatement.setFloat(5,producto.getPrecio());
			preparedStatement.setString(6,producto.getFabricante());
			preparedStatement.setString(7,producto.getReferencia());

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
				throw new Exception("EL PRODUCTO NO EXISTE");
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
	
	
	public static void actualizarProducto(Producto producto) throws Exception {
		
		try {
			//CONEXIÓN BASE DE DATOS
			Connection conexion = BBDD.conexionBBDD(nombre_bbdd);
			
			//QUERY PREPARADA
			PreparedStatement preparedStatement = conexion.prepareStatement("UPDATE Productos SET nombre=?,descripcion=?,"
					+ "formato=?,tipo_formato=?,precio=?,fabricante=? WHERE referencia=?");
			
			//INSERTAMOS PRODUCTO EN TABLA
			preparedStatement.setString(1,producto.getNombre());
			preparedStatement.setString(2,producto.getDescripcion());
			preparedStatement.setFloat(3,producto.getFormato());
			preparedStatement.setString(4,producto.getTipo_formato());
			preparedStatement.setFloat(5,producto.getPrecio());
			preparedStatement.setString(6,producto.getFabricante());
			preparedStatement.setString(7,producto.getReferencia());

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
				throw new Exception("EL PRODUCTO NO EXISTE");
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
	
	
	
	
	
	public static void eliminarProducto() throws Exception {
		
		try {
			
			//CONEXIÓN BASE DE DATOS
			Connection conexion = BBDD.conexionBBDD(nombre_bbdd);
			
			//QUERY PREPARADA
			PreparedStatement preparedStatement = conexion.prepareStatement("DELETE FROM Productos WHERE referencia=?");
			
			Producto producto = new Producto("PLC50050");
			
			preparedStatement.setString(1,producto.getReferencia());
			
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
				throw new Exception("EL PRODUCTO NO EXISTE");
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
	
	
	public static void eliminarProducto(Producto producto) throws Exception {
		
		try {
			
			//CONEXIÓN BASE DE DATOS
			Connection conexion = BBDD.conexionBBDD(nombre_bbdd);
			
			//QUERY PREPARADA
			PreparedStatement preparedStatement = conexion.prepareStatement("DELETE FROM Productos WHERE referencia=?");
			
			preparedStatement.setString(1,producto.getReferencia());
			
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
				throw new Exception("EL PRODUCTO NO EXISTE");
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
