package com.jobportal.dao;

import com.jobportal.entity.Company;
import com.jobportal.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class CompanyDAOImpl implements CompanyDAO{

    @Override
    public Company save(Company company) {

        Transaction tx = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            session.persist(company);
            tx.commit();
        } catch(Exception ex){
            if(tx != null){
                tx.rollback();
            }
            throw new RuntimeException("Unable to save company.",ex);
        }
        return company;
    }

    @Override
    public Optional<Company> findById(Long id) {
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            Company company = session.find(Company.class, id);
            tx.commit();
            return Optional.ofNullable(company);
        }  catch(Exception ex){
            if(tx != null){
                tx.rollback();
            }
            throw new RuntimeException("Unable to find company.",ex);
        }
    }

    @Override
    public List<Company> findAll() {
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            List<Company> companies = session.createQuery("FROM Company", Company.class)
                    .getResultList();
            tx.commit();
            return companies;
        } catch(Exception ex){
            if(tx != null){
                tx.rollback();

            }
            throw new RuntimeException("Unable to find all companies.",ex);
        }
    }

    @Override
    public Company update(Company company) {
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            Company merged =  session.merge(company);
            tx.commit();
            return merged;
        } catch(Exception ex){
            if(tx != null){
                tx.rollback();

            }
            throw new RuntimeException("Unable to update company.",ex);
        }
    }

    @Override
    public boolean delete(Long id) {
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){

            if(id == null){
                return false;
            }
            tx = session.beginTransaction();

            Company company = session.find(Company.class, id);
            if(company == null){
                tx.rollback();
                return false;
            }
            session.remove(company);
            tx.commit();
            return true;

        } catch(Exception ex){
            if(tx != null){
                tx.rollback();
            }
            throw new RuntimeException("Unable to delete company.",ex);
        }
    }
}
