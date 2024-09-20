import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;

        Arrays.sort(mats);
        for (int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i];
            
            for (int r = 0; r < park.length; r++) {
                for (int c = 0; c < park[0].length; c++) {
                    if (park[r][c].equals("-1")) {
                        if (checkMat(park, r, c, size)) {
                            return size;
                        }
                    }
                }
            }
        }

        return answer;
    }

    public static boolean checkMat(String[][] park, int r, int c, int size) {
        if (r + size > park.length || c + size > park[0].length) {
            return false;
        }
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }

        return true;
    }
}