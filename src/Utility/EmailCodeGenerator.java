package Utility;

public class EmailCodeGenerator {
    public String createEmailCode()
    {
        return Double.toString(Math.random() * 10000000).substring(0, 4);
    }

    public String createPassword() {
        return "Bil" + Double.toString(Math.random() * 10000000).substring(0, 5);
    }
}
