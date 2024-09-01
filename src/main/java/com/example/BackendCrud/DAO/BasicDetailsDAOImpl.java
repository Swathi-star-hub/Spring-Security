package com.example.BackendCrud.DAO;
import com.example.BackendCrud.Utils.HibernateUtil;
import com.example.BackendCrud.entity.FamilyDtls;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BasicDetailsDAOImpl implements BasicDetailsDAO  {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BasicDetailsDAOImpl.class);

    @Autowired
    private HibernateUtil hibernateUtils;

    @Override
    public FamilyDtls getFamilyDtlsBymebId(Integer mebId) {
        Session session = hibernateUtils.getSessionFactory().openSession();
        FamilyDtls result = null;
        try {
            String hql = "select fd from com.example.BackendCrud.entity.FamilyDtls  fd where fd.mebId=:mebId";
            Query<FamilyDtls> query =session.createQuery(hql);
            query.setParameter("mebId",mebId);
            result = query.getSingleResult();
        }catch(Exception e) {
            logger.error("Error occured in BasicDetailsDAO",e);
        }finally{
            session.close();
        }
        return result;
    }
    }


