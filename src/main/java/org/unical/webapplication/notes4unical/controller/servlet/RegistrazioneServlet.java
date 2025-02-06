package org.unical.webapplication.notes4unical.controller.servlet;

import java.io.IOException;

import org.unical.webapplication.notes4unical.model.Utente;
import org.unical.webapplication.notes4unical.service.UtenteService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registrazione")
public class RegistrazioneServlet extends HttpServlet {
    
    private UtenteService utenteService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            // Recupera i parametri dal form
            String email = request.getParameter("email");
            String nome = request.getParameter("nome");
            String cognome = request.getParameter("cognome");
            int corsoDiStudio = Integer.parseInt(request.getParameter("corsoDiStudio"));

            // Crea nuovo utente
            Utente utente = new Utente();
            utente.setEmail(email);
            utente.setNome(nome);
            utente.setCognome(cognome);
            utente.setCorsoDiStudio(corsoDiStudio);

            // Salva utente
            utenteService.createUtente(utente);

            // Redirect a pagina di successo
            response.sendRedirect("login.jsp");

        } catch (Exception e) {
            // Gestione errori
            request.setAttribute("error", "Errore durante la registrazione: " + e.getMessage());
            request.getRequestDispatcher("registrazione.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Mostra form di registrazione
        request.getRequestDispatcher("registrazione.jsp").forward(request, response);
    }
}
