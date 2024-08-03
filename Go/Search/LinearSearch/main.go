package main







func main(){
	arr := []int{1, 2, 3, 4, 5}
	index := LinearSearch2(arr, 9)
	if index != -1 {
		println("Found at index: ", index)
	} else {
		println("Not found")
	}
}

func LinearSearch(arr []int, target int) int {
	for i := 0; i < len(arr); i++ {
		if arr[i] == target {
			return i
		}
	}
	return -1
}


func LinearSearch2(arr []int, target int) int {
	index := 0
	for index < len(arr) && arr[index] != target{
		index++
	}
	if index >= len(arr){
		index = -1
	}
	return index
}