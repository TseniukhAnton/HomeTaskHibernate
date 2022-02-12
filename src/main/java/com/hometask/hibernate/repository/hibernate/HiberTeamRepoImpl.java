package com.hometask.hibernate.repository.hibernate;

import com.hometask.hibernate.model.Team;
import com.hometask.hibernate.repository.TeamRepository;
import com.hometask.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HiberTeamRepoImpl implements TeamRepository {
    @Override
    public Team getById(Integer id) {
        Session session = null;
        Team team = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            team = session.get(Team.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return team;
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
    public List<Team> getAll() {
        Session session = null;
        List teams = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            teams = session.createQuery("FROM Team").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return teams;
    }

    @Override
    public void save(Team team) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(team);
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
    public boolean update(Team team) {
        Session session = null;
        Transaction transaction = null;

        if (getById(team.getId()) == null) {
            return false;
        }

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(team);
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
