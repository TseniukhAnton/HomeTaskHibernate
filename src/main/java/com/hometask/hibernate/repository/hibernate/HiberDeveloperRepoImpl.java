package com.hometask.hibernate.repository.hibernate;

import com.hometask.hibernate.model.Developer;
import com.hometask.hibernate.repository.DeveloperRepository;
import com.hometask.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HiberDeveloperRepoImpl implements DeveloperRepository {
    @Override
    public Developer getById(Integer id) {
        Session session = null;
        Developer developer = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            developer = session.get(Developer.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return developer;
    }

    @Override
    public boolean deleteById(Integer id) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            if (getById(id) == null) {
                return false;
            }
            session.delete(getById(id));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return true;
    }

    @Override
    public List<Developer> getAll() {
        Session session = null;
        List developers = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            developers = session.createQuery("FROM Developer").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return developers;
    }

    @Override
    public void save(Developer developer) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(developer);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public boolean update(Developer developer) {
        Session session = null;
        Transaction transaction = null;

        if (getById(developer.getId()) == null) {
            return false;
        }

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(developer);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
            return false;
        }finally {
            if (session!=null){
                session.close();
            }
        }

        return true;
    }
}
