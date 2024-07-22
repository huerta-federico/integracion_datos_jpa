package com.structureddata.jpa.controller;

import java.util.List;

public class ConsolePrinter {

    // Crea el objeto Query que contiene la lógica de las consultas
    private Queries Query = new Queries();

    // Cada función ejecuta e imprime los resultados de cada consulta.
    public void printAllResults() {
        printAllUsers();
        printVideoTitlesByUser();
        printVideoCategories();
        printUserProfileForEducationVideos();
        printDetailedVideoInfo();
    }

    private void printAllUsers() {
        List<Object[]> results = Query.getAllUsers();
        System.out.println("\n----------------------------------------------------------------------");
        System.out.println("\n1. ¿Cuáles son los nombres y correos de todos los usuarios registrados?\n");
        for (Object[] row : results) {
            System.out.println("Nombre: " + row[0] + "\nEmail: " + row[1] + "\n");
        }
        System.out.println("----------------------------------------------------------------------");
    }

    private void printVideoTitlesByUser() {
        List<Object[]> results = Query.getVideoTitlesByUser();
        System.out.println("\n2. ¿Cuáles son los títulos de los videos publicados por cada usuario?\n");
        for (Object[] row : results) {
            System.out.println("Usuario: " + row[0] + "\tTítulo del video: " + row[1] + "\n");
        }
        System.out.println("----------------------------------------------------------------------");
    }

    private void printVideoCategories() {
        List<Object[]> results = Query.getVideoCategories();
        System.out.println("\n3. ¿Cuáles son las categorías a las que pertenece cada video?\n");
        for (Object[] row : results) {
            System.out.println("Categoría: " + row[0] + "\nTítulo del video: " + row[1] + "\n");
        }
        System.out.println("----------------------------------------------------------------------");
    }

    private void printUserProfileForEducationVideos() {
        List<Object[]> results = Query.getUserProfileForEducationVideos();
        System.out.println(
                "\n4. ¿Cuál es la biografía y foto de perfil de cada usuario que ha publicado videos de la categoría 'Educación'?\n");
        for (Object[] row : results) {
            System.out.println("Biografía: " + row[0] + "\nFoto de perfil: " + row[1] + "\n");
        }
        System.out.println("----------------------------------------------------------------------");
    }

    private void printDetailedVideoInfo() {
        List<Object[]> results = Query.getDetailedVideoInfo();
        System.out.println(
                "\n5. ¿Cuáles son los títulos y descripciones de los videos, los nombres de los usuarios que los publicaron, las biografías de estos usuarios, y las categorías a las que pertenecen los videos?\n");
        for (Object[] row : results) {
            System.out.println("Categoría: " + row[0] + "\nTítulo del video: " + row[1] +
                    "\nDescripción: " + row[2] + "\nUsuario: " + row[3] + "\nBiografía: " + row[4] + "\n");
        }
        System.out.println("----------------------------------------------------------------------");
    }
}