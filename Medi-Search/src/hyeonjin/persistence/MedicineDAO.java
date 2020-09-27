package hyeonjin.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import hyeonjin.domain.MedicineVO;


public class MedicineDAO {
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
	public ArrayList<MedicineVO> getMedicineList() {
		connect();
		ArrayList<MedicineVO> medicinelist = new ArrayList<MedicineVO>();
		String sql = "select * from medicine";
		try {
			pstmt = conn.prepareStatement(sql);
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
	public MedicineVO read(String medicineName)
	{
		connect();
		MedicineVO medicineVO = new MedicineVO();
		//String sql = "select * from student where id = " + "\""+ id+ "\"";
		String sql = "select * from medicine where medicineName=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, medicineName);
			ResultSet rs1 = pstmt.executeQuery();
			while(rs1.next())
			{
				medicineVO.setMedicineName(rs1.getString("medicineName"));
				medicineVO.setIngredient(rs1.getString("ingredient"));
				medicineVO.setPeriod(rs1.getString("period"));
				medicineVO.setEffect(rs1.getString("effect"));
				medicineVO.setCaution(rs1.getString("caution"));
				medicineVO.setCompany(rs1.getString("company"));
			}
			rs1.close();
		}
			catch(SQLException e)
			{
				e.printStackTrace();
			}finally {
				disconnect();
			}
		
		return medicineVO;
	}
	public ArrayList<MedicineVO> readAll(String medicineName)
	{
		connect();
		
		ArrayList<MedicineVO> medicinelist = new ArrayList<MedicineVO>();
		//String sql = "select * from student where id = " + "\""+ id+ "\"";
		String sql = "select * from medicine where medicineName like ?";
		String temp = "%" + medicineName + "%";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, temp);
			ResultSet rs1 = pstmt.executeQuery();
			while(rs1.next())
			{
				MedicineVO medicineVO = new MedicineVO();
				medicineVO.setMedicineName(rs1.getString("medicineName"));
				medicineVO.setIngredient(rs1.getString("ingredient"));
				medicineVO.setPeriod(rs1.getString("period"));
				medicineVO.setEffect(rs1.getString("effect"));
				medicineVO.setCaution(rs1.getString("caution"));
				medicineVO.setCompany(rs1.getString("company"));
				
				medicinelist.add(medicineVO);
			}
			rs1.close();
		}
			catch(SQLException e)
			{
				e.printStackTrace();
			}finally {
				disconnect();
			}
		
		return medicinelist;
	}
}
