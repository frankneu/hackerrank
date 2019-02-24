package hackerrank;

import java.util.*;

/**
 * https://www.1point3acres.com/bbs/thread-278720-1-1.html
 */
public class HostCrowding {
    static List<String> paginate(int resultsPerPage, List<String> results) {
        Map<String, List<String>> map = new HashMap<>();//host_id
        List<String> source = new LinkedList<>();
        TreeMap<Double, List<String>> order = new TreeMap<>();
        source.addAll(results);
        for(String str : results){
            String[] array = str.split(",");
            if(map.containsKey(array[0])){
                map.get(array[0]).add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                Double point = Double.valueOf(array[2]);
                order.put(point, list);
                map.put(array[0], list);
            }
        }
        List<String> pages = new LinkedList<>();
        while(!source.isEmpty()){
            int count = resultsPerPage;
            while(count >0 && !source.isEmpty() ){
                Object[] keys = order.keySet().toArray();
                for(int i=keys.length-1;i>=0&& count >0;i--){
                    Double point = (Double)keys[i];
                    List<String> list = order.get(point);
                    String thisValue = list.get(0);
                    pages.add(thisValue);
                    list.remove(0);
                    order.remove(point);
                    if(list.size()>0) {
                        String newString = list.get(0);
                        String[] array = newString.split(",");
                        Double newPoint = Double.valueOf(array[2]);
                        order.put(newPoint, list);
                    }
                    source.remove(thisValue);
                    count--;
                }
            }
            pages.add("");
        }
        return pages;
    }

    public static void main(String[] args){
        List<String> list = Arrays.asList("1,28,300.6,San Francisco","4,5,209.1,San Francisco","20,7,203.4,Oakland","6,8,202.9,San Francisco","6,10,199.8,San Francisco","1,16,190.5,San Francisco","6,29,185.3,San Francisco","7,20,180.0,Oakland","6,21,162.2,San Francisco","2,18,161.7,San Jose","2,30,149.8,San Jose","3,76,146.7,San Francisco","2,14,141.8,San Jose");
        System.out.println(list.size());
        List<String> res = paginate(5, list);
        for(String str : res){
            System.out.println(str);
        }
    }
}
