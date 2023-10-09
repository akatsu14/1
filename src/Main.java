import data.Admin;
import view.AdminView;

public class Main {

    public static void main(String[] args) {
        Admin adminUser = new Admin("   ", "admin_password");
        // Truy xuất và in thông tin người dùng
        AdminView av = new AdminView();
        av.selection();
        // In thông tin sau khi thay đổi vai trò
        System.out.println("Updated Role: " + adminUser.getRole());
    }
}
