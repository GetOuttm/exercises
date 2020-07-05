import java.util.*;

/**
 * @ProjectName: BigDemo
 * @Author: LiJinFeng
 * @Description:
 * @Date: 2019/12/14 16:17
 */
/*
预先设置5名学员姓名，存放在ArrayList<HashMap<String,String>>类型的集合中。HashMap中用于存放学员姓名的key是
“name”，用来存放学员成绩的key是“score”。根据学员姓名，查找是否含有此学员，
如果不包含此学员，则提示“查找不到此学员”。如果有则输入成绩，存储。之后提示“是否继续插入成绩（Y/N）”，
如果输入的是Y，则继续输入学员姓名，查找学员。如果输入N，则打印出，这五个学员的姓名和成绩。（若此学员无成绩，按0分计算）。
 */
public class ArrayHash {

    public static void main(String[] args) {
        String[] name = new String[]{"张三", "李四", "王五", "赵六", "霍七"};
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < name.length; i++) {
            HashMap<String, String> map = new HashMap<>();
            map.put("name", name[i]);
            arrayList.add(map);
        }
        System.out.println(arrayList);
        method(arrayList);
    }

    public static void method(ArrayList<HashMap<String, String>> arrayList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入姓名");
        String xm = scanner.nextLine();

        for (HashMap<String, String> hashMap : arrayList) {
            for(Map.Entry<String, String> e: hashMap.entrySet()) {
                if (e.getValue().equals(xm)) {
                    System.out.println("请写入年龄");
                    String in = scanner.nextLine();
                    System.out.println("是否继续插入成绩（Y/N）");
                    String s1 = scanner.nextLine();
                    if ("Y".equals(s1)) {
                       method(arrayList);
                       return;
                    } else if ("N".equals(s1)) {
                        hashMap.put("score",in);
                        System.out.println(arrayList);
                        break;
                    }
                }
            }
        }
        System.out.println("查找不到此学员");
    }
}