package main

import "fmt"

// stack represents stack that hold a slice
type Stack struct {
	items []int
}

// Queue represent s a queue that holds a slice
type Queue struct {
	items []int
}

// Enqueue adds a value at the end
func (q *Queue) Enqueue(i int) {
	q.items = append(q.items, i)
}

// Dequeue
func (q *Queue) Dequeue() int {
	toRemove := q.items[0]
	q.items = q.items[1:]
	return toRemove
}

// Push will add a value at the end
func (s *Stack) Push(i int) {
	s.items = append(s.items, i)
}

// Pop will remove a value at the end
// and returns the removed value
func (s *Stack) Pop() int {
	l := len(s.items) - 1
	toRemove := s.items[l]
	s.items = s.items[:l]
	return toRemove

}
func main() {
	myStack := Stack{}
	fmt.Println(myStack)
	myStack.Push(100)
	myStack.Push(200)
	myStack.Push(300)
	fmt.Println(myStack)
	myStack.Pop()
	fmt.Println(myStack)

	// Queue

	myQueue := Queue{}
	fmt.Println(myQueue)
	myQueue.Enqueue(100)
	myQueue.Enqueue(200)
	myQueue.Enqueue(300)
	myQueue.Dequeue()
	fmt.Println(myQueue)
}
