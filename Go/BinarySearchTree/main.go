package main

import "fmt"

type Node struct {
	Key   int
	Left  *Node
	Right *Node
}

func (n *Node) Insert(k int) {
	if n.Key < k {
		// move right
		if n.Right == nil {
			n.Right = &Node{Key: k}
		} else {
			n.Right.Insert(k)
		}
	} else if n.Key > k {
		// move left
		if n.Left == nil {
			n.Left = &Node{Key: k}
		} else {
			n.Left.Insert(k)
		}
	}
}

// Search will take in a key value
// and RETURN true if there is a node with that value
func (n *Node) Search(k int) bool {
	if n == nil {
		return false
	}
	if n.Key < k {
		// move right
		return n.Right.Search(k)
	} else if n.Key > k {
		// move left
		return n.Left.Search(k)
	}
	return true
}

func (n *Node) PreOrder() {
	if (n == nil) {
		return
	}
	fmt.Println(n.Key)
	n.Left.PreOrder()
	n.Right.PreOrder()	
}

func (n *Node) PostOrder() {
	if (n == nil) {
		return
	}
	n.Left.PostOrder()
	n.Right.PostOrder()
	fmt.Println(n.Key)
}

func (n *Node) InOrder() {
	if (n == nil) {
		return
	}
	n.Left.InOrder()
	fmt.Println(n.Key)
	n.Right.InOrder()
}

// public void preOrder(TreeNode root) {
// 	if(root == null) {
// 		return;
// 	}
// 	System.out.print(root.data + " ");
// 	preOrder(root.left);
// 	preOrder(root.right);
// }
func main() {
	tree := &Node{Key: 100}
	tree.Insert(40)
	tree.Insert(300)
	tree.Insert(10)
	tree.Insert(30)
	tree.Insert(50)
	// fmt.Println(tree.Search(10))
	// fmt.Println(tree.Search(100))
	// fmt.Println(tree.Search(1))
	tree.PostOrder()
	fmt.Println("---")
}
