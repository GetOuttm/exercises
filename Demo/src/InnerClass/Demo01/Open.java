package InnerClass.Demo01;

import java.util.ArrayList;

public class Open implements OpenMode {
    @Override
    public ArrayList<Integer> divide(final int totalMoney,final int totalCount) {
        ArrayList<Integer> list = new ArrayList<>();
        int avg = totalMoney / totalCount;//平均
        int mod = totalMoney % totalCount;//余数

        //totalCount - 1代表最后一个先留着
        for (int i = 0; i < totalCount - 1; i++) {
            list.add(avg);
        }
        //有余数就放到最后一个红包中
        list.add(avg + mod);
        return list;
    }
}
