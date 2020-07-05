import java.util.ArrayList;
import java.util.List;

public class a {

    public static void main(String[] args) {
        List masterList = new ArrayList<>();
        masterList.add("1");
        masterList.add("2");
        masterList.add("3");
        masterList.add("4");
        masterList.add("5");

        System.out.println(masterList);

        List branchList = masterList.subList(0,3);
        System.out.println(branchList);

        /*masterList.remove(0);
        masterList.add("10");
        masterList.clear();*/

        branchList.clear();
        branchList.add("6");
        branchList.add("7");
        branchList.remove(0);

        for (Object o : branchList) {
            System.out.println(o);
        }

        System.out.println(masterList);
    }
}
