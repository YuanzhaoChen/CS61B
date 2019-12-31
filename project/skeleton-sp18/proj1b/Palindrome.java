public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> deque =  new LinkedListDeque2<>();
        for (int i=0; i<word.length();i++){
            deque.addLast(word.charAt(i));
        }
        return deque;
    }
    public boolean isPalindrome(String word){
        String reverseWord="";
        for(int i=word.length()-1; i>=0 ;i--){
            reverseWord += word.charAt(i);
        }
        return word.equals(reverseWord);
    }
    public boolean isPalindrome(String word, CharacterComparator cc){
        int start=0, end=word.length()-1;
        while(start<end){
            char c1=word.charAt(start);
            char c2=word.charAt(end);
            if(!cc.equalChars(c1,c2)){
                return false;
            }
            start+=1;
            end-=1;
        }
        return true;
    }
}
