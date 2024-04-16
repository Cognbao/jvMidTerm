public class Fresher extends Employee {
    String graduationDate;
    String graduationRank;
    String education;

    public Fresher(int ID, String fullName, String birthDay, String phone, String email, String graduationDate, String graduationRank, String education) {
        super(ID, fullName, birthDay, phone, email, "Fresher");
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Graduation Date: " + graduationDate);
        System.out.println("Graduation Rank: " + graduationRank);
        System.out.println("Education: " + education);
    }
}