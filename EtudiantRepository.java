package com.devoirjava.repositories;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.devoirjava.entities.Etudiant;

public class EtudiantRepository {

    public void saveEtudiant(Etudiant etudiant) {
        String sql = "INSERT INTO etudiant(id, nom, prenom, tuteur, matricule) values(?,?,?,?,?)";
        try (Connection db = DB.connection();
             PreparedStatement preparedStatement = db.prepareStatement(sql)) {
            preparedStatement.setInt(1, etudiant.getId());
            preparedStatement.setString(2, etudiant.getNom());
            preparedStatement.setString(3, etudiant.getPrenom());
            preparedStatement.setString(4, etudiant.getTuteur());
            preparedStatement.setString(5, etudiant.getMatricule());
            int count = preparedStatement.executeUpdate();
            if (count == 0) {
                System.out.println("Une erreur est survenue, l'etudiant n'est pas créée");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
/* 
    private Etudiant findEtudiantById(int id) {
        String sql = "SELECT id, nom, prenom, tuteur, matricule FROM etudiant WHERE id = ?";
        try (Connection db = DB.connection();
             PreparedStatement preparedStatement = db.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String tuteur = resultSet.getString("tuteur");
                String matricule = resultSet.getString("matricule");
                return new Etudiant(id, nom, prenom, tuteur, matricule);
            }
            throw new RuntimeException("Catégorie non trouvée");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
*/
    public List<Etudiant> findAllEtudiants() {
        String sql = "SELECT id, nom, prenom, tuteur, matricule FROM etudiant";
        try (Connection db = DB.connection();
             PreparedStatement preparedStatement = db.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Etudiant> etudiants = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String tuteur = resultSet.getString("tuteur");
                String matricule = resultSet.getString("matricule");
                Etudiant etudiant = new Etudiant(id, nom, prenom, tuteur, matricule);
                etudiants.add(etudiant);
            }
            return etudiants;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Etudiant> findEtudiantsByAnnee(String annee) {
        String sql = """
            SELECT id, nom, prenom, tuteur, matricule FROM etudiant
            INNER JOIN inscription i on i.id_etudiant = id
            WHERE i.annee = ?       
            """;
        try (Connection db = DB.connection();
             PreparedStatement preparedStatement = db.prepareStatement(sql)) {
            preparedStatement.setString(1, annee);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Etudiant> etudiants = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String tuteur = resultSet.getString("tuteur");
                String matricule = resultSet.getString("matricule");
                Etudiant etudiant = new Etudiant(id, nom, prenom, tuteur, matricule);
                etudiants.add(etudiant);
            }
            return etudiants;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Etudiant> findEtudiantsByClasse(int idClasse) {
        String sql = """
            SELECT id, nom, prenom, tuteur, matricule FROM etudiant
            INNER JOIN inscription i on i.id_etudiant = id
            WHERE i.id_classe = ?       
            """;
        try (Connection db = DB.connection();
             PreparedStatement preparedStatement = db.prepareStatement(sql)) {
            preparedStatement.setInt(1, idClasse);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Etudiant> etudiants = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String tuteur = resultSet.getString("tuteur");
                String matricule = resultSet.getString("matricule");
                Etudiant etudiant = new Etudiant(id, nom, prenom, tuteur, matricule);
                etudiants.add(etudiant);
            }
            return etudiants;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
