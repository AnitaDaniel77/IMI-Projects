public class PrimitiveDataTypes {
    public static void main(String[] args) {

        // -128 to 127
        byte myByte = 12; // holds whole numbers -> just 8 bits (1s and 0s)
        byte myByteChar = 'C'; // can also hold characters

        // -32,768 to 32,767
        short myShort = 1234; // holds whole numbers, bigger range than byte

        // -2 billion to +2 billion (2,147,483,647)
        int myInt = 2837;

        // -9,223,372,036,854,775,808 to +9,223,372,036,854,775,808
        long myLong = 12323;

        // you can run into overflows if you use the wrong data type for the range you need

        // about 6 decimal digits of precision
        float myFloat = 6.3f;

        // about 15 decimal digits of precision
        double myDouble = 45.213434;

        // true or false
        boolean myBoolean = false;
        boolean moreThan1000 = (myInt > 1000);

        // one character
        char myChar = 'W';
    }
}