import java.util.Random;
public class Driver {
public static void main(String[] args) {
		
		
		Random random = new Random();
		
		AVLTree tree = new AVLTree();
		
	
		for (int i = 0; i < 10; i++) {
			
			for (int j = 0; j < 10; j++) {
				tree.insert(random.nextInt(200));
			}
			
			
			tree.inorder();
			
			System.out.println();
			System.out.println();
			
		}
		
	}
}
