package ex5;

class MergeSorter implements Runnable{
    private int[] arr;
    private int Size;
    private int left;
    private int right;
    private int[] resultArr ;

    public int[] getResultArr() {
        return resultArr;
    }

    public MergeSorter(int[] arr, int i, int j) {
        this.arr = arr;
        this.Size = arr.length;
        this.left  = i;
        this.right = j;
    }
    @Override
    public void run() {
        sort();
    }

    private void sort() {
        if(left==right && left >=0 )
        {
            this.resultArr = new int[]{arr[left]};
            return;
        }
        if(left>right) return;
        int rightLimit = this.left+(right-left)/2;

        MergeSorter mleft = new MergeSorter(arr,left,rightLimit);
        Thread t1 = new Thread(mleft);
        t1.start();
        int leftlimit = 1 + rightLimit;

        MergeSorter mright= new MergeSorter(arr,leftlimit,right);
        Thread t2 = new Thread(mright);
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        merge(mleft.resultArr,mright.resultArr);
    }

    private  int[] merge(int[] left, int[] right) {
        resultArr = new int[left.length+right.length];
        int r=0;
        int i=0;
        int j=0;
        while(i<left.length && j <right.length )
        {
            if( i<left.length && j<right.length && left[i] < right[j] )
                resultArr[r++] = left[i++];

            else if( j<right.length && i<left.length && right[j] < left[i])
                resultArr[r++] = right[j++];
        }
        while(i<left.length)
        {
            resultArr[r++] = left[i++];
        }
        while(j<right.length)
        {
            resultArr[r++] = right[j++];
        }
        return resultArr;
    }



}