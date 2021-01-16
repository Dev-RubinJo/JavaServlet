package example;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
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

//    private void connDB() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("Success for Load Driver");
//            String url = "jdbc:mysql://localhost:3306/DatabaseServlet?serverTimezone=UTC";
//            String user = "rubin";
//            String password = "PASSWORD";
//            conn = DriverManager.getConnection(url, user, password);
//            System.out.println("Success for connect Mysql");
//            stmt = conn.createStatement();
//            System.out.println("Success for Create Stmt");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
