package com.edutecno.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.edutecno.dao.UsuarioDAO;
import com.edutecno.modelo.Usuario;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchSvl
 */
@WebServlet("/search")
public class SearchSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private UsuarioDAO usuarioDAO = new UsuarioDAO();


    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchTerm = request.getParameter("search");
        List<Usuario> usuarios;
        //Mediante el url en index.jsp, mando directament el empty.
        try {
            if (searchTerm == null || searchTerm.isEmpty()) {
                usuarios = usuarioDAO.getAllUsuarios();
            } else {
                usuarios = usuarioDAO.searchUsuarios(searchTerm);
            }
            request.setAttribute("usuarios", usuarios);
            RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("index.jsp");
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
