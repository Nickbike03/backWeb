package org.unical.webapplication.notes4unical.persistence.dao.impljdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.unical.webapplication.notes4unical.model.Documento;
import org.unical.webapplication.notes4unical.persistence.DBManager;
import org.unical.webapplication.notes4unical.persistence.dao.DocumentoDao;

@Repository
@Component
public class DocumentoDaoJDBCComponent implements DocumentoDao {

    Connection connection;

    public DocumentoDaoJDBCComponent(){
        this.connection = DBManager.getInstance().getConnection();
    }

    @Override
    public List<Documento> findAll() {
        List<Documento> documenti = new ArrayList<Documento>();
        String sql = "SELECT * FROM documento";
        Statement st = null;
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                Documento doc = new Documento();

                doc.setId(rs.getInt("id"));
                doc.setUtente(rs.getString("utente"));
                doc.setNome(rs.getString("nome"));
                doc.setDestrizione(rs.getString("descrizione"));
                doc.setMateria(rs.getString("materia"));
                doc.setContenuto(rs.getBytes("contenuto"));
            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return documenti;
    }

    

    @Override
    public Documento findByPrimarykey(int id) {
        String sql = "SELECT * FROM documento WHERE id = ?";
         try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()){
                Documento doc = new Documento();

                doc.setId(rs.getInt("id"));
                doc.setUtente(rs.getString("utente"));
                doc.setNome(rs.getString("nome"));
                doc.setDestrizione(rs.getString("descrizione"));
                doc.setMateria(rs.getString("materia"));
                doc.setContenuto(rs.getBytes("contenuto"));

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Documento documento) {
        String sql = "INSERT INTO documento (id, utente, nome, descrizione, materia, contenuto) VALUES (?, ?, ?, ?, ?, ?) ";
        try (PreparedStatement st = connection.prepareStatement(sql)){
            st.setInt(1, documento.getId());
            st.setString(2, documento.getUtente());
            st.setString(3, documento.getNome());
            st.setString(4, documento.getDestrizione());
            st.setString(5, documento.getMateria());
            st.setBytes(6, documento.getContenuto() );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void delete(Documento documento) {
        try {
            // Verifica esistenza utente
            String checkQuery = "SELECT COUNT(*) FROM documento WHERE id = ?";
            PreparedStatement checkStmt = connection.prepareStatement(checkQuery);
            checkStmt.setInt(1, documento.getId());
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next() && rs.getInt(1) == 0) {
                throw new RuntimeException("Documento con Id: " + documento.getId()+ " non trovato");
            }

            // Procedi con eliminazione
            String deleteQuery = "DELETE FROM documeto WHERE id = ?";
            PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery);
            deleteStmt.setInt(1, documento.getId());
            deleteStmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Errore durante l'eliminazione dell'utente", e);
        }
    }
    

    @Override
    public List<Documento> findByMateria(String materia) {
        String sql = "SELECT * FROM documento WHERE materia = ?";
         try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, materia);
            ResultSet rs = st.executeQuery();

            if (rs.next()){
                Documento doc = new Documento();

                doc.setId(rs.getInt("id"));
                doc.setUtente(rs.getString("utente"));
                doc.setNome(rs.getString("nome"));
                doc.setDestrizione(rs.getString("descrizione"));
                doc.setMateria(rs.getString("materia"));
                doc.setContenuto(rs.getBytes("contenuto"));

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
