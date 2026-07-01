package org.example._20260630;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * 常见排序算法汇总
 *
 * 本文件汇总 10 种经典排序算法，并在每个算法上方给出解题思路与时间复杂度分析。
 *
 * 复杂度总结（对 n 个元素）：
 * ┌──────────┬──────────┬──────────┬──────────┬─────────┬──────────┐
 * │  算法     │  最优    │  平均    │  最坏    │  空间   │  稳定性  │
 * ├──────────┼──────────┼──────────┼──────────┼─────────┼──────────┤
 * │ 冒泡排序  │ O(n)     │ O(n^2)   │ O(n^2)   │ O(1)    │ 稳定     │
 * │ 选择排序  │ O(n^2)   │ O(n^2)   │ O(n^2)   │ O(1)    │ 不稳定   │
 * │ 插入排序  │ O(n)     │ O(n^2)   │ O(n^2)   │ O(1)    │ 稳定     │
 * │ 希尔排序  │ O(n log n)│ 依赖增量│ O(n^(3/2))│ O(1)    │ 不稳定   │
 * │ 归并排序  │ O(n log n)│ O(n log n)│ O(n log n)│ O(n)   │ 稳定     │
 * │ 快速排序  │ O(n log n)│ O(n log n)│ O(n^2)  │ O(log n)│ 不稳定   │
 * │ 堆排序    │ O(n log n)│ O(n log n)│ O(n log n)│ O(1)   │ 不稳定   │
 * │ 计数排序  │ O(n+k)   │ O(n+k)   │ O(n+k)   │ O(n+k)  │ 稳定     │
 * │ 桶排序    │ O(n+k)   │ O(n+k)   │ O(n^2)   │ O(n+k)  │ 稳定     │
 * │ 基数排序  │ O(d*(n+k))│ O(d*(n+k))│ O(d*(n+k))│ O(n+k)│ 稳定     │
 * └──────────┴──────────┴──────────┴──────────┴─────────┴──────────┘
 *
 * 其中 k 表示桶 / 计数区间大小；d 表示数字最大位数。
 */
public final class SortAlgorithms {

	private SortAlgorithms() {
	}

	/* ===================== 工具方法 ===================== */

