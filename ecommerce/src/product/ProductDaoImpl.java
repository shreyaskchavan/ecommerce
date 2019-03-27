package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DatabaseManager;

public class ProductDaoImpl implements ProductDao {

	Connection con;

	public ProductDaoImpl() {
		super();
	}

	public ProductDaoImpl(Connection con) {
		super();
		this.con = con;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	@Override
	public String insert(ProductDto pdto) {
		String result = "Data entered successfully";

		String sql = "insert into product(catid, subcatid, uname, title, description, price, picture1, picture2, dou, status) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = DatabaseManager.getPreparedStatement(con, sql);

		try {
			ps.setString(1, pdto.getCatid());
			ps.setString(2, pdto.getSubcatid());
			ps.setString(3, pdto.getUname());
			ps.setString(4, pdto.getTitle());
			ps.setString(5, pdto.getDescription());
			ps.setDouble(6, pdto.getPrice());
			ps.setString(7, pdto.getPicture1());
			ps.setString(8, pdto.getPicture2());
			ps.setDate(9, pdto.getDou());
			ps.setString(10, pdto.getStatus());

			ps.executeUpdate();

		} catch (SQLException e) {
			result = "Data not entered successfully";
			e.printStackTrace();
		}

		return result;
	}

	public List<ProductDto> searchByKey(String searchKey) {
		ArrayList<ProductDto> ar = new ArrayList<>();
		String sql = "select * from product where description like '%" + searchKey + "%'";
		PreparedStatement ps = DatabaseManager.getPreparedStatement(con, sql);
		try {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductDto pdto = new ProductDto(rs.getLong("productid"), rs.getString("catid"),
						rs.getString("subcatid"), rs.getString("uname"), rs.getString("title"),
						rs.getString("description"), rs.getString("picture1"), rs.getString("picture2"),
						rs.getString("status"), rs.getDouble("price"), rs.getDate("dou"));

				ar.add(pdto);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ar;
	}

	@Override
	public ProductDto searchById(String searchId) {
		long id = Long.parseLong(searchId);
		ProductDto pdto = null;
		String sql = "select * from product where productId = ?";

		PreparedStatement ps = DatabaseManager.getPreparedStatement(con, sql);
		try {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				pdto = new ProductDto(rs.getLong("productid"), rs.getString("catid"), rs.getString("subcatid"),
						rs.getString("uname"), rs.getString("title"), rs.getString("description"),
						rs.getString("picture1"), rs.getString("picture2"), rs.getString("status"),
						rs.getDouble("price"), rs.getDate("dou"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pdto;
	}

}
