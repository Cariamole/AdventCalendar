import java.util.*;

public class Jour2 {
    List<Pair<java.lang.Long,java.lang.Long>> list;

    public Jour2(String s){
        String[] ids=s.split(",");
        list=new ArrayList<>();
        for (int i = 0; i <ids.length; i++) {
            String[] line=ids[i].split("-");
            long a = Long.parseLong(line[0].trim());
            long b = Long.parseLong(line[1].trim());
            Pair<Long, Long> pair = new Pair<>(a, b);
            list.add(pair);
        }
    }

    public void printAll(){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getLeft() + " - "+ list.get(i).getRight());
        }
    }

    public long validSum(Long start,Long end){
        long ret=0L;
        for (Long i = start; i < end+1; i++) {
            String s=String.valueOf(i);
            if(s.length()%2==0){
                if(s.substring(0,s.length()/2).equals(s.substring(s.length()/2,s.length()))){
                    ret+=i;
                    System.out.println(i);
                }
            }
        }
        return ret;
    }

    private boolean repetitiveNumber(String[] tab){
        for (int i = 0; i < tab.length-1; i++) {
            for (int j = i+1; j < tab.length; j++) {
                if(!tab[i].equals(tab[j])){
                    return false;
                }
            }
        }
        return true;
    }

    private String[] toTab(String s,int part){
        int step=s.length()/part;
        String[] ret=new String[part];
        int retIdx=0;
        for (int i = 0; i < part; i++) {
            ret[i]=s.substring(retIdx,retIdx+step);
            retIdx+=step;
        }
        //System.out.println(s +"in "+part+" parts : " + Arrays.toString(ret));
        return ret;
    }

    public long validSumPart2(Long start,Long end){
        List<Long> invalidIds=new ArrayList<>();
        long ret=0L;
        for (Long i = start; i < end+1; i++) {
            String s=String.valueOf(i);
            for (int j = 2; j < s.length()+1; j++) {
                if(s.length()%j==0 && repetitiveNumber(toTab(s,j)) && !invalidIds.contains(i)) {
                    invalidIds.add(i);
                }
            }
        }
        for (int i = 0; i < invalidIds.size(); i++) {
            ret+=invalidIds.get(i);
            System.out.println(invalidIds.get(i));
        }
        return ret;
    }

    public void listInvalid(){
        long ret=0L;
        for (int i = 0; i < list.size(); i++) {
            ret+=validSumPart2(list.get(i).getLeft(),list.get(i).getRight());
        }
        System.out.println(ret);
    }
}
