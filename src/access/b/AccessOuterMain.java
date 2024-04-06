package access.b;

import access.a.AccessData;

public class AccessOuterMain {
    public AccessOuterMain() {
    }

    public static void main(String[] args) {
        AccessData accessData = new AccessData();
        accessData.publicField = 1;
        accessData.publicMethod();
        accessData.innerAccess();
    }
}
