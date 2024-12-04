package com.edutecno.servlets;

import java.io.IOException;
import java.time.LocalDate;

import com.edutecno.dao.UsuarioDAO;
import com.edutecno.modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterSvl
 */
@WebServlet("/register")
public class RegisterSvl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterSvl() {
        super();
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
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String clave = request.getParameter("clave");
        String confirmclave = request.getParameter("confirmclave");
        LocalDate fecha_nacimiento = LocalDate.parse(request.getParameter("fecha_nacimiento"));

        //Confirmacion de clave, super comun en otros form de registros.
        if (!clave.equals(confirmclave)) {
            request.setAttribute("errorMessage", "Las contraseñas no coinciden. Por favor, inténtelo de nuevo.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
            return;
        }
        //Evito el unique de username
        if (usuarioDAO.existsByUsername(username)) {
            request.setAttribute("errorMessage", "El nombre de usuario ya existe. Por favor, elija otro o ingrese a su cuenta.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
            return;
        }
        //Lo mismo pero email
        if (usuarioDAO.existsByEmail(email)) {
            request.setAttribute("errorMessage", "El correo ya está en uso. Por favor, utilice otro o ingrese a su cuenta.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
            return;
        }
        //Añado y mando alerta por js
        try {
            Usuario newUser  = new Usuario(nombre, username, email, fecha_nacimiento, clave);

            usuarioDAO.addUsuario(newUser);

            request.setAttribute("successMessage", "Registro exitoso! Ahora puede iniciar sesion.");
            request.getRequestDispatcher("login.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Ocurrió un error durante el registro. Por favor, inténtelo de nuevo.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
    }
}