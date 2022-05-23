package shop;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShohinDetailServlet
 */
@WebServlet("/ShohinDetailServlet")
public class ShohinDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String a = "SELECT * FROM SHOHIN WHERE SHOHIN_CODE = ?";
		String code = request.getParameter("code");
		ShohinArrayBean shohinBean = new ShohinArrayBean();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2a1_sampledb","root","kazuma966")){
			String sql = "SELECT * FROM SHOHIN WHERE SHOHIN_CODE = '"+ code +"'";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				//検索結果がある場合は所品情報を取得
				ShohinBean sh = new ShohinBean();
				sh.setCode(rs.getString("SHOHIN_CODE"));
				sh.setImage(rs.getString("SHOHIN_IMAGE"));
				sh.setName(rs.getString("SHOHIN_NAME"));
				sh.setVol(rs.getString("SHOHIN_VOL"));
				sh.setPrice(rs.getInt("SHOHIN_PRICE"));
				sh.setArea(rs.getString("SHOHIN_AREA"));
				sh.setComment(rs.getString("SHOHIN_COMMENT"));
				
				shohinBean.addShohinHistoryArray(sh);
			}else {
				throw new SQLException("商品コードが見つかりません");
			}
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		HttpSession session = request.getSession();
		session.setAttribute("shohinBean", shohinBean);

		response.sendRedirect("shohin_detail.jsp");

	}
	

}
