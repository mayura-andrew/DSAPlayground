package main

// import "fmt"

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
		// heap := make(restaurantHeap, 0)
		cuisineRestaurants := make([]Restaurant, 0)
		for _, restaurant := range catalog {
			if restaurant.CuisineType == cuisineType {
				// score := calculatePopupalarityScore(restaurant)
				// heap.Push(restaurantEntry{restaurant, score, len(heap)})
				// fmt.Println(score)
				cuisineRestaurants = append(cuisineRestaurants, restaurant)
			}
		}

		// topRestaurants := make([]Restaurant, 0)
		// for heap.Len() > 0 {
		// 	entry := heap.Pop().(restaurantEntry)
		// 	topRestaurants = append(topRestaurants, entry.restaurant)
		// }
		heapSort(cuisineRestaurants)

		rankings[cuisineType] = cuisineRestaurants
	}
	return rankings
}

func heapify(arr []Restaurant, n int, i int) {
	largest := i
	left := 2*i + 1
	right := 2*i + 2

	if left < n && calculatePopupalarityScore(arr[left]) < calculatePopupalarityScore(arr[largest]){
		largest = left
	}
	if right < n && calculatePopupalarityScore(arr[right]) < calculatePopupalarityScore(arr[largest]){
		largest = right
	}

	if largest != i {
		arr[i], arr[largest] = arr[largest], arr[i]
		heapify(arr, n, largest)
	}
}

func heapSort (arr []Restaurant) {
	n := len(arr)

	for i := n/2 - 1; i >= 0; i-- {
		heapify(arr, n, i)
	}

	for i := n - 1 ; i > 0; i-- {
		arr[0], arr[i] = arr[i], arr[0]
		heapify(arr, i, 0)
	}
}