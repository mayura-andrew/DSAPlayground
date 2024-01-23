package main

import "fmt"

func main(){
	fmt.Println("Hello world")
	n := Factorial(3)
	fmt.Println(n)
	x := FibSum(0)
	fmt.Printf("%d\n", x) // Convert x to a string using %d format specifier
	x = FibSum(1) // Added missing variable declaration
	fmt.Printf("%d\n", x) // Convert xy to a string using %d format specifier
	x = FibSum(5)
	fmt.Printf("%d\n", x)
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
