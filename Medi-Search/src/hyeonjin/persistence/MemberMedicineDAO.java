package hyeonjin.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hyeonjin.domain.MedicineVO;
import hyeonjin.domain.MemberMedicineVO;

public class MemberMedicineDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost:3307/jspdb?useSSL=false&serverTimezone=UTC";
	
	void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url,"jspbook","passwd");
		} catch(Exception e) {
		e.printStackTrace();
		}
	}
	void disconnect() {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public boolean add(MemberMedicineVO vo) {
		connect();
		String sql = "insert into user_medicine values(?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getMedicineName());
			pstmt.executeUpdate();
		} catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
		
		}
	public ArrayList<MedicineVO> getUserMedicineList(String userid)
	{
		connect();
		ArrayList<MedicineVO> medicinelist = new ArrayList<MedicineVO>();
		String sql = "select medicine.medicineName, ingredient, period, effect, caution, company from medicine, user_medicine where user_medicine.userID=? and user_medicine.medicineName = medicine.medicineName";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				MedicineVO medicine = new MedicineVO();
				medicine.setMedicineName(rs.getString("medicineName"));
				medicine.setIngredient(rs.getString("ingredient"));
				medicine.setPeriod(rs.getString("period"));
				medicine.setEffect(rs.getString("effect"));
				medicine.setCaution(rs.getString("caution"));
				medicine.setCompany(rs.getString("company"));
				
				medicinelist.add(medicine);
			}
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return medicinelist;
	
	}
	public boolean search(MemberMedicineVO vo) {
		connect();
		String sql = "select medicineName from user_medicine where userID=? and medicineName=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getMedicineName());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				return false;
			}
		} catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
		
		}
	public boolean delete(MemberMedicineVO vo) {
		connect();
		String sql = "delete from user_medicine where userID=? and medicineName=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getMedicineName());
			pstmt.executeUpdate();
		} catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
		
	}
	
}
