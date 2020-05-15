package com.lilJade.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lilJade.dao.TbUsuarioDao;
import com.lilJade.model.TbUsuario;

/**
 * Servlet implementation class servletLogin
 */
public class servletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u = request.getParameter("usser");
		String p = request.getParameter("pass");
		String closeSession = request.getParameter("btnClose");

		if(closeSession != null) {
			if(closeSession.equals("Cerrar Sesion")) {
				HttpSession close = (HttpSession) request.getSession();
				close.invalidate();
				
				response.sendRedirect("index.jsp");
			}
		} else {
			TbUsuario tbu = new TbUsuario();
			TbUsuarioDao ud = new TbUsuarioDao();
			
			tbu.setUsser(u);
			tbu.setContra(p);
			
			int access = ud.logInUser(tbu).size();
			
			if(access == 1) {
				HttpSession seccion = request.getSession(true);
				seccion.setAttribute("usuario", u);
				response.sendRedirect("index.jsp");
			} else {
				System.out.println("¡Error!");
			}
		}
	}
}