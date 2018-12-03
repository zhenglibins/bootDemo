import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by zhenglibin on 2018/4/13.
 */
public class test {
    public static void main(String args[]){
//        LocalDate ld1 = LocalDate.of(2017,5,23);
//        LocalDate ld2 = LocalDate.of(2018,11,22);
//        System.out.println(Period.between(ld1,ld2));
        List<String> list = new ArrayList<String>();
        list.add(null);
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