	private static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	private static boolean isSorted(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] > arr[i]) {
				return false;
			}
		}
		return true;
	}

	private static int[] cloneArray(int[] src) {
		return src.clone();
	}

	/* ===================== 1. 冒泡排序 =====================
	 *
	 * 解题思路：
	 *   从头到尾两两比较相邻元素，若前者大于后者则交换；每一轮结束后最大值"浮"到末尾。
	 *   使用 swapped 标志在某轮无交换时提前终止，以获得最优 O(n)。
	 *
	 * 复杂度推导：
	 *   最坏/平均共 n-1 轮，第 i 轮比较 n-i 次，Σ(n-i) = n(n-1)/2 ≈ n^2/2 → O(n^2)。
	 *   最好情况一轮遍历无交换 → O(n)。空间 O(1)，稳定。
	 */
	public static void bubbleSort(int[] arr) {
		if (arr == null || arr.length <= 1)
			return;
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			boolean swapped = false;
			for (int j = 0; j < n - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
					swapped = true;
				}
			}
			if (!swapped)
				break;
		}
	}

	/* ===================== 2. 选择排序 =====================
	 *
	 * 解题思路：
	 *   每轮在未排序区中寻找最小值下标，与未排序区首元素交换；已排序区逐渐扩大。
	 *
	 * 复杂度推导：
	 *   无论数据分布如何，都需要 n-1 轮选择，每轮线性扫描 → O(n^2)。
	 *   交换次数至多 n-1，故常数时间可忽略。空间 O(1)，不稳定（跨越交换）。
	 */
	public static void selectionSort(int[] arr) {
		if (arr == null || arr.length <= 1)
			return;
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIdx])
					minIdx = j;
			}
			if (minIdx != i)
				swap(arr, i, minIdx);
		}
	}

	/* ===================== 3. 插入排序 =====================
	 *
	 * 解题思路：
	 *   将数组视为"已排序前缀 + 未排序后缀"；每次取出后缀首元素，
	 *   向前扫描已排序区并把大于它的元素后移一位，最终插入到正确位置。
	 *
	 * 复杂度推导：
	 *   最坏/平均时第 i 个元素平均向前移动 i/2 步，Σi ≈ n^2/2 → O(n^2)。
	 *   已排序数组时内层循环立即终止，总耗时 O(n)。空间 O(1)，稳定。
	 */
	public static void insertionSort(int[] arr) {
		if (arr == null || arr.length <= 1)
			return;
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int cur = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > cur) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = cur;
		}
	}

	/* ===================== 4. 希尔排序 =====================
	 *
	 * 解题思路：
	 *   插入排序的改进：先按较大步长 gap 对子序列做插入排序（使数组"基本有序"），
	 *   再逐步缩小 gap，直至 gap=1 完成最终排序。
	 *
	 * 复杂度推导：
	 *   与增量序列相关。常见的 n/2^k 序列最坏 O(n^2)；Hibbard 序列可到 O(n^(3/2))；
	 *   理论上最好可达 O(n log n)。空间 O(1)，不稳定（同 gap 组内可能跨越交换）。
	 */
	public static void shellSort(int[] arr) {
		if (arr == null || arr.length <= 1)
			return;
		int n = arr.length;
		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i++) {
				int cur = arr[i];
				int j = i;
				while (j - gap >= 0 && arr[j - gap] > cur) {
					arr[j] = arr[j - gap];
					j -= gap;
				}
				arr[j] = cur;
			}
		}
	}

	/* ===================== 5. 归并排序 =====================
	 *
	 * 解题思路（分治 Divide & Conquer）：
	 *   1) 分割：将数组从中间二分，递归地对左右两半排序；
	 *   2) 合并：将两个已排序的子数组合并成一个有序数组（双指针 + 辅助数组）。
	 *
	 * 复杂度推导：
	 *   递归深度为 log n（每次二分），每层合并总工作量为 O(n) →
	 *   T(n) = 2*T(n/2) + O(n)，由主定理得 T(n) = O(n log n)，三种情况一致。
	 *   空间 O(n)（辅助数组），稳定（合并时相等元素取左子数组优先）。
	 */
	public static void mergeSort(int[] arr) {
		if (arr == null || arr.length <= 1)
			return;
		int[] tmp = new int[arr.length];
		mergeSort(arr, 0, arr.length - 1, tmp);
	}

	private static void mergeSort(int[] arr, int l, int r, int[] tmp) {
		if (l >= r)
			return;
		int mid = (l + r) >>> 1;
		mergeSort(arr, l, mid, tmp);
		mergeSort(arr, mid + 1, r, tmp);
		if (arr[mid] <= arr[mid + 1])
			return;
		merge(arr, l, mid, r, tmp);
	}

	private static void merge(int[] arr, int l, int mid, int r, int[] tmp) {
		System.arraycopy(arr, l, tmp, l, r - l + 1);
		int i = l, j = mid + 1;
		for (int k = l; k <= r; k++) {
			if (i > mid) {
				arr[k] = tmp[j++];
			} else if (j > r) {
				arr[k] = tmp[i++];
			} else if (tmp[i] <= tmp[j]) {
				arr[k] = tmp[i++];
			} else {
				arr[k] = tmp[j++];
			}
		}
	}

	/* ===================== 6. 快速排序 =====================
	 *
	 * 解题思路（分治）：
	 *   1) 选取一个基准 pivot（本文使用三数取中 + 随机化，降低最坏情况概率）；
	 *   2) 分区：把小于 pivot 的元素放左，大于 pivot 的放右，相等的放中间；
	 *   3) 递归处理左右两个子区间。
	 *
	 * 复杂度推导：
	 *   平均：每次划分较均衡，递归深度 O(log n)，每层 O(n) → O(n log n)。
	 *   最坏：每次仅减少一个元素（例如已排序 + 固定基准），深度 O(n) → O(n^2)。
	 *   通过随机化 / 三数取中可将最坏情况概率降至极低。空间 O(log n)（递归栈），不稳定。
	 */
	public static void quickSort(int[] arr) {
		if (arr == null || arr.length <= 1)
			return;
		quickSort(arr, 0, arr.length - 1);
	}

	private static final Random RAND = new Random();

	private static void quickSort(int[] arr, int l, int r) {
		if (l >= r)
			return;
		if (r - l + 1 <= 16) {
			insertionSortRange(arr, l, r);
			return;
		}
		int pivot = arr[l + RAND.nextInt(r - l + 1)];
		int i = l, lt = l, gt = r;
		while (i <= gt) {
			if (arr[i] < pivot) {
				swap(arr, lt++, i++);
			} else if (arr[i] > pivot) {
				swap(arr, i, gt--);
			} else {
				i++;
			}
		}
		quickSort(arr, l, lt - 1);
		quickSort(arr, gt + 1, r);
	}

	private static void insertionSortRange(int[] arr, int l, int r) {
		for (int i = l + 1; i <= r; i++) {
			int cur = arr[i];
			int j = i - 1;
			while (j >= l && arr[j] > cur) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = cur;
		}
	}

	/* ===================== 7. 堆排序 =====================
	 *
	 * 解题思路：
	 *   1) 建堆：将数组视为完全二叉树，从最后一个非叶子节点向前做"下沉"，构造最大堆。
	 *   2) 排序：不断将堆顶元素与末尾元素交换（最大值归位），然后缩小堆范围并维护堆性质。
	 *
	 * 复杂度推导：
	 *   建堆：自底向上下沉，总开销 Σ O(log(n/2^i)) * 2^i ≈ O(n)；
	 *   排序：n-1 次交换 + 每次 O(log n) 的下沉 → O(n log n)。
	 *   总体 O(n log n)；空间 O(1)，不稳定。
	 */
	public static void heapSort(int[] arr) {
		if (arr == null || arr.length <= 1)
			return;
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			sink(arr, i, n);
		}
		for (int size = n - 1; size > 0; size--) {
			swap(arr, 0, size);
			sink(arr, 0, size);
		}
	}

	private static void sink(int[] arr, int k, int size) {
		while (2 * k + 1 < size) {
			int j = 2 * k + 1;
			if (j + 1 < size && arr[j + 1] > arr[j])
				j++;
			if (arr[k] >= arr[j])
				break;
			swap(arr, k, j);
			k = j;
		}
	}

	/* ===================== 8. 计数排序 =====================
	 *
	 * 解题思路：
	 *   假设元素取值范围较小（max - min = k）。统计每个值出现的次数到 count 数组，
	 *   对 count 做前缀和即可得到每个值在结果中的最终位置；逆序回填可保证稳定性。
	 *
	 * 复杂度推导：
	 *   扫描 O(n) + 桶初始化 O(k) + 前缀和 O(k) + 回填 O(n) → 总体 O(n + k)。
	 *   当 k = O(n) 时线性；k 过大则不适用。空间 O(n + k)，稳定。
	 */
	public static void countingSort(int[] arr) {
		if (arr == null || arr.length <= 1)
			return;
		int min = arr[0], max = arr[0];
		for (int v : arr) {
			if (v < min)
				min = v;
			if (v > max)
				max = v;
		}
		int range = max - min + 1;
		int[] count = new int[range];
		for (int v : arr)
			count[v - min]++;
		for (int i = 1; i < range; i++)
			count[i] += count[i - 1];
		int[] out = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			out[--count[arr[i] - min]] = arr[i];
		}
		System.arraycopy(out, 0, arr, 0, arr.length);
	}

	/* ===================== 9. 桶排序 =====================
	 *
	 * 解题思路：
	 *   将数据按大小分配到若干"桶"中（如区间 [min + i*step, min + (i+1)*step)），
	 *   对每个桶内部进行排序（插入/快速），再按桶序拼接。
	 *
	 * 复杂度推导：
	 *   平均情况下桶内数据均匀分布，每桶大小 n/k，总代价 ≈ n + k * O((n/k) log (n/k))
	 *   = O(n + n log(n/k))。当 k ≈ n 时接近 O(n)；最坏数据集中于单桶 → O(n^2)。
	 *   空间 O(n + k)，稳定（桶内使用稳定排序）。
	 */
	public static void bucketSort(int[] arr) {
		if (arr == null || arr.length <= 1)
			return;
		int min = arr[0], max = arr[0];
		for (int v : arr) {
			if (v < min)
				min = v;
			if (v > max)
				max = v;
		}
		if (min == max)
			return;
		int bucketCount = Math.min(arr.length, 1024);
		long span = (long) max - min + 1;
		int step = (int) Math.max(1, (span + bucketCount - 1) / bucketCount);
		ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(bucketCount);
		for (int i = 0; i < bucketCount; i++)
			buckets.add(new ArrayList<>());
		for (int v : arr) {
			int idx = Math.min((v - min) / step, bucketCount - 1);
			buckets.get(idx).add(v);
		}
		int p = 0;
		for (ArrayList<Integer> b : buckets) {
			if (b.isEmpty())
				continue;
			Collections.sort(b);
			for (int v : b)
				arr[p++] = v;
		}
	}

	/* ===================== 10. 基数排序 =====================
	 *
	 * 解题思路（最低位优先 LSD）：
	 *   按从低到高的每一位数字（十进制 0~9，即基数 radix=10）进行一轮"桶排序"。
	 *   因为每轮使用稳定排序，较低位的顺序在较高位相同时得以保留。
	 *   对负数支持：将所有数平移为非负，最后再平移回去。
	 *
	 * 复杂度推导：
	 *   共 d 轮（d = 数字最大位数），每轮 O(n + k)，其中 k = radix（常取 10），
	 *   故总复杂度 O(d * (n + k)) ≈ O(d * n)。当 d 为常数时线性。
	 *   空间 O(n + k)，稳定。
	 */
	public static void radixSort(int[] arr) {
		if (arr == null || arr.length <= 1)
			return;
		int min = arr[0], max = arr[0];
		for (int v : arr) {
			if (v < min)
				min = v;
			if (v > max)
				max = v;
		}
		long[] a = new long[arr.length];
		for (int i = 0; i < arr.length; i++)
			a[i] = (long) arr[i] - min;
		long m = (long) max - min;
		for (long exp = 1; m / exp > 0; exp *= 10) {
			countingSortByDigit(a, exp);
		}
		for (int i = 0; i < arr.length; i++)
			arr[i] = (int) (a[i] + min);
	}

	private static void countingSortByDigit(long[] a, long exp) {
		int n = a.length;
		long[] out = new long[n];
		int[] count = new int[10];
		for (long v : a)
			count[(int) ((v / exp) % 10)]++;
		for (int i = 1; i < 10; i++)
			count[i] += count[i - 1];
		for (int i = n - 1; i >= 0; i--) {
			out[--count[(int) ((a[i] / exp) % 10)]] = a[i];
		}
		System.arraycopy(out, 0, a, 0, n);
	}

	/* ===================== 测试入口 ===================== */

	public static void main(String[] args) {
		int[] base = randomArray(200, -500, 500);

		System.out.println("原数组前 20 个：");
		printHead(base, 20);

		int[] a1 = cloneArray(base);
		bubbleSort(a1);
		verify("冒泡排序", a1);
		int[] a2 = cloneArray(base);
		selectionSort(a2);
		verify("选择排序", a2);
		int[] a3 = cloneArray(base);
		insertionSort(a3);
		verify("插入排序", a3);
		int[] a4 = cloneArray(base);
		shellSort(a4);
		verify("希尔排序", a4);
		int[] a5 = cloneArray(base);
		mergeSort(a5);
		verify("归并排序", a5);
		int[] a6 = cloneArray(base);
		quickSort(a6);
		verify("快速排序", a6);
		int[] a7 = cloneArray(base);
		heapSort(a7);
		verify("堆排序", a7);
		int[] a8 = cloneArray(base);
		countingSort(a8);
		verify("计数排序", a8);
		int[] a9 = cloneArray(base);
		bucketSort(a9);
		verify("桶排序", a9);
		int[] a10 = cloneArray(base);
		radixSort(a10);
		verify("基数排序", a10);

		int[] big = randomArray(100_000, -1_000_000, 1_000_000);
		bench("归并排序", big, SortAlgorithms::mergeSort);
		bench("快速排序", big, SortAlgorithms::quickSort);
		bench("堆排序", big, SortAlgorithms::heapSort);
		bench("基数排序", big, SortAlgorithms::radixSort);

		System.out.println("所有测试完成。");
	}

	private static int[] randomArray(int size, int lo, int hi) {
		int[] arr = new int[size];
		Random r = new Random(20260626L);
		for (int i = 0; i < size; i++)
			arr[i] = lo + r.nextInt(hi - lo + 1);
		return arr;
	}

	private static void printHead(int[] arr, int count) {
		int n = Math.min(count, arr.length);
		int[] head = new int[n];
		System.arraycopy(arr, 0, head, 0, n);
		System.out.println(Arrays.toString(head));
	}

	private static void verify(String name, int[] arr) {
		boolean ok = isSorted(arr);
		System.out.printf("[%s] %s%n", name, ok ? "OK" : "FAIL");
		if (!ok) {
			System.out.println("前 20 个: " + Arrays
					.toString(Arrays.copyOf(arr, Math.min(20, arr.length))));
		}
	}

	private static void bench(String name, int[] src,
			java.util.function.Consumer<int[]> fn) {
		int[] arr = cloneArray(src);
		long s = System.nanoTime();
		fn.accept(arr);
		long e = System.nanoTime();
		boolean ok = isSorted(arr);
		System.out.printf("[%s] %s 耗时 %.2f ms%n", name, ok ? "OK" : "FAIL",
				(e - s) / 1e6);
	}

	public static void quickMain(int[] arr) {
		doQuick(arr, 0, arr.length - 1);
	}

	public static void doQuick(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		int pivotIndex = partition(arr, left, right);
		doQuick(arr, left, pivotIndex - 1);
		doQuick(arr, pivotIndex + 1, right);
	}

	public static int partition(int[] arr, int left, int right) {
		int randomIndex = left + new Random().nextInt(right - left + 1);
		int pivot = arr[randomIndex];
		swap(arr, randomIndex, right);
		int i = left - 1;
		for (int j = left; j < right; j++) {
			if (arr[j] <= pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, right);
		return i + 1;
	}


	public static void mergeMain(int[] arr) {
		//基于mid，分成左右两个数组，递归处理、合并
		doMergeSort(arr, 0, arr.length - 1);
	}

	public static void doMergeSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		int mid = left + (right - left) / 2;
		doMergeSort(arr, left, mid);
		doMergeSort(arr, mid + 1, right);
		doMerge(arr, left, mid, right);
	}

	public static void doMerge(int[] arr, int left, int mid, int right) {
		int i = left;
		int j = mid + 1;
		int[] temp = new int[right - left + 1];
		int tempIndex = 0;
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[tempIndex] = arr[i];
				i++;
			} else {
				temp[tempIndex] = arr[j];
				j++;
			}
			tempIndex++;
		}
		while (i <= mid) {
			temp[tempIndex] = arr[i];
			i++;
			tempIndex++;
		}
		while (j <= right) {
			temp[tempIndex] = arr[j];
			j++;
			tempIndex++;
		}
		System.arraycopy(temp, 0, arr, left, right - left + 1);
	}

}