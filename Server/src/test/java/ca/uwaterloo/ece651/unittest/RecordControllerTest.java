package ca.uwaterloo.ece651.unittest;

import ca.uwaterloo.ece651.controllers.RecordController;
import ca.uwaterloo.ece651.enums.Day;
import ca.uwaterloo.ece651.enums.Meal;
import ca.uwaterloo.ece651.models.Record;
import ca.uwaterloo.ece651.repositories.RecordRepository;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RecordControllerTest {

    private static RecordRepository recordRepository = mock(RecordRepository.class);

    @InjectMocks
    private RecordController recordController;

    @BeforeClass
    public static void init() {
        Record record1 = new Record();
        record1.setId(1L);
        record1.setUid(24L);
        record1.setContent("record one content");
        record1.setMeal(Meal.BREAKFAST);
        record1.setDay(Day.MONDAY);
        record1.setDate("2019.3.20");

        Record record2 = new Record();
        record1.setId(2L);
        record1.setUid(10L);
        record1.setContent("record two content");
        record1.setMeal(Meal.LUNCH);
        record1.setDay(Day.SUNDAY);
        record1.setDate("2019.2.10");

        Record record3 = new Record();
        record1.setId(3L);
        record1.setUid(10L);
        record1.setContent("record three content");
        record1.setMeal(Meal.DINNER);
        record1.setDay(Day.FRIDAY);
        record1.setDate("2019.4.17");

        Record record4 = new Record();
        record1.setId(4L);
        record1.setUid(5L);
        record1.setContent("record four content");
        record1.setMeal(Meal.BREAKFAST);
        record1.setDay(Day.TUESDAY);
        record1.setDate("2019.3.15");

        when(recordRepository.findByUid(10L)).thenReturn(Arrays.asList(record2, record3));
        when(recordRepository.findByUid(24L)).thenReturn(Arrays.asList(record1));
        when(recordRepository.findByUid(5L)).thenReturn(Arrays.asList(record4));
        when(recordRepository.findByUid(22L)).thenReturn(Arrays.asList());
        when(recordRepository.save(any(Record.class))).then(returnsFirstArg());
    }

    @Test
    public void testGetRecordOne() {
        List<Record> result = recordController.getRecord("10");
        assertEquals(2, result.size());
    }

    @Test
    public void testGetRecordTwo() {
        List<Record> result = recordController.getRecord("24");
        assertEquals(1, result.size());
    }

    @Test
    public void testGetRecordThree() {
        List<Record> result = recordController.getRecord("5");
        assertEquals(1, result.size());
    }

    @Test
    public void testGetRecordFour() {
        List<Record> result = recordController.getRecord("22");
        assertEquals(0, result.size());
    }

    @Test
    public void testUploadRecordOne() {
        int result = recordController.uploadRecord("21", "2019.4.1", "Monday", "Lunch", "Delicious Lunch");
        assertEquals(1, result);
    }

    @Test
    public void testUploadRecordTwo() {
        int result = recordController.uploadRecord("18", "2019.3.11", "Tuesday", "Brunch", "No Brunch");
        assertEquals(0, result);
    }
}
