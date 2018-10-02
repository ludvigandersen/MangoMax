package mangomax.demo.repository;

import mangomax.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
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
        String sql = "SELECT * FROM mangomax.user INNER JOIN role ON userRole_fk = role_id ";
        sqlRowSet = jdbc.queryForRowSet(sql);
        List<User> allUser = new ArrayList<>();
        while (sqlRowSet.next()) {
            allUser.add(new User(
                    sqlRowSet.getInt("user_id"),
                    sqlRowSet.getString("user_name"),
                    sqlRowSet.getString("user_email"),
                    sqlRowSet.getString("user_phone"),
                    sqlRowSet.getString("user_password"),
                    sqlRowSet.getInt("role_id")

            ));
        }
        return allUser;


    }


    @Override
    public User getUserById(int userId) {

        sqlRowSet = jdbc.queryForRowSet("SELECT * FROM user WHERE user_id=?", userId);

        while (sqlRowSet.next()) {
            return new User(
                    sqlRowSet.getInt("user_id"),
                    sqlRowSet.getString("user_name"),
                    sqlRowSet.getString("user_email"),
                    sqlRowSet.getString("user_phone"),
                    sqlRowSet.getString("user_password"),
                    sqlRowSet.getInt("userRole_fk"));
        }

        return null;

    }

    @Override
    public void updateUser(int userId, User user) {

        jdbc.update("UPDATE mangomax.user " +
                        "SET user_name=?,user_email=?, user_phone=?, user_password=? WHERE user_id=?",
                new Object[]{
                        user.getUserName(),
                        user.getUserMail(),
                        user.getUserPhoneNumber(),
                        user.getUserPassword(),
                });

    }

    @Override
    public void deleteUser(int userId) {
        jdbc.update("DELETE FROM mangomax.user WHERE mangomax.user.user_id=?", userId);


    }

    @Override
    public void createCinema(Cinema cinema) {
        jdbc.update("INSERT into mangomax.cinemas (cinemas, cinemas_seats) VALUES (?,?)",
                new Object[]{
                        cinema.getCinemaName(),
                        cinema.getCinemaSeats(),
                });
    }

    @Override
    public List<Cinema> getAllCinemas() {
        String sql = "SELECT * FROM mangomax.cinemas";
        sqlRowSet = jdbc.queryForRowSet(sql);
        List<Cinema> cinemaList = new ArrayList<>();
        while (sqlRowSet.next()) {
            cinemaList.add(new Cinema(
                    sqlRowSet.getInt("cinema_id"),
                    sqlRowSet.getString("cinemas"),
                    sqlRowSet.getInt("cinema_seats")
            ));
        }
        return cinemaList;
    }

    @Override
    public Cinema getCinemaById(int cinemaId) {
        return null;
    }

    @Override
    public void updateCinema(int cinemaId, Cinema cinema) {
        jdbc.update("UPDATE mangomax.cinemas " +
                        "SET cinemas =?, cinemas_seats=?",
                new Object[]{
                        cinema.getCinemaName(),
                        cinema.getCinemaSeats(),
                });
    }

    @Override
    public void deleteCinema(int cinemaId) {
        jdbc.update("DELETE FROM mangomax.cinemas WHERE mangomax.cinemas.cinema_id=?", cinemaId);

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

        sqlRowSet = jdbc.queryForRowSet("SELECT movie_dates.movie_date, movies.movie_id, movies.movie_name, movies.movie_description, movies.price, movies.age, cinemas.cinema_id, cinemas.cinemas, cinemas.cinemas_seats\n" +
                        "FROM movie_dates\n" +
                        "INNER JOIN movies ON movies.movie_id = movie_dates.moviedatesMovies_fk\n" +
                        "INNER JOIN cinemas ON movies.moviesCinemas_fk = cinemas.cinema_id\n" +
                "WHERE movie_id=?", movieId);


        while (sqlRowSet.next()) {
            return new Movie(
                    sqlRowSet.getInt("movie_id"),
                    sqlRowSet.getString("movie_name"),
                    sqlRowSet.getString("movie_description"),
                    sqlRowSet.getInt("price"),
                    sqlRowSet.getInt("age"),
                    sqlRowSet.getTimestamp("movie_date"),
                    new Cinema(sqlRowSet.getInt("cinema_id"),
                            sqlRowSet.getString("cinemas"),
                            sqlRowSet.getInt("cinemas_seats")));
        }
        return null;
    }

    @Override
    public List<Movie> getMoviesOneWeekFromNow() {
        String sql = "SELECT movie_dates.movie_date, movies.movie_id, movies.movie_name, movies.movie_description, movies.price, movies.age, cinemas.cinema_id, cinemas.cinemas, cinemas.cinemas_seats\n" +
                "FROM movie_dates\n" +
                "INNER JOIN movies ON movies.movie_id = movie_dates.moviedatesMovies_fk\n" +
                "INNER JOIN cinemas ON movies.moviesCinemas_fk = cinemas.cinema_id\n" +
                "WHERE movie_dates.movie_date BETWEEN NOW() AND NOW() + INTERVAL 7 DAY";
        sqlRowSet = jdbc.queryForRowSet(sql);
        List<Movie> movies = new ArrayList<>();

        while (sqlRowSet.next()) {
            movies.add(new Movie(
                    sqlRowSet.getInt("movie_id"),
                    sqlRowSet.getString("movie_name"),
                    sqlRowSet.getString("movie_description"),
                    sqlRowSet.getInt("price"),
                    sqlRowSet.getInt("age"),
                    sqlRowSet.getTimestamp("movie_date"),
                    new Cinema(sqlRowSet.getInt("cinema_id"),
                            sqlRowSet.getString("cinemas"),
                            sqlRowSet.getInt("cinemas_seats"))
            ));
        }
        return movies;
    }

    @Override
    public void updateMovie(int movieId, Movie movie) {
        jdbc.update("UPDATE mangomax.movies SET movie_name=?, movie_description=?, price=?, age=?",
                new Object[]{
                        movie.getMovieName(),
                        movie.getMovieDescription(),
                        movie.getMoviePrice(),
                        movie.getMovieAgeLimit(),
                });
    }

    @Override
    public void deleteMovie(int movieId) {
        jdbc.update("DELETE FROM mangomax.movies WHERE mangomax.movies.movie_id=?", movieId);
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
        String sql = "SELECT * FROM mangomax.products";
        sqlRowSet = jdbc.queryForRowSet(sql);
        List<Product> productList = new ArrayList<>();
        while (sqlRowSet.next()) {
            productList.add(new Product(
                            sqlRowSet.getInt("products_id"),
                            sqlRowSet.getString("products_name"),
                            sqlRowSet.getInt("products_price"),
                            sqlRowSet.getString("products_description")
                    ));
        }
        return productList;
    }

    @Override
    public Product getProductById(int productId) {
        sqlRowSet = jdbc.queryForRowSet("SELECT * FROM mangomax.products WHERE products_id=?", productId);
        while (sqlRowSet.next()) {
            return new Product(
                    sqlRowSet.getInt("product_id"),
                    sqlRowSet.getString("products_name"),
                    sqlRowSet.getInt("products_price"),
                    sqlRowSet.getString("products_description")
                    );
        }
        return null;
    }

    @Override
    public void updateProduct(int productId, Product product) {
        jdbc.update("UPDATE mangomax.products SET products_name=?,products_price=?,products_description=?",
                new Object[]{
                        product.getProductName(),
                        product.getProductPrice(),
                        product.getProductDescription(),
                });
    }

    @Override
    public void deleteProduct(int productId) {
        jdbc.update("DELETE FROM mangomax.products WHERE products_id =?", productId);
    }

    @Override
    public void createReservation(Reservation reservation) {

    }

    @Override
    public void updateReservation(int resId, Reservation reservation) {

    }

    @Override
    public void deleteReservation(int resId) {

    }

    @Override
    public List<Reservation> getAllReservations() {
        return null;
    }

    @Override
    public Reservation getReservationById(int reservationsId) {
        return null;
    }

    @Override
    public void createOrder(Order order) {

    }

    @Override
    public void updateOrder(int orderId, Order order) {

    }

    @Override
    public void deleteOrder(int orderId) {

    }

    @Override
    public List<Order> getAllOrders() {
        return null;
    }

    @Override
    public Order getOrderById(int orderId) {
        return null;
    }

}
