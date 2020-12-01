package cs1302.list;

import cs1302.listadt.StringList;

import cs1302.list.ListParent;

/**
 *Represents a StringList implementation using an array.
 *
 */

public class ArrayStringList extends ListParent {

    String[] strArr;

    /**
     *This is a constructor that creates a new list with size 0.
     *
     *
     */

    public ArrayStringList() {
        strArr = new String[50];
    }

    /**
     *Secondary constructor that takes a StringList object and creates a deep copy.
     *
     *@param copyCat This is the list to be copied
     */

    public ArrayStringList(StringList copyCat) {
        strArr = new String[copyCat.size() + 20];
        for (int i = 0; i < copyCat.size();i++) {
            strArr[i] = copyCat.get(i);
        }
    }

    /**
     *Returns the number of elements in the given list.
     *
     *@return Returns the number of elements in a given String List
     */

    public int size() {
        int size = 0;
        for (int i = 0; i < strArr.length;i++) {
            if (strArr[i] != null) {
                size++;
            }
        }
        return size;
    }

    /**
     *Gets the string at a specified point in the String List.
     *
     *@param  index is the index of the desired string
     *@return Returns the string a pre-specified position in the String List
     */

    public String get(int index) {
        checkRange(index, size(),2);
        if (size() < index) {
            throw new IndexOutOfBoundsException();
        }
        return strArr[index];
    }

    /**
     *Adjusts the size of the array to handle larger lists.
     *@param amount This is the amount the array needs to incease by
     */

    public void arrAdj(int amount) {
        while ((strArr.length - size()) < amount) {
            String[] biggerArr = new String[strArr.length + 20];
            for (int i = 0; i < strArr.length;i++) {
                strArr[i] = biggerArr[i];
                strArr = biggerArr;
            }
        }
    }


    /**
     *Adds a specified string to the end of the String List.
     *@param s is the string you want to add to the end of the lsit
     *@return returns if the string was added successfully
     */

    public boolean add(String s) {
        checkNullVoid(s);
        arrAdj(1);
        strArr[size()] = s;
        if (s != null && s != "") {
            return false;
        }
        return true;
    }

    /**
     *Adds a specific string at a specific point in the list.
     *@param index index at which the given string will be added
     *@param s the String that will be inserted
     *@return boolean returns true if the list changed, false otherwise
     */

    public boolean add(int index, String s) {
        checkNullVoid(s);
        checkRange(index, size(), 1);
        arrAdj(1);
        for (int i = size(); i > index ;i--) {
            strArr[i] = strArr[i - 1];
        }
        strArr[index] = s;
        return true;
    }

    /**
     *Inserts a given list of stirngs into the String arrray.
     *@param index This is where the list will be inserted
     *@param s1 This is the given list of strings that will be inserted
     *@return boolean returns true if the list is changed as a result, false otherwise
     */

    public boolean add(int index, StringList s1) {
        checkRange(index, size(), 1);
        arrAdj(s1.size());
        for (int i = size() + s1.size() - 1; i > index + s1.size() - 1;i--) {
            strArr[i] = strArr[i - s1.size()];
        }
        for (int i = 0; i < s1.size();i++) {
            strArr[index + i] = s1.get(i);
        }
        return true;
    }

    /**
     *Inserts a given stringList to the end of the the array list.
     *@param s1 This is the string list to be added to the array list
     *@return boolean If the list is changed as a result
     *
     */

    public boolean add(StringList s1) {
        int length = size();
        for (int i = 0; i < s1.size();i++) {
            strArr[length + i] = s1.get(i);
        }
        return true;
    }

    /**
     *Clears the array of all elements.
     */

    public void clear() {
        strArr = new String[50];
    }

    /**
     *Creates a new string list without any duplicates.
     *@return StringList returns a new array without any duplicates
     */

    public StringList distinct() {
        StringList distinctList = new ArrayStringList();
        for (int i = 0; i < size();i++) {
            if (!distinctList.contains(strArr[i])) {
                distinctList.add(strArr[i]);
            }
        }
        return distinctList;
    }

    /**
     *Checks to see if the array is empty.
     *@return boolean Returns true if the array contains no elements
     */

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    /**
     *Removes the string a the specified position in the list.
     *@param  index This is the index of the string to be removed
     *@return String Returns a the string at the removed index
     */

    public String remove(int index) {
        checkRange(index, size(), 2);
        String removed = get(index);
        for (int i = index ; i < size() ;i++) {
            strArr[i] = strArr[i + 1];
        }
        return removed;
    }

    /**
     *Sets the string at a specified index to the specified string.
     *@param index This is the index that your setting the string to
     *@param s This is the string you are changing the index to
     *@return Returns the String that is replaced
     */

    public String set(int index, String s) {
        checkNullVoid(s);
        checkRange(index, size(), 2);
        String replaced = get(index);
        strArr[index] = s;
        return replaced;
    }

    /**
     *This returns an array that contains the string in the proper sequence.
     *@return String[] returns an array representation of the list
     */

    public String[] toArray() {
        String[] listArray = new String[size()];
        for (int i = 0; i < size();i++) {
            listArray[i] = strArr[i];
        }
        return listArray;
    }

    /**
     *Reverses all given elements in the given list.
     *@return Returns a StringList of the revered list
     */

    public StringList reverse() {
        StringList rev = new ArrayStringList();
        for (int i = size() - 1; i >= 0;i--) {
            rev.add(strArr[i]);
        }
        return rev;
    }

    /**
     *Builds a new stringlist consisting of the current list between two indices.
     *@param fromIndex This is the starting index
     *@param toIndex This is the ending index
     *@return StringList This is the returned list between the given indicies
     */

    public StringList splice(int fromIndex, int toIndex) {
        if ( fromIndex < 0 || toIndex > size() || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        checkRange(fromIndex, size(), 1);
        checkRange(toIndex, size(), 1);
        StringList splice = new ArrayStringList();
        for (int  i = fromIndex; i <= toIndex;i++) {
            splice.add(get(i));
        }
        return splice;
    }

}
