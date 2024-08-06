package main






import "fmt"




type Stack struct {
	arr []int
	top int
}

func NewStack() *Stack {
	return &Stack{
		arr: make([]int, 0),
		top: -1,
	}
}

func (s *Stack) Push(x int){
	s.arr = append(s.arr, x)
	s.top++
} 

func (s *Stack) Pop() int {
	if s.IsEmpty() {
		return -1
	}

	x := s.arr[s.top]
	s.arr = s.arr[:s.top]
	s.top--
	return x
}

func (s *Stack) Peek() int {
	if s.IsEmpty(){
		return -1
	}
	return s.arr[s.top]
}

func (s *Stack) IsEmpty() bool {
	return s.top == -1
}

func (s *Stack) Size() int {
	return s.top + 1
}

type Node struct {
	data int
	next *Node
}

type StackLL struct {
	top *Node
}

func NewStackLL() *StackLL{
	return &StackLL{}
}

func (s *StackLL) Push(x int){
	newNode := &Node{
		data: x,
		next: s.top,
	}
	s.top = newNode
}

func main() {

	stack := NewStack()

	stack.Push(1)
	stack.Push(2)
	stack.Push(3)
	stack.Push(4)
	stack.Push(5)



	fmt.Println(stack)
	fmt.Println(stack.Pop())
	fmt.Println(stack)
	fmt.Println(stack.Pop())
	fmt.Println(stack)


	n := reverseString("hello")
	fmt.Println(n)

	n = reverseStringLL("hello")
	fmt.Println(n)


	fmt.Println(balancedParantheses("()"))
	fmt.Println(balancedParantheses("()[]{}"))
	fmt.Println(balancedParantheses("(]"))
	fmt.Println(balancedParantheses("([)]"))

}


func reverseString(s string) string {
	stack := NewStack()
	for _, c := range s {
		stack.Push(int(c))
	}

	var res string
	for !stack.IsEmpty() {
		res += string(stack.Pop())
	}

	return res
}

func reverseStringLL(s string) string {
	stack := NewStackLL()
	for _, c := range s {
		stack.Push(int(c))
	}

	var res string
	for stack.top != nil {
		res += string(stack.top.data)
		stack.top = stack.top.next
	}

	return res
}


func balancedParantheses(s string) bool {
	stack := NewStack()
	for _, c := range s {
		if c == '(' || c == '{' || c == '[' {
			stack.Push(int(c))
		} else {
			if stack.IsEmpty() {
				return false
			}

			if c == ')' && stack.Peek() != '(' {
				return false
			}

			if c == '}' && stack.Peek() != '{' {
				return false
			}

			if c == ']' && stack.Peek() != '[' {
				return false
			}

			stack.Pop()
		}
	}
	
	return stack.IsEmpty()
}
