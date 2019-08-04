package jp.co.systena.tigerscave.ListController_1;

public class ListForm {

  private int num1;         //商品番号1 注文数量
  private int num1_sum;     //商品番号1 注文合計金額
  private int num2;         //商品番号2 数量
  private int num2_sum;     //商品番号2 注文合計金額

  public int getNum1() {
    return this.num1;
  }

  public void setNum1(int num1) {

    //値が設定されているかコンソールに表示してみる(debug)
    //System.out.println("d");
    //System.out.printf("%d\n",this.num1);

    this.num1 = num1;

    //値が設定されているかコンソールに表示してみる(debug)
    //System.out.printf("%d\n",this.num1);
  }

  public int getNum1_sum() {
    return this.num1_sum;
  }

  public void setNum1_sum(int num1_sum) {

    //値が設定されているかコンソールに表示してみる(debug)
    //System.out.println("e");
    //System.out.printf("%d\n",this.num1_sum);

    this.num1_sum = num1_sum * this.num1;       //注文合計数*単価=注文合計金額

    //System.out.printf("%d\n",this.num1_sum);
  }

  public int getNum2() {
    return this.num2;
  }

  public void setNum2(int num2) {
    this.num2 = num2;
  }

  public int getNum2_sum() {
    return this.num2_sum;
  }

  public void setNum2_sum(int num2_sum) {
    this.num2_sum = num2_sum * this.num2;       //注文合計数*単価=注文合計金額
  }

}
