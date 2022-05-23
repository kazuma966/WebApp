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
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code = request.getParameter("code"); //商品コード
		int quantity = Integer.parseInt(request.getParameter("quantity")); //数量
		CartBean  cb = new CartBean();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2a1_sampledb","root","kazuma966")){
			String sql = "SELECT * FROM SHOHIN WHERE SHOHIN_CODE = '"+ code +"'";;
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				cb.setName(rs.getString("SHOHIN_NAME"));
				cb.setVol(rs.getString("SHOHIN_VOL"));
				cb.setPrice(rs.getInt("SHOHIN_PRICE"));
				cb.setCode(rs.getString("SHOHIN_CODE"));				
				cb.setQuantity(quantity);
				cb.getQuantity();
			}
			
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		HttpSession session = request.getSession();
		CartArrayBean cartArrayBean = (CartArrayBean)session.getAttribute("cartArrayBean");
		if (cartArrayBean == null) {
			cartArrayBean = new CartArrayBean();
			session.setAttribute("cartArrayBean", cartArrayBean);
			
		}
		
		cartArrayBean.addcartArray(cb);
		response.sendRedirect("shohin_cart.jsp");
	}


}
