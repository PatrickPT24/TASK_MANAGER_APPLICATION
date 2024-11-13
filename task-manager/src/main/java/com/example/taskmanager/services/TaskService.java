package services;

// import .t;
// import com.example.taskmanagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Task;
import repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EmailService emailService;

    public Task createTask(Task task) {
        Task newTask = taskRepository.save(task);

        // Send email notification
        if (newTask.getAssignedTeamMember() != null) {
            String to = newTask.getAssignedTeamMember().getEmail();
            String subject = "New Task Assigned: " + newTask.getName();
            String body = "Hello " + newTask.getAssignedTeamMember().getName() + ",\n\n"
                    + "You have been assigned a new task:\n"
                    + "Task Name: " + newTask.getName() + "\n"
                    + "Description: " + newTask.getDescription() + "\n"
                    + "Deadline: " + newTask.getDeadline() + "\n\n"
                    + "Best regards,\n"
                    + "Task Management System";

            emailService.sendEmail(to, subject, body);
        }

        return newTask;
    }
}
