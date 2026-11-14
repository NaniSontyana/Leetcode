class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n=nums.size();
        int ans=Integer.MAX_VALUE;

        int[] prefix=new int[n+1];

        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+nums.get(i);       
            }

        for(int start=0;start<n;start++){
            for(int len=l;len<=r;len++){
                int end=start+len-1;

                if(end>=n){
                    break;
                }
                int sum=prefix[end+1]-prefix[start];
                if(sum>0){
                    ans=Math.min(ans,sum);
                }

            }

        }
        return ans==Integer.MAX_VALUE?-1:ans;
        
    }
}