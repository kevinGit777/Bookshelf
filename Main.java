package project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("data1.txt");
		AVLTree tree = new AVLTree();
		Scanner inFile = new Scanner(file);

		while (inFile.hasNextLine()) {
			String data = inFile.nextLine();
			AVLNode node = parseLine(data);
			tree.setRoot(tree.Insert(node, tree.getRoot()));
		}
		tree.display(tree.getRoot());
		inFile.close();
	}

	static AVLNode parseLine(String data) {
		String ISBN, author, name;
		ISBN = data.substring(0, data.indexOf("A:"));
		author = data.substring(data.indexOf("A:") + 2, data.indexOf("N:"));
		name = data.substring(data.indexOf("N:") + 2);
		Book book = new Book(name, author);
		return new AVLNode(ISBN, book);
	}

}
