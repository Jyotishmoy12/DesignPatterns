package singleton;

public class TVset {
    private static TVset tvSetInstance = null;

    private TVset() {
        System.out.println("TVset created");
    }

    // static methods does not need any instance of the class to call
    public static TVset getTVSetInstance() {
        if (tvSetInstance == null) {
            tvSetInstance = new TVset();
        }
        return tvSetInstance;
    }
}
