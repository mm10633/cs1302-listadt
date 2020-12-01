package cs1302.list;

import cs1302.listadt.StringList;

import cs1302.list.ListParent;

/**
 *This is a linkedList imprelmentation of the ArrayList class.
 *
 */


public class LinkedStringList extends ListParent {

    StringList.Node head;

    /**
     *Constucts a Blank node object.
     *
     */

    public LinkedStringList() {
        head = new StringList.Node();
    }

    /**
     *Constructs a node object with the contents of a given string.
     *@param str This is the string passed in
     */

    public LinkedStringList(String str) {
        head = new StringList.Node("str");
    }

    /**
     *Constructs a node with given content and next values.
     *@param str This is the specified string
     *@param next This is the specified next node
     */

    public LinkedStringList(String str, StringList.Node next) {
        head = new StringList.Node("str", next);
    }

    /**
     *Returns the size of the linkedList.
     *@return int returns the an int of the size of the array
     */

    public int size() {
        int count = 1;
        if (head.getStr() == null && head.getNext() == null) {
            return 0;
        }
        StringList.Node tempNode = head;
        while (tempNode.getNext() != null) {
            tempNode = tempNode.getNext();
            count++;
        }
        return count;
    }


    /**
     *This returns the string contents of a specific index.
     *@param index Returns the string in the specified position
     *@return String Thsi returns the string at a given index
     */

    public String get(int index) {
        checkRange(index,size(),2);
        StringList.Node tempNode = head;
        for (int i = 0; i < index;i++) {
            tempNode = tempNode.getNext();
        }
        return tempNode.getStr();
    }

    /**
     *Adds a specified String to the end of the list.
     *@param  s This is the specified string
     *@return Boolean this
     */

    public boolean add(String s) {
        checkNullVoid(s);
        if (size() == 0) {
            head.setStr(s);
            return true;
        } else  if (size() == 1) {
            head.setNext(new StringList.Node(s));
            return true;
        }
        StringList.Node tempNode = head;
        for (int i = 0; i < size() - 1;i++) {
            tempNode = tempNode.getNext();
        }
        tempNode.setNext(new StringList.Node(s));
        return true;
    }

    /**
     *Adds a specific String at a specific point into the list.
     *@param index This is where the string is inserted
     *@param s This is the inserted string
     *@return boolean retruns true if the list is changed successfully
     */

    public boolean add(int index, String s) {
        checkNullVoid(s);
        checkRange(index, size(),1);
        StringList.Node tempNode = head;
        for (int i = 0; i < index - 1;i++) {
            tempNode = tempNode.getNext();
        }
        StringList.Node newString  = new Node(s);
        newString.setNext(tempNode.getNext());
        tempNode.setNext(newString);
        return true;
    }

    /**
     *Inserts a given list of strings into the list.
     *@param index This is the starting point of where the list will be added
     *@param s1 This is the list that will be added at the index
     *@return boolean This returns true if the list is add specifically
     */

    public boolean add(int index, StringList s1) {
        checkRange(index, size(), 1);
        StringList.Node tempNode = head;
        StringList.Node tempHead = new StringList.Node(s1.get(0));
        StringList.Node temptail = tempHead;
        for (int i = 0; i < index - 1;i++) {
            tempNode = tempNode.getNext();
        }
        for (int  i = 1; i < s1.size();i++) {
            temptail.setNext(new StringList.Node(s1.get(i)));
            temptail = temptail.getNext();
        }
        temptail.setNext(tempNode.getNext());
        tempNode.setNext(tempHead);
        return true;
    }

    /**
     *Adds a specified stringList to the end of the given list.
     *@param  s1 This is the specidied list to be added
     *@return returns true if the action occurs
     */

    public boolean add(StringList s1) {
        StringList.Node tempNode = head;
        for (int i = 0; i < size() - 1;i++) {
            tempNode = tempNode.getNext();
        }
        for (int i = 0; i < s1.size();i++) {
            tempNode.setNext(new StringList.Node(s1.get(i)));
            tempNode = tempNode.getNext();
        }
        return true;
    }

    /**
     *Clears the array of all elements.
     */

    public void clear() {
        int listsize = size();
        for (int i = 0; i < listsize;i++) {
            remove(0);


        }

    }

    /**
     *Creates a new, distinct list with no duplicates.
     *@return StringList without any duplicates
     */

    public StringList distinct() {
        StringList disList = new LinkedStringList();
        for (int i = 0; i < size();i++) {
            if (!disList.contains(get(i))) {
                disList.add(get(i));
            }
        }
        return disList;

    }

    /**
     *Checks to see if the array is empty.
     *@return boolean Returns true if the array contains no elements
     */

    public boolean isEmpty() {
        if (head.getNext() == null) {
            return true;
        }
        return false;
    }

    /**
     *Removes the string at a specified position in the list.
     *@param  index This is the parameter that is to be removed
     *@return Returns the string that is to be replaced
     */

    public String remove(int index) {
        checkRange(index, size(), 2);
        StringList.Node tempNode = head;
        String removed = "";
        if (index == size() - 1) {
            tempNode.setNext(null);
            removed = tempNode.getStr();
            tempNode.setStr(null);
            return removed;
        }

        for (int i = 0; i < index - 1;i++) {
            tempNode = tempNode.getNext();
        }
        removed = tempNode.getNext().getStr();
        tempNode.setNext(tempNode.getNext().getNext());
        return removed;

    }

    /**
     *Sets the string in a specified index to the give one.
     *@param index This is where the string will be set
     *@param s This is the string that will be added at index
     *@return Returns the string that is replaced
     */

    public String set(int index, String s) {
        checkNullVoid(s);
        checkRange(index, size(), 2);
        StringList.Node tempNode = head;
        String set = "";
        for (int i = 0; i < index;i++) {
            tempNode = tempNode.getNext();
        }
        set = tempNode.getStr();
        tempNode.setStr(s);
        return set;
    }

    /**
     *Returns the list in array form.
     *@return String[] Returns an array repersentation of the list
     */

    public String[] toArray() {
        String[] listArray = new String[size()];
        for (int i = 0; i < size();i++) {
            listArray[i] = get(i);
        }
        return listArray;
    }


    /**
     *reverse all elements in the given list.
     *@return StringList returns a reversed stringlist
     */

    public StringList reverse() {
        StringList reverse = new LinkedStringList();
        for (int i = size() - 1; i >= 0;i--) {
            reverse.add(get(i));
        }
        return reverse;
    }

    /**
     *Builds a new stringlist consisting of the current list between two indices.
     *@param  fromIndex This is the starting index
     *@param  toIndex This is the ending index
     *@return StringList This is the returned list between the given indicies
     */

    public StringList splice(int fromIndex, int toIndex) {

        StringList splice = new LinkedStringList();
        if ( fromIndex < 0 || toIndex > size() || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int  i = fromIndex; i <=  toIndex;i++) {
            splice.add(get(i));
        }
        return splice;
    }

}
