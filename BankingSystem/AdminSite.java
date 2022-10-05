package bankingsystem;

import java.util.HashMap;

public class AdminSite extends CustomerSite{

    public void adminView()
    {
         adminSet();
        boolean bool=true;
        byte option=0;
        boolean iterate=true;
        while(iterate) {
            System.out.println("Enter the Admin Id");
            long adminId = scan.nextLong();
            if (!adminIdCheck(adminId)) {
                continue;
            }

            System.out.println("Enter the Admin Password");
            String adminPassword = scan.next();
            while(!adminPasswordCheck(adminId, adminPassword))
            {
                System.out.println("Enter the correct password here");
                adminPassword= scan.next();
            }
            iterate=false;
                while (bool) {
                    System.out.println("View Customer Info          Press 1");
                    System.out.println("Add admin                   Press 2");
                    System.out.println("Exit                        Press 3");
                    option = scan.nextByte();
                    if (option == 3) {
                        bool = false;
                        continue;
                    }
                    switch (option) {
                        case 1:
                            adminWrites();
                            break;
                        case 2:
                            addAdmin();
                            break;
                        default:
                            System.out.println("Enter the valid one");

                    }
                }
            }
        }

    public AdminSite(){
        super();

    }

}
