package main

// import "sort"

// type RestaurantPopularity struct {
// 	Restaurant      Restaurant
// 	PopularityScore float64
// }

// func calculatePopularity(r Restaurant) float64 {
// 	return r.Rating * r.NumReviews
// }

// func rankRestaurantsByPopularity(interests []string, catalog []Restaurant) map[string][]Restaurant {
// 	cuisineRestaurants := make(map[string][]Restaurant)

// 	for _, restaurant := range catalog {
// 		cuisineType := restaurant.CuisineType
// 		if contains(interests, cuisineType) {
// 			cuisineRestaurants[cuisineType] = append(cuisineRestaurants[cuisineType], restaurant)
// 		}
// 	}

// 	for cuisineType, restaurants := range cuisineRestaurants {
// 		sort.Slice(restaurants, func(i, j int) bool {
// 			return calculatePopularity(restaurants[i]) > calculatePopularity(restaurants[j])
// 		})

// 		cuisineRestaurants[cuisineType] = restaurants
// 	}
// 	return cuisineRestaurants
// }

// func contains(slice []string, item string) bool {
// 	for _, a := range slice {
// 		if a == item {
// 			return true
// 		}
// 	}
// 	return false
// }