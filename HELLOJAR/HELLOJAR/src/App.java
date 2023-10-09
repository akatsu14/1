import java.util.*;

import view.InvoiceView;
import vn.edu.ptit.*;

// class PaymentController {

//     public static Scanner sc = new Scanner(System.in);

//     private final Invoice invoice;
//     private final Student student;
//     private final ArrayList<Subject> subjecs;
//     private final Rule rule;

//     public PaymentController() {
//         this.student = getStudent();
//         this.subjecs = getSubjects();
//         this.rule = getRule();
//         this.invoice = setInvoice();
//     }

//     public Invoice getInvoice() {
//         return this.invoice;
//     }

//     private Student getStudent() {
//         String studentCode = sc.nextLine();
//         String studentName = sc.nextLine();
//         return new Student(studentCode, studentName);
//     }

//     private ArrayList<Subject> getSubjects() {
//         ArrayList<Subject> subjecsList = new ArrayList<>();
//         int numOfSubjects = Integer.parseInt(sc.nextLine());
//         for (int i = 0; i < numOfSubjects; ++i) {
//             subjecsList.add(getSubject());
//         }

//         return subjecsList;
//     }

//     private Subject getSubject() {
//         String nameSubject = sc.nextLine();
//         String codeSubject = sc.nextLine();
//         int creditSubject = Integer.parseInt(sc.nextLine());
//         return new Subject(codeSubject, nameSubject, creditSubject);
//     }

//     private Rule getRule() {
//         String codeRule = sc.nextLine();
//         String nameRule = sc.nextLine();
//         double creditPrice = Double.parseDouble(sc.nextLine()) * getCredits();
//         return new Rule(codeRule, nameRule, creditPrice);
//     }

//     private int getCredits() {
//         int count = 0;
//         for (Subject subject : this.subjecs) {
//             count += subject.getCredit();
//         }
//         return count;
//     }

//     private Invoice setInvoice() {
//         Invoice invoice = new Invoice(this.rule);
//         invoice.setAlSubject(this.subjecs);
//         invoice.setAmount(this.rule.getCreditPrice());
//         invoice.setSt(this.student);
//         return invoice;
//     }

// }
class PaymentController {
    private final Student st;
    private final ArrayList<Subject> subs;
    private final Rule rule;
    private final Invoice inv;
    public static Scanner sc = new Scanner(System.in);

    PaymentController() {
        this.st = getStudent();
        this.subs = getSubjects();
        this.rule = getRule();
        this.inv = setInvoice();
    }

    public Invoice getInvoice() {
        return this.inv;
    }

    private Student getStudent() {
        String code = sc.nextLine();
        String name = sc.nextLine();
        return new Student(code, name);
    }

    private ArrayList<Subject> getSubjects() {
        ArrayList<Subject> subjecsList = new ArrayList<>();
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            subjecsList.add(getSubject());
        }
        return subjecsList;
    }

    private Subject getSubject() {
        String code = sc.nextLine();
        String ten = sc.nextLine();
        int soTinChi = Integer.parseInt(sc.nextLine());
        return new Subject(ten, code, soTinChi);
    }

    private Rule getRule() {
        String code = sc.nextLine();
        String name = sc.nextLine();
        Double price = Double.parseDouble(sc.nextLine()) * getCredits();
        return new Rule(code, name, price);
    }

    private int getCredits() {
        int cnt = 0;
        for (Subject sub : subs) {
            cnt += sub.getCredit();
        }
        return cnt;
    }

    private Invoice setInvoice() {
        Invoice invoice = new Invoice(rule);
        invoice.setAlSubject(subs);
        invoice.setSt(st);
        invoice.setAmount(rule.getCreditPrice());
        return invoice;
    }
}

public class App {
    public static void main(String[] args) {
        PaymentController pc = new PaymentController();
        // Output for test
        Invoice invoice = pc.getInvoice();
        InvoiceView.show(invoice);
    }
}
