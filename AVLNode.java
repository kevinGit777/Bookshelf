package project2;

public class AVLNode {
	String key; 
	Book value; //create a class representing a book with minimum attributes
	int height;
	AVLNode leftPtr;
	AVLNode rightPtr;

	public AVLNode()
	{
		key ="";
		value =null;
		height =0;
		leftPtr =null;
		rightPtr =null;
	}
	public AVLNode(String key, Book value)
	{
		this.key =key;
		this.value=value;
		height =0;
		leftPtr =null;
		rightPtr =null;
	}
	
	public void addheight()
	{
		height++;
	}
	

	public int getHeight()
	{
		return height;
	}
	
	public void setHeigth(int height)
	{
		this.height =height;
	}
	
	public AVLNode getLeft()
	{
		return leftPtr;
	}
	
	public void setLeft(AVLNode node)
	{
		leftPtr =node;
	}
	public AVLNode getRight()
	{
		return rightPtr;
	}
	
	public void setRight(AVLNode node)
	{
		rightPtr =node;
	}
	
	
	public void updatedHeight()
	{
		if(this.leftPtr == null && this.rightPtr == null) //case for leaf
		this.setHeigth(0);
		else if (this.leftPtr ==null) //if only rightPtr
			this.setHeigth(this.rightPtr.getHeight()+1);
		else if (this.rightPtr == null) //if only leftPtr
			this.setHeigth(this.leftPtr.getHeight()+1);
		else {
			//has both Ptr, heigth is max of Ptr +1
			this.setHeigth(Math.max(this.getLeft().getHeight(), this.getRight().getHeight())+1);
		}
	}
	
	public boolean isBlanced()
	{
		int balance, leftHeight, rightHeight;
		if (this.getLeft() == null)
			leftHeight = -1;
		else {
			leftHeight = this.getLeft().getHeight();
		}
		if (this.getRight() == null)
			rightHeight = -1;
		else {
			rightHeight = this.getRight().getHeight();
		}
		balance = rightHeight -leftHeight;
		return !(balance>1 || balance<-1);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return key+" Author: "+value.author+" Title: "+value.title;
	}
	
}
