package com.lilJade.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.lilJade.dao.TbConsultaDao;
import com.lilJade.model.TbConsulta;

/**
 * Servlet implementation class servletControl
 */
public class servletControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TbConsulta tbc = new TbConsulta();
		TbConsultaDao tbcd = new TbConsultaDao();

		String id = null;
		String nombre = null;
		String apellido = null;
		
		try {
			id = request.getParameter("id");
			nombre = request.getParameter("nombre");
			apellido = request.getParameter("apellido");
			System.out.println(id +" "+ nombre + " " + apellido);
			
			
			tbc.setId(Integer.parseInt(id));
			tbc.setNombre(nombre);
			tbc.setApellido(apellido);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		String acttion = request.getParameter("btn");
		
		if(acttion.equals("ACTUALIZAR")){
			tbc.setId(Integer.parseInt(id));
			tbc.setNombre(nombre);
			tbc.setApellido(apellido);
			
			tbcd.actualizarConsulta(tbc);
		} else if(acttion.equals("ELIMINAR")){
			tbc.setId(Integer.parseInt(id));

			tbcd.eliminarConsulta(tbc);
		}
		
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TbConsultaDao tbcd = new TbConsultaDao();
		Gson json = new Gson();
		
		try {
			response.getWriter().append(json.toJson(tbcd.listaConsulta()));
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
