package main

import (
	"fmt"
	"time"
)

func main(){
	fmt.Println("Hello World")
	start := time.Now()
	result := Fibonacci(50, make(map[int]int))
	elapsed := time.Since(start)
	fmt.Printf("The 50th Fibonacci number is: %d\nCalculation time: %s\n", result, elapsed)

	start = time.Now()
	result = EuclidGCD(357, 234)
	elapsed = time.Since(start)
	fmt.Printf("The GCD of 357 and 234 is: %d\nCalculation time: %s\n", result, elapsed)
}

func Fibonacci(n int, memo map[int]int) int {
	if n <= 1 {
		return n
	}

	if val, ok := memo[n]; ok {
		return val
	}
	memo[n] = Fibonacci(n-1, memo) + Fibonacci(n-2, memo)
	return memo[n]
}


func EuclidGCD(a, b int) int {
	for b != 0 {
		a, b = b, a % b
	}

	return a
}