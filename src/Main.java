public class Main {

    public static void main(String[] args) {
        //Example 1: nums = 1, 2, 3, 5, 6, 7; divisibility = 2; => 2 (2 and 6 are divisible by 2)
        //Example 2: nums = 8, 19, 27, 54, 31, 81; divisibility = 9; => 3

        int divisibility = 9;
        int[] nums = {8, 19, 27, 54, 31, 81};

        countMults(nums, divisibility);


        //-------------------------------------------------------------------------------------------------------
        //Example 1: nums = 3, 1, 3, 1, 3; => true
        //Example 2: nums = 3, 1, 3, 1; => false
        //Example 3: nums = 3, 1, 3, 3; => false

        int[] nums1 = {3, 1, 3, 1, 3};

        hasThreeNonAdjacentThrees(nums1);

        //-------------------------------------------------------------------------------------------------------
        //Example 1: letters = "azzzaaataaaczzzc", word = "cat" => true
        //Example 2: letters = "abcdefghijklmnopqrstuvwxyz" word is anything => true
        //Example 3: letters = "azzzaaataaazzzzz" word = "cat", => false

        char[] letters = "azzzaaataaazzzzz".toCharArray();
        String word = "cat";

        containsString(letters, word);
    }

    //Returns the number of numbers that are divisible by "divisibility"
    public static int countMults(int[] nums, int divisibility){
        int total = 0;
        for(int num : nums){
            if(num % divisibility == 0){
                total ++;
            }
        }
//        System.out.println("Should return 3 " + total);
        return total;
    }

    //Returns true if the array contains three non-adjacent threes and no adjacent 3s
    //Returns false if it detects any adjacent 3s
    public static boolean hasThreeNonAdjacentThrees (int[] nums){
        int nonAdjacent = 0;
        int previousIndexOfThree = 0;


        for(int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
            if(nums[i] == 3){
                if(i == 0){
                    System.out.println("first number is three, increasing nonadjacent");
                    nonAdjacent ++;
                } else if(i+1 < nums.length && nums[i+1] == 3){
                    System.out.println("adjacent threes == false");
                    return false;
                } else if(previousIndexOfThree == i-2){
                    System.out.println("increasing nonadjacent");
                    nonAdjacent ++;
                }
                System.out.println("previous index number set to " + i);
                previousIndexOfThree = i;
            }


        }
//        System.out.println("non adjacent count " + nonAdjacent);
        if(nonAdjacent == 3 || nonAdjacent == 0){
            System.out.println("3 or 0 non adjacents true");
            return true;
        } else {
            System.out.println("less than three non adjacents false");
            return false;
        }
    }

    //Returns true if all the letters in word are contained in letters
    //Order or frequency doesn't matter
    public static boolean containsString (char[] letters, String word){
        int numberOfSameLetters = 0;
        word.toCharArray();
        for(char charInWord : word.toCharArray()) {
            for (char letter : letters) {
                if(charInWord == letter){
//                    System.out.println("letter " + letter);
                    numberOfSameLetters ++;
                    break;
                }
            }
        }
        if(numberOfSameLetters == word.length()){
//            System.out.println(true);
            return true;
        }
//        System.out.println("false");
        return false;
    }
}
