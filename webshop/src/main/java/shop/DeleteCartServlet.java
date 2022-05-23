package shop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteCartServlet
 */
@WebServlet("/DeleteCartServlet")
public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		CartArrayBean cartArrayBean = 
				(CartArrayBean)session.getAttribute("cartArrayBean");
		
		
		String ShohinCode = request.getParameter("code"); //商品コード
		// = new CartArrayBean();
		
		cartArrayBean.delCartArray(ShohinCode);
		//cartArrayBean.delCartArray(getServletInfo());
		//cartArrayBean.delCartArray(getServletInfo());
		
		session.setAttribute("cartArrayBean", cartArrayBean);

		response.sendRedirect("shohin_cart.jsp");

	}


}
