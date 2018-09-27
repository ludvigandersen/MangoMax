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

        while (sqlRowSet.next()) {
            test.add(sqlRowSet.getString("value"));
        }

        if (test.size() > 0) {
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
//        jdbc.update("UPDATE products " +
//                        "SET productName=?, productPurchasePrice=?, " +
//                        "productSalesPrice=?, productBarcodeNumber=?, productDescription=?, " +
//                        "productLocationId=?, productsInStock=? " +
//                        "WHERE productId=?",
//                new Object[]{
//                        product.getProductName(), product.getPurchasePrice(),
//                        product.getSalesPrice(), product.getProductBarcode(), product.getProductDescription(),
//                        product.getProductLocation(), product.getProductsInStock(), product.getProductId()
//                });
    }

    @Override
    public void deleteUser(int userId) {
        //jdbc.update("DELETE FROM ballonkompagniet.products WHERE ballonkompagniet.products.productNumber = ?", id);


    }

    @Override
    public void createCinema(Cinema cinema) {
            jdbc.update("INSERT into mangomax.cinemas (cinemas, cinemas_seats) VALUES (?,?)",
            new Object[] {
                    cinema.getCinemaName(),
                    cinema.getCinemaSeats(),
            });
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
        jdbc.update("INSERT into mangomax.movies (movie_name, movie_description, price, age, moviesCinemas_fk)" +
                        " VALUES (?,?,?,?,?)",
                new Object[]{
                        movie.getMovieName(),
                        movie.getMovieDescription(),
                        movie.getMoviePrice(),
                        movie.getMoviePrice(),
                        movie.getMovieAgeLimit(),
                        movie.getCinema().getCinemaId(),

                });
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
    public List<Movie> getMoviesOneWeekFromNow() {
        String sql = "SELECT movie_dates.movie_date, movies.movie_id, movies.movie_name, movies.movie_description, movies.price, movies.age, cinemas.cinema_id, cinemas.cinemas, cinemas.cinemas_seats\n" +
                "FROM movie_dates\n" +
                "INNER JOIN movies ON movies.movie_id = movie_dates.moviedatesMovies_fk\n" +
                "INNER JOIN cinemas ON movies.moviesCinemas_fk = cinemas.cinema_id\n" +
                "WHERE movie_dates.movie_date BETWEEN NOW() AND DATE_ADD(NOW(), INTERVAL 7 DAY)";
        sqlRowSet = jdbc.queryForRowSet(sql);
        List<Movie> movies = new ArrayList<>();

        while (sqlRowSet.next()){
            movies.add(new Movie(
                    sqlRowSet.getInt("movie_id"),
                    sqlRowSet.getString("movie_name"),
                    sqlRowSet.getString("movie_description"),
                    sqlRowSet.getInt("price"),
                    sqlRowSet.getInt("age"),
                    sqlRowSet.getDate("movie_date"),
                    new Cinema(sqlRowSet.getInt("cinema_id"),
                            sqlRowSet.getString("cinemas"),
                            sqlRowSet.getInt("cinemas_seats"))
            ));
        }
        return movies;
    }

    @Override
    public void updateMovie(int movieId, Movie movie) {

    }

    @Override
    public void deleteMovie(int movieId) {

    }

    @Override
    public void createProduct(Product product) {
               jdbc.update("INSERT INTO mangomax.products (products_name, products_price, products_description) VALUES (?,?,?)",
                new Object[]{
                        product.getProductName(),
                        product.getProductPrice(),
                        product.getProductDescription(),

                });
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
