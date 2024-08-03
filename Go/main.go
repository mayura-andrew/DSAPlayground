package main

import "fmt"

func main(){
	fmt.Println("Hello world")
	// n := Factorial(3)
	// fmt.Println(n)
	// x := FibSum(0)
	// fmt.Printf("%d\n", x) // Convert x to a string using %d format specifier
	// x = FibSum(1) // Added missing variable declaration
	// fmt.Printf("%d\n", x) // Convert xy to a string using %d format specifier
	// x = FibSum(5)
	// fmt.Printf("%d\n", x)

	arr := []int{3, 2, 1, 5, 4, 10, 34, 21, 4, 2, 4, 6, 3, 2, 1, 5, 4, 10, 34, 21, 4, 2, 4, 6}
	fmt.Println(MergeSort(arr))
}


func MergeSort(arr []int) []int {
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

func Factorial(n int) int  {
	// Base Case
	if n == 0 {
		return 1
	} else {
		fact := Factorial(n-1)
		return n * fact
	}
}

func FibSum(n int) int {
	// Base Case
	if (n == 0) {
		return 0
	} else if (n == 1) {
		return 1
	} else {
		return FibSum(n-1)  + FibSum(n-2)
	}
}
