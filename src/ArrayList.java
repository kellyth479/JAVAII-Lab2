import java.util.Arrays;

public class ArrayList<E> {

    private int size = 0;
    private static final int startingSize = 5;
    private Object values[];

    //Construct an empty ArrayList object.
    public ArrayList(){

        values = new Object[startingSize];

    }

    //Return the size (number of items) in this ArrayList.
    public int size(){
        return this.size;
    }


    //Return true if this ArrayList has no items. (This is the same as the
    //size equal to zero.) Return false if the size is greater than zero.
    public boolean isEmpty(){
        if(this.size > 0){
            return false;
        }
        return true;
    }


    //Add the given element, value, to the end of the list.
    public void add(E value){
        if (this.size == values.length) {
            expandList();
        }
        values[this.size] = value;
        this.size += 1;
    }


    //Add the given element, value, to the list at the given index. After
    //this operation is complete, get(index) will return value. This
    //operation is only valid for 0 <= index <= size().
    public void add(int index, E value){

        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Attempted to add to index = " + index + " which is out of bounds");
        }
        if (this.size == values.length) {
            expandList();
        }
        values[index] = value;
    }


    //Return the element of the list at the given index. This operation is only
    //valid for 0 <= index < size(). This operation does not modify
    //the list.
    public E get(int index){

        if (0 > index || index >= this.size) {
            throw new IndexOutOfBoundsException("Attempted to get index = " + index + " which is out of bounds");
        }

        return (E) values[index];
    }


    //Removes the first occurrence of the specified element from this list, if it
    //is present.
    public E remove(E value){

        Object tempValue = null;

        for(int temp = 0;temp < this.size;temp++){
            if(values[temp] == value){
                tempValue = values[temp];
                values[temp] = null;
                reIndex(temp);
                return (E) tempValue;
            }
        }

        return null;
    }


    //Remove and return the element with the given index from the list.
    //This operation is only valid for 0 <= index < size(). After this
    //operation, all elements that had an index greater than index (as
    //determined by get()) will have their index reduced by one.
    public E remove(int index){
        if (0 > index || index >= this.size) {
            throw new IndexOutOfBoundsException("Attempted to remove index = " + index + " which is out of bounds");
        }
        Object tempValue = null;
        tempValue = values[index];
        reIndex(index);
        return (E) tempValue;

    }


    //Removes all the elements from this list.
    public void clear(){
        for (int cleaner = 0;cleaner < this.size; cleaner ++){
            values[cleaner] = null;
        }
        this.size = 0;
    }

    private void expandList(){
        int expand = values.length + 1;
        values = Arrays.copyOf(values, expand);
    }

    private void reIndex(int index){
        this.size -= 1;
        while (index < this.size){
//            System.out.println(index+1);
//            System.out.println(values[index+1]);
            values[index] = values[index+1];
            values[index+1] = null;
            index+=1;
        }
    }

    public void printMe(){
        for(int temp = 0;temp < this.size; temp++){
            System.out.println("INDEX " + temp + " : " +values[temp]);
        }
    }

    public static void main(String[] args){

        //test1 add one element and get it
        System.out.println("###############################");
        System.out.println("TEST 1");
        System.out.println("###############################");
        ArrayList test1 = new ArrayList();
        test1.add("face");
        System.out.println(test1.get(0));
        System.out.println("SIZE: " + test1.size);
        System.out.println("###############################");

        //test2 add three elements remove via index = 0 (TOM)
        System.out.println();
        System.out.println("###############################");
        System.out.println("TEST 2 - TOM");
        System.out.println("###############################");
        ArrayList test2 = new ArrayList();
        test2.add("TOM");
        test2.add("FRED");
        test2.add("FRANK");
        test2.printMe();
        System.out.println("REMOVE: " + test2.remove(0));
        test2.printMe();
        System.out.println("SIZE: " + test2.size);
        System.out.println("###############################");

        //test3 remove via index = 1 (FRED)
        System.out.println();
        System.out.println("###############################");
        System.out.println("TEST 3 - FRED");
        System.out.println("###############################");
        ArrayList test3 = new ArrayList();
        test3.add("TOM");
        test3.add("FRED");
        test3.add("FRANK");
        test3.printMe();
        System.out.println("REMOVE: " + test3.remove(1));
        test3.printMe();
        System.out.println("SIZE: " + test3.size);
        System.out.println("###############################");

        //test4 remove via index = 2 (FRANK)
        System.out.println();
        System.out.println("###############################");
        System.out.println("TEST 4 - FRANK");
        System.out.println("###############################");
        ArrayList test4 = new ArrayList();
        test4.add("TOM");
        test4.add("FRED");
        test4.add("FRANK");
        System.out.println("REMOVE: " + test4.remove(2));
        test4.printMe();
        System.out.println("SIZE: " + test4.size);
        System.out.println("###############################");


        //test5 add 8 elements, test the default size
        System.out.println();
        System.out.println("###############################");
        System.out.println("TEST 5");
        System.out.println("###############################");
        ArrayList test5 = new ArrayList();
        test5.add("TOM");
        test5.add("FRED");
        test5.add("FRANK");
        test5.add("TEDDY");
        test5.add("BILLY");
        test5.add("DUDESMEN");
        test5.add("DANNY");
        test5.add("CRAIG");
        test5.printMe();
        System.out.println("SIZE: " + test5.size);
        System.out.println("###############################");

        //test 6 remove DUDESMEN via value
        System.out.println();
        System.out.println("###############################");
        System.out.println("TEST 6");
        System.out.println("###############################");
        ArrayList test6 = new ArrayList();
        test6.add("TOM");
        test6.add("FRED");
        test6.add("FRANK");
        test6.add("TEDDY");
        test6.add("BILLY");
        test6.add("DUDESMEN");
        test6.add("DANNY");
        test6.add("CRAIG");
        test6.remove("DUDESMEN");
        test6.printMe();
        System.out.println("SIZE: " + test6.size);
        System.out.println("###############################");


        //test 7 remove DUDESMEN via index
        System.out.println();
        System.out.println("###############################");
        System.out.println("TEST 7");
        System.out.println("###############################");
        ArrayList test7 = new ArrayList();
        test7.add("TOM");
        test7.add("FRED");
        test7.add("FRANK");
        test7.add("TEDDY");
        test7.add("BILLY");
        test7.add("DUDESMEN");
        test7.add("DANNY");
        test7.add("CRAIG");
        Object returnTemp = test7.remove(5);
        System.out.println("*******************************");
        System.out.println(returnTemp);
        System.out.println("*******************************");
        test7.printMe();
        System.out.println("SIZE: " + test7.size);
        System.out.print("Value at last Index(6): ");
        System.out.println(test7.get(6));
        System.out.println("###############################");

        //Test 8 Clear
        System.out.println();
        System.out.println("###############################");
        System.out.println("TEST 8");
        System.out.println("###############################");
        ArrayList test8 = new ArrayList();
        test8.add("TOM");
        test8.add("FRED");
        test8.add("FRANK");
        test8.add("TEDDY");
        test8.add("BILLY");
        test8.add("DUDESMEN");
        test8.add("DANNY");
        test8.add("CRAIG");
        test8.printMe();
        System.out.println("*******************************");
        test8.clear();
        System.out.print("After Clear: ");
        test8.printMe();
        System.out.println("SIZE: " + test8.size);
        System.out.println("###############################");

        //Test 9 Add at Index = 7
        System.out.println();
        System.out.println("###############################");
        System.out.println("TEST 9");
        System.out.println("###############################");
        ArrayList test9 = new ArrayList();
        test9.add("TOM");
        test9.add("FRED");
        test9.add("FRANK");
        test9.add("TEDDY");
        test9.add("BILLY");
        test9.add("DUDESMEN");
        test9.add("DANNY");
        test9.add("CRAIG");
        test9.printMe();
        System.out.println("SIZE: " + test9.size);
        System.out.println("*******************************");
        test9.add(7, "REPLACED");
        test9.printMe();
        System.out.println("SIZE: " + test9.size);
        System.out.println("###############################");

        //Test 10 Add at Index = 7
        System.out.println();
        System.out.println("###############################");
        System.out.println("TEST 10");
        System.out.println("###############################");
        ArrayList test10 = new ArrayList();
        test10.add("TOM");
        test10.add("FRED");
        test10.add("FRANK");
        test10.add("TEDDY");
        test10.add("BILLY");
        test10.add("DUDESMEN");
        test10.add("DANNY");
        test10.add("CRAIG");
        test10.printMe();
        System.out.println("SIZE: " + test10.size);
        System.out.println("*******************************");
        test10.add(0, "REPLACED");
        test10.printMe();
        System.out.println("SIZE: " + test9.size);
        System.out.println("###############################");

        //Test 11 IsEmpty
        System.out.println();
        System.out.println("###############################");
        System.out.println("TEST 6");
        System.out.println("###############################");
        ArrayList test11 = new ArrayList();
        test11.add("TOM");
        test11.add("FRED");
        test11.add("FRANK");
        test11.add("TEDDY");
        test11.add("BILLY");
        test11.add("DUDESMEN");
        test11.add("DANNY");
        test11.add("CRAIG");
        test11.printMe();
        System.out.println("SIZE: " + test11.size);
        System.out.println("*******************************");
        System.out.println("IS EMPTY?");
        System.out.println(test11.isEmpty());
        System.out.println("*******************************");
        test11.printMe();
        System.out.println("SIZE: " + test11.size);
        System.out.println("###############################");

        //Test 12 IsEmpty
        System.out.println();
        System.out.println("###############################");
        System.out.println("TEST 6");
        System.out.println("###############################");
        ArrayList test12 = new ArrayList();
        test12.add("TOM");
        test12.add("FRED");
        test12.add("FRANK");
        test12.add("TEDDY");
        test12.add("BILLY");
        test12.add("DUDESMEN");
        test12.add("DANNY");
        test12.add("CRAIG");
        test12.printMe();
        System.out.println("SIZE: " + test12.size);
        System.out.println("*******************************");
        System.out.print("IS EMPTY? - ");
        System.out.println(test12.isEmpty());
        System.out.println("*******************************");
        test12.printMe();
        System.out.println("SIZE: " + test12.size);
        System.out.println("*******************************");
        System.out.println("CLEARING");
        test12.clear();
        System.out.print("IS EMPTY? - ");
        System.out.println(test12.isEmpty());
        test12.printMe();
        System.out.println("SIZE: " + test12.size);
        System.out.println("###############################");


        //Out of Bounds Testing 1 at a time


        //Out Of Bounds test1 remove via index = 3 (index out of bounds)
//        System.out.println("###############################");
//        System.out.println("Out Of Bounds test1");
//        System.out.println("###############################");
//        ArrayList Boundstest1 = new ArrayList();
//        Boundstest1.add("TOM");
//        Boundstest1.add("FRED");
//        Boundstest1.add("FRANK");
//        Boundstest1.printMe();
//        System.out.println(Boundstest1.remove(3));
//        System.out.println("SIZE: " + Boundstest1.size);
//        System.out.println("###############################");


        //Out Of Bounds test2 remove via index = -3 (index out of bounds)
//        System.out.println("###############################");
//        System.out.println("Out Of Bounds test1");
//        System.out.println("###############################");
//        ArrayList Boundstest2 = new ArrayList();
//        Boundstest2.add("TOM");
//        Boundstest2.add("FRED");
//        Boundstest2.add("FRANK");
//        Boundstest2.printMe();
//        System.out.println(Boundstest2.remove(-3));
//        System.out.println("SIZE: " + Boundstest2.size);
//        System.out.println("###############################");



        //Out Of Bounds test3 remove via index = -3 (index out of bounds)
//        System.out.println("###############################");
//        System.out.println("Out Of Bounds test1");
//        System.out.println("###############################");
//        ArrayList Boundstest3 = new ArrayList();
//        Boundstest3.add("TOM");
//        Boundstest3.add("FRED");
//        Boundstest3.add("FRANK");
//        Boundstest3.printMe();
//        Boundstest3.add(-1, "FACE");
//        System.out.println(Boundstest3.remove(-3));
//        System.out.println("SIZE: " + Boundstest3.size);
//        System.out.println("###############################");




    }

}






