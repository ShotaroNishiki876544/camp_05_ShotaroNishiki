import com.sun.org.apache.xpath.internal.objects.XString;

import java.util.Random;
import java.util.Scanner;


public class kadai5 {
    public static void main(String[] args) {

        System.out.println("★相性診断★");
        System.out.println("ドラゴンクエストを知っていますか？");
        System.out.println("1 はい　　　2　いいえ  (1か2 半角で答えてね)");

        Scanner scanner = new Scanner(System.in);
        int answer1;
        answer1 = scanner.nextInt();

        System.out.println("ぼくと一緒にスライムと戦いませんか？");
        System.out.println("1 はい　　　2　いいえ ");//いいえでも戦うのは仕様

        int answer2;
        answer2 = scanner.nextInt();

        int turn = 1;
        String[] turnMessage={"ぼく「一緒に頑張ろう」","ぼく「どちらか一方が倒れたら負けだよ」","ぼく「ぼくは50%の確率でうだうだして何もしないよ」","「ここが踏ん張りどころ！」","ぼく「」"};
        System.out.println("--------------------------");
        System.out.println("スライム　が　あらわれた！");
        System.out.println("--------------------------");
        int yourHP=20, yourMP=6, bokuHP=15, bokuMP=0, bossHP=35;
        boolean victory=false;


      for(int i=0;i<5;i++) {
          System.out.println("--------------------------------------------------------");


          System.out.print("あなた HP: ");
          System.out.print(yourHP);
          System.out.print("/ MP: ");
          System.out.print(yourMP);
          System.out.print("        ");
          System.out.print("ぼく HP: ");
          System.out.print(bokuHP);
          System.out.print("/ MP: ");
          System.out.println(bokuMP);
          System.out.println("てき: スライム×1");

          System.out.println("--------------------------------------------------------");
          System.out.print("あと ");
          int countDown=6-turn;
          System.out.print(countDown);
          System.out.println("ターン以内にやっつけろ！ ");
          System.out.println(turnMessage[turn-1]);
          System.out.println("どうする？");
          System.out.println("1 たたかう　　　2　じゅもん   　3 にげる  ");
          int yourAction = 1;
          yourAction = scanner.nextInt();
          if (yourAction == 1) {
              System.out.print("あなたのこうげき！");
              int damage = damageCal(7);
              System.out.print("スライムに");
              System.out.print(damage);
              System.out.print("ダメージ!");
              bossHP -= damage;


          }else if(yourAction == 2){
              System.out.println("1 ホイミ(消費MP4)　　　2　メラ(消費MP2) ");
              int jumonSelect = scanner.nextInt();
                     if(jumonSelect==1){
                         System.out.println("どっちに使う？　1 あなた　　　2　ぼく ");
                         int target= scanner.nextInt();
                           if(target==1){
                               if(yourMP<4) {
                                   System.out.print("あなたはホイミをとなえた！MPが足りない！");
                               }else  {

                                   System.out.print("あなたはホイミをとなえた！あなたのキズがかいふくした！");
                                   yourHP = 20;
                                   yourMP -= 4;
                               }
                           }
                           else{
                               if(yourMP<4) {
                                   System.out.print("あなたはホイミをとなえた！MPが足りない！");
                               }else  {

                                   System.out.print("あなたはホイミをとなえた！ぼくのキズがかいふくした！");
                                   bokuHP=15;
                                   yourMP-=4;
                               }


                           }
                     }else{
                         if(yourMP<2) {
                             System.out.print("あなたはメラをとなえた！MPが足りない！");
                         }else  {

                             System.out.println("あなたはメラをとなえた！");
                             int damage = damageCal(12);
                             System.out.print("スライムに");
                             System.out.print(damage);
                             System.out.print("ダメージ!");
                             bossHP -= damage;
                             yourMP-=2;
                         }



                     }//end hoimi

            }//end jumon select
          else{
              System.out.println("あなたはにげだした！");
              break;
          }
          System.out.println("");

          Random r = new Random();
          int bokuAction = r.nextInt(2);
          if (bokuAction == 1) {
              System.out.print("ぼくのこうげき！");
              int damage = damageCal(6);
              System.out.print("スライムに");
              System.out.print(damage);
              System.out.println("ダメージ!");
              bossHP -= damage;
          } else {
              System.out.println("ぼくは うだうだ している！");
          }

          //スライムHP0
          if(bossHP<=0){//VICTORY
              System.out.println("スライムをやっつけた!");
              victory=true;
              break;
          }


          int bossAction = r.nextInt(2);
          if (bossAction == 1) {
              if(turn==2||turn==3) {
                  int damage = damageCal(10);
                  System.out.print("スライムはメラをとなえた！");
                  System.out.print("あなたに");
                  System.out.print(damage);
                  System.out.println("ダメージ!");
                  yourHP -= damage;
              }else{
                  int damage = damageCal(5);
                  System.out.print("スライムのこうげき！");
                  System.out.print("あなたに");
                  System.out.print(damage);
                  System.out.println("ダメージ!");
                  yourHP -= damage;
              }
          } else {

              System.out.print("スライムのこうげき！");
              int damage = damageCal(6);
              System.out.print("ぼくに");
              System.out.print(damage);

              System.out.println("ダメージ!");
              bokuHP -= damage;
          }

           if(yourHP<=0){//LOSE
               System.out.println("あなたはしんでしまった!");
               break;
           }
          if(bokuHP<=0){//LOSE
              System.out.println("ぼくはしんでしまった!");
              break;
          }

          turn+=1;
      }//end for

    //診断結果

        if(victory){
            System.out.println("************************************");
            System.out.println("相性は良いです!今度ごはんでもいかが？");
            System.out.println("************************************");
        }else{
            System.out.println("************************************");
            System.out.println("悲しいけど相性は悪いです");
            System.out.println("************************************");
        }





    }//end main


//***********************************************************
    public static int damageCal(int power) {

        Random r=new Random();
        double i = power + 1.5*r.nextGaussian();
        //ダメージ ガウス分布でバラツク
        i=Math.round(i);
        int j = (int)i;
        return j;
    }//end sub
//************************************************************

}