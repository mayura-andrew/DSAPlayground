package main

import "fmt"






func main(){
	arr := []int{12, 11, 13, 5, 6, 7}
	HeapSort(arr)
	fmt.Println(arr)

	arr = []int{12, 11, 13, 5, 6, 7}
	heapSort(arr)
	fmt.Println(arr)


	arr = []int{12, 11, 13, 5, 6, 7}
	heap := []int{}
	for _, v := range arr {
		heap = insert(heap, v)
	}

	for i := 0; i < len(arr); i++ {
		heap, max := extractMax(heap)

		fmt.Println(max)
		fmt.Println(heap)
	}

	arr = []int{12, 11, 13, 5, 6, 7}
	heap = []int{}
	for _, v := range arr {
		heap = insert(heap, v)
	}

	heap = remove(heap, 2)
	for i := 0; i < len(heap); i++ {
		fmt.Println(heap[i])
	}

	arr = []int{12, 11, 13, 5, 6, 7}
	heap = []int{}
	for _, v := range arr {
		heap = insert(heap, v)
	}

	heap = deleteRoot(heap)
	for i := 0; i < len(heap); i++ {
		fmt.Println(heap[i])
	}
}

func HeapSort(arr []int) {
	n := len(arr)

	for i := n/2 - 1; i >= 0; i-- {
		heapify(arr, n, i)
	}

	for i := n - 1; i > 0; i-- {
		arr[0], arr[i] = arr[i], arr[0]
		heapify(arr, i, 0)
	}
}



func heapify(arr []int, n, i int) {
	largest := i
	l := 2*i + 1
	r := 2*i + 2

	if l < n && arr[l] > arr[largest] {
		largest = l
	}

	if r < n && arr[r] > arr[largest] {
		largest = r
	}

	if largest != i {
		arr[i], arr[largest] = arr[largest], arr[i]
		heapify(arr, n, largest)
	}
}

func heapSort(arr []int) {	
	n := len(arr)
	for i := n/2 - 1; i >= 0; i-- {
		bubbleUp(arr, i)
	}

	for i := n - 1; i > 0; i-- {
		arr[0], arr[i] = arr[i], arr[0]
		bubbleDown(arr, 0, i)
	}

	
}

func bubbleUp(arr []int, index int) {
	if index == 0 {
		return
	}

	parent := (index - 1) / 2
	if arr[parent] < arr[index] {
		arr[parent], arr[index] = arr[index], arr[parent]
		bubbleUp(arr, parent)
	}
}

func bubbleDown(arr []int, index, n int) {
	left := 2*index + 1
	right := 2*index + 2

	if left >= n {
		return
	}

	largest := left
	if right < n && arr[right] > arr[left] {
		largest = right
	}

	if arr[index] > arr[largest] {
		return
	}

	arr[index], arr[largest] = arr[largest], arr[index]
	bubbleDown(arr, largest, n)
}

func insert(heap []int, key int) []int {
	heap = append(heap, key)
	bubbleUp(heap, len(heap) - 1)
	return heap
}

func extractMax(heap []int) ([]int, int) {
	if len(heap) == 0 {
		return heap, -1
	}

	max := heap[0]
	heap[0] = heap[len(heap) - 1]
	heap = heap[:len(heap) - 1]
	bubbleDown(heap, 0, len(heap))
	return heap, max
}

func remove(heap []int, index int) []int {
	heap[index] = heap[len(heap) - 1]
	heap = heap[:len(heap) - 1]
	bubbleDown(heap, index, len(heap))
	return heap
}

func deleteRoot(heap []int) []int {
	if len(heap) == 0 {
		return heap
	}
	heap[0], heap[len(heap) - 1] = heap[len(heap) - 1], heap[0]
	heap = heap[:len(heap) - 1]
	bubbleDown(heap, 0, len(heap))
	return heap
}