import java.util.ArrayList;
import java.util.List;

public class SimplyfyPath {
    public String simplifyPath(String path) {
        List<String> result = new ArrayList<>();                                // create Arraylist to store our result
        String[] pathArray = path.split("/");                                   // split the path with "/"
        for(String str : pathArray){
            if(str == "" || str.equals(".")){ continue; }                       // no need to do anything, if str is empty, or is "."
            if(!str.equals("..")){ result.add(str); }                           // if str is not "..", then just add it to result list
            else{
                if(result.size() > 0){ result.remove(result.size()-1); }        // if str is "..", remove the last str from result list.
            }
        }
        return "/"+String.join("/", result);                                    // first add "/" at front. then add the string formed by joining "/" to all result list elements
    }
}
