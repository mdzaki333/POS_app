import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import Manager.*;
import UI.mainMenuUI;
import UI.manageMemberUI;
import UI.manageOrderUI;
import UI.manageStaffUI;
import UI.manageTableUI;

import javax.net.ssl.ManagerFactoryParameters;

public class mainapp implements Serializable {
    public static void main(String[] args) throws Exception {
        mainMenu testMenu = new mainMenu();
        try {
            testMenu = testMenu.readMenu();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        manageStaff testStaff = new manageStaff();
        try {
            testStaff = testStaff.readStaff();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        manageOrder testOrder = new manageOrder();
        try {
            testOrder = testOrder.readOrders();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        manageMember testMember = new manageMember();
        try {
            testMember = testMember.readMemberList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        manageReservation manageReserv = new manageReservation();
        try {
            manageReserv = manageReserv.readReservation();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        manageTable testTable = new manageTable();
        try {
            testTable = testTable.readTables();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        Scanner scan = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nPlease select your operations.");
            System.out.println("(1) Manage Staff");
            System.out.println("(2) Manage Menu");
            System.out.println("(3) Manage Orders");
            System.out.println("(4) Manage Customer Memberships");
            System.out.println("(5) Manage Reservations");
            System.out.println("(6) Manage Tables");
            System.out.println("(7) Exit");
            System.out.printf("Select a choice: ");
            choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    manageStaffUI.start(testStaff);
                    testStaff.saveStaffList();
                    break;
                case 2:
                    mainMenuUI.start(testMenu);
                    testMenu.saveMenu();
                    break;
                case 3:
                    manageOrderUI.start(testOrder);
                    testOrder.saveOrders();
                    break;
                case 4:
                    manageMemberUI.start(testMember);
                    break;
                case 5:
                    manageReserv.start(testTable, testMember);
                    break;
                case 6:
                    manageTableUI.start(testTable);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Please enter a valid choice");
            }

        } while (choice != 7);

        System.out.println("Program Terminating...");
    }
}
