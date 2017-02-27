import java.util.HashMap;

public class TextDollarChallenge {

    public static void main(String abc[]){
        AmericalNumberWorderStrategy test = new AmericalNumberWorderStrategy();
        System.out.print((test.processMe("15220")) + "Dollars");
    }
}


final class Split{
    int high;
    int low;

    int highPosition;
    int lowPosition;

    Split(int value){
        if(value > 3){
            this.high = value - 3;
            this.low = 3;
        }else {
            switch (value){
                case 0 : this.low = 0; this.high = 0; break;
                case 1 : this.low = 1; this.high = 0; break;
                case 2 : this.low = 1; this.high = 1; break;
                case 3 : this.low = 2; this.high = 1; break;
            }
        }

        switch (high + low){
            case 1 : highPosition = 0; lowPosition = 1; break;
            case 2 : highPosition = 0; lowPosition = 2 ; break;
            case 3 : highPosition = 3; lowPosition = 2 ; break;
            case 4 : highPosition = 4; lowPosition = 3; break;
            case 5 : highPosition = 4; lowPosition = 3; break;
            case 6 : highPosition = 4; lowPosition = 3; break;
            case 7 : highPosition = 5; lowPosition = 4; break;

        }
    }

    @Override
    public String toString() {
        return "("+ this.high + " ,"+ this.low + ")";
    }
}

interface NumberWorderStrategy{
    String processMe(int number);
    String processMe(String number);
    String processMe(int[] number);
}

class AmericalNumberWorderStrategy implements NumberWorderStrategy {

    private final String[] base = {
            "",
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine"
    };

    private final String[] postionString = {
            "",
            "",
            "",
            "Hundred",
            "Thousand",
            "Thousand",
            "",
            ""

    };

    private final HashMap<String, String> twoDigit = new HashMap<String, String>();
    {
        twoDigit.put("10", "Ten");
        twoDigit.put("11", "Eleven");
        twoDigit.put("12", "Twelve");
        twoDigit.put("13", "Thirteen");
        twoDigit.put("14", "Fourteen");
        twoDigit.put("15", "Fifteen");
        twoDigit.put("16", "Sixteen");
        twoDigit.put("17", "Seventeen");
        twoDigit.put("18", "Eighteen");
        twoDigit.put("19", "Nineteen");
    }

    private final String[] tySuffix = {
            base[0],
            "",
            "Twenty",
            "Thirty",
            "Fourty",
            "Fifty",
            "Sixty",
            "Seventy",
            "Eighty",
            "Ninety"
    };

    private Split getSplit(int length){
        return new Split(length);
    }

    @Override
    public String processMe(int number) {
        return null;
    }

    @Override
    public String processMe(int[] number) {
        return null;
    }

    private String getStringForTwoDigitNumber(String number){
        //todo : implement such that 63 - Sixty three and 12 - Twelve
        if(twoDigit.containsKey(number)){
            return twoDigit.get(number);
        }else{
            return "Twenty";
        }
    }

    private String getStringForOneDigitNumber(String number){
        return base[Integer.parseInt(number)];
    }

    private String getPositionString(int position){
        return postionString[position];
    }

    public String processMe(String number) {
        int length = number.length();
        Split s = this.getSplit(length);
        if(s.high == 0 && s.low == 1){
            String baseReturn = getStringForOneDigitNumber(number) + "" + getPositionString(s.lowPosition);
            return baseReturn;
        }
        else if(s.high == 1 && s.low == 1){
            String base = getStringForTwoDigitNumber(number) + "" + getPositionString(s.lowPosition);
            return base;
        }
        else
            return processMe(number.substring(0, s.high)) + "" + getPositionString(s.highPosition) + "" + processMe(number.substring(s.high, s.high + s.low)) ;
    }
}
