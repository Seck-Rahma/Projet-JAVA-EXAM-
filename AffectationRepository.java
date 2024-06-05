package com.devoirjava.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AffectationRepository {

    public void creerAffectation(int idProfesseur, int idClasse) {
           String sql = """
                INSERT INTO affectation_classe(id_professeur, id_classe) \
                values(?,?)
                """;
        try (Connection db = DB.connection();
             PreparedStatement preparedStatement = db.prepareStatement(sql)) {
            preparedStatement.setInt(1, idProfesseur);
            preparedStatement.setInt(2, idClasse);
            
            
            int count = preparedStatement.executeUpdate();
            if (count == 0) {
                System.out.println("Une erreur est survenue, l'affectation classe n'est pas créée");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }   
    }

}
