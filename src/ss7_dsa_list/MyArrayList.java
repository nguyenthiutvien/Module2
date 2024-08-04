package ss7_dsa_list;

import java.util.concurrent.LinkedBlockingDeque;

public class MyArrayList {
    private  int capacity;
    private int[] arr;

    private int size;

    private  int[] emptyArray = {};
    public int size(){
        return  size;
    }
    public  MyArrayList(){
        arr = emptyArray;
    }
    public MyArrayList(int capacity){
        this.capacity = capacity;
        this.arr = new int[this.capacity];
    }
//   b. them vao cuoi
    public  void add(int element){
        if(arr == emptyArray){
            this.capacity = 10;
            this.arr = new int[this.capacity];
        }

        if (size == capacity){
            this.capacity *=1.5;
            if (size == capacity){
                capacity++;
            }

            int[] newArr = new int[this.capacity];

            for (int i = 0; i < size; i ++){
                newArr[i] =arr[i];
            }
            arr = newArr;
        }
        arr[size] = element;
        size++;
    }
    @Override
    public  String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for ( int i =0; i < size; i++){
            stringBuilder.append(arr[i]).append("\t");
        }
        return  stringBuilder.toString();
    }
//   c. Thêm vao vị tri index
    public void add(int i, int e){
        if (i <0 || i > size){
            System.out.println(" index is not in range");
            return;
        }
        if (size == capacity){
            this.capacity *=1.5;
            if (size == capacity){
                 capacity++;
            }
            int[] newArr = new int[this.capacity];

            for (int j = 0; j <  i; j++){
                newArr[j] = arr[i];
            }
            newArr[i] = e;

            for (int j = i; j < size; j++){
                newArr[j+1] = arr[j];
            }
            arr = newArr;
        } else {
            for (int j = size; j > i; j--){
                arr[j] = arr[j-1];
            }
            arr[i] = e;
        }
        size++;
    }

//    d. Thay the phan tu tai index
    public void set (int index, int e){
        if (index < 0 || index >=size){
            System.out.println("Index range out of");
            return;
        }
        arr[index] = e;
    }
//    e. get (int index): tra ve phan tu tai index
    public  Integer get (int index){
        if (index < 0 || index >= size){
            System.out.println("Index range out of");
        }
        return arr[index];
    }
//    f. lay vi tri index phan tu dau tien tim thay

    public  int indexOf(int e){
        for (int i = 0; i < size; i++){
            if (arr[i] == e){
                return i;
            }
        }
        return -1;
    }

//    g. lastIndexOf : lay vi tri index phan tu cuoi cung tim thay
    public int lastIndexOf (int e ){
        for (int i = size - 1; i >=0; i--){
            if (arr[i] == e){
                return i;
            }
    }
        return -1;
    }

//    remove (int index) xoa phan tu lai vi tri index
    public void remove (int index){
        if (index < 0 || index >=size){
            System.out.println(" Index range out of");
            return;
        }
        for (int i = index; i < size - 1; i++){
            arr[i] = arr[i+1];
        }
        size--;
    }
//    i. removeElement (int e): xoa tat ca cac phan tu
    public void removeElement(int e){
        int newIndex = 0;

        for (int i = 0; i < size; i++){
            if (arr[i] != e){
                arr[newIndex] = arr[i];
            }
        }
        size = newIndex;
    }
}
