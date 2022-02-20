package com.hometask.hibernate.repository.hibernate;

import com.hometask.hibernate.model.Team;
import com.hometask.hibernate.repository.TeamRepository;
import com.hometask.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HiberTeamRepoImpl implements TeamRepository {
    @Override
    public Team getById(Integer id) {
        Team team = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("FROM Team where id = :id");
            query.setParameter("id", id);
            List teams =  query.getResultList();
            team = (Team) teams.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return team;
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
    public List<Team> getAll() {
        List teams = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            teams = session.createQuery("FROM Team t JOIN FETCH t.developers td").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teams;
    }

    @Override
    public Team save(Team team) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(team);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return team;

    }

    @Override
    public Team update(Team team) {
        Transaction transaction = null;

        if (getById(team.getId()) == null) {
            return null;
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.update(team);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
        return team;
    }
}
