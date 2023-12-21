public class Complaint {
    //for unique assignment of complaintId
    private static int nextId = 1;

    private int complaintId;
    private int serviceNumber;
    private String address;
    private String contactNumber;
    private boolean resolved;

    public Complaint(int serviceNumber, String address, String contactNumber) {
        this.complaintId = nextId++;
        this.serviceNumber = serviceNumber;
        this.address = address;
        this.contactNumber = contactNumber;
        this.resolved = false;
    }

    public int getComplaintId() {
        return complaintId;
    }

    public int getServiceNumber() {
        return serviceNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void resolveComplaint() {
        this.resolved = true;
    }

    @Override
    public String toString() {
        return "Complaint [ID=" + complaintId + ", Service Number=" + serviceNumber +
                ", Address=" + address + ", Contact Number=" + contactNumber +
                ", Resolved=" + resolved + "]";
    }
}
