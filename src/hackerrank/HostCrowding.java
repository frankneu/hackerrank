package hackerrank;

import java.util.*;

/**
 * https://github.com/cicean/leetcode-java/blob/98530981aecbd75bf482fd22df2cfc553690c104/src/Airbnb/HostCrowding.java
 */
public class HostCrowding {
    static List<String> paginate(int resultsPerPage, List<String> results) {
        Map<String, List<String>> map = new HashMap<>();//将同一个hostid的数据合并到一个list中
        List<String> source = new LinkedList<>();//对输入数据进行转码，进行无副作用的删除操作
        TreeMap<Double, List<String>> order = new TreeMap<>();//按照比分进行排序
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
        }//组织数据，写入map
        List<String> pages = new LinkedList<>();//结果页
        while(!source.isEmpty()){
            int count = resultsPerPage;
            while(count >0 && !source.isEmpty() ){//当前页满或是剩余元素已经空了
                Object[] keys = order.keySet().toArray();
                //先取出当前的key，然后依次从队列头部取出信息放入页中
                //如果一轮匹配页面不满，则再执行一次
                for(int i=keys.length-1;i>=0&& count >0;i--){
                    Double point = (Double)keys[i];
                    List<String> list = order.get(point);
                    String thisValue = list.get(0);
                    pages.add(thisValue);
                    //@transaction start
                    /**
                     * 1. 队列移除刚刚加入页面的元素
                     * 2. order中更新key为新的队头的point
                     * 3. 从source中移除元素
                     * 4. count--
                     */
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
                    //@transaction end
                }
            }
            pages.add("");//一页count满
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
