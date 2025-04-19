// data structure for restaurant data
class Restaurant {

    constructor(name, cuisine, location, rating) {
        this.name = name;
        this.cuisine = cuisine;
        this.location = location;
        this.rating = rating;
        this.isSaved = false;
    }

    getDetails() {
        return `Restaurant: ${this.name}, Cuisine: ${this.cuisine}, Location: ${this.location}, Rating: ${this.rating}`;
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

    getIsSaved() {
        return this.isSaved;
    }
}

export default Restaurant;