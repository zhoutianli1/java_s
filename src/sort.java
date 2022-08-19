import java.util.Arrays;
import java.util.Scanner;

public class sort {
    public static void main(String[] args)
    {

        int [] arr = {1,3,2,5,4,7,6,9,33,44,22,11,21};
        System.out.println("待排序的数组arr[]为："+ Arrays.toString(arr)); //Arrays类中的toStrin
        System.out.println("输入：");
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();

        switch (n)
        {
            case 1:
                bubbleSort(arr);
                break;

            case 2:
                selectionSort(arr);
                break;
            case 3:
                insertionSort(arr);
                break;
            case 4:
                shellSort(arr);
                break;

            default:

        }

    }

    /**
     * 比较类排序：通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn)，因此也称为非线性时间比较类排序。
     * 非比较类排序：不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也称为线性时间非比较类排序。
     */

    //1冒泡排序  O(n^2)   O(1)

    /**
     * 每一轮循环 将 第一个元素  上升到”最上面“  -----通过比较
     比较相邻的元素，如果第一个比第二个大，就交换它们两个；
     对每一对相邻元素作同样的比价，从开始第一对到结尾的最后一对，这样在最后的元素就是最大的数；
     针对所有的元素重复以上的步骤，除了数组最后已经排好序的数组；
     重复步骤1~3，直到排序完成。
     */
    public static void bubbleSort(int[] arr)
    {
        int len = arr.length;
        for(int i = 0;i<len-1;i++)
        {
            for(int j=0;j<len-i-1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //2选择排序 O(n^2)   O(1)
    /**
     * 每一轮循环 选出当前位置的 最小元素；位置（小->大）
     首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置；
     再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾；
     重复第2步，直到所有元素均排序完毕。
     */
    public static void selectionSort(int[] arr)
    {
        int len = arr.length;
        for(int i=0;i<len-1;i++)
        {
            int k =i; //记住i位置所要 座的人
            for(int j=i+1;j<len;j++)
            {
                if(arr[k]>arr[j])
                {
                    k=j;
                }
            }
            //替换k、i位置的元素
            int tmp = arr[i];
            arr[i] = arr[k];
            arr[k] = tmp;
        }
        System.out.println(Arrays.toString(arr));
    }
    //3、插入排序 O(n^2)  O(1)
    /**
     * 在第一轮循环中，将数组分为2部分， 左边为有序 ，右边第一个为待 插入元素
     首先从第一个元素开始，该元素被认为是有序的；
     取出下一个元素，在已经排序的元素序列中从后往前进行扫描；
     如果该已排好序的元素大于新元素，则将该元素移到下一位置；
     重复步骤3一直往前进行扫描比较，直到找到已排序的元素小于或者等于新元素的位置；
     将新元素插入到该位置后；
     重复步骤2~5。
     */
    public static void insertionSort(int[] arr)
    {
        int len = arr.length;
        for(int i = 1;i<len;i++)
        {
            int k = arr[i],j;
            for( j=i;j>0;j--)
            {
                if(k<arr[j-1])
                {
                    arr[j] = arr[j-1];
                }
                else {break;}
            }
            arr[j]=k;
        }
        System.out.println(Arrays.toString(arr));
    }


    //4、希尔排序是基于插入排序的一种算法.希尔排序（插入排序进阶） 。因为以每一轮增量排序后，数组整体都更加趋于有序    O(Nlog2N)    O（1）
    /**
     * 选择一个增量序列{t1, t2, …, tk}；
     * 按增量序列个数k，对序列进行k趟排序；
     * 每趟排序，根据对应的增量t，将待排序列分割成若干长度为m的子序列，分别对各子表进行直接插入排序。   （因为插入排序：当右边是有序的，找到一个合适位置可以停止循环，而数组整体都更加趋于有序）
     * 仅增量因子为1时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     * 其中，增量gap=length/2，缩小增量继续以gap = gap/2的方式，这种增量选择我们可以用一个序列来表示，{n/2, (n/2)/2, …, 1}，称为增量序列。一般的增量序列都选择以上说明的这个，但不一定是最优的。
     */
    public static void shellSort(int[] arr)
    {
        int len = arr.length, tmp, j;
        for (int gap = len / 2; gap >= 1; gap = gap / 2)   //每次都将gap的值减半
        {
            for (int i = gap; i < len; i++)     //对于gap所分的每一个组
            {
                tmp = arr[i];
                for(j=i-gap;j>=0;j=j-gap)  //进行插入排序
                {
                    if(tmp<arr[j-1])
                    {
                        arr[j + gap] = arr[j];
                    }
                    else {break;}
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }


}
