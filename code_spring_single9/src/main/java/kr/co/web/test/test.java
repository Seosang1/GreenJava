package kr.co.web.test;
import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
   public static void main(String[] args) throws ClassNotFoundException, SQLException {
      String url = "jdbc:mariadb://127.0.0.1:3306/shopingmall";
      String sql = "SELECT * FROM testTable";

                // �대���ㅻ�� 媛�泥댄��, ���쇱�대�瑜� 濡���
      Class.forName("org.mariadb.jdbc.Driver");
                // �ㅽ�� ��援� ����
      Connection con = DriverManager.getConnection(url, "root", "root");
                // �곌껐 媛�泥대�� �살��
      Statement st = con.createStatement();
                // 荑쇰━瑜� �ㅽ������ 寃곌낵 吏��⑹�� �살�댁�⑤��.
      ResultSet rs = st.executeQuery(sql);

      if(rs.next()) { // �ㅼ�� 媛��� 媛��몄�� Bof ~ Eof
         String ex1 = rs.getString("name");
         System.out.println(ex1);
         
         
      }

      rs.close();
      st.close();
      con.close();
   }
}


