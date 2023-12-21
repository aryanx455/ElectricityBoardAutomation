import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ComplaintList complaintList = new ComplaintList();
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        do {
            try {
                System.out.println("\n1. Add Complaint\n2. Search Complaint\n3. Display All Complaints");
                System.out.println("4. Resolve a complaint by complaint Id\n5. Remove Resolved Complaints\n6. Send Alert to Superintendent\n7. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Service Number: ");
                        int serviceNumber = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Address: ");
                        String address = scanner.nextLine();
                        System.out.print("Enter Contact Number: ");
                        String contactNumber = scanner.nextLine();

                        complaintList.addComplaint(serviceNumber, address, contactNumber);
                        break;

                    case 2:
                        System.out.print("Enter Complaint ID to search: ");
                        int searchComplaintId = scanner.nextInt();
                        Complaint foundComplaint = complaintList.searchComplaint(searchComplaintId);
                        if (foundComplaint != null) {
                            System.out.println("Complaint Found: " + foundComplaint);
                        } else {
                            System.out.println("Complaint not found.");
                        }
                        break;

                    case 3:
                        complaintList.displayAllComplaints();
                        break;
                    case 4:
                        System.out.print("Enter Complaint ID to resolve: ");
                        int resolveComplaintId = scanner.nextInt();
                        complaintList.resolveComplaint(resolveComplaintId);
                        break;
                    case 5:
                        complaintList.removeResolvedComplaints();
                        break;

                    case 6:
                        complaintList.sendAlertToSuperintendent();
                        break;

                    case 7:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }

        } while (choice != 7);

        scanner.close();
    }
}