package member;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    private PreparedStatement pstmt;
    private Connection conn;
    private DataSource dataSource;

    public MemberDAO() {
        try {
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/mysql");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<MemberVO> listMembers() {
        List<MemberVO> list = new ArrayList<>();
        try {
//            connDB();
            conn = dataSource.getConnection();
            String query = "select * from DatabaseServlet.tMember";
            System.out.println("PreparedStatement query is " + query);
            pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery(query);
            while (rs.next()) {
                String id = rs.getString("id");
                String pwd = rs.getString("pwd");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date joinDate = rs.getDate("joinDate");

                MemberVO vo = new MemberVO();
                vo.setId(id);
                vo.setPwd(pwd);
                vo.setName(name);
                vo.setEmail(email);
                vo.setJoinDate(joinDate);

                list.add(vo);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addMember(MemberVO vo) {
        try {
            conn = dataSource.getConnection();
            String id = vo.getId();
            String password = vo.getPwd();
            String name = vo.getName();
            String email = vo.getEmail();

            String query = "insert into DatabaseServlet.tMember" +
                    " (id, pwd, name, email)" +
                    " values(?, ?, ?, ?)";

            System.out.println("prepareStatement: " + query);
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.setString(2, password);
            pstmt.setString(3, name);
            pstmt.setString(4, email);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delMember(String id) {
        try {
            conn = dataSource.getConnection();
            String query = "delete from DatabaseServlet.tMember where id=?";
            System.out.println("PrepareStatement: " + query);
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}