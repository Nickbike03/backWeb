package org.unical.webapplication.notes4unical.persistence.dao.impljdbc;

import java.sql.Connection;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public CorsoDiStudio findByPrimaryKey(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPrimaryKey'");
    }

    @Override
    public void save(CorsoDiStudio corsoDiStudio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void delete(CorsoDiStudio corsoDiStudio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
