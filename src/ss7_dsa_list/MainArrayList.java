package ss7_dsa_list;

public class MainArrayList {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();

//    a. them phan tu e vao cuoi
        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(30);
        myArrayList.add(40);
        myArrayList.add(50);
        myArrayList.add(60);
//b. toString()
        System.out.println("Array list first: " + myArrayList.toString());
//    c. add (them phan tu vao index
        myArrayList.add(2, 25);
        System.out.println("Array list second: " + myArrayList.toString());
//d.set (thay the phan tu tai index
        myArrayList.set(3, 35);
        System.out.println(myArrayList.toString());
// e. tra ve tai vi tri index
        int result = myArrayList.get(4);
        System.out.println(result);
//  f. indexOf ( lay vi tri index phan tu dau tien tim thay)
        int numberToFind = 30;
        int indexOfNumber = myArrayList.indexOf(numberToFind);
        if (indexOfNumber != -1) {
            System.out.println("Vi tri cua " + numberToFind + " la " + indexOfNumber);
        } else {
            System.out.println(" Khong tim thay phan tu");
        }

// g. lastIndexOf (int e ): lay vi tri index cua phan tu cuoi cung tim thay
        int lastIndexOf = myArrayList.lastIndexOf(numberToFind);
        if (lastIndexOf != -1) {
            System.out.println("Vi tri cua " + numberToFind + " la " + indexOfNumber);
        } else {
            System.out.println(" Khong tim thay phan tu");
        }
//h. remove (int index): xoa phan tu tai vi tri index
        myArrayList.remove(1);
        System.out.println(" Danh sach sau khi xoa phan tu: " + myArrayList.toString());
//i. Xoa tat ca cac phan tu
        myArrayList.remove(30);
        System.out.println("danh sach sau khi xoa:  " + myArrayList.toString());
    }

}
