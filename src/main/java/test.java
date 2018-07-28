import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

/**
 * Created by zhenglibin on 2018/4/13.
 */
public class test {
    public static void main(String args[]){
        System.out.println(Character.MIN_RADIX);
        System.out.println(Integer.parseInt("123",16));
    }

    public static void testLocalDateTime(){
        int deadline= 25;

        LocalDate ld1 = LocalDate.of(2018,3,1);
        LocalDate ld2 = LocalDate.of(2018,3,5);
        if(deadline>=25){
            if(ld1.plusDays(25).compareTo(ld2)>0){
                System.out.println("不能转让");
            }else{
                System.out.println("能转让");
            }
        }else{
            if(ld1.plusDays(deadline).compareTo(ld2)>0){
                System.out.println("不能转让");
            }else{
                System.out.println("能转让");
            }
        }
    }
}
