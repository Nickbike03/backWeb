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
import org.unical.webapplication.notes4unical.model.CorsoDiStudio;
import org.unical.webapplication.notes4unical.persistence.DBManager;
import org.unical.webapplication.notes4unical.persistence.dao.CorsoDiStudioDao;

@Repository
@Component
public class CorsoDiStudioDaoJDBCComponent implements CorsoDiStudioDao {

    Connection connection;

    public CorsoDiStudioDaoJDBCComponent(){
        this.connection = DBManager.getInstance().getConnection();
    }

    @Override
    public List<CorsoDiStudio> findAll() {
        List<CorsoDiStudio> corsoDiStudi = new ArrayList<CorsoDiStudio>();
        String sql = "SELECT * FROM corso_di_studio";
        Statement st = null;
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                CorsoDiStudio corso = new CorsoDiStudio();

                corso.setId(rs.getInt("id"));
                corso.setNome(rs.getString("nome"));
                corso.setFacoltà(rs.getString("facolta"));
                corso.setData(rs.getDate("data"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return corsoDiStudi;
    }

    @Override
    public CorsoDiStudio findByPrimaryKey(int id) {
        String sql = "SELECT * FROM corso_di_studio WHERE id = ?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                CorsoDiStudio corso = new CorsoDiStudio();

                corso.setId(rs.getInt("id"));
                corso.setNome(rs.getString("nome"));
                corso.setFacoltà(rs.getString("facolta"));
                corso.setData(rs.getDate("data"));
                return corso;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(CorsoDiStudio corsoDiStudio) {
        try {
            // Verifica esistenza
            String checkQuery = "SELECT COUNT(*) FROM corso_di_studio WHERE id = ?";
            PreparedStatement checkStmt = connection.prepareStatement(checkQuery);
            checkStmt.setInt(1, corsoDiStudio.getId());
            ResultSet rs = checkStmt.executeQuery();
            
            if (rs.next() && rs.getInt(1) > 0) {
                throw new RuntimeException("Corso di studio con ID " + corsoDiStudio.getId() + " già esistente");
            }

            // Inserimento
            String insertQuery = "INSERT INTO corso_di_studio (nome, facolta, data) VALUES (?, ?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
            insertStmt.setString(1, corsoDiStudio.getNome());
            insertStmt.setString(2, corsoDiStudio.getFacoltà());
            insertStmt.setDate(3, new java.sql.Date(corsoDiStudio.getData().getTime()));
            
            insertStmt.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException("Errore durante il salvataggio del corso di studio", e);
        }
    }

    @Override
    public void delete(CorsoDiStudio corsoDiStudio) {
        try {
            // Verifica esistenza
            String checkQuery = "SELECT COUNT(*) FROM corso_di_studio WHERE id = ?";
            PreparedStatement checkStmt = connection.prepareStatement(checkQuery);
            checkStmt.setInt(1, corsoDiStudio.getId());
            ResultSet rs = checkStmt.executeQuery();
            
            if (rs.next() && rs.getInt(1) == 0) {
                throw new RuntimeException("Corso di studio con ID " + corsoDiStudio.getId() + " non trovato");
            }

            // Eliminazione
            String deleteQuery = "DELETE FROM corso_di_studio WHERE id = ?";
            PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery);
            deleteStmt.setInt(1, corsoDiStudio.getId());
            deleteStmt.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException("Errore durante l'eliminazione del corso di studio", e);
        }
    }
    
}
