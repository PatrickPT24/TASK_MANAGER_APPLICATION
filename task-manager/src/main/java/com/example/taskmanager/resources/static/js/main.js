// Login Event Listener
document.getElementById('login-form').addEventListener('submit', function(e) {
    e.preventDefault();
    const email = document.getElementById('email').value;
    localStorage.setItem('loggedInUser', email);
    window.location.href = 'dashboard.html';
});

// Logout function
document.getElementById('logout')?.addEventListener('click', function() {
    localStorage.removeItem('loggedInUser');
    window.location.href = 'index.html';
});

// Dashboard - Display logged-in user email
document.addEventListener('DOMContentLoaded', function() {
    const email = localStorage.getItem('loggedInUser');
    if (email) document.getElementById('user-email').textContent = email;
});
