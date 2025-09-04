import java.util.*;

public class LC28_StrStr_NoticeSearch {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String haystack = sc.nextLine();
        String needle = sc.nextLine();
        sc.close();

        int idx = strStr(haystack, needle);
        System.out.println(idx);
    }

    static int strStr(String haystack, String needle){
        if(needle.length()==0) return 0;
        int n = haystack.length(), m = needle.length();
        for(int i=0;i<=n-m;i++){
            if(haystack.substring(i,i+m).equals(needle)) return i;
        }
        return -1;
    }
}
