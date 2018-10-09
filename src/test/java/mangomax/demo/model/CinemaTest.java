package mangomax.demo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CinemaTest {
    Cinema cinema = new Cinema(1, "Sal1", 100);

    @Test
    public void getCinemaId() {
        assertEquals(1, cinema.getCinemaId());
    }

    @Test
    public void setCinemaId() {
        cinema.setCinemaId(2);
        assertEquals(2, cinema.getCinemaId());
    }

    @Test
    public void getCinemaName() {
        assertEquals("Sal1", cinema.getCinemaName());
    }

    @Test
    public void setCinemaName() {
        cinema.setCinemaName("Sal2");
        assertEquals("Sal2", cinema.getCinemaName());
    }

    @Test
    public void getCinemaSeats() {
        assertEquals(100, cinema.getCinemaSeats());
    }

    @Test
    public void setCinemaSeats() {
        cinema.setCinemaSeats(200);
        assertEquals(200, cinema.getCinemaSeats());
    }
}