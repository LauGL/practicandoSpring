package com.example.demo;

import com.example.demo.models.Task;
import com.example.demo.repositories.TaskRepository;
import com.example.demo.services.TaskService;
import org.testng.annotations.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    @Test
    void findAllReturnsTasks() {
        TaskRepository repo = Mockito.mock(TaskRepository.class);
        TaskService service = new TaskService(repo);

        Mockito.when(repo.findAll()).thenReturn(List.of(
                new Task("Test", "Testing")
        ));

        List<Task> tasks = service.findAll();

        assertEquals(1, tasks.size());
        assertEquals("Test", tasks.get(0).getTitle());
    }
}
