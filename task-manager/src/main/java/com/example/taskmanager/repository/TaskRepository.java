package repository;

import model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // 1. Find tasks by status
    List<Task> findByStatus(String status);

    // 2. Find tasks by priority
    List<Task> findByPriority(String priority);

    // 3. Find tasks assigned to a specific user
    List<Task> findByAssignedUser_Id(Long userId);

    // 4. Find tasks with deadlines before a specific date
    List<Task> findByDeadlineBefore(Date deadline);

    // 5. Find tasks assigned to a specific user and by status
    List<Task> findByAssignedUser_IdAndStatus(Long userId, String status);
    
    // 6. Find tasks by name containing a specific keyword (for search functionality)
    List<Task> findByNameContainingIgnoreCase(String keyword);

}