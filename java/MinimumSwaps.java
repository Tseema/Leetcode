public class MinimumSwaps {
    public static void main(String [] args){
        int [] arr = {1,0,1,0,1};
        minSwaps(arr);

    }

    public static int minSwaps(int[] data) {

        int countOns = 0;
        int len= data.length;

// fixed window size problem
        for(int val:data){
            if(val==1){
                countOns++;
            }
        }

        int start=0;
        int end=0;

        int windowSize =0;

// maximum swaps will be when no 1 are beside and every thing has to be swaped
        int result = countOns;

        int minimumswaps=0 ;

        while(end<len){

// we only need to swap if we encounter 0
            if(data[end]==0){
                minimumswaps++;
            }

// the sliding window size will be always equal to length of the number of ones
//we keep increamenting untill we reach the window
            if(windowSize<countOns){

                windowSize++;
            }

//once the window is reached we have to check the calculate the swaps so far
            if(windowSize==countOns){

                result = Math.min(result, minimumswaps);

                // we have to slide the window hence move the start by 1 element and and we have to substract if it is accountable to minimum swaps value
                if(data[start]==0){
                    minimumswaps--;
                }

                //decrease the window by 1
                start++;

            }

//move the end by once element and make the window size constant again
            end++;

        }

        return result;

    }


}
