package upei.project;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class MainTests {
    /*
     * Test case for the initial method.
     * Checks if the welcome statements and battleship clipart are printed without errors.
     */
    @Timeout(value=100, unit= TimeUnit.MILLISECONDS)
    @Test
    public void testInitial() {
        Main.Initial();
    }
    @Test
    public void testMain() {
        Main.main(null);
    }




}