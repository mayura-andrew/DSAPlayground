package main






func main(){
	arr := []int{1, 2, 3, 4, 5}
	index := BinarySearch2(arr, 5)
	if index != -1 {
		println("Found at index: ", index)
	} else {
		println("Not found")
	}
}

func BinarySearch(arr []int, target int) int {
	low, high := 0, len(arr) - 1
	for low <= high {
		mid := (high + low) / 2
		if arr[mid] == target {
			return mid
		} else if arr[mid] < target {
			low = mid + 1
		} else {
			high = mid - 1
		}
	}
	return -1
}

func BinarySearch2(arr []int, target int) int {
	low, high := 0, len(arr) - 1
	found := false
	mid := 0
	for low <= high && !found {
		mid = (high + low) / 2
		if arr[mid] == target {
			found = true
		} else if target < arr[mid] {
			high = mid - 1
		} else {
			low = mid + 1
		}
	}
	if !found {
		mid = -1
	}
	return mid	
}