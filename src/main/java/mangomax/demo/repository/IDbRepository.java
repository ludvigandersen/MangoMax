package mangomax.demo.repository;

import mangomax.demo.model.*;
import org.springframework.security.access.method.P;

import java.util.Date;
import java.util.List;

public interface  IDbRepository {
    boolean test();

    // TODO: role objekt + getAllRoles and id's
    // USER + role
    void createUser(User user, int roleId);
    List<User> getAllUsers();
    User getUserById(int userId);
    User getUserByEmail(String email);
    void updateUser(int userId, User user);
    void deleteUser(int userId);
    int getUserId(String name);

    // Cinema
    void createCinema(Cinema cinema);
    List<Cinema> getAllCinemas();
    Cinema getCinemaById(int cinemaId);
    void updateCinema(int cinemaId, Cinema cinema);
    void deleteCinema(int cinemaId);

    // Movies
    void createMovie(Movie movie);
    List<Movie> getAllMovies();
    Movie getMovieById(int movieId);
    List<Movie> getMoviesOneWeekFromNow();
    void updateMovie(int movieId, Movie movie);
    void deleteMovie(int movieId);

    // MovieDates
    void addMovieToDate(int movieId, Date date);
    void deleteMovieDate(int movieId);

    // Productsuser
    void createProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(int productId);
    void updateProduct(int productId, Product product);
    void deleteProduct(int productId);

    // Reservations
    void createReservation (Reservation reservation);
    void updateReservation (int resId, Reservation reservation);
    void deleteReservation (int resId);
    List<Reservation> getAllReservations ();
    List<Reservation> getAllUserReservations(int userId);
    Reservation getReservationById (int reservationsId);

    // Orders
    void createOrder (Order order);
    void updateOrder (int orderId, Order order);
    void deleteOrder (int orderId);
    List<Order> getAllOrders();
    Order getOrderById(int orderId);
    
}