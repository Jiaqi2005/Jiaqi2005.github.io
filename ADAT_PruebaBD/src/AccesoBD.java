import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AccesoBD {


	// Conexion con la BD. La crearemos en el constructor con el resto de datos
	// (que deberian estar en un fichero config)
	Connection conn;

	public AccesoBD() {

		
		// Libreria de MySQL
		String driver = "com.mysql.cj.jdbc.Driver";

		// Nombre de la base de datos
		String database = "bdpruebas";

		// Host
		String hostname = "localhost";

		// Puerto
		String port = "3306";

		// Ruta de nuestra base de datos (desactivamos el uso de SSL con
		// "?useSSL=false")
		String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";

		// Nombre de usuario
		String username = "root";

		// Clave de usuario
		String password = "root";
		
		try {
			Class.forName(driver);
			System.out.println(url);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public void pruebaRead() {

		 try {
		        String query = "SELECT id, nombre, descripcion, caracteristica, edad FROM elementos";

		        
		        Statement st = conn.createStatement();

		        
		        ResultSet rs = st.executeQuery(query);

		        
		        while (rs.next()) {
		           
		            int id = rs.getInt("id");
		            String name = rs.getString("nombre");
		            String description = rs.getString("descripcion");
		            String character = rs.getString("caracteristica");
		            int years = rs.getInt("edad");

		            // print the results
		            System.out.println("--------------------------------------------------------------");
		            System.out.printf("	Id: %d\n	Nombre: %s\n	Descripción: %s\n	Característica: %s\n	Edad: %d\n", id, name, description, character, years);
		            System.out.println("--------------------------------------------------------------");
		        }

		        rs.close();
		        st.close();

		    } catch (Exception e) {
		        System.err.println("Got an exception! ");
		        System.err.println(e.getMessage());
		        e.printStackTrace();
		    }
		}
	
	public void pruebaInsert(Jugador jugador) {
		Scanner teclado = new Scanner (System.in);
		
		try {
			/*
			System.out.println("Introduce el id");
			int id = teclado.nextInt();
			
			teclado.nextLine();
		
			System.out.println("Introduce el nombre");
			String nombre = teclado.nextLine();
			
			System.out.println("Introduce una descripcion");
			String descripcion = teclado.nextLine();
			
			System.out.println("Introduce la caracteristica");
			String caracteristica = teclado.nextLine();
			
			System.out.println("Introduce la edad");
			int edad = teclado.nextInt();
			*/

			
			String query = "Insert Into elementos (id, nombre, descripcion, caracteristica, edad)" + " values('" +jugador.getId()+ "', '" +jugador.getNombre()+ "', '" +jugador.getDescripcion()+ "', '" +jugador.getCaracteritica()+ "', '" +jugador.getEdad()+ "')";
            System.out.println(query);
			// create the java statement
			Statement st = conn.createStatement();

			
			st.executeLargeUpdate(query);
			
			st.close();
			
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
	public void pruebaUpdate(Jugador jugador) {
		Scanner teclado = new Scanner (System.in);
		
		try {
			/*
			System.out.println("Introduce el id a modificar");
			int id = teclado.nextInt();
			
			teclado.nextLine();
			
			System.out.println("Introduce el nombre");
			String nombre = teclado.nextLine();
			
			System.out.println("Introduce una descripcion");
			String descripcion = teclado.nextLine();
			
			System.out.println("Introduce la caracteristica");
			String caracteristica = teclado.nextLine();
			
			System.out.println("Introduce la edad");
			int edad = teclado.nextInt();
			*/
			String query = "Update elementos Set nombre= '" +jugador.getNombre()+ "', descripcion= '" +jugador.getDescripcion()+ "', caracteristica= '" +jugador.getCaracteritica()+ "', edad= '" +jugador.getEdad()+  "' Where id= '" +jugador.getId()+ "'";
            System.out.println(query);
            
			// create the java statement
			Statement st = conn.createStatement();

			
			st.executeLargeUpdate(query);
			
			st.close();
			
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
	public void pruebaBorrar(Jugador jugador) {
		Scanner teclado = new Scanner (System.in);
		
		try {
			/*
			System.out.println("Introduce el id a borrar");
			int id = teclado.nextInt();
			*/
			String query = "Delete From elementos Where id= '" +jugador.getId()+ "'";
            System.out.println(query);
            
			// create the java statement
			Statement st = conn.createStatement();

			
			st.executeLargeUpdate(query);
			
			st.close();
			
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public void buscarPorId(int id) {
	    try {
	        String query = "SELECT id, nombre, descripcion, caracteristica, edad FROM elementos WHERE id = " + id;
	        Statement st = conn.createStatement();
	        ResultSet rs = st.executeQuery(query);

	        if (rs.next()) {
	            int elementId = rs.getInt("id");
	            String name = rs.getString("nombre");
	            String description = rs.getString("descripcion");
	            String character = rs.getString("caracteristica");
	            int years = rs.getInt("edad");

	            System.out.println("--------------------------------------------------------------");
	            System.out.printf("    Id: %d\n    Nombre: %s\n    Descripción: %s\n    Característica: %s\n    Edad: %d\n", elementId, name, description, character, years);
	            System.out.println("--------------------------------------------------------------");
	        } else {
	            System.out.println("No se encontró ningún elemento con el ID: " + id);
	        }

	        rs.close();
	        st.close();

	    } catch (Exception e) {
	        System.err.println("Got an exception! ");
	        System.err.println(e.getMessage());
	        e.printStackTrace();
	    }
	}

	public void buscarPorCampoYValor(String campo, String valor) {
	    try {
	        String query = "SELECT id, nombre, descripcion, caracteristica, edad FROM elementos WHERE " + campo + " LIKE '%" + valor + "%'";
	        Statement st = conn.createStatement();
	        ResultSet rs = st.executeQuery(query);

	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String name = rs.getString("nombre");
	            String description = rs.getString("descripcion");
	            String character = rs.getString("caracteristica");
	            int years = rs.getInt("edad");

	            System.out.println("--------------------------------------------------------------");
	            System.out.printf("    Id: %d\n    Nombre: %s\n    Descripción: %s\n    Característica: %s\n    Edad: %d\n", id, name, description, character, years);
	            System.out.println("--------------------------------------------------------------");
	        }

	        rs.close();
	        st.close();

	    } catch (Exception e) {
	        System.err.println("Got an exception! ");
	        System.err.println(e.getMessage());
	        e.printStackTrace();
	    }
	}

	
	public void buscarPorValorEnCualquierCampo(String valor) {
	    try {
	        String query = "SELECT id, nombre, descripcion, caracteristica, edad FROM elementos WHERE id LIKE '%" + valor + "%' OR nombre LIKE '%" + valor + "%' OR descripcion LIKE '%" + valor + "%' OR caracteristica LIKE '%" + valor + "%' OR edad LIKE '%" + valor + "%'";
	        Statement st = conn.createStatement();
	        ResultSet rs = st.executeQuery(query);

	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String name = rs.getString("nombre");
	            String description = rs.getString("descripcion");
	            String character = rs.getString("caracteristica");
	            int years = rs.getInt("edad");

	            System.out.println("--------------------------------------------------------------");
	            System.out.printf("    Id: %d\n    Nombre: %s\n    Descripción: %s\n    Característica: %s\n    Edad: %d\n", id, name, description, character, years);
	            System.out.println("--------------------------------------------------------------");
	        }

	        rs.close();
	        st.close();

	    } catch (Exception e) {
	        System.err.println("Got an exception! ");
	        System.err.println(e.getMessage());
	        e.printStackTrace();
	    }
	}

}
