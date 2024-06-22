import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.concurrent.atomic.AtomicInteger;

public class Candies {
    public static void main(String [] args){
        int i = 3;
        int [] arr = {2,3,5,1,3};
        kidsWithCandies(arr,i);
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> returnlist = new ArrayList<>();
        if(candies.length > 0) {
            int highestCandyCount = Arrays.stream(candies).max().getAsInt();
            //AtomicInteger i = new AtomicInteger(0);
            Arrays.stream(candies).forEach(kid -> {
                if ((kid + extraCandies) >= highestCandyCount) {
                    returnlist.add(true);

                } else
                    returnlist.add(false);
            });
        }

        return returnlist;
    }
}
