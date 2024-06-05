package com.devoirjava.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.devoirjava.entities.Classe;

public class ClasseRepository {

    public void saveClasse(Classe classe) {
        String sql = """
                INSERT INTO classe(id, libelle, filliere, niveau) \
                values(?,?,?,?)
                """;
        try (Connection db = DB.connection();
             PreparedStatement preparedStatement = db.prepareStatement(sql)) {
            preparedStatement.setInt(1, classe.getId());
            preparedStatement.setString(2, classe.getLibelle());
            preparedStatement.setString(3, classe.getFilliere());
            preparedStatement.setString(4, classe.getNiveau());
            
            int count = preparedStatement.executeUpdate();
            if (count == 0) {
                System.out.println("Une erreur est survenue, la classe n'est pas créée");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Classe> findAllClasses() {
        String sql = """
                SELECT id, libelle, filliere, niveau 
                FROM classe  
                """;
        try (Connection db = DB.connection();
             PreparedStatement preparedStatement = db.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Classe> classes = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String libelle = resultSet.getString("libelle");
                String filliere = resultSet.getString("filliere");
                String niveau = resultSet.getString("niveau");
                Classe classe = new Classe(id, libelle, filliere, niveau);
                classes.add(classe);
            }
            return classes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
