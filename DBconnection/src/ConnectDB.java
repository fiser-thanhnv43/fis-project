/**
 * @author PortugalDAce
 * @version 1.0 Oct 28, 2015
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectDB {
	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/hoc_java", "root", "");
			System.out.println("connect success");
			System.out.println("cac cap yeu nha :");
			String query1 = "select name from user join love on user.idUser = love.idUser1;";
			String query2 = "select name from user join love on user.idUser = love.idUser2;";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query1);
			ArrayList<String> arrNu = new ArrayList<String>();
			ArrayList<String> arrNam = new ArrayList<String>();
			System.out.println(" Nam   --  Nu\n");
			while (rs.next()) {
				String nu = rs.getString("name");
				arrNu.add(nu);
			}
			rs = stmt.executeQuery(query2);
			while (rs.next()) {
				String nam = rs.getString("name");
				arrNam.add(nam);
			}
			int N = arrNu.size();
			for (int i = 0; i < N; i++) {
				System.out.println(" " + arrNam.get(i) + "\t" + arrNu.get(i));
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
