package mvc.DAO;

import mvc.Koneksi.Koneksi;
import mvc.Model.Movie;
import mvc.DAOInterface.IMovie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DAO implementation for Movie
 * @author ACER
 */
public class DAOMovie implements IMovie {
    Connection connection;
    final String insert = "INSERT INTO tblmovies (title, genre, director, release_year, rating, description) VALUES (?, ?, ?, ?, ?, ?)";
    final String update = "UPDATE tblmovies SET title=?, genre=?, director=?, release_year=?, rating=?, description=? WHERE id=?";
    final String delete = "DELETE FROM tblmovies WHERE id=?";
    final String select = "SELECT * FROM tblmovies";
    final String carinama = "SELECT * FROM tblmovies WHERE title LIKE ?";
    
    public DAOMovie() {
        connection = Koneksi.connection();
    }
    
    @Override
    public void insert(Movie movie) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, movie.getTitle());
            statement.setString(2, movie.getGenre());
            statement.setString(3, movie.getDirector());
            statement.setInt(4, movie.getReleaseYear());
            statement.setDouble(5, movie.getRating());
            statement.setString(6, movie.getDescription());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                movie.setId(rs.getInt(1));
            }
        } catch (SQLException ex) {
            System.out.println("Berhasil Input");
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Gagal Input");
            }
        }
    }
    
    @Override
    public void update(Movie movie) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, movie.getTitle());
            statement.setString(2, movie.getGenre());
            statement.setString(3, movie.getDirector());
            statement.setInt(4, movie.getReleaseYear());
            statement.setDouble(5, movie.getRating());
            statement.setString(6, movie.getDescription());
            statement.setInt(7, movie.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Berhasil Update");
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Gagal Update");
            }
        }
    }
    
    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Berhasil Delete");
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Gagal Delete");
            }
        }
    }
    
    @Override
    public List<Movie> getAll() {
        List<Movie> lb = null;
        try {
            lb = new ArrayList<Movie>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setId(rs.getInt("id"));
                movie.setTitle(rs.getString("title"));
                movie.setGenre(rs.getString("genre"));
                movie.setDirector(rs.getString("director"));
                movie.setReleaseYear(rs.getInt("release_year"));
                movie.setRating(rs.getDouble("rating"));
                movie.setDescription(rs.getString("description"));
                lb.add(movie);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }
    
    @Override
    public List<Movie> getCariTitle(String title) {
        List<Movie> lb = null;
        try {
            lb = new ArrayList<Movie>();
            PreparedStatement st = connection.prepareStatement(carinama);
            st.setString(1, "%" + title + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setId(rs.getInt("id"));
                movie.setTitle(rs.getString("title"));
                movie.setGenre(rs.getString("genre"));
                movie.setDirector(rs.getString("director"));
                movie.setReleaseYear(rs.getInt("release_year"));
                movie.setRating(rs.getDouble("rating"));
                movie.setDescription(rs.getString("description"));
                lb.add(movie);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }
}
