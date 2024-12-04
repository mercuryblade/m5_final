package com.edutecno.servlets;

import java.io.IOException;

import com.edutecno.dao.UsuarioDAO;
import com.edutecno.modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginSvl
 */
@WebServlet("/login")
public class LoginSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDAO usuarioDAO = new UsuarioDAO();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");

	    //Verifico exactamente cual es form erroneo y le hago saber el usuario (Anteriorme rediriga a registro.jsp si el usuario no existia, pero muy molesto si hay input error)
	    try {
	        Usuario existingUser  = usuarioDAO.getUsuarioByUsername(username);
	        //Sigo la logica por la consola
	        if (existingUser  == null) {
	            System.out.println("Usuario no encontrado.");
	            request.setAttribute("error", "Usuario no encontrado. Intentelo de nuevo o registrese.");
	            request.getRequestDispatcher("login.jsp").forward(request, response);
	            return;
	        }

	        if (existingUser .getPass() == null || !existingUser .getPass().equals(password)) {
	            System.out.println("Contraseña incorrecta. Redirigiendo a login.");
	            request.setAttribute("error", "Clave inválida. Intentelo de nuevo.");
	            request.getRequestDispatcher("login.jsp").forward(request, response);
	            return;
	        }

	        System.out.println("Usuario encontrado: " + existingUser .getUser () + ", ID: " + existingUser .getId());
	        HttpSession sesion = request.getSession();
	        sesion.setAttribute("userObj", existingUser );
	        response.sendRedirect(request.getContextPath() + "/index.jsp");

	    } catch (Exception e) {
	        request.setAttribute("error", "Error: " + e.getMessage());
	        request.getRequestDispatcher("login.jsp").forward(request, response);
	    }
	}

}
