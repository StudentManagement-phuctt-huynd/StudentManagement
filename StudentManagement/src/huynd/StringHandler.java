/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huynd;

/**
 *
 * @author Lawliet
 */
public class StringHandler {
    public static boolean isVowel(char ch) {
        String vnVowelStr = "ẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴY";
        String vowelStr = "UEOAI";
        ch = Character.toUpperCase(ch);
        
        //System.out.println("Char: " + ch);
        for (int i = 0; i < vnVowelStr.length(); i++) {
            if(vnVowelStr.charAt(i) == ch) { return true; }
        }
        for (int i = 0; i < vowelStr.length(); i++) {
            if(vowelStr.charAt(i) == ch) { return true; }
        }
        
        return false;
    }
    
    public static int countVowel(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(StringHandler.isVowel(str.charAt(i))) { count++; }
        }
        return count;
    }
    
    public static int countConsonant(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(!StringHandler.isVowel(str.charAt(i))) { count++; }
        }
        return count;
    }
    
    public static int countSpaces(String str) {
        int spaces = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                spaces++;
            }
        }
        return spaces;
    }
}
