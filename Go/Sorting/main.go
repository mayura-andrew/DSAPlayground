package main

import "fmt"







func main() {
	// fmt.Println("Hello world")

	arr := []int{3, 2, 1, 5, 4}
	fmt.Println(arr)
	fmt.Println(MergeSort(arr))

	fmt.Println(maxSort(arr))
	fmt.Println(selectionSort(arr))
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
			fmt.Println(result)
			l++
		} else {
			result = append(result, right[r])
			fmt.Println(result)
			r++
		}

	}
	fmt.Println(result)

	result = append(result, left[l:]...)
	fmt.Println(result)
	result = append(result, right[r:]...)
	fmt.Println(result)

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
