package mangomax.demo.repository;

import mangomax.demo.model.Cinema;
import mangomax.demo.model.Movie;
import mangomax.demo.model.Product;
import mangomax.demo.model.User;
import org.springframework.security.access.method.P;

import java.util.List;

public interface IDbRepository {
    boolean test();

    // TODO: role objekt + getAllRoles and id's
    // USER + role
    void createUser(User user, int roleId);
    List<User> getAllUsers();
    User getUserById(int userId);
    void updateUser(int userId, User user);
    void deleteUser(int userId);

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
    void updateMovie(int movieId, Movie movie);
    void deleteMovie(int movieId);

    // MovieDates

    // Productsuser
    void createProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(int productId);
    void updateProduct(int productId, Product product);
    void deleteProduct(int productId);

    // Reservations

    // Orders

}