import java.util.Arrays;

public class QuickSort
{
    public static void main(String[] args)
    {
        int[] arr = {11,44,23,67,88,65,34,48,9,12};
        quickSort(arr);
        System.out.println("\n最终排序结果："+ Arrays.toString(arr));
    }

    /**
     * 算法步驟:
     * 从序列中随机挑出一个元素，做为基准（pivot，这里选择序列的最左边元素作为基准）；
     * 重新排列序列，将所有比基准值小的元素摆放在基准前面，所有比基准值大的摆在基准的后面。该操作结束之后，该基准就处于数列的中间位置。这个操作称为分区（partition）；
     * "递归" 地把小于基准值元素的子序列和大于基准值元素的子序列进行上述操作即可。
     */

    //1.函数入口
    public static void quickSort(int[] arr)
    {
        sort(arr, 0, arr.length - 1);
    }


    private static void sort(int[] arr, int left, int right)
    {
        if (left < right) {
            int pivotIdx = partition(arr, left, right);
            sort(arr, 0, pivotIdx - 1);
            sort(arr, pivotIdx + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right)
    {
        int idx = left + 1;
        for (int i = idx; i <= right; i++)
        {
            if (arr[left] > arr[i]) {
                swap(arr, i, idx++);
            }
        }
        swap(arr, left, idx - 1);
        return idx - 1;
    }

    private static void swap(int[] arr, int idx1, int idx2) //交换函数
    {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}
