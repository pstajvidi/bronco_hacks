import React, {createContext} from 'react';
import SavedRestaurant from './SavedRestaurant';

// create context for restaurants
export const RestaurantsContext = createContext();

// provider component to manage saved restaurants
export const RestaurantsProvider = ({children}) => {
    const [savedRestaurants, setSavedRestaurants] = React.useState([
        new SavedRestaurant("Sushi Spot", "Japanese", "456 Elm St", 4.8, ["Sushi", "Ramen"]),
        new SavedRestaurant("Taco Town", "Mexican", "654 Pine St", 4.6, ["Tacos", "Burritos"]),
    ]);

    return (
        <RestaurantsContext.Provider value={{ savedRestaurants, setSavedRestaurants }}>
            {children}
        </RestaurantsContext.Provider>
    );
};