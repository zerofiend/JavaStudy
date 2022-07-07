package Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * 模拟斗地主发牌
 */
public class PokerCard {
    public static void main(String[] args) {
        String[] number = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        String[] color = {"♥","♦","♠","♣"};
        //  所以扑克牌的集合
        ArrayList<String> pokerCard = new ArrayList<>();
        for(String c : color) {
            for(String n : number) {
                pokerCard.add(c+n);
            }
        }
        pokerCard.add("大王");
        pokerCard.add("小王");
        // 模拟洗牌
        Collections.shuffle(pokerCard);
        //创建玩家对象
        TreeSet<String> player1 = new TreeSet<>(new OrderCard());
        TreeSet<String> player2 = new TreeSet<>(new OrderCard());
        TreeSet<String> player3 = new TreeSet<>(new OrderCard());
        TreeSet<String> underCard = new TreeSet<>(new OrderCard());
        //发牌
        for(int i=0;i<51;i++) {
            int turn = i%3;
            if(turn==0) {
                player1.add(pokerCard.get(i));
            } else if(turn==1) {
                player2.add(pokerCard.get(i));
            } else {
                player3.add(pokerCard.get(i));
            }
        }
        for(int i=51;i<54;i++) {
            underCard.add(pokerCard.get(i));
        }
        //展示牌
        System.out.println("玩家一号的牌："+player1);
        System.out.println("玩家二号的牌："+player2);
        System.out.println("玩家三号的牌："+player3);
        System.out.println("底牌："+underCard);

    }
}

class OrderCard implements Comparator<String> {
    String[] number = {"3","4","5","6","7","8","9","10","J","Q","K","A","2","小王","大王"};

    @Override
    public int compare(String o1, String o2) {
        String number1 = o1.substring(1);
        String color1 = o1.substring(0,1);
        String number2 = o2.substring(1);
        String color2 = o2.substring(0,1);
        int numO1 = 0,numO2 = 0;
        for(int i=0;i< number.length;i++) {
            String num = number[i];
            if(number1.equals(num)) {
                numO1 = i;
                break;
            }
        }
        for(int i=0;i< number.length;i++) {
            String num = number[i];
            if(number2.equals(num)) {
                numO2 = i;
                break;
            }
        }
        return numO2 - numO1 == 0 ? color1.compareTo(color2) : numO2 - numO1;
    }
}