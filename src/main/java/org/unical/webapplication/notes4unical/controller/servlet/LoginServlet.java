package org.unical.webapplication.notes4unical.controller.servlet;

import java.io.IOException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.unical.webapplication.notes4unical.model.Utente;
import org.unical.webapplication.notes4unical.service.IUtenteService;
import org.unical.webapplication.notes4unical.service.UtenteService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@CrossOrigin(origins = "http://localhost:4200")
@WebServlet("/doLogin")
public class LoginServlet extends HttpServlet {
    private final IUtenteService utenteService;
    
    public LoginServlet(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            System.out.println("Sono entrato nel controoler della registrazione");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            Utente utente = utenteService.findByEmail(username);
            if (utente != null && utente.getPasword() == password){

                req.getSession(true).setAttribute("username", username);
                resp.sendRedirect("/");
                
            }else{
                RequestDispatcher dispatcher = req.getRequestDispatcher("/");
                dispatcher.forward(req, resp);
            }
        }catch (ServletException e) {
            e.printStackTrace();
    }

    }
}


