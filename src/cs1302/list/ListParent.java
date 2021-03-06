package cs1302.list;

import cs1302.listadt.StringList;

/**
 *This is an abstract parent class containing all the methods that can be abstract.
 *It contains methods that are implemented the same in both array and linked lists.
 */
abstract class ListParent implements StringList {

    /**
     *Returns true if the specified string is contained in the arrayList.
     *@param o This is the string the list is checked for
     *@return boolean Returns true if the lists contains the given String
     */

    public boolean contains(String o) {
        checkNullVoid(o);
        for (int i = 0; i < size();i++) {
            if (get(i).equals(o)) {
                return true;
            }
        }
        return false;
    }


    /**
     *Returns true if the specified string is contained in the arrayList.
     *@param o This is the string the list is checked for
     *@return boolean Returns true if the lists contains the given String regardless of case
     */

    public boolean containsIgnoreCase(String o) {
        checkNullVoid(o);
        o = o.toLowerCase();
        for (int i = 0; i < this.size();i++) {
            if (this.get(i).toLowerCase().equals(o)) {
                return true;
            }
        }
        return false;
    }


    /**
     *Returns true if any string inside the list contains the specified substring.
     *@param o This parameter is the substring that will be searched for inside the list
     *@return boolean Returns true if the any element in the list contains the specified string
     */

    public boolean containsSubstring(String o) {
        checkNullVoid(o);
        for (int i = 0; i < this.size();i++) {
            if (this.get(i).contains(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     *Returns the first index of a specified string.
     *
     *@param  s This the string that the user wants to find the index of
     *@return int returns the int value of the index or -1 if no index exists for String s
     */

    public int indexOf(String s) {
        checkNullVoid(s);
        for (int i = 0; i < this.size();i++) {
            if (this.get(i).equals(s)) {
                return i;
            }
        }
        return -1;
    }

    /**
     *Returns the first index of a specified string regardless of case.
     *
     *@param  s This the string that the user wants to find the index of
     *@return int returns the int value of the index or -1 if no index exists for String s
     */

    public int indexOfIgnoreCase(String s) {
        checkNullVoid(s);
        s = s.toLowerCase();
        for (int i = 0; i < this.size();i++) {
            if (this.get(i).toLowerCase().equals(s)) {
                return i;
            }
        }
        return -1;
    }

    /**
     *Checks to see if the array is empty.
     *@return boolean Returns true if the array contains no elements
     */

    public boolean isEmpty() {
        if (this.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     *Creates a new string containing all elements of the array in order.
     *@return String returns a string representation of the elements in order
     */

    public String makeString() {
        String allOfThem = "";
        for (int i = 0; i < this.size();i++) {
            allOfThem = allOfThem + this.get(i);
        }
        return allOfThem;
    }

    /**
     *Returns a string repersentation of the list seperated by a specified string.
     *@param  sep This is the string that seperates each element
     *@return String This is the final string repersentation of the list
     */

    public String makeString(String sep) {
        String allOfThem = "";
        for (int i = 0; i < this.size() - 1;i++) {
            allOfThem = allOfThem + this.get(i) + sep;
        }
        allOfThem = allOfThem + this.get(this.size() - 1);
        return allOfThem;
    }

    /**
     *Returns a String repesentation of the String with a specified start, sep, and end String.
     *@param start This is the starting string
     *@param sep This is the seperator string
     *@param end This is the ending string
     *@return String Returns a string repersentation of the list
     */

    public String makeString(String start, String sep, String end) {
        checkNullVoid(start);
        checkNullVoid(end);
        String allOfThem = "";
        for (int i = this.indexOf(start); i < this.indexOf(end);i++) {
            allOfThem = allOfThem + this.get(i) + sep;
        }
        allOfThem = allOfThem + this.get(indexOf(end));
        return allOfThem;
    }


    /**
     *checks to see if the specified string is null or empty.
     *@param  s this is the string to be passed in to be checked
     */

    public void checkNullVoid(String s) {
        if (s == null) {
            throw new NullPointerException("The specified string is null");
        }

        if (s.equals("")) {
            throw new IllegalArgumentException("The given string is empty");
        }
    }

    /**
     *Checks to see if the given index is out of bounds of the list.
     *@param i this is the specified index
     *@param range this is the given size
     *@param type  this is the type of check
     *@return boolean Returns false if an error is throw
     */

    public boolean checkRange(int i, int range, int type) {
        if (type == 1) {
            if (i < 0 || i > range) {
                throw new IndexOutOfBoundsException("The specified index is out of bounds");
            }
        }
        if (type == 2) {
            if (i < 0 || i >= range) {
                throw new IndexOutOfBoundsException("The specified index is out of bounds");
            }
        }
        return true;
    }

}
