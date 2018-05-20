/**
 * Created by nitinkumarsharma on 11/13/16.
 */

public class test {
    public static void main(String[] args) {

    }

    public static class a {
    }

    public static class b extends a {
        b() {

        }

        String get() {
            return "b";
        }
    }

    public static class c extends a {
        c() {

        }

        String get() {
            return "c";
        }
    }

    public static java.util.ArrayList<a> list = new java.util.ArrayList<a>(2);

    static {
        b first_object = new b();
        c second_object = new c();
        list.add(first_object);
        list.add(second_object);
        b first_returned_object = ((b) get_element(true));
        System.out.println(first_returned_object.get());
        c second_returned_object = ((c) get_element(false));
        second_returned_object.getClass();
        System.out.println(second_returned_object.get());
    }

    public static Object get_element(boolean first) {
        if (first) {
            return list.get(0);
        } else {
            return list.get(1);
        }
    }
}