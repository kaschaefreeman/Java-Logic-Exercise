package io.catalyte.training;

import java.math.BigDecimal;
import java.math.RoundingMode;import java.util.*;
import java.util.stream.Collectors;


/** Contains multiple common logic exercises. */
public class LogicExercise {

  /**
   * Takes a BigDecimal for the unit price and an int for number of units sold and returns a
   * discounted sales total based on the quantity sold: if more than 99 units are sold, apply a 15%
   * discount to the total price; if more than 49 units are sold, apply a 10% discount 10% to the
   * total price; if less than 50 units are sold, do not apply a discount to the price. For example,
   * if the unit price was 1.00 and the quantity sold was 100, the method should return 85.00 for
   * the total sales amount.
   */
  public BigDecimal getDiscount(BigDecimal unitPrice, int unitAmount) {
    BigDecimal subTotal = unitPrice.multiply(BigDecimal.valueOf(unitAmount));

    double discount;
    if (unitAmount >= 99) {
      discount = -.15;
    } else if (unitAmount > 49) {
      discount = -.10;
    } else {
      discount = 0;
    }

    BigDecimal totalPrice = subTotal.add(subTotal.multiply(BigDecimal.valueOf(discount)));

    return totalPrice.setScale(2, RoundingMode.HALF_EVEN);
  }

  /**
   * This method takes an int representing a percentile score and should return the appropriate
   * letter grade. If the score is 90 or above, return 'A'; if the score is between 80 and 89,
   * return 'B'; if the score is between 70 and 79, return 'C'; if the score is between 60 and 69,
   * return 'D'; if the score is below 60, return 'F'.
   */
  public char getGrade(int score) {
    char grade = 'F';

    if (score >= 90) {
      grade = 'A';
    } else if (score >= 80) {
      grade = 'B';
    } else if (score >= 70) {
      grade = 'C';
    } else if (score >= 60) {
      grade = 'D';
    }

    return grade;
  }

  /**
   * This method should take an ArrayList of strings, remove all the elements in the array
   * containing an even number of letters, and then return the result. For example, if given an
   * array of "Cat", "Dog", "Bird", the method should return an array containing only "Cat" and
   * "Dog".
   */
  public ArrayList<String> removeEvenLength(ArrayList<String> a) {
    a.removeIf(s -> s.length() % 2 ==0);
    return a;
  }

  /**
   * This method should take an double array, a, and return a new array containing the square of
   * each element in a.
   */
  public double[] powerArray(double[] a) {
    for (int i = 0; i < a.length; i++) {
      a[i] *= a[i];
    }
    return a;
  }

  /**
   * This method should take an int array, a, and return the index of the element with the greatest
   * value.
   */
  public int indexOfMax(int[] a) {
    int max = Integer.MIN_VALUE;
    int maxIndex = -1;
    for (int i = 0; i < a.length; i++) {
      int num = a[i];
      if (a[i] > max) {
        max = num;
        maxIndex = i;
      }
    }
    return maxIndex;
  }

  /**
   * This method should take an ArrayList of Integers, a, and returns true if all elements in the
   * array are divisible by the given int, i.
   */
  public boolean isDivisibleBy(ArrayList<Integer> a, int i) {
    return a.stream().allMatch(val -> val % i == 0);
  }

  /**
   * A word is "abecedarian" if its letters appear in alphabetical order--the word 'biopsy' for
   * example. This method should take String s and return true if it is abecedarian.
   */
  public boolean isAbecedarian(String s) {
    char[] charArray = s.toCharArray();
    Arrays.sort(charArray);
    String sortedString = new String(charArray);
    return s.equals(sortedString);
  }

  /**
   * This method should take 2 strings and return true if they are anagrams of each other. For
   * example, "stop" is an anagram for "pots".
   */
  public boolean areAnagrams(String s1, String s2) {
    if(s1.length() != s2.length()) return false;

    HashMap<Character, Integer> s1Map = new HashMap<>();
    HashMap<Character, Integer> s2Map = new HashMap<>();

    for (int i = 0; i < s1.length(); i++) {
      char s1Char = Character.toLowerCase(s1.charAt(i));
      char s2Char = Character.toLowerCase(s2.charAt(i));
      if (s1Map.containsKey(s1Char)) {
        int value = s1Map.get(s1Char) + 1;
        s1Map.put(s1Char, value);
      } else {
        s1Map.put(s1Char, 1);
      }
      if (s2Map.containsKey(s2Char)) {
        int value = s2Map.get(s2Char) + 1;
        s2Map.put(s2Char, value);
      } else {
        s2Map.put(s2Char, 1);
      }
    }
    return s1Map.equals(s2Map);
  }

  /**
   * This method should take a String and return the number of unique characters. For example, if
   * the method is given "noon", it should return a value of 2.
   */
  public int countUniqueCharacters(String s) {
    Set<Character> set = s.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
    return set.size();
  }

  /**
   * This method should take a string and return true if it is a palindrome, i.e. it is spelled the
   * same forwards and backwards. For example, the words "racecar" and "madam" are palindromes.
   */
  public boolean isPalindrome(String s) {
    char[] charArray = s.toCharArray();
    String newString = new StringBuilder(new String(charArray)).reverse().toString();
    return s.equals(newString);
  }

  /**
   * This method should take a string and return a HashMap which is a map of characters to a list of
   * their indices in a string (i.e., which characters occur where in a string). For example for the
   * string "Hello World", the map would look something like: d=[9], o=[4, 6], r=[7], W=[5], H=[0],
   * l=[2, 3, 8], e=[1].
   */
  public HashMap<String, ArrayList<Integer>> concordanceForString(String s) {
    HashMap<String, ArrayList<Integer>> result = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char sChar = s.charAt(i);
      String letter = String.valueOf(sChar);
      ArrayList<Integer> indices = result.get(letter);
      if (indices == null) indices = new ArrayList<>();
      indices.add(i);
      result.put(letter, indices);
    }

    return result;
  }
}
