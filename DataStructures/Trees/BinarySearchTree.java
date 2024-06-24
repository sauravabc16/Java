
class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
}

public class BinarySearchTree {
     private BinaryTreeNode<Integer> root; 
    
     public Boolean search(int data){
         return searchhelper(data,root);
     } 
     private Boolean searchhelper(int data,BinaryTreeNode<Integer> root){
         if(root==null){
             return false;
         }
         if(root.data==data){
             return true;
         }
         if(root.data>data){
             return searchhelper(data,root.left);
         }else
          {
            return searchhelper(data,root.right);
   }
     }  
    
	 public void insertData(int data){
        root= insertDatahelper(data,root);
     }
     private BinaryTreeNode<Integer> insertDatahelper(int data,BinaryTreeNode<Integer> root){
            if(root==null){
                BinaryTreeNode<Integer> ans=new BinaryTreeNode<Integer>(data);
                return ans;
            }
            if(root.data>data){
                root.left=insertDatahelper(data,root.left);
            }
           else {
               root.right= insertDatahelper(data,root.right);
           }
         return root;
     }
     
    
      public void deleteData(int data){
         root=deleteData(data,root);
     }
      private BinaryTreeNode<Integer> deleteData(int data, BinaryTreeNode<Integer> root) {
  		if (root == null) {
  			return null;
  		}
  		if (data < root.data) {
  			root.left = deleteData(data, root.left);
  			return root;
  		} else if (data > root.data) {
  			root.right = deleteData(data, root.right);
  			return root;
  		} else {
  			if (root.left == null && root.right == null) {
  				return null;
  			} else if (root.left == null) {
  				return root.right;
  			} else if (root.right == null) {
  				return root.left;
  			} else {
  				BinaryTreeNode<Integer> minNode = root.right;
  				while (minNode.left != null) {
  					minNode = minNode.left;
  				}
  				root.data = minNode.data;
  				root.right = deleteData(minNode.data, root.right);
  				return root;
  			}
  		}
  		
  	}
      
     public static int max(BinaryTreeNode<Integer> root){  
      /* loop down to find the rightmost leaf */
        BinaryTreeNode<Integer> current = root; 
          while (current.right != null)  
           current = current.right; 
            return (current.data); 
      }  
     
   
    public void printTree(){
        printtree(root);
    }
    private void printtree(BinaryTreeNode<Integer> root){
        if(root==null){
            return;
        }
        String str = root.data + ":";
        if (root.left!=null){
            str += "L:"+ root.left.data + ",";
        }
        if (root.right!=null){
            str += "R:"+ root.right.data ;
        }
        System.out.println(str);
        printtree(root.left);
        printtree(root.right);
    }
}

class QueueEmptyException extends Exception {
}

class QueueUsingLL<T> {

	class Node<T> {
		T data;
		Node<T> next;
		Node(T data){
			this.data = data;
		}
	}

	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		if(size == 0){
			return true;
		}
		return false;
	}

	public T front() throws QueueEmptyException{
		if(size == 0){
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}

		return head.data;
	}


	public void enqueue(T element){
		Node<T> newNode = new Node<T>(element);

		if(head == null){
			head = newNode;
			tail = newNode;
		}
		else{
			tail.next = newNode;
			tail = newNode;
		}

		size++;
	}

	public T dequeue() throws QueueEmptyException{
		if(head == null){
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}
		if(head == tail){
			tail = null;
		}
		T temp = head.data;
		head = head.next;
		size--;
		return temp;
	}
}

/**************
 * Main function that we can use to test 
 * 
public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		int choice, input;
		while(true) {
			choice = s.nextInt();
			switch(choice) {
				case 1 : 
					input = s.nextInt();
					bst.insertData(input);
					break;
				case 2 : 
					input = s.nextInt();
					bst.deleteData(input);
					break;
				case 3 : 
					input = s.nextInt();
					System.out.println(bst.search(input));
					break;
				default :
					bst.printTree();
					return;
			}

		}
*******************/
