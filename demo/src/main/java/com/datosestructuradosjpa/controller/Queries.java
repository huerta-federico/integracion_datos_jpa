package com.datosestructuradosjpa.controller;

import java.util.List;
import com.datosestructuradosjpa.entity.JPAUtil;
import javax.persistence.EntityManager;

public class Queries {
    public List<Object[]> getAllUsers() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT u.name, u.email FROM User u ORDER BY u.name", Object[].class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Object[]> getVideoTitlesByUser() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT u.name, v.title FROM User u JOIN u.videos v ORDER BY u.name", Object[].class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Object[]> getVideoCategories() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT c.name, v.title FROM Video v JOIN v.categories c ORDER BY c.name", Object[].class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Object[]> getUserProfileForEducationVideos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT up.bio, up.profilePicture FROM UserProfile up " +
                    "JOIN up.user u " +
                    "JOIN u.videos v " +
                    "JOIN v.categories c " +
                    "WHERE c.name = 'Education'", Object[].class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Object[]> getDetailedVideoInfo() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT c.name, v.title, v.description, u.name, up.bio FROM Video v " +
                    "JOIN v.user u " +
                    "JOIN u.userProfile up " +
                    "JOIN v.categories c ORDER BY c.name", Object[].class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

}
