import java.util.Arrays;

/**
 * 5、归并排序（Merge Sort）
 * 算法步驟:
 * 如果待排序列只有一个元素，则直接返回，否则将长度为n的待排序列分成两个长度为n/2的子序列，递归进行调用进行分割知道每个子序列中只有一个元素；
 * 此时的每个子序列被认为是有序的，然后 "递归" 调用的返回子序列进行两两合并；
 * 合并过程中完成排序操作，具体操作为设定两个指针，分别指向两个已经排序子序列的起始位置；
 * 比较两个指针所指向的元素，选择相对小的元素放入到合并返回的数组，并移动指针到下一位置；
 * 重复步骤3~4直到某一指针达到序列尾；
 * 将另一序列剩下的所有元素直接复制到合并序列尾，最终得到的新序列就是有序序列。
 */
public class mergeSort  //时间复杂度 O（nlogn）
{
    public static void main(String[] args)
    {
        int[] arr = {11,44,23,67,88,65,34,48,9,12};
        int[] tmp = new int[arr.length];    //新建一个临时数组存放
        int len = arr.length;
        mergeSort(arr,0,len-1,tmp);
        System.out.println("\n最终排序结果："+Arrays.toString(arr));
    }

    //核心代码： 如何合并
    public static void merge(int[] arr,int low,int mid,int high,int[] tmp)
    {
        int i = 0;               //i代表位置
        int j = low,k = mid+1;  //左边序列和右边序列起始索引：low 与 mid+1
        while(j <= mid && k <= high)  //low到mid； mid+1到high 2部分
        {
            if(arr[j] < arr[k]){
                tmp[i++] = arr[j++]; //i找个位置是 ：左边序列的j，若是i++，j++ ；还是右边序列的k，若是 i++，k++
            }else{
                tmp[i++] = arr[k++];
            }
        }
        //若左边序列还有剩余，则将其全部拷贝进tmp[]中
        while(j <= mid){
            tmp[i++] = arr[j++];
        }
        //若右边序列还有剩余，则将其全部拷贝进tmp[]中
        while(k <= high){
            tmp[i++] = arr[k++];
        }
        System.out.println(i);  //i的值在不断改变，随着序列大小
        System.out.println(Arrays.toString(tmp));
        for(int t=0;t<i;t++){    //将
            arr[low+t] = tmp[t];
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr,int low,int high,int[] tmp)
    {
        if(low<high)
        {
            //递归部分:
            int mid = (low+high)/2;
            mergeSort(arr,low,mid,tmp); //对左边序列进行归并排序
            mergeSort(arr,mid+1,high,tmp);  //对右边序列进行归并排序
            //合并代码：
            merge(arr,low,mid,high,tmp);    //合并两个有序序列
        }
    }

}
