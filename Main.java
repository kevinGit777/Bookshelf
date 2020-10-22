package project2;

import java.io.*;
import java.util.Scanner;

public final class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("data1.txt");
		
		AVLTree tree = new AVLTree();
		Scanner inFile =new Scanner(file);
		
		while (inFile.hasNextLine()) {

		String data = inFile.nextLine();
		AVLNode node = parseLine(data);
	   tree.root =	tree.Insert(node, tree.root);
	}
		tree.display(tree.root);
		
	inFile.close();

}
	
static AVLNode parseLine(String data)
{
	String ISBN, author, name;
	ISBN = data.substring(0, data.indexOf("A:"));
	author = data.substring(data.indexOf("A:")+2, data.indexOf("N:"));
	name= data.substring(data.indexOf("N:")+2);
	
	Book book =new Book(name, author);
	return new AVLNode(ISBN, book); 
}
	
}
