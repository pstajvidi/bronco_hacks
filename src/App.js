import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import RestaurantRecommender from './RestaurantRecommender';
import RestaurantPage from './RestaurantPage';
import Login from './Login';
import { RestaurantsProvider } from './RestaurantsContext';

function App() {
  return (
    <RestaurantsProvider>
      <Router>
        <div className="App">
          <Routes>
            <Route path="/" element={<Login />} />
            <Route path="/recommender" element={<RestaurantRecommender/>} />
            <Route path="/restaurant" element={<RestaurantPage/>} />
          </Routes>
        </div>
      </Router>
    </RestaurantsProvider>
  );
}

export default App;
