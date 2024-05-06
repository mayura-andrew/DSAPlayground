package main

func generatePersonalizedRecommndations(userInterests map[string]int, rankings map[string][]Restaurant) []Restaurant {
    var recommendations []Restaurant

    for cuisineType, count := range userInterests {
		restaurants := rankings[cuisineType]

		if len(restaurants) > count {
			restaurants = restaurants[:count]
		}
        recommendations = append(recommendations, restaurants...)
    }

    return recommendations

}

func binarySearch(recommendations []Restaurant, target int) int {
	left := 0
	right := len(recommendations) -1

	for left <= right {
		mid := (left + right ) / 2

		if mid == target {
			return mid
		} else if mid < target {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return -1
}


func getTopKRecommendations(recommendations []Restaurant, k int, cuisineType string) []Restaurant {
    topK := make([]Restaurant, 0 , k)
    filteredRecommendations := make([]Restaurant, 0)


    for _, restaurant := range recommendations {
        if restaurant.CuisineType == cuisineType {
            filteredRecommendations = append(filteredRecommendations, restaurant)
        }
    }


    for i := 0; i < k && i < len(filteredRecommendations); i++ {
        index := binarySearch(filteredRecommendations, i)
        if index != -1 {
            topK = append(topK, filteredRecommendations[index])
        }
    }
    return topK
}
