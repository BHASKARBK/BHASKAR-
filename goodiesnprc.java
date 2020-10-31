package goodies;

import java.io.*;
import java.util.*;
public class goodiesnprc {
public static void main(String[] args) throws Exception {
FileInputStream f=new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\goodies\\src\\sample_input.txt"); //      
Scanner bk=new Scanner(f);
int number_of_employees = Integer.parseInt(bk.nextLine().split(": ")[1]);
bk.nextLine();bk.nextLine();bk.nextLine();
class goodie {
int amt; String lst;
public goodie(String name, int price) {
this.lst = name; this.amt = price;
}
  public String toString() { 
  return this.lst + ": " + this.amt;
 }
}
ArrayList<goodie> goodies_items = new ArrayList<goodie>();
while(bk.hasNextLine())  
{
  String exist[] = bk.nextLine().split(": ");
  goodies_items.add(new goodie(exist[0], Integer.parseInt(exist[1])));
}
bk.close();
Collections.sort(goodies_items, new Comparator<goodie>(){
  public int compare(goodie a, goodie b) { 
    return a.amt - b.amt; 
  } 
});

int mindif = goodies_items.get(goodies_items.size()-1).amt;
int min = 0;
for(int i=0;i<goodies_items.size()-number_of_employees+1;i++) {
  int diff = goodies_items.get(number_of_employees+i-1).amt-goodies_items.get(i).amt;
  if(diff<=mindif) {
    mindif = diff;
    min = i;
  }
}
FileWriter fw = new FileWriter("C:\\Users\\Dell\\eclipse-workspace\\goodies\\src\\output.txt");
fw.write("The goodies selected for distribution are: \r\n");
for(int i=min;i<min + number_of_employees; i++) {
fw.write(goodies_items.get(i).toString() + "\r\n");
}
fw.write("\nthe difference b/w the chosen goodie with high price and low price is " + mindif);
fw.close();
}
}