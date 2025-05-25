package Model.Film;

import Model.Connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOFilm implements InterfaceDAOFilm{
    @Override
    public void insert(ModelFilm film) {
        try {
            String query = "INSERT INTO data_film (judul, nilai_alur, nilai_penokohan, nilai_akting, nilai_rating) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, film.getJudul());
            statement.setFloat(2, film.getAlur());
            statement.setFloat(3, film.getPenokohan());
            statement.setFloat(4, film.getAkting());
            statement.setFloat(5, film.getRating());

            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            System.out.println("Input Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void update(ModelFilm film) {
        try {
            String query = "UPDATE data_film SET judul=?, nilai_alur=?, nilai_penokohan=?, nilai_akting=?, nilai_rating=? WHERE id_film=?;";

            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, film.getJudul());
            statement.setFloat(2, film.getAlur());
            statement.setFloat(3, film.getPenokohan());
            statement.setFloat(4, film.getAkting());
            statement.setFloat(5, film.getRating());
            statement.setInt(6, film.getId());

            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            System.out.println("update Failed! (" + e.getMessage() + ")");
        }
    }

    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM data_film WHERE id_film=?;";

            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setInt(1, id);

            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            System.out.println("Delete Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public List<ModelFilm> getAll() {
        List<ModelFilm> listFilm = null;

        try {
            listFilm = new ArrayList<>();

            Statement statement = Connector.Connect().createStatement();

            String query = "SELECT * FROM data_film;";

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                ModelFilm flm = new ModelFilm();

                flm.setId(resultSet.getInt("id_film"));
                flm.setJudul(resultSet.getString("judul"));
                flm.setAlur(resultSet.getFloat("nilai_alur"));
                flm.setPenokohan(resultSet.getFloat("nilai_penokohan"));
                flm.setAkting(resultSet.getFloat("nilai_akting"));
                flm.setRating(resultSet.getFloat("nilai_rating"));

                listFilm.add(flm);
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listFilm;
    }
    
    @Override
    public void deleteAll() {
        try {
            String query = "TRUNCATE TABLE data_film;";

            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);

            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            System.out.println("Clear Failed: " + e.getLocalizedMessage());
        }
    }
}