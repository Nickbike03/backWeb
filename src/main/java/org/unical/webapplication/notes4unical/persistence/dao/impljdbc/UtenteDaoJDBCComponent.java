package org.unical.webapplication.notes4unical.persistence.dao.impljdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.unical.webapplication.notes4unical.model.Utente;
import org.unical.webapplication.notes4unical.persistence.DBManager;
import org.unical.webapplication.notes4unical.persistence.dao.UtenteDao;

@Component
@Repository
public class UtenteDaoJDBCComponent implements UtenteDao {

    Connection connection;


    public UtenteDaoJDBCComponent(){
        this.connection = DBManager.getInstance().getConnection();
    }


    @Override
    public List<Utente> findAll() {
       List<Utente> utenti = new ArrayList<Utente>();
       String sql = "SELECT * FROM utente";
       Statement st = null;
       try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                Utente utente = new Utente();
                utente.setEmail(rs.getString("email"));
                utente.setNome(rs.getString("nome"));
                utente.setCognome(rs.getString("cognome"));
                utente.setCorsoDiStudio(rs.getInt("id_corsodistudio"));

                utenti.add(utente);
            }
       } catch (Exception e) {
        e.printStackTrace();
       }
       return utenti;
    }

    @Override
    public Utente findByEmail(String email) {
        String sql = "SELECT * FROM utente WHERE email = ?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, email);
            ResultSet rs = st.executeQuery();

            if (rs.next()){
                Utente utente = new Utente();
                utente.setEmail(rs.getString("email"));
                utente.setNome(rs.getString("nome"));
                utente.setCognome(rs.getString("cognome"));
                utente.setCorsoDiStudio(rs.getInt("id_corsodistudio"));

                return utente;

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Utente utente) {
        try {
            // Verifica se esiste già un utente con la stessa email
            String checkQuery = "SELECT COUNT(*) FROM utente WHERE email = ?";
            PreparedStatement checkStmt = connection.prepareStatement(checkQuery);
            checkStmt.setString(1, utente.getEmail());
            ResultSet rs = checkStmt.executeQuery();
            
            if (rs.next() && rs.getInt(1) > 0) {
                throw new RuntimeException("Utente con email " + utente.getEmail() + " già esistente");
            }

            // Se non esiste, procedi con l'inserimento
            String insertQuery = "INSERT INTO utente (email, nome, cognome, id_corsodistudio) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
            insertStmt.setString(1, utente.getEmail());
            insertStmt.setString(2, utente.getNome());
            insertStmt.setString(3, utente.getCognome());
            insertStmt.setInt(4, utente.getCorsoDiStudio());
            
            insertStmt.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException("Errore durante il salvataggio dell'utente", e);
        }
    }

    @Override
    public void delete(Utente utente) {
        try {
            // Verifica esistenza utente
            String checkQuery = "SELECT COUNT(*) FROM utente WHERE email = ?";
            PreparedStatement checkStmt = connection.prepareStatement(checkQuery);
            checkStmt.setString(1, utente.getEmail());
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next() && rs.getInt(1) == 0) {
                throw new RuntimeException("Utente con email " + utente.getEmail() + " non trovato");
            }

            // Procedi con eliminazione
            String deleteQuery = "DELETE FROM utente WHERE email = ?";
            PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery);
            deleteStmt.setString(1, utente.getEmail());
            deleteStmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Errore durante l'eliminazione dell'utente", e);
        }
    }
    
}
