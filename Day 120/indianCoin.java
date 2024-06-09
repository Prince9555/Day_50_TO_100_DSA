import java.util.*;
/**
 * indianCoin
 */
public class indianCoin {

  public static void main(String[] args) {
    Integer coin[]={1,2,5,10,20,50,100,500,2000};
    int amount=590;
    Arrays.sort(coin,Comparator.reverseOrder());
    int count=0;
    ArrayList<Integer> ans=new ArrayList<>();
    for(int i=0;i<coin.length;i++)
    {
    if(coin[i]<=amount){
      while(coin[i]<=amount){
      amount -=coin[i];
      count++;
      ans.add(coin[i]);
    }}
  }
  }
}