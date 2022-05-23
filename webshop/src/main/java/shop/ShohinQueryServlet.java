package shop;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class ShohinQueryServlet
 */
@WebServlet("/ShohinQueryServlet")
public class ShohinQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String keyword = request.getParameter("keyword");
		String s1 = request.getParameter("item1");
		String s2 = request.getParameter("item2");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		ShohinArrayBean shnArrayBean = new ShohinArrayBean();
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2a1_sampledb","root","kazuma966")){
				
			if (s2 == null) {
				String sql1 = "SELECT * FROM SHOHIN WHERE SHOHIN_NAME LIKE '%" + keyword + "%';";
				PreparedStatement pstmt1 = conn.prepareStatement(sql1);
				ResultSet rs1 = pstmt1.executeQuery(sql1);
				while (rs1.next()) {
					ShohinBean shb = new ShohinBean();
					shb.setImage( rs1.getString("SHOHIN_IMAGE"));
					shb.setName( rs1.getString("SHOHIN_NAME"));
					shb.setVol( rs1.getString("SHOHIN_VOL"));
					shb.setPrice( rs1.getInt("SHOHIN_PRICE"));
					shb.setComment( rs1.getString("SHOHIN_COMMENT"));
					shb.setCode(rs1.getString("SHOHIN_CODE"));
					shb.setArea(rs1.getString("SHOHIN_AREA"));
					//ShohinArrayBeanにレコード追加
					shnArrayBean.addShohinHistoryArray(shb);
				}
				rs1.close();
			}
	
			
			if(s1 == null) {
				String sql2 ="SELECT * FROM SHOHIN WHERE SHOHIN_PRICE = "+ keyword +"";
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				ResultSet rs2 = pstmt2.executeQuery(sql2);
				while (rs2.next()) {
					ShohinBean shb = new ShohinBean();
					shb.setImage( rs2.getString("SHOHIN_IMAGE"));
					shb.setName( rs2.getString("SHOHIN_NAME"));
					shb.setVol( rs2.getString("SHOHIN_VOL"));
					shb.setPrice( rs2.getInt("SHOHIN_PRICE"));
					shb.setComment( rs2.getString("SHOHIN_COMMENT"));
					shb.setCode( rs2.getString("SHOHIN_CODE"));
					shb.setArea(rs2.getString("SHOHIN_AREA"));
					//ShohinArrayBeanにレコード追加
					shnArrayBean.addShohinHistoryArray(shb);
					}
				rs2.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		
		HttpSession session = request.getSession();
		session.setAttribute("shnArrayBean", shnArrayBean);

		response.sendRedirect("shohin_retrieval.jsp");

	}

}
