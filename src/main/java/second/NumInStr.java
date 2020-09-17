package second;

/**
 * 序列中某一位的数字
 * 数字以0123456789101112...的格式序列化成一个字符序列
 * 写一个函数 求任意第n位对应的数字
 *
 * 思路分析：
 *  一位数  0-9 前10位
 *  两位数 10-99 180位 =90*2
 *  三位数 1000-999 900*3 =2700位
 */
public class NumInStr {
    public static void main(String[] args) {
        int digitAtIndex = getDigitAtIndex(13);
        System.out.println(digitAtIndex);
    }


    public static  int getDigitAtIndex(int index) {
        if (index < 0)
            return -1;
        int place = 1;  // 1 表示个位，2 表示 十位...
        while (true) {
            int amount = countIntegers(place);
            int totalAmount = amount * place;
            if (index < totalAmount)
                return getDigitAtIndex(index, place);
            index -= totalAmount;
            place++;
        }
    }
    /**
     * 输入m位数字 总共有多少个
     * @param digits
     * @return
     */
    private static int countIntegers(int digits){
        if(digits ==1){
            return  10;
        }
        return (int)Math.pow(10,digits-1)*9;
    }

    /**
     * m位数字起始的数字
     * @param digits
     * @return
     */
    private static  int startNum(int digits){

        if(digits ==1){
            return 0;
        }
        return (int)Math.pow(10,digits-1);
    }

    /**
     * 在digits个数字中 第index的位数
     * @param index
     * @param digits
     * @return
     */
    private  static  int  getDigitAtIndex(int index,int digits){

        int beginNumber = startNum(digits);
        int shiftNumber = index / digits;
        String number = (beginNumber + shiftNumber) + "";
        int count = index % digits;
        return number.charAt(count) - '0';
    }
}
