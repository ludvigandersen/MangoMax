package mangomax.demo.repository;

import mangomax.demo.model.Cinema;
import mangomax.demo.model.Movie;
import mangomax.demo.model.Product;
import mangomax.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DbConnection implements IDbRepository {

    @Autowired
    JdbcTemplate jdbc;
    SqlRowSet sqlRowSet;

    @Override
    public boolean test() {
        List<String> test = new ArrayList<>();

        String sql = "SELECT * FROM test_table";
        sqlRowSet = jdbc.queryForRowSet(sql);

        while (sqlRowSet.next()){
            test.add(sqlRowSet.getString("value"));
        }

        if (test.size() > 0){
            return true;
        }
        return false;
    }

    @Override
    public void createUser(User user, int roleId) {
        jdbc.update("INSERT INTO user (user_name ,user_email, user_phone, user_password, userRole_fk) " +
                        "VALUES (?,?,?,?,?)",
                new Object[]{
                    user.getUserName(),
                    user.getUserMail(),
                    user.getUserPhoneNumber(),
                    user.getUserPassword(),
                    roleId
                });
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserById(int userId) {
        return null;
    }

    @Override
    public void updateUser(int userId, User user) {

    }

    @Override
    public void deleteUser(int userId) {

    }

    @Override
    public void createCinema(Cinema cinema) {

    }

    @Override
    public List<Cinema> getAllCinemas() {
        return null;
    }

    @Override
    public Cinema getCinemaById(int cinemaId) {
        return null;
    }

    @Override
    public void updateCinema(int cinemaId, Cinema cinema) {

    }

    @Override
    public void deleteCinema(int cinemaId) {

    }

    @Override
    public void createMovie(Movie movie) {

    }

    @Override
    public List<Movie> getAllMovies() {
        return null;
    }

    @Override
    public Movie getMovieById(int movieId) {
        return null;
    }

    @Override
    public void updateMovie(int movieId, Movie movie) {

    }

    @Override
    public void deleteMovie(int movieId) {

    }

    @Override
    public void createProduct(Product product) {

    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getProductById(int productId) {
        return null;
    }

    @Override
    public void updateProduct(int productId, Product product) {

    }

    @Override
    public void deleteProduct(int productId) {

    }
}
