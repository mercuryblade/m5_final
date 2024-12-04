package com.edutecno.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import com.edutecno.dao.UsuarioDAO;
import com.edutecno.modelo.Usuario;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/edit")
public class EditSvl extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int id = Integer.parseInt(request.getParameter("id"));
		Usuario u = null;
		try {
			u = usuarioDAO.getUsuarioById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("u", u);
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
		dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String fechaNacimiento = request.getParameter("fecha_nacimiento");
        String password = request.getParameter("password");

        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre(nombre);
        usuario.setUser(username);
        usuario.setEmail(email);
        usuario.setFecha_nacimiento(LocalDate.parse(fechaNacimiento));
        usuario.setPass(password);

        try {
        	usuario.setAnimal(usuario.getZodiac());

            Usuario currentUsuario = usuarioDAO.getUsuarioById(id);

            //Verifico si el usuario ha cambiado sus datos a unos existentes y poder entregar el error al usuario
            if (!currentUsuario.getUser().equals(username) && usuarioDAO.existsByUsername(username)) {
                request.setAttribute("error", "El username ya está en uso por otro usuario.");
                request.setAttribute("u", usuario);
                request.getRequestDispatcher("edit.jsp").forward(request, response);
                return;
            }

            if (!currentUsuario.getEmail().equals(email) && usuarioDAO.existsByEmail(email)) {
                request.setAttribute("error", "El email ya está en uso por otro usuario.");
                request.setAttribute("u", usuario);
                request.getRequestDispatcher("edit.jsp").forward(request, response);
                return;
            }

            usuarioDAO.updateUsuario(usuario);
            //Hago que el usuario inicie sesion nuevamente para actualizar el animal correctamente y obtener una nueva session
            HttpSession sesion = request.getSession(false);
            sesion.removeAttribute("userObj");
			sesion.invalidate();
            request.setAttribute("message", "Usuario actualizado con exito. Inicie sesion nuevamente");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Hubo un error al actualizar el usuario. Inténtelo más tarde.");
            request.setAttribute("u", usuario);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        }
    }


}
