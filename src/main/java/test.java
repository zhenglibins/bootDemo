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
//        List<String> list = new ArrayList<String>();
//        list.add(null);
        int result = 0 ;
         result = result*2;
         System.out.println(result);

         Integer int1 = 300;
        Integer int2 = 300;
        Integer int3 = 127;
        Integer int4 = 127;
        System.out.println(int1.equals(int2));
        System.out.println(int1==int2);
        System.out.println(int3.equals(int4));
        System.out.println(int3==int4);

        int int5 = 500;
        int int6 = 500;
        System.out.println(int5==int6);
    }


}
