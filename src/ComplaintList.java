import java.util.Iterator;
import java.util.LinkedList;

public class ComplaintList {
    private LinkedList<Complaint> complaints;

    public ComplaintList() {
        complaints = new LinkedList<>();
    }
    //For adding a Complaint to the list of complaints
    public void addComplaint(int serviceNumber, String address, String contactNumber) {
        try {
            // Validate contact number
            if (!isValidContactNumber(contactNumber)) {
                throw new IllegalArgumentException("Invalid contact number. Contact number must be 10 digits and numerical.");
            }

            Complaint complaint = new Complaint(serviceNumber, address, contactNumber);
            complaints.add(complaint);
            System.out.println("Complaint added with ID: " + complaint.getComplaintId());
        } catch (Exception e) {
            System.out.println("Error adding complaint: " + e.getMessage());
        }
    }

    private boolean isValidContactNumber(String contactNumber) {
        return contactNumber.matches("\\d{10}");
    }

    public Complaint searchComplaint(int complaintId) {
        for (Complaint complaint : complaints) {
            if (complaint.getComplaintId() == complaintId) {
                return complaint;
            }
        }
        return null;
    }
    //For resolving a complaint based on complaint Id
    public void resolveComplaint(int complaintId) {
        Complaint complaint = searchComplaint(complaintId);
        if (complaint != null) {
            complaint.resolveComplaint();
            System.out.println("Complaint with ID " + complaintId + " resolved.");
        } else {
            System.out.println("Complaint not found with ID " + complaintId + ". Unable to resolve.");
        }
    }

    public void displayAllComplaints() {
        for (Complaint complaint : complaints) {
            System.out.println(complaint);
        }
    }
    //For checking and removing all resolved complaints
    public void removeResolvedComplaints() {
        Iterator<Complaint> iterator = complaints.iterator();
        while (iterator.hasNext()) {
            Complaint complaint = iterator.next();
            if (complaint.isResolved()) {
                System.out.println("Removing resolved complaint: " + complaint.getComplaintId());
                iterator.remove();
            }
        }
    }
    //this. method gets called automatically if the number of complaints
    //exceeds 5 or can be manually called in by admin

    public void sendAlertToSuperintendent() {
        if (complaints.size() > 5) {
            System.out.println("Alert: More than 5 complaints. Notifying the superintendent.");
        }
        else{
            System.out.println("Alerting the superintendent to take a look at the pending complaints");
        }
    }
}