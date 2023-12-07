import java.util.*;
public class Main {
    public static void main(String args[])
    {  System.out.println("+------------------------------+");
        System.out.println("| WELCOME TO CAMERA RENTAL APP |");
        System.out.println("+------------------------------+");
        System.out.println("PLEASE LOGIN TO CONTINUE -");
        System.out.print("USERNAME - ");
        Scanner s=new Scanner(System.in);
        String username=s.next();
        System.out.print("PASSWORD - ");
        String password=s.next();
        if(username.equals("admin") && password.equals("admin123"))
        {   int option;
            int oneoption;
            ArrayList<Integer> id= new ArrayList<Integer>();
            ArrayList<String> brand= new ArrayList<String>();
            ArrayList<String> model= new ArrayList<String>();
            ArrayList<String> price= new ArrayList<String>();
            ArrayList<String> status= new ArrayList<String>();
            int wallet=10000;
            do{
                System.out.println("");
                System.out.println("1. MY CAMERA");
                System.out.println("2. RENT A CAMERA");
                System.out.println("3. VIEW ALL CAMERAS");
                System.out.println("4. MY WALLET");
                System.out.println("5. EXIT");
                System.out.print("Choose the Option : ");
                s.nextLine();
                option=s.nextInt();
                if(option==1)
                {
                    do
                    {  System.out.println(" ");
                        System.out.println("1. ADD");
                        System.out.println("2. REMOVE");
                        System.out.println("3. VIEW ALL CAMERAS");
                        System.out.println("4. GO TO PREVIOUS MENU");
                        System.out.print("Choose the Option : ");
                        s.nextLine();
                        oneoption=s.nextInt();
                        if(oneoption==1)//ADD
                        {
                            System.out.println(" ");
                            System.out.print("ENTER THE CAMERA BRAND : ");
                            String brand1 =s.next();
                            System.out.print("ENTER THE MODEL : ");
                            String model1 =s.next();
                            System.out.print("ENTER THE PER DAY PRICE (INR) : ");
                            String price1 =s.next();
                            id.add(id.size()+1);
                            brand.add(brand1);
                            model.add(model1);
                            price.add(price1);
                            status.add("Available");
                            System.out.println("********************************************************");
                            System.out.println("YOUR CAMERA HAS BEEN SUCCESSFULLY ADDED TO THE LIST.");
                            System.out.println("********************************************************");
                        }
                        else if(oneoption==2)//REMOVE
                        {
                            System.out.println("********************************************************");
                            System.out.printf("| %-2s | %-10s | %-10s | %-6s | %-7s |\n", "ID", "Name", "Model", "Rent", "Status");
                            System.out.println("********************************************************");
                            for (int i = 0; i < id.size(); i++) {
                                System.out.printf("| %-2d | %-10s | %-10s | %-6s | %-7s |\n", id.get(i), brand.get(i), model.get(i), price.get(i), status.get(i));
                            }
                            System.out.println("********************************************************");

                            System.out.println("");
                            System.out.print("ENTER THE CAMERA ID to REMOVE : ");
                            s.nextLine();
                            int removeid=s.nextInt();
                            removeid--;
                            id.remove(removeid);
                            brand.remove(removeid);
                            model.remove(removeid);
                            price.remove(removeid);
                            status.remove(removeid);
                            for (int i = 0; i < id.size(); i++) {
                                id.set(i, i + 1);
                            }
                            System.out.println("********************************************************");
                            System.out.println("CAMERA SUCCESSFULLY REMOVED FROM THE LIST");
                            System.out.println("********************************************************");
                        }
                        else if(oneoption==3)//VIEW ALL CAMERAS
                        {
                            System.out.println("********************************************************");
                            System.out.printf("| %-2s | %-10s | %-10s | %-6s | %-10s |\n", "ID", "Name", "Model", "Rent", "Status");
                            System.out.println("********************************************************");
                            for (int i = 0; i < id.size(); i++) {
                                System.out.printf("| %-2d | %-10s | %-10s | %-6s | %-10s |\n", id.get(i), brand.get(i), model.get(i), price.get(i), status.get(i));
                            }
                            System.out.println("********************************************************");

                        }
                    }
                    while(oneoption!=4);
                }
                if(option==2)//RENT a CAMERAS
                {
                    if (wallet < 8000) {
                        System.out.println("********************************************************");
                        System.out.println("Insufficient Balance to Rent a Camera (MIN-8000)");
                        System.out.println("********************************************************");
                    }
                    else
                    {
                        System.out.println("********************************************************");
                        System.out.printf("| %-2s | %-10s | %-10s | %-6s | %-7s |\n", "ID", "Name", "Model", "Rent", "Status");
                        System.out.println("********************************************************");
                        for (int i = 0; i < id.size(); i++) {
                            System.out.printf("| %-2d | %-10s | %-10s | %-6s | %-7s |\n", id.get(i), brand.get(i), model.get(i), price.get(i), status.get(i));
                        }
                        System.out.println("********************************************************");

                        System.out.print("");
                        System.out.print("ENTER THE CAMERA ID YOU WANT TO RENT : ");
                        s.nextLine();
                        int rentid=s.nextInt();
                        rentid--;
                        status.set(rentid,"Rented");
                        System.out.println("YOUR TRANSACTION FOR CAMERA :  "+brand.get(rentid)+" with rent INR "+
                                price.get(rentid)+" HAS SUCCESSFULLY COMPLETED");
                        int rentAmount = Integer.parseInt(price.get(rentid));
                        wallet -= rentAmount;
                    }


                }
                if(option==3)//VIEW ALL CAMERAS
                { System.out.println("********************************************************");
                    System.out.printf("| %-2s | %-10s | %-10s | %-6s | %-7s |\n", "ID", "Name", "Model", "Rent", "Status");
                    System.out.println("********************************************************");
                    for (int i = 0; i < id.size(); i++) {
                        System.out.printf("| %-2d | %-10s | %-10s | %-6s | %-7s |\n", id.get(i), brand.get(i), model.get(i), price.get(i), status.get(i));
                    }
                    System.out.println("********************************************************");

                }
                if(option==4)//MY WALLET
                { System.out.println("YOUR CURRENT WALLET BALANCE IS -INR "+wallet);
                    System.out.print("DO YOU WANT TO DEPOSIT MORE TO YOU WALLET? (1.YES 2.NO) : ");
                    int walletoption=s.nextInt();
                    if(walletoption==1)
                    {   System.out.print("ENTER THE AMOUNT (INR) : ");
                        int amoutt=s.nextInt();
                        wallet+=amoutt;
                        System.out.println("YOUR WALLET BALANCE UPDATED SUCCESSFULLY.");
                        System.out.println("CURRENT WALLET BALANCE -INR "+wallet);
                    }
                }
            }
            while(option!=5);
        }
        else{
            System.out.print("login details incorrect");
        }
    }
}