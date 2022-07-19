import java.util.*;

public class FlexibleString {
    /**
     * Given a string & operations
     * Can the given string converted to all of same characters?
     * eg: String s = abccc;
     *      Operatiosn: b can be replaced by c
     *                  a can be replaced by b
     *
     *  The operations can be performed in any order and any number of times
     * */

    public static void main(String[] args) {
        System.out.println(canBeConverted("abcdc", new char[][]{
                {'b','c'},
                {'a','b'},
                {'c','d'}
        }));
    }
    public static boolean canBeConverted(String s, char[][] opts){

        Map<Character, HashSet<Character>> operations = new HashMap<>();
        for(char[] operation : opts){
            operations.putIfAbsent(operation[0], new HashSet<>());
            operations.get(operation[0]).add(operation[1]);
        }
        HashMap<Character, HashSet<Character>> convert = new HashMap<>();
        for(char[] operation : opts)
            visit(operation[0], operations, convert);
        char[] chrs = s.toCharArray();
        for(char c = 'a'; c<'z';c++){
            boolean flag = false;
            for(char ch: chrs){
                HashSet set = convert.get(ch);
                if(ch != c && (set == null || !set.contains(c))){
                    flag = true;
                    break;
                }
            }
            if(!flag) return true;
        }
        return false;
    }

    private static Set<Character> visit(char c, Map<Character, HashSet<Character>> operations, HashMap<Character, HashSet<Character>> convert) {
        if(convert.get(c) != null ) return  convert.get(c);;
        convert.put(c, new HashSet<>());
        HashSet<Character> children = operations.get(c);
        if(children != null){
            for(char child: children){
                convert.get(c).add(child);
                convert.get(c).addAll(visit(child, operations, convert));
            }
        }
        return convert.get(c);
    }
}
