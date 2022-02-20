package com.hometask.hibernate.repository.hibernate;

import com.hometask.hibernate.model.Skill;
import com.hometask.hibernate.repository.SkillRepository;
import com.hometask.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HiberSkillRepoImpl implements SkillRepository {
    @Override
    public Skill getById(Integer id) {
        Skill skill = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("FROM Skill where id = :id");
            query.setParameter("id", id);
            List skills = query.getResultList();
            skill = (Skill) skills.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return skill;
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
    public List<Skill> getAll() {
        List skills = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            skills = session.createQuery("FROM Skill s JOIN FETCH s.developers sd").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return skills;
    }

    @Override
    public Skill save(Skill skill) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(skill);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return skill;
    }

    @Override
    public Skill update(Skill skill) {
        Transaction transaction = null;
        if (getById(skill.getId()) == null) {
            return null;
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
            return null;
        }
        return skill;
    }
}
