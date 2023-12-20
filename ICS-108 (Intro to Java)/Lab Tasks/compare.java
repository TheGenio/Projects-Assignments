public class compare {
    public static void main(String[] args) {

        System.out.println(well("++-++-++--++-"));  // Output: 0
        System.out.println(well("-+--++--+--+---++------"));  // Output: 2
        System.out.println(well("-+---++-+-+-++---++++-"));  // Output: 3
        System.out.println(well("-+--++--+-+-+--+++++---+-"));  // Output: 4
        System.out.println(well("-+--+-+-+--++--++-+"));  // Output: 1
        System.out.println(well("----+---+-+---+-+++++++-+++-"));  // Output: 1
        System.out.println(well("+-+++++-++-+-+++++--+-+-++++"));  // Output: 0
        System.out.println(well("+---+--+-+"));  // Output: 0
        System.out.println(well("-+------+-"));  // Output: 1
        System.out.println(well("---+++++-+++++-+-"));  // Output: 1
        System.out.println(well("-+---+-----+++++-+-++-"));  // Output: 1
        System.out.println(well("+++-++-++-+-++-+++-+"));  // Output: 0
        System.out.println(well("-+-+++-+++++-"));  // Output: 2
        System.out.println(well("+---++-+-+-+-+++++-+"));  // Output: 5
        System.out.println(well("+-++--+++-+----++-++---+"));  // Output: 2
        System.out.println(well("-++-+-++++-+++--+--+---+-"));  // Output: 1
        System.out.println(well("-+-+----+---"));  // Output: 2
        System.out.println(well("+--+++-++---+----++-"));  // Output: 1
        System.out.println(well("-++++-++----++--"));  // Output: 1
        System.out.println(well("-++++++-++"));  // Output: 1
        System.out.println(well("++-+++-++-"));  // Output: 0
        System.out.println(well("++-++----+++++--+--+++--+-"));  // Output: 1

    }

    public static int well(String z){
        int times = 0;
        int count = 0;
        for(int i = 0; i < z.length(); i++){
            if(z.charAt(i) == '+'){
                times++;
            } else if(z.charAt(i) == '-'){
                times--;
            }

            if(times == -1){
                count = count + 1;
            }

        }
        return count;
    }
}
