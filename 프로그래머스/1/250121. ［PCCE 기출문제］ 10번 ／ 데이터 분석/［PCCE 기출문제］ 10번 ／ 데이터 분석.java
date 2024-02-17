import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        List<Integer[]> list = new ArrayList<>();
        
        for(int i = 0; i < data.length; i++){
            if(ext.equals("date")){
                if(data[i][1] < val_ext){
                    list.add(Arrays.stream(data[i]).boxed().toArray(Integer[]::new));
                }
            }else if(ext.equals("code")){
                if(data[i][0] < val_ext){
                    list.add(Arrays.stream(data[i]).boxed().toArray(Integer[]::new));
                }
            }else if(ext.equals("maximum")){
                if(data[i][2] < val_ext){
                    list.add(Arrays.stream(data[i]).boxed().toArray(Integer[]::new));
                }
            }else if(ext.equals("remain")){
                if(data[i][3] < val_ext){
                    list.add(Arrays.stream(data[i]).boxed().toArray(Integer[]::new));
                }
            }
        }
        
        if(sort_by.equals("code")){
            Collections.sort(list, new Comparator<Integer[]>() {
                @Override
                public int compare(Integer[] arr1, Integer[] arr2) {
                    return Integer.compare(arr1[0], arr2[0]);
                }
            });
        }else if(sort_by.equals("date")){
            Collections.sort(list, new Comparator<Integer[]>() {
                @Override
                public int compare(Integer[] arr1, Integer[] arr2) {
                    return Integer.compare(arr1[1], arr2[1]);
                }
            });
        }else if(sort_by.equals("maximum")){
            Collections.sort(list, new Comparator<Integer[]>() {
                @Override
                public int compare(Integer[] arr1, Integer[] arr2) {
                    // 특정 인덱스의 값으로 비교하여 정렬
                    return Integer.compare(arr1[2], arr2[2]);
                }
            });
        }else if(sort_by.equals("remain")){
            Collections.sort(list, new Comparator<Integer[]>() {
                @Override
                public int compare(Integer[] arr1, Integer[] arr2) {
                    return Integer.compare(arr1[3], arr2[3]);
                }
            });
        }
        
        int[][] answer = new int[list.size()][list.get(0).length];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = Arrays.stream(list.get(i))
                               .mapToInt(Integer::intValue)
                               .toArray();
        }
        return answer;
    }
}