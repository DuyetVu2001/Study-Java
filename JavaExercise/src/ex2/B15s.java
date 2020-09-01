package ex2;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 * @author Than
 */
public class B15s {
//    "Các bước thực hiện thuật toán để chuẩn hóa xâu kí tự: "
//    + "Bước 1: viết thường cả xâu bằng hàm toLowerCase()"
//    + "BƯớc 2: tách từng từ ra và lưu vào mảng String"
//    + "Bước 3: tiến hành viết hoa chữ cái đầu mỗi từ toUpperCase()"
//    + "BƯớc 4: nối các từ lại với nhau, xóa bỏ dấu cách cuối cùng => ta được xâu kết quả"

    public static void main(String[] args) {
        nhap();
    }

    static void chuanHoa(String s) {
        s = s.toLowerCase(); // viet thuong tat ca xau
        String[] ss;
        String s2 = "";
        ss = s.split(" ");
        for (int i = 0; i < ss.length; i++) {
            String s1 = "";
            if (ss[i].length() != 0) {
                s1 += Character.toUpperCase(ss[i].charAt(0));
                if (ss[i].length() > 1) s1 += ss[i].substring(1);
                s2 += s1;
                if (i < ss.length) s2 += " ";
            }
        }
        if (s2.charAt(s2.length() - 1) == ' ') s2 += "\b";
        System.out.print("\nstr sau khi chuan hoa: " + s2);
    }

    static void nhap() {
        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        System.out.print("str truoc khi chuan hoa: " + str);
        chuanHoa(str);
        System.out.println("");
    }
}
