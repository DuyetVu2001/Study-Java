package view;

import other.MyDic;

public class Main {
    public static void main(String[] args) {
        MyDic<String, Integer> dic;
        dic = new MyDic<>("one", 1);
        MyDic<String, Float> otherDic = new MyDic("A Half", 0.5f);

        dic.show();
        otherDic.show();
    }
}
