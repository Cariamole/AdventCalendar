import java.util.ArrayList;
import java.util.List;

public class Jour1 {

    private int count_zeros;
    private int currentDial;
    private List<Pair<Character,Integer>> listOpe;

    public Jour1(String s, int start){
        this.currentDial=start;
        this.count_zeros=0;
        listOpe=new ArrayList<>();
        for (String line : s.split("\\R")) { // \R = toute fin de ligne
            listOpe.add(stringToInt(line));
        }
    }

    private static Pair<Character,Integer> stringToInt(String s){
        char lr=s.charAt(0);
        int ret=Integer.parseInt(s.substring(1,s.length()));
        Pair<Character,Integer> pair=new Pair<>(lr,ret);
        return pair;
    }



    private int nbOfZeroes(Pair<Character,Integer> p){
        int nb0=p.getRight()/100;
        int turn=p.getRight()%100;
        if(p.getLeft()=='R'){
            int newDial=(this.currentDial+turn)%100;
            if(newDial<currentDial)nb0++;
            this.currentDial=newDial;
            return nb0;
        }else{
            int newDial=(this.currentDial-turn+100)%100;
            if((newDial > this.currentDial || newDial==0) && currentDial!=0){
                nb0++;
            }
            this.currentDial=newDial;
            return nb0;
        }
    }

    public void countZeros(){
        for (int i = 0; i < this.listOpe.size(); i++) {
            this.count_zeros+=nbOfZeroes(listOpe.get(i));
        }
        System.out.println(this.count_zeros);
    }

}
