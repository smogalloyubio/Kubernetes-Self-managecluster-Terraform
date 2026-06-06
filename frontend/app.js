const API_URL = '/api/books';

// Centralized state management
let state = {
    books: [],
    loading: false,
    error: null
};

// --- API Methods ---

async function fetchBooks() {
    state.loading = true;
    try {
        const response = await fetch(API_URL);
        if (!response.ok) throw new Error('Failed to fetch books');
        state.books = await response.json();
        state.error = null;
    } catch (err) {
        state.error = err.message;
        console.error('API Error:', err);
    } finally {
        state.loading = false;
        renderDashboard();
    }
}

async function addBook(bookData) {
    try {
        const response = await fetch(API_URL, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(bookData)
        });
        if (!response.ok) throw new Error('Failed to add book');
        showToast('Book added successfully!', 'success');
        return true;
    } catch (err) {
        showToast(err.message, 'danger');
        return false;
    }
}

async function updateBook(id, bookData) {
    try {
        const response = await fetch(`${API_URL}/${id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(bookData)
        });
        if (!response.ok) throw new Error('Failed to update book');
        showToast('Book updated successfully!', 'success');
        return true;
    } catch (err) {
        showToast(err.message, 'danger');
        return false;
    }
}

async function deleteBook(id) {
    if (!confirm('Are you sure you want to delete this book?')) return;
    
    try {
        const response = await fetch(`${API_URL}/${id}`, { method: 'DELETE' });
        if (!response.ok) throw new Error('Failed to delete book');
        showToast('Book deleted.', 'info');
        fetchBooks();
    } catch (err) {
        showToast(err.message, 'danger');
    }
}

// --- UI Rendering ---

function renderDashboard() {
    const grid = document.getElementById('book-grid');
    const statsContainer = document.getElementById('stats-container');
    if (!grid) return;

    if (state.loading) {
        grid.innerHTML = '<div class="col-12 text-center p-5"><div class="spinner-border text-primary"></div></div>';
        return;
    }

    if (state.error) {
        grid.innerHTML = `<div class="col-12"><div class="alert alert-danger">${state.error}</div></div>`;
        return;
    }

    // Update Stats
    const total = state.books.length;
    const available = state.books.filter(b => b.available).length;
    const borrowed = total - available;

    if (statsContainer) {
        document.getElementById('stat-total').textContent = total;
        document.getElementById('stat-available').textContent = available;
        document.getElementById('stat-borrowed').textContent = borrowed;
    }

    // Render Grid
    grid.innerHTML = '';
    if (total === 0) {
        grid.innerHTML = '<div class="col-12 text-center p-5 text-muted"><h4>Your library is empty.</h4><p>Add your first book to get started!</p></div>';
        return;
    }

    state.books.forEach(book => {
        const col = document.createElement('div');
        col.className = 'col-md-6 col-lg-4 mb-4';
        col.innerHTML = `
            <div class="book-card card">
                <div class="card-body d-flex flex-column">
                    <div class="d-flex justify-content-between align-items-start mb-2">
                        <span class="badge book-badge ${book.available ? 'bg-success-subtle text-success' : 'bg-warning-subtle text-warning'} border ${book.available ? 'border-success' : 'border-warning'}">
                            ${book.available ? 'Available' : 'Borrowed'}
                        </span>
                        <small class="text-muted">${book.isbn}</small>
                    </div>
                    <h5 class="card-title mt-2 mb-1">${book.title}</h5>
                    <p class="text-muted mb-4">${book.author}</p>
                    <div class="mt-auto pt-3 border-top border-secondary-subtle d-flex justify-content-between">
                        <a href="edit-book.html?id=${book.id}" class="btn btn-sm btn-outline-light">Edit</a>
                        <button onclick="deleteBook(${book.id})" class="btn btn-sm btn-outline-danger">Delete</button>
                    </div>
                </div>
            </div>
        `;
        grid.appendChild(col);
    });
}

// --- Utility Functions ---

function showToast(message, type = 'info') {
    const container = document.getElementById('toast-container');
    if (!container) return;

    const toast = document.createElement('div');
    toast.className = `alert alert-${type} alert-dismissible fade show shadow-sm`;
    toast.innerHTML = `
        ${message}
        <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
    `;
    container.appendChild(toast);
    setTimeout(() => {
        toast.classList.remove('show');
        setTimeout(() => toast.remove(), 500);
    }, 4000);
}

// Search Functionality
function setupSearch() {
    const searchInput = document.getElementById('search-books');
    if (!searchInput) return;

    searchInput.addEventListener('input', (e) => {
        const query = e.target.value.toLowerCase();
        const filtered = state.books.filter(b => 
            b.title.toLowerCase().includes(query) || 
            b.author.toLowerCase().includes(query) ||
            b.isbn.includes(query)
        );
        renderFilteredGrid(filtered);
    });
}

function renderFilteredGrid(filteredBooks) {
    const grid = document.getElementById('book-grid');
    if (!grid) return;
    grid.innerHTML = '';
    
    if (filteredBooks.length === 0) {
        grid.innerHTML = '<div class="col-12 text-center p-5 text-muted"><h4>No books match your search.</h4></div>';
        return;
    }

    filteredBooks.forEach(book => {
        const col = document.createElement('div');
        col.className = 'col-md-6 col-lg-4 mb-4';
        col.innerHTML = `
            <div class="book-card card">
                <div class="card-body d-flex flex-column">
                    <div class="d-flex justify-content-between align-items-start mb-2">
                        <span class="badge book-badge ${book.available ? 'bg-success-subtle text-success' : 'bg-warning-subtle text-warning'} border ${book.available ? 'border-success' : 'border-warning'}">
                            ${book.available ? 'Available' : 'Borrowed'}
                        </span>
                        <small class="text-muted">${book.isbn}</small>
                    </div>
                    <h5 class="card-title mt-2 mb-1">${book.title}</h5>
                    <p class="text-muted mb-4">${book.author}</p>
                    <div class="mt-auto pt-3 border-top border-secondary-subtle d-flex justify-content-between">
                        <a href="edit-book.html?id=${book.id}" class="btn btn-sm btn-outline-light">Edit</a>
                        <button onclick="deleteBook(${book.id})" class="btn btn-sm btn-outline-danger">Delete</button>
                    </div>
                </div>
            </div>
        `;
        grid.appendChild(col);
    });
}
