import Restaurant from './Restaurant';

// data structure for saved restaurant data
class SavedRestaurant extends Restaurant {
    constructor(name, cuisine, location, rating, menu) {
        super(name, cuisine, location, rating);
        this.isSaved = true; // Indicates that this restaurant is saved
        this.menu = menu; // Menu of the saved restaurant
    }

    getDetails() {
        return `Saved Restaurant: ${this.name}, Cuisine: ${this.cuisine}, Location: ${this.location}, Rating: ${this.rating}`;
    }
    
    getName() {
        return this.name;
    }

    getCuisine() {
        return this.cuisine;
    }

    getLocation() {
        return this.location;
    }

    getRating() {
        return this.rating;
    }

    getMenu() {
        return this.menu; // Returns the menu of the saved restaurant
    }
    
    getIsSaved() {
        return this.isSaved; // Returns true indicating that this restaurant is saved
    }
}

export default SavedRestaurant;