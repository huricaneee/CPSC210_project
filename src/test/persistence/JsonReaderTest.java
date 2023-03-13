package persistence;

import model.MovementList;
import model.TimeSchedule;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest {
    private static final String pathOfMovementList = "./data/testMovement.json";
    private static final String pathOfHourSchedule = "./data/testSchedule.json";
    private JsonReader readerOfMovement;
    private JsonReader readerOfSchedule;

    @Test
    public void testMovementException() {
        readerOfMovement = new JsonReader("....");
        try{
            MovementList ml = readerOfMovement.read();
            fail("Exception exists");
        } catch(IOException e) {

        }
    }

    @Test
    public void testMovementWithoutException() {
        readerOfMovement = new JsonReader(pathOfMovementList);
        try{
            MovementList ml = readerOfMovement.read();

        } catch(IOException e) {
            fail("Exception shouldn't exist");
        }
    }

    @Test
    public void testScheduleException() {
        readerOfSchedule = new JsonReader("..");
        try{
            TimeSchedule timeSchedule = readerOfSchedule.read1();
            fail("Exception exists");
        } catch(IOException e) {

        }

    }

    @Test
    public void testScheduleWithoutException() {
        readerOfSchedule = new JsonReader(pathOfHourSchedule);
        try{
            TimeSchedule timeSchedule = readerOfSchedule.read1();

        } catch(IOException e) {
            fail("Exception shouldn't exist");
        }
    }
}
