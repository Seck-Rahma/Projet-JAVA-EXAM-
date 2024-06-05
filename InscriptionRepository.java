package com.devoirjava.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InscriptionRepository {

    public void creerInscription(int idEtudiant, int idClasse, String annee) {
        String sql = """
                INSERT INTO inscription(id_etudiant, id_classe, annee) \
                values(?,?,?)
                """;
        try (Connection db = DB.connection();
             PreparedStatement preparedStatement = db.prepareStatement(sql)) {
            preparedStatement.setInt(1, idEtudiant);
            preparedStatement.setInt(2, idClasse);
            preparedStatement.setString(3, annee);
            
            
            int count = preparedStatement.executeUpdate();
            if (count == 0) {
                System.out.println("Une erreur est survenue, l'inscription n'est pas créée");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }   
    }

}
