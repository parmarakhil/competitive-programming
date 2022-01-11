public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(5%3);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)return findMedianSortedArrays(nums2,nums1);
        int n1 = nums1.length;
        int n2 = nums2.length;
        int low =0;
        int high= n1;
        while(low<=high)
        {
            int l1,l2,r1,r2;
            int part1 = low +(high-low)/2;
            int part2 = ((n1+n2)/2)-part1;

            if(part1==0)
            {
                l1=Integer.MIN_VALUE;
            }
            else{
                l1=nums1[part1-1];
            }

            if(part2==0)
            {
                l2=Integer.MIN_VALUE;
            }
            else{
                l2=nums2[part2-1];
            }

            if(part1==n1)
            {
                r1=Integer.MAX_VALUE;
            }
            else{
                r1=nums1[part1];
            }

            if(part2==n2)
            {
                r2=Integer.MAX_VALUE;
            }
            else{
                r2=nums2[part2];
            }

            if(l1>r2)
            {
                high=part1-1;
            }
            else if(l2>r1)
            {
                low=part1+1;
            }
            else{

                return (n1+n2)%2==0 ? (float)( Math.max(l1,l2)+Math.min(r1,r2))/2 : (float)Math.min(r1,r2);
            }
        }
        return -1;


    }
}
