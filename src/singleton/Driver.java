package singleton;

public class Driver {
    public static void main(String[] args) {
        TVset tvset1ForMember1 = TVset.getTVSetInstance();
        TVset tvset2ForMember2 = TVset.getTVSetInstance();
        System.out.println("TVset instance for member 1: " + tvset1ForMember1);
        System.out.println("TVset instance for member 2: " + tvset2ForMember2);
    }
}