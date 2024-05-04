package main

import "fmt"

type restaurantEntry struct {
	restaurant Restaurant
	score      float64
	index      int
}

type restaurantHeap []restaurantEntry

func (h restaurantHeap) Len() int {
	return len(h)
}
func (h restaurantHeap) Less(i, j int) bool {
	return h[i].score > h[j].score
}

func (h restaurantHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
	h[i].index = i
	h[j].index = j
}

func (h *restaurantHeap) Push(x interface{}) {
	n := len(*h)
	entry := x.(restaurantEntry)
	entry.index = n
	*h = append(*h, entry)
}

func (h *restaurantHeap) Pop() interface{} {
	old := *h
	n := len(old)
	entry := old[n-1]
	old[n-1] = restaurantEntry{}
	*h = old[0 : n-1]
	return entry
}

func calculatePopupalarityScore(restaurant Restaurant) float64 {
	rating := restaurant.Rating
	numReviews := restaurant.NumReviews

	popularityScore := (rating*numReviews/rating + numReviews)

	return popularityScore

}

func rankRestaurantsByPopularity(profile map[string]int, catalog []Restaurant) map[string][]Restaurant {
	rankings := make(map[string][]Restaurant)

	for cuisineType := range profile {
		heap := make(restaurantHeap, 0)

		for _, restaurant := range catalog {
			if restaurant.CuisineType == cuisineType {
				score := calculatePopupalarityScore(restaurant)
				heap.Push(restaurantEntry{restaurant, score, len(heap)})
				fmt.Println(score)
			}
		}

		topRestaurants := make([]Restaurant, 0)
		for heap.Len() > 0 {
			entry := heap.Pop().(restaurantEntry)
			topRestaurants = append(topRestaurants, entry.restaurant)
		}

		rankings[cuisineType] = topRestaurants
	}
	return rankings
}