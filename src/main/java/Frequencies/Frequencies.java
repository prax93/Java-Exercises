package Frequencies;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Frequencies {


    public static void main (String[] args){

        String text = "Hallo Hallo hallo wie geht es dir?";

        List<String> splitted = List.of(text.split(" "));

        Map<String, Long> wordfrequencies = splitted.stream().collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
        
        wordfrequencies.keySet().stream().sorted().forEach(word -> System.out.println(word + ": " + wordfrequencies.get(word)));

        

    }




}
