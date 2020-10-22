package project2;

import java.util.Random;


public class AVLTree {

	AVLNode root;

	public AVLTree() {
		root = null;
	}

	public AVLTree(AVLNode root) {
		this.root = root;
	}

	public void setRoot(AVLNode root) {
		this.root = root;
	}

	public void display(AVLNode root) {
		// check if the node is empty
		if (root != null) {
			display(root.leftPtr);
			System.out.println(root);
			display(root.rightPtr);
		}
	}

	public AVLNode Insert(AVLNode node, AVLNode current) {
		if (current == null) {
			return node;
		} else {
			if (node.key.compareTo(current.key) < 0) // node smaller that current
			{
				current.setLeft(Insert(node, current.getLeft()));

			} else if (node.key.compareTo(current.key) > 0) // node bigger that current
			{
				current.setRight(Insert(node, current.getRight()));
			}
			else 
			return current;

			current.updatedHeight();

			if (!current.isBlanced()) {
				System.out.print("Imbalance occurred at inserting ISBN " + node.key + ";");

				if (node.key.compareTo(current.key) < 0) // first flag: L
				{
					if (node.key.compareTo(current.getLeft().key) < 0) {
						System.out.println("fixed in Left Rotation.");
						return LLrotation(current);

					} // LL
					else {
						System.out.println("fixed in LeftRight Rotation.");
						
						return LRrotation(current);// LR
					}
				} else {
					if (node.key.compareTo(current.getRight().key) > 0) {
						System.out.println("fixed in Right Rotation.");

						return RRrotition(current);
					} else {
						System.out.println("fixed in RightLeft Rotation.");

						return RLrotation(current);
					}
				}
			}
			return current;
		}
	}

	public AVLNode LLrotation(AVLNode current) {
		AVLNode parent = current.getLeft();
		AVLNode node =parent.getRight();
		
		parent.setRight(current);
		current.setLeft(node);
		current.updatedHeight();
		parent.updatedHeight();
		return parent;
	}

	public AVLNode LRrotation(AVLNode current) {
		current.setLeft(RRrotition(current.getLeft()));
		return LLrotation(current);
	}

	public AVLNode RRrotition(AVLNode current) {
		AVLNode parent = current.getRight();
		AVLNode node =parent.getLeft();
		
		parent.setLeft(current);
		current.setRight(node);
		current.updatedHeight();
		parent.updatedHeight();
		return parent;
	}

	public AVLNode RLrotation(AVLNode current) {
		current.setRight(LLrotation(current.getRight()));
		return RRrotition(current);

	}

	public AVLNode randomInsert(AVLNode node, AVLNode root) {
		// TODO Auto-generated method stub
		if(root ==null)
			return node;
		Random rand = new Random();
		int num = rand.nextInt(2);
		
		if(num ==1) {
			root.setRight(randomInsert(node, root.getRight()));
			root.updatedHeight();
		}
		else {
			 root.setLeft(randomInsert(node, root.getRight()));
				root.updatedHeight();

		}
		
		
		return null;
	}
}
