package project;

import java.util.Scanner;
import sun.font.StrikeCache;
import java.util.LinkedList;

public class BaseballGame {
    public static void main(String[] args) {
        int[] com = new int[3];
        int[] gamer = new int[3];
        int strike = -1;
        int ball = -1;
//        int cnt = 0;
        
        Com cm = new Com();
        User user = new User();
        Game game = new Game();
        
        cm.initNumberList();

        System.out.println("+++ 숫자 야구 게임 +++");
        
//        cm.selectNumber();
//        com = cm.get_Number();
        user.selectNumber();
        gamer = user.get_Number();
        System.out.println("user="+gamer[0]+","+gamer[1]+","+gamer[2]);
        
        com = cm.give_Number(strike, ball);
        System.out.println("com="+com[0]+","+com[1]+","+com[2]);

        game.jdgGame(gamer, com);
        
        strike = game.get_strike();
        ball = game.get_ball();
        
        
        
//        while(true) {
//            cnt++;

//            user.selectNumber();
//            gamer = user.get_Number();
            
//            if(game.jdgGame(com, gamer)) {
//                System.out.printf("%d번만에 이겼습니다.\n",cnt);
//                break;
//           }
//        }
    }
}

abstract class Play {
    protected int [] num = new int[3];
    
    abstract void selectNumber();
    
    public int[] get_Number() {
        return num;
    }
}

class Com extends Play {
    private LinkedList<int[]> list = new LinkedList<int[]>();
    private int index = 0;
    private int[] number = new int[3];
    
    private int[] chgDgt() {
        return number;
    }
    
    private void delChgDgt() {
        
    }

    private void delAlNum() {
        
    }
    
    private void delBal() {
        
    }
    
    private void delStk() {
        
    }
    
    public void selectNumber() {
        num[0] = (int)(Math.random() * 9) + 1;
        
        do num[1] = (int)(Math.random() * 9) + 1;
        while(num[0] == num[1]);
        
        do num[2] = (int)(Math.random() * 9) + 1;
        while(num[0] == num[2] && num[1] == num[2]);
    }
    
    public void initNumberList() {
      for(int i=1;i<=9;i++) {
         for(int j=1;j<=9;j++) {
            if(i==j) continue;      /* 첫번째와 두번째 번호 중복시 스킵 */
            for(int k=1;k<=9;k++) {
               if(j==k || i==k) continue;      /* 두번째와 세번째 또는 첫번째와 세번째 번호 중복시 스킵 */
               int[] element = new int[3];      /* 각 회전마다 배열 주소 새로 생성하기 위하여 선언 */ 
               element[0] = i;      /* 첫번째 번호 설정 */
               element[1] = j;      /* 두번째 번호 설정 */
               element[2] = k;      /* 세번째 번호 설정 */
               list.add(element);      /* 링키지리스트에 요소 삽입 */
            }
         }
      }
    }
    
    public int[] give_Number(int st, int bal) {
        if(st == -1 && bal == -1) {
            index = (int)(Math.random() * list.size());
            number = list.get(index);    
        }
        
        if(st == 0 && bal == 0) {
            delAlNum();
            index = (int)(Math.random() * list.size());
            number = list.get(index);    
        }
        
        if(st == 0 && bal == 1) {
            delBal();
            index = (int)(Math.random() * list.size());
            number = list.get(index);    
        }
        if(st == 0 && bal == 2) {
            delBal();
            index = (int)(Math.random() * list.size());
            number = list.get(index);    
        }
        if(st == 0 && bal == 3) {
            number = chgDgt();
//            index = (int)(Math.random() * list.size());
//            number = list.get(index);    
        }
        if(st == 1 && bal == 0) {
            delStk();
            index = (int)(Math.random() * list.size());
            number = list.get(index);    
        }
        if(st == 1 && bal == 1) {
            delChgDgt();
            index = (int)(Math.random() * list.size());
            number = list.get(index);    
        }
        if(st == 1 && bal == 2) {
            number = chgDgt();
        }
        if(st == 2 && bal == 0) {
            delStk();
            index = (int)(Math.random() * list.size());
            number = list.get(index);    
        }
        
        return number;
    }
}

class User extends Play {
    private int[] makeNum(int a){
        int[] gamer = new int[3];
        
        gamer[0] = a / 100;
        a %= 100;
        gamer[1] = a / 10;
        gamer[2] = a % 10;

        return gamer;
    }
    
    public void selectNumber() {
        Scanner sc = new Scanner(System.in);
        int input = 0;
        System.out.print("1~9까지의 숫자 중 하나씩 선택해 3자리 숫자를 입력하세요(중복불가) >");
        input = sc.nextInt();
        
        num = makeNum(input);
    }
}

class Game {
    private int st;
    private int ball;
    
    public boolean jdgGame(int[] a, int[] b) {
        st = 0;
        ball = 0;
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
//                System.out.println("com="+a[0]+a[1]+a[2]+", user="+b[0]+b[1]+b[2]+", i="+i+", j="+j);
                if(a[i]==b[j]){
                    if(i == j) st += 1;
                    else ball += 1;
                }
            }
        }

        System.out.printf("%d 스트라이크 %d 볼\n", st, ball);
        
        if(st == 3) return true;
        
        return false;
    }
    
    public int get_strike() {
        return st;
    }
    
    public int get_ball() {
        return ball;
    }
}