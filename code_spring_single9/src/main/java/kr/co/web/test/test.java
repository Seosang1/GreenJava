package kr.co.web.test;
import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
   public static void main(String[] args) throws ClassNotFoundException, SQLException {
      String url = "jdbc:mariadb://127.0.0.1:3306/test";
      String sql = "SELECT * FROM testTable";

                // 클래스를 객체화, 드라이버를 로드
      Class.forName("org.mariadb.jdbc.Driver");
                // 실행 도구 생성
      Connection con = DriverManager.getConnection(url, "root", "7058");
                // 연결 객체를 얻음
      Statement st = con.createStatement();
                // 쿼리를 실행하여 결과 집합을 얻어온다.
      ResultSet rs = st.executeQuery(sql);

      if(rs.next()) { // 다음 값을 가져옴 Bof ~ Eof
         String ex1 = rs.getString("name");
         System.out.println(ex1);
         
         
      }

      rs.close();
      st.close();
      con.close();
   }
}


