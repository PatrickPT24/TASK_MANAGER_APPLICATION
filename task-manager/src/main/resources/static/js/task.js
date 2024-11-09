// Example statuses
const statuses = ["To Do", "In Progress", "Completed"];

// Add new properties for task assignment and status
function createTask(newTask) {
    newTask.id = getNewTaskId();
    newTask.assignee = document.getElementById('assignee').value || 'Unassigned';
    newTask.status = 'To Do'; // Default status

    let tasks = getTasks();
    tasks.push(newTask);
    updateTasks(tasks);
    notify('Task created successfully.');
}

function updateTaskStatus(taskId, newStatus) {
    let tasks = getTasks();
    tasks = tasks.map(task => (task.id === taskId ? { ...task, status: newStatus } : task));
    updateTasks(tasks);
    notify('Task status updated.');
}

function assignTask(taskId, assignee) {
    let tasks = getTasks();
    tasks = tasks.map(task => (task.id === taskId ? { ...task, assignee: assignee } : task));
    updateTasks(tasks);
    notify('Task assigned successfully.');
}

// Update dashboard view by filtering tasks for logged-in user
function updateDashboardView() {
    const email = localStorage.getItem('loggedInUser');
    let tasks = getTasks().filter(task => task.assignee === email);
    // Display tasks on dashboard
}
