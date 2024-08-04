package main

import (
    "fmt"
    "math/rand"
    "time"
)

func main() {
    // Seed the random number generator
    rand.Seed(time.Now().UnixNano())

    // Generate an array of 1000 random integers
    arr := make([]int, 100)
    for i := range arr {
        arr[i] = rand.Intn(100) // Random integer between 0 and 999
    }

    // Measure and print the time taken by MergeSort
    start := time.Now()
    MergeSort(arr)
    fmt.Println("MergeSort took:", time.Since(start))

    // Measure and print the time taken by maxSort
    start = time.Now()
    maxSort(arr)
    fmt.Println("maxSort took:", time.Since(start))

    // Measure and print the time taken by selectionSort
    start = time.Now()
    selectionSort(arr)
    fmt.Println("selectionSort took:", time.Since(start))

    // Measure and print the time taken by bubbleSort
    start = time.Now()
    bubbleSort(arr)
    fmt.Println("bubbleSort took:", time.Since(start))

    // Measure and print the time taken by insertionSort
    start = time.Now()
    insertionSort(arr)
    fmt.Println("insertionSort took:", time.Since(start))

	// Measure and print the time taken by quickSort
	start = time.Now()
	quickSort(arr)
	fmt.Println("quickSort took:", time.Since(start))

}


func MergeSort(arr []int) []int{

	if len(arr) <= 1 {
		return arr
	}

	mid := len(arr) / 2
	left := MergeSort(arr[:mid])
	right := MergeSort(arr[mid:])

	return merge(left, right)
}


func merge(left, right []int) []int {
	var result []int
	l, r := 0, 0

	for l < len(left) && r < len(right) {
		if left[l] < right[r] {
			result = append(result, left[l])
			l++
		} else {
			result = append(result, right[r])
			r++
		}

	}

	result = append(result, left[l:]...)
	result = append(result, right[r:]...)

	return result
} 


func maxSort(arr []int) []int {
	for i := 0; i < len(arr); i++ {
		max := i
		for j := i + 1; j < len(arr); j++ {
			if arr[j] > arr[max] {
				max = j
			}
		}
		arr[i], arr[max] = arr[max], arr[i]
	}
	return arr
}

func selectionSort(arr []int) []int {
	for i := 0; i < len(arr); i++ {
		min := i
		for j := i + 1; j < len(arr); j++ {
			if arr[j] < arr[min] {
				min = j
			}
		}
		arr[i], arr[min] = arr[min], arr[i]
	}
	return arr
}

func bubbleSort(arr []int) []int {
	for i := 0; i < len(arr); i++ {
		for j := 0; j < len(arr) - i - 1; j++ {
			if arr[j] > arr[j + 1] {
				arr[j], arr[j + 1] = arr[j + 1], arr[j]
			}
		}
	}
	return arr
}


func insertionSort(arr []int) []int {
	for i:= 1; i < len(arr); i++ {
		key := arr[i]
		j := i - 1
		for j >= 0 && arr[j] > key {
			arr[j+1] = arr[j]
			j--
		}
		arr[j+1] = key
 	}
	return arr
}


func quickSort(arr []int) []int {
	if len(arr) <= 1 {
		return arr
	}

	left, right := 0, len(arr) - 1
	pivot := rand.Int() % len(arr)

	arr[pivot], arr[right] = arr[right], arr[pivot]

	for i := range arr {
		if arr[i] < arr[right] {
			arr[i], arr[left] = arr[left], arr[i]
			left++
		}
	}

	arr[left], arr[right] = arr[right], arr[left]

	quickSort(arr[:left])
	quickSort(arr[left + 1:])

	return arr
}
