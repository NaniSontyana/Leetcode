class Solution {
    public boolean canAliceWin(int n) {
        for (int stones = 10, turn = 0; stones > 0; stones--, turn++) {
            if (n < stones) {
                return turn % 2 == 1;
            }
            n -= stones;
        }
        return false;
    }
}