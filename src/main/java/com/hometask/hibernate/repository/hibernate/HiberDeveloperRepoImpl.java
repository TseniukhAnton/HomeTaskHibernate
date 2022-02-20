package com.hometask.hibernate.repository.hibernate;

import com.hometask.hibernate.model.Developer;
import com.hometask.hibernate.repository.DeveloperRepository;
import com.hometask.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HiberDeveloperRepoImpl implements DeveloperRepository {
    @Override
    public Developer getById(Integer id) {
        Developer developer = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("FROM Developer d JOIN FETCH d.skills ds where d.id = :id");
            query.setParameter("id", id);
            List developers =  query.getResultList();
            developer = (Developer) developers.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return developer;
    }

    @Override
    public boolean deleteById(Integer id) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
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
        }
        return true;
    }

    @Override
    public List<Developer> getAll() {
        List developers = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            developers = session.createQuery("FROM Developer d join fetch d.team dt").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return developers;
    }

    @Override
    public Developer save(Developer developer) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(developer);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return developer;

    }

    @Override
    public Developer update(Developer developer) {
        Transaction transaction = null;

        if (getById(developer.getId()) == null) {
            return null;
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.update(developer);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
        return developer;
    }
}
