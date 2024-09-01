package com.example.BackendCrud.DAO;


import java.util.List;


import com.example.BackendCrud.Utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDAO {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CommonDAO.class);

    @Autowired
    HibernateUtil hibernateUtils;

    List<Object> saveEntities(List<Object> entities) {
        try (Session session = hibernateUtils.getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();
            for (Object entity : entities) {
                session.saveOrUpdate(entity);
            }
            tx.commit();

            return entities;
        } catch (Exception e) {
            logger.error("rolled back {} ", e);

            throw new HibernateException("Server might be down. Please try again later.");
        }
    }
}
