import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;
class Main {
  public static void main(String[] args) {
 String word = "";
    String[] alphabet = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    Scanner input = new Scanner(System.in);
    ArrayList<String> listOfWords = new ArrayList<String>();
    System.out.println("Enter your words here. Type done when finished");
    while(!(word.toUpperCase().equals("DONE"))){
      word=input.next();
      listOfWords.add(word);
    }
    listOfWords.remove(listOfWords.size()-1);
    int letters=listOfWords.get(0).length();
    for(int i=1; i<listOfWords.size(); i++){
      int numOfLet=listOfWords.get(i).length();
      if(letters<numOfLet){
        letters=numOfLet;
      }
    }
    String[][] wordSearch = new String[letters][letters];
    int random=0;
    for(int i=0; i<listOfWords.size(); i++){
      random = 1+(int)(Math.random()*3);
      String direction = "";
      if(random==1){
        direction = "horizontal";
      }
      else if(random==2){
        direction = "vertical";
      }
      else{
        direction = "diagonal";
      }
      if(direction.toUpperCase().equals("HORIZONTAL")){
        random = (int)(Math.random()*letters);
        int randomCol = (int)(Math.random()*letters);
        if((letters-random+1)>listOfWords.get(i).length()){
          for(int j=0; j<listOfWords.get(i).length(); j++){
            if(wordSearch[random+j][randomCol]==null){
            String character = listOfWords.get(i).substring(j, j+1);
            wordSearch[random+j][randomCol]=character;
          }
            else{
              i--;
            }
          }
        }
        else{
          i--;
        }
      }
      else if(direction.toUpperCase().equals("VERTICAL")){
        random = (int)(Math.random()*letters);
        int randomRow = (int)(Math.random()*letters);
        if((listOfWords.size()-random+1)>listOfWords.get(i).length()){
          for(int j=0; j<listOfWords.get(i).length(); j++){
            if(wordSearch[randomRow][random+j]==null){
            String character = listOfWords.get(i).substring(j, j+1);
            wordSearch[randomRow][random+j]=character;
          }
            else{
              i--;
            }
          }
        }
        else{
          i--;
        }
      }
      else{
        random = (int)(Math.random()*letters);
        int randomRow = (int)(Math.random()*letters-1);
        if(random+listOfWords.get(i).length()-1<letters&&randomRow+listOfWords.get(i).length()-1<letters){
          for(int j=0; j<listOfWords.get(i).length(); j++){
            if(wordSearch[randomRow+j][random+j]==null){
            String character = listOfWords.get(i).substring(j, j+1);
            wordSearch[randomRow+j][random+j]=character;
          }
            else{
              i--;
            }
          }
        }
        else{
          i--;
        }
      }
    }
    for(int i=0; i<letters; i++){
      for(int j=0; j<letters; j++){
        for(int k=0; k<alphabet.length; k++){
          if(wordSearch[i][j]==null){
            random=(int)(Math.random()*(alphabet.length-1));
            wordSearch[i][j]=alphabet[random];
          }
        }
      }
    }
    //System.out.println(wordSearch[0].length);
    for(int i=0; i<wordSearch.length; i++){
      for(int j=0; j<wordSearch[0].length; j++){
        System.out.print(wordSearch[i][j]+" ");
        //System.out.print("a");
      }
      System.out.println();
    }
  }
}
