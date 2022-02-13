package com.hometask.hibernate.repository.hibernate;

import com.hometask.hibernate.model.Skill;
import com.hometask.hibernate.repository.SkillRepository;
import com.hometask.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HiberSkillRepoImpl implements SkillRepository {
    @Override
    public Skill getById(Integer id) {
        Session session = null;
        Skill skill = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            skill = session.get(Skill.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return skill;
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
    public List<Skill> getAll() {
        Session session = null;
        List skills = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            skills = session.createQuery("FROM Skill").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return skills;
    }

    @Override
    public void save(Skill skill) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(skill);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public boolean update(Skill skill) {

        Transaction transaction = null;
        if (getById(skill.getId()) == null) {
            return false;
        }
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(skill);
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
}
