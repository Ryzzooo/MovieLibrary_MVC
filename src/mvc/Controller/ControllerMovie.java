package mvc.Controller;

import mvc.DAO.DAOMovie;
import mvc.DAOInterface.IMovie;
import mvc.Model.Movie;
import mvc.Model.TabelModelMovie;
import mvc.View.FormMovie;
import java.util.List;
import javax.swing.JOptionPane;
import mvc.DAO.DAOLogin;
import mvc.DAOInterface.ILogin;
import mvc.View.FormHome;

/**
 * Controller for Movie
 * @author ACER
 */
public class ControllerMovie {
    FormMovie frame;
    IMovie implMovie;
    List<Movie> lb;
    ILogin implLogin;
    
    public ControllerMovie(FormMovie frame) {
        this.frame = frame;
        implMovie = new DAOMovie();
        implLogin = new DAOLogin();
        lb = implMovie.getAll();
    }
    
    // Reset form fields
    public void reset() {
        frame.getTxtID().setText("");
        frame.getTxtTitle().setText("");
        frame.getTxtGenre().setText("");
        frame.getTxtDirector().setText("");
        frame.getTxtReleaseYear().setText("");
        frame.getTxtRating().setText("");
        frame.getTxtDescription().setText("");
        frame.getTxtCariTitle().setText("");
    }
    
    // Populate table with data
    public void isiTable() {
        lb = implMovie.getAll();
        TabelModelMovie tmb = new TabelModelMovie(lb);
        frame.getTabelData().setModel(tmb);
    }
    
    // Populate form fields with selected row data
    public void isiField(int row) {
        frame.getTxtID().setText(lb.get(row).getId().toString());
        frame.getTxtTitle().setText(lb.get(row).getTitle());
        frame.getTxtGenre().setText(lb.get(row).getGenre());
        frame.getTxtDirector().setText(lb.get(row).getDirector());
        frame.getTxtReleaseYear().setText(lb.get(row).getReleaseYear().toString());
        frame.getTxtRating().setText(lb.get(row).getRating().toString());
        frame.getTxtDescription().setText(lb.get(row).getDescription());
    }
    
    // Insert new movie
    public void insert() {
        if (!frame.getTxtTitle().getText().trim().isEmpty() && 
            !frame.getTxtGenre().getText().trim().isEmpty() &&
            !frame.getTxtDirector().getText().trim().isEmpty() &&
            !frame.getTxtReleaseYear().getText().trim().isEmpty()) {
            
            Movie movie = new Movie();
            movie.setTitle(frame.getTxtTitle().getText());
            movie.setGenre(frame.getTxtGenre().getText());
            movie.setDirector(frame.getTxtDirector().getText());
            movie.setReleaseYear(Integer.parseInt(frame.getTxtReleaseYear().getText()));
            movie.setRating(Double.parseDouble(frame.getTxtRating().getText()));
            movie.setDescription(frame.getTxtDescription().getText());
            implMovie.insert(movie);
            JOptionPane.showMessageDialog(null, "Simpan Data sukses");
        } else {
            JOptionPane.showMessageDialog(frame, "Data Tidak Boleh Kosong");
        }
    }
    
    // Update existing movie
    public void update() {
        if (!frame.getTxtID().getText().trim().isEmpty()) {
            Movie movie = new Movie();
            movie.setTitle(frame.getTxtTitle().getText());
            movie.setGenre(frame.getTxtGenre().getText());
            movie.setDirector(frame.getTxtDirector().getText());
            movie.setReleaseYear(Integer.parseInt(frame.getTxtReleaseYear().getText()));
            movie.setRating(Double.parseDouble(frame.getTxtRating().getText()));
            movie.setDescription(frame.getTxtDescription().getText());
            movie.setId(Integer.parseInt(frame.getTxtID().getText()));
            implMovie.update(movie);
            JOptionPane.showMessageDialog(null, "Update Data sukses");
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih data yang akan di ubah");
        }
    }
    
    // Delete movie
    public void delete() {
        if (!frame.getTxtID().getText().trim().isEmpty()) {
            int id = Integer.parseInt(frame.getTxtID().getText());
            implMovie.delete(id);
            JOptionPane.showMessageDialog(null, "Hapus Data sukses");
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih data yang akan di hapus");
        }
    }
    
    // Search movies by title
    public void isiTableCariTitle() {
        lb = implMovie.getCariTitle(frame.getTxtCariTitle().getText());
        TabelModelMovie tmb = new TabelModelMovie(lb);
        frame.getTabelData().setModel(tmb);
    }
    
    // Search function
    public void carinama() {
        if (!frame.getTxtCariTitle().getText().trim().isEmpty()) {
            implMovie.getCariTitle(frame.getTxtCariTitle().getText());
            isiTableCariTitle();
        } else {
            JOptionPane.showMessageDialog(frame, "SILAHKAN PILIH DATA");
        }
    }
}