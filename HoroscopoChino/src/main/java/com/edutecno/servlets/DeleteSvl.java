package com.edutecno.servlets;

import java.io.IOException;
import java.sql.SQLException;

import com.edutecno.dao.UsuarioDAO;
import com.edutecno.modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteSvl
 */
@WebServlet("/delete")
public class DeleteSvl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSvl() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            Usuario usuario = usuarioDAO.getUsuarioById(id);

            if (usuario != null) {
                request.setAttribute("u", usuario);
                request.getRequestDispatcher("/delete.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Usuario no encontrado.");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (SQLException e) {
			e.printStackTrace();
		}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//Pequeño verificador para eliminar el usuario. (Email no es la mejor opcion, pero mejor que nada.) Reutilizacion de DAO
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String email = request.getParameter("email");

            if (usuarioDAO.existsByEmail(email)) {
                usuarioDAO.deleteUsuario(id);
                HttpSession sesion = request.getSession(false);
                if (sesion != null) {
                    sesion.removeAttribute("userObj");
                    sesion.invalidate();
                }

                request.setAttribute("message", "Cuenta eliminada con éxito.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Credenciales incorrectas. Inténtalo de nuevo.");
                request.setAttribute("id", id);
                request.getRequestDispatcher("/delete.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
