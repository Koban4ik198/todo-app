import org.example.TodoList;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodoListTest {

    @Test
    void addAndList() {
        TodoList t = new TodoList();
        t.add(" task1 ");
        assertEquals(1, t.size());
        assertEquals("task1", t.getAll().get(0));
    }

    @Test
    void remove() {
        TodoList t = new TodoList();
        t.add("a");
        t.add("b");
        assertTrue(t.remove(0));
        assertEquals(1, t.size());
        assertFalse(t.remove(10));
    }

    @Test
    void addEmptyIgnored() {
        TodoList t = new TodoList();
        t.add("   ");
        assertEquals(0, t.size());
    }

    @Test
    void clearTasks() {
        TodoList t = new TodoList();
        t.add("Task 1");
        t.clear();
        assertEquals(0, t.size());
    }

    @Test
    void markTaskDone() {
        TodoList t = new TodoList();
        t.add("Task 1");
        assertTrue(t.markDone(0));
        assertEquals("[X] Task 1", t.getAll().get(0));
    }

    @Test
    void searchTasks() {
        TodoList t = new TodoList();
        t.add("Buy milk");
        t.add("Buy bread");
        t.add("Run");
        List<String> results = t.search("Buy");
        assertEquals(2, results.size());
    }
}