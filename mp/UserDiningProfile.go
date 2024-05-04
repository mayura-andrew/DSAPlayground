package main

import "fmt"

type Restaurant struct {
	Name        string
	CuisineType string
	Rating      float64
	NumReviews  float64
	PriceRange  int 
}

type RestaurantNode struct {
	restaurant Restaurant
	left       *RestaurantNode
	right      *RestaurantNode
	height int
}

var restaurantBSTs = make(map[string]*RestaurantNode)

type UserPreferences struct {
	PreferredCuisines   []string
	PreferredPriceRange int
}

type pair struct {
	Key   string
	Value int
}

func quickSort(pairs []pair, low, high int) {
	if low < high {
		pi := partition(pairs, low, high)
		quickSort(pairs, low, pi-1)
		quickSort(pairs, pi+1, high)
	}
}

func partition(pairs []pair, low, high int) int {
	pivot := pairs[high]
	i := low - 1

	for j := low; j <= high-1; j++ {
		if pairs[j].Value > pivot.Value {
			i++
			pairs[i], pairs[j] = pairs[j], pairs[i]
		}
	}

	pairs[i+1], pairs[high] = pairs[high], pairs[i+1]
	return i + 1

}
func userDiningProfile(history []Restaurant, preferences UserPreferences) (map[string]int, map[string]*RestaurantNode) {
	cuisineFrequency := make(map[string]int)
	cuisinePriceTotal := make(map[string]int)
	cuisineCount := make(map[string]int)
	preferredCuisines := make(map[string]bool)

	for _, preferred := range preferences.PreferredCuisines {
		preferredCuisines[preferred] = true
	}

	
	for _, restaurant := range history {
		cuisineType := restaurant.CuisineType
		cuisineFrequency[cuisineType]++
		cuisinePriceTotal[cuisineType] += restaurant.PriceRange
		cuisineCount[cuisineType]++
	}

	fmt.Println(cuisineFrequency)
	
	pairs := make([]pair, 0, len(cuisineFrequency))
	for k, v := range cuisineFrequency {
		pairs = append(pairs, pair{k, v})
	}
	fmt.Println(pairs)

	cuisineFrequencySlice := make([]pair, 0, len(cuisineFrequency))
	for k, v := range cuisineFrequency {
		cuisineFrequencySlice = append(cuisineFrequencySlice, pair{k, v})
	}

	quickSort(cuisineFrequencySlice, 0, len(cuisineFrequencySlice)-1)

	fmt.Println(cuisineFrequencySlice)

	userInterests := make(map[string]int)

	for _, pair := range cuisineFrequencySlice {
		cuisineType := pair.Key

		if preferredCuisines[cuisineType] {
			average := cuisinePriceTotal[cuisineType] / cuisineCount[cuisineType]
			if abs(average - preferences.PreferredPriceRange) <= 1000 {
				root := restaurantBSTs[cuisineType]
				for _, restaurant := range history {
					if restaurant.CuisineType == cuisineType {
						root = intertNode(root, restaurant)
					}
				}
				restaurantBSTs[cuisineType] = root
				userInterests[cuisineType] = cuisineFrequency[cuisineType]
			}
		}
	}

	return userInterests, restaurantBSTs
}

func height(node *RestaurantNode) int {
	if node == nil {
		return 0
	}
	return node.height
}

func max(a, b int) int {
	if a > b {
		return a 
	}
	return b
}

func rotateRight(y *RestaurantNode) *RestaurantNode {
	x := y.left
	T2 := x.right

	x.right = y
	y.left = T2

	y.height = max(height(y.left), height(y.right)) + 1
	x.height = max(height(x.left), height(x.right)) + 1

	return x
}

func rotateLeft(x *RestaurantNode) *RestaurantNode {
	y := x.right
	T2 := y.left

	y.left = x
	x.right = T2

	x.height = max(height(x.left), height(x.right)) + 1
	y.height = max(height(y.left), height(y.right)) + 1

	return y
}

func getBalance(node *RestaurantNode) int {
	if node == nil {
		return 0
	}
	return height(node.left) - height(node.right)
}
func intertNode(node *RestaurantNode, restaurant Restaurant) *RestaurantNode {
	if node == nil {
		return &RestaurantNode{restaurant: restaurant, height: 1}
	}

	if restaurant.Rating < node.restaurant.Rating {
		node.left = intertNode(node.left, restaurant)
	} else if restaurant.Rating > node.restaurant.Rating {
		node.right = intertNode(node.right, restaurant)
	} else {
		return node
	}

	node.height = 1 + max(height(node.left), height(node.right))

	balance := getBalance(node)

	if balance > 1 && restaurant.Rating < node.left.restaurant.Rating {
		return rotateRight(node)
	}
	 
	if balance < -1 && restaurant.Rating > node.right.restaurant.Rating {
		return rotateLeft(node)
	}

	if balance > 1 && restaurant.Rating > node.left.restaurant.Rating {
		node.left = rotateLeft(node.left)
		return rotateRight(node)
	}

	if balance < -1 && restaurant.Rating < node.right.restaurant.Rating {
		node.right = rotateRight(node.right)
		return rotateLeft(node)
	}

	return node
}

// Updated searchRestaurants function to take a BST root as input
func searchRestaurants(_ string, criteria func(Restaurant) bool, bst *RestaurantNode) []Restaurant {
	var results []Restaurant
	searchBST(bst, criteria, &results)
	return results
}

// Updated searchBST function to take a BST root as input
func searchBST(root *RestaurantNode, criteria func(Restaurant) bool, results *[]Restaurant) {
	if root == nil {
		return
	}

	if criteria(root.restaurant) {
		*results = append(*results, root.restaurant)
	}

	searchBST(root.left, criteria, results)
	searchBST(root.right, criteria, results)
}

// func matchesPriceRange(history []Restaurant, cuisineType string, preferredPriceRange int) bool {
// 	var total int
// 	var count int

// 	for _, restaurant := range history {
// 		if restaurant.CuisineType == cuisineType {
// 			total += restaurant.PriceRange
// 			count++
// 		}
// 	}

// 	if count == 0 {
// 		return false
// 	}

// 	average := total / count
// 	return abs(average - preferredPriceRange) <= 1
// }


func abs(x int) int {
	if x <0 {
		return -x
	}
	return x
}

// Helper function to print the BST in-order traversal
func printBST(root *RestaurantNode) {
    if root == nil {
        return
    }

    printBST(root.left)
    fmt.Printf("%s (Price Range: %d)\n", root.restaurant.Name, root.restaurant.PriceRange)
    printBST(root.right)
}
