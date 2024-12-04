package com.edutecno.servlets;

import java.io.IOException;

import com.edutecno.modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ChechHorokSvl
 */
@WebServlet("/animal")
public class ChechHorokSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChechHorokSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//No se que hacer...
		//Verificacion de usuario para entregar el animal?
		HttpSession sesion = request.getSession(false);

		if(sesion != null) {
			Usuario currentUser = (Usuario) sesion.getAttribute("userObj");

			if(currentUser != null) {
				String animal = currentUser.getAnimal();

				request.setAttribute("animal", animal);

				request.getRequestDispatcher("checkAnimal.jsp").forward(request, response);
			}else {
				System.out.println("error");
				response.sendRedirect("login.jsp");
			}
		}else {
			System.out.println("error 2");
			 response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
