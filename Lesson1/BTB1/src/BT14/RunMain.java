package BT14;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class RunMain {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao chuoi bat ki: ");
        String str = sc.nextLine();
        
        String[] arrStr = str.split("");
        
        

        Map<String, Integer> map = new HashMap<>();
        for (String s : arrStr) {
            if (map.containsKey(s)) {
                map.replace(s, map.get(s) + 1);
            } else {
            	map.put(s, 1);
            }
        }
        
        int maxAmount = 0;
        
        for (Map.Entry<String, Integer> entry : map.entrySet())
            if(entry.getValue() > maxAmount)
                maxAmount = entry.getValue();

        System.out.print("Cac ki tu xuat hien nhieu nhat trong chuoi la: ");
        for(Map.Entry<String, Integer> entry : map.entrySet())
            if(entry.getValue() == maxAmount)
            {
                if(entry.getKey().equals(" "))
                    System.out.print("Space");
                else
                    System.out.print(entry.getKey());
                System.out.print(", ");
            }
    }
	
}
