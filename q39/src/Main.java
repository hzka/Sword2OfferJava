public class Main {

    public static void main(String[] args) {
        System.out.println(MoreThanHalfNum_Solution(new int []{2,2,2,2,2,1,3,4,5}));
    }

    public static int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0) return 0;
        if(array.length == 1) return array[0];
        int counting = 1;
        int nownumber = array[0];
        for(int i  = 1;i<array.length;i++){
            if(counting == 0){
                nownumber = array[i];
                counting = 1;
            }
            if(array[i] == array[i-1])   counting++;
            if(array[i] != array[i-1])   counting--;
        }
        int allcounting = 0;
        for(int i  = 1;i<array.length;i++){
            if(nownumber == array[i])   allcounting++;
            if(allcounting>array.length/2)  return nownumber;
        }
        return 0;
    }
}
