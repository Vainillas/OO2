package accesos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import tp6p4.modelo.Listados;

public class DataBaseDecorator implements Listados {
	Listados listador;

	public DataBaseDecorator(Listados listador) {
		this.listador = listador;
	}

	@Override
	public String obtenerListado() {
		try {

			ObjectMapper mapper = new ObjectMapper();
			try {
				List<Map<String, Object>> map = mapper.readValue(listador.obtenerListado(),
						new TypeReference<List<Map<String, Object>>>() {
						});
				Connection conn = ConnectionManager.getConnection();

				for (Map<String, Object> m : map) {
					PreparedStatement statement = conn
							.prepareStatement("INSERT INTO posts(user_id, id, title, body) " + "VALUES (?,?,?,?)");
					int userId = (int) m.get("userId");
					int id = (int) m.get("id");
					statement.setInt(1, userId);
					statement.setInt(2, id);
					statement.setString(3, (String) m.get("title"));
					statement.setString(4, (String) m.get("body"));
					statement.executeUpdate();
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e) {
			throw new RuntimeException("No se puedo conectar a la base de datos" + e);
		} finally {
			ConnectionManager.disconnect();
		}

		return listador.obtenerListado();
	}
}