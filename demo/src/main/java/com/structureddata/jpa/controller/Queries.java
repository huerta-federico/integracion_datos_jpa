package com.structureddata.jpa.controller;

import java.util.List;

import javax.persistence.EntityManager;

import com.structureddata.jpa.entity.JpaUtil;

public class Queries {

    // Obtiene el nombre y correo de cada usuario. Ordenado por nombre de usuario.
    public List<Object[]> getAllUsers() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.createQuery("SELECT u.name, u.email FROM User u ORDER BY u.name", Object[].class).getResultList();
        } finally {
            em.close();
        }
    }

    // Obtiene el título de cada video con su respectivo nombre de usuario. Ordenado
    // por nombre de usuario.
    public List<Object[]> getVideoTitlesByUser() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.createQuery("SELECT u.name, v.title FROM User u JOIN u.videos v ORDER BY u.name", Object[].class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    // Obtiene el nombre de cada categoría y los títulos de los videos que
    // pertenecen a cada categoría. Ordenado por el nombre de categoría.
    public List<Object[]> getVideoCategories() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em
                    .createQuery("SELECT c.name, v.title FROM Video v JOIN v.categories c ORDER BY c.name",
                            Object[].class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    // Obtiene la biografía y la "imagen de perfil" de los usuarios que han subido
    // un video en la categoría educación.
    public List<Object[]> getUserProfileForEducationVideos() {
        EntityManager em = JpaUtil.getEntityManager();
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

    // Obtiene el nombre de categoría y videos que pertenecen a cada una, con su
    // respectivo título y descripción, además, el nombre y biografía del usuario
    // que lo subió. Ordenado por nombre de categoría.
    public List<Object[]> getDetailedVideoInfo() {
        EntityManager em = JpaUtil.getEntityManager();
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
