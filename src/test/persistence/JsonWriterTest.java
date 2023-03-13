package persistence;

import model.FitnessMovement;
import model.HourSchedule;
import model.MovementList;
import model.TimeSchedule;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * writer to write MovementList and HourSchedule in to file
 * based on the JSOnSerializationDemo
 */
public class JsonWriterTest {

    @Test
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("..");
            writer.open();
            fail("should have exception");
        } catch(IOException e) {

        }
    }

    @Test
    void testWriterOfMovement() {
        try {
            JsonWriter writer = new JsonWriter("./data/testWriteMovement.json");
            MovementList ml = new MovementList();
            FitnessMovement ft = new FitnessMovement("a","b",",,",3);
            ml.addMovement(ft);
            writer.open();
            writer.writeMovementList(ml);
            writer.close();

        } catch(IOException e) {
            fail("should not have exception");
        }

        MovementList ml1 = new MovementList();

        try {
            JsonReader reader = new JsonReader("./data/testWriteMovement.json");
            ml1 = reader.read();
        } catch(IOException e) {
            fail("should not have exception");
        }

        FitnessMovement f1 = ml1.getMovement(0);
        assertEquals("a",f1.getName());
    }

    @Test
    void testWriterOfSchedule() {
        try {
            JsonWriter writer = new JsonWriter("./data/testWriteSchedule.json");
            TimeSchedule ts = new TimeSchedule();
            FitnessMovement ft = new FitnessMovement("a","b",",,",3);
            HourSchedule hs = new HourSchedule(1,2,ft);
            ts.addSchedule(hs);
            writer.open();
            writer.writeTimeSchedule(ts);
            writer.close();

        } catch(IOException e) {
            fail("should not have exception");
        }

        TimeSchedule ts1 = new TimeSchedule();

        try {
            JsonReader reader = new JsonReader("./data/testWriteSchedule.json");
            ts1 = reader.read1();
        } catch(IOException e) {
            fail("should not have exception");
        }

        HourSchedule hs1 = ts1.getSchedules().get(0);
        assertEquals(1,hs1.getDay());
    }

}
