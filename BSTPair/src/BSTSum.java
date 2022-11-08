import java.util.ArrayList;
import java.util.Scanner;
public class BSTSum {
	
	static ArrayList<Integer>  nodelist = new ArrayList<>();
	public static Node newNode( int z) {
		Node temp = new Node();
			
		temp.data = z;
		
	
	    return temp;
	}
	
	

	public void insert(Node root, Node temp) {
		
		if(temp.data < root.data )
		{
			if(root.leftNode == null)
			{
				root.leftNode = temp;
			}
			else
			{
				insert(root.leftNode, temp);
			}
		}
		else
		{
			if(root.rightNode == null)
			{
				root.rightNode = temp;
			}
			else
			{
				insert(root.rightNode, temp);
			}
		
		}
	}
	
	public static void traverseBST(Node root)
	{
		//Inorder  LDR
		
		if(root != null)
		{
		   traverseBST(root.leftNode);
		   nodelist.add(root.data);
		   traverseBST(root.rightNode);
		}
		
	}
	public static void main(String[] args) {
		
		BSTSum bst = new BSTSum();
	
		Node root = null;
		Node temp = null;
		int nodeData;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of nodes :");
		
		int k = sc.nextInt();

		for(int i = 1 ; i <= k ; i++)
		{
			System.out.println("Enter data for nodes :");
		    nodeData = sc.nextInt();
		    
		    temp = newNode(nodeData);
		    if(root == null)
		    {
		    	root = temp;
		    }
		    else
		    {
		    	bst.insert(root,temp);
		    }
		}
		
		bst.traverseBST(root);
		
		System.out.println("Enter sum : ");
		int sum = sc.nextInt();
	    int flag = 0;
		for(int i = 1; i < bst.nodelist.size() ; i++)
		{
			if(bst.nodelist.contains(sum - bst.nodelist.get(i)))
			{
				int a = bst.nodelist.get(i);
				int b = sum - (bst.nodelist.get(i));
			    flag = 1;
			    System.out.println("Pair is " + a + " " + b );
			    break;
			}
		    
		}
		if(flag == 0 )
		{
			 System.out.println("Pair not found");
		}
		
		
	sc.close();
	}



}
