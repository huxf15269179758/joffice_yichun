package com.hy.powerplatform.my_utils.utils;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2019/3/1.
 * 更具数字自动生成大写
 */

public class MoneyFormat {
    private static final char[] UNIT = {'亿', '拾', '佰', '仟', '万', '拾', '佰', '仟'};
    private static final char[] SPECK = {'角', '分', '厘'};
    private static final char[] CHAINIESFIGURE2={'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'};
    private static final String[] CN_NUMBER = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private static final String[] CN_UNIT  = { "分", "角", "圆","拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "兆", "拾", "佰", "仟", "顺" };

    //一些额外附加的字符
    private static final String CN_NEGATIVE = "负";
    private static final String CN_FULL = "整";
    private static final String CN_ZERO_FULL = "零圆整";
    private static final int PERCISION = 2; // 精度

    //整数部分的转换
    public static String toChineseCharI(String intString) throws NumberFormatException {
        StringBuffer ChineseCharI = new StringBuffer(intString);
        //倒序的数字,便于同单位合并
        String rintString = ChineseCharI.reverse().toString();
        //清空一下
        ChineseCharI.delete(0, ChineseCharI.length());
        //单位索引
        int unitIndex = 0;
        //数字长度
        int intStringLen = intString.length();
        //一位由字符转换的数字
        int intStringnumber = 0;
        //补0
        boolean addZero = false;
        boolean flagZero = false;
        for (int i = 0; i < intStringLen; i++) {
            //按单位长度循环索引
            unitIndex = i % UNIT.length;
            //异常检查
            if (!Character.isDigit(rintString.charAt(i))) {
                throw new NumberFormatException("数字中含有非法字符");
            }
            intStringnumber = Character.digit(rintString.charAt(i), 10);
            //如果当前位是0,开启补0继续循环直到不是0的位
            if (intStringnumber == 0) {
                addZero = true;
                if (i != 0 && i % 4 == 0) {
                    if (addZero && ChineseCharI.length() != 0) {
                        ChineseCharI.append(CHAINIESFIGURE2[0]);
                        addZero = false;
                    }
                    flagZero = true;
                    ChineseCharI.append(UNIT[unitIndex]);
                }
            } else {
                //若当前位不是第一位且补0开启
                if (addZero && ChineseCharI.length() != 0 && !flagZero) {
                    ChineseCharI.append(CHAINIESFIGURE2[0]);
                }
                flagZero = false;
                //插入单位
                //个位数后面不需 要单位
                if (i > 0) {
                    System.out.println(i);
                    ChineseCharI.append(UNIT[unitIndex]);
                }
                //插入大写数字
                ChineseCharI.append(CHAINIESFIGURE2[intStringnumber]);
                //补0关闭           
                addZero = false;
            }
        }
        if (ChineseCharI.length() == 0) {
            return "零";
        }
        return ChineseCharI.reverse().toString();
//
//        //当此 BigDecimal 的值为负、零或正时，返回 -1、0 或 1。
//        int signum = numOfMoney.signum();
//
//        //若输入为0，输出零圆整；
//        if(signum == 0) {
//            return CN_ZERO_FULL;
//        }
//
//        //对金额进行四舍五入转化为long类型的整数；先将数的小数点向右移两位，然后在四舍五入，取绝对值，最后将它转换为长整型；
//        long number = numOfMoney.movePointRight(PERCISION).setScale(0, BigDecimal.ROUND_HALF_UP).abs().longValue();
//        int numIndex = 0; //记录数字的个数；
//        boolean getZero = false;
///*
// * 思路：要先判断一下小数部分的具体情况；究其根本是因为：小数部分和整数部分在处理“0”的问题上略有不同；避免出现如图1所示的情况；
// */
//        //得到小数部分（小数点后两位）；
//        long scale = number % 100;
//        if(scale == 0) { //若小数部分为"00"时的情况；骚年，不要忘了在最后追加特殊字符：整
//            numIndex += 2;
//            getZero = true;
//            number /= 100;  // 从number去掉为0数；
//            sb.append(CN_FULL);
//        } else if(scale % 10 == 0){ //若小数部分为"*0"时的情况；
//            numIndex += 1;
//            getZero = true;
//            number /= 10;// 从number去掉为0数；
//        }
//
//        //排除上述两种小数部分的特殊情况，则对小数和整数的处理就是一样一样一样地了！
//        while(true) {
//            //循环结束条件；
//            if(number <= 0){
//                break;
//            }
//
//            //每次通过取余来得到最后一位数；
//            int numUnit = (int)(number % 10);
//            if(numUnit != 0){
//                sb.insert(0, CN_UNIT[numIndex]);  //先添加单位
//                sb.insert(0, CN_NUMBER[numUnit]); //在添加根据数字值来对应数组中的中文表述；
//                getZero = false; //表明当前数不是0；
//            }
//            else {
//                //意思是它的上一次的数不是零，那么打印出零；
//                if(!getZero) {
//                    sb.insert(0, CN_NUMBER[numUnit]);
//                }
//                //若角分位为零，那么打印零；
//                if(numIndex == 2) {
//                    if(number > 0) {
//                        sb.insert(0, CN_UNIT[numIndex]);
//                    }
//                } else if((numIndex - 2) % 4 == 0 && number % 1000 !=0 ) { //第一个条件是为了每隔4位，打印“圆，万，亿”；第二个条件是为了避免出现如图3的情况；
//                    sb.insert(0, CN_UNIT[numIndex]);
//                }
//                getZero = true; //将其置为true,那么如果下一位还是0,也不会再打印一遍'零'；避免出现图2的情况；
//            }
//
//            // 从number每次都去掉最后一个数
//            number  = number / 10;
//            numIndex++;
//        }
//
//        // 如果signum == -1，则说明输入的数字为负数，就在最前面追加特殊字符：负
//        if(signum == -1) {
//            sb.insert(0, CN_NEGATIVE);
//        }
//
//        return sb.toString();
    }

    //整数部分的转换
    public static String toChineseCharI1(BigDecimal numOfMoney) throws NumberFormatException {
        StringBuilder sb = new StringBuilder();
        int signum = numOfMoney.signum();
        //若输入为0，输出零圆整；
        if(signum == 0) {
            return CN_ZERO_FULL;
        }

        //对金额进行四舍五入转化为long类型的整数；先将数的小数点向右移两位，然后在四舍五入，取绝对值，最后将它转换为长整型；
        long number = numOfMoney.movePointRight(PERCISION).setScale(0, BigDecimal.ROUND_HALF_UP).abs().longValue();
        int numIndex = 0; //记录数字的个数；
        boolean getZero = false;
/*
 * 思路：要先判断一下小数部分的具体情况；究其根本是因为：小数部分和整数部分在处理“0”的问题上略有不同；避免出现如图1所示的情况；
 */
        //得到小数部分（小数点后两位）；
        long scale = number % 100;
        if(scale == 0) { //若小数部分为"00"时的情况；骚年，不要忘了在最后追加特殊字符：整
            numIndex += 2;
            getZero = true;
            number /= 100;  // 从number去掉为0数；
            sb.append(CN_FULL);
        } else if(scale % 10 == 0){ //若小数部分为"*0"时的情况；
            numIndex += 1;
            getZero = true;
            number /= 10;// 从number去掉为0数；
        }

        //排除上述两种小数部分的特殊情况，则对小数和整数的处理就是一样一样一样地了！
        while(true) {
            //循环结束条件；
            if(number <= 0){
                break;
            }

            //每次通过取余来得到最后一位数；
            int numUnit = (int)(number % 10);
            if(numUnit != 0){
                sb.insert(0, CN_UNIT[numIndex]);  //先添加单位
                sb.insert(0, CN_NUMBER[numUnit]); //在添加根据数字值来对应数组中的中文表述；
                getZero = false; //表明当前数不是0；
            }
            else {
                //意思是它的上一次的数不是零，那么打印出零；
                if(!getZero) {
                    sb.insert(0, CN_NUMBER[numUnit]);
                }
                //若角分位为零，那么打印零；
                if(numIndex == 2) {
                    if(number > 0) {
                        sb.insert(0, CN_UNIT[numIndex]);
                    }
                } else if((numIndex - 2) % 4 == 0 && number % 1000 !=0 ) { //第一个条件是为了每隔4位，打印“圆，万，亿”；第二个条件是为了避免出现如图3的情况；
                    sb.insert(0, CN_UNIT[numIndex]);
                }
                getZero = true; //将其置为true,那么如果下一位还是0,也不会再打印一遍'零'；避免出现图2的情况；
            }

            // 从number每次都去掉最后一个数
            number  = number / 10;
            numIndex++;
        }

        // 如果signum == -1，则说明输入的数字为负数，就在最前面追加特殊字符：负
        if(signum == -1) {
            sb.insert(0, CN_NEGATIVE);
        }
        return sb.toString();
    }


    private static String noSpeck(String intString) {
        //用来存放转换后的大写数字,因为是StringBuffer类型,所以顺便把没有转换
        //的数字倒序排列一下,省一个变量.
        StringBuffer ChineseCharI = new StringBuffer(intString);
        //倒序的数字,便于同单位合并
        String rintString = ChineseCharI.reverse().toString();
        //清空一下
        ChineseCharI.delete(0, ChineseCharI.length());
        //单位索引
        int unitIndex = 0;
        //数字长度
        int intStringLen = intString.length();
        //一位由字符转换的数字
        int intStringnumber = 0;
        //补0
        boolean addZero = false;
        boolean flagZero = false;
        for (int i = 0; i < intStringLen; i++) {
            //按单位长度循环索引
            unitIndex = i % UNIT.length;
            //异常检查
            if (!Character.isDigit(rintString.charAt(i))) {
                throw new NumberFormatException("数字中含有非法字符");
            }
            intStringnumber = Character.digit(rintString.charAt(i), 10);
            //如果当前位是0,开启补0继续循环直到不是0的位
            if (intStringnumber == 0) {
                addZero = true;
                if (i != 0 && i % 4 == 0) {
                    if (addZero && ChineseCharI.length() != 0) {
                        ChineseCharI.append(CHAINIESFIGURE2[0]);
                        addZero = false;
                    }
                    flagZero = true;
                    ChineseCharI.append(UNIT[unitIndex]);
                }
            } else {
                //若当前位不是第一位且补0开启
                if (addZero && ChineseCharI.length() != 0 && !flagZero) {
                    ChineseCharI.append(CHAINIESFIGURE2[0]);
                }
                flagZero = false;
                //插入单位
                //个位数后面不需 要单位
                if (i > 0) {
                    System.out.println(i);
                    ChineseCharI.append(UNIT[unitIndex]);
                }
                //插入大写数字
                ChineseCharI.append(CHAINIESFIGURE2[intStringnumber]);
                //补0关闭           
                addZero = false;
            }
        }
        if (ChineseCharI.length() == 0) {
            return "零";
        }
        return ChineseCharI.reverse().toString();
    }

    private static String haveSpeck(String intString) {
        String spStr[] = intString.split(".");
        String s = spStr[0];
        StringBuffer ChineseCharI = new StringBuffer(spStr[0]);
        //倒序的数字,便于同单位合并
        String rintString = ChineseCharI.reverse().toString();
        //清空一下
        ChineseCharI.delete(0, ChineseCharI.length());
        //单位索引
        int unitIndex = 0;
        //数字长度
        int intStringLen = spStr[0].length();
        //一位由字符转换的数字
        int intStringnumber = 0;
        //补0
        boolean addZero = false;
        boolean flagZero = false;
        for (int i = 0; i < intStringLen; i++) {
            //按单位长度循环索引
            unitIndex = i % UNIT.length;
            //异常检查
            if (!Character.isDigit(rintString.charAt(i))) {
                throw new NumberFormatException("数字中含有非法字符");
            }
            intStringnumber = Character.digit(rintString.charAt(i), 10);
            //如果当前位是0,开启补0继续循环直到不是0的位
            if (intStringnumber == 0) {
                addZero = true;
                if (i != 0 && i % 4 == 0) {
                    if (addZero && ChineseCharI.length() != 0) {
                        ChineseCharI.append(CHAINIESFIGURE2[0]);
                        addZero = false;
                    }
                    flagZero = true;
                    ChineseCharI.append(UNIT[unitIndex]);
                }
            } else {
                //若当前位不是第一位且补0开启
                if (addZero && ChineseCharI.length() != 0 && !flagZero) {
                    ChineseCharI.append(CHAINIESFIGURE2[0]);
                }
                flagZero = false;
                //插入单位
                //个位数后面不需 要单位
                if (i > 0) {
                    System.out.println(i);
                    ChineseCharI.append(UNIT[unitIndex]);
                }
                //插入大写数字
                ChineseCharI.append(CHAINIESFIGURE2[intStringnumber]);
                //补0关闭           
                addZero = false;
            }
        }
        if (ChineseCharI.length() == 0) {
            return "零";
        }


        StringBuffer ChineseCharI1 = new StringBuffer(spStr[1]);
        //倒序的数字,便于同单位合并
        String rintString1 = ChineseCharI1.reverse().toString();
        //清空一下
        ChineseCharI1.delete(0, ChineseCharI1.length());
        //单位索引
        int unitIndex1 = 0;
        //数字长度
        int intStringLen1 = spStr[1].length();
        //一位由字符转换的数字
        int intStringnumber1 = 0;
        //补0
        boolean addZero1 = false;
        boolean flagZero1 = false;
        for (int i = 0; i < intStringLen1; i++) {
            //按单位长度循环索引
            unitIndex1 = i % UNIT.length;
            //异常检查
            if (!Character.isDigit(rintString.charAt(i))) {
                throw new NumberFormatException("数字中含有非法字符");
            }
            intStringnumber1 = Character.digit(rintString.charAt(i), 10);
            //如果当前位是0,开启补0继续循环直到不是0的位
            if (intStringnumber1 == 0) {
                addZero1 = true;
                if (i != 0 && i % 4 == 0) {
                    if (addZero1 && ChineseCharI1.length() != 0) {
                        ChineseCharI1.append(CHAINIESFIGURE2[0]);
                        addZero1 = false;
                    }
                    flagZero1 = true;
                    ChineseCharI1.append(SPECK[unitIndex]);
                }
            } else {
                //若当前位不是第一位且补0开启
                if (addZero1 && ChineseCharI1.length() != 0 && !flagZero1) {
                    ChineseCharI1.append(CHAINIESFIGURE2[0]);
                }
                flagZero1 = false;
                //插入单位
                //个位数后面不需 要单位
                if (i > 0) {
                    System.out.println(i);
                    ChineseCharI1.append(SPECK[unitIndex]);
                }
                //插入大写数字
                ChineseCharI1.append(CHAINIESFIGURE2[intStringnumber]);
                //补0关闭           
                addZero1 = false;
            }
        }
        if (ChineseCharI1.length() == 0) {
            return "零";
        }
        return ChineseCharI.reverse().toString()+ChineseCharI1.reverse().toString();
    }
}
