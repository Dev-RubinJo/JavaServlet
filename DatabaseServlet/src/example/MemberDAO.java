package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberDAO {

    private Statement stmt;
    private Connection conn;

    public List<MemberVO> listMembers() {
        List<MemberVO> list = new ArrayList<>();
        try {
            connDB();
            String query = "select * from DatabaseServlet.tMember";
            ResultSet rs = stmt.executeQuery(query);
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
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private void connDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Success for Load Driver");

            String url = "jdbc:mysql://localhost:3306/DatabaseServlet?serverTimezone=UTC";
            String user = "rubin";
            String password = "PASSOWRD";

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Success for connect Mysql");

            stmt = conn.createStatement();
            System.out.println("Success for Create Stmt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
