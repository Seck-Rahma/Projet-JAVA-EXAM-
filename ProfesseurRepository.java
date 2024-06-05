package com.devoirjava.repositories;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.devoirjava.entities.Classe;
import com.devoirjava.entities.Professeur;

public class ProfesseurRepository {

    public void saveProfesseur(Professeur professeur) {
        String sql = "INSERT INTO professeur(id, nom, prenom, grade, NCI) values(?,?,?,?,?)";
        try (Connection db = DB.connection();
             PreparedStatement preparedStatement = db.prepareStatement(sql)) {
            preparedStatement.setInt(1, professeur.getId());
            preparedStatement.setString(2, professeur.getNom());
            preparedStatement.setString(3, professeur.getPrenom());
            preparedStatement.setString(4, professeur.getGrade());
            preparedStatement.setString(5, professeur.getNCI());
            int count = preparedStatement.executeUpdate();
            if (count == 0) {
                System.out.println("Une erreur est survenue, le professeur n'est pas créée");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Professeur> findAllProfesseurs() {
        String sql = "SELECT id, nom, prenom, grade, NCI FROM professeur";
        try (Connection db = DB.connection();
             PreparedStatement preparedStatement = db.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Professeur> professeurs = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String grade = resultSet.getString("grade");
                String NCI = resultSet.getString("NCI");
                Professeur professeur= new Professeur(id, nom, prenom, grade, NCI);
                professeurs.add(professeur);
            }
            return professeurs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Classe> findClasses(int idProfesseur) {
        String sql = """
                SELECT id, libelle, filliere, niveau 
                FROM classe c 
                INNER JOIN affectation_classe ac1 on ac1.id_professeur = ?
                INNER JOIN affectation_classe ac2 on ac2.id_classe = c.id
                """;
        try (Connection db = DB.connection();
                PreparedStatement preparedStatement = db.prepareStatement(sql)) {
            preparedStatement.setInt(1, idProfesseur);
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

