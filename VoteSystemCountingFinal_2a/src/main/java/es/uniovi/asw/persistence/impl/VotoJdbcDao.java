package es.uniovi.asw.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import es.uniovi.asw.model.Voto;
import es.uniovi.asw.persistence.Jdbc;
import es.uniovi.asw.persistence.VotoDao;

public class VotoJdbcDao implements VotoDao {

	private Properties QUERIES = Jdbc.getQueries();

	public boolean save(Voto voto) {

		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;

		try {

			con = Jdbc.getConnection();
			/*
			ps = con.prepareStatement(QUERIES.getProperty("SAVE_VOTE"));

			ps.setLong(1, voto.getIdOpcion());
			ps.setLong(2, voto.getIdColElect());
			ps.setLong(3, voto.getTotVotos());

			int num = ps.executeUpdate();
			*/
			
			ps2 = con
					.prepareStatement("select definicion, codvotacion from opciones where id = ?");
			ps2.setLong(1, voto.getIdOpcion());
			ResultSet rs = ps2.executeQuery();
			//Long codVota = 0L;
			String opcion = "";
			while (rs.next()) {
				opcion = rs.getString(1);
				//codVota = rs.getLong(2);
			}

			ps3 = con
					.prepareStatement(QUERIES.getProperty("SAVE_VOTE"));
			ps3.setLong(1, voto.getIdColElect());
			ps3.setLong(2, voto.getIdOpcion());
			ps3.setBoolean(3, true);
			ps3.setString(4, opcion);

			int num=ps3.executeUpdate();

			return (num > 0);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Jdbc.close(con, ps);
		}

		return false;

	}

	/*public boolean update(Voto voto) {

		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = Jdbc.getConnection();
			ps = con.prepareStatement(QUERIES.getProperty("UPDATE_VOTE"));

			ps.setLong(1, voto.getTotVotos());
			ps.setLong(2, voto.getIdOpcion());
			ps.setLong(3, voto.getIdColElect());

			int num = ps.executeUpdate();

			return (num > 0);

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			Jdbc.close(con, ps);
		}
		return false;

	}
*/
	public boolean incrementarVoto(Voto voto) {

		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		try {

			con = Jdbc.getConnection();
			/*
			ps = con.prepareStatement(QUERIES.getProperty("UPDATE_VOTE"));

			//ps.setLong(1, voto.getTotVotos() + 1);
			ps.setLong(2, voto.getIdOpcion());
			ps.setLong(3, voto.getIdColElect());
			
			int num = ps.executeUpdate();
			*/
			
			ps2 = con
					.prepareStatement("select definicion, codvotacion from opciones where id = ?");
			ps2.setLong(1, voto.getIdOpcion());
			ResultSet rs = ps2.executeQuery();
			Long codVota = 0L;
			String opcion = "";
			while (rs.next()) {
				opcion = rs.getString(1);
				codVota = rs.getLong(2);
			}

			ps3 = con
					.prepareStatement("insert into voto (id_colegio, id_eleccion, online, opcion) values(?, ?, ?, ?)");
			ps3.setLong(1, voto.getIdColElect());
			ps3.setLong(2, codVota);
			ps3.setBoolean(3, true);
			ps3.setString(4, opcion);

			int num=ps3.executeUpdate();

			return (num > 0);

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			Jdbc.close(con, ps);
		}
		return false;

	}

	public Voto find(Long idOpcion, Long idColElect) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Voto voto = null;

		try {

			con = Jdbc.getConnection();
			ps = con.prepareStatement(QUERIES.getProperty("FIND_VOTE"));
			ps.setLong(1, idOpcion);
			ps.setLong(2, idColElect);

			rs = ps.executeQuery();

			if (rs.next()) {

				String opc = rs.getString("OPCION");
				voto = new Voto(idOpcion, idColElect, opc);

			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			Jdbc.close(rs, ps, con);
		}

		return voto;
	}

}
