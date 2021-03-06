/*3. Longest Substring Without Repeating Characters - Leetcode Java Solutions*/


/*
---------------------------Sliding Window Approach (Optimised)----------------------------

Time Complexity : O(n)
Space Complexity :  O(min(n,m))

*/

class LongSubsWithoutRepChars
{
   
    public int lengthOfLongestSubstring(String s) 
    {
        if(s.length()==0)
            return 0;
        
        if(s.length()==1)
            return 1;
        
        int i=0,j=0, res=0,n=s.length();
        HashMap<Character, Integer> hm = new HashMap<>();
        
        while(j<n)
        {
            if(hm.containsKey(s.charAt(j)))
                i=Math.max(hm.get(s.charAt(j))+1, i);
            
            hm.put(s.charAt(j), j);
            res=Math.max(res, j-i+1);
            j++;
        }   
        
        return res;
    }
}

/*
---------------------------Sliding Window Approach----------------------------

Time Complexity : O(2n)
Space Complexity :  O(min(n,m))

*/


/*
class LongSubsWithoutRepChars
{
   
    public int lengthOfLongestSubstring(String s) 
    {
        if(s.length()==0)
            return 0;
        
        if(s.length()==1)
            return 1;
        
        int i=0,j=0, res=0,n=s.length();
        Set<Character> hs=new HashSet<>();
        
        while(i<n && j<n)
        {
            if(!hs.contains(s.charAt(j)))
            {
                hs.add(s.charAt(j));
                res=Math.max(j-i+1, res);
                j++;
            }
            else
            {
                hs.remove(s.charAt(i));
                i++;
            }
        }   
    
        
        return res;
    }
}
*/


/*
---------------------------Brute Force----------------------------

Time Complexity : O(n^3)
Space Complexity :  O(min(n,m))

*/

/*
class Solution
{
    public boolean checkUnq(String s, int st, int end)
    {
        int i;
        Set<Character> hs=new HashSet<>();
        
        for(i=st;i<end;i++)
        {
            if(hs.contains(s.charAt(i)))
                return false;
            else
                hs.add(s.charAt(i));
        }
        
        return true;
    }
    public int lengthOfLongestSubstring(String s) 
    {
        if(s.length()==0)
            return 0;
        
        if(s.length()==1)
            return 1;
        
        int i,j,n=s.length(),maxLen=Integer.MIN_VALUE;
        
        for(i=0;i<n-1;i++)
        {
            for(j=i+1;j<=n;j++)
            {
                if(checkUnq(s,i,j))
                    maxLen=Math.max(maxLen, j-i);
            }
        }
        
        return maxLen;
    }
}
*/