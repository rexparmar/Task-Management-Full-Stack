// Axios Setup
const apiUrl = 'http://localhost:5454/tasks';

// Fetch all tasks and display them
function getTasks() {
    axios.get(apiUrl)
        .then(response => {
            const tasks = response.data;
            const taskList = document.getElementById("taskList");
            taskList.innerHTML = '';
            tasks.forEach(task => {
                const li = document.createElement("li");
                li.innerHTML = `
                    <div><strong>${task.title}</strong> - ${task.status}</div>
                    <button onclick="deleteTask(${task.id})">Complete</button>
                `;
                taskList.appendChild(li);
            });
        })
        .catch(error => {
            console.error("Error fetching tasks:", error);
        });
}

// Create new task
function createTask() {
    const title = document.getElementById("taskTitle").value;
    const description = document.getElementById("taskDescription").value;
    const status = document.getElementById("taskStatus").value;

    if (!title || !description || !status) {
        alert("Please fill in all fields.");
        return;
    }

    const newTask = { title, description, status };

    axios.post(apiUrl, newTask)
        .then(response => {
            getTasks(); // Refresh the task list
            document.getElementById("taskTitle").value = '';
            document.getElementById("taskDescription").value = '';
            document.getElementById("taskStatus").value = 'Not Started';
        })
        .catch(error => {
            console.error("Error creating task:", error);
        });
}

// Delete task
function deleteTask(taskId) {
    axios.delete(`${apiUrl}/${taskId}`)
        .then(response => {
            getTasks(); // Refresh the task list
        })
        .catch(error => {
            console.error("Error deleting task:", error);
        });
}

// Initial call to fetch tasks
getTasks();
