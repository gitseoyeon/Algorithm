class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int worstRank = 0;
        int bestRank = 0;
        int matchedCount = 0;
        int zeroCount = 0;

        for (int n : lottos) {
            if (n == 0) {
                zeroCount++;
            } else {
                for (int wn : win_nums) {
                    if (n == wn) {
                        matchedCount++;
                        break;
                    }
                }
            }
        }

        int totalMatches = matchedCount + zeroCount;

        worstRank = getRank(matchedCount);
        bestRank = getRank(totalMatches);

        int[] answer = {bestRank, worstRank};

        return answer;
    }

    public int getRank(int matchedCount) {
        switch (matchedCount) {
            case 6: return 1;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            case 2: return 5;
            default: return 6;
        }
    }
}
