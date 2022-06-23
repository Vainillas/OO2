package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MySQLFacade implements DBFacade {
  private static String DRIVER = "com.mysql.jdbc.Driver";
  private static String URL_DB = "jdbc:mysql://localhost:3306/";
  protected static String DB = "objetos2_tp8";

  protected static String user = "root";
  protected static String pass = "";
  protected static Connection conn = null;

  private static void connect() throws SQLException {
    try {
      conn = DriverManager.getConnection(URL_DB + DB + "?useSSL=false", user, pass);
    } catch (SQLException sqlEx) {
      throw sqlEx;
    }
  }

  /**
   * Abre una conexión a una base de datos
   * */
  public void open() {
    try {
      if (conn == null || conn.isClosed()) connect();
    } catch (SQLException e) {
      throw new RuntimeException(e.getCause());
    }
  }

  /**
   * Ejecuta una sentencia SQL.
   *
   * @return una Lista de filas, donde cada fila es un Mapa con nombreColumna
   * => valorColumna. O una lista vacia.
   * @throws RuntimeException
   * si la conexión no esta abierta o existe un error en la
   * sentencia sql
   */
  public List<Map<String, String>> queryResultAsAsociation(String sql) {
    List<Map<String, String>> listaMaps = new ArrayList<Map<String, String>>();
    try {
      PreparedStatement statement = conn.prepareStatement(sql);
      ResultSet result = statement.executeQuery();
      ResultSetMetaData rsMeta = result.getMetaData();
      int cantColumnas = rsMeta.getColumnCount();
      while (result.next()) {
        for (int i = 0; i <= cantColumnas; i++) {
          Map<String, String> map = Map.of(
            rsMeta.getColumnClassName(i),
            result.getString(i)
          );
          listaMaps.add(map);
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e.getCause());
    }
    return listaMaps;
  }

  /**
   * Ejecuta una sentencia SQL.
   *
   * @return una Lista de filas, donde cada fila es una arreglo. O una lista vacia.
   * *
   * @throws RuntimeException
   * si la conexión no esta abierta o existe un error en la
   * sentencia sql
   */
  public List<String[]> queryResultAsArray(String sql) {
    List<String[]> listaString = new ArrayList<String[]>();
    try {
      PreparedStatement statement = conn.prepareStatement(sql);
      ResultSet result = statement.executeQuery();
      ResultSetMetaData rsMeta = result.getMetaData();
      int cantColumnas = rsMeta.getColumnCount();
      while (result.next()) {
        String[] string = new String[cantColumnas];
        for (int i = 0; i <= cantColumnas; i++) {
          string[i] = result.getString(i);
        }
        listaString.add(string);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e.getCause());
    }

    return listaString;
  }

  /**
   * Cierra la conexión a la base de datos.
   * */
  public void close() {
    try {
      conn.close();
    } catch (SQLException e) {
      throw new RuntimeException(e.getCause());
    }
  }
}
