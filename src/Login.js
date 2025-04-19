import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const navigate = useNavigate();

    // Simple authentication check
    const handleSubmit = (event) => {
        event.preventDefault();
        setError('');

        // Basic validation
        if (!username || !password) {
            setError('Both fields are required');
            return;
        }

        // Mock authentication - replace with real API call
        if (password.length >= 6) { // Simple password length check
            // Navigate to restaurant page with username as URL parameter
            navigate(`/recommender?user=${encodeURIComponent(username)}`);
            
            // Store username in localStorage (for demonstration)
            //localStorage.setItem('username', username);
            sessionStorage.setItem('authToken', 'mock-token');
        } else {
            setError('Password must be at least 6 characters');
        }
    };


    return (
        <div className="container">
            <h1>Login</h1>
            {error && (
                <div className="alert alert-danger" role="alert" style={{ 
                    color: '#d9534f'}}>
                    {error}
                </div>
            )}
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label htmlFor="username">Username</label>
                    <input
                        type="text"
                        className="form-control"
                        id="username"
                        name="username"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="password">Password</label>
                    <input
                        type="password"
                        className="form-control"
                        id="password"
                        name="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                </div>
                <button type="submit" className="btn btn-primary">Login</button>
            </form>
        </div>
    );
};

export default Login;