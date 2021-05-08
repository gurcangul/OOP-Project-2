import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Facilities.AccountOfCompany;
import Facilities.DistributionCenter;
import Facilities.Factory;
import Facilities.StorageTank;
import Facilities.Warehouse;
import Ingredients.Cacao;
import Ingredients.Cream;
import Ingredients.Milk;
import Ingredients.RawMaterial;
import Ingredients.Yeast;
import Products.BoxedMilk;
import Products.Chocolate;
import Products.Product;
import Products.Yogurt;

public class BusinessApplicationApp {
	public static void main(String[] args) {
		
		AccountOfCompany moneyAccount = new AccountOfCompany();
		RawMaterial cacao = new Cacao();
		RawMaterial cream = new Cream();
		RawMaterial milk = new Milk();
		RawMaterial yeast = new Yeast();
		Product boxedMilk = new BoxedMilk();
		Product chocolate = new Chocolate();
		Product yogurt = new Yogurt();
		
		Warehouse warehouse = new Warehouse();
		Factory factory = new Factory();
		DistributionCenter distributionCenter = new DistributionCenter();
		
		System.out.println("Welcome To Business Application Program!");
		System.out.println("Here you can buy ingredients to produce product\n"
				+"Then you can sell the product\n"
				+"Also you can ship items between facilities");
		
		System.out.println("------------------------------------------");
		String message = 	"1) To buy ingredients\n"+
				"2) To ship ingredients to Factory\n"+
				"3) To produce product with ingredients\n"+
				"4) To ship products to Distribution Center\n"+
				"5) To sell products\n"+
				"0) To exit";
				ArrayList<Integer> mList=new ArrayList<Integer>();
				ArrayList<Integer> caList=new ArrayList<Integer>();
				ArrayList<Integer> crList=new ArrayList<Integer>();
				ArrayList<Integer> yList=new ArrayList<Integer>();
				StorageTank yeastTank = null;
				StorageTank cacaoTank= null;
				StorageTank milkTank= null;
				StorageTank creamTank= null;

System.out.println("-----------------------------------------");
		Scanner scanner = new Scanner(System.in);
		boolean done = false;
		while(!done) {
			System.out.println(message);		
			System.out.println("-----------------------------------------");
			String kind;
			int amount=0;
			String move = scanner.nextLine();
			
			switch (move) {
				case "0":
					done = true;
					break;
			
				case "1":
					System.out.println("Please enter a ingredient name for buy (milk, cacao, cream, yeast)");
					kind = scanner.nextLine();	kind = kind.toLowerCase();
					System.out.println("Also enter  how much ingredients you want to buy.");
					amount = 0;
					try{
						amount = scanner.nextInt();
					}catch (InputMismatchException e) {
						System.out.println("Entered invalid amount of ingredients");
					}
					if(kind.equals("milk")) {
						warehouse.buyIngredients(milk,amount,moneyAccount);
						mList.add(amount);
						 milkTank=new StorageTank(amount);
					}
					else if(kind.equals("cacao")) {
						warehouse.buyIngredients(cacao,amount,moneyAccount);	
						caList.add(amount);
						 cacaoTank=new StorageTank(amount);
					}
					else if(kind.equals("cream")) {
						warehouse.buyIngredients(cream,amount,moneyAccount);
						crList.add(amount);
						 creamTank=new StorageTank(amount);
					}
					else if(kind.equals("yeast")) {
						warehouse.buyIngredients(yeast,amount,moneyAccount);			
						yList.add(amount);
						 yeastTank=new StorageTank(amount);
					}
					System.out.println(warehouse);
					System.out.println(moneyAccount);
					break;
				case "2":
					System.out.println("Please enter the number of the container for ship ingredients that you bought to Factory! \n ");
					String containerMessage = "1- Dry Storage Container(boxed milk, chocolate, yogurt)\n" +  "2- Open Top Container(yeast, cacao)\n"+  "3- Tank Container(milk, cream)";
					System.out.println(containerMessage+"\n");
					int c = scanner.nextInt();
					if(c==1) {
						
					}
					else if(c==2) {
						
						//yeast & cacao
						
						
						warehouse.setStorageYeast(yeastTank);
					}	
					else if(c==3) {
						
						//yeast & cacao
						warehouse.setStorageYeast(yeastTank);
					}	
					else if(c==4) {
						
						//yeast & cacao
						warehouse.setStorageYeast(yeastTank);
					}	
					else if(c==5) {
						
						//yeast & cacao
						warehouse.setStorageYeast(yeastTank);
					}
				
					/* Dry Storage Container -> boxed milk, chocolate, and yogurt
					  Open Top Container -> yeast, cacao
					  Tank Container -> milk, cream
					 */
					break;
				case "3":
					System.out.println("Please enter a product name for sell (boxedmilk, chocolate, yogurt)");
					kind = scanner.nextLine(); kind = kind.toLowerCase();
					System.out.println("Also enter  how much ingredients you want to buy.");
					amount = 0;
					try{
						amount = scanner.nextInt();
					}catch (InputMismatchException e) {
						System.out.println("Entered invalid amount of ingredients");
					}
					if(kind.equals("boxedmilk")) {
						factory.produceProduct(boxedMilk, amount);
					}
					else if(kind.equals("chocolate")) {
						factory.produceProduct(chocolate, amount);
					}
					else if(kind.equals("yogurt")) {
						factory.produceProduct(yogurt, amount);
					}
					break;
				case "4":
					
					break;
				case "5":
					System.out.println("Please enter a product name for sell (boxedmilk, chocolate, yogurt)");
					kind = scanner.nextLine();
					kind = kind.toLowerCase();
					System.out.println("Also enter  how much ingredients you want to buy.");
					amount = 0;
					try{
						amount = scanner.nextInt();
					}catch (InputMismatchException e) {
						System.out.println("Entered invalid amount of ingredients");
					}
					if(kind.equals("boxedmilk")) {
						distributionCenter.sellProduct(boxedMilk , amount, moneyAccount);
					}
					else if(kind.equals("chocolate")) {
						distributionCenter.sellProduct(chocolate , amount, moneyAccount);
					}
					else if(kind.equals("yogurt")) {
						distributionCenter.sellProduct(yogurt , amount, moneyAccount);
					}
					break;
				
			}
		}
		/*String kind = "cacao";
		int amount = 10;
		if(kind.equals("cacao"))
			warehouse.buyIngredients(cacao,amount,moneyAccount);
			warehouse.storeItem(cacao,storageCacao);
		

		
		System.out.println(storageCacao);
		System.out.println(moneyAccount);
		 */	
	}
	

}
