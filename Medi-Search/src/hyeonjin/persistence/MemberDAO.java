package hyeonjin.persistence;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import hyeonjin.domain.MemberVO;


public class MemberDAO {
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
	public boolean add(MemberVO vo) {
		connect();
		String sql = "insert into userDB values(?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMemberID());
			pstmt.setString(2, vo.getMemberPassword());
			pstmt.setString(3, vo.getMemberName());
			pstmt.setString(4, vo.getMemberAge());
			pstmt.setString(5, vo.getMemberMobile());
			pstmt.setString(6, vo.getMemberGender());
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
	public MemberVO login(MemberVO memberVO) {
		connect();
		MemberVO loginmember = null;
		try {
			String sql = "select * from userDB where id=? and passwd=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberVO.getMemberID());
			pstmt.setString(2,  memberVO.getMemberPassword());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				loginmember = new MemberVO();
				loginmember.setMemberID(rs.getString("id"));
				loginmember.setMemberPassword(rs.getString("passwd"));
				loginmember.setMemberName(rs.getString("username"));
				loginmember.setMemberAge(rs.getString("userage"));
				loginmember.setMemberMobile(rs.getString("mobile"));
				loginmember.setMemberGender(rs.getString("gender"));
			}
			rs.close();
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		return loginmember;
	}
	public MemberVO read(String id)

	{
		connect();
		MemberVO member = new MemberVO();
		String sql = "select * from userDB where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs1 = pstmt.executeQuery();
			while(rs1.next())
			{
				member.setMemberID(rs1.getString("id"));
				member.setMemberPassword(rs1.getString("passwd"));
				member.setMemberName(rs1.getString("username"));
				member.setMemberAge(rs1.getString("userage"));
				member.setMemberMobile(rs1.getString("mobile"));
				member.setMemberGender(rs1.getString("gender"));
			}
			rs1.close();
		}
			catch(SQLException e)
			{
				e.printStackTrace();
			}finally {
				disconnect();
			}
		
		return member;
	}
	public boolean update(MemberVO vo)
	{
		connect();
		String sql = "update userDB set passwd=?, username=?, userage=?, mobile=?, gender=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMemberPassword());
			pstmt.setString(2, vo.getMemberName());
			pstmt.setString(3, vo.getMemberAge());
			pstmt.setString(4, vo.getMemberMobile());
			pstmt.setString(5, vo.getMemberGender());
			pstmt.setString(6, vo.getMemberID());
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
