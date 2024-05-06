package main

import (
	"fmt"

)

func main() {
    // Sample user's dining history
    userDiningHistory := []Restaurant{
        {Name:"Restaurant A", CuisineType: "Italian", PriceRange: 2000, Rating: 4.5, NumReviews: 1000},
        {Name: "Restaurant B", CuisineType: "Mexican", PriceRange:2000, Rating:4.2, NumReviews: 800},
        {Name: "Restaurant C", CuisineType: "Italian", PriceRange:4000, Rating:4.7, NumReviews: 500},
        {Name: "Restaurant D", CuisineType: "Indian", PriceRange:2000, Rating:3.8, NumReviews: 300},
		{Name: "Restaurant E", CuisineType:"Italian", PriceRange:3000, Rating:4.5, NumReviews: 1000},
        {Name: "Restaurant F", CuisineType:"Mexican", PriceRange:2000, Rating:4.2, NumReviews: 800},
        {Name: "Restaurant G", CuisineType:"Italian", PriceRange:4000, Rating:4.7, NumReviews: 500},
        {Name: "Restaurant H", CuisineType:"Indian", PriceRange:2000, Rating:3.8, NumReviews: 500},
        {Name: "Restaurant I", CuisineType:"Mexican", PriceRange:2000, Rating:4.1, NumReviews: 700}, 
		{Name: "Restaurant J", CuisineType:"Sri Lankan", PriceRange:1000, Rating:4.1, NumReviews: 700},
        {Name: "Restaurant K", CuisineType:"Sri Lankan", PriceRange:3000, Rating:4.5, NumReviews: 1000},
        {Name: "Restaurant L", CuisineType:"Austrilian", PriceRange:3000, Rating:4.5, NumReviews: 1000},
        {Name: "Restaurant G", CuisineType:"Italian", PriceRange:4000, Rating:4.7, NumReviews: 500},
    }

    catalog := []Restaurant{
        {Name: "R1", CuisineType: "Italian", PriceRange: 3000, Rating: 4.5, NumReviews: 1000},
        {Name: "R2", CuisineType: "Mexican", PriceRange: 1000, Rating: 4.2, NumReviews: 800},
        {Name: "R3", CuisineType: "Indian", PriceRange: 2000, Rating: 4.7, NumReviews: 1200},
        {Name: "R4", CuisineType: "Italian", PriceRange: 4000, Rating: 4.6, NumReviews: 1100},
        {Name: "R5", CuisineType: "", PriceRange: 500, Rating: 4.3, NumReviews: 850},
        {Name: "R6", CuisineType: "Chinese", PriceRange: 2000, Rating: 4.8, NumReviews: 1250},
        {Name: "R7", CuisineType: "Italian", PriceRange: 1000, Rating: 4.4, NumReviews: 950},
        {Name: "R8", CuisineType: "Sri Lankan", PriceRange: 4000, Rating: 4.1, NumReviews: 750},
        {Name: "R9", CuisineType: "Sri Lankan", PriceRange: 2000, Rating: 4.9, NumReviews: 1300},
    }


    // Sample user's preferences
    userPreferences := UserPreferences{
        PreferredCuisines:     []string{"Mexican", "Italian", "Sri Lankan"},
        PreferredPriceRange:   3000,
    }

    // Call the userDiningProfile function
    userInterests , restaurantBSTs := userDiningProfile(userDiningHistory, userPreferences)

    // Print the cuisine types of interest and the corresponding BSTs
    for cuisineType, bst := range restaurantBSTs {
        fmt.Printf("Cuisine Type: %s\n", cuisineType)
        printBST(bst)
        fmt.Println()
    }

	fmt.Println("------")
    fmt.Println(userInterests)

	fmt.Println("------")

    // Search for restaurants based on a specific criteria
    criteria := func(r Restaurant) bool {
        return r.Rating >= 2.0 || r.NumReviews >= 100
    }

    for cuisineType, bst := range restaurantBSTs {
        fmt.Printf("Restaurants in %s cuisine type matching the criteria:\n", cuisineType)
        matchingRestaurants := searchRestaurants(cuisineType, criteria, bst)
        for _, restaurant := range matchingRestaurants {
            fmt.Printf("%s (Rating: %.1f, Reviews: %.0f)\n", restaurant.Name, restaurant.Rating, restaurant.NumReviews)
        }
        fmt.Println()
    }

    fmt.Println("----------")
    rankedRestaurants := rankRestaurantsByPopularity(userInterests, catalog)
    fmt.Println(rankedRestaurants)
    fmt.Println("----------")

    fmt.Println("Recommendation")
    recommendations := generatePersonalizedRecommndations(userInterests, rankedRestaurants)
    fmt.Println(recommendations)

    k := 10
    fmt.Println("TOp Recommendation")

    topK := getTopKRecommendations(recommendations, k, "Sri Lankan")
    
    for _, restaurant := range topK {
        fmt.Println(restaurant)
    }
}
